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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.inittypes.inittypes.Attribute#getNameAttribute <em>Name Attribute</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.inittypes.inittypes.Attribute#getRegexAttribute <em>Regex Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.inittypes.inittypes.InittypesPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2014 AtoS\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n  Malick Wade (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * Returns the value of the '<em><b>Name Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name Attribute</em>' attribute.
	 * @see #setNameAttribute(String)
	 * @see org.polarsys.reqcycle.inittypes.inittypes.InittypesPackage#getAttribute_NameAttribute()
	 * @model
	 * @generated
	 */
	String getNameAttribute();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.inittypes.inittypes.Attribute#getNameAttribute <em>Name Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Attribute</em>' attribute.
	 * @see #getNameAttribute()
	 * @generated
	 */
	void setNameAttribute(String value);

	/**
	 * Returns the value of the '<em><b>Regex Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regex Attribute</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regex Attribute</em>' containment reference.
	 * @see #setRegexAttribute(Regex)
	 * @see org.polarsys.reqcycle.inittypes.inittypes.InittypesPackage#getAttribute_RegexAttribute()
	 * @model containment="true"
	 * @generated
	 */
	Regex getRegexAttribute();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.inittypes.inittypes.Attribute#getRegexAttribute <em>Regex Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Regex Attribute</em>' containment reference.
	 * @see #getRegexAttribute()
	 * @generated
	 */
	void setRegexAttribute(Regex value);

} // Attribute
