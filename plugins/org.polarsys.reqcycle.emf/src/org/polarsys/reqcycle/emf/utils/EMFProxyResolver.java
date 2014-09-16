/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
package org.polarsys.reqcycle.emf.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polarsys.reqcycle.uri.model.ProxyResolver;

/**
 * A {@link ProxyResolver} that can resolve proxy {@link EObject} (wich have {@link EObject#eIsProxy()} is <code>true</code>).
 * <p>
 * Each {@link EMFProxyResolver} instance owns an internal {@link ResourceSet}, that should be unloaded by calling {@link #dispose()}.
 * </p>
 * 
 * @author rsemlal
 */
public class EMFProxyResolver implements ProxyResolver {
	private final ResourceSet resourceSet;

	public EMFProxyResolver() {
		resourceSet = EMFUtils.getFastAndUnresolvingResourceSet();
	}

	@Override
	public Object resolve(Object obj) {
		final Object result;

		if (obj != null && obj instanceof EObject) {
			EObject eobject = (EObject) obj;

			if (eobject.eIsProxy()) {
				eobject = EcoreUtil.resolve(eobject, resourceSet);
			}

			result = eobject;
		} else {
			result = obj;
		}

		return result;
	}

	@Override
	public void dispose() {
		if (resourceSet != null) {
			for (int i = 0; i < resourceSet.getResources().size(); i++) {
				try {
					resourceSet.getResources().get(i).unload();
				} catch (Exception e) {
					// TODO Error management
				}
				resourceSet.getResources().clear();
			}
		}

	}

}
