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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * @see org.polarsys.reqcycle.predicates.core.PredicatesPackage
 * @generated
 */
public class PredicatesAdapterFactory extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static PredicatesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PredicatesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PredicatesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc --> This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model. <!-- end-user-doc
	 * -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PredicatesSwitch<Adapter> modelSwitch = new PredicatesSwitch<Adapter>() {
			@Override
			public Adapter caseIPredicate(IPredicate object) {
				return createIPredicateAdapter();
			}
			@Override
			public Adapter caseCompositePredicate(CompositePredicate object) {
				return createCompositePredicateAdapter();
			}
			@Override
			public Adapter caseCustomPredicate(CustomPredicate object) {
				return createCustomPredicateAdapter();
			}
			@Override
			public <T extends Object> Adapter caseEqualPredicate(EqualPredicate<T> object) {
				return createEqualPredicateAdapter();
			}
			@Override
			public Adapter caseStringEqualPredicate(StringEqualPredicate object) {
				return createStringEqualPredicateAdapter();
			}
			@Override
			public Adapter caseDateEqualPredicate(DateEqualPredicate object) {
				return createDateEqualPredicateAdapter();
			}
			@Override
			public Adapter caseEnumEqualPredicate(EnumEqualPredicate object) {
				return createEnumEqualPredicateAdapter();
			}
			@Override
			public Adapter caseBooleanEqualPredicate(BooleanEqualPredicate object) {
				return createBooleanEqualPredicateAdapter();
			}
			@Override
			public Adapter caseContainsPatternPredicate(ContainsPatternPredicate object) {
				return createContainsPatternPredicateAdapter();
			}
			@Override
			public <T> Adapter caseIntoPredicate(IntoPredicate<T> object) {
				return createIntoPredicateAdapter();
			}
			@Override
			public Adapter caseStringIntoPredicate(StringIntoPredicate object) {
				return createStringIntoPredicateAdapter();
			}
			@Override
			public Adapter caseEnumIntoPredicate(EnumIntoPredicate object) {
				return createEnumIntoPredicateAdapter();
			}
			@Override
			public Adapter caseAndPredicate(AndPredicate object) {
				return createAndPredicateAdapter();
			}
			@Override
			public Adapter caseOrPredicate(OrPredicate object) {
				return createOrPredicateAdapter();
			}
			@Override
			public Adapter caseNotPredicate(NotPredicate object) {
				return createNotPredicateAdapter();
			}
			@Override
			public Adapter caseCompareNumberPredicate(CompareNumberPredicate object) {
				return createCompareNumberPredicateAdapter();
			}
			@Override
			public <T> Adapter caseITypedPredicate(ITypedPredicate<T> object) {
				return createITypedPredicateAdapter();
			}
			@Override
			public Adapter caseIEAttrPredicate(IEAttrPredicate object) {
				return createIEAttrPredicateAdapter();
			}
			@Override
			public Adapter caseIEClassifierPredicate(IEClassifierPredicate object) {
				return createIEClassifierPredicateAdapter();
			}
			@Override
			public Adapter caseTruePredicate(TruePredicate object) {
				return createTruePredicateAdapter();
			}
			@Override
			public Adapter caseOperationPredicate(OperationPredicate object) {
				return createOperationPredicateAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseIntParameter(IntParameter object) {
				return createIntParameterAdapter();
			}
			@Override
			public Adapter caseBooleanParameter(BooleanParameter object) {
				return createBooleanParameterAdapter();
			}
			@Override
			public Adapter caseStringParameter(StringParameter object) {
				return createStringParameterAdapter();
			}
			@Override
			public Adapter caseEObjectParameter(EObjectParameter object) {
				return createEObjectParameterAdapter();
			}
			@Override
			public Adapter caseIPredicateContainer(IPredicateContainer object) {
				return createIPredicateContainerAdapter();
			}
			@Override
			public Adapter caseIsTypeOfPredicate(IsTypeOfPredicate object) {
				return createIsTypeOfPredicateAdapter();
			}
			@Override
			public Adapter caseIsNullPredicate(IsNullPredicate object) {
				return createIsNullPredicateAdapter();
			}
			@Override
			public Adapter caseIListeningPredicate(IListeningPredicate object) {
				return createIListeningPredicateAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.IPredicate <em>IPredicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.IPredicate
	 * @generated
	 */
	public Adapter createIPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.CompositePredicate <em>Composite Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.CompositePredicate
	 * @generated
	 */
	public Adapter createCompositePredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.CustomPredicate <em>Custom Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.CustomPredicate
	 * @generated
	 */
	public Adapter createCustomPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.EqualPredicate <em>Equal Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.EqualPredicate
	 * @generated
	 */
	public Adapter createEqualPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.StringEqualPredicate <em>String Equal Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.StringEqualPredicate
	 * @generated
	 */
	public Adapter createStringEqualPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.DateEqualPredicate <em>Date Equal Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.DateEqualPredicate
	 * @generated
	 */
	public Adapter createDateEqualPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.EnumEqualPredicate <em>Enum Equal Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.EnumEqualPredicate
	 * @generated
	 */
	public Adapter createEnumEqualPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.BooleanEqualPredicate <em>Boolean Equal Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.BooleanEqualPredicate
	 * @generated
	 */
	public Adapter createBooleanEqualPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.ContainsPatternPredicate <em>Contains Pattern Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.ContainsPatternPredicate
	 * @generated
	 */
	public Adapter createContainsPatternPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.IntoPredicate <em>Into Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.IntoPredicate
	 * @generated
	 */
	public Adapter createIntoPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.StringIntoPredicate <em>String Into Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.StringIntoPredicate
	 * @generated
	 */
	public Adapter createStringIntoPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.EnumIntoPredicate <em>Enum Into Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.EnumIntoPredicate
	 * @generated
	 */
	public Adapter createEnumIntoPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.AndPredicate <em>And Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.AndPredicate
	 * @generated
	 */
	public Adapter createAndPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.OrPredicate <em>Or Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.OrPredicate
	 * @generated
	 */
	public Adapter createOrPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.CompareNumberPredicate <em>Compare Number Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.CompareNumberPredicate
	 * @generated
	 */
	public Adapter createCompareNumberPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.ITypedPredicate <em>ITyped Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.ITypedPredicate
	 * @generated
	 */
	public Adapter createITypedPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.IEAttrPredicate <em>IE Attr Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.IEAttrPredicate
	 * @generated
	 */
	public Adapter createIEAttrPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.IEClassifierPredicate <em>IE Classifier Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.IEClassifierPredicate
	 * @generated
	 */
	public Adapter createIEClassifierPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.TruePredicate <em>True Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.TruePredicate
	 * @generated
	 */
	public Adapter createTruePredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.OperationPredicate <em>Operation Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.OperationPredicate
	 * @generated
	 */
	public Adapter createOperationPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.IntParameter <em>Int Parameter</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.IntParameter
	 * @generated
	 */
	public Adapter createIntParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.BooleanParameter <em>Boolean Parameter</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.BooleanParameter
	 * @generated
	 */
	public Adapter createBooleanParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.StringParameter <em>String Parameter</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.StringParameter
	 * @generated
	 */
	public Adapter createStringParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.EObjectParameter <em>EObject Parameter</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.EObjectParameter
	 * @generated
	 */
	public Adapter createEObjectParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.IPredicateContainer <em>IPredicate Container</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.IPredicateContainer
	 * @generated
	 */
	public Adapter createIPredicateContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.IsTypeOfPredicate <em>Is Type Of Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.IsTypeOfPredicate
	 * @generated
	 */
	public Adapter createIsTypeOfPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.IsNullPredicate <em>Is Null Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.IsNullPredicate
	 * @generated
	 */
	public Adapter createIsNullPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.IListeningPredicate <em>IListening Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.IListeningPredicate
	 * @generated
	 */
	public Adapter createIListeningPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.predicates.core.api.NotPredicate <em>Not Predicate</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.predicates.core.api.NotPredicate
	 * @generated
	 */
	public Adapter createNotPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This default implementation returns null. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // PredicatesAdapterFactory
