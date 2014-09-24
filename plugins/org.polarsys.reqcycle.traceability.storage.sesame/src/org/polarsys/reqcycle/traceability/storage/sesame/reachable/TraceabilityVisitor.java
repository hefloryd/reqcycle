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

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.eclipse.core.runtime.IAdaptable;
import org.polarsys.reqcycle.traceability.builder.ITraceabilityBuilder.IBuilderCallBack;
import org.polarsys.reqcycle.traceability.model.Link;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.internal.beans.SesameContainedLink;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.visitors.IVisitor;

public class TraceabilityVisitor implements IVisitor {

	@PostConstruct
	public void init() {
	}

	@Override
	public void start(IAdaptable adaptable) {

	}

	@Override
	public boolean visit(Object o, IAdaptable adaptable) {
		if (o != null && o instanceof SesameContainedLink) {
			final SesameContainedLink obj = (SesameContainedLink) o;
			final Object container = obj.getContainer();
			final Link link = obj.getLink();
			final IBuilderCallBack callBack = getCallBack(adaptable);
			if (link != null && link.getSources() != null && link.getTargets() != null) {
				final ArrayList<Reachable> targets = new ArrayList<Reachable>(link.getTargets());

				for (final Reachable source : link.getSources()) {
					callBack.newUpwardRelation(link.getId(), container, source, targets, link.getKind());
				}
			}
			return true;
		}
		return false;
	}

	IBuilderCallBack getCallBack(IAdaptable adaptable) {
		return (IBuilderCallBack) adaptable.getAdapter(IBuilderCallBack.class);
	}

	@Override
	public void end(IAdaptable adaptable) {

	}

}
