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
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.runtime.CoreException;
import org.openrdf.OpenRDFException;
import org.openrdf.model.Resource;
import org.openrdf.model.URI;
import org.openrdf.model.Value;
import org.openrdf.model.ValueFactory;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.UpdateExecutionException;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.polarsys.reqcycle.traceability.engine.ITraceabilityEngine.DIRECTION;
import org.polarsys.reqcycle.traceability.model.Link;
import org.polarsys.reqcycle.traceability.model.Pair;
import org.polarsys.reqcycle.traceability.model.TType;
import org.polarsys.reqcycle.traceability.storage.IStorageProvider;
import org.polarsys.reqcycle.traceability.storage.ITraceabilityStorage;
import org.polarsys.reqcycle.traceability.storage.ITraceabilityStorageTopics;
import org.polarsys.reqcycle.traceability.storage.sesame.exceptions.SesameStorageRuntimeException;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.helpers.KindStorageHelper;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.helpers.LinksStorageHelper;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.helpers.ReachablesStorageHelper;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.helpers.StorageHelpersProvider;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.internal.beans.LinkRef;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.savetriggers.ISaveTrigger;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.utils.Reachable2StorageURIFunction;
import org.polarsys.reqcycle.uri.IReachableCreator;
import org.polarsys.reqcycle.uri.model.Reachable;

import com.google.common.collect.Collections2;

public class SesameTraceabilityStorage implements ITraceabilityStorage {

	private final String path;
	private final ISaveTrigger saveTrigger;
	private final RepositoryConnection connection;
	private StorageHelpersProvider helpers;
	private final IStorageProvider provider;

	@Inject
	IReachableCreator creator;

	public SesameTraceabilityStorage(final IStorageProvider provider, final String path, final RepositoryConnection connection, final ISaveTrigger saveTrigger) {
		super();
		this.provider = provider;
		this.path = path;
		this.connection = connection;
		this.saveTrigger = saveTrigger;
		this.helpers = new StorageHelpersProvider(connection);
	}

	private Iterable<Pair<Link, Reachable>> retrieveTraceability(final DIRECTION direction, final URI extremityValue, final Resource context) throws MalformedQueryException, QueryEvaluationException, URISyntaxException, RepositoryException {

		final URI extremityPredicate = LinksStorageHelper.getDirectionPredicate(direction);

		final List<Pair<Link, Reachable>> result = new LinkedList<Pair<Link, Reachable>>();

		final Collection<LinkRef> linkRefs = this.helpers.getLinksStorageHelper().getStoredLinkRefsByExtremity(extremityPredicate, extremityValue, context);

		for (final LinkRef linkRef : linkRefs) {
			final Link link = this.helpers.getLinksStorageHelper().getStoredLinkFromRef(linkRef, context);

			for (final Reachable r : link.getTargets()) {
				final Pair<Link, Reachable> pair = new Pair<Link, Reachable>(link, r);
				result.add(pair);
			}
		}

		return result;
	}

	@Override
	public String getPath() {
		return this.path;
	}

	@Override
	public void dispose() {
		this.provider.notifyChanged(ITraceabilityStorageTopics.DISPOSE, this);

		try {
			connection.close();
		} catch (final RepositoryException e) {
			throw new SesameStorageRuntimeException("Failed to release sesame connection", e);
		}

	}

	@Override
	public void startTransaction() {
		try {
			if (!this.connection.isActive()) {
				this.connection.begin();
			}
		} catch (final RepositoryException e) {
			throw new SesameStorageRuntimeException("Failed to start transaction", e);
		}
	}

	@Override
	public void commit() {
		try {
			this.connection.commit();
			this.provider.notifyChanged(ITraceabilityStorageTopics.COMMIT, this);
		} catch (final RepositoryException e) {
			throw new SesameStorageRuntimeException("Failed to commit current transaction", e);
		}
	}

	@Override
	public void save() {
		try {
			if (saveTrigger != null) {
				this.saveTrigger.doSave(connection);
			}
			this.provider.notifyChanged(ITraceabilityStorageTopics.SAVE, this);
		} catch (final RepositoryException e) {
			throw new SesameStorageRuntimeException("Failed to save current state", e);
		} catch (final OpenRDFException e) {
			throw new SesameStorageRuntimeException("Failed to save current state", e);
		} catch (final IOException e) {
			throw new SesameStorageRuntimeException("Failed to save current state", e);
		} catch (CoreException e) {
			throw new SesameStorageRuntimeException("Failed to save current state", e);
		}

	}

	@Override
	public void rollback() {
		try {
			this.connection.rollback();
		} catch (final RepositoryException e) {
			throw new SesameStorageRuntimeException("Failed to perform a rollback on the current transaction", e);
		}
	}

	@Override
	public void clearInContainer(final Reachable container) {
		try {
			final URI uri = ReachablesStorageHelper.getURI(container);

			this.connection.clear(uri);
		} catch (final RepositoryException e) {
			throw new SesameStorageRuntimeException("Failed to remove all statements in container " + container, e);
		}
	}

	@Override
	public void addOrUpdateUpwardRelationShip(final TType ttype, final Reachable traceaReachable, final Reachable container, final Reachable source, final Reachable... targets) {
		try {
			if (targets != null && targets.length > 0) {
				this.helpers.getLinksStorageHelper().storeLink(traceaReachable, ttype, source, targets, container);
			}

		} catch (final RepositoryException e) {
			throw new SesameStorageRuntimeException("Failed to add new relationship", e);
		} catch (final URISyntaxException e) {
			throw new SesameStorageRuntimeException("Failed to add new relationship", e);
		}
	}

	@Override
	public void removeTraceabilityLink(final Reachable r) {
		try {
			final URI traceaUri = ReachablesStorageHelper.getURI(r);
			this.connection.remove(traceaUri, null, null);
		} catch (final RepositoryException e) {
			throw new SesameStorageRuntimeException("Failed to commit current transaction", e);
		}
	}

	@Override
	public Reachable getReachable(final String strUri) {
		try {
			final ValueFactory valueFactory = this.connection.getValueFactory();
			final URI uri = valueFactory.createURI(strUri);

			return this.helpers.getReachablesStorageHelper().getStoredReachable(this.connection, uri, null);
		} catch (final URISyntaxException e) {
			throw new SesameStorageRuntimeException("Failed to create reachable ", e);
		} catch (final RepositoryException e) {
			throw new SesameStorageRuntimeException("Failed to create reachable ", e);
		} catch (final QueryEvaluationException e) {
			throw new SesameStorageRuntimeException("Failed to create reachable ", e);
		} catch (final MalformedQueryException e) {
			throw new SesameStorageRuntimeException("Failed to create reachable ", e);
		}
	}

	@Override
	public Iterable<Pair<Link, Reachable>> getTraceability(final Reachable reachable, final DIRECTION direction) {
		try {
			final URI reacheableUri = ReachablesStorageHelper.getURI(reachable);
			return this.retrieveTraceability(direction, reacheableUri, null);
		} catch (final MalformedQueryException e) {
			throw new SesameStorageRuntimeException("Failed to retrieve traceability links", e);
		} catch (final QueryEvaluationException e) {
			throw new SesameStorageRuntimeException("Failed to retrieve traceability links", e);
		} catch (final RepositoryException e) {
			throw new SesameStorageRuntimeException("Failed to retrieve traceability links", e);
		} catch (final URISyntaxException e) {
			throw new SesameStorageRuntimeException("Failed to retrieve traceability links", e);
		}
	}

	@Override
	public Iterable<Pair<Link, Reachable>> getAllTraceability(final DIRECTION direction) {
		try {
			return this.retrieveTraceability(direction, null, null);
		} catch (final MalformedQueryException e) {
			throw new SesameStorageRuntimeException("Failed to retrieve traceability links", e);
		} catch (final QueryEvaluationException e) {
			throw new SesameStorageRuntimeException("Failed to retrieve traceability links", e);
		} catch (final RepositoryException e) {
			throw new SesameStorageRuntimeException("Failed to retrieve traceability links", e);
		} catch (final URISyntaxException e) {
			throw new SesameStorageRuntimeException("Failed to retrieve traceability links", e);
		}
	}

	@Override
	public Iterable<Reachable> getTraceabilityLinksContainedIn(final Reachable reachable) {
		try {
			final URI context = ReachablesStorageHelper.getURI(reachable);

			final Collection<LinkRef> linkRefs = this.helpers.getLinksStorageHelper().getStoredLinkRefsByExtremity(null, null, context);

			final List<Reachable> result = new LinkedList<Reachable>();
			for (final LinkRef linkRef : linkRefs) {
				final URI uri = linkRef.getId();
				final Reachable storedReachable = this.helpers.getReachablesStorageHelper().getStoredReachable(this.connection, uri, context);

				result.add(storedReachable);
			}

			return result;
		} catch (final RepositoryException e) {
			throw new SesameStorageRuntimeException("Failed to retrieve traceability links", e);
		} catch (final QueryEvaluationException e) {
			throw new SesameStorageRuntimeException("Failed to retrieve traceability links", e);
		} catch (final MalformedQueryException e) {
			throw new SesameStorageRuntimeException("Failed to retrieve traceability links", e);
		} catch (final URISyntaxException e) {
			throw new SesameStorageRuntimeException("Failed to retrieve traceability links", e);
		}
	}

	@Override
	public void removeUpwardRelationShip(final TType kind, final Reachable container, final Reachable source, final Reachable... targets) {
		try {
			final URI kindUri = KindStorageHelper.getURI(kind.getId());
			final URI sourceUri = ReachablesStorageHelper.getURI(source);
			final URI containerUri = container != null ? ReachablesStorageHelper.getURI(container) : null;
			final Collection<Value> targetValues = Collections2.transform(Arrays.asList(targets), new Reachable2StorageURIFunction<Value>());

			this.helpers.getLinksStorageHelper().removeStoredLinks(kindUri, sourceUri, containerUri, targetValues);

		} catch (final RepositoryException e) {
			throw new SesameStorageRuntimeException("Failed to retreive traceability links", e);
		} catch (final MalformedQueryException e) {
			throw new SesameStorageRuntimeException("Failed to retreive traceability links", e);
		} catch (final QueryEvaluationException e) {
			throw new SesameStorageRuntimeException("Failed to retreive traceability links", e);
		}
	}

	@Override
	public void updateRelationShip(final Link oldLink, final Link newLink, final DIRECTION direction) {
		// FIXME This method is never used and must probably be deleted

	}

	@Override
	public void addUpdateProperty(final Reachable reachable, final String key, final String value) {
		try {
			final URI owner = ReachablesStorageHelper.getURI(reachable);

			this.helpers.getPropertiesStorageHelper().addOrUpdateProperty(owner, key, value);
		} catch (final RepositoryException e) {
			throw new SesameStorageRuntimeException("Failed to add or update property", e);
		}
	}

	@Override
	public void removeProperty(final Reachable reachable, final String key) {
		try {
			final URI owner = ReachablesStorageHelper.getURI(reachable);

			this.helpers.getPropertiesStorageHelper().deleteStoredProperty(owner, key, null);
		} catch (final RepositoryException e) {
			throw new SesameStorageRuntimeException("Failed to delete property: " + key, e);
		} catch (final UpdateExecutionException e) {
			throw new SesameStorageRuntimeException("Failed to delete property: " + key, e);
		} catch (final MalformedQueryException e) {
			throw new SesameStorageRuntimeException("Failed to delete property: " + key, e);
		}
	}

	@Override
	public String getProperty(final Reachable reachable, final String key) {
		try {
			final URI owner = ReachablesStorageHelper.getURI(reachable);

			return this.helpers.getPropertiesStorageHelper().getStoredProperty(owner, key, null);
		} catch (final RepositoryException e) {
			throw new SesameStorageRuntimeException("Failed to get property: " + key, e);
		} catch (final QueryEvaluationException e) {
			throw new SesameStorageRuntimeException("Failed to get property: " + key, e);
		} catch (final MalformedQueryException e) {
			throw new SesameStorageRuntimeException("Failed to get property: " + key, e);
		}
	}
}
