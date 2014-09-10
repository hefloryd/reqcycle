/**
 * Copyright (c) 2014 AtoS
 *     All rights reserved. This program and the accompanying materials
 *     are made available under the terms of the Eclipse Public License v1.0
 *     which accompanies this distribution, and is available at
 *     http://www.eclipse.org/legal/epl-v10.html *
 *     Contributors:
 *       Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.styling.model.Styling;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.styling.model.Styling.StylingModel#getStyles <em>Styles</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.styling.model.Styling.StylingModel#getModeName <em>Mode Name</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.styling.model.Styling.StylingModel#getDefault <em>Default</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.styling.model.Styling.StylingModel#getBasic <em>Basic</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.styling.model.Styling.StylingPackage#getStylingModel()
 * @model
 * @generated
 */
public interface StylingModel extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2014 AtoS\r\n    All rights reserved. This program and the accompanying materials\r\n    are made available under the terms of the Eclipse Public License v1.0\r\n    which accompanies this distribution, and is available at\r\n    http://www.eclipse.org/legal/epl-v10.html *\r\n    Contributors:\r\n      Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * Returns the value of the '<em><b>Styles</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.reqcycle.styling.model.Styling.CaseStyle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Styles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Styles</em>' containment reference list.
	 * @see org.polarsys.reqcycle.styling.model.Styling.StylingPackage#getStylingModel_Styles()
	 * @model containment="true"
	 * @generated
	 */
	EList<CaseStyle> getStyles();

	/**
	 * Returns the value of the '<em><b>Mode Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode Name</em>' attribute.
	 * @see #setModeName(String)
	 * @see org.polarsys.reqcycle.styling.model.Styling.StylingPackage#getStylingModel_ModeName()
	 * @model
	 * @generated
	 */
	String getModeName();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.styling.model.Styling.StylingModel#getModeName <em>Mode Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode Name</em>' attribute.
	 * @see #getModeName()
	 * @generated
	 */
	void setModeName(String value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' containment reference.
	 * @see #setDefault(Default)
	 * @see org.polarsys.reqcycle.styling.model.Styling.StylingPackage#getStylingModel_Default()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Default getDefault();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.styling.model.Styling.StylingModel#getDefault <em>Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' containment reference.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(Default value);

	/**
	 * Returns the value of the '<em><b>Basic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basic</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basic</em>' containment reference.
	 * @see #setBasic(Basic)
	 * @see org.polarsys.reqcycle.styling.model.Styling.StylingPackage#getStylingModel_Basic()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Basic getBasic();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.styling.model.Styling.StylingModel#getBasic <em>Basic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basic</em>' containment reference.
	 * @see #getBasic()
	 * @generated
	 */
	void setBasic(Basic value);

} // StylingModel
