/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.stub;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.polarsys.reqcycle.emf.types.EMFTypeChecker;
import org.polarsys.reqcycle.emf.utils.EMFUtils;
import org.polarsys.reqcycle.uri.IIDContributor;
import org.polarsys.reqcycle.uri.IReachableCreator;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.eclipse.uml2.uml.NamedElement;

public class StubbedIdContributor implements IIDContributor {

	@Inject
	IReachableCreator creator;

	@Inject
	IReachableManager manager;

	@Override
	public Reachable getReachable(String logicalID) {
		String[] splitted = logicalID.split("/");

		// general case
		IResource container = ResourcesPlugin.getWorkspace().getRoot();
		Resource resEMF = null;
		EObject current = null;
		boolean found = false;
		for (String s : splitted) {
			found = false;
			if (current != null) {
				for (EObject e : current.eContents()) {
					if (e instanceof NamedElement) {
						NamedElement uml = (NamedElement) e;
						if (s.equals(uml.getName())) {
							current = uml;
							found = true;
							break;
						}
					}
				}
			} else if (resEMF != null) {
				for (EObject e : resEMF.getContents()) {
					if (e instanceof NamedElement) {
						NamedElement uml = (NamedElement) e;
						if (s.equals(uml.getName())) {
							current = uml;
						}
					}
				}
			} else if (container instanceof IContainer) {
				IContainer folder = (IContainer) container;
				IResource res = getRes(folder, s);
				if (res instanceof IContainer) {
					container = res;
				} else if (res != null) {
					IFile f = folder.getFile(new Path(s));
					if (!f.exists()) {
						f = null;
					} else {
						try {
							org.eclipse.emf.common.util.URI emfURI = org.eclipse.emf.common.util.URI.createPlatformResourceURI(f.getFullPath().toString(), true);
							boolean checker = new EMFTypeChecker().apply(creator.getReachable(new URI(emfURI.toString())));
							if (checker) {
								resEMF = EMFUtils.getFAURSWithPathMaps().getResource(emfURI, true);
							}
						} catch (URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		if (found && current != null) {
			try {
				return manager.getHandlerFromObject(current).getFromObject(current).getReachable();
			} catch (IReachableHandlerException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private IResource getRes(IContainer folder, String s) {
		return folder.findMember(s);
	}
}
