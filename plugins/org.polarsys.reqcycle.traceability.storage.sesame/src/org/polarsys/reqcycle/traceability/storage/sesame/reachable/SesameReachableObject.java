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

import javax.inject.Inject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.polarsys.reqcycle.traceability.storage.NoProjectStorageException;
import org.polarsys.reqcycle.uri.IReachableCreator;
import org.polarsys.reqcycle.uri.exceptions.VisitableException;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.model.ReachableObject;
import org.polarsys.reqcycle.uri.visitors.IVisitable;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class SesameReachableObject implements ReachableObject {

	private Reachable reachable;
	@Inject
	IReachableCreator creator;

	public SesameReachableObject(Reachable t) {
		this.reachable = t;
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if(IFile.class.equals(adapter)) {
			final IWorkspace workspace = ResourcesPlugin.getWorkspace();
			final IWorkspaceRoot workspaceRoot = workspace.getRoot();
			final IFile file = workspaceRoot.getFile(new Path(reachable.getPath()));
			return file;
		}
		return null;
	}

	@Override
	public IVisitable getVisitable() throws VisitableException {
		SesameVisitable sesameVisitable;
		try {
			sesameVisitable = new SesameVisitable(reachable);
			ZigguratInject.inject(sesameVisitable); // TODO plus la peine
			return sesameVisitable;
		} catch (NoProjectStorageException e) {
			throw new VisitableException("Unable to create visitable for: " + reachable, e);
		}
	}

	@Override
	public String getRevisionIdentification() {
		String path = reachable.getPath();
		if ("file".equals(reachable.getScheme())) {
			File f = new File(path);
			if (f.exists()) {
				return String.valueOf(f.lastModified());
			}
		} else if ("platform".equals(reachable.getScheme())) {
			IFile f = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
			if (f.exists()) {
				return String.valueOf(f.getModificationStamp());
			}
		}
		return null;
	}

	@Override
	public Reachable getReachable(Object o) {
		return this.reachable;
	}
}