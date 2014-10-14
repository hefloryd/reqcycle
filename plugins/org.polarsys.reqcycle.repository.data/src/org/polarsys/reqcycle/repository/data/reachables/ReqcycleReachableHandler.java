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

import java.net.URISyntaxException;

import javax.inject.Inject;

import org.eclipse.emf.common.util.URI;
import org.polarsys.reqcycle.emf.handlers.EMFReachableObject;
import org.polarsys.reqcycle.emf.handlers.EMFURIHandler;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementsContainer;
import org.polarsys.reqcycle.uri.IReachableCreator;
import org.polarsys.reqcycle.uri.model.Reachable;

public class ReqcycleReachableHandler extends EMFURIHandler {

	@Inject
	IDataManager dataManager;

	@Inject
	IReachableCreator reachableCreator;

	@Override
	public boolean handlesURI(URI uri) {
		return isReqcycle(uri);
	}

	public static boolean isReqcycle(URI uri) {
		return uri.scheme().equals("reqcycle") || uri.path().endsWith("reqcycle");
	}

	@Override
	protected EMFReachableObject doGetReachableObject(Reachable t) {
		if (t.getPath().endsWith(".reqcycle")) {
			URI resourceUri = URI.createURI(t.toString()).trimFragment();
			for (RequirementSource reqSource : dataManager.getRequirementSources()) {
				RequirementsContainer content = reqSource.getContents();
				if (content != null && content.eResource() != null && resourceUri.equals(content.eResource().getURI())) {
					try {
						Reachable reqcycleReachable = reachableCreator.getReachable(new java.net.URI("reqcycle://" + URI.encodeSegment(reqSource.getName(), true)));
						reqcycleReachable.setFragment(t.getFragment());
						return new ReqcycleReachableObject(reqcycleReachable, t);
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		if ("reqcycle".equals(t.getScheme())) {
			String reqSourceName = URI.decode(t.getHost());
			for (RequirementSource reqSource : dataManager.getRequirementSources()) {
				if (reqSourceName.equals(reqSource.getName())) {
					RequirementsContainer content = reqSource.getContents();
					if (content != null && content.eResource() != null) {
						try {
							Reachable emfReachable = reachableCreator.getReachable(new java.net.URI(content.eResource().getURI().toString()));
							emfReachable.setFragment(t.getFragment());
							return new ReqcycleReachableObject(t, emfReachable);
						} catch (URISyntaxException e) {
							e.printStackTrace();
						}
					}
					break;
				}
			}
		}
		return new ReqcycleReachableObject(null, t);
	}

}
