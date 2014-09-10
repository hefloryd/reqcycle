/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.storage.sesame.storage.helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openrdf.model.Resource;
import org.openrdf.model.URI;
import org.openrdf.model.Value;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;
import org.openrdf.model.vocabulary.RDF;
import org.openrdf.model.vocabulary.RDFS;
import org.openrdf.model.vocabulary.XMLSchema;
import org.openrdf.query.BindingSet;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.query.Update;
import org.openrdf.query.UpdateExecutionException;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.rdf.Queries;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.rdf.ReqVoc;
import org.polarsys.reqcycle.uri.model.Reachable;

public class PropertiesStorageHelper {

	private final static ValueFactory valueFactory = ValueFactoryImpl.getInstance();
	private final RepositoryConnection conn;

	PropertiesStorageHelper(final RepositoryConnection conn, final StorageHelpersProvider storageHelpersProvider) {
		super();
		this.conn = conn;
	}

	/**
	 * @param owner
	 *            {@link URI} of the object that owns the property.
	 * @param name
	 *            Name of the property.
	 * @return The {@link URI} for the property.
	 */
	public static URI getURI(final URI owner, final String name) {
		final String url = owner.stringValue();
		final StringBuilder builder = new StringBuilder(url);
		if (url.contains("?")) {
			builder.append('&');
		} else {
			builder.append('?');
		}
		builder.append("prop=");
		builder.append(name); // TODO escape name
		return valueFactory.createURI(builder.toString());
	}

	/**
	 * Store a property.
	 * 
	 * @param conn
	 *            {@link RepositoryConnection} to use for storing data.
	 * @param owner
	 *            The owner of the property.
	 * @param key
	 *            The property's name.
	 * @param value
	 *            The property's value.
	 * @param contexts
	 *            The containing contexts.
	 * @return The {@link URI} of the stored property.
	 * @throws RepositoryException
	 *             Error.
	 */
	public URI storeProperty(final URI owner, final String key, final String value, final Resource... contexts)
			throws RepositoryException {
		final URI propUri = getURI(owner, key);

		this.conn.add(owner, ReqVoc.HAS_PROPERTY, propUri, contexts);
		this.conn.add(propUri, RDFS.LABEL, valueFactory.createLiteral(key, XMLSchema.STRING), contexts);
		this.conn.add(propUri, RDF.VALUE, valueFactory.createLiteral(value, XMLSchema.STRING), contexts);

		return propUri;
	}

	public URI addOrUpdateProperty(final URI owner, final String key, final String value, final Resource... contexts)
			throws RepositoryException {
		final URI propUri = getURI(owner, key);

		this.conn.add(owner, ReqVoc.HAS_PROPERTY, propUri, contexts);
		this.conn.add(propUri, RDFS.LABEL, valueFactory.createLiteral(key, XMLSchema.STRING), contexts);
		if(this.conn.hasStatement(propUri, RDF.VALUE, null, false, contexts)) {
			this.conn.remove(propUri, RDF.VALUE, null, contexts);
		}
		this.conn.add(propUri, RDF.VALUE, valueFactory.createLiteral(value, XMLSchema.STRING), contexts);

		return propUri;
	}

	/**
	 * Retrieves a stored property value.
	 * 
	 * @param conn
	 *            {@link RepositoryConnection} to use for storing data.
	 * @param owner
	 *            The owner of the property.
	 * @param key
	 *            The property's name.
	 * @param context
	 *            The containing context (or <code>null</code> for all of them).
	 * @return The retrieved value or <code>null</code> if no property
	 *         associated.
	 * @throws RepositoryException
	 *             on error.
	 * @throws QueryEvaluationException
	 *             on error.
	 * @throws MalformedQueryException
	 *             on error.
	 */
	public String getStoredProperty(final URI owner, final String key, final Resource context) throws RepositoryException,
			QueryEvaluationException, MalformedQueryException {

		final String queryString = Queries.buildPropertySelectQuery(context);
		final TupleQuery query = this.conn.prepareTupleQuery(QueryLanguage.SPARQL, queryString);

		query.setBinding(Queries.OWNER, owner);
		query.setBinding(Queries.KEY, valueFactory.createLiteral(key, XMLSchema.STRING));

		final TupleQueryResult result = query.evaluate();

		String ret = null;
		while (result.hasNext()) { // Le dernier en date sera pris
			final BindingSet binding = result.next();
			final Value value = binding.getValue(Queries.VALUE);
			if (value != null) {
				ret = value.stringValue();
			}
		}

		return ret;
	}

	/**
	 * Deletes a stored property.
	 *
	 * @param conn
	 * @param owner
	 *            The owner of the property.
	 * @param key
	 *            The name of the property.
	 * @param context
	 *            Containing {@link Resource} or <code>null</code>.
	 * @throws UpdateExecutionException
	 *             on error.
	 * @throws MalformedQueryException
	 *             on error.
	 * @throws RepositoryException
	 *             on error.
	 */
	public void deleteStoredProperty(final URI owner, final String key, final Resource context) throws UpdateExecutionException,
			MalformedQueryException, RepositoryException {

		final String queryString = Queries.buildPropertyDeleteQuery(context);
		final Update query = this.conn.prepareUpdate(QueryLanguage.SPARQL, queryString);

		query.setBinding(Queries.OWNER, owner);
		query.setBinding(Queries.KEY, valueFactory.createLiteral(key, XMLSchema.STRING));

		query.execute();
	}

	/**
	 * Store a set of {@link Reachable} properties.
	 * 
	 * @param conn
	 *            Connection to use for adding statements.
	 * @param owner
	 *            {@link URI} of the owner (stored {@link Reachable}).
	 * @param props
	 *            {@link Map} that contains properties key-value pairs.
	 * @param contexts
	 *            Containing resources.
	 * @throws RepositoryException
	 *             on error.
	 */
	public void storeProperties(final URI owner, final Map<String, String> props, final Resource... contexts)
			throws RepositoryException {

		for (final Entry<String, String> entry : props.entrySet()) {
			final String key = entry.getKey();
			final String value = entry.getValue();

			this.storeProperty(owner, key, value, contexts);
		}
	}

	/**
	 * @param conn
	 *            A valid {@link RepositoryConnection} object.
	 * @param uri
	 *            {@link URI} of the stored {@link Reachable}.
	 * @param context
	 *            The containing {@link Resource} or <code>null</code> to grab
	 *            properties from all contexts.
	 * @return A {@link Map} object containing the key-value pairs of the stored
	 *         {@link Reachable} properties.
	 * @throws RepositoryException
	 *             When error occured.
	 * @throws QueryEvaluationException
	 *             When error occured.
	 * @throws MalformedQueryException
	 *             When error occured.
	 */
	public Map<String, String> getStoredProperties(final URI owner, final Resource context) throws RepositoryException,
			QueryEvaluationException, MalformedQueryException {
		final String queryString = Queries.buildPropertySelectQuery(context);
		final TupleQuery query = this.conn.prepareTupleQuery(QueryLanguage.SPARQL, queryString);

		query.setBinding(Queries.OWNER, owner);

		final TupleQueryResult result = query.evaluate();

		final Map<String, String> map = new HashMap<String, String>();
		while (result.hasNext()) {
			final BindingSet binding = result.next();
			final Value key = binding.getValue(Queries.KEY);
			final Value value = binding.getValue(Queries.VALUE);
			if (key != null && value != null) {
				map.put(key.stringValue(), value.stringValue());
			}
		}

		return map;
	}
}
