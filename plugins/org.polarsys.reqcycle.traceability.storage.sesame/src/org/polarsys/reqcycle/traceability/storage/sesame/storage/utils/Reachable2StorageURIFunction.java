/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.storage.sesame.storage.utils;

import org.openrdf.model.URI;
import org.openrdf.model.Value;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.helpers.ReachablesStorageHelper;
import org.polarsys.reqcycle.uri.model.Reachable;

import com.google.common.base.Function;

/**
 * A transformation that return a {@link URI} object for a {@link Reachable}.
 * 
 * @author rsemlal
 * 
 * @param <T>
 *            Super-type of {@link URI} to return.
 */
public class Reachable2StorageURIFunction<T extends Value> implements Function<Reachable, T> {
	public Reachable2StorageURIFunction() {
		super();
	}

	@Override
	@SuppressWarnings("unchecked")
	public T apply(final Reachable reachable) {
		return (T) ReachablesStorageHelper.getURI(reachable);
	}
}