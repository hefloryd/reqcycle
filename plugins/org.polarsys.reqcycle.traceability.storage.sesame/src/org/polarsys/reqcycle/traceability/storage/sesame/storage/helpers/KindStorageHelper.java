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

import javax.inject.Inject;

import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;
import org.openrdf.repository.RepositoryConnection;
import org.polarsys.reqcycle.traceability.extenders.TTypeExtender;
import org.polarsys.reqcycle.traceability.model.TType;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.rdf.ReqVoc;
import org.polarsys.reqcycle.traceability.utils.SerializationUtils;
import org.polarsys.reqcycle.uri.IReachableCreator;
import org.polarsys.reqcycle.uri.model.Reachable;

public class KindStorageHelper {
	private final static ValueFactory valueFactory = ValueFactoryImpl.getInstance();

	@Inject
	protected IReachableCreator creator;

	KindStorageHelper(final RepositoryConnection conn, final StorageHelpersProvider storageHelpersProvider) {
		super();
	}

	/**
	 * Create a valid {@link URI} for a {@link TType}.
	 * 
	 * @param id
	 *            Id of the {@link TType} object.
	 * @return The {@link URI} for the {@link TType} object.
	 */
	public static URI getURI(final String id) {
		// TODO escape id
		return valueFactory.createURI(ReqVoc.NAMESPACE, "ttype?id=" + id);
	}

	/**
	 * Returns the {@link TType} represented by a {@link Reachable} (if any).
	 * 
	 * @param reachable
	 *            The original {@link Reachable} object.
	 * @return The resulting {@link TType}, or <code>null</code> on error.
	 */
	public TType toTType(final Reachable reachable) {
		if (reachable == null) {
			return null;
		}

		final String serializedData = TTypeExtender.getData(reachable);
		return SerializationUtils.deserialize(serializedData);
	}

	/**
	 * Creates a {@link Reachable} that represents a {@link TType}.
	 * 
	 * @param ttype
	 *            The original {@link TType} object.
	 * @return The resulting {@link Reachable}.
	 * @throws URISyntaxException
	 *             on error.
	 */
	public Reachable toReachable(final TType ttype) throws URISyntaxException {
		final URI kindUri = KindStorageHelper.getURI(ttype.getId());
		final java.net.URI netUri = new java.net.URI(kindUri.stringValue());
		return this.creator.getReachable(netUri, ttype);
	}

}
