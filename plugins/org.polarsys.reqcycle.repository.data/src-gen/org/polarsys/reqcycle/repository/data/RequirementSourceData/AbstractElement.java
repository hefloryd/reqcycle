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

import org.eclipse.emf.ecore.EObject;

import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement#getId <em>Id</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement#getText <em>Text</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement#getUri <em>Uri</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement#getScopes <em>Scopes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataPackage#getAbstractElement()
 * @model abstract="true"
 * @generated
 */
public interface AbstractElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataPackage#getAbstractElement_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataPackage#getAbstractElement_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataPackage#getAbstractElement_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Scopes</b></em>' reference list.
	 * The list contents are of type {@link org.polarsys.reqcycle.repository.data.ScopeConf.Scope}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scopes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scopes</em>' reference list.
	 * @see org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataPackage#getAbstractElement_Scopes()
	 * @model
	 * @generated
	 */
	EList<Scope> getScopes();

} // AbstractElement
