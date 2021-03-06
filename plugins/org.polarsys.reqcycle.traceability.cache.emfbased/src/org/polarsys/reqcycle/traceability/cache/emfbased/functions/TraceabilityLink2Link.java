/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.cache.emfbased.functions;

import javax.inject.Inject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import org.polarsys.reqcycle.traceability.cache.emfbased.model.CacheTracability.TraceabilityLink;
import org.polarsys.reqcycle.traceability.model.Link;
import org.polarsys.reqcycle.traceability.model.TType;
import org.polarsys.reqcycle.uri.IReachableCreator;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

public class TraceabilityLink2Link implements Function<TraceabilityLink, Link> {

	@Inject
	IReachableCreator creator;

	@Override
	public Link apply(TraceabilityLink aLink) {
		TraceableElement2Traceable traceableElement2Traceable = new TraceableElement2Traceable();
		ZigguratInject.inject(traceableElement2Traceable);
		Iterable<Reachable> sources = Iterables.transform(aLink.getSources(), traceableElement2Traceable);
		Iterable<Reachable> targets = Iterables.transform(aLink.getTargets(), traceableElement2Traceable);

		// RFa provide ID - to check
		// FIXME
		UUID uniqueID = UUID.randomUUID();
		URI uri = null;
		try {
			uri = new URI(aLink.getResource().getUri());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reachable r = creator.getReachable(uri);
		Link link = new Link(r, new TType(uniqueID.toString(), aLink.getLabel()), sources, targets);
		return link;
	}

}
