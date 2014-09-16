/**
 * Copyright (c) 2014 AtoS
 *     All rights reserved. This program and the accompanying materials
 *     are made available under the terms of the Eclipse Public License v1.0
 *     which accompanies this distribution, and is available at
 *     http://www.eclipse.org/legal/epl-v10.html *
 *     Contributors:
 *       Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.styling.model.Styling.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.polarsys.reqcycle.styling.model.Styling.*;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see org.polarsys.reqcycle.styling.model.Styling.StylingPackage
 * @generated
 */
public class StylingAdapterFactory extends AdapterFactoryImpl {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2014 AtoS\r\n    All rights reserved. This program and the accompanying materials\r\n    are made available under the terms of the Eclipse Public License v1.0\r\n    which accompanies this distribution, and is available at\r\n    http://www.eclipse.org/legal/epl-v10.html *\r\n    Contributors:\r\n      Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static StylingPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StylingAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = StylingPackage.eINSTANCE;
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
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StylingSwitch<Adapter> modelSwitch = new StylingSwitch<Adapter>() {
		@Override
		public Adapter caseStylingModel(StylingModel object) {
			return createStylingModelAdapter();
		}

		@Override
		public Adapter caseStylingPredicate(StylingPredicate object) {
			return createStylingPredicateAdapter();
		}

		@Override
		public Adapter caseSegment(Segment object) {
			return createSegmentAdapter();
		}

		@Override
		public Adapter caseIcon(Icon object) {
			return createIconAdapter();
		}

		@Override
		public Adapter caseStyle(Style object) {
			return createStyleAdapter();
		}

		@Override
		public Adapter caseCaseStyle(CaseStyle object) {
			return createCaseStyleAdapter();
		}

		@Override
		public Adapter caseDefault(Default object) {
			return createDefaultAdapter();
		}

		@Override
		public Adapter caseStyling(Styling object) {
			return createStylingAdapter();
		}

		@Override
		public Adapter casePattern(Pattern object) {
			return createPatternAdapter();
		}

		@Override
		public Adapter caseConstantPattern(ConstantPattern object) {
			return createConstantPatternAdapter();
		}

		@Override
		public Adapter caseModelPattern(ModelPattern object) {
			return createModelPatternAdapter();
		}

		@Override
		public Adapter caseOperationPattern(OperationPattern object) {
			return createOperationPatternAdapter();
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
		public Adapter caseBasic(Basic object) {
			return createBasicAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param target
	 *            the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.styling.model.Styling.StylingModel <em>Model</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.styling.model.Styling.StylingModel
	 * @generated
	 */
	public Adapter createStylingModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.styling.model.Styling.StylingPredicate <em>Predicate</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.styling.model.Styling.StylingPredicate
	 * @generated
	 */
	public Adapter createStylingPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.styling.model.Styling.Segment <em>Segment</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Segment
	 * @generated
	 */
	public Adapter createSegmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.styling.model.Styling.Icon <em>Icon</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a
	 * case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Icon
	 * @generated
	 */
	public Adapter createIconAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.styling.model.Styling.Style <em>Style</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore
	 * a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Style
	 * @generated
	 */
	public Adapter createStyleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.styling.model.Styling.CaseStyle <em>Case Style</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.styling.model.Styling.CaseStyle
	 * @generated
	 */
	public Adapter createCaseStyleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.styling.model.Styling.Default <em>Default</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Default
	 * @generated
	 */
	public Adapter createDefaultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.styling.model.Styling.Styling <em>Styling</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Styling
	 * @generated
	 */
	public Adapter createStylingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.styling.model.Styling.Pattern <em>Pattern</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Pattern
	 * @generated
	 */
	public Adapter createPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.styling.model.Styling.ConstantPattern <em>Constant Pattern</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.styling.model.Styling.ConstantPattern
	 * @generated
	 */
	public Adapter createConstantPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.styling.model.Styling.ModelPattern <em>Model Pattern</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.styling.model.Styling.ModelPattern
	 * @generated
	 */
	public Adapter createModelPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.styling.model.Styling.OperationPattern <em>Operation Pattern</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.styling.model.Styling.OperationPattern
	 * @generated
	 */
	public Adapter createOperationPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.styling.model.Styling.Parameter <em>Parameter</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.styling.model.Styling.IntParameter <em>Int Parameter</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.styling.model.Styling.IntParameter
	 * @generated
	 */
	public Adapter createIntParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.styling.model.Styling.BooleanParameter <em>Boolean Parameter</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.styling.model.Styling.BooleanParameter
	 * @generated
	 */
	public Adapter createBooleanParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.styling.model.Styling.StringParameter <em>String Parameter</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.styling.model.Styling.StringParameter
	 * @generated
	 */
	public Adapter createStringParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.styling.model.Styling.EObjectParameter <em>EObject Parameter</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.styling.model.Styling.EObjectParameter
	 * @generated
	 */
	public Adapter createEObjectParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.reqcycle.styling.model.Styling.Basic <em>Basic</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore
	 * a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Basic
	 * @generated
	 */
	public Adapter createBasicAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case. <!-- begin-user-doc --> This default implementation returns null. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // StylingAdapterFactory
