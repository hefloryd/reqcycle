/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.extenders;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.polarsys.reqcycle.traceability.model.TType;
import org.polarsys.reqcycle.traceability.utils.SerializationUtils;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.services.IReachableExtender;

/**
 * {@link IReachableExtender} to use for {@link TType} objects.
 * 
 * @author rsemlal
 */
public class TTypeExtender implements IReachableExtender {

	/**
	 * Id of the property that stores the value of {@link TType#getId()} in the {@link Reachable}.
	 */
	public static final String PROPERTY_ID = "id";

	/**
	 * Id of the property that stores the serialized value of the {@link TType} instance in the {@link Reachable}.
	 */
	public static final String PROPERTY_DATA = "data";

	/**
	 * Id of the property that stores the value of {@link TType#getLabel()} in the {@link Reachable}.
	 */
	public static final String PROPERTY_LABEL = "label";

	/**
	 * @param reachable
	 *            {@link Reachable} of {@link TType}.
	 * @return The {@link TType} id (the result of {@link TType#getId()}) from its reachable, or <code>null</code> on error.
	 */
	public static String getId(final Reachable reachable) {
		return reachable.get(TTypeExtender.PROPERTY_ID);
	}

	/**
	 * @param reachable
	 *            {@link Reachable} of {@link TType}.
	 * @return The {@link TType} label (the result of {@link TType#getLabel()}) from its reachable, or <code>null</code> on error.
	 */
	public static String getLabel(final Reachable reachable) {
		return reachable.get(TTypeExtender.PROPERTY_LABEL);
	}

	/**
	 * @param reachable
	 *            {@link Reachable} of {@link TType}.
	 * @return The {@link TType} serialized string representation from its reachable, or <code>null</code> on error.
	 */
	public static String getData(final Reachable reachable) {
		return reachable.get(TTypeExtender.PROPERTY_DATA);
	}

	public TTypeExtender() {
		super();
	}

	@Override
	public Map<String, String> getExtendedProperties(final URI uri, final Object originalObject) {
		final Map<String, String> map = new HashMap<String, String>();

		if (originalObject != null && originalObject instanceof TType) {
			final TType ttype = (TType) originalObject;

			map.put(PROPERTY_ID, ttype.getId());
			map.put(PROPERTY_LABEL, ttype.getLabel());
			map.put(PROPERTY_DATA, SerializationUtils.serialize(ttype));
		}

		return map;
	}

	@Override
	public boolean handles(final URI uri, final Object object) {
		return object != null && object instanceof TType;
	}

}
