/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.ui.views;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.wb.swt.ResourceManager;
import org.polarsys.reqcycle.commands.CreateRelationCommand;
import org.polarsys.reqcycle.commands.utils.RelationCommandUtils;
import org.polarsys.reqcycle.commands.utils.RelationCreationDescriptor;
import org.polarsys.reqcycle.traceability.types.configuration.preferences.dialogs.IconRegistry;
import org.polarsys.reqcycle.traceability.types.configuration.typeconfiguration.provider.TypeconfigurationItemProviderAdapterFactory;
import org.polarsys.reqcycle.traceability.ui.TraceabilityUtils;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.model.IObjectHandler;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.model.ReachableObject;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class TraceabilityCreator extends ViewPart implements ISelectionListener {

	public static final String ID = "org.polarsys.reqcycle.traceability.ui.views.TraceabilityCreator"; //$NON-NLS-1$
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text sourceText;
	private Text targetText;

	@Inject
	private IReachableManager manager;

	private Reachable source;
	private Reachable target;

	private ISelection selection;

	public TraceabilityCreator() {
		ZigguratInject.inject(this);
	}

	@Override
	public void dispose() {
		super.dispose();
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().removeSelectionListener(this);
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().addSelectionListener(this);

		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));

		Form frmCreation = formToolkit.createForm(container);
		formToolkit.paintBordersFor(frmCreation);
		frmCreation.setText("Creata a traceability link");
		frmCreation.getBody().setLayout(new FillLayout(SWT.HORIZONTAL));

		Section sctnNewSection = formToolkit.createSection(frmCreation.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Source and Target");

		Composite composite = new Composite(sctnNewSection, SWT.NONE);
		formToolkit.adapt(composite);
		formToolkit.paintBordersFor(composite);
		sctnNewSection.setClient(composite);
		composite.setLayout(new GridLayout(3, false));

		Label lblSource = new Label(composite, SWT.NONE);
		lblSource.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		formToolkit.adapt(lblSource, true, true);
		lblSource.setText("Source :");

		sourceText = new Text(composite, SWT.BORDER);
		sourceText.setEditable(false);
		sourceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		formToolkit.adapt(sourceText, true, true);

		Button btnSetSource = new Button(composite, SWT.NONE);
		btnSetSource.addSelectionListener(new AddSelectionListener(new SourceSetter()));
		btnSetSource.setImage(ResourceManager.getPluginImage("org.polarsys.reqcycle.traceability.ui", "icons/add_obj.gif"));
		formToolkit.adapt(btnSetSource, true, true);

		Label lblTarget = new Label(composite, SWT.NONE);
		lblTarget.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		formToolkit.adapt(lblTarget, true, true);
		lblTarget.setText("Target :");

		targetText = new Text(composite, SWT.BORDER);
		targetText.setEditable(false);
		targetText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		formToolkit.adapt(targetText, true, true);

		Button btnSetTarget = new Button(composite, SWT.NONE);
		btnSetTarget.addSelectionListener(new AddSelectionListener(new TargetSetter()));
		btnSetTarget.setImage(ResourceManager.getPluginImage("org.polarsys.reqcycle.traceability.ui", "icons/add_obj.gif"));
		formToolkit.adapt(btnSetTarget, true, true);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Button btnCreateLink = formToolkit.createButton(composite, "", SWT.NONE);
		btnCreateLink.setImage(ResourceManager.getPluginImage("org.polarsys.reqcycle.traceability.ui", "icons/locate.gif"));
		btnCreateLink.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if ((target != null) && (source != null)) {
					createTraceability();
				}
			}
		});

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	private class AddSelectionListener implements SelectionListener {

		private ISetter setter;

		public AddSelectionListener(ISetter s) {
			this.setter = s;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			handleCurrentSelection(setter);
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			widgetSelected(e);
		}

	}

	private void handleCurrentSelection(ISetter setter) {
		if (selection != null && !selection.isEmpty()) {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structured = (IStructuredSelection) selection;
				for (@SuppressWarnings("unchecked")
				Iterator<Object> i = structured.iterator(); i.hasNext();) {
					Object o = i.next();
					if (o == null) {
						setter.set(null);
					} else {
						setter.set(o);
					}

				}
			}
		}
	}

	private interface ISetter {
		void set(Object o);
	}

	private class TargetSetter implements ISetter {

		public void set(Object o) {
			if (o == null) {
				targetText.setText("invalid selection");
				target = null;
			} else {
				Reachable r = getReachable(o);
				if (r != null) {
					target = r;
					targetText.setText(TraceabilityUtils.getText(r));
				} else {
					targetText.setText("invalid selection");
					target = null;
				}
			}

		}
	}

	private class SourceSetter implements ISetter {

		public void set(Object o) {
			if (o == null) {
				sourceText.setText("invalid selection");
				source = null;
			} else {
				Reachable r = getReachable(o);
				if (r != null) {
					source = r;
					sourceText.setText(TraceabilityUtils.getText(r));
				} else {
					sourceText.setText("invalid selection");
					source = null;
				}
			}
		}
	}

	public Reachable getReachable(Object o) {
		try {
			IObjectHandler handler = manager.getHandlerFromObject(o);
			ReachableObject reachableObject = handler.getFromObject(o);
			if (reachableObject != null) {
				return reachableObject.getReachable();
			}
		} catch (IReachableHandlerException e) {
		}
		return null;
	}

	protected void createTraceability() {
		final Map<RelationCreationDescriptor, CreateRelationCommand> allCommands = RelationCommandUtils.getAllRelationCommands(Collections.singletonList(source), Collections.singletonList(target));

		Iterable<RelationCreationDescriptor> upstreamToDownstreams = Iterables.filter(allCommands.keySet(), new Predicate<RelationCreationDescriptor>() {

			public boolean apply(RelationCreationDescriptor desc) {
				return desc.isUpstreamToDownstream();
			}
		});
		Iterable<RelationCreationDescriptor> downstreamToUpstream = Iterables.filter(allCommands.keySet(), new Predicate<RelationCreationDescriptor>() {

			public boolean apply(RelationCreationDescriptor desc) {
				return desc.isDownstreamToUpstream();
			}
		});

		Menu menu = new Menu(Display.getDefault().getActiveShell());
		Iterator<RelationCreationDescriptor> iteratorUD = upstreamToDownstreams.iterator();
		if (iteratorUD.hasNext()) {
			createMenu(menu, "Up To Down", iteratorUD, allCommands);
		}
		Iterator<RelationCreationDescriptor> iteratorDU = downstreamToUpstream.iterator();
		if (iteratorDU.hasNext()) {
			createMenu(menu, "Down To Up", iteratorDU, allCommands);
		}
		menu.setVisible(true);
	}

	private void createMenu(Menu menu, String string, Iterator<RelationCreationDescriptor> iteratorUD, Map<RelationCreationDescriptor, CreateRelationCommand> allCommands) {
		MenuItem newItem = new MenuItem(menu, SWT.CASCADE);
		Menu newMenu = new Menu(menu);
		newItem.setMenu(newMenu);
		newItem.setText(string);
		for (; iteratorUD.hasNext();) {
			RelationCreationDescriptor desc = iteratorUD.next();
			MenuItem item = new MenuItem(newMenu, SWT.NONE);
			final CreateRelationCommand command = allCommands.get(desc);
			item.setText(desc.getLabel());
			if ((desc.getRelation().getIcon() != null) && (desc.getRelation().getIcon().length() > 0)) {
				item.setImage(IconRegistry.getImage(desc.getRelation().getIcon()));
			} else {
				item.setImage(new AdapterFactoryLabelProvider(new TypeconfigurationItemProviderAdapterFactory()).getImage(desc.getRelation()));
			}
			item.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					command.execute();
				}

			});
		}
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (part != this && (!(part instanceof PropertySheet))) {
			this.selection = selection;
		}
	}
}
