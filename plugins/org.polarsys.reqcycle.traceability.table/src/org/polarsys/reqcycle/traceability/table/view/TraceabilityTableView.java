/*******************************************************************************
 * Copyright (c) 2013, 2014 AtoS and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *  Olivier Melois (AtoS) - initial API and implementation and/or initial documentation
 *  Raphael Faudou (Samares Engineering) : Fixed performance issue
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.table.view;

import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.PartSite;
import org.eclipse.ui.part.ViewPart;
import org.polarsys.reqcycle.traceability.engine.ITraceabilityEngine;
import org.polarsys.reqcycle.traceability.model.Link;
import org.polarsys.reqcycle.traceability.model.TType;
import org.polarsys.reqcycle.traceability.storage.ITraceabilityStorageTopics;
import org.polarsys.reqcycle.traceability.table.filters.TableFilter;
import org.polarsys.reqcycle.traceability.table.menus.actions.AllLinksAction;
import org.polarsys.reqcycle.traceability.table.menus.actions.ExplicitLinksAction;
import org.polarsys.reqcycle.traceability.table.model.TableController;
import org.polarsys.reqcycle.traceability.table.providers.LinkLabelProvider;
import org.polarsys.reqcycle.traceability.table.providers.TraceabilityLazyContentProvider;
import org.polarsys.reqcycle.traceability.types.ui.IStylePredicateProvider;
import org.polarsys.reqcycle.traceability.ui.TraceabilityUtils;
import org.polarsys.reqcycle.traceability.ui.services.ILocateService;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@SuppressWarnings("restriction")
public class TraceabilityTableView extends ViewPart {

	private static final Logger LOG = Logger.getLogger(TraceabilityTableView.class.getName());
	private static final String VIEW_ID = "org.polarsys.reqcycle.traceability.table.partdescriptor.traceability.table"; //$NON-NLS-1$

	@Inject
	protected ITraceabilityEngine engine;

	@Inject
	protected IStylePredicateProvider styleProvider;

	protected TableViewer viewer;

	protected TableController tableControl;

	protected Text filterText;

	protected Refresher refresher = new Refresher();

	private ILocateService locateService = ZigguratInject.make(ILocateService.class);
	
	private IReachableManager managerService = ZigguratInject.make(IReachableManager.class);

	public TraceabilityTableView() {
		ZigguratInject.inject(this);
	}

	@Inject
	@Optional
	void reactOnNewTraceaLinkCreation(@UIEventTopic(ITraceabilityStorageTopics.NEW) Reachable object) {
		refresher.scheduleRefresh();
	}

	@Inject
	@Optional
	void reactOnTraceaLinkRemoval(@UIEventTopic(ITraceabilityStorageTopics.REMOVE) Reachable object) {
		refresher.scheduleRefresh();
	}

	@Override
	public void createPartControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		filterText = new Text(composite, SWT.BORDER);
		filterText.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));

		viewer = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER | SWT.VIRTUAL);
		viewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		TraceabilityLazyContentProvider<Link> provider = TraceabilityLazyContentProvider.create(Link.class, viewer);
		viewer.setContentProvider(provider);

		// Creating the control.
		tableControl = new TableController(viewer);
		ZigguratInject.inject(tableControl);

		// special settings for the lazy Content provider
		viewer.setUseHashlookup(true);

		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// Creating the columns.
		createModel();

		hookMenu(table);
		hookActions();
		hookListeners();

		// Setting the input.
		tableControl.displayAllLinks();
	}

	private void hookListeners() {
		TableFilter filter = new TableFilter();
		viewer.addFilter(filter);
		filterText.addModifyListener(new ModifyListenerImplementation(filter));
		;
	}

	private void hookMenu(final Table table) {
		MenuManager popupMenu = new MenuManager(null, VIEW_ID);
		Menu menu = popupMenu.createContextMenu(table);
		table.setMenu(menu);
		getSite().setSelectionProvider(viewer);
		getSite().registerContextMenu(popupMenu, viewer);
	}

	private void createModel() {
		TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		addDoubleClickListener(viewerColumn);
		createTableViewerColumn(viewerColumn, "Link type", 50, 0).setLabelProvider(new LinkLabelProvider(styleProvider) {

			@Override
			public String getText(Object element) {
				if (element instanceof Link) {
					TType kind = ((Link) element).getKind();
					StringBuilder builder = new StringBuilder(kind.getLabel());
					TType superKind = kind.getSuperType();
					if (superKind != null) {
						builder.append(String.format(" [Transverse : %s]", superKind.getLabel()));
					}
					return builder.toString();
				}
				return super.getText(element);
			}
		});
		viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		createTableViewerColumn(viewerColumn, "Upstream", 200, 1).setLabelProvider(new LinkLabelProvider(styleProvider) {

			@Override
			public String getText(Object element) {
				if (element instanceof Link) {
					Set<Reachable> set = ((Link) element).getSources();
					if (set != null && set.size() == 1) {
						Reachable reachable = Iterables.get(set, 0);
						return TraceabilityUtils.getText(reachable);
					}
				}
				return super.getText(element);
			}
		});
		viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		createTableViewerColumn(viewerColumn, "Downstream", 200, 2).setLabelProvider(new LinkLabelProvider(styleProvider) {

			@Override
			public String getText(Object element) {
				if (element instanceof Link) {
					Set<Reachable> set = ((Link) element).getTargets();
					if (set != null && set.size() == 1) {
						Reachable reachable = Iterables.get(set, 0);
						return TraceabilityUtils.getText(reachable);
					}
				}
				return super.getText(element);
			}
		});
		
	}

	private void addDoubleClickListener(TableViewerColumn viewerColumn) {
		final List<Integer> index = Lists.newArrayList();
		viewerColumn.getViewer().addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) event.getSelection();

					if (!index.isEmpty()) {
						Object firstElement = selection.getFirstElement();
						if (firstElement instanceof Link) {
							switch (index.get(0)) {
							case 0:
								Reachable id = ((Link) firstElement).getId();
								index.clear();
								break;
							case 1:
								setSelection(((Link) firstElement).getSources());
								index.clear();
								break;
							case 2:
								setSelection(((Link) firstElement).getTargets());
								index.clear();
								break;
							default:
								break;
							}
						}
					}
				}
			}

			
		});
		viewer.getTable().addListener(SWT.MouseDown, new Listener() {
			@Override
			public void handleEvent(Event event) {
				Point pt = new Point(event.x, event.y);
				TableItem item = viewer.getTable().getItem(pt);
				if (item == null)
					return;
				for (int i = 0; i < 3; i++) {
					Rectangle rect = item.getBounds(i);
					if (rect.contains(pt)) {
						index.clear();
						index.add(i);
					}
				}
			}
		});

	}

	private void setSelection(Set<Reachable> reachables) {
		List<Reachable> reqsToSelect = Lists.newArrayList();
		List<Reachable> otherObjectsToSelect = Lists.newArrayList();
		for (Reachable source : reachables) {
			if (source.getPath().endsWith("reqcycle")) {
				reqsToSelect.add(source);
			} else {
				otherObjectsToSelect.add(source);
			}
		}
		if (!reqsToSelect.isEmpty()) {
			try {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.polarsys.reqcycle.repository.ui.views.requirements");
			} catch (PartInitException e) {
				e.printStackTrace();
			}

			IViewReference viewRef = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findViewReference("org.polarsys.reqcycle.repository.ui.views.requirements");
			if (viewRef != null) {
				IWorkbenchPart view = viewRef.getPart(false);
				if (view != null) {
					Viewer reqViewer = (Viewer) view.getAdapter(Viewer.class);
					reqViewer.setSelection(new StructuredSelection(reqsToSelect), true);
				}
			}
		}
		if(!otherObjectsToSelect.isEmpty()){
			for (Reachable obj : otherObjectsToSelect) {
				try {
					locateService.open(obj);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void hookActions() {
		IActionBars bars = ((PartSite) getSite()).getActionBars();
		ExplicitLinksAction explicitAction = new ExplicitLinksAction(viewer, tableControl);
		AllLinksAction implicitAction = new AllLinksAction(tableControl);
		ZigguratInject.inject(explicitAction, implicitAction);
		RefreshAction refreshViewAction = new RefreshAction(refresher);
		bars.getToolBarManager().add(explicitAction);
		bars.getToolBarManager().add(implicitAction);
		bars.getToolBarManager().add(refreshViewAction);
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	private TableViewerColumn createTableViewerColumn(TableViewerColumn viewerColumn, String title, int bound, final int colNumber) {
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(false);
		return viewerColumn;
	}

	/**
	 * Search is performed after a delay (avoids computation every time the user presses a key)
	 * 
	 * @author omelois
	 */
	private final class ModifyListenerImplementation implements ModifyListener {

		Timer t = new Timer();

		TimerTask tt;

		TableFilter filter;

		ModifyListenerImplementation(TableFilter filter) {
			this.filter = filter;
		}

		@Override
		public void modifyText(ModifyEvent e) {
			if (tt != null) {
				tt.cancel(); // This cancels the timer as well.
				t.purge();
				tt = null;
			}

			tt = new TimerTask() {

				// The timer thread will yield to the display thread to apply the filter.
				@Override
				public void run() {
					Display.getDefault().syncExec(new Runnable() {

						public void run() {
							String searchText = TraceabilityTableView.this.filterText.getText();
							ModifyListenerImplementation.this.filter.setSearchText(searchText);
							TraceabilityTableView.this.tableControl.refreshViewerVisuals();
						}
					});
				}
			};

			t.schedule(tt, 800);
		}

	}

	private final class Refresher {
		Timer t = new Timer();
		TimerTask tt;

		public void scheduleRefresh() {
			// LOG.entering("traceabilityTable","schedule refresh");
			if (tt != null) {
				tt.cancel(); // This cancels the timer as well.
				t.purge();
				tt = null;
			}
			tt = new TimerTask() {

				// The timer thread will yield to the display thread to apply the filter.
				@Override
				public void run() {

					IWorkbenchPartSite site = getSite();
					if (site != null) {
						Shell shell = site.getShell();
						if (shell != null) {
							Display display = shell.getDisplay();

							display.syncExec(new Runnable() {
								public void run() {
									tableControl.refreshViewerData();
								}
							});
						} // if shell
					} // if site

				}
			};

			t.schedule(tt, 1500);
			// LOG.exiting("traceabilityTable","schedule refresh");

		}

	}

	private final class RefreshAction extends Action {

		private Refresher refresher;

		public RefreshAction(Refresher refresher) {
			this.refresher = refresher;
			setText("Refresh");
			setToolTipText("Refresh Links list");
		}

		@Override
		public void run() {
			this.refresher.scheduleRefresh();
		}
	}

	public TableController getController() {
		return this.tableControl;
	}

}
