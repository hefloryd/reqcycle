/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.storage.sesame.storage.internal.beans;

import org.polarsys.reqcycle.traceability.model.Link;
import org.polarsys.reqcycle.uri.model.Reachable;

public class SesameContainedLink {
	private final Link link;
	private final Reachable container;

	public SesameContainedLink(Reachable container, Link link) {
		super();
		this.link = link;
		this.container = container;
	}

	/**
	 * @return the link
	 */
	public Link getLink() {
		return link;
	}

	/**
	 * @return the container
	 */
	public Reachable getContainer() {
		return container;
	}
}
