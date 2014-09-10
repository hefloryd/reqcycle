/**
 * Copyright (c) 2013 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *   Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.repository.data.ScopeConf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Scope</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.repository.data.ScopeConf.Scope#getName <em>Name</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.repository.data.ScopeConf.Scope#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.repository.data.ScopeConf.Scope#getDataModelName <em>Data Model Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.repository.data.ScopeConf.ScopeConfPackage#getScope()
 * @model
 * @generated
 */
public interface Scope extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.polarsys.reqcycle.repository.data.ScopeConf.ScopeConfPackage#getScope_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.repository.data.ScopeConf.Scope#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Requirements</b></em>' reference list.
	 * The list contents are of type {@link org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirements</em>' reference list.
	 * @see #isSetRequirements()
	 * @see org.polarsys.reqcycle.repository.data.ScopeConf.ScopeConfPackage#getScope_Requirements()
	 * @model resolveProxies="false" unsettable="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<AbstractElement> getRequirements();

	/**
	 * Returns whether the value of the '{@link org.polarsys.reqcycle.repository.data.ScopeConf.Scope#getRequirements <em>Requirements</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Requirements</em>' reference list is set.
	 * @see #getRequirements()
	 * @generated
	 */
	boolean isSetRequirements();

	/**
	 * Returns the value of the '<em><b>Data Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Model Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Model Name</em>' attribute.
	 * @see #setDataModelName(String)
	 * @see org.polarsys.reqcycle.repository.data.ScopeConf.ScopeConfPackage#getScope_DataModelName()
	 * @model
	 * @generated
	 */
	String getDataModelName();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.repository.data.ScopeConf.Scope#getDataModelName <em>Data Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Model Name</em>' attribute.
	 * @see #getDataModelName()
	 * @generated
	 */
	void setDataModelName(String value);

} // Scope
