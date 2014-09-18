/**
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *   Malick Wade (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.inittypes.inittypes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.inittypes.inittypes.Requirement#getNameReq <em>Name Req</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.inittypes.inittypes.Requirement#getRegexReq <em>Regex Req</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.inittypes.inittypes.Requirement#getAttributesReq <em>Attributes Req</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.inittypes.inittypes.InittypesPackage#getRequirement()
 * @model
 * @generated
 */
public interface Requirement extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2014 AtoS\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n  Malick Wade (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * Returns the value of the '<em><b>Name Req</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name Req</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name Req</em>' attribute.
	 * @see #setNameReq(String)
	 * @see org.polarsys.reqcycle.inittypes.inittypes.InittypesPackage#getRequirement_NameReq()
	 * @model
	 * @generated
	 */
	String getNameReq();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.inittypes.inittypes.Requirement#getNameReq <em>Name Req</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Req</em>' attribute.
	 * @see #getNameReq()
	 * @generated
	 */
	void setNameReq(String value);

	/**
	 * Returns the value of the '<em><b>Regex Req</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regex Req</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regex Req</em>' containment reference.
	 * @see #setRegexReq(Regex)
	 * @see org.polarsys.reqcycle.inittypes.inittypes.InittypesPackage#getRequirement_RegexReq()
	 * @model containment="true"
	 * @generated
	 */
	Regex getRegexReq();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.inittypes.inittypes.Requirement#getRegexReq <em>Regex Req</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Regex Req</em>' containment reference.
	 * @see #getRegexReq()
	 * @generated
	 */
	void setRegexReq(Regex value);

	/**
	 * Returns the value of the '<em><b>Attributes Req</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.reqcycle.inittypes.inittypes.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes Req</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes Req</em>' containment reference list.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.InittypesPackage#getRequirement_AttributesReq()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getAttributesReq();

} // Requirement
