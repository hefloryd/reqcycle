/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.uri.model;

public interface IReachableHandler extends IHandler {
	/**
	 * @param t
	 * @return
	 */
	ReachableObject getFromReachable(Reachable t);

	/**
	 * @param t
	 * @return
	 */
	boolean handlesReachable(Reachable t);

	/**
	 * 
	 * @return The type of {@link ProxyResolver} to use with {@link Reachable}s handled by this instance, <b>or <code>null</code> if no {@link ProxyResolver} available</b>.
	 */
	ProxyResolver getProxyResolver();
}
