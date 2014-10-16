/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.emf.handlers;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.polarsys.reqcycle.emf.utils.EMFProxyResolver;
import org.polarsys.reqcycle.emf.utils.EMFUtils;
import org.polarsys.reqcycle.uri.model.IObjectHandler;
import org.polarsys.reqcycle.uri.model.IReachableHandler;
import org.polarsys.reqcycle.uri.model.ProxyResolver;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.model.ReachableObject;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class EMFURIHandler implements IReachableHandler, IObjectHandler {

	@Override
	public boolean handlesReachable(Reachable t) {
		URI uri = EMFUtils.getEMFURI(t);
		return handlesURI(uri);
	}

	public boolean handlesURI(URI uri) {
		return EMFUtils.isEMF(uri);
	}

	@Override
	public ReachableObject getFromReachable(final Reachable t) {
		ReachableObject emfReachableObject = doGetReachableObject(t);
		ZigguratInject.inject(emfReachableObject);
		return emfReachableObject;
	}

	protected ReachableObject doGetReachableObject(final Reachable t) {
		return new EMFReachableObject(t);
	}

	@Override
	public boolean handlesObject(Object t) {
		return handles(t);
	}

	public boolean handles(Object t) {
		if (t instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable) t;
			Object o = adaptable.getAdapter(Resource.class);
			if (o != null) {
				t = o;
			} else {
				o = adaptable.getAdapter(EObject.class);
				if (o != null) {
					t = o;
				}
			}
		}
		if (t instanceof EObject) {
			Resource r = ((EObject) t).eResource();
			if (r != null) {
				t = r;
			}
		}
		if (t instanceof Resource) {
			return handlesURI(((Resource) t).getURI());
		}
		if (t instanceof IResource) {
			return handlesURI(URI.createPlatformResourceURI(((IResource) t).getFullPath().toString(), true));
		}

		return false;
	}

	@Override
	public ReachableObject getFromObject(final Object o) {
		ReachableObject result = null;
		if (o instanceof IResource) {
			IResource res = (IResource) o;
			result = doGetReachableObject(EMFUtils.getReachable(URI.createPlatformResourceURI(res.getFullPath().toString(), true)));
		} else if (o instanceof EObject) {
			result = doGetReachableObject(EMFUtils.getReachable(((EObject) o)));
		} else if (o instanceof Resource) {
			result = doGetReachableObject(EMFUtils.getReachable(((Resource) o).getURI()));
		} else if (o instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable) o;
			result = doGetReachableObject(EMFUtils.getReachable((EObject) adaptable.getAdapter(EObject.class)));
		}
		if (result != null) {
			ZigguratInject.inject(result);
		}
		return result;
	}

	@Override
	public ProxyResolver getProxyResolver() {
		return new EMFProxyResolver();
	}
}
