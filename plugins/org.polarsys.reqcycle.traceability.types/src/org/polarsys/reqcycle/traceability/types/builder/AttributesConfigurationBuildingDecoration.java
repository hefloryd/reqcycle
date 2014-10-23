/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.types.builder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.polarsys.reqcycle.traceability.builder.IBuildingDecoration.IBuildingDecorationAdapter;
import org.polarsys.reqcycle.traceability.builder.ITraceabilityBuilder.IBuilderCallBack;
import org.polarsys.reqcycle.traceability.engine.ITraceabilityEngine.DIRECTION;
import org.polarsys.reqcycle.traceability.model.TType;
import org.polarsys.reqcycle.traceability.storage.IStorageProvider;
import org.polarsys.reqcycle.traceability.storage.ITraceabilityStorage;
import org.polarsys.reqcycle.traceability.storage.NoProjectStorageException;
import org.polarsys.reqcycle.traceability.types.ITypesConfigurationProvider;
import org.polarsys.reqcycle.traceability.types.RelationBasedType;
import org.polarsys.reqcycle.traceability.types.RelationUtils;
import org.polarsys.reqcycle.traceability.types.configuration.typeconfiguration.Configuration;
import org.polarsys.reqcycle.traceability.types.configuration.typeconfiguration.Relation;
import org.polarsys.reqcycle.traceability.types.impl.TraceabilityAttributesManager;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.model.IObjectHandler;
import org.polarsys.reqcycle.uri.model.Reachable;

public class AttributesConfigurationBuildingDecoration extends IBuildingDecorationAdapter {

	@Inject
	protected ITypesConfigurationProvider provider;
	@Inject
	protected IReachableManager manager;
	@Inject
	protected IStorageProvider storageProvider;

	protected ITraceabilityStorage currentStorage;

	protected Set<Reachable> allTraceabilityWithProperties = new HashSet<Reachable>();

	private Configuration defaultConfiguration = null;

	@Override
	public void startBuild(IBuilderCallBack callBack, Reachable reachable) {
		defaultConfiguration = provider.getDefaultConfiguration();
		if (defaultConfiguration == null) {
			return;
		}
		try {
			currentStorage = storageProvider.getProjectStorageFromLinkId(reachable);
		} catch (NoProjectStorageException e) {
			e.printStackTrace(); // TODO Error handling
		}
	}

	@Override
	public void endBuild(IBuilderCallBack callBack, Reachable reachable) {
		if (currentStorage != null) {
			currentStorage.save();
//			currentStorage.dispose();
			currentStorage = null;
		}
		defaultConfiguration = null;
	}

	@Override
	public boolean newUpwardRelation(IBuilderCallBack callBack, Object traceability, Object resource, Object source, List<? extends Object> targets, TType kind) {
		if (kind instanceof RelationBasedType) {
			// prevent recursive call
			return true;
		}
		// in case of no configuration registered the elements are not modified
		if (defaultConfiguration == null) {
			return true;
		}
		Reachable reachableSource = getReachable(source);
		Reachable reachableTrac = getReachable(traceability);
		boolean newOne = true;
		for (Object t : targets) {
			Reachable reachableTarget = getReachable(t);
			Iterable<Relation> relations = RelationUtils.getAgregatingRelations(kind, defaultConfiguration, reachableSource, reachableTarget, DIRECTION.UPWARD);
			for (Relation r : relations) {
				newOne = false;
				RelationBasedType relBasedType = new RelationBasedType(r, kind);
				callBack.newUpwardRelation(traceability, resource, source, targets, relBasedType);
				if (currentStorage != null) {
					currentStorage.addUpdateProperty(reachableTrac, TraceabilityAttributesManager.RELATION_NAME, r.getKind());
				}
			}
		}
		return newOne;

	}

	private Reachable getReachable(Object object) {
		IObjectHandler handler;
		try {
			handler = manager.getHandlerFromObject(object);
			return handler.getFromObject(object).getReachable();
		} catch (IReachableHandlerException e) {
			// e.printStackTrace();
			System.out.println("could not get reachable for " + object);
		}
		return null;
	}

}
