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
package org.polarsys.reqcycle.predicates.core.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.polarsys.reqcycle.predicates.core.PredicatesPackage;
import org.polarsys.reqcycle.predicates.core.api.*;
import org.polarsys.reqcycle.predicates.core.api.AndPredicate;
import org.polarsys.reqcycle.predicates.core.api.BooleanEqualPredicate;
import org.polarsys.reqcycle.predicates.core.api.CompareNumberPredicate;
import org.polarsys.reqcycle.predicates.core.api.CompositePredicate;
import org.polarsys.reqcycle.predicates.core.api.ContainsPatternPredicate;
import org.polarsys.reqcycle.predicates.core.api.CustomPredicate;
import org.polarsys.reqcycle.predicates.core.api.DateEqualPredicate;
import org.polarsys.reqcycle.predicates.core.api.EnumEqualPredicate;
import org.polarsys.reqcycle.predicates.core.api.EnumIntoPredicate;
import org.polarsys.reqcycle.predicates.core.api.EqualPredicate;
import org.polarsys.reqcycle.predicates.core.api.IEAttrPredicate;
import org.polarsys.reqcycle.predicates.core.api.IEClassifierPredicate;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.predicates.core.api.ITypedPredicate;
import org.polarsys.reqcycle.predicates.core.api.IntoPredicate;
import org.polarsys.reqcycle.predicates.core.api.NotPredicate;
import org.polarsys.reqcycle.predicates.core.api.OrPredicate;
import org.polarsys.reqcycle.predicates.core.api.StringEqualPredicate;
import org.polarsys.reqcycle.predicates.core.api.StringIntoPredicate;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model, starting with the actual class
 * of the object and proceeding up the inheritance hierarchy until a non-null result is returned, which is the result of the switch. <!-- end-user-doc -->
 * @see org.polarsys.reqcycle.predicates.core.PredicatesPackage
 * @generated
 */
public class PredicatesSwitch<T1> extends Switch<T1> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static PredicatesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PredicatesSwitch() {
		if (modelPackage == null) {
			modelPackage = PredicatesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case PredicatesPackage.IPREDICATE: {
				IPredicate iPredicate = (IPredicate)theEObject;
				T1 result = caseIPredicate(iPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.COMPOSITE_PREDICATE: {
				CompositePredicate compositePredicate = (CompositePredicate)theEObject;
				T1 result = caseCompositePredicate(compositePredicate);
				if (result == null) result = caseIListeningPredicate(compositePredicate);
				if (result == null) result = caseIPredicate(compositePredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.CUSTOM_PREDICATE: {
				CustomPredicate customPredicate = (CustomPredicate)theEObject;
				T1 result = caseCustomPredicate(customPredicate);
				if (result == null) result = caseIPredicate(customPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.EQUAL_PREDICATE: {
				EqualPredicate<?> equalPredicate = (EqualPredicate<?>)theEObject;
				T1 result = caseEqualPredicate(equalPredicate);
				if (result == null) result = caseIPredicate(equalPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.STRING_EQUAL_PREDICATE: {
				StringEqualPredicate stringEqualPredicate = (StringEqualPredicate)theEObject;
				T1 result = caseStringEqualPredicate(stringEqualPredicate);
				if (result == null) result = caseEqualPredicate(stringEqualPredicate);
				if (result == null) result = caseIPredicate(stringEqualPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.DATE_EQUAL_PREDICATE: {
				DateEqualPredicate dateEqualPredicate = (DateEqualPredicate)theEObject;
				T1 result = caseDateEqualPredicate(dateEqualPredicate);
				if (result == null) result = caseEqualPredicate(dateEqualPredicate);
				if (result == null) result = caseIPredicate(dateEqualPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.ENUM_EQUAL_PREDICATE: {
				EnumEqualPredicate enumEqualPredicate = (EnumEqualPredicate)theEObject;
				T1 result = caseEnumEqualPredicate(enumEqualPredicate);
				if (result == null) result = caseEqualPredicate(enumEqualPredicate);
				if (result == null) result = caseIPredicate(enumEqualPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.BOOLEAN_EQUAL_PREDICATE: {
				BooleanEqualPredicate booleanEqualPredicate = (BooleanEqualPredicate)theEObject;
				T1 result = caseBooleanEqualPredicate(booleanEqualPredicate);
				if (result == null) result = caseEqualPredicate(booleanEqualPredicate);
				if (result == null) result = caseIPredicate(booleanEqualPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.CONTAINS_PATTERN_PREDICATE: {
				ContainsPatternPredicate containsPatternPredicate = (ContainsPatternPredicate)theEObject;
				T1 result = caseContainsPatternPredicate(containsPatternPredicate);
				if (result == null) result = caseIPredicate(containsPatternPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.INTO_PREDICATE: {
				IntoPredicate<?> intoPredicate = (IntoPredicate<?>)theEObject;
				T1 result = caseIntoPredicate(intoPredicate);
				if (result == null) result = caseIPredicate(intoPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.STRING_INTO_PREDICATE: {
				StringIntoPredicate stringIntoPredicate = (StringIntoPredicate)theEObject;
				T1 result = caseStringIntoPredicate(stringIntoPredicate);
				if (result == null) result = caseIntoPredicate(stringIntoPredicate);
				if (result == null) result = caseIPredicate(stringIntoPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.ENUM_INTO_PREDICATE: {
				EnumIntoPredicate enumIntoPredicate = (EnumIntoPredicate)theEObject;
				T1 result = caseEnumIntoPredicate(enumIntoPredicate);
				if (result == null) result = caseIntoPredicate(enumIntoPredicate);
				if (result == null) result = caseIPredicate(enumIntoPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.AND_PREDICATE: {
				AndPredicate andPredicate = (AndPredicate)theEObject;
				T1 result = caseAndPredicate(andPredicate);
				if (result == null) result = caseCompositePredicate(andPredicate);
				if (result == null) result = caseIListeningPredicate(andPredicate);
				if (result == null) result = caseIPredicate(andPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.OR_PREDICATE: {
				OrPredicate orPredicate = (OrPredicate)theEObject;
				T1 result = caseOrPredicate(orPredicate);
				if (result == null) result = caseCompositePredicate(orPredicate);
				if (result == null) result = caseIListeningPredicate(orPredicate);
				if (result == null) result = caseIPredicate(orPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.NOT_PREDICATE: {
				NotPredicate notPredicate = (NotPredicate)theEObject;
				T1 result = caseNotPredicate(notPredicate);
				if (result == null) result = caseCompositePredicate(notPredicate);
				if (result == null) result = caseIListeningPredicate(notPredicate);
				if (result == null) result = caseIPredicate(notPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.COMPARE_NUMBER_PREDICATE: {
				CompareNumberPredicate compareNumberPredicate = (CompareNumberPredicate)theEObject;
				T1 result = caseCompareNumberPredicate(compareNumberPredicate);
				if (result == null) result = caseIPredicate(compareNumberPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.ITYPED_PREDICATE: {
				ITypedPredicate<?> iTypedPredicate = (ITypedPredicate<?>)theEObject;
				T1 result = caseITypedPredicate(iTypedPredicate);
				if (result == null) result = caseIPredicateContainer(iTypedPredicate);
				if (result == null) result = caseIPredicate(iTypedPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.IE_ATTR_PREDICATE: {
				IEAttrPredicate ieAttrPredicate = (IEAttrPredicate)theEObject;
				T1 result = caseIEAttrPredicate(ieAttrPredicate);
				if (result == null) result = caseITypedPredicate(ieAttrPredicate);
				if (result == null) result = caseIPredicateContainer(ieAttrPredicate);
				if (result == null) result = caseIPredicate(ieAttrPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.IE_CLASSIFIER_PREDICATE: {
				IEClassifierPredicate ieClassifierPredicate = (IEClassifierPredicate)theEObject;
				T1 result = caseIEClassifierPredicate(ieClassifierPredicate);
				if (result == null) result = caseITypedPredicate(ieClassifierPredicate);
				if (result == null) result = caseIPredicateContainer(ieClassifierPredicate);
				if (result == null) result = caseIPredicate(ieClassifierPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.TRUE_PREDICATE: {
				TruePredicate truePredicate = (TruePredicate)theEObject;
				T1 result = caseTruePredicate(truePredicate);
				if (result == null) result = caseIPredicate(truePredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.OPERATION_PREDICATE: {
				OperationPredicate operationPredicate = (OperationPredicate)theEObject;
				T1 result = caseOperationPredicate(operationPredicate);
				if (result == null) result = caseIPredicateContainer(operationPredicate);
				if (result == null) result = caseIListeningPredicate(operationPredicate);
				if (result == null) result = caseIPredicate(operationPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T1 result = caseParameter(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.INT_PARAMETER: {
				IntParameter intParameter = (IntParameter)theEObject;
				T1 result = caseIntParameter(intParameter);
				if (result == null) result = caseParameter(intParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.BOOLEAN_PARAMETER: {
				BooleanParameter booleanParameter = (BooleanParameter)theEObject;
				T1 result = caseBooleanParameter(booleanParameter);
				if (result == null) result = caseParameter(booleanParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.STRING_PARAMETER: {
				StringParameter stringParameter = (StringParameter)theEObject;
				T1 result = caseStringParameter(stringParameter);
				if (result == null) result = caseParameter(stringParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.EOBJECT_PARAMETER: {
				EObjectParameter eObjectParameter = (EObjectParameter)theEObject;
				T1 result = caseEObjectParameter(eObjectParameter);
				if (result == null) result = caseParameter(eObjectParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.IPREDICATE_CONTAINER: {
				IPredicateContainer iPredicateContainer = (IPredicateContainer)theEObject;
				T1 result = caseIPredicateContainer(iPredicateContainer);
				if (result == null) result = caseIPredicate(iPredicateContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.IS_TYPE_OF_PREDICATE: {
				IsTypeOfPredicate isTypeOfPredicate = (IsTypeOfPredicate)theEObject;
				T1 result = caseIsTypeOfPredicate(isTypeOfPredicate);
				if (result == null) result = caseIPredicate(isTypeOfPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.IS_NULL_PREDICATE: {
				IsNullPredicate isNullPredicate = (IsNullPredicate)theEObject;
				T1 result = caseIsNullPredicate(isNullPredicate);
				if (result == null) result = caseIPredicate(isNullPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatesPackage.ILISTENING_PREDICATE: {
				IListeningPredicate iListeningPredicate = (IListeningPredicate)theEObject;
				T1 result = caseIListeningPredicate(iListeningPredicate);
				if (result == null) result = caseIPredicate(iListeningPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPredicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPredicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIPredicate(IPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCompositePredicate(CompositePredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCustomPredicate(CustomPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equal Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equal Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Object> T1 caseEqualPredicate(EqualPredicate<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Equal Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Equal Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStringEqualPredicate(StringEqualPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Date Equal Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Date Equal Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDateEqualPredicate(DateEqualPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Equal Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Equal Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEnumEqualPredicate(EnumEqualPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Equal Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Equal Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBooleanEqualPredicate(BooleanEqualPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contains Pattern Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contains Pattern Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseContainsPatternPredicate(ContainsPatternPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Into Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Into Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseIntoPredicate(IntoPredicate<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Into Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Into Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStringIntoPredicate(StringIntoPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Into Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Into Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEnumIntoPredicate(EnumIntoPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAndPredicate(AndPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOrPredicate(OrPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compare Number Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compare Number Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCompareNumberPredicate(CompareNumberPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITyped Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITyped Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseITypedPredicate(ITypedPredicate<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IE Attr Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IE Attr Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIEAttrPredicate(IEAttrPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IE Classifier Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IE Classifier Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIEClassifierPredicate(IEClassifierPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>True Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>True Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTruePredicate(TruePredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOperationPredicate(OperationPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Parameter</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIntParameter(IntParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Parameter</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBooleanParameter(BooleanParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Parameter</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStringParameter(StringParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject Parameter</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEObjectParameter(EObjectParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPredicate Container</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPredicate Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIPredicateContainer(IPredicateContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Type Of Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Type Of Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIsTypeOfPredicate(IsTypeOfPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Null Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Null Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIsNullPredicate(IsNullPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IListening Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IListening Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIListeningPredicate(IListeningPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Predicate</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNotPredicate(NotPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch, but this is the last case anyway. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object) {
		return null;
	}

} // PredicatesSwitch
