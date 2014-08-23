/*******************************************************************************
 *  Copyright (c) 2014 AtoS and others
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    (AtoS) - initial API and implementation and/or initial documentation
 *    Raphael Faudou (Samares Engineering) - revereted default display of requirements 
 *    it was before stytling model (see https://polarsys.org/bugs/show_bug.cgi?id=28)
 *    
 *******************************************************************************/
package org.polarsys.reqcycle.styling.ui.providers;

import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.polarsys.reqcycle.predicates.core.IPredicateEvaluator;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.predicates.ui.providers.PredicatesItemProviderAdapterFactory;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementsContainer;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Section;
import org.polarsys.reqcycle.styling.model.ITopic;
import org.polarsys.reqcycle.styling.model.Styling.CaseStyle;
import org.polarsys.reqcycle.styling.model.Styling.StylingModel;
import org.polarsys.reqcycle.styling.model.Styling.StylingPredicate;
import org.polarsys.reqcycle.styling.ui.IStylingManager;
import org.polarsys.reqcycle.styling.ui.dialogs.IconRegistry;
//import org.polarsys.reqcycle.styling.ui.providers.StylingContentProvider.PredicateInput;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Lists;

public class StylingLabelProvider implements ILabelProvider,
		IStyledLabelProvider, EventHandler {

	@Inject
	IStylingManager manager;

	@Inject
	IEventBroker broker;

	@Inject
	IReachableManager rManager;

	@Inject
	IPredicateEvaluator predicateEvaluator;

	private Collection<ILabelProviderListener> listeners = Lists.newArrayList();

	public StylingLabelProvider() {
		super();
		ZigguratInject.inject(this);
		broker.subscribe(ITopic.LISTENER, this);
	}

	public void notifyChanged(Object[] objects) {
		for (ILabelProviderListener listener : listeners) {
			listener.labelProviderChanged(new LabelProviderChangedEvent(this,
					objects));
		}
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		listeners.add(listener);
	}

	@Override
	public void dispose() {
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		listeners.remove(listener);
	}

	@Override
	public String getText(Object element) {
		if (element instanceof IPredicate) {
			return ((IPredicate) element).getDisplayName();
		} else {
			return getText(element, String.class);
		}
	}

	private StyledString applyStyle(Object element, CaseStyle styling) {

		return styling.getStyledString(element);
	}

	private StylingModel getStylingModel() {
		String selectedModel = manager.getPreferredStyleModel();
		EList<StylingModel> list = manager.getStyling().getModels();
		for (StylingModel styling : list) {
			if (styling.getModeName().equals(selectedModel)) {
				return styling;
			}
		}
		return null;
	}

	@Override
	public Image getImage(Object object) {
		if (object instanceof RequirementSource) {
			return null;
		} else if (object instanceof IPredicate) {
			PredicatesItemProviderAdapterFactory factory = new PredicatesItemProviderAdapterFactory();
			return new AdapterFactoryLabelProvider(factory).getImage(object);
		} else {
			StylingModel model = getStylingModel();
			if (model != null) {
				EList<CaseStyle> list = model.getStyles();
				for (CaseStyle styling : list) {
					StylingPredicate sp = (StylingPredicate) styling;
					if (predicateEvaluator.match(sp.getPredicate(), object)) {
						return IconRegistry.getImage(sp.getIcon().getImage());
					}
				}
				if (model.getDefault() != null) {
					return IconRegistry.getImage(model.getDefault().getIcon()
							.getImage());
				}
			}
			return null;
		}
	}

	@Override
	public StyledString getStyledText(Object element) {
		if (element instanceof IPredicate) {
			return new StyledString(((IPredicate) element).getDisplayName());
		} else {
			return getText(element, StyledString.class);
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T getText(Object element, Class<T> theClass) {
		if (element instanceof EObject) {
			EObject eobject = (EObject) element;
			if (!containsAdapter(eobject)) {
				eobject.eAdapters().add(new StylingAdapter());
			}
		}

		if (element instanceof RequirementSource) {
			String label = ((RequirementSource) element).getRepositoryUri();
			if (label == null) {
				label = ((RequirementSource) element).getName();
			} else {
				label = ((RequirementSource) element).getName() + 
						" [" + label
						+ "]";
			}
			return toT(label, theClass);
		} else {
			StylingModel model = getStylingModel();
			if (model != null) {
				EList<CaseStyle> list = model.getStyles();
				for (CaseStyle styling : list) {
					StylingPredicate sp = (StylingPredicate) styling;
					if (sp.getPredicate() != null) {
						if (predicateEvaluator
								.match(sp.getPredicate(), element)) {
							if (StyledString.class.equals(theClass)) {
								return (T) applyStyle(element, styling);
							}
						}
					}
				}
				if (model.getDefault() != null) {
					return (T) applyStyle(element, model.getDefault());
				}
			}
			else {
				// in case no sytling model is defined, we display requirement section ID and requirement ID + Text by default				
				if (element instanceof Requirement) {
					Requirement req = (Requirement) element;
					String label = "id=" +req.getId() +"]["+ "text=" + req.getText() ;
					return toT(" [ " +label+ "]", theClass);

				}
				// as Requirement extends section, requirement must be handled first (before section)
				if (element instanceof Section) {
					String label = (( Section) element).getId() + "][" + (( Section) element).getText();
					return toT(" [ " +label+ "]", theClass);
				}
			}
		}
		return toT(element.toString(), theClass);
	}

	protected boolean containsAdapter(EObject eobject) {
		for (Adapter a : eobject.eAdapters()) {
			if (a instanceof StylingAdapter) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public <T> T toT(String string, Class<T> theClass) {
		if (String.class.equals(theClass)) {
			return (T) string;
		} else if (StyledString.class.equals(theClass)) {
			StyledString styled = new StyledString(string);
			return (T) styled;
		} else {
			return null;
		}
	}

	private class StylingAdapter extends AdapterImpl {

	}

	void handleModification(Notification notification) {
		Object[] listObject = new Object[1];
		listObject[0] = notification.getFeature();
		this.notifyChanged(listObject);
	}

	@Override
	public void handleEvent(Event event) {
		Object data = event.getProperty(IEventBroker.DATA);
		if (data instanceof Reachable) {
			Reachable reachable = (Reachable) data;
			notifyChanged(new Object[] { reachable });
		} else if (data instanceof Collection) {
			notifyChanged(((Collection) data).toArray());
		}
	}

}
