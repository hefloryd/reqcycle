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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Style</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.polarsys.reqcycle.styling.model.Styling.Style#getAppliedFonts <em>Applied Fonts</em>}</li>
 * <li>{@link org.polarsys.reqcycle.styling.model.Styling.Style#getColor <em>Color</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.styling.model.Styling.StylingPackage#getStyle()
 * @model
 * @generated
 */
public interface Style extends EObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String copyright = "Copyright (c) 2014 AtoS\r\n    All rights reserved. This program and the accompanying materials\r\n    are made available under the terms of the Eclipse Public License v1.0\r\n    which accompanies this distribution, and is available at\r\n    http://www.eclipse.org/legal/epl-v10.html *\r\n    Contributors:\r\n      Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * Returns the value of the '<em><b>Applied Fonts</b></em>' attribute list. The list contents are of type {@link org.polarsys.reqcycle.styling.model.Styling.FontOption}. The literals are from the enumeration
	 * {@link org.polarsys.reqcycle.styling.model.Styling.FontOption}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied Fonts</em>' attribute list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Applied Fonts</em>' attribute list.
	 * @see org.polarsys.reqcycle.styling.model.Styling.FontOption
	 * @see org.polarsys.reqcycle.styling.model.Styling.StylingPackage#getStyle_AppliedFonts()
	 * @model
	 * @generated
	 */
	EList<FontOption> getAppliedFonts();

	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see #setColor(String)
	 * @see org.polarsys.reqcycle.styling.model.Styling.StylingPackage#getStyle_Color()
	 * @model
	 * @generated
	 */
	String getColor();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.styling.model.Styling.Style#getColor <em>Color</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Color</em>' attribute.
	 * @see #getColor()
	 * @generated
	 */
	void setColor(String value);

} // Style
