/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Olivier Melois (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.utils.collect;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.polarsys.reqcycle.utils.collect.collectors.DepthMeasuringHarvester;
import org.polarsys.reqcycle.utils.collect.yieldadapters.ThreadedYieldAdapter;

public class ZigguratCollectPlugin implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		ZigguratCollectPlugin.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		ZigguratCollectPlugin.context = null;
	}

	/**
	 * Method used to get to create a dependency list out of pickers. A DepthMeasuringHarvester is used to iterate other elements, and the depth is computed while the elements are iterated on. In the end, a list of dependencies is retrieved from the
	 * harvester.
	 * 
	 * if A.getNext() = [B,C,D] then B,C,D are deeper than A and A depends on B,C,D.
	 * 
	 * @return a list going from the deepest element, to the most shallow.
	 */
	public static <T> List<T> getDependencyList(T startingElement, Picker<T> picker) {
		@SuppressWarnings("unchecked")
		DepthMeasuringHarvester<T> harvester = new DepthMeasuringHarvester<T>(startingElement, Collections.singleton(picker));
		Iterable<T> iterable = new ThreadedYieldAdapter<T>().adapt(harvester);
		Iterator<T> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			// Do nothing, just going through the iterator
			iterator.next();
		}
		return harvester.getElementsFromDeepest();
	}

}
