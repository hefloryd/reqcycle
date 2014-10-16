/*******************************************************************************
 *  Copyright (c) 2013-2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *    Anass Radouani (AtoS) - injected logger
 *******************************************************************************/
package org.polarsys.reqcycle.emf.handlers;

import java.util.Collections;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.polarsys.reqcycle.core.ILogger;
import org.polarsys.reqcycle.emf.ui.EMFLabelProvider;
import org.polarsys.reqcycle.emf.utils.EMFUtils;
import org.polarsys.reqcycle.emf.visitors.EMFVisitable;
import org.polarsys.reqcycle.uri.Activator;
import org.polarsys.reqcycle.uri.exceptions.VisitableException;
import org.polarsys.reqcycle.uri.model.IBusinessObject;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.model.ReachableObject;
import org.polarsys.reqcycle.uri.visitors.IVisitable;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class EMFReachableObject implements ReachableObject {
	private final Reachable t;
	@Inject
	ILogger logger;
	@Inject
	IEMFProxyRegistry registry ;

	public EMFReachableObject(Reachable t) {
		this.t = t;
	}

	@Override
	public IVisitable getVisitable() throws VisitableException {
		try {
			EMFVisitable emfVisitable = doGetVisitable(EMFUtils.getEMFURI(t));
			ZigguratInject.inject(emfVisitable);
			return emfVisitable;
		} catch (RuntimeException e) {
			if (Activator.getDefault().isDebugging()) {
				logger.trace("Error loading " + t.toString());
			}
			throw new VisitableException();
		}
	}

	protected EMFVisitable doGetVisitable(URI uri) {
		return new EMFVisitable(uri);
	}

	@Override
	public String getRevisionIdentification() {
		EMFVisitable emfVisitable;
		try {
			emfVisitable = (EMFVisitable) getVisitable();
			String result = emfVisitable.getResourceTimeStamp();
			emfVisitable.dispose();
			return result;
		} catch (VisitableException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {
		if (IBusinessObject.class.equals(adapter)){
			URI createURI = URI.createURI(t.toString());
			if (createURI.isPlatformResource()){
				return new IBusinessObject.DefaultBusinessObject(!registry.isProxy(createURI));
			}
			else {
				EObject obj = (EObject) getAdapter(EObject.class);
				return new IBusinessObject.DefaultBusinessObject(obj != null && !obj.eIsProxy());
			}
		}
		if (EObject.class.equals(adapter)) {
			if (t.getFragment() != null && t.getFragment().length() > 0) {
				Resource r = (Resource) getAdapter(Resource.class);
				if (r != null){
					return r.getEObject(t.getFragment());
				}
			}
		}
		if (IMarker.class.equals(adapter)) {
			final IFile f = (IFile) getAdapter(IFile.class);
			if (f != null) {
				IMarker marker = new IMarker() {
					@Override
					public Object getAdapter(Class adapter) {
						return null;
					}

					@Override
					public void setAttributes(String[] attributeNames, Object[] values) throws CoreException {
					}

					@Override
					public void setAttributes(Map<String, ? extends Object> attributes) throws CoreException {
					}

					@Override
					public void setAttribute(String attributeName, boolean value) throws CoreException {
					}

					@Override
					public void setAttribute(String attributeName, Object value) throws CoreException {
					}

					@Override
					public void setAttribute(String attributeName, int value) throws CoreException {
					}

					@Override
					public boolean isSubtypeOf(String superType) throws CoreException {
						return true;
					}

					@Override
					public String getType() throws CoreException {
						return EValidator.MARKER;
					}

					@Override
					public IResource getResource() {
						return f;
					}

					@Override
					public long getId() {
						return 0;
					}

					@Override
					public long getCreationTime() throws CoreException {
						return 0;
					}

					@Override
					public Object[] getAttributes(String[] attributeNames) throws CoreException {
						return new Object[] {};
					}

					@Override
					public Map<String, Object> getAttributes() throws CoreException {
						return Collections.emptyMap();
					}

					@Override
					public boolean getAttribute(String attributeName, boolean defaultValue) {
						return false;
					}

					@Override
					public String getAttribute(String attributeName, String defaultValue) {
						if (EValidator.URI_ATTRIBUTE.equals(attributeName)) {
							return t.toString();
						}
						return null;
					}

					@Override
					public int getAttribute(String attributeName, int defaultValue) {
						return 0;
					}

					@Override
					public Object getAttribute(String attributeName) throws CoreException {
						if (EValidator.URI_ATTRIBUTE.equals(attributeName)) {
							return t.toString();
						}
						return null;
					}

					@Override
					public boolean exists() {
						return true;
					}

					@Override
					public void delete() throws CoreException {
					}
				};
				return marker;
			}
		}
		if (IResource.class.equals(adapter) || IFile.class.equals(adapter)) {
			try {
				return WorkspaceSynchronizer.getFile(((EMFVisitable) getVisitable()).getResource());
			} catch (VisitableException e) {
				e.printStackTrace();
			}
		}
		if (Resource.class.equals(adapter)) {
			try {
				return ((EMFVisitable) getVisitable()).getResource();
			} catch (VisitableException e) {
				e.printStackTrace();
			}
		}
		if (IVisitable.class.equals(adapter)) {
			try {
				return getVisitable();
			} catch (VisitableException e) {
				e.printStackTrace();
			}
		}
		if (ILabelProvider.class.equals(adapter)) {
			return new EMFLabelProvider();
		}
		return null;
	}

	@Override
	public Reachable getReachable() {
		return t;
	}

}
