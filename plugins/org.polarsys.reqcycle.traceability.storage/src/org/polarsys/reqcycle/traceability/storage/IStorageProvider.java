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
package org.polarsys.reqcycle.traceability.storage;

import org.eclipse.core.resources.IProject;
import org.polarsys.reqcycle.uri.model.Reachable;

public interface IStorageProvider {
	/**
	 * Returns a storage able to store traceability information
	 * 
	 * @param path
	 * @return
	 */
	ITraceabilityStorage getStorage(String path);

	/**
	 * @param project
	 *            The target project.
	 * @return A storage able to store explicit traceability links for a
	 *         project.
	 */
	ITraceabilityStorage getProjectStorage(IProject project);

	/**
	 * Gets a {@link ITraceabilityStorage} that can be used to read/update an
	 * explicit link.
	 * 
	 * @param reachable
	 *            Id of the explicit link.
	 * @return {@link ITraceabilityStorage} object.
	 * @throws NoProjectStorageException
	 *             Thrown when the link id is not a valid explicit link id.
	 */
	ITraceabilityStorage getProjectStorageFromLinkId(Reachable reachable) throws NoProjectStorageException;

	void notifyChanged(String event, Object data);
}
