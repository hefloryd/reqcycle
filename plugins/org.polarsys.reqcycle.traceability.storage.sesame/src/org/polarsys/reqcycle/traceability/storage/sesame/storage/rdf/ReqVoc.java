/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.storage.sesame.storage.rdf;

import org.openrdf.model.Namespace;
import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.NamespaceImpl;
import org.openrdf.model.impl.ValueFactoryImpl;

/**
 * Reqcycle Vocabulary.
 * 
 * @author rsemlal
 * 
 */
public class ReqVoc {
	public static final String NAMESPACE = "http://www.polarsys.org/projects/polarsys.reqcycle/syntax#";

	public static final String PREFIX = "req";

	public static final Namespace NS = new NamespaceImpl(PREFIX, NAMESPACE);

	public static final URI HAS_DOWNSTREAM;
	public static final URI HAS_UPSTREAM;
	public static final URI HAS_KIND;
	public static final URI HAS_PROPERTY;

	public static final URI TYPE_TRACEABILITY;
	public static final URI TYPE_TRACEABLE;
	public static final URI TYPE_TTYPE;

	private static final ValueFactory valueFactory = ValueFactoryImpl.getInstance();

	static {
		HAS_DOWNSTREAM = valueFactory.createURI(NAMESPACE, "hasDownstream");
		HAS_UPSTREAM = valueFactory.createURI(NAMESPACE, "hasUpstream");
		HAS_KIND = valueFactory.createURI(NAMESPACE, "hasKind");
		HAS_PROPERTY = valueFactory.createURI(NAMESPACE, "hasProperty");

		TYPE_TRACEABILITY = valueFactory.createURI(NAMESPACE, "traceability");
		TYPE_TRACEABLE = valueFactory.createURI(NAMESPACE, "traceable");
		TYPE_TTYPE = valueFactory.createURI(NAMESPACE, "ttype");
	}

	private ReqVoc() {
		super();
	}
}
