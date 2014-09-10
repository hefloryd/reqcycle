/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.repository.data.types;

import java.util.Collection;

/**
 * The Interface DataModel.
 */
public interface IDataModel {

	/**
	 * Gets the name.
	 * 
	 * @return the data model name
	 */
	public String getName();

	public int getVersion();

	/**
	 * Adds the requirement type.
	 * 
	 * @param type
	 *            the requirement type to add
	 */
	public void addType(IType type);

	public void removeType(IType type);

	/**
	 * Gets the requirement type.
	 * 
	 * @param name
	 *            the requirement type name
	 * @return the requirement type
	 */
	public IType getType(String name);

	/**
	 * Gets the requirement types.
	 * 
	 * @return the requirement types
	 */
	public Collection<IType> getTypes();

	/**
	 * Gets the data model uri.
	 * 
	 * @return the data model uri
	 */
	public String getDataModelURI();

}
