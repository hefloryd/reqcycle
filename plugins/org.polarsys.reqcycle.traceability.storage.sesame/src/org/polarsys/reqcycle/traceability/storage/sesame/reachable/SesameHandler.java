/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.storage.sesame.reachable;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.resources.IFile;
import org.polarsys.reqcycle.uri.IReachableCreator;
import org.polarsys.reqcycle.uri.model.IObjectHandler;
import org.polarsys.reqcycle.uri.model.IReachableHandler;
import org.polarsys.reqcycle.uri.model.ProxyResolver;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.model.ReachableObject;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;
import org.openrdf.rio.RDFWriterRegistry;

public class SesameHandler implements IObjectHandler, IReachableHandler {

	@Inject
	IReachableCreator creator;

	@PostConstruct
	public void init() {
	}

	@Override
	public ReachableObject getFromObject(Object object) {
		ReachableObject result = null;
		if (object instanceof File) {
			final URI uri = ((File) object).toURI();
			result = new SesameReachableObject(creator.getReachable(uri, object));
		} else if (object instanceof IFile) {
			try {
				final URI uri = new URI("platform:" + ((IFile) object).getFullPath().toString());
				result = new SesameReachableObject(creator.getReachable(uri, object));
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
		if (result != null) {
			ZigguratInject.inject(result);
		}
		return result;
	}

	@Override
	public boolean handlesObject(Object object) {
		if (object instanceof File) {
			return RDFWriterRegistry.getInstance().getFileFormatForFileName(((File) object).getName()) != null;
		} else if (object instanceof IFile) {
			return RDFWriterRegistry.getInstance().getFileFormatForFileName(((IFile) object).getName()) != null;
		}
		return false;
	}

	@Override
	public ReachableObject getFromReachable(Reachable t) {
		SesameReachableObject sesameReachableObject = new SesameReachableObject(t);
		ZigguratInject.inject(sesameReachableObject);
		return sesameReachableObject;
	}

	@Override
	public boolean handlesReachable(Reachable t) {
		return t.getPath() != null && RDFWriterRegistry.getInstance().getFileFormatForFileName(t.getPath()) != null;
	}

	@Override
	public ProxyResolver getProxyResolver() {
		return null;
	}

}
