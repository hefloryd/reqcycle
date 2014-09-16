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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.jface.viewers.StyledString;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

import org.polarsys.reqcycle.predicates.core.PredicatesPackage;

import org.polarsys.reqcycle.styling.model.Styling.Basic;
import org.polarsys.reqcycle.styling.model.Styling.BooleanParameter;
import org.polarsys.reqcycle.styling.model.Styling.CaseStyle;
import org.polarsys.reqcycle.styling.model.Styling.ConstantPattern;
import org.polarsys.reqcycle.styling.model.Styling.Default;
import org.polarsys.reqcycle.styling.model.Styling.EObjectParameter;
import org.polarsys.reqcycle.styling.model.Styling.FontOption;
import org.polarsys.reqcycle.styling.model.Styling.Icon;
import org.polarsys.reqcycle.styling.model.Styling.IntParameter;
import org.polarsys.reqcycle.styling.model.Styling.ModelPattern;
import org.polarsys.reqcycle.styling.model.Styling.OperationPattern;
import org.polarsys.reqcycle.styling.model.Styling.Parameter;
import org.polarsys.reqcycle.styling.model.Styling.Pattern;
import org.polarsys.reqcycle.styling.model.Styling.Segment;
import org.polarsys.reqcycle.styling.model.Styling.StringParameter;
import org.polarsys.reqcycle.styling.model.Styling.Style;
import org.polarsys.reqcycle.styling.model.Styling.Styling;
import org.polarsys.reqcycle.styling.model.Styling.StylingFactory;
import org.polarsys.reqcycle.styling.model.Styling.StylingModel;
import org.polarsys.reqcycle.styling.model.Styling.StylingPackage;
import org.polarsys.reqcycle.styling.model.Styling.StylingPredicate;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class StylingPackageImpl extends EPackageImpl implements StylingPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2014 AtoS\r\n    All rights reserved. This program and the accompanying materials\r\n    are made available under the terms of the Eclipse Public License v1.0\r\n    which accompanies this distribution, and is available at\r\n    http://www.eclipse.org/legal/epl-v10.html *\r\n    Contributors:\r\n      Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stylingModelEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stylingPredicateEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass segmentEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iconEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass styleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass caseStyleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass defaultEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stylingEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass patternEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass constantPatternEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass modelPatternEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass operationPatternEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass intParameterEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass booleanParameterEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stringParameterEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass eObjectParameterEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass basicEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum fontOptionEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType colorEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType fontEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType styledStringEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType imageEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.polarsys.reqcycle.styling.model.Styling.StylingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StylingPackageImpl() {
		super(eNS_URI, StylingFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link StylingPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StylingPackage init() {
		if (isInited)
			return (StylingPackage) EPackage.Registry.INSTANCE.getEPackage(StylingPackage.eNS_URI);

		// Obtain or create and register package
		StylingPackageImpl theStylingPackage = (StylingPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StylingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StylingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PredicatesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theStylingPackage.createPackageContents();

		// Initialize created meta-data
		theStylingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStylingPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StylingPackage.eNS_URI, theStylingPackage);
		return theStylingPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStylingModel() {
		return stylingModelEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStylingModel_Styles() {
		return (EReference) stylingModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getStylingModel_ModeName() {
		return (EAttribute) stylingModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStylingModel_Default() {
		return (EReference) stylingModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStylingModel_Basic() {
		return (EReference) stylingModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStylingPredicate() {
		return stylingPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStylingPredicate_Predicate() {
		return (EReference) stylingPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSegment() {
		return segmentEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSegment_Style() {
		return (EReference) segmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSegment_Pattern() {
		return (EReference) segmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getSegment__GetColor() {
		return segmentEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getSegment__GetFont() {
		return segmentEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getSegment__SetColor__Color() {
		return segmentEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIcon() {
		return iconEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIcon_Image() {
		return (EAttribute) iconEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStyle() {
		return styleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getStyle_AppliedFonts() {
		return (EAttribute) styleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getStyle_Color() {
		return (EAttribute) styleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCaseStyle() {
		return caseStyleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCaseStyle_Segments() {
		return (EReference) caseStyleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCaseStyle_Icon() {
		return (EReference) caseStyleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getCaseStyle__GetStyledString__Object() {
		return caseStyleEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getCaseStyle__GetImage() {
		return caseStyleEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDefault() {
		return defaultEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStyling() {
		return stylingEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStyling_Models() {
		return (EReference) stylingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPattern() {
		return patternEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getPattern__GetPattern() {
		return patternEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getPattern__GetPatternValue__Object() {
		return patternEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getConstantPattern() {
		return constantPatternEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getConstantPattern_Value() {
		return (EAttribute) constantPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getModelPattern() {
		return modelPatternEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getModelPattern_AttributeName() {
		return (EAttribute) modelPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOperationPattern() {
		return operationPatternEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getOperationPattern_Operation() {
		return (EAttribute) operationPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOperationPattern_Parameters() {
		return (EReference) operationPatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getParameter_Name() {
		return (EAttribute) parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getParameter__GetObjectValue() {
		return parameterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIntParameter() {
		return intParameterEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIntParameter_Value() {
		return (EAttribute) intParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getBooleanParameter() {
		return booleanParameterEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getBooleanParameter_Value() {
		return (EAttribute) booleanParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStringParameter() {
		return stringParameterEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getStringParameter_Value() {
		return (EAttribute) stringParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEObjectParameter() {
		return eObjectParameterEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEObjectParameter_Value() {
		return (EReference) eObjectParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getBasic() {
		return basicEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getFontOption() {
		return fontOptionEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getColor() {
		return colorEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getFont() {
		return fontEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getStyledString() {
		return styledStringEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getImage() {
		return imageEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StylingFactory getStylingFactory() {
		return (StylingFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to have no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		stylingModelEClass = createEClass(STYLING_MODEL);
		createEReference(stylingModelEClass, STYLING_MODEL__STYLES);
		createEAttribute(stylingModelEClass, STYLING_MODEL__MODE_NAME);
		createEReference(stylingModelEClass, STYLING_MODEL__DEFAULT);
		createEReference(stylingModelEClass, STYLING_MODEL__BASIC);

		stylingPredicateEClass = createEClass(STYLING_PREDICATE);
		createEReference(stylingPredicateEClass, STYLING_PREDICATE__PREDICATE);

		segmentEClass = createEClass(SEGMENT);
		createEReference(segmentEClass, SEGMENT__STYLE);
		createEReference(segmentEClass, SEGMENT__PATTERN);
		createEOperation(segmentEClass, SEGMENT___GET_COLOR);
		createEOperation(segmentEClass, SEGMENT___GET_FONT);
		createEOperation(segmentEClass, SEGMENT___SET_COLOR__COLOR);

		iconEClass = createEClass(ICON);
		createEAttribute(iconEClass, ICON__IMAGE);

		styleEClass = createEClass(STYLE);
		createEAttribute(styleEClass, STYLE__APPLIED_FONTS);
		createEAttribute(styleEClass, STYLE__COLOR);

		caseStyleEClass = createEClass(CASE_STYLE);
		createEReference(caseStyleEClass, CASE_STYLE__SEGMENTS);
		createEReference(caseStyleEClass, CASE_STYLE__ICON);
		createEOperation(caseStyleEClass, CASE_STYLE___GET_STYLED_STRING__OBJECT);
		createEOperation(caseStyleEClass, CASE_STYLE___GET_IMAGE);

		defaultEClass = createEClass(DEFAULT);

		stylingEClass = createEClass(STYLING);
		createEReference(stylingEClass, STYLING__MODELS);

		patternEClass = createEClass(PATTERN);
		createEOperation(patternEClass, PATTERN___GET_PATTERN);
		createEOperation(patternEClass, PATTERN___GET_PATTERN_VALUE__OBJECT);

		constantPatternEClass = createEClass(CONSTANT_PATTERN);
		createEAttribute(constantPatternEClass, CONSTANT_PATTERN__VALUE);

		modelPatternEClass = createEClass(MODEL_PATTERN);
		createEAttribute(modelPatternEClass, MODEL_PATTERN__ATTRIBUTE_NAME);

		operationPatternEClass = createEClass(OPERATION_PATTERN);
		createEAttribute(operationPatternEClass, OPERATION_PATTERN__OPERATION);
		createEReference(operationPatternEClass, OPERATION_PATTERN__PARAMETERS);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__NAME);
		createEOperation(parameterEClass, PARAMETER___GET_OBJECT_VALUE);

		intParameterEClass = createEClass(INT_PARAMETER);
		createEAttribute(intParameterEClass, INT_PARAMETER__VALUE);

		booleanParameterEClass = createEClass(BOOLEAN_PARAMETER);
		createEAttribute(booleanParameterEClass, BOOLEAN_PARAMETER__VALUE);

		stringParameterEClass = createEClass(STRING_PARAMETER);
		createEAttribute(stringParameterEClass, STRING_PARAMETER__VALUE);

		eObjectParameterEClass = createEClass(EOBJECT_PARAMETER);
		createEReference(eObjectParameterEClass, EOBJECT_PARAMETER__VALUE);

		basicEClass = createEClass(BASIC);

		// Create enums
		fontOptionEEnum = createEEnum(FONT_OPTION);

		// Create data types
		colorEDataType = createEDataType(COLOR);
		fontEDataType = createEDataType(FONT);
		styledStringEDataType = createEDataType(STYLED_STRING);
		imageEDataType = createEDataType(IMAGE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is guarded to have no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		PredicatesPackage thePredicatesPackage = (PredicatesPackage) EPackage.Registry.INSTANCE.getEPackage(PredicatesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		stylingPredicateEClass.getESuperTypes().add(this.getCaseStyle());
		defaultEClass.getESuperTypes().add(this.getCaseStyle());
		constantPatternEClass.getESuperTypes().add(this.getPattern());
		modelPatternEClass.getESuperTypes().add(this.getPattern());
		operationPatternEClass.getESuperTypes().add(this.getPattern());
		intParameterEClass.getESuperTypes().add(this.getParameter());
		booleanParameterEClass.getESuperTypes().add(this.getParameter());
		stringParameterEClass.getESuperTypes().add(this.getParameter());
		eObjectParameterEClass.getESuperTypes().add(this.getParameter());
		basicEClass.getESuperTypes().add(this.getCaseStyle());

		// Initialize classes, features, and operations; add parameters
		initEClass(stylingModelEClass, StylingModel.class, "StylingModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStylingModel_Styles(), this.getCaseStyle(), null, "styles", null, 0, -1, StylingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStylingModel_ModeName(), ecorePackage.getEString(), "modeName", null, 0, 1, StylingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStylingModel_Default(), this.getDefault(), null, "default", null, 1, 1, StylingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStylingModel_Basic(), this.getBasic(), null, "basic", null, 1, 1, StylingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stylingPredicateEClass, StylingPredicate.class, "StylingPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStylingPredicate_Predicate(), thePredicatesPackage.getIPredicate(), null, "predicate", null, 0, 1, StylingPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(segmentEClass, Segment.class, "Segment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSegment_Style(), this.getStyle(), null, "style", null, 1, 1, Segment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSegment_Pattern(), this.getPattern(), null, "pattern", null, 1, 1, Segment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getSegment__GetColor(), this.getColor(), "getColor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getSegment__GetFont(), this.getFont(), "getFont", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getSegment__SetColor__Color(), null, "setColor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getColor(), "color", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(iconEClass, Icon.class, "Icon", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIcon_Image(), ecorePackage.getEString(), "image", null, 0, 1, Icon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(styleEClass, Style.class, "Style", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStyle_AppliedFonts(), this.getFontOption(), "appliedFonts", null, 0, -1, Style.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyle_Color(), ecorePackage.getEString(), "color", null, 0, 1, Style.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caseStyleEClass, CaseStyle.class, "CaseStyle", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCaseStyle_Segments(), this.getSegment(), null, "segments", null, 1, -1, CaseStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCaseStyle_Icon(), this.getIcon(), null, "icon", null, 1, 1, CaseStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getCaseStyle__GetStyledString__Object(), this.getStyledString(), "getStyledString", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getCaseStyle__GetImage(), this.getImage(), "getImage", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(defaultEClass, Default.class, "Default", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stylingEClass, Styling.class, "Styling", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStyling_Models(), this.getStylingModel(), null, "models", null, 0, -1, Styling.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternEClass, Pattern.class, "Pattern", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getPattern__GetPattern(), ecorePackage.getEString(), "getPattern", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getPattern__GetPatternValue__Object(), ecorePackage.getEString(), "getPatternValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(constantPatternEClass, ConstantPattern.class, "ConstantPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstantPattern_Value(), ecorePackage.getEString(), "value", null, 0, 1, ConstantPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelPatternEClass, ModelPattern.class, "ModelPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelPattern_AttributeName(), ecorePackage.getEString(), "attributeName", null, 0, 1, ModelPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationPatternEClass, OperationPattern.class, "OperationPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperationPattern_Operation(), ecorePackage.getEString(), "operation", null, 0, 1, OperationPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationPattern_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, OperationPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getParameter__GetObjectValue(), ecorePackage.getEJavaObject(), "getObjectValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(intParameterEClass, IntParameter.class, "IntParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntParameter_Value(), ecorePackage.getEInt(), "value", null, 0, 1, IntParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanParameterEClass, BooleanParameter.class, "BooleanParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanParameter_Value(), ecorePackage.getEBoolean(), "value", null, 0, 1, BooleanParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringParameterEClass, StringParameter.class, "StringParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringParameter_Value(), ecorePackage.getEString(), "value", null, 0, 1, StringParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eObjectParameterEClass, EObjectParameter.class, "EObjectParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEObjectParameter_Value(), ecorePackage.getEObject(), null, "value", null, 0, 1, EObjectParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(basicEClass, Basic.class, "Basic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(fontOptionEEnum, FontOption.class, "FontOption");
		addEEnumLiteral(fontOptionEEnum, FontOption.ITALIC);
		addEEnumLiteral(fontOptionEEnum, FontOption.BOLD);
		addEEnumLiteral(fontOptionEEnum, FontOption.UNDERLINE);
		addEEnumLiteral(fontOptionEEnum, FontOption.STRIKE);

		// Initialize data types
		initEDataType(colorEDataType, Color.class, "Color", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(fontEDataType, Font.class, "Font", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(styledStringEDataType, StyledString.class, "StyledString", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(imageEDataType, Image.class, "Image", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} // StylingPackageImpl
