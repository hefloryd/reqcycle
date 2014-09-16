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
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openrdf.model.Resource;
import org.openrdf.model.URI;
import org.openrdf.model.Value;
import org.openrdf.model.ValueFactory;
import org.openrdf.query.BindingSet;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.polarsys.reqcycle.traceability.engine.ITraceabilityEngine.DIRECTION;
import org.polarsys.reqcycle.traceability.model.Link;
import org.polarsys.reqcycle.traceability.model.TType;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.internal.beans.LinkRef;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.rdf.Queries;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.rdf.ReqVoc;
import org.polarsys.reqcycle.uri.model.Reachable;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class LinksStorageHelper {

	private final RepositoryConnection conn;
	private final ValueFactory valueFactory;
	private final StorageHelpersProvider helpers;

	LinksStorageHelper(final RepositoryConnection conn, final StorageHelpersProvider storageHelpersProvider) {
		super();
		this.conn = conn;
		this.valueFactory = conn.getValueFactory();
		this.helpers = storageHelpersProvider;
	}

	/**
	 * @param direction
	 *            Direction of a link (can be {@link DIRECTION#UPWARD} or {@link DIRECTION#DOWNWARD}).
	 * @return {@link URI} of the corresponding predicate.
	 *         <ul>
	 *         <li> {@link ReqVoc#HAS_DOWNSTREAM} if the direction is {@link DIRECTION#UPWARD}.</li>
	 *         <li>{@link ReqVoc#HAS_UPSTREAM} if the direction is {@link DIRECTION#UPWARD}.</li>
	 *         <li><code>null</code> if the direction is <code>null</code>.</li>
	 *         </ul>
	 */
	public static URI getDirectionPredicate(final DIRECTION direction) {
		final URI extremityPredicate;
		if (direction == DIRECTION.UPWARD) {
			extremityPredicate = ReqVoc.HAS_DOWNSTREAM;
		} else if (direction == DIRECTION.DOWNWARD) {
			extremityPredicate = ReqVoc.HAS_UPSTREAM;
		} else {
			extremityPredicate = null;
		}
		return extremityPredicate;
	}

	/**
	 * Add or updates a new link.
	 * 
	 * @param traceability
	 *            The traceability id {@link Reachable} object.
	 * @param ttype
	 *            The {@link TType} of the traceability.
	 * @param downstream
	 *            The downstream {@link Reachable}.
	 * @param upstreams
	 *            The upstream {@link Reachable}s.
	 * @param container
	 *            The container.
	 * @return The link {@link URI}.
	 * @throws RepositoryException
	 *             on error.
	 * @throws URISyntaxException
	 *             on error.
	 */
	public URI storeLink(Reachable traceability, TType ttype, Reachable downstream, Reachable[] upstreams, Reachable container) throws RepositoryException, URISyntaxException {
		final ReachablesStorageHelper reachablesStorageHelper = helpers.getReachablesStorageHelper();

		final Reachable kind = helpers.getKindsStorageHelper().toReachable(ttype);

		final Resource[] contexts;
		if (container != null) {
			final URI contextUri = ReachablesStorageHelper.getURI(container);
			contexts = new Resource[] { contextUri };
		} else {
			contexts = new Resource[0];
		}

		final URI sourceUri = reachablesStorageHelper.storeReachable(downstream, ReqVoc.TYPE_TRACEABLE, contexts);
		final URI linkUri = reachablesStorageHelper.storeReachable(traceability, ReqVoc.TYPE_TRACEABILITY, contexts);
		final URI kindUri = reachablesStorageHelper.storeReachable(kind, ReqVoc.TYPE_TTYPE, contexts);

		conn.add(linkUri, ReqVoc.HAS_DOWNSTREAM, sourceUri, contexts);
		conn.add(linkUri, ReqVoc.HAS_KIND, kindUri, contexts);

		for (final Reachable upstream : upstreams) {
			final URI targetUri = reachablesStorageHelper.storeReachable(upstream, ReqVoc.TYPE_TRACEABLE, contexts);
			conn.add(linkUri, ReqVoc.HAS_UPSTREAM, targetUri, contexts);
		}

		return linkUri;
	}

	/**
	 * List of links that have the element <code>extremity</code> as source or target (depending on the value of <code>direction</code>).
	 * 
	 * @param conn
	 *            A valid {@link RepositoryConnection} object.
	 * @param direction
	 *            Relationship direction, if <code>null</code> both directions are taken into account.
	 * @param extremity
	 *            The element in the extremity, if <code>null</code> all links will be retrieved.
	 * @param context
	 *            A containing resource, or <code>null</code>.
	 * @return List of {@link LinkRef} that references selected links.
	 * @throws RepositoryException
	 *             on error.
	 * @throws MalformedQueryException
	 *             on error.
	 * @throws QueryEvaluationException
	 *             on error.
	 */
	public Collection<LinkRef> getStoredLinkRefsByExtremity(final URI direction, final URI extremity, final Resource context) throws RepositoryException, MalformedQueryException, QueryEvaluationException {

		final String queryString = Queries.buildLinkSelectQuery(context);
		final TupleQuery query = this.conn.prepareTupleQuery(QueryLanguage.SPARQL, queryString);

		if (direction != null) {
			query.setBinding(Queries.DIRECTION, direction);
		}
		if (extremity != null) {
			query.setBinding(Queries.EXTREMITY, extremity);
		}

		final TupleQueryResult result = query.evaluate();

		final Set<LinkRef> list = new HashSet<LinkRef>();
		while (result.hasNext()) {
			final BindingSet binding = result.next();
			final Value link = binding.getValue(Queries.LINK);
			final Value kind = binding.getValue(Queries.KIND);
			final Value directionValue = binding.getValue(Queries.DIRECTION);
			if (link != null && kind != null) {
				final URI linkURI = this.valueFactory.createURI(link.stringValue());
				final URI kindURI = this.valueFactory.createURI(kind.stringValue());
				final DIRECTION linkDirection;
				if (ReqVoc.HAS_DOWNSTREAM.equals(directionValue)) {
					linkDirection = DIRECTION.UPWARD;
				} else {
					linkDirection = DIRECTION.DOWNWARD;
				}
				list.add(new LinkRef(linkURI, kindURI, linkDirection));
			}
		}

		return list;
	}

	/**
	 * Find extremities of a link.
	 * 
	 * @param conn
	 *            A valid {@link RepositoryConnection} object.
	 * @param direction
	 *            Relationship direction, if <code>null</code> both directions are taken into account.
	 * @param link
	 *            Link identifier.
	 * @param context
	 *            A containing resource, or <code>null</code>.
	 * @return List of {@link URI} that represents the selected objects.
	 * @throws RepositoryException
	 *             on error.
	 * @throws MalformedQueryException
	 *             on error.
	 * @throws QueryEvaluationException
	 *             on error.
	 */
	public Collection<URI> getStoredLinkExtremities(final URI direction, final URI link, final Resource context) throws RepositoryException, MalformedQueryException, QueryEvaluationException {

		final String queryString = Queries.buildLinkSelectQuery(context);
		final TupleQuery query = this.conn.prepareTupleQuery(QueryLanguage.SPARQL, queryString);

		if (link != null) {
			query.setBinding(Queries.LINK, link);
		}
		if (direction != null) {
			query.setBinding(Queries.DIRECTION, direction);
		}

		final TupleQueryResult result = query.evaluate();

		final List<URI> list = new LinkedList<URI>();
		while (result.hasNext()) {
			final BindingSet binding = result.next();
			final Value element = binding.getValue(Queries.EXTREMITY);
			if (element != null) {
				final URI elementURI = this.valueFactory.createURI(element.stringValue());
				list.add(elementURI);
			}
		}

		return list;
	}

	/**
	 * Gets a stored {@link Link} object.
	 * 
	 * @param conn
	 *            A valid {@link RepositoryConnection}.
	 * @param linkRef
	 *            A {@link LinkRef} object.
	 * @param context
	 *            containing resource, or <code>null</code>.
	 * @return The {@link Link} object.
	 * @throws RepositoryException
	 *             on error.
	 * @throws MalformedQueryException
	 *             on error.
	 * @throws QueryEvaluationException
	 *             on error.
	 * @throws URISyntaxException
	 *             on error.
	 */
	public Link getStoredLinkFromRef(final LinkRef linkRef, final Resource context) throws RepositoryException, MalformedQueryException, QueryEvaluationException, URISyntaxException {
		final URI linkUri = linkRef.getId();
		final URI kindUri = linkRef.getKind();

		final Reachable linkReachable = this.helpers.getReachablesStorageHelper().getStoredReachable(this.conn, linkUri, context);
		final Reachable kindReachable = this.helpers.getReachablesStorageHelper().getStoredReachable(this.conn, kindUri, context);
		final TType kind = this.helpers.getKindsStorageHelper().toTType(kindReachable);

		final Collection<URI> downstreamsUris = this.getStoredLinkExtremities(ReqVoc.HAS_DOWNSTREAM, linkUri, context);
		final List<Reachable> downstreams = new LinkedList<Reachable>();
		for (final URI uri : downstreamsUris) {
			final Reachable reachable = this.helpers.getReachablesStorageHelper().getStoredReachable(this.conn, uri, context);
			downstreams.add(reachable);
		}

		final Collection<URI> upstreamsUris = this.getStoredLinkExtremities(ReqVoc.HAS_UPSTREAM, linkUri, context);
		final List<Reachable> upstreams = new LinkedList<Reachable>();
		for (final URI uri : upstreamsUris) {
			final Reachable reachable = this.helpers.getReachablesStorageHelper().getStoredReachable(this.conn, uri, context);
			upstreams.add(reachable);
		}

		final Collection<Reachable> sources;
		final Collection<Reachable> targets;

		if (linkRef.getDirection() == DIRECTION.UPWARD) {
			sources = downstreams;
			targets = upstreams;
		} else {
			sources = upstreams;
			targets = downstreams;
		}

		return new Link(linkReachable, kind, sources, targets);
	}

	/**
	 * Removes stored links from the repository if it match some criteria.
	 * 
	 * @param kindUri
	 *            The {@link TType} of the links to remove (can be <code>null</code> to ignore this field in filtering).
	 * @param downwstreamUri
	 *            The downstream side of the links to remove (can be <code>null</code> to ignore this field in filtering).
	 * @param containerUri
	 *            The container of the links to remove (can be <code>null</code> to ignore this field in filtering).
	 * @param upstreams
	 *            The upstream side of links to remove.
	 * @throws RepositoryException
	 *             on error.
	 * @throws MalformedQueryException
	 *             on error.
	 * @throws QueryEvaluationException
	 *             on error.
	 */
	public void removeStoredLinks(final URI kindUri, final URI downwstreamUri, final URI containerUri, final Collection<Value> upstreams) throws RepositoryException, MalformedQueryException, QueryEvaluationException {
		final String strquery = Queries.buildLinkSelectQuery2(containerUri);

		final TupleQuery query = conn.prepareTupleQuery(QueryLanguage.SPARQL, strquery);
		if (kindUri != null) {
			query.setBinding(Queries.KIND, kindUri);
		}
		if (downwstreamUri != null) {
			query.setBinding(Queries.SOURCE, downwstreamUri);
		}

		final Multimap<Value, Value> multimap = HashMultimap.create();
		final TupleQueryResult queryResult = query.evaluate();
		while (queryResult.hasNext()) {
			final BindingSet binding = queryResult.next();
			final Value linkValue = binding.getBinding(Queries.LINK).getValue();
			final Value targetValue = binding.getBinding(Queries.TARGET).getValue();
			multimap.put(linkValue, targetValue);
		}

		for (final Value linkValue : multimap.keySet()) {
			final Collection<Value> linkedTargets = multimap.get(linkValue);
			final boolean allTargetShouldBeRemoved = upstreams.containsAll(linkedTargets);

			final URI linkUri = valueFactory.createURI(linkValue.stringValue());
			if (allTargetShouldBeRemoved) {
				conn.remove(linkUri, null, null, containerUri);
			} else {
				for (final Value targetValue : upstreams) {
					final URI targetUri = valueFactory.createURI(targetValue.stringValue());
					conn.remove(linkUri, ReqVoc.HAS_UPSTREAM, targetUri, containerUri);
				}
			}
		}
	}
}
