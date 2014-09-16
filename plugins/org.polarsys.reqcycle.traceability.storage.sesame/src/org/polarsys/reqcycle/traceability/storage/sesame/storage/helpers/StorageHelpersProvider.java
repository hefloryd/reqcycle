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

import org.openrdf.repository.RepositoryConnection;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class StorageHelpersProvider {

	private final RepositoryConnection connection;
	private final PropertiesStorageHelper propertiesStorageHelper;
	private final LinksStorageHelper linksStorageHelper;
	private final ReachablesStorageHelper reachablesStorageHelper;
	private final KindStorageHelper kindsStorageHelper;

	public StorageHelpersProvider(final RepositoryConnection conn) {
		this.connection = conn;
		this.propertiesStorageHelper = new PropertiesStorageHelper(conn, this);
		this.linksStorageHelper = new LinksStorageHelper(conn, this);
		this.reachablesStorageHelper = new ReachablesStorageHelper(conn, this);
		this.kindsStorageHelper = new KindStorageHelper(conn, this);

		ZigguratInject.inject(this.propertiesStorageHelper);
		ZigguratInject.inject(this.linksStorageHelper);
		ZigguratInject.inject(this.reachablesStorageHelper);
		ZigguratInject.inject(this.kindsStorageHelper);
	}

	/**
	 * @return The {@link RepositoryConnection} used by the helpers.
	 */
	public final RepositoryConnection getConnection() {
		return this.connection;
	}

	/**
	 * @return the reachablesStorageHelper
	 */
	public final ReachablesStorageHelper getReachablesStorageHelper() {
		return this.reachablesStorageHelper;
	}

	/**
	 * @return the propertiesStorageHelper
	 */
	public final PropertiesStorageHelper getPropertiesStorageHelper() {
		return this.propertiesStorageHelper;
	}

	/**
	 * @return the linksStorageHelper
	 */
	public final LinksStorageHelper getLinksStorageHelper() {
		return this.linksStorageHelper;
	}

	/**
	 * @return the kindsStorageHelper
	 */
	public final KindStorageHelper getKindsStorageHelper() {
		return kindsStorageHelper;
	}

}
