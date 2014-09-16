/**
 * Copyright (c) 2014 AtoS
 *     All rights reserved. This program and the accompanying materials
 *     are made available under the terms of the Eclipse Public License v1.0
 *     which accompanies this distribution, and is available at
 *     http://www.eclipse.org/legal/epl-v10.html *
 *     Contributors:
 *       Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.impact.Impact;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Requirement Impacted</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.polarsys.reqcycle.impact.Impact.RequirementImpacted#getId <em>Id</em>}</li>
 * <li>{@link org.polarsys.reqcycle.impact.Impact.RequirementImpacted#getLinkList <em>Link List</em>}</li>
 * <li>{@link org.polarsys.reqcycle.impact.Impact.RequirementImpacted#getAttributesImpacted <em>Attributes Impacted</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage#getRequirementImpacted()
 * @model
 * @generated
 */
public interface RequirementImpacted extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage#getRequirementImpacted_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.impact.Impact.RequirementImpacted#getId <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Link List</b></em>' containment reference list. The list contents are of type {@link org.polarsys.reqcycle.impact.Impact.TraceabilityLink}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link List</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Link List</em>' containment reference list.
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage#getRequirementImpacted_LinkList()
	 * @model containment="true"
	 * @generated
	 */
	EList<TraceabilityLink> getLinkList();

	/**
	 * Returns the value of the '<em><b>Attributes Impacted</b></em>' containment reference list. The list contents are of type {@link org.polarsys.reqcycle.impact.Impact.AttributeImpacted}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes Impacted</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Attributes Impacted</em>' containment reference list.
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage#getRequirementImpacted_AttributesImpacted()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttributeImpacted> getAttributesImpacted();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	AttributeImpacted getImpactedAttribute(String attributeName);

} // RequirementImpacted
