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

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.openrdf.OpenRDFException;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.polarsys.reqcycle.traceability.storage.IOneFileStorageProvider;
import org.polarsys.reqcycle.traceability.storage.IStorageProvider;
import org.polarsys.reqcycle.traceability.storage.ITraceabilityStorage;
import org.polarsys.reqcycle.traceability.storage.NoProjectStorageException;
import org.polarsys.reqcycle.traceability.storage.sesame.exceptions.SesameStorageRuntimeException;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.repositoryholders.SesameBinaryRepositoryHolder;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.repositoryholders.SesameXMLRepositoryHolder;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.savetriggers.DummySaveTrigger;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.savetriggers.ISaveTrigger;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.model.ReachableObject;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class SesameStorageProvider implements IStorageProvider, IOneFileStorageProvider {

	@Inject
	private IEventBroker broker;

	@Inject
	private SesameBinaryRepositoryHolder binaryRepositoryHolder;
	@Inject
	private SesameXMLRepositoryHolder xmlRepositoryHolder;

	@Inject
	protected IReachableManager manager;

	public SesameStorageProvider() {
		super();
	}

	@Override
	public ITraceabilityStorage getStorage(final String path) {
		try {
			final RepositoryConnection connection = binaryRepositoryHolder.getConnection(path);
			final ISaveTrigger saveTrigger = binaryRepositoryHolder.getSaveTrigger(path);

			final ITraceabilityStorage traceabilityStorage = new SesameTraceabilityStorage(this, path, connection, saveTrigger);
			ZigguratInject.inject(traceabilityStorage);
			return traceabilityStorage;
		} catch (final RepositoryException e) {
			throw new SesameStorageRuntimeException("Error initializing storage repository", e);
		} catch (final ExecutionException e) {
			throw new SesameStorageRuntimeException("Error initializing storage repository", e);
		}
	}

	@Override
	public ITraceabilityStorage getStorageReader(final InputStream inputStream) {
		try {
			final RepositoryConnection connection = xmlRepositoryHolder.getConnection(inputStream);
			return new SesameTraceabilityStorage(this, "", connection, new DummySaveTrigger());
		} catch (final OpenRDFException e) {
			throw new SesameStorageRuntimeException("Error initializing storage repository", e);
		} catch (final IOException e) {
			throw new SesameStorageRuntimeException("Error initializing storage repository", e);
		} catch (ExecutionException e) {
			throw new SesameStorageRuntimeException("Error initializing storage repository", e);
		}
	}

	@Override
	public ITraceabilityStorage getProjectStorage(final IProject project) {
		try {
			final RepositoryConnection connection = xmlRepositoryHolder.getConnection(project);
			final ISaveTrigger saveTrigger = xmlRepositoryHolder.getSaveTrigger(project);
			final String pathUri = xmlRepositoryHolder.getTargetFile(project).toURI().toString();
			SesameTraceabilityStorage sesameTraceabilityStorage = new SesameTraceabilityStorage(this, pathUri, connection, saveTrigger);
			ZigguratInject.inject(sesameTraceabilityStorage);
			return sesameTraceabilityStorage;
		} catch (final RepositoryException e) {
			throw new SesameStorageRuntimeException("Error initializing storage repository", e);
		} catch (ExecutionException e) {
			throw new SesameStorageRuntimeException("Error initializing storage repository", e);
		}
	}

	@Override
	public void notifyChanged(final String event, final Object data) {
		this.broker.post(event, data);
	}

	@Override
	public ITraceabilityStorage getProjectStorageFromLinkId(final Reachable reachable) throws NoProjectStorageException {
		try {
			final ReachableObject object = manager.getHandlerFromReachable(reachable).getFromReachable(reachable);

			if (object != null) {
				final IFile adapted = (IFile) object.getAdapter(IFile.class);
				if (adapted != null) {
					final IProject p = adapted.getProject();
					return getProjectStorage(p);
				}
			}
		} catch (final IReachableHandlerException e) {
			throw new NoProjectStorageException(e);
		}

		throw new NoProjectStorageException("Unable to create project storage from reachable");
	}

}
