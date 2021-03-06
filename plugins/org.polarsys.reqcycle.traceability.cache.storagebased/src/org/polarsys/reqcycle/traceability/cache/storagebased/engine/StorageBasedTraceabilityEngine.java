/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.cache.storagebased.engine;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.polarsys.reqcycle.core.ILogger;
import org.polarsys.reqcycle.traceability.cache.AbstractCachedTraceabilityEngine;
import org.polarsys.reqcycle.traceability.cache.Activator;
import org.polarsys.reqcycle.traceability.cache.storagebased.engine.pickers.GetTraceabilityPicker;
import org.polarsys.reqcycle.traceability.model.Link;
import org.polarsys.reqcycle.traceability.model.Pair;
import org.polarsys.reqcycle.traceability.model.StopCondition;
import org.polarsys.reqcycle.traceability.model.TType;
import org.polarsys.reqcycle.traceability.model.scopes.ResourceScope;
import org.polarsys.reqcycle.traceability.storage.IStorageProvider;
import org.polarsys.reqcycle.traceability.storage.ITraceabilityStorage;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.model.IReachableHandler;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.model.ReachableObject;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;
import org.polarsys.reqcycle.utils.iterators.exceptions.PickerExecutionException;
import org.polarsys.reqcycle.utils.iterators.factories.IteratorFactory;
import org.polarsys.reqcycle.utils.iterators.pickers.IPicker;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import static com.google.common.collect.Iterables.filter;

@Singleton
public class StorageBasedTraceabilityEngine extends AbstractCachedTraceabilityEngine {

	public static final String REVISION = "revisionProperty";
	private Map<Reachable, String> inMemoryRevision = Maps.newHashMap();
	@Inject
	ILogger logger;

	@Inject
	IStorageProvider storageEngine;

	ITraceabilityStorage storage;

	private boolean isDebugging;

	@Override
	protected void environmentClosed() {
		if (isDebugging) {
			logger.trace("Storage is closing");
		}
		storage.save();
//		storage.dispose();
		if (isDebugging) {
			logger.trace("Storage closed, saved : " + getCachePath());
		}
	}

	@PostConstruct
	public void postConstruct() {
		isDebugging = logger.isDebug(Activator.OPTIONS_DEBUG, Activator.getDefault());
		if (isDebugging) {
			logger.trace("Storage Initialization");
		}
		storage = storageEngine.getStorage(getCachePath());
		if (isDebugging) {
			logger.trace("Storage is initialized");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Iterator<Pair<Link, Reachable>> doGetTraceability(Reachable source, DIRECTION direction, Predicate<Pair<Link, Reachable>> scope) {
		IPicker picker = new GetTraceabilityPicker(direction, storage, scope);
		ZigguratInject.inject(picker);
		IPicker[] pickers = new IPicker[] { picker };
		IteratorFactory factory = new IteratorFactory(Arrays.asList(pickers));
		factory.activateDepthWisdom();
		factory.activateRedundancyAwareness();
		Iterator<Object> iterator = factory.createIterable(source).iterator();
		iterator.next();
		List<Pair<Link, Reachable>> list = Lists.newArrayList(Iterators.transform(iterator, new Function<Object, Pair<Link, Reachable>>() {
			public Pair<Link, Reachable> apply(Object o) {
				return (Pair<Link, Reachable>) o;
			}
		}));
		return list.iterator();
	}

	@Override
	protected Iterator<Pair<Link, Reachable>> doGetOneLevelTraceability(Reachable source, DIRECTION direction, Predicate<Pair<Link, Reachable>> scope) {
		IPicker picker = new GetTraceabilityPicker(direction, storage, scope);
		Iterable<?> nexts;
		try {
			nexts = picker.getNexts(source);
			Iterator<Pair<Link, Reachable>> iterator = Iterators.transform(nexts.iterator(), new Function<Object, Pair<Link, Reachable>>() {
				public Pair<Link, Reachable> apply(Object o) {
					return (Pair<Link, Reachable>) o;
				}
			});
			return iterator;
		} catch (PickerExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Iterators.emptyIterator();
	}

	@Override
	protected Iterator<Pair<Link, Reachable>> doGetTraceability(Reachable source, StopCondition condition, DIRECTION direction, Predicate<Pair<Link, Reachable>> scope) {
		Set<Pair<Link, Reachable>> result = new LinkedHashSet<Pair<Link, Reachable>>();
		Set<Reachable> visited = new HashSet<Reachable>();
		if (source != null && condition != null) {
			IPicker picker = new GetTraceabilityPicker(direction, storage, scope);
			ZigguratInject.inject(picker);
			result.addAll(search(source, condition, picker, visited));
		}
		return result.iterator();
	}

	/**
	 * Search if one path exist between source and node satisfying the condition
	 * 
	 * @param source
	 *            the reachable source
	 * @param condition
	 *            the stopping condition
	 * @param picker
	 *            used to determine next of current element
	 * @param visited
	 *            the elements already visited to prevent cycles
	 * @param mapForOrder
	 *            use to not add double entries and improve the contains
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<? extends Pair<Link, Reachable>> search(Reachable source, StopCondition condition, IPicker picker, Set<Reachable> visited) {
		List<Pair<Link, Reachable>> result = new LinkedList<Pair<Link, Reachable>>();
		if (!visited.contains(source)) {
			visited.add(source);
			try {
				Iterable<?> nexts = picker.getNexts(source);
				for (Object o : nexts) {
					if (o instanceof Pair) {
						Pair<Link, Reachable> pair = (Pair<Link, Reachable>) o;
						if (condition.apply(pair)) {
							result.add(pair);
						}
					}
				}
				for (Object o : nexts) {
					if (o instanceof Pair) {
						Pair<Link, Reachable> pair = (Pair<Link, Reachable>) o;
						Collection<? extends Pair<Link, Reachable>> tmp = search(pair.getSecond(), condition, picker, visited);
						if (!tmp.isEmpty()) {
							result.add(pair);
							result.addAll(tmp);
						}
					}
				}
			} catch (PickerExecutionException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	protected Iterable<Reachable> getEntriesFor(Reachable reachable) {
		return storage.getTraceabilityLinksContainedIn(reachable);
	}

	@Override
	protected void tagDeletedRelationShips(Iterable<Link> linksToTag) {

	}

	@Override
	public Iterable<Link> getLinksForTraceable(Reachable reachable) {
		return null;
	}

	@Override
	protected boolean isCacheOk(Reachable reachable) {
		if (reachable == null){
			return false;
		}
		String uri = ResourceScope.getURIPath(reachable.trimFragment());
		if (uri == null) {
			return false;
		}
		Reachable trimmedFragment = reachable.trimFragment();
		String revisionOfObject = null;
		try {
			IReachableHandler handler = manager.getHandlerFromReachable(reachable);
			ReachableObject object = handler.getFromReachable(reachable);
			if (object != null) {
				// NULL means the object can not identify its revision
				// so the cache must be computed each time
				revisionOfObject = object.getRevisionIdentification();
			}
		} catch (IReachableHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String revision = inMemoryRevision.get(trimmedFragment);
		if (revision == null) {
			Reachable fromStorage = storage.getReachable(trimmedFragment.toString());
			if (fromStorage != null) {
				revision = fromStorage.get(REVISION);
				inMemoryRevision.put(trimmedFragment, revision);
			}
		}
		if (revision != null && revisionOfObject != null) {
			return revision.equals(revisionOfObject);
		}
		return false;
	}

	@Override
	public void newUpwardRelation(Reachable traceaReachable, Reachable container, Reachable source, List<Reachable> targets, TType tType) {
		handleRevision(container);
		storage.addOrUpdateUpwardRelationShip(tType, traceaReachable, container, source, targets.toArray(new Reachable[targets.size()]));
	}

	private void handleRevision(Reachable container) {
		String val = container.get(OPTION_CHECK_CACHE);
		if (val == null || Boolean.TRUE.equals(val)) {
			IReachableHandler uriHandler = null;
			try {
				uriHandler = manager.getHandlerFromReachable(container);
				ReachableObject object = uriHandler.getFromReachable(container);
				if (object != null) {
					String revision = object.getRevisionIdentification();
					container.put(REVISION, revision);
					inMemoryRevision.put(container, revision);
				}
			} catch (IReachableHandlerException e) {
				// TODO ERROR management ?
				e.printStackTrace();
			}
		}
	}

	@Override
	public void startBuild(Reachable reachable) {
		storage.startTransaction();
		storage.clearInContainer(reachable);
		super.startBuild(reachable);
	}

	@Override
	public void endBuild(Reachable reachable) {
		if (reachable == null){
			return ;
		}
		super.endBuild(reachable);
		handleRevision(reachable);
		String revision = reachable.get(REVISION);
		storage.addUpdateProperty(reachable, REVISION, revision);
		inMemoryRevision.put(reachable, revision);
		storage.commit();
	}

	@Override
	public void errorOccurs(Reachable reachable, Throwable t) {
		super.errorOccurs(reachable, t);
		storage.rollback();
	}

	@Override
	protected Iterator<Pair<Link, Reachable>> doGetAllTraceability(DIRECTION direction, Predicate<Pair<Link, Reachable>> requestPredicate) {
		return filter(storage.getAllTraceability(direction), requestPredicate).iterator();
	}

	@Override
	protected void removeTraceabilityLink(Reachable r) {
		storage.removeTraceabilityLink(r);
	}

}
