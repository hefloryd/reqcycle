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

import javax.inject.Inject;

import org.eclipse.core.runtime.IAdaptable;
import org.polarsys.reqcycle.traceability.engine.ITraceabilityEngine.DIRECTION;
import org.polarsys.reqcycle.traceability.model.Link;
import org.polarsys.reqcycle.traceability.model.Pair;
import org.polarsys.reqcycle.traceability.storage.IStorageProvider;
import org.polarsys.reqcycle.traceability.storage.ITraceabilityStorage;
import org.polarsys.reqcycle.traceability.storage.NoProjectStorageException;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.internal.beans.SesameContainedLink;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.visitors.IVisitable;
import org.polarsys.reqcycle.uri.visitors.IVisitor;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class SesameVisitable implements IVisitable, IAdaptable {

	@Inject
	private IStorageProvider provider;
	private final ITraceabilityStorage storage;
	private final Reachable reachable;

	public SesameVisitable(final Reachable reachable) throws NoProjectStorageException {
		ZigguratInject.inject(this);
		this.reachable = reachable;
		this.storage = this.provider.getProjectStorageFromLinkId(reachable);
	}

	@Override
	public void accept(final IVisitor visitor) {
		final Iterable<Pair<Link, Reachable>> traces = this.storage.getAllTraceability(DIRECTION.UPWARD);
		for (final Pair<Link, Reachable> x : traces) {
			final Link link = x.getFirst();
			// TODO Changer le id du link pour virer le container
			final SesameContainedLink toVisit = new SesameContainedLink(this.reachable, link);
			visitor.visit(toVisit, this);
		}
	}

	@Override
	public void dispose() {
		if (this.storage != null) {
			// this.storage.dispose();
		}
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") final Class adapter) {
		return null;
	}

}
