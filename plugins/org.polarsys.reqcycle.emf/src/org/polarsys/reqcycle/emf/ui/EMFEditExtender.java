/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.emf.ui;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.polarsys.reqcycle.emf.Activator;
import org.polarsys.reqcycle.emf.utils.EMFUtils;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.model.ReachableObject;
import org.polarsys.reqcycle.uri.services.IReachableExtender;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class EMFEditExtender implements IReachableExtender {

	private static final String URI_PREFIX = "emf:/";
	private static String EMF_EDIT_LABEL = URI_PREFIX + "emfEditLabel";
	private static String EMF_EDIT_ECLASS = URI_PREFIX + "emfEditEclass";
	private static ComposedAdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
	static IReachableManager manager = ZigguratInject.make(IReachableManager.class);

	public EMFEditExtender() {
	}

	@Override
	public Map<String, String> getExtendedProperties(URI uri, Object originalObject) {
		Map<String, String> result = new HashMap<String, String>();
		if (originalObject instanceof EObject) {
			EObject eobj = (EObject) originalObject;
			if (!eobj.eIsProxy()) {
				AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(factory);
				String label = adapterFactoryLabelProvider.getText(eobj);
				putLabel(result, label);
				putImage(result, eobj.eClass().getEPackage().getNsURI() + "#" + eobj.eClass().getName());
			}

		}
		return result;
	}

	public void putImage(Map<String, String> result, String image) {
		result.put(EMF_EDIT_ECLASS, image);
	}

	public void putLabel(Map<String, String> result, String label) {
		result.put(EMF_EDIT_LABEL, label);
	}

	@Override
	public boolean handles(URI uri, Object object) {
		return EMFUtils.isEMF(uri) && object instanceof EObject && !((EObject) object).eIsProxy();
	}

	public static EObject getEObject (Reachable r){
		ReachableObject ro;
		EObject result = null;
		try {
			ro = manager.getHandlerFromReachable(r).getFromReachable(r);
			result = (EObject) ro.getAdapter(EObject.class);
			if (result == null) {
				ResourceSet set = EMFUtils.getFastAndUnresolvingResourceSet();
				org.eclipse.emf.common.util.URI emfuri = EMFUtils.getEMFURI(r);
				result = set.getEObject(emfuri, true);
			}
		} catch (IReachableHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result ;
	}
	
	public static String getLabel(Reachable r) {
		String result = r.get(EMF_EDIT_LABEL);
		if (result == null) {
			EObject e = getEObject(r);
			try {
				r.putAll(new EMFEditExtender().getExtendedProperties(new java.net.URI(r.toString()), e));
			} catch (URISyntaxException e1) {
				Activator.getDefault().getLog().log(new Status(Status.ERROR, Activator.PLUGIN_ID, e1.getMessage(), e1));
			}
			result = r.get(EMF_EDIT_LABEL);
		}
		if (result != null && result.length() > 0) {
			return result;
		}
		return r.toString();
	}

	public static Image getImage(Reachable r) {
		String s = r.get(EMF_EDIT_ECLASS);
		if (s == null) {
			EObject e = getEObject(r);
			try {
				r.putAll(new EMFEditExtender().getExtendedProperties(new java.net.URI(r.toString()), e));
			} catch (URISyntaxException e1) {
				Activator.getDefault().getLog().log(new Status(Status.ERROR, Activator.PLUGIN_ID, e1.getMessage(), e1));
			}
		}
		s = r.get(EMF_EDIT_ECLASS);
		if (s != null) {
			String[] tab = s.split("#");
			if (tab.length == 2) {
				String epackageURI = tab[0];
				String eclassName = tab[1];
				EPackage ep = EPackage.Registry.INSTANCE.getEPackage(epackageURI);
				if (ep != null) {
					EClassifier e = ep.getEClassifier(eclassName);
					if (e instanceof EClass) {
						EClass eclass = (EClass) e;
						EObject eobj = ep.getEFactoryInstance().create(eclass);
						AdapterFactoryLabelProvider p = new AdapterFactoryLabelProvider(factory);
						return p.getImage(eobj);
					}
				}
			}
		}
		return null;
	}
}
