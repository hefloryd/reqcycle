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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Font Option</b></em>', and utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see org.polarsys.reqcycle.styling.model.Styling.StylingPackage#getFontOption()
 * @model
 * @generated
 */
public enum FontOption implements Enumerator {
	/**
	 * The '<em><b>ITALIC</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #ITALIC_VALUE
	 * @generated
	 * @ordered
	 */
	ITALIC(0, "ITALIC", "ITALIC"),

	/**
	 * The '<em><b>BOLD</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #BOLD_VALUE
	 * @generated
	 * @ordered
	 */
	BOLD(1, "BOLD", "BOLD"),

	/**
	 * The '<em><b>UNDERLINE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #UNDERLINE_VALUE
	 * @generated
	 * @ordered
	 */
	UNDERLINE(2, "UNDERLINE", "UNDERLINE"),

	/**
	 * The '<em><b>STRIKE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #STRIKE_VALUE
	 * @generated
	 * @ordered
	 */
	STRIKE(3, "STRIKE", "STRIKE");

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2014 AtoS\r\n    All rights reserved. This program and the accompanying materials\r\n    are made available under the terms of the Eclipse Public License v1.0\r\n    which accompanies this distribution, and is available at\r\n    http://www.eclipse.org/legal/epl-v10.html *\r\n    Contributors:\r\n      Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * The '<em><b>ITALIC</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ITALIC</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ITALIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ITALIC_VALUE = 0;

	/**
	 * The '<em><b>BOLD</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BOLD</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #BOLD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOLD_VALUE = 1;

	/**
	 * The '<em><b>UNDERLINE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNDERLINE</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #UNDERLINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNDERLINE_VALUE = 2;

	/**
	 * The '<em><b>STRIKE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STRIKE</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #STRIKE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRIKE_VALUE = 3;

	/**
	 * An array of all the '<em><b>Font Option</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final FontOption[] VALUES_ARRAY = new FontOption[] { ITALIC, BOLD, UNDERLINE, STRIKE, };

	/**
	 * A public read-only list of all the '<em><b>Font Option</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<FontOption> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Font Option</b></em>' literal with the specified literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static FontOption get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FontOption result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Font Option</b></em>' literal with the specified name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static FontOption getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FontOption result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Font Option</b></em>' literal with the specified integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static FontOption get(int value) {
		switch (value) {
		case ITALIC_VALUE:
			return ITALIC;
		case BOLD_VALUE:
			return BOLD;
		case UNDERLINE_VALUE:
			return UNDERLINE;
		case STRIKE_VALUE:
			return STRIKE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private FontOption(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // FontOption
