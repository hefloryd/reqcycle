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

import org.openrdf.model.Resource;
import org.openrdf.model.vocabulary.RDF;
import org.openrdf.model.vocabulary.RDFS;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.utils.SPARQLStringBuilder;

/**
 * Commonly used SPARQL queries.
 * 
 * @author rsemlal
 * 
 */
public class Queries {

	public static final String OWNER = "owner";
	public static final String KEY = "key";
	public static final String VALUE = "value";

	public static final String LINK = "link";
	public static final String KIND = "kind";
	public static final String DIRECTION = "direction";
	public static final String EXTREMITY = "extremity";
	public static final String SOURCE = "source";
	public static final String TARGET = "target";

	static {

	}

	/**
	 * Select query for properties. <br>
	 * Bindables:
	 * <ul>
	 * <li>{@link #OWNER}</li>
	 * <li>{@link #KEY}</li>
	 * <li>{@link #VALUE}</li>
	 * </ul>
	 * Selected:
	 * <ul>
	 * <li>{@link #OWNER}</li>
	 * <li>{@link #KEY}</li>
	 * <li>{@link #VALUE}</li>
	 * </ul>
	 * 
	 * @param context
	 *            Containing {@link Resource}, or <code>null</code>.
	 * @return Query.
	 */
	public static String buildPropertySelectQuery(final Resource context) {
		final SPARQLStringBuilder queryBuilder = new SPARQLStringBuilder(new StringBuilder());
		queryBuilder.prefix(ReqVoc.NS);
		queryBuilder.prefix(RDF.NS);
		queryBuilder.prefix(RDFS.NS);
		queryBuilder.select(KEY, VALUE, OWNER);
		if (context != null) {
			queryBuilder.from(context);
		}
		queryBuilder.append("WHERE {");
		queryBuilder.statement(OWNER, ReqVoc.HAS_PROPERTY, "prop");
		queryBuilder.statement("prop", RDFS.LABEL, KEY);
		queryBuilder.statement("prop", RDF.VALUE, VALUE);
		queryBuilder.append("}");

		return queryBuilder.toString();
	}

	/**
	 * Delete query for properties. <br>
	 * Bindables:
	 * <ul>
	 * <li>{@link #OWNER}</li>
	 * <li>{@link #KEY}</li>
	 * </ul>
	 * 
	 * @param context
	 *            Containing {@link Resource}, or <code>null</code>.
	 * @return Update query.
	 */
	public static String buildPropertyDeleteQuery(final Resource context) {
		final SPARQLStringBuilder queryBuilder = new SPARQLStringBuilder(new StringBuilder());
		queryBuilder.prefix(ReqVoc.NS);
		queryBuilder.prefix(RDF.NS);
		queryBuilder.prefix(RDFS.NS);

		queryBuilder.append("DELETE ");
		if (context != null) {
			queryBuilder.from(context);
		}
		queryBuilder.append("{ ");
		queryBuilder.statement(OWNER, ReqVoc.HAS_PROPERTY, "prop");
		queryBuilder.statement("prop", RDFS.LABEL, KEY);
		queryBuilder.statement("prop", RDF.VALUE, VALUE);
		queryBuilder.append("} WHERE {");
		queryBuilder.statement(OWNER, ReqVoc.HAS_PROPERTY, "prop");
		queryBuilder.statement("prop", RDFS.LABEL, KEY);
		queryBuilder.append("}");

		return queryBuilder.toString();
	}

	/**
	 * Select query for links. <br>
	 * Bindables:
	 * <ul>
	 * <li>{@link #LINK}</li>
	 * <li>{@link #KIND}</li>
	 * <li>{@link #DIRECTION}</li>
	 * <li>{@link #EXTREMITY}</li>
	 * </ul>
	 * Selected:
	 * <ul>
	 * <li>{@link #LINK}</li>
	 * <li>{@link #KIND}</li>
	 * <li>{@link #DIRECTION}</li>
	 * <li>{@link #EXTREMITY}</li>
	 * </ul>
	 * 
	 * @param context
	 *            Containing {@link Resource}, or <code>null</code>.
	 * @return Query.
	 */
	public static String buildLinkSelectQuery(final Resource context) {
		final SPARQLStringBuilder queryBuilder = new SPARQLStringBuilder(new StringBuilder());
		queryBuilder.prefix(ReqVoc.NS);
		queryBuilder.prefix(RDF.NS);
		queryBuilder.select(LINK, KIND, DIRECTION, EXTREMITY);
		if (context != null) {
			queryBuilder.from(context);
		}
		queryBuilder.append("WHERE {");
		queryBuilder.statement(LINK, RDF.TYPE, ReqVoc.TYPE_TRACEABILITY);
		queryBuilder.statement(EXTREMITY, RDF.TYPE, ReqVoc.TYPE_TRACEABLE);
		queryBuilder.statement(EXTREMITY, RDF.TYPE, ReqVoc.TYPE_TRACEABLE);
		queryBuilder.statement(LINK, ReqVoc.HAS_KIND, KIND);
		queryBuilder.statement(LINK, DIRECTION, EXTREMITY);
		queryBuilder.append("}");

		return queryBuilder.toString();
	}

	/**
	 * Select query for links. <br>
	 * Bindables:
	 * <ul>
	 * <li>{@link #LINK}</li>
	 * <li>{@link #KIND}</li>
	 * <li>{@link #SOURCE}</li>
	 * <li>{@link #TARGET}</li>
	 * </ul>
	 * Selected:
	 * <ul>
	 * <li>{@link #LINK}</li>
	 * <li>{@link #KIND}</li>
	 * <li>{@link #SOURCE}</li>
	 * <li>{@link #TARGET}</li>
	 * </ul>
	 * 
	 * @param context
	 *            Containing {@link Resource}, or <code>null</code>.
	 * @return Query.
	 */
	public static String buildLinkSelectQuery2(final Resource context) {
		final SPARQLStringBuilder queryBuilder = new SPARQLStringBuilder(new StringBuilder());
		queryBuilder.prefix(ReqVoc.NS);
		queryBuilder.prefix(RDF.NS);
		queryBuilder.select(LINK, SOURCE, TARGET, KIND);
		if (context != null) {
			queryBuilder.from(context);
		}
		queryBuilder.append("WHERE {");
		queryBuilder.statement(LINK, RDF.TYPE, ReqVoc.TYPE_TRACEABILITY);
		queryBuilder.statement(SOURCE, RDF.TYPE, ReqVoc.TYPE_TRACEABLE);
		queryBuilder.statement(TARGET, RDF.TYPE, ReqVoc.TYPE_TRACEABLE);
		queryBuilder.statement(LINK, ReqVoc.HAS_KIND, KIND);
		queryBuilder.statement(LINK, ReqVoc.HAS_DOWNSTREAM, SOURCE);
		queryBuilder.statement(LINK, ReqVoc.HAS_UPSTREAM, TARGET);

		queryBuilder.append("}");

		return queryBuilder.toString();
	}

	private Queries() {
		super();
	}

}
