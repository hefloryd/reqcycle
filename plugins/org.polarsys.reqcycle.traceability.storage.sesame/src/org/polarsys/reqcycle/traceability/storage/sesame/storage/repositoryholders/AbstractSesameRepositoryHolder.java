/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.storage.sesame.storage.repositoryholders;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.openrdf.OpenRDFException;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.savetriggers.ISaveTrigger;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public abstract class AbstractSesameRepositoryHolder<T> {

	protected LoadingCache<T, Repository> repositories;
	protected final LoadingCache<T, ThreadLocal<RepositoryConnection>> connections;

	public AbstractSesameRepositoryHolder() {
		super();

		repositories = CacheBuilder.newBuilder().build(new InitRepositoryCallable());
		connections = CacheBuilder.newBuilder().build(new ThreadLocalConnectionsBuilderCallable());
	}

	public Repository getRepository(final T project) throws ExecutionException {
		return repositories.get(project);
	}

	public RepositoryConnection getConnection(final T project) throws RepositoryException, ExecutionException {
		ThreadLocal<RepositoryConnection> connectionsThreadLocal = connections.get(project);
		RepositoryConnection connection = connectionsThreadLocal.get();
		if (connection == null || !connection.isOpen()) {
			final Repository repository = getRepository(project);
			connection = repository.getConnection();
			connectionsThreadLocal.set(connection);
		}

		return connection;
	}

	protected abstract Repository initRepository(T key) throws IOException, OpenRDFException;

	public abstract ISaveTrigger getSaveTrigger(T key) throws RepositoryException;

	private final class InitRepositoryCallable extends CacheLoader<T, Repository> {
		@Override
		public Repository load(T key) throws IOException, OpenRDFException {
			return initRepository(key);
		}
	}

	private final class ThreadLocalConnectionsBuilderCallable extends CacheLoader<T, ThreadLocal<RepositoryConnection>> {
		@Override
		public ThreadLocal<RepositoryConnection> load(T key) {
			return new ThreadLocal<RepositoryConnection>();
		}
	}

}