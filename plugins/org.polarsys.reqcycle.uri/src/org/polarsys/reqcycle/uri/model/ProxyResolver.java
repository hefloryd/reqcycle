/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
package org.polarsys.reqcycle.uri.model;

/**
 * Service that expose a method to resolve proxy objects when registering
 * traceability links.
 * 
 * @author rsemlal
 */
public interface ProxyResolver {
	/**
	 * Resolve an object.
	 * 
	 * @param obj
	 *            Original object to resolve.
	 * @return A new resolved instance if the original object was a proxy, or a
	 *         reference to the same original object elsewhere.
	 */
	Object resolve(Object obj);

	/**
	 * Release resources, must be called after usage.
	 */
	void dispose();
}
