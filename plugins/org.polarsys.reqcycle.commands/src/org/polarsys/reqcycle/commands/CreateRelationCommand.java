/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Philippe Roland (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.commands;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polarsys.reqcycle.traceability.builder.BuilderUtil;
import org.polarsys.reqcycle.traceability.storage.IStorageProvider;
import org.polarsys.reqcycle.traceability.storage.ITraceabilityStorage;
import org.polarsys.reqcycle.traceability.types.ITraceTypesManager;
import org.polarsys.reqcycle.traceability.types.configuration.typeconfiguration.Relation;
import org.polarsys.reqcycle.uri.IReachableCreator;
import org.polarsys.reqcycle.uri.IReachableListenerManager;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.model.ReachableObject;

import com.google.common.collect.Lists;

public class CreateRelationCommand implements Command {

	@Inject
	IStorageProvider provider;

	@Inject
	ITraceTypesManager tTypesManager;

	@Inject
	IReachableManager manager;

	@Inject
	IReachableCreator creator;

	@Inject
	IReachableListenerManager listenerManager;

	private Relation relation;

	private Reachable source;

	private Reachable target;

	public CreateRelationCommand(Relation relation, Reachable source, Reachable target) {
		this.relation = relation;
		this.source = source;
		this.target = target;
	}

	public IProject getDefaultTraceabilityProject() {
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject("ReqCycle_Transverse_Traceability");
		if (!p.exists()) {
			try {
				p.create(new NullProgressMonitor());
				p.setHidden(false);
				BuilderUtil.installBuilder(p);
			} catch (CoreException e) {
			}
		}
		return p;
	}

	public IProject getProjectFromReachable(Reachable r) {
		ReachableObject object;
		try {
			object = manager.getHandlerFromReachable(r).getFromReachable(r);
			IFile f = (IFile) object.getAdapter(IFile.class);
			if (f != null && f.exists()) {
				return f.getProject();
			}
		} catch (IReachableHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void execute() {
		redo();
	}

	public void redo() {
		// handle project traceability path
		IProject p = getProjectFromReachable(source);
		if (p == null) {
			p = getProjectFromReachable(target);
		}
		if (p == null) {
			p = getDefaultTraceabilityProject();
		}
		List<Reachable> toUpdate = Lists.newArrayList();
		// get the storage for the project
		ITraceabilityStorage traceaStorage = provider.getProjectStorage(p);
		String originalPath = traceaStorage.getPath();
		String wsPath = originalPath.replace(ResourcesPlugin.getWorkspace().getRoot().getLocationURI().toString(),"");
		if (wsPath.equals(originalPath)){
			wsPath = p.getFullPath().toString();
		}
		try {
			Reachable container = creator.getReachable(new URI("platform:" + wsPath));
			Reachable tracea = creator.getReachable(new URI("platform:" + wsPath));
			tracea.setFragment(getNextId());
			traceaStorage.startTransaction();
			// FIX ME
			// for (TType type : relation.getAgregated()) {
			// storage.addOrUpdateUpwardRelationShip(type, tracea, container,
			// source,
			// new Reachable[] { target });
			// }
			traceaStorage.addOrUpdateUpwardRelationShip(relation.getTType(), tracea, container, source, new Reachable[] { target });
			toUpdate.add(tracea);
			toUpdate.add(container);
			toUpdate.add(source);
			toUpdate.add(target);
			traceaStorage.addUpdateProperty(tracea, "relationKind", relation.getKind()); //$NON-NLS-1$
			traceaStorage.commit();
			traceaStorage.save();

		} catch (RuntimeException e) {
			e.printStackTrace();
			traceaStorage.rollback();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			traceaStorage.dispose();
		}
		listenerManager.notifyChanged(toUpdate.toArray(new Reachable[] {}));
	}

	private String getNextId() {
		return EcoreUtil.generateUUID();
	}
}
