/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Papa Issa Diakhate (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
/**
 */
package org.polarsys.reqcycle.predicates.core.impl;

import java.lang.CharSequence;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.polarsys.reqcycle.predicates.core.PredicatesPackage;
import org.polarsys.reqcycle.predicates.core.api.ContainsPatternPredicate;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Contains Pattern Predicate</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.predicates.core.impl.ContainsPatternPredicateImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.predicates.core.impl.ContainsPatternPredicateImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.predicates.core.impl.ContainsPatternPredicateImpl#getExpectedPattern <em>Expected Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContainsPatternPredicateImpl extends MinimalEObjectImpl.Container implements ContainsPatternPredicate {

	/**
	 * The default value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPLAY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected String displayName = DISPLAY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getInput() <em>Input</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected static final CharSequence INPUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected CharSequence input = INPUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpectedPattern() <em>Expected Pattern</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getExpectedPattern()
	 * @generated
	 * @ordered
	 */
	protected static final Pattern EXPECTED_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpectedPattern() <em>Expected Pattern</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getExpectedPattern()
	 * @generated
	 * @ordered
	 */
	protected Pattern expectedPattern = EXPECTED_PATTERN_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainsPatternPredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PredicatesPackage.Literals.CONTAINS_PATTERN_PREDICATE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDisplayName(String newDisplayName) {
		String oldDisplayName = displayName;
		displayName = newDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PredicatesPackage.CONTAINS_PATTERN_PREDICATE__DISPLAY_NAME, oldDisplayName, displayName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CharSequence getInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInput(CharSequence newInput) {
		CharSequence oldInput = input;
		input = newInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PredicatesPackage.CONTAINS_PATTERN_PREDICATE__INPUT, oldInput, input));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Pattern getExpectedPattern() {
		return expectedPattern;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExpectedPattern(Pattern newExpectedPattern) {
		Pattern oldExpectedPattern = expectedPattern;
		expectedPattern = newExpectedPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PredicatesPackage.CONTAINS_PATTERN_PREDICATE__EXPECTED_PATTERN, oldExpectedPattern, expectedPattern));
	}

	@Override
	public boolean match(Object input) {
		try {
			CharSequence inputValue = (CharSequence) input;
			return this.getExpectedPattern().matcher(inputValue).find();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PredicatesPackage.CONTAINS_PATTERN_PREDICATE__DISPLAY_NAME:
				return getDisplayName();
			case PredicatesPackage.CONTAINS_PATTERN_PREDICATE__INPUT:
				return getInput();
			case PredicatesPackage.CONTAINS_PATTERN_PREDICATE__EXPECTED_PATTERN:
				return getExpectedPattern();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PredicatesPackage.CONTAINS_PATTERN_PREDICATE__DISPLAY_NAME:
				setDisplayName((String)newValue);
				return;
			case PredicatesPackage.CONTAINS_PATTERN_PREDICATE__INPUT:
				setInput((CharSequence)newValue);
				return;
			case PredicatesPackage.CONTAINS_PATTERN_PREDICATE__EXPECTED_PATTERN:
				setExpectedPattern((Pattern)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PredicatesPackage.CONTAINS_PATTERN_PREDICATE__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
				return;
			case PredicatesPackage.CONTAINS_PATTERN_PREDICATE__INPUT:
				setInput(INPUT_EDEFAULT);
				return;
			case PredicatesPackage.CONTAINS_PATTERN_PREDICATE__EXPECTED_PATTERN:
				setExpectedPattern(EXPECTED_PATTERN_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PredicatesPackage.CONTAINS_PATTERN_PREDICATE__DISPLAY_NAME:
				return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
			case PredicatesPackage.CONTAINS_PATTERN_PREDICATE__INPUT:
				return INPUT_EDEFAULT == null ? input != null : !INPUT_EDEFAULT.equals(input);
			case PredicatesPackage.CONTAINS_PATTERN_PREDICATE__EXPECTED_PATTERN:
				return EXPECTED_PATTERN_EDEFAULT == null ? expectedPattern != null : !EXPECTED_PATTERN_EDEFAULT.equals(expectedPattern);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PredicatesPackage.CONTAINS_PATTERN_PREDICATE___MATCH__OBJECT:
				return match(arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (displayName: ");
		result.append(displayName);
		result.append(", input: ");
		result.append(input);
		result.append(", expectedPattern: ");
		result.append(expectedPattern);
		result.append(')');
		return result.toString();
	}

} // ContainsPatternPredicateImpl
