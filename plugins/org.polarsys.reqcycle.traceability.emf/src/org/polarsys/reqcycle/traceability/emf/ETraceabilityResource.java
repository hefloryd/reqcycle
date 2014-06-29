/*****************************************************************************
 * Copyright (c) 2014 AtoS.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Abdellah El Ayadi  (AtoS) abdellah.elayadi@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.polarsys.reqcycle.traceability.emf;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityFactory;
import org.polarsys.reqcycle.traceability.engine.ITraceabilityEngine;
import org.polarsys.reqcycle.traceability.engine.ITraceabilityEngine.DIRECTION;
import org.polarsys.reqcycle.traceability.engine.Request;
import org.polarsys.reqcycle.traceability.engine.Request.DEPTH;
import org.polarsys.reqcycle.traceability.exceptions.EngineException;
import org.polarsys.reqcycle.traceability.model.Link;
import org.polarsys.reqcycle.traceability.model.Pair;
import org.polarsys.reqcycle.traceability.model.scopes.CompositeScope;
import org.polarsys.reqcycle.traceability.model.scopes.Scopes;
import org.polarsys.reqcycle.traceability.types.scopes.ConfigurationScope;
import org.polarsys.reqcycle.uri.model.Reachable;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;

public class ETraceabilityResource extends ResourceImpl {

	private Set<EObject> contents = Sets.newHashSet();
	protected boolean flag = false;

	protected Request request = new Request();

	@Inject
	ITraceabilityEngine engine;

	private HashMap<String, EReachable> map = new HashMap<String, EReachable>();

	/**
	 * {@inheritDoc}
	 * 
	 * ELinks are not handled
	 */
	@Override
	public EObject getEObject(String uri) {
		if (!map.containsKey(uri)) {
			return createEReachable(uri);
		} else {
			return map.get(uri);
		}
	}

	private EObject createEReachable(String uri) {
		EReachable reach = ReqCycleTraceabilityFactory.eINSTANCE.createEReachable();
		reach.setURI(uri);
		if (reach instanceof InternalEObject) {
			InternalEObject internal = (InternalEObject) reach;
			internal.eSetResource(this, null);
		}
		contents.add(reach);
		map.put(uri, reach);
		return reach;
	}

	@Override
	public void load(Map<?, ?> options) throws IOException {
	}

	@Override
	public EList<EObject> getContents() {
		if (!flag) {

			CompositeScope scope = new CompositeScope();
			scope.add(Scopes.getWorkspaceScope());
			scope.add(new ConfigurationScope());
			request.setScope(scope);
			request.setDepth(DEPTH.INFINITE);
			request.setDirection(DIRECTION.UPWARD);
			try {
				loadAllTraceability(DIRECTION.DOWNWARD);
				loadAllTraceability(DIRECTION.UPWARD);
			} catch (EngineException e) {
				Activator.log(IStatus.OK, Messages.ETraceabilityResource_0, e);
			}
			flag = true;
		}
		return new BasicEList<EObject>(contents);
	}

	private void loadAllTraceability(DIRECTION direction) throws EngineException {
		request.setDirection(direction);
		Iterator<Pair<Link, Reachable>> traceability = engine.getTraceability(request);
		Iterator<Reachable> reachables = Iterators.transform(traceability, new Function<Pair<Link, Reachable>, Reachable>() {

			@Override
			public Reachable apply(Pair<Link, Reachable> arg0) {
				Reachable second = arg0.getSecond();
				return second;
			}
		});
		while (reachables.hasNext()) {
			EReachable eReachable = (EReachable) getEObject(reachables.next().getURI().toString());
			contents.addAll(eReachable.getDownwards());
			contents.addAll(eReachable.getUpwards());
		}
	}

}
