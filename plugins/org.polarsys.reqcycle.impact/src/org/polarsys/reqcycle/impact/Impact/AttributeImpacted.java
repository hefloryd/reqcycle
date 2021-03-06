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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Attribute Impacted</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.polarsys.reqcycle.impact.Impact.AttributeImpacted#getId <em>Id</em>}</li>
 * <li>{@link org.polarsys.reqcycle.impact.Impact.AttributeImpacted#getOldValue <em>Old Value</em>}</li>
 * <li>{@link org.polarsys.reqcycle.impact.Impact.AttributeImpacted#getNewValue <em>New Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage#getAttributeImpacted()
 * @model
 * @generated
 */
public interface AttributeImpacted extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage#getAttributeImpacted_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.impact.Impact.AttributeImpacted#getId <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Old Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Value</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Old Value</em>' attribute.
	 * @see #setOldValue(String)
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage#getAttributeImpacted_OldValue()
	 * @model required="true"
	 * @generated
	 */
	String getOldValue();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.impact.Impact.AttributeImpacted#getOldValue <em>Old Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Old Value</em>' attribute.
	 * @see #getOldValue()
	 * @generated
	 */
	void setOldValue(String value);

	/**
	 * Returns the value of the '<em><b>New Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Value</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>New Value</em>' attribute.
	 * @see #setNewValue(String)
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage#getAttributeImpacted_NewValue()
	 * @model required="true"
	 * @generated
	 */
	String getNewValue();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.impact.Impact.AttributeImpacted#getNewValue <em>New Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>New Value</em>' attribute.
	 * @see #getNewValue()
	 * @generated
	 */
	void setNewValue(String value);

} // AttributeImpacted
