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
package org.polarsys.reqcycle.predicates.core;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polarsys.reqcycle.predicates.core.PredicatesFactory
 * @model kind="package"
 * @generated
 */
public interface PredicatesPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "predicates";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.polarsys.org/ReqCycle/predicates/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "predicates";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	PredicatesPackage eINSTANCE = org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.api.IPredicate <em>IPredicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.api.IPredicate
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getIPredicate()
	 * @generated
	 */
	int IPREDICATE = 0;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPREDICATE__DISPLAY_NAME = 0;

	/**
	 * The number of structural features of the '<em>IPredicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPREDICATE_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPREDICATE___MATCH__OBJECT = 0;

	/**
	 * The number of operations of the '<em>IPredicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPREDICATE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.CompositePredicateImpl <em>Composite Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.CompositePredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getCompositePredicate()
	 * @generated
	 */
	int COMPOSITE_PREDICATE = 1;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PREDICATE__DISPLAY_NAME = IPREDICATE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Predicates</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PREDICATE__PREDICATES = IPREDICATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PREDICATE_FEATURE_COUNT = IPREDICATE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PREDICATE___MATCH__OBJECT = IPREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>Composite Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PREDICATE_OPERATION_COUNT = IPREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.IEAttrPredicateImpl <em>IE Attr Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.IEAttrPredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getIEAttrPredicate()
	 * @generated
	 */
	int IE_ATTR_PREDICATE = 17;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.api.CustomPredicate <em>Custom Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.api.CustomPredicate
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getCustomPredicate()
	 * @generated
	 */
	int CUSTOM_PREDICATE = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.EqualPredicateImpl <em>Equal Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.EqualPredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getEqualPredicate()
	 * @generated
	 */
	int EQUAL_PREDICATE = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.ContainsPatternPredicateImpl <em>Contains Pattern Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.ContainsPatternPredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getContainsPatternPredicate()
	 * @generated
	 */
	int CONTAINS_PATTERN_PREDICATE = 8;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.AndPredicateImpl <em>And Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.AndPredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getAndPredicate()
	 * @generated
	 */
	int AND_PREDICATE = 12;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.OrPredicateImpl <em>Or Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.OrPredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getOrPredicate()
	 * @generated
	 */
	int OR_PREDICATE = 13;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.api.ITypedPredicate <em>ITyped Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.api.ITypedPredicate
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getITypedPredicate()
	 * @generated
	 */
	int ITYPED_PREDICATE = 16;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PREDICATE__DISPLAY_NAME = IPREDICATE__DISPLAY_NAME;

	/**
	 * The number of structural features of the '<em>Custom Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PREDICATE_FEATURE_COUNT = IPREDICATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PREDICATE___MATCH__OBJECT = IPREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>Custom Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PREDICATE_OPERATION_COUNT = IPREDICATE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL_PREDICATE__DISPLAY_NAME = IPREDICATE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL_PREDICATE__INPUT = IPREDICATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expected Object</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL_PREDICATE__EXPECTED_OBJECT = IPREDICATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Equal Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL_PREDICATE_FEATURE_COUNT = IPREDICATE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL_PREDICATE___MATCH__OBJECT = IPREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>Equal Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL_PREDICATE_OPERATION_COUNT = IPREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.StringEqualPredicateImpl <em>String Equal Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.StringEqualPredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getStringEqualPredicate()
	 * @generated
	 */
	int STRING_EQUAL_PREDICATE = 4;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_EQUAL_PREDICATE__DISPLAY_NAME = EQUAL_PREDICATE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_EQUAL_PREDICATE__INPUT = EQUAL_PREDICATE__INPUT;

	/**
	 * The feature id for the '<em><b>Expected Object</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_EQUAL_PREDICATE__EXPECTED_OBJECT = EQUAL_PREDICATE__EXPECTED_OBJECT;

	/**
	 * The number of structural features of the '<em>String Equal Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_EQUAL_PREDICATE_FEATURE_COUNT = EQUAL_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_EQUAL_PREDICATE___MATCH__OBJECT = EQUAL_PREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>String Equal Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_EQUAL_PREDICATE_OPERATION_COUNT = EQUAL_PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.DateEqualPredicateImpl <em>Date Equal Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.DateEqualPredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getDateEqualPredicate()
	 * @generated
	 */
	int DATE_EQUAL_PREDICATE = 5;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_EQUAL_PREDICATE__DISPLAY_NAME = EQUAL_PREDICATE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_EQUAL_PREDICATE__INPUT = EQUAL_PREDICATE__INPUT;

	/**
	 * The feature id for the '<em><b>Expected Object</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_EQUAL_PREDICATE__EXPECTED_OBJECT = EQUAL_PREDICATE__EXPECTED_OBJECT;

	/**
	 * The number of structural features of the '<em>Date Equal Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_EQUAL_PREDICATE_FEATURE_COUNT = EQUAL_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_EQUAL_PREDICATE___MATCH__OBJECT = EQUAL_PREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>Date Equal Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_EQUAL_PREDICATE_OPERATION_COUNT = EQUAL_PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.EnumEqualPredicateImpl <em>Enum Equal Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.EnumEqualPredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getEnumEqualPredicate()
	 * @generated
	 */
	int ENUM_EQUAL_PREDICATE = 6;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_EQUAL_PREDICATE__DISPLAY_NAME = EQUAL_PREDICATE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_EQUAL_PREDICATE__INPUT = EQUAL_PREDICATE__INPUT;

	/**
	 * The feature id for the '<em><b>Expected Object</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_EQUAL_PREDICATE__EXPECTED_OBJECT = EQUAL_PREDICATE__EXPECTED_OBJECT;

	/**
	 * The number of structural features of the '<em>Enum Equal Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_EQUAL_PREDICATE_FEATURE_COUNT = EQUAL_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_EQUAL_PREDICATE___MATCH__OBJECT = EQUAL_PREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>Enum Equal Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_EQUAL_PREDICATE_OPERATION_COUNT = EQUAL_PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.BooleanEqualPredicateImpl <em>Boolean Equal Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.BooleanEqualPredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getBooleanEqualPredicate()
	 * @generated
	 */
	int BOOLEAN_EQUAL_PREDICATE = 7;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EQUAL_PREDICATE__DISPLAY_NAME = EQUAL_PREDICATE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EQUAL_PREDICATE__INPUT = EQUAL_PREDICATE__INPUT;

	/**
	 * The feature id for the '<em><b>Expected Object</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EQUAL_PREDICATE__EXPECTED_OBJECT = EQUAL_PREDICATE__EXPECTED_OBJECT;

	/**
	 * The number of structural features of the '<em>Boolean Equal Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EQUAL_PREDICATE_FEATURE_COUNT = EQUAL_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EQUAL_PREDICATE___MATCH__OBJECT = EQUAL_PREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>Boolean Equal Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EQUAL_PREDICATE_OPERATION_COUNT = EQUAL_PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_PATTERN_PREDICATE__DISPLAY_NAME = IPREDICATE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_PATTERN_PREDICATE__INPUT = IPREDICATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expected Pattern</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_PATTERN_PREDICATE__EXPECTED_PATTERN = IPREDICATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Contains Pattern Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_PATTERN_PREDICATE_FEATURE_COUNT = IPREDICATE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_PATTERN_PREDICATE___MATCH__OBJECT = IPREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>Contains Pattern Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_PATTERN_PREDICATE_OPERATION_COUNT = IPREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.IntoPredicateImpl <em>Into Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.IntoPredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getIntoPredicate()
	 * @generated
	 */
	int INTO_PREDICATE = 9;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTO_PREDICATE__DISPLAY_NAME = IPREDICATE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTO_PREDICATE__INPUT = IPREDICATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Allowed Entries</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTO_PREDICATE__ALLOWED_ENTRIES = IPREDICATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Into Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTO_PREDICATE_FEATURE_COUNT = IPREDICATE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTO_PREDICATE___MATCH__OBJECT = IPREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>Into Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTO_PREDICATE_OPERATION_COUNT = IPREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.StringIntoPredicateImpl <em>String Into Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.StringIntoPredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getStringIntoPredicate()
	 * @generated
	 */
	int STRING_INTO_PREDICATE = 10;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_INTO_PREDICATE__DISPLAY_NAME = INTO_PREDICATE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_INTO_PREDICATE__INPUT = INTO_PREDICATE__INPUT;

	/**
	 * The feature id for the '<em><b>Allowed Entries</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_INTO_PREDICATE__ALLOWED_ENTRIES = INTO_PREDICATE__ALLOWED_ENTRIES;

	/**
	 * The number of structural features of the '<em>String Into Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_INTO_PREDICATE_FEATURE_COUNT = INTO_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_INTO_PREDICATE___MATCH__OBJECT = INTO_PREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>String Into Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_INTO_PREDICATE_OPERATION_COUNT = INTO_PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.EnumIntoPredicateImpl <em>Enum Into Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.EnumIntoPredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getEnumIntoPredicate()
	 * @generated
	 */
	int ENUM_INTO_PREDICATE = 11;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_INTO_PREDICATE__DISPLAY_NAME = INTO_PREDICATE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_INTO_PREDICATE__INPUT = INTO_PREDICATE__INPUT;

	/**
	 * The feature id for the '<em><b>Allowed Entries</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_INTO_PREDICATE__ALLOWED_ENTRIES = INTO_PREDICATE__ALLOWED_ENTRIES;

	/**
	 * The number of structural features of the '<em>Enum Into Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_INTO_PREDICATE_FEATURE_COUNT = INTO_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_INTO_PREDICATE___MATCH__OBJECT = INTO_PREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>Enum Into Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_INTO_PREDICATE_OPERATION_COUNT = INTO_PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_PREDICATE__DISPLAY_NAME = COMPOSITE_PREDICATE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Predicates</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_PREDICATE__PREDICATES = COMPOSITE_PREDICATE__PREDICATES;

	/**
	 * The number of structural features of the '<em>And Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_PREDICATE_FEATURE_COUNT = COMPOSITE_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_PREDICATE___MATCH__OBJECT = COMPOSITE_PREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>And Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_PREDICATE_OPERATION_COUNT = COMPOSITE_PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_PREDICATE__DISPLAY_NAME = COMPOSITE_PREDICATE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Predicates</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_PREDICATE__PREDICATES = COMPOSITE_PREDICATE__PREDICATES;

	/**
	 * The number of structural features of the '<em>Or Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_PREDICATE_FEATURE_COUNT = COMPOSITE_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_PREDICATE___MATCH__OBJECT = COMPOSITE_PREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>Or Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_PREDICATE_OPERATION_COUNT = COMPOSITE_PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.CompareNumberPredicateImpl <em>Compare Number Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.CompareNumberPredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getCompareNumberPredicate()
	 * @generated
	 */
	int COMPARE_NUMBER_PREDICATE = 15;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.api.IEClassifierPredicate <em>IE Classifier Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.api.IEClassifierPredicate
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getIEClassifierPredicate()
	 * @generated
	 */
	int IE_CLASSIFIER_PREDICATE = 18;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.NotPredicateImpl <em>Not Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.NotPredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getNotPredicate()
	 * @generated
	 */
	int NOT_PREDICATE = 14;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_PREDICATE__DISPLAY_NAME = COMPOSITE_PREDICATE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Predicates</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_PREDICATE__PREDICATES = COMPOSITE_PREDICATE__PREDICATES;

	/**
	 * The number of structural features of the '<em>Not Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_PREDICATE_FEATURE_COUNT = COMPOSITE_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_PREDICATE___MATCH__OBJECT = COMPOSITE_PREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>Not Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_PREDICATE_OPERATION_COUNT = COMPOSITE_PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_NUMBER_PREDICATE__DISPLAY_NAME = IPREDICATE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_NUMBER_PREDICATE__INPUT = IPREDICATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expected Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_NUMBER_PREDICATE__EXPECTED_VALUE = IPREDICATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_NUMBER_PREDICATE__OPERATOR = IPREDICATE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Compare Number Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_NUMBER_PREDICATE_FEATURE_COUNT = IPREDICATE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_NUMBER_PREDICATE___MATCH__OBJECT = IPREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>Compare Number Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_NUMBER_PREDICATE_OPERATION_COUNT = IPREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.TruePredicateImpl <em>True Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.TruePredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getTruePredicate()
	 * @generated
	 */
	int TRUE_PREDICATE = 19;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.OperationPredicateImpl <em>Operation Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.OperationPredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getOperationPredicate()
	 * @generated
	 */
	int OPERATION_PREDICATE = 20;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.ParameterImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 21;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.IntParameterImpl <em>Int Parameter</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.IntParameterImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getIntParameter()
	 * @generated
	 */
	int INT_PARAMETER = 22;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.BooleanParameterImpl <em>Boolean Parameter</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.BooleanParameterImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getBooleanParameter()
	 * @generated
	 */
	int BOOLEAN_PARAMETER = 23;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.StringParameterImpl <em>String Parameter</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.StringParameterImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getStringParameter()
	 * @generated
	 */
	int STRING_PARAMETER = 24;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.EObjectParameterImpl <em>EObject Parameter</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.EObjectParameterImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getEObjectParameter()
	 * @generated
	 */
	int EOBJECT_PARAMETER = 25;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.IPredicateContainerImpl <em>IPredicate Container</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.IPredicateContainerImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getIPredicateContainer()
	 * @generated
	 */
	int IPREDICATE_CONTAINER = 26;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPREDICATE_CONTAINER__DISPLAY_NAME = IPREDICATE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Result Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPREDICATE_CONTAINER__RESULT_PREDICATE = IPREDICATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IPredicate Container</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPREDICATE_CONTAINER_FEATURE_COUNT = IPREDICATE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPREDICATE_CONTAINER___MATCH__OBJECT = IPREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>IPredicate Container</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPREDICATE_CONTAINER_OPERATION_COUNT = IPREDICATE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITYPED_PREDICATE__DISPLAY_NAME = IPREDICATE_CONTAINER__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Result Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITYPED_PREDICATE__RESULT_PREDICATE = IPREDICATE_CONTAINER__RESULT_PREDICATE;

	/**
	 * The feature id for the '<em><b>Typed Element</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITYPED_PREDICATE__TYPED_ELEMENT = IPREDICATE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ITyped Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITYPED_PREDICATE_FEATURE_COUNT = IPREDICATE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITYPED_PREDICATE___MATCH__OBJECT = IPREDICATE_CONTAINER___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>ITyped Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITYPED_PREDICATE_OPERATION_COUNT = IPREDICATE_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ATTR_PREDICATE__DISPLAY_NAME = ITYPED_PREDICATE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Result Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ATTR_PREDICATE__RESULT_PREDICATE = ITYPED_PREDICATE__RESULT_PREDICATE;

	/**
	 * The feature id for the '<em><b>Typed Element</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ATTR_PREDICATE__TYPED_ELEMENT = ITYPED_PREDICATE__TYPED_ELEMENT;

	/**
	 * The number of structural features of the '<em>IE Attr Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ATTR_PREDICATE_FEATURE_COUNT = ITYPED_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ATTR_PREDICATE___MATCH__OBJECT = ITYPED_PREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>IE Attr Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_ATTR_PREDICATE_OPERATION_COUNT = ITYPED_PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASSIFIER_PREDICATE__DISPLAY_NAME = ITYPED_PREDICATE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Result Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASSIFIER_PREDICATE__RESULT_PREDICATE = ITYPED_PREDICATE__RESULT_PREDICATE;

	/**
	 * The feature id for the '<em><b>Typed Element</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASSIFIER_PREDICATE__TYPED_ELEMENT = ITYPED_PREDICATE__TYPED_ELEMENT;

	/**
	 * The number of structural features of the '<em>IE Classifier Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASSIFIER_PREDICATE_FEATURE_COUNT = ITYPED_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASSIFIER_PREDICATE___MATCH__OBJECT = ITYPED_PREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>IE Classifier Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IE_CLASSIFIER_PREDICATE_OPERATION_COUNT = ITYPED_PREDICATE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_PREDICATE__DISPLAY_NAME = IPREDICATE__DISPLAY_NAME;

	/**
	 * The number of structural features of the '<em>True Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_PREDICATE_FEATURE_COUNT = IPREDICATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_PREDICATE___MATCH__OBJECT = IPREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>True Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_PREDICATE_OPERATION_COUNT = IPREDICATE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PREDICATE__DISPLAY_NAME = IPREDICATE_CONTAINER__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Result Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PREDICATE__RESULT_PREDICATE = IPREDICATE_CONTAINER__RESULT_PREDICATE;

	/**
	 * The feature id for the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PREDICATE__OPERATION_NAME = IPREDICATE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PREDICATE__PARAMETERS = IPREDICATE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PREDICATE_FEATURE_COUNT = IPREDICATE_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PREDICATE___MATCH__OBJECT = IPREDICATE_CONTAINER___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>Operation Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PREDICATE_OPERATION_COUNT = IPREDICATE_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Get Object Value</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___GET_OBJECT_VALUE = 0;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_PARAMETER__VALUE = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Parameter</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Object Value</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_PARAMETER___GET_OBJECT_VALUE = PARAMETER___GET_OBJECT_VALUE;

	/**
	 * The number of operations of the '<em>Int Parameter</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_PARAMETER_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PARAMETER__VALUE = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Parameter</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Object Value</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PARAMETER___GET_OBJECT_VALUE = PARAMETER___GET_OBJECT_VALUE;

	/**
	 * The number of operations of the '<em>Boolean Parameter</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PARAMETER_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PARAMETER__VALUE = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Parameter</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Object Value</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PARAMETER___GET_OBJECT_VALUE = PARAMETER___GET_OBJECT_VALUE;

	/**
	 * The number of operations of the '<em>String Parameter</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PARAMETER_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_PARAMETER__VALUE = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EObject Parameter</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Object Value</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_PARAMETER___GET_OBJECT_VALUE = PARAMETER___GET_OBJECT_VALUE;

	/**
	 * The number of operations of the '<em>EObject Parameter</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_PARAMETER_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.IsTypeOfPredicateImpl <em>Is Type Of Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.IsTypeOfPredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getIsTypeOfPredicate()
	 * @generated
	 */
	int IS_TYPE_OF_PREDICATE = 27;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_TYPE_OF_PREDICATE__DISPLAY_NAME = IPREDICATE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Is Strict Type Of</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_TYPE_OF_PREDICATE__IS_STRICT_TYPE_OF = IPREDICATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_TYPE_OF_PREDICATE__TYPE = IPREDICATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Is Type Of Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_TYPE_OF_PREDICATE_FEATURE_COUNT = IPREDICATE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_TYPE_OF_PREDICATE___MATCH__OBJECT = IPREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>Is Type Of Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_TYPE_OF_PREDICATE_OPERATION_COUNT = IPREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.impl.IsNullPredicateImpl <em>Is Null Predicate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.impl.IsNullPredicateImpl
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getIsNullPredicate()
	 * @generated
	 */
	int IS_NULL_PREDICATE = 28;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_NULL_PREDICATE__DISPLAY_NAME = IPREDICATE__DISPLAY_NAME;

	/**
	 * The number of structural features of the '<em>Is Null Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_NULL_PREDICATE_FEATURE_COUNT = IPREDICATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_NULL_PREDICATE___MATCH__OBJECT = IPREDICATE___MATCH__OBJECT;

	/**
	 * The number of operations of the '<em>Is Null Predicate</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_NULL_PREDICATE_OPERATION_COUNT = IPREDICATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.predicates.core.api.OPERATOR <em>OPERATOR</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.predicates.core.api.OPERATOR
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getOPERATOR()
	 * @generated
	 */
	int OPERATOR = 29;

	/**
	 * The meta object id for the '<em>Pattern</em>' data type.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see java.util.regex.Pattern
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 30;

	/**
	 * The meta object id for the '<em>Char Sequence</em>' data type.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see java.lang.CharSequence
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getCharSequence()
	 * @generated
	 */
	int CHAR_SEQUENCE = 31;

	/**
	 * The meta object id for the '<em>Number</em>' data type.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see java.lang.Number
	 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getNumber()
	 * @generated
	 */
	int NUMBER = 32;

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.IPredicate <em>IPredicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPredicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.IPredicate
	 * @generated
	 */
	EClass getIPredicate();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.predicates.core.api.IPredicate#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.IPredicate#getDisplayName()
	 * @see #getIPredicate()
	 * @generated
	 */
	EAttribute getIPredicate_DisplayName();

	/**
	 * Returns the meta object for the '{@link org.polarsys.reqcycle.predicates.core.api.IPredicate#match(java.lang.Object) <em>Match</em>}' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the '<em>Match</em>' operation.
	 * @see org.polarsys.reqcycle.predicates.core.api.IPredicate#match(java.lang.Object)
	 * @generated
	 */
	EOperation getIPredicate__Match__Object();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.CompositePredicate <em>Composite Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.CompositePredicate
	 * @generated
	 */
	EClass getCompositePredicate();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.predicates.core.api.CompositePredicate#getPredicates <em>Predicates</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Predicates</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.CompositePredicate#getPredicates()
	 * @see #getCompositePredicate()
	 * @generated
	 */
	EReference getCompositePredicate_Predicates();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.CustomPredicate <em>Custom Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.CustomPredicate
	 * @generated
	 */
	EClass getCustomPredicate();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.EqualPredicate <em>Equal Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equal Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.EqualPredicate
	 * @generated
	 */
	EClass getEqualPredicate();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.predicates.core.api.EqualPredicate#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.EqualPredicate#getInput()
	 * @see #getEqualPredicate()
	 * @generated
	 */
	EAttribute getEqualPredicate_Input();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.predicates.core.api.EqualPredicate#getExpectedObject <em>Expected Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expected Object</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.EqualPredicate#getExpectedObject()
	 * @see #getEqualPredicate()
	 * @generated
	 */
	EAttribute getEqualPredicate_ExpectedObject();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.StringEqualPredicate <em>String Equal Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Equal Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.StringEqualPredicate
	 * @generated
	 */
	EClass getStringEqualPredicate();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.DateEqualPredicate <em>Date Equal Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Date Equal Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.DateEqualPredicate
	 * @generated
	 */
	EClass getDateEqualPredicate();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.EnumEqualPredicate <em>Enum Equal Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Equal Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.EnumEqualPredicate
	 * @generated
	 */
	EClass getEnumEqualPredicate();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.BooleanEqualPredicate <em>Boolean Equal Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Equal Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.BooleanEqualPredicate
	 * @generated
	 */
	EClass getBooleanEqualPredicate();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.ContainsPatternPredicate <em>Contains Pattern Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contains Pattern Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.ContainsPatternPredicate
	 * @generated
	 */
	EClass getContainsPatternPredicate();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.predicates.core.api.ContainsPatternPredicate#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.ContainsPatternPredicate#getInput()
	 * @see #getContainsPatternPredicate()
	 * @generated
	 */
	EAttribute getContainsPatternPredicate_Input();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.predicates.core.api.ContainsPatternPredicate#getExpectedPattern <em>Expected Pattern</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expected Pattern</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.ContainsPatternPredicate#getExpectedPattern()
	 * @see #getContainsPatternPredicate()
	 * @generated
	 */
	EAttribute getContainsPatternPredicate_ExpectedPattern();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.IntoPredicate <em>Into Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Into Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.IntoPredicate
	 * @generated
	 */
	EClass getIntoPredicate();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.predicates.core.api.IntoPredicate#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.IntoPredicate#getInput()
	 * @see #getIntoPredicate()
	 * @generated
	 */
	EAttribute getIntoPredicate_Input();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.reqcycle.predicates.core.api.IntoPredicate#getAllowedEntries <em>Allowed Entries</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Allowed Entries</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.IntoPredicate#getAllowedEntries()
	 * @see #getIntoPredicate()
	 * @generated
	 */
	EAttribute getIntoPredicate_AllowedEntries();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.StringIntoPredicate <em>String Into Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Into Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.StringIntoPredicate
	 * @generated
	 */
	EClass getStringIntoPredicate();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.EnumIntoPredicate <em>Enum Into Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Into Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.EnumIntoPredicate
	 * @generated
	 */
	EClass getEnumIntoPredicate();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.AndPredicate <em>And Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.AndPredicate
	 * @generated
	 */
	EClass getAndPredicate();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.OrPredicate <em>Or Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.OrPredicate
	 * @generated
	 */
	EClass getOrPredicate();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.CompareNumberPredicate <em>Compare Number Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compare Number Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.CompareNumberPredicate
	 * @generated
	 */
	EClass getCompareNumberPredicate();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.predicates.core.api.CompareNumberPredicate#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.CompareNumberPredicate#getInput()
	 * @see #getCompareNumberPredicate()
	 * @generated
	 */
	EAttribute getCompareNumberPredicate_Input();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.predicates.core.api.CompareNumberPredicate#getExpectedValue <em>Expected Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expected Value</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.CompareNumberPredicate#getExpectedValue()
	 * @see #getCompareNumberPredicate()
	 * @generated
	 */
	EAttribute getCompareNumberPredicate_ExpectedValue();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.predicates.core.api.CompareNumberPredicate#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.CompareNumberPredicate#getOperator()
	 * @see #getCompareNumberPredicate()
	 * @generated
	 */
	EAttribute getCompareNumberPredicate_Operator();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.ITypedPredicate <em>ITyped Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>ITyped Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.ITypedPredicate
	 * @generated
	 */
	EClass getITypedPredicate();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.reqcycle.predicates.core.api.ITypedPredicate#getTypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Typed Element</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.ITypedPredicate#getTypedElement()
	 * @see #getITypedPredicate()
	 * @generated
	 */
	EReference getITypedPredicate_TypedElement();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.IEAttrPredicate <em>IE Attr Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>IE Attr Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.IEAttrPredicate
	 * @generated
	 */
	EClass getIEAttrPredicate();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.IEClassifierPredicate <em>IE Classifier Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>IE Classifier Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.IEClassifierPredicate
	 * @generated
	 */
	EClass getIEClassifierPredicate();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.TruePredicate <em>True Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>True Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.TruePredicate
	 * @generated
	 */
	EClass getTruePredicate();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.OperationPredicate <em>Operation Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.OperationPredicate
	 * @generated
	 */
	EClass getOperationPredicate();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.predicates.core.api.OperationPredicate#getOperationName <em>Operation Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation Name</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.OperationPredicate#getOperationName()
	 * @see #getOperationPredicate()
	 * @generated
	 */
	EAttribute getOperationPredicate_OperationName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.predicates.core.api.OperationPredicate#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.OperationPredicate#getParameters()
	 * @see #getOperationPredicate()
	 * @generated
	 */
	EReference getOperationPredicate_Parameters();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.predicates.core.api.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for the '{@link org.polarsys.reqcycle.predicates.core.api.Parameter#getObjectValue() <em>Get Object Value</em>}' operation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Object Value</em>' operation.
	 * @see org.polarsys.reqcycle.predicates.core.api.Parameter#getObjectValue()
	 * @generated
	 */
	EOperation getParameter__GetObjectValue();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.IntParameter <em>Int Parameter</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Parameter</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.IntParameter
	 * @generated
	 */
	EClass getIntParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.predicates.core.api.IntParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.IntParameter#getValue()
	 * @see #getIntParameter()
	 * @generated
	 */
	EAttribute getIntParameter_Value();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.BooleanParameter <em>Boolean Parameter</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Parameter</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.BooleanParameter
	 * @generated
	 */
	EClass getBooleanParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.predicates.core.api.BooleanParameter#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.BooleanParameter#isValue()
	 * @see #getBooleanParameter()
	 * @generated
	 */
	EAttribute getBooleanParameter_Value();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.StringParameter <em>String Parameter</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Parameter</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.StringParameter
	 * @generated
	 */
	EClass getStringParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.predicates.core.api.StringParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.StringParameter#getValue()
	 * @see #getStringParameter()
	 * @generated
	 */
	EAttribute getStringParameter_Value();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.EObjectParameter <em>EObject Parameter</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject Parameter</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.EObjectParameter
	 * @generated
	 */
	EClass getEObjectParameter();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.reqcycle.predicates.core.api.EObjectParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.EObjectParameter#getValue()
	 * @see #getEObjectParameter()
	 * @generated
	 */
	EReference getEObjectParameter_Value();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.IPredicateContainer <em>IPredicate Container</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPredicate Container</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.IPredicateContainer
	 * @generated
	 */
	EClass getIPredicateContainer();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.reqcycle.predicates.core.api.IPredicateContainer#getResultPredicate <em>Result Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.IPredicateContainer#getResultPredicate()
	 * @see #getIPredicateContainer()
	 * @generated
	 */
	EReference getIPredicateContainer_ResultPredicate();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.IsTypeOfPredicate <em>Is Type Of Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Type Of Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.IsTypeOfPredicate
	 * @generated
	 */
	EClass getIsTypeOfPredicate();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.reqcycle.predicates.core.api.IsTypeOfPredicate#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.IsTypeOfPredicate#getType()
	 * @see #getIsTypeOfPredicate()
	 * @generated
	 */
	EReference getIsTypeOfPredicate_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.predicates.core.api.IsTypeOfPredicate#isIsStrictTypeOf <em>Is Strict Type Of</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Strict Type Of</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.IsTypeOfPredicate#isIsStrictTypeOf()
	 * @see #getIsTypeOfPredicate()
	 * @generated
	 */
	EAttribute getIsTypeOfPredicate_IsStrictTypeOf();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.IsNullPredicate <em>Is Null Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Null Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.IsNullPredicate
	 * @generated
	 */
	EClass getIsNullPredicate();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.predicates.core.api.NotPredicate <em>Not Predicate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Predicate</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.NotPredicate
	 * @generated
	 */
	EClass getNotPredicate();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.reqcycle.predicates.core.api.OPERATOR <em>OPERATOR</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>OPERATOR</em>'.
	 * @see org.polarsys.reqcycle.predicates.core.api.OPERATOR
	 * @generated
	 */
	EEnum getOPERATOR();

	/**
	 * Returns the meta object for data type '{@link java.util.regex.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Pattern</em>'.
	 * @see java.util.regex.Pattern
	 * @model instanceClass="java.util.regex.Pattern"
	 * @generated
	 */
	EDataType getPattern();

	/**
	 * Returns the meta object for data type '{@link java.lang.CharSequence <em>Char Sequence</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Char Sequence</em>'.
	 * @see java.lang.CharSequence
	 * @model instanceClass="java.lang.CharSequence"
	 * @generated
	 */
	EDataType getCharSequence();

	/**
	 * Returns the meta object for data type '{@link java.lang.Number <em>Number</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Number</em>'.
	 * @see java.lang.Number
	 * @model instanceClass="java.lang.Number"
	 * @generated
	 */
	EDataType getNumber();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PredicatesFactory getPredicatesFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.api.IPredicate <em>IPredicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.api.IPredicate
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getIPredicate()
		 * @generated
		 */
		EClass IPREDICATE = eINSTANCE.getIPredicate();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPREDICATE__DISPLAY_NAME = eINSTANCE.getIPredicate_DisplayName();

		/**
		 * The meta object literal for the '<em><b>Match</b></em>' operation.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IPREDICATE___MATCH__OBJECT = eINSTANCE.getIPredicate__Match__Object();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.CompositePredicateImpl <em>Composite Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.CompositePredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getCompositePredicate()
		 * @generated
		 */
		EClass COMPOSITE_PREDICATE = eINSTANCE.getCompositePredicate();

		/**
		 * The meta object literal for the '<em><b>Predicates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_PREDICATE__PREDICATES = eINSTANCE.getCompositePredicate_Predicates();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.api.CustomPredicate <em>Custom Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.api.CustomPredicate
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getCustomPredicate()
		 * @generated
		 */
		EClass CUSTOM_PREDICATE = eINSTANCE.getCustomPredicate();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.EqualPredicateImpl <em>Equal Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.EqualPredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getEqualPredicate()
		 * @generated
		 */
		EClass EQUAL_PREDICATE = eINSTANCE.getEqualPredicate();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUAL_PREDICATE__INPUT = eINSTANCE.getEqualPredicate_Input();

		/**
		 * The meta object literal for the '<em><b>Expected Object</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUAL_PREDICATE__EXPECTED_OBJECT = eINSTANCE.getEqualPredicate_ExpectedObject();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.StringEqualPredicateImpl <em>String Equal Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.StringEqualPredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getStringEqualPredicate()
		 * @generated
		 */
		EClass STRING_EQUAL_PREDICATE = eINSTANCE.getStringEqualPredicate();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.DateEqualPredicateImpl <em>Date Equal Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.DateEqualPredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getDateEqualPredicate()
		 * @generated
		 */
		EClass DATE_EQUAL_PREDICATE = eINSTANCE.getDateEqualPredicate();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.EnumEqualPredicateImpl <em>Enum Equal Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.EnumEqualPredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getEnumEqualPredicate()
		 * @generated
		 */
		EClass ENUM_EQUAL_PREDICATE = eINSTANCE.getEnumEqualPredicate();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.BooleanEqualPredicateImpl <em>Boolean Equal Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.BooleanEqualPredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getBooleanEqualPredicate()
		 * @generated
		 */
		EClass BOOLEAN_EQUAL_PREDICATE = eINSTANCE.getBooleanEqualPredicate();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.ContainsPatternPredicateImpl <em>Contains Pattern Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.ContainsPatternPredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getContainsPatternPredicate()
		 * @generated
		 */
		EClass CONTAINS_PATTERN_PREDICATE = eINSTANCE.getContainsPatternPredicate();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINS_PATTERN_PREDICATE__INPUT = eINSTANCE.getContainsPatternPredicate_Input();

		/**
		 * The meta object literal for the '<em><b>Expected Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINS_PATTERN_PREDICATE__EXPECTED_PATTERN = eINSTANCE.getContainsPatternPredicate_ExpectedPattern();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.IntoPredicateImpl <em>Into Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.IntoPredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getIntoPredicate()
		 * @generated
		 */
		EClass INTO_PREDICATE = eINSTANCE.getIntoPredicate();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTO_PREDICATE__INPUT = eINSTANCE.getIntoPredicate_Input();

		/**
		 * The meta object literal for the '<em><b>Allowed Entries</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTO_PREDICATE__ALLOWED_ENTRIES = eINSTANCE.getIntoPredicate_AllowedEntries();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.StringIntoPredicateImpl <em>String Into Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.StringIntoPredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getStringIntoPredicate()
		 * @generated
		 */
		EClass STRING_INTO_PREDICATE = eINSTANCE.getStringIntoPredicate();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.EnumIntoPredicateImpl <em>Enum Into Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.EnumIntoPredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getEnumIntoPredicate()
		 * @generated
		 */
		EClass ENUM_INTO_PREDICATE = eINSTANCE.getEnumIntoPredicate();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.AndPredicateImpl <em>And Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.AndPredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getAndPredicate()
		 * @generated
		 */
		EClass AND_PREDICATE = eINSTANCE.getAndPredicate();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.OrPredicateImpl <em>Or Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.OrPredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getOrPredicate()
		 * @generated
		 */
		EClass OR_PREDICATE = eINSTANCE.getOrPredicate();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.CompareNumberPredicateImpl <em>Compare Number Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.CompareNumberPredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getCompareNumberPredicate()
		 * @generated
		 */
		EClass COMPARE_NUMBER_PREDICATE = eINSTANCE.getCompareNumberPredicate();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARE_NUMBER_PREDICATE__INPUT = eINSTANCE.getCompareNumberPredicate_Input();

		/**
		 * The meta object literal for the '<em><b>Expected Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARE_NUMBER_PREDICATE__EXPECTED_VALUE = eINSTANCE.getCompareNumberPredicate_ExpectedValue();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARE_NUMBER_PREDICATE__OPERATOR = eINSTANCE.getCompareNumberPredicate_Operator();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.api.ITypedPredicate <em>ITyped Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.api.ITypedPredicate
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getITypedPredicate()
		 * @generated
		 */
		EClass ITYPED_PREDICATE = eINSTANCE.getITypedPredicate();

		/**
		 * The meta object literal for the '<em><b>Typed Element</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITYPED_PREDICATE__TYPED_ELEMENT = eINSTANCE.getITypedPredicate_TypedElement();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.IEAttrPredicateImpl <em>IE Attr Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.IEAttrPredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getIEAttrPredicate()
		 * @generated
		 */
		EClass IE_ATTR_PREDICATE = eINSTANCE.getIEAttrPredicate();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.api.IEClassifierPredicate <em>IE Classifier Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.api.IEClassifierPredicate
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getIEClassifierPredicate()
		 * @generated
		 */
		EClass IE_CLASSIFIER_PREDICATE = eINSTANCE.getIEClassifierPredicate();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.TruePredicateImpl <em>True Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.TruePredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getTruePredicate()
		 * @generated
		 */
		EClass TRUE_PREDICATE = eINSTANCE.getTruePredicate();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.OperationPredicateImpl <em>Operation Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.OperationPredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getOperationPredicate()
		 * @generated
		 */
		EClass OPERATION_PREDICATE = eINSTANCE.getOperationPredicate();

		/**
		 * The meta object literal for the '<em><b>Operation Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_PREDICATE__OPERATION_NAME = eINSTANCE.getOperationPredicate_OperationName();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_PREDICATE__PARAMETERS = eINSTANCE.getOperationPredicate_Parameters();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.ParameterImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Get Object Value</b></em>' operation.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETER___GET_OBJECT_VALUE = eINSTANCE.getParameter__GetObjectValue();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.IntParameterImpl <em>Int Parameter</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.IntParameterImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getIntParameter()
		 * @generated
		 */
		EClass INT_PARAMETER = eINSTANCE.getIntParameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_PARAMETER__VALUE = eINSTANCE.getIntParameter_Value();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.BooleanParameterImpl <em>Boolean Parameter</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.BooleanParameterImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getBooleanParameter()
		 * @generated
		 */
		EClass BOOLEAN_PARAMETER = eINSTANCE.getBooleanParameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_PARAMETER__VALUE = eINSTANCE.getBooleanParameter_Value();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.StringParameterImpl <em>String Parameter</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.StringParameterImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getStringParameter()
		 * @generated
		 */
		EClass STRING_PARAMETER = eINSTANCE.getStringParameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_PARAMETER__VALUE = eINSTANCE.getStringParameter_Value();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.EObjectParameterImpl <em>EObject Parameter</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.EObjectParameterImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getEObjectParameter()
		 * @generated
		 */
		EClass EOBJECT_PARAMETER = eINSTANCE.getEObjectParameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOBJECT_PARAMETER__VALUE = eINSTANCE.getEObjectParameter_Value();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.IPredicateContainerImpl <em>IPredicate Container</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.IPredicateContainerImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getIPredicateContainer()
		 * @generated
		 */
		EClass IPREDICATE_CONTAINER = eINSTANCE.getIPredicateContainer();

		/**
		 * The meta object literal for the '<em><b>Result Predicate</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference IPREDICATE_CONTAINER__RESULT_PREDICATE = eINSTANCE.getIPredicateContainer_ResultPredicate();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.IsTypeOfPredicateImpl <em>Is Type Of Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.IsTypeOfPredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getIsTypeOfPredicate()
		 * @generated
		 */
		EClass IS_TYPE_OF_PREDICATE = eINSTANCE.getIsTypeOfPredicate();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference IS_TYPE_OF_PREDICATE__TYPE = eINSTANCE.getIsTypeOfPredicate_Type();

		/**
		 * The meta object literal for the '<em><b>Is Strict Type Of</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IS_TYPE_OF_PREDICATE__IS_STRICT_TYPE_OF = eINSTANCE.getIsTypeOfPredicate_IsStrictTypeOf();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.IsNullPredicateImpl <em>Is Null Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.IsNullPredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getIsNullPredicate()
		 * @generated
		 */
		EClass IS_NULL_PREDICATE = eINSTANCE.getIsNullPredicate();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.impl.NotPredicateImpl <em>Not Predicate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.impl.NotPredicateImpl
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getNotPredicate()
		 * @generated
		 */
		EClass NOT_PREDICATE = eINSTANCE.getNotPredicate();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.predicates.core.api.OPERATOR <em>OPERATOR</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.predicates.core.api.OPERATOR
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getOPERATOR()
		 * @generated
		 */
		EEnum OPERATOR = eINSTANCE.getOPERATOR();

		/**
		 * The meta object literal for the '<em>Pattern</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see java.util.regex.Pattern
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getPattern()
		 * @generated
		 */
		EDataType PATTERN = eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '<em>Char Sequence</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see java.lang.CharSequence
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getCharSequence()
		 * @generated
		 */
		EDataType CHAR_SEQUENCE = eINSTANCE.getCharSequence();

		/**
		 * The meta object literal for the '<em>Number</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see java.lang.Number
		 * @see org.polarsys.reqcycle.predicates.core.impl.PredicatesPackageImpl#getNumber()
		 * @generated
		 */
		EDataType NUMBER = eINSTANCE.getNumber();

	}

} // PredicatesPackage
