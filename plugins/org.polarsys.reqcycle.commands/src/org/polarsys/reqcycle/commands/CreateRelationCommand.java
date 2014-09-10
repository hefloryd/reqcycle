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

import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polarsys.reqcycle.traceability.storage.IStorageProvider;
import org.polarsys.reqcycle.traceability.storage.ITraceabilityStorage;
import org.polarsys.reqcycle.traceability.types.ITraceTypesManager;
import org.polarsys.reqcycle.traceability.types.configuration.typeconfiguration.Relation;
import org.polarsys.reqcycle.uri.IReachableCreator;
import org.polarsys.reqcycle.uri.IReachableListenerManager;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.model.Reachable;

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

	private IResource res;

	public CreateRelationCommand(Relation relation, Reachable source, Reachable target, IResource res) {
		this.relation = relation;
		this.source = source;
		this.target = target;
		this.res = res;
	}

	public void execute() {
		redo();

	}

	public void redo() {
		// handle project traceability path
		IProject p = res.getProject();
		String projectURI = p.getFullPath().toPortableString() + "/here";
		List<Reachable> toUpdate = Lists.newArrayList();
		// get the storage for the project
		ITraceabilityStorage traceaStorage = provider.getProjectStorage(p);
		try {
			Reachable container = manager.
					getHandlerFromObject(projectURI).
						getFromObject(projectURI).
							getReachable(projectURI);
			Object id = new Object[]{ container, getNextId() };
			Reachable tracea = manager.getHandlerFromObject(id).getFromObject(id).getReachable(id);
			traceaStorage.startTransaction();
			// FIX ME
			// for (TType type : relation.getAgregated()) {
			// storage.addOrUpdateUpwardRelationShip(type, tracea, container,
			// source,
			// new Reachable[] { target });
			// }
			traceaStorage.addOrUpdateUpwardRelationShip(relation.getTType(), tracea, container, source, new Reachable[]{ target });
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
		} catch (IReachableHandlerException e) {
			e.printStackTrace();
		} finally {
			traceaStorage.dispose();
		}
		listenerManager.notifyChanged(toUpdate.toArray(new Reachable[]{}));
	}

	private String getNextId() {
		return EcoreUtil.generateUUID();
	}
}
