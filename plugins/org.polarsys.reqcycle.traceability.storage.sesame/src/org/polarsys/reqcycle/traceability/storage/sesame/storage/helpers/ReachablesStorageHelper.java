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

import java.net.URISyntaxException;
import java.util.Map;

import javax.inject.Inject;

import org.openrdf.model.Resource;
import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;
import org.openrdf.model.vocabulary.RDF;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.polarsys.reqcycle.uri.IReachableCreator;
import org.polarsys.reqcycle.uri.model.Reachable;

public class ReachablesStorageHelper {
	private final RepositoryConnection conn;
	private final StorageHelpersProvider helpers;

	private final static ValueFactory valueFactory = ValueFactoryImpl.getInstance();

	@Inject
	protected IReachableCreator creator;

	ReachablesStorageHelper(final RepositoryConnection conn, final StorageHelpersProvider storageHelpersProvider) {
		super();
		this.conn = conn;
		this.helpers = storageHelpersProvider;
	}

	/**
	 * Gets a {@link URI} object for a {@link Reachable}.
	 * 
	 * @param reachable
	 *            The original {@link Reachable}.
	 * @return A {@link URI}.
	 */
	public static URI getURI(final Reachable reachable) {
		if (reachable == null){
			return null;
		}
		return valueFactory.createURI(reachable.getURI().toString());
	}

	/**
	 * Stores a {@link Reachable}.
	 * 
	 * @param conn
	 *            Connection to use for accessing the repository.
	 * @param reachable
	 *            The reachable to store.
	 * @param type
	 *            Type of reachable to store.
	 * @param contexts
	 *            Containing resources.
	 * @return The {@link URI} of the stored reachable.
	 * @throws RepositoryException
	 *             on error.
	 */
	public URI storeReachable(final Reachable reachable, final URI type, final Resource... contexts) throws RepositoryException {
		final URI uri = getURI(reachable);

		this.conn.add(uri, RDF.TYPE, type, contexts);
		this.helpers.getPropertiesStorageHelper().storeProperties(uri, reachable.getProperties(), contexts);

		return uri;
	}

	/**
	 * Loads a stored {@link Reachable}.
	 * 
	 * @param conn
	 *            Connection to use for accessing the repository.
	 * @param uri
	 *            URI of the reachable to load.
	 * @param context
	 *            Containing resource, or <code>null</code>.
	 * @return The {@link URI} of the stored reachable.
	 * @throws RepositoryException
	 *             on error.
	 * @throws URISyntaxException
	 *             on error.
	 * @throws MalformedQueryException
	 *             on error.
	 * @throws QueryEvaluationException
	 *             on error.
	 */
	public Reachable getStoredReachable(final RepositoryConnection conn, final URI uri, final Resource context) throws RepositoryException, URISyntaxException, QueryEvaluationException, MalformedQueryException {
		final Reachable reachable = this.creator.getReachable(new java.net.URI(uri.stringValue()));

		final Map<String, String> props = this.helpers.getPropertiesStorageHelper().getStoredProperties(uri, context);
		reachable.putAll(props);

		return reachable;
	}

}
