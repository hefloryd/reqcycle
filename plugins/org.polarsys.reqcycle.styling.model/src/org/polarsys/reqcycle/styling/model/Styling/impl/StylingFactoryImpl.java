/**
 * Copyright (c) 2014 AtoS
 *     All rights reserved. This program and the accompanying materials
 *     are made available under the terms of the Eclipse Public License v1.0
 *     which accompanies this distribution, and is available at
 *     http://www.eclipse.org/legal/epl-v10.html *
 *     Contributors:
 *       Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.styling.model.Styling.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.polarsys.reqcycle.styling.model.Styling.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StylingFactoryImpl extends EFactoryImpl implements StylingFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2014 AtoS\r\n    All rights reserved. This program and the accompanying materials\r\n    are made available under the terms of the Eclipse Public License v1.0\r\n    which accompanies this distribution, and is available at\r\n    http://www.eclipse.org/legal/epl-v10.html *\r\n    Contributors:\r\n      Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StylingFactory init() {
		try {
			StylingFactory theStylingFactory = (StylingFactory)EPackage.Registry.INSTANCE.getEFactory(StylingPackage.eNS_URI);
			if (theStylingFactory != null) {
				return theStylingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StylingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StylingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StylingPackage.STYLING_MODEL: return createStylingModel();
			case StylingPackage.STYLING_PREDICATE: return createStylingPredicate();
			case StylingPackage.SEGMENT: return createSegment();
			case StylingPackage.ICON: return createIcon();
			case StylingPackage.STYLE: return createStyle();
			case StylingPackage.DEFAULT: return createDefault();
			case StylingPackage.STYLING: return createStyling();
			case StylingPackage.CONSTANT_PATTERN: return createConstantPattern();
			case StylingPackage.MODEL_PATTERN: return createModelPattern();
			case StylingPackage.OPERATION_PATTERN: return createOperationPattern();
			case StylingPackage.INT_PARAMETER: return createIntParameter();
			case StylingPackage.BOOLEAN_PARAMETER: return createBooleanParameter();
			case StylingPackage.STRING_PARAMETER: return createStringParameter();
			case StylingPackage.EOBJECT_PARAMETER: return createEObjectParameter();
			case StylingPackage.BASIC: return createBasic();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case StylingPackage.FONT_OPTION:
				return createFontOptionFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case StylingPackage.FONT_OPTION:
				return convertFontOptionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StylingModel createStylingModel() {
		StylingModelImpl stylingModel = new StylingModelImpl();
		return stylingModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StylingPredicate createStylingPredicate() {
		StylingPredicateImpl stylingPredicate = new StylingPredicateImpl();
		return stylingPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Segment createSegment() {
		SegmentImpl segment = new SegmentImpl();
		return segment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Icon createIcon() {
		IconImpl icon = new IconImpl();
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Style createStyle() {
		StyleImpl style = new StyleImpl();
		return style;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Default createDefault() {
		DefaultImpl default_ = new DefaultImpl();
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Styling createStyling() {
		StylingImpl styling = new StylingImpl();
		return styling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantPattern createConstantPattern() {
		ConstantPatternImpl constantPattern = new ConstantPatternImpl();
		return constantPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelPattern createModelPattern() {
		ModelPatternImpl modelPattern = new ModelPatternImpl();
		return modelPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationPattern createOperationPattern() {
		OperationPatternImpl operationPattern = new OperationPatternImpl();
		return operationPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntParameter createIntParameter() {
		IntParameterImpl intParameter = new IntParameterImpl();
		return intParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanParameter createBooleanParameter() {
		BooleanParameterImpl booleanParameter = new BooleanParameterImpl();
		return booleanParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringParameter createStringParameter() {
		StringParameterImpl stringParameter = new StringParameterImpl();
		return stringParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObjectParameter createEObjectParameter() {
		EObjectParameterImpl eObjectParameter = new EObjectParameterImpl();
		return eObjectParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Basic createBasic() {
		BasicImpl basic = new BasicImpl();
		return basic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontOption createFontOptionFromString(EDataType eDataType, String initialValue) {
		FontOption result = FontOption.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFontOptionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StylingPackage getStylingPackage() {
		return (StylingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StylingPackage getPackage() {
		return StylingPackage.eINSTANCE;
	}

} //StylingFactoryImpl
