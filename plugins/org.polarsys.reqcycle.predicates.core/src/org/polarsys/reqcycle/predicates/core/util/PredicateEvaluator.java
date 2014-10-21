/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Papa Issa Diakhate (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.predicates.core.util;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import org.polarsys.reqcycle.predicates.core.IPredicateEvaluator;
import org.polarsys.reqcycle.predicates.core.api.IListeningPredicate;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.uri.IReachableListener;
import org.polarsys.reqcycle.uri.IReachableListenerManager;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.functions.Object2Reachable;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

@Singleton
public class PredicateEvaluator implements IPredicateEvaluator, IReachableListener {

	private static final Object2Reachable OBJECT2_REACHABLE = new Object2Reachable();

	static {
		ZigguratInject.inject(OBJECT2_REACHABLE);
	}

	IReachableListenerManager lManager = ZigguratInject.make(IReachableListenerManager.class);

	IReachableManager rManager = ZigguratInject.make(IReachableManager.class);

	Cache<Reachable, Map<String, Boolean>> cache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build();

	/**
	 * Know the children of a resource listened (the parent ares also listened)
	 */
	Multimap<Reachable, Reachable> resourceToChildren = HashMultimap.create();
	/**
	 * The binding between some objects listened and dependant ones
	 */
	Multimap<Reachable, Reachable> bindings = HashMultimap.create();

	@Override
	public boolean match(IPredicate p, Object input) {
		if (p == null) {
			return false;
		}
		Reachable r = null;
		if (input instanceof Reachable) {
			r = (Reachable) input;
		} else {
			try {
				r = rManager.getHandlerFromObject(input).getFromObject(input).getReachable();
			} catch (IReachableHandlerException e) {
			}
		}
		if (r != null) {
			final Reachable reachable = r;
			Map<String, Boolean> map;
			try {
				map = cache.get(r, new Callable<Map<String, Boolean>>() {
					@Override
					public Map<String, Boolean> call() throws Exception {
						Map<String, Boolean> result = Maps.newHashMap();
						listen(reachable);
						return result;
					}

				});
				Boolean result = map.get(p.getDisplayName());
				if (result == null) {
					result = p.match(input);
					if (p instanceof IListeningPredicate) {
						IListeningPredicate listening = (IListeningPredicate) p;
						for (Reachable toListen : Iterables.transform(listening.getObjectsToListen(), OBJECT2_REACHABLE)) {
							listen(toListen);
							bindings.put(toListen, r);
						}
					}
					map.put(p.getDisplayName(), result);
				}
				return result;
			} catch (ExecutionException e) {
				e.printStackTrace();
			}

		}

		return p.match(input);
	}

	private void listen(final Reachable reachable) {
		lManager.addReachableListener(reachable, PredicateEvaluator.this);
		lManager.addReachableListener(reachable.trimFragment(), PredicateEvaluator.this);
		resourceToChildren.put(reachable.trimFragment(), reachable);
	}

	@Override
	public void hasChanged(Reachable[] reachable) {
		for (Reachable r : reachable) {
			if (r.getFragment() == null || r.getFragment().length() == 0) {
				Collection<Reachable> list = resourceToChildren.get(r);
				for (Reachable child : list) {
					doHasChanged(child);
				}
				resourceToChildren.removeAll(r);
				lManager.removeReachableListener(this, r);
				cache.invalidate(r);
			} else {
				doHasChanged(r);
			}
		}
	}

	private void doHasChanged(Reachable r) {
		cache.invalidate(r);
		Collection<Reachable> fromBinding = bindings.get(r);
		if (fromBinding != null) {
			for (Reachable binded : fromBinding) {
				cache.invalidate(binded);
			}
			bindings.removeAll(r);
		}
		lManager.removeReachableListener(this, r);
	}

}
