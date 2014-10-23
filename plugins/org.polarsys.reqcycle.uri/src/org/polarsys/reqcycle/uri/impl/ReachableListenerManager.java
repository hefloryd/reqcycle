/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.uri.impl;

import java.util.Arrays;
import java.util.Collection;

import javax.inject.Singleton;

import org.polarsys.reqcycle.uri.IReachableListener;
import org.polarsys.reqcycle.uri.IReachableListenerManager;
import org.polarsys.reqcycle.uri.model.Reachable;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

@Singleton
public class ReachableListenerManager implements IReachableListenerManager {

	Multimap<Reachable, IReachableListener> mapReachableToListener = HashMultimap.create();
	Multimap<IReachableListener, Reachable> mapListenerToReachable = HashMultimap.create();
	boolean preventReentrant = false;

	@Override
	public void addReachableListener(Reachable reachable, IReachableListener listener) {
		put(mapReachableToListener, mapListenerToReachable, reachable, listener);
	}

	public <X, Y> void put(Multimap<X, Y> map, Multimap<Y, X> map2, X reachable, Y listener) {
		map.put(reachable, listener);
		map2.put(listener, reachable);
	}

	public <X, Y> void remove(Multimap<X, Y> map, Multimap<Y, X> map2, X reachable, Y listener) {
		map.remove(reachable, listener);
		map2.remove(listener, reachable);
	}

	@Override
	public synchronized void removeReachableListener(IReachableListener listener) {
		Collection<Reachable> reachables = mapListenerToReachable.removeAll(listener);
		for (Reachable r : reachables) {
			mapReachableToListener.remove(r, listener);
		}
	}

	@Override
	public synchronized void notifyChanged(final Reachable[] reachables) {
		if (!preventReentrant){
			preventReentrant = true;
			final Collection<IReachableListener> collection = Sets.newHashSet();
			final Reachable[] copy = Arrays.copyOf(reachables, reachables.length);
			for (Reachable r : reachables) {
				collection.addAll(mapReachableToListener.get(r));
			}
			IReachableListener[] array = collection.toArray(new IReachableListener[collection.size()]);
			for (int i = 0; i < array.length; i++) {
				array[i].hasChanged(filter(copy, mapListenerToReachable.get(array[i])));
			}
		}
		preventReentrant = false;

	}

	private Reachable[] filter(Reachable[] reachables, Collection<Reachable> collection) {
		Collection<Reachable> result = Sets.newHashSet();
		Collection<Reachable> collection2 = Sets.newHashSet(collection);
		for (Reachable r : reachables) {
			if (collection2.contains(r)) {
				result.add(r);
			}
		}
		return result.toArray(new Reachable[] {});
	}

	@Override
	public synchronized void removeReachableListener(IReachableListener listener, Reachable reachable) {
		remove(mapReachableToListener, mapListenerToReachable, reachable, listener);
	}
}
