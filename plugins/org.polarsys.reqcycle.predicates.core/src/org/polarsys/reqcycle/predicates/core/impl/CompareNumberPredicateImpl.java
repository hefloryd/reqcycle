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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.polarsys.reqcycle.predicates.core.PredicatesPackage;
import org.polarsys.reqcycle.predicates.core.api.CompareNumberPredicate;
import org.polarsys.reqcycle.predicates.core.api.OPERATOR;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Compare Number Predicate</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.predicates.core.impl.CompareNumberPredicateImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.predicates.core.impl.CompareNumberPredicateImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.predicates.core.impl.CompareNumberPredicateImpl#getExpectedValue <em>Expected Value</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.predicates.core.impl.CompareNumberPredicateImpl#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompareNumberPredicateImpl extends MinimalEObjectImpl.Container implements CompareNumberPredicate {

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
	protected static final Number INPUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected Number input = INPUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpectedValue() <em>Expected Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getExpectedValue()
	 * @generated
	 * @ordered
	 */
	protected static final Number EXPECTED_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpectedValue() <em>Expected Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getExpectedValue()
	 * @generated
	 * @ordered
	 */
	protected Number expectedValue = EXPECTED_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected static final OPERATOR OPERATOR_EDEFAULT = OPERATOR.EQ;

	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected OPERATOR operator = OPERATOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CompareNumberPredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PredicatesPackage.Literals.COMPARE_NUMBER_PREDICATE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PredicatesPackage.COMPARE_NUMBER_PREDICATE__DISPLAY_NAME, oldDisplayName, displayName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Number getInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInput(Number newInput) {
		Number oldInput = input;
		input = newInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PredicatesPackage.COMPARE_NUMBER_PREDICATE__INPUT, oldInput, input));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Number getExpectedValue() {
		return expectedValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExpectedValue(Number newExpectedValue) {
		Number oldExpectedValue = expectedValue;
		expectedValue = newExpectedValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PredicatesPackage.COMPARE_NUMBER_PREDICATE__EXPECTED_VALUE, oldExpectedValue, expectedValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OPERATOR getOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperator(OPERATOR newOperator) {
		OPERATOR oldOperator = operator;
		operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PredicatesPackage.COMPARE_NUMBER_PREDICATE__OPERATOR, oldOperator, operator));
	}

	@Override
	public boolean match(Object input) {
		try {
			final Number inputNumber = ((Number) input);
			final double inputVal = inputNumber.doubleValue();
			final double expectedVal = this.expectedValue.doubleValue();

			switch (getOperator()) {
			case EQ:
				return inputVal == expectedVal;
			case NQ:
				return inputVal != expectedVal;
			case GT:
				return inputVal > expectedVal;
			case GET:
				return inputVal >= expectedVal;
			case LT:
				return inputVal < expectedVal;
			case LET:
				return inputVal <= expectedVal;
			default:
				throw new UnsupportedOperationException("Unknown operator ...");
			}
		} catch (ClassCastException e) {
			return false;
		} catch (NullPointerException e) {
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
			case PredicatesPackage.COMPARE_NUMBER_PREDICATE__DISPLAY_NAME:
				return getDisplayName();
			case PredicatesPackage.COMPARE_NUMBER_PREDICATE__INPUT:
				return getInput();
			case PredicatesPackage.COMPARE_NUMBER_PREDICATE__EXPECTED_VALUE:
				return getExpectedValue();
			case PredicatesPackage.COMPARE_NUMBER_PREDICATE__OPERATOR:
				return getOperator();
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
			case PredicatesPackage.COMPARE_NUMBER_PREDICATE__DISPLAY_NAME:
				setDisplayName((String)newValue);
				return;
			case PredicatesPackage.COMPARE_NUMBER_PREDICATE__INPUT:
				setInput((Number)newValue);
				return;
			case PredicatesPackage.COMPARE_NUMBER_PREDICATE__EXPECTED_VALUE:
				setExpectedValue((Number)newValue);
				return;
			case PredicatesPackage.COMPARE_NUMBER_PREDICATE__OPERATOR:
				setOperator((OPERATOR)newValue);
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
			case PredicatesPackage.COMPARE_NUMBER_PREDICATE__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
				return;
			case PredicatesPackage.COMPARE_NUMBER_PREDICATE__INPUT:
				setInput(INPUT_EDEFAULT);
				return;
			case PredicatesPackage.COMPARE_NUMBER_PREDICATE__EXPECTED_VALUE:
				setExpectedValue(EXPECTED_VALUE_EDEFAULT);
				return;
			case PredicatesPackage.COMPARE_NUMBER_PREDICATE__OPERATOR:
				setOperator(OPERATOR_EDEFAULT);
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
			case PredicatesPackage.COMPARE_NUMBER_PREDICATE__DISPLAY_NAME:
				return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
			case PredicatesPackage.COMPARE_NUMBER_PREDICATE__INPUT:
				return INPUT_EDEFAULT == null ? input != null : !INPUT_EDEFAULT.equals(input);
			case PredicatesPackage.COMPARE_NUMBER_PREDICATE__EXPECTED_VALUE:
				return EXPECTED_VALUE_EDEFAULT == null ? expectedValue != null : !EXPECTED_VALUE_EDEFAULT.equals(expectedValue);
			case PredicatesPackage.COMPARE_NUMBER_PREDICATE__OPERATOR:
				return operator != OPERATOR_EDEFAULT;
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
			case PredicatesPackage.COMPARE_NUMBER_PREDICATE___MATCH__OBJECT:
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
		result.append(", expectedValue: ");
		result.append(expectedValue);
		result.append(", operator: ");
		result.append(operator);
		result.append(')');
		return result.toString();
	}

} // CompareNumberPredicateImpl
