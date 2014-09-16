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

import java.io.File;
import java.util.concurrent.ExecutionException;

import javax.inject.Singleton;

import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.sail.nativerdf.NativeStore;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Singleton
public class SesameRepositoryHolder {

	private static final String REPOSITORY_FOLDER = "/binary";

	private LoadingCache<String, Repository> repositories;
	private LoadingCache<String, ThreadLocal<RepositoryConnection>> connections;

	public SesameRepositoryHolder() {
		repositories = CacheBuilder.newBuilder().build(new InitRepositoryCallable());
		connections = CacheBuilder.newBuilder().build(new ThreadLocalConnectionsBuilderCallable());
	}

	public Repository getRepository(final String path) throws ExecutionException {
		return repositories.get(path);
	}

	public RepositoryConnection getConnection(final String path) throws RepositoryException, ExecutionException {
		ThreadLocal<RepositoryConnection> connectionsThreadLocal = connections.get(path);
		RepositoryConnection connection = connectionsThreadLocal.get();
		if (connection == null || !connection.isOpen()) {
			final Repository repository = getRepository(path);
			connection = repository.getConnection();
			connectionsThreadLocal.set(connection);
		}

		return connection;
	}

	private static final class InitRepositoryCallable extends CacheLoader<String, Repository> {
		@Override
		public Repository load(String path) throws RepositoryException {
			final NativeStore store = new NativeStore(new File(path + REPOSITORY_FOLDER));
			final Repository repository = new SailRepository(store);
			repository.initialize();
			return repository;
		}
	}

	private static final class ThreadLocalConnectionsBuilderCallable extends CacheLoader<String, ThreadLocal<RepositoryConnection>> {
		@Override
		public ThreadLocal<RepositoryConnection> load(String path) {
			return new ThreadLocal<RepositoryConnection>();
		}
	}
}