/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.repository.data.reachables;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.polarsys.reqcycle.emf.handlers.EMFReachableObject;
import org.polarsys.reqcycle.emf.utils.EMFUtils;
import org.polarsys.reqcycle.emf.visitors.EMFVisitable;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.utils.configuration.IConfigurationManager;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class ReqcycleReachableObject extends EMFReachableObject {

	protected Reachable reqcycleReachable;
	IConfigurationManager manager = ZigguratInject.make(IConfigurationManager.class);

	public ReqcycleReachableObject(Reachable reqcycleReachable, Reachable emfReachable) {
		super(emfReachable);
		if (reqcycleReachable == null) {
			reqcycleReachable = emfReachable;
		}
		this.reqcycleReachable = reqcycleReachable;
	}

	@Override
	public Reachable getReachable() {
		return reqcycleReachable;
	}

	@Override
	protected EMFVisitable doGetVisitable(URI uri) {
		return new EMFVisitable(uri) {

			@Override
			protected ResourceSet getResourceSet() {
				return EMFUtils.getFAURSWithPathMaps();
			}
		};
	}
}
