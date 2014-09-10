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

import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;

/**
 * The Interface RequirementType.
 */
public interface IRequirementType extends IType {

	/**
	 * Gets the attributes.
	 * 
	 * @return the requirement types attributes
	 */
	public Collection<IAttribute> getAttributes();

	/**
	 * Adds the attribute type.
	 * 
	 * @param type
	 *            the attribute type
	 */
	public void addAttribute(IAttribute att);

	public void removeAttribute(IAttribute att);

	/**
	 * Creates an instance.
	 * 
	 * @return requirement element
	 */
	public Requirement createInstance();

	public IDataModel getDataModel();
}
