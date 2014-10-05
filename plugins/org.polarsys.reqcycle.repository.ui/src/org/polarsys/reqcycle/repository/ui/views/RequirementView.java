package org.polarsys.reqcycle.repository.ui.views;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.ICommonViewerMapper;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.repository.connector.update.rs.IUpdateListener;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.ui.navigator.NavigatorRoot;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.model.IObjectHandler;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.model.ReachableObject;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Maps;

public class RequirementView extends CommonNavigator implements EventHandler {

	/** View ID */
	public static final String VIEW_ID = "org.polarsys.reqcycle.repository.ui.views.requirements";

	protected Collection<IPredicate> predicates;

	NavigatorRoot root = new NavigatorRoot();

	private AdapterFactoryEditingDomain readOnlyEditingDomain;

	@Inject
	IEventBroker broker;

	public RequirementView() {
		super();
		ZigguratInject.inject(this);
		broker.subscribe(IUpdateListener.LISTENER, this);
	}

	IReachableManager manager = ZigguratInject.make(IReachableManager.class);

	@Override
	protected IAdaptable getInitialInput() {
		this.getCommonViewer().refresh();
		return root;
	}

	@Override
	protected CommonViewer createCommonViewer(Composite aParent) {
		CommonViewer viewer = super.createCommonViewer(aParent);
		getSite().setSelectionProvider(viewer);
		viewer.setUseHashlookup(true);
		ReachableMapper mapper = new ReachableMapper();
		ZigguratInject.inject(mapper);
		viewer.setMapper(mapper);
		return viewer;
	}

	@Override
	protected CommonViewer createCommonViewerObject(Composite aParent) {
		return new CommonViewer(getViewSite().getId(), aParent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL) {
			@Override
			protected void mapElement(Object element, Widget item) {
				super.mapElement(element, item);
				if (!(element instanceof Reachable)) {
					try {
						if (getReachable(element) != null) {
							super.mapElement(getReachable(element), item);
						}
					} catch (IReachableHandlerException e) {
						e.printStackTrace();
					}
				}
			}

			@Override
			protected void unmapElement(Object element, Widget item) {
				super.unmapElement(element, item);
				if (!(element instanceof Reachable)) {
					try {
						if (getReachable(element) != null) {
							super.unmapElement(getReachable(element), item);
						}
					} catch (IReachableHandlerException e) {
						e.printStackTrace();
					}
				}
			}
		};
	}

	@Override
	public Object getAdapter(Class adapter) {
		if (IPropertySheetPage.class.isAssignableFrom(adapter)) {
			return getPropertySheetPage();
		}
		if (Viewer.class.isAssignableFrom(adapter)) {
			return getCommonViewer();
		}
		return super.getAdapter(adapter);
	}

	public IPropertySheetPage getPropertySheetPage() {
		ExtendedPropertySheetPage propertySheetPage = new ExtendedPropertySheetPage(readOnlyEditingDomain, ExtendedPropertySheetPage.Decoration.NONE, null);
		propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(new ReflectiveItemProviderAdapterFactory()));
		return propertySheetPage;
	}

	/**
	 * @param sources
	 * @param predicates
	 *            - The collection of predicates to use for filtering the same input.
	 */
	public static void openNewRequirementView(final Collection<RequirementSource> sources, final Collection<IPredicate> predicates) {
		if (!sources.isEmpty()) {
			IViewPart view = createNewView();
			if (view == null) {
				return;
			}

			RequirementView reqView = (RequirementView) view;
			reqView.setPredicates(predicates);
			reqView.setSources(sources);
		}
	}

	public void setSources(Collection<RequirementSource> sources) {
		if (readOnlyEditingDomain == null && !sources.isEmpty()) {
			ResourceSet rs = sources.iterator().next().eResource().getResourceSet();
			if (readOnlyEditingDomain == null) {
				readOnlyEditingDomain = new AdapterFactoryEditingDomain(new ReflectiveItemProviderAdapterFactory(), new BasicCommandStack(), rs) {

					@Override
					public boolean isReadOnly(Resource resource) {
						return true;
					}
				};
				rs.eAdapters().add(new AdapterFactoryEditingDomain.EditingDomainProvider(readOnlyEditingDomain));
			}
		}
		root.setSources(sources);

		this.getCommonViewer().refresh();
	}

	public Collection<RequirementSource> getSources() {
		return root.getSources();
	}

	public void setPredicates(Collection<IPredicate> predicates) {
		root.setPredicates(predicates);
	}

	public void setScopes(Collection<Scope> scopes) {
		root.setScopes(scopes);
	}

	public void setViewFiltered(Boolean filtered) {
		root.setViewFiltered(filtered);
	}

	public void setViewOrdered(Boolean ordered) {
		root.setViewOrdered(ordered);
	}

	public void setViewByScopes(Boolean scope) {
		root.setViewByScopes(scope);
	}

	protected Reachable getReachable(Object element) throws IReachableHandlerException {
		return manager.getHandlerFromObject(element).getFromObject(element).getReachable(element);
	}

	public static IViewPart createNewView() {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		int nbView = 0;
		for (IViewReference ref : activePage.getViewReferences()) {
			if (ref.getId().startsWith(VIEW_ID)) {
				nbView++;
			}
		}
		// increment to have the second view named #2
		nbView++;
		IViewPart view = null;
		try {
			view = activePage.showView(VIEW_ID, VIEW_ID + "_" + nbView, IWorkbenchPage.VIEW_ACTIVATE);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return view;

	}

	private class ReachableMapper implements ICommonViewerMapper {

		Map<Reachable, Item> items = Maps.newHashMap();

		@Override
		public void removeFromMap(Object element, Item item) {
			Reachable r = null;
			if (element instanceof Reachable) {
				r = (Reachable) element;
			} else {
				try {
					IObjectHandler handlerFromObject = manager.getHandlerFromObject(element);
					if (handlerFromObject != null) {
						ReachableObject fromObject = handlerFromObject.getFromObject(element);
						if (fromObject != null) {
							r = fromObject.getReachable(element);
						}
					}
				} catch (IReachableHandlerException e) {
					e.printStackTrace();
				}
			}
			items.remove(r);
		}

		@Override
		public void objectChanged(Object object) {
			Reachable r = null;
			if (object instanceof Reachable) {
				r = (Reachable) object;
			} else {
				try {
					IObjectHandler handlerFromObject = manager.getHandlerFromObject(object);
					if (handlerFromObject != null) {
						ReachableObject fromObject = handlerFromObject.getFromObject(object);
						if (fromObject != null) {
							r = fromObject.getReachable(object);
						}
					}
				} catch (IReachableHandlerException e) {
					e.printStackTrace();
				}
			}
			Item get = items.get(r);
			if (get != null) {
				RequirementView.this.getCommonViewer().doUpdateItem(get);
			}
		}

		@Override
		public boolean isEmpty() {
			return items.isEmpty();
		}

		@Override
		public boolean handlesObject(Object object) {
			Reachable r = null;
			if (object instanceof Reachable) {
				r = (Reachable) object;
			} else {
				try {
					IObjectHandler handlerFromObject = manager.getHandlerFromObject(object);
					if (handlerFromObject != null) {
						ReachableObject fromObject = handlerFromObject.getFromObject(object);
						if (fromObject != null) {
							r = fromObject.getReachable(object);
						}
					}
				} catch (IReachableHandlerException e) {
					return false;
				}
			}
			return r != null && items.containsKey(r);

		}

		@Override
		public void clearMap() {
			items.clear();
		}

		@Override
		public void addToMap(Object element, Item item) {
			Reachable r = null;
			if (element instanceof Reachable) {
				r = (Reachable) element;
			} else {
				try {
					r = getReachable(element);
				} catch (IReachableHandlerException e) {
					e.printStackTrace();
				}
			}
			items.put(r, item);
		}
	}

	@Override
	public void handleEvent(Event event) {
		Object data = event.getProperty(IEventBroker.DATA);
		if (data instanceof List<?>) {
			List<?> dataList = (List<?>) data;
			if ((dataList.size() > 1) && (dataList.get(0) instanceof RequirementSource) && (dataList.get(1) instanceof RequirementSource)) {
				RequirementSource oldrs = (RequirementSource) dataList.get(0);
				RequirementSource newrs = (RequirementSource) dataList.get(1);

				List<RequirementSource> list = root.getSources();
				if (list.contains(oldrs)) {
					root.removeSource(oldrs);
					root.addSource(newrs);

					this.getCommonViewer().refresh();
				}
			}
		}
	}
}
