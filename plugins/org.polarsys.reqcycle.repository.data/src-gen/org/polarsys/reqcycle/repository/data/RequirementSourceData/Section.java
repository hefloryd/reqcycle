/**
 * Copyright (c) 2013 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *   Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.repository.data.RequirementSourceData;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Section</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.polarsys.reqcycle.repository.data.RequirementSourceData.Section#getChildren
 * <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataPackage#getSection()
 * @model
 * @generated
 */
public interface Section extends AbstractElement {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement}
	 * . <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataPackage#getSection_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractElement> getChildren();

} // Section
