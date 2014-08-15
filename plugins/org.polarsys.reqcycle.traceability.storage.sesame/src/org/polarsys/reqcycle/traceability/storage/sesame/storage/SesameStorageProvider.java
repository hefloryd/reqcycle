/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.storage.sesame.storage;

import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.polarsys.reqcycle.traceability.storage.IStorageProvider;
import org.polarsys.reqcycle.traceability.storage.ITraceabilityStorage;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class SesameStorageProvider implements IStorageProvider {
	@Inject
	protected IEventBroker broker;

	@Inject
	protected SesameRepositoryHolder repositoryHolder;

	public SesameStorageProvider() {
		super();
	}

	@Override
	public ITraceabilityStorage getStorage(final String path) {
		try {
			RepositoryConnection connection = repositoryHolder.getConnection(path);

			final ITraceabilityStorage traceabilityStorage = new SesameTraceabilityStorage(this, path, connection);
			ZigguratInject.inject(traceabilityStorage);
			return traceabilityStorage;
		} catch (RepositoryException e) {
			throw new SesameStorageRuntimeException("Error initializing storage repository", e);
		} catch (ExecutionException e) {
			throw new SesameStorageRuntimeException("Error initializing storage repository", e);
		}
	}

	@Override
	public void notifyChanged(final String event, final Object data) {
		this.broker.post(event, data);
	}

}
