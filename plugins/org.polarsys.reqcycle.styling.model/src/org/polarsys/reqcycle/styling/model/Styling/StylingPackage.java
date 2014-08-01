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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polarsys.reqcycle.styling.model.Styling.StylingFactory
 * @model kind="package"
 * @generated
 */
public interface StylingPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2014 AtoS\r\n    All rights reserved. This program and the accompanying materials\r\n    are made available under the terms of the Eclipse Public License v1.0\r\n    which accompanies this distribution, and is available at\r\n    http://www.eclipse.org/legal/epl-v10.html *\r\n    Contributors:\r\n      Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Styling";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.polarsys.org/ReqCycle/styling/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "styling";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StylingPackage eINSTANCE = org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.StylingModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingModelImpl
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getStylingModel()
	 * @generated
	 */
	int STYLING_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Styles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLING_MODEL__STYLES = 0;

	/**
	 * The feature id for the '<em><b>Mode Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLING_MODEL__MODE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLING_MODEL__DEFAULT = 2;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLING_MODEL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLING_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.CaseStyleImpl <em>Case Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.CaseStyleImpl
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getCaseStyle()
	 * @generated
	 */
	int CASE_STYLE = 5;

	/**
	 * The feature id for the '<em><b>Segments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STYLE__SEGMENTS = 0;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STYLE__ICON = 1;

	/**
	 * The number of structural features of the '<em>Case Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STYLE_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Get Styled String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STYLE___GET_STYLED_STRING__OBJECT = 0;

	/**
	 * The operation id for the '<em>Get Image</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STYLE___GET_IMAGE = 1;

	/**
	 * The number of operations of the '<em>Case Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STYLE_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.StylingPredicateImpl <em>Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPredicateImpl
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getStylingPredicate()
	 * @generated
	 */
	int STYLING_PREDICATE = 1;

	/**
	 * The feature id for the '<em><b>Segments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLING_PREDICATE__SEGMENTS = CASE_STYLE__SEGMENTS;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLING_PREDICATE__ICON = CASE_STYLE__ICON;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLING_PREDICATE__PREDICATE = CASE_STYLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLING_PREDICATE_FEATURE_COUNT = CASE_STYLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Styled String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLING_PREDICATE___GET_STYLED_STRING__OBJECT = CASE_STYLE___GET_STYLED_STRING__OBJECT;

	/**
	 * The operation id for the '<em>Get Image</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLING_PREDICATE___GET_IMAGE = CASE_STYLE___GET_IMAGE;

	/**
	 * The number of operations of the '<em>Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLING_PREDICATE_OPERATION_COUNT = CASE_STYLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.SegmentImpl <em>Segment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.SegmentImpl
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getSegment()
	 * @generated
	 */
	int SEGMENT = 2;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__STYLE = 0;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__PATTERN = 1;

	/**
	 * The number of structural features of the '<em>Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Get Color</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT___GET_COLOR = 0;

	/**
	 * The operation id for the '<em>Get Font</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT___GET_FONT = 1;

	/**
	 * The operation id for the '<em>Set Color</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT___SET_COLOR__COLOR = 2;

	/**
	 * The number of operations of the '<em>Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.IconImpl <em>Icon</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.IconImpl
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getIcon()
	 * @generated
	 */
	int ICON = 3;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON__IMAGE = 0;

	/**
	 * The number of structural features of the '<em>Icon</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Icon</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.StyleImpl <em>Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StyleImpl
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getStyle()
	 * @generated
	 */
	int STYLE = 4;

	/**
	 * The feature id for the '<em><b>Applied Fonts</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__APPLIED_FONTS = 0;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__COLOR = 1;

	/**
	 * The number of structural features of the '<em>Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.DefaultImpl <em>Default</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.DefaultImpl
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getDefault()
	 * @generated
	 */
	int DEFAULT = 6;

	/**
	 * The feature id for the '<em><b>Segments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT__SEGMENTS = CASE_STYLE__SEGMENTS;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT__ICON = CASE_STYLE__ICON;

	/**
	 * The number of structural features of the '<em>Default</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_FEATURE_COUNT = CASE_STYLE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Styled String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT___GET_STYLED_STRING__OBJECT = CASE_STYLE___GET_STYLED_STRING__OBJECT;

	/**
	 * The operation id for the '<em>Get Image</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT___GET_IMAGE = CASE_STYLE___GET_IMAGE;

	/**
	 * The number of operations of the '<em>Default</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_OPERATION_COUNT = CASE_STYLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.StylingImpl <em>Styling</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingImpl
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getStyling()
	 * @generated
	 */
	int STYLING = 7;

	/**
	 * The feature id for the '<em><b>Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLING__MODELS = 0;

	/**
	 * The number of structural features of the '<em>Styling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLING_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Styling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.PatternImpl <em>Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.PatternImpl
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 8;

	/**
	 * The number of structural features of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Get Pattern</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN___GET_PATTERN = 0;

	/**
	 * The operation id for the '<em>Get Pattern Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN___GET_PATTERN_VALUE__OBJECT = 1;

	/**
	 * The number of operations of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.ConstantPatternImpl <em>Constant Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.ConstantPatternImpl
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getConstantPattern()
	 * @generated
	 */
	int CONSTANT_PATTERN = 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_PATTERN__VALUE = PATTERN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constant Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_PATTERN_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Pattern</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_PATTERN___GET_PATTERN = PATTERN___GET_PATTERN;

	/**
	 * The operation id for the '<em>Get Pattern Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_PATTERN___GET_PATTERN_VALUE__OBJECT = PATTERN___GET_PATTERN_VALUE__OBJECT;

	/**
	 * The number of operations of the '<em>Constant Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_PATTERN_OPERATION_COUNT = PATTERN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.ModelPatternImpl <em>Model Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.ModelPatternImpl
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getModelPattern()
	 * @generated
	 */
	int MODEL_PATTERN = 10;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PATTERN__ATTRIBUTE_NAME = PATTERN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PATTERN_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Pattern</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PATTERN___GET_PATTERN = PATTERN___GET_PATTERN;

	/**
	 * The operation id for the '<em>Get Pattern Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PATTERN___GET_PATTERN_VALUE__OBJECT = PATTERN___GET_PATTERN_VALUE__OBJECT;

	/**
	 * The number of operations of the '<em>Model Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PATTERN_OPERATION_COUNT = PATTERN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.OperationPatternImpl <em>Operation Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.OperationPatternImpl
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getOperationPattern()
	 * @generated
	 */
	int OPERATION_PATTERN = 11;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATTERN__OPERATION = PATTERN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATTERN__PARAMETERS = PATTERN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATTERN_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Pattern</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATTERN___GET_PATTERN = PATTERN___GET_PATTERN;

	/**
	 * The operation id for the '<em>Get Pattern Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATTERN___GET_PATTERN_VALUE__OBJECT = PATTERN___GET_PATTERN_VALUE__OBJECT;

	/**
	 * The number of operations of the '<em>Operation Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATTERN_OPERATION_COUNT = PATTERN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.ParameterImpl
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Get Object Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER___GET_OBJECT_VALUE = 0;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.IntParameterImpl <em>Int Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.IntParameterImpl
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getIntParameter()
	 * @generated
	 */
	int INT_PARAMETER = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_PARAMETER__VALUE = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Object Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_PARAMETER___GET_OBJECT_VALUE = PARAMETER___GET_OBJECT_VALUE;

	/**
	 * The number of operations of the '<em>Int Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_PARAMETER_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.BooleanParameterImpl <em>Boolean Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.BooleanParameterImpl
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getBooleanParameter()
	 * @generated
	 */
	int BOOLEAN_PARAMETER = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PARAMETER__VALUE = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Object Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PARAMETER___GET_OBJECT_VALUE = PARAMETER___GET_OBJECT_VALUE;

	/**
	 * The number of operations of the '<em>Boolean Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PARAMETER_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.StringParameterImpl <em>String Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StringParameterImpl
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getStringParameter()
	 * @generated
	 */
	int STRING_PARAMETER = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PARAMETER__VALUE = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Object Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PARAMETER___GET_OBJECT_VALUE = PARAMETER___GET_OBJECT_VALUE;

	/**
	 * The number of operations of the '<em>String Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PARAMETER_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.EObjectParameterImpl <em>EObject Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.EObjectParameterImpl
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getEObjectParameter()
	 * @generated
	 */
	int EOBJECT_PARAMETER = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_PARAMETER__VALUE = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EObject Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Object Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_PARAMETER___GET_OBJECT_VALUE = PARAMETER___GET_OBJECT_VALUE;

	/**
	 * The number of operations of the '<em>EObject Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_PARAMETER_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.styling.model.Styling.FontOption <em>Font Option</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.styling.model.Styling.FontOption
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getFontOption()
	 * @generated
	 */
	int FONT_OPTION = 17;

	/**
	 * The meta object id for the '<em>Color</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.swt.graphics.Color
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getColor()
	 * @generated
	 */
	int COLOR = 18;

	/**
	 * The meta object id for the '<em>Font</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.swt.graphics.Font
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getFont()
	 * @generated
	 */
	int FONT = 19;

	/**
	 * The meta object id for the '<em>Styled String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jface.viewers.StyledString
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getStyledString()
	 * @generated
	 */
	int STYLED_STRING = 20;

	/**
	 * The meta object id for the '<em>Image</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.swt.graphics.Image
	 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 21;


	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.styling.model.Styling.StylingModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.StylingModel
	 * @generated
	 */
	EClass getStylingModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.styling.model.Styling.StylingModel#getStyles <em>Styles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Styles</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.StylingModel#getStyles()
	 * @see #getStylingModel()
	 * @generated
	 */
	EReference getStylingModel_Styles();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.styling.model.Styling.StylingModel#getModeName <em>Mode Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode Name</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.StylingModel#getModeName()
	 * @see #getStylingModel()
	 * @generated
	 */
	EAttribute getStylingModel_ModeName();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.reqcycle.styling.model.Styling.StylingModel#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.StylingModel#getDefault()
	 * @see #getStylingModel()
	 * @generated
	 */
	EReference getStylingModel_Default();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.styling.model.Styling.StylingPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.StylingPredicate
	 * @generated
	 */
	EClass getStylingPredicate();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.reqcycle.styling.model.Styling.StylingPredicate#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predicate</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.StylingPredicate#getPredicate()
	 * @see #getStylingPredicate()
	 * @generated
	 */
	EReference getStylingPredicate_Predicate();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.styling.model.Styling.Segment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Segment</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Segment
	 * @generated
	 */
	EClass getSegment();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.reqcycle.styling.model.Styling.Segment#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Style</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Segment#getStyle()
	 * @see #getSegment()
	 * @generated
	 */
	EReference getSegment_Style();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.reqcycle.styling.model.Styling.Segment#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pattern</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Segment#getPattern()
	 * @see #getSegment()
	 * @generated
	 */
	EReference getSegment_Pattern();

	/**
	 * Returns the meta object for the '{@link org.polarsys.reqcycle.styling.model.Styling.Segment#getColor() <em>Get Color</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Color</em>' operation.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Segment#getColor()
	 * @generated
	 */
	EOperation getSegment__GetColor();

	/**
	 * Returns the meta object for the '{@link org.polarsys.reqcycle.styling.model.Styling.Segment#getFont() <em>Get Font</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Font</em>' operation.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Segment#getFont()
	 * @generated
	 */
	EOperation getSegment__GetFont();

	/**
	 * Returns the meta object for the '{@link org.polarsys.reqcycle.styling.model.Styling.Segment#setColor(org.eclipse.swt.graphics.Color) <em>Set Color</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Color</em>' operation.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Segment#setColor(org.eclipse.swt.graphics.Color)
	 * @generated
	 */
	EOperation getSegment__SetColor__Color();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.styling.model.Styling.Icon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Icon</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Icon
	 * @generated
	 */
	EClass getIcon();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.styling.model.Styling.Icon#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Icon#getImage()
	 * @see #getIcon()
	 * @generated
	 */
	EAttribute getIcon_Image();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.styling.model.Styling.Style <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Style</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Style
	 * @generated
	 */
	EClass getStyle();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.reqcycle.styling.model.Styling.Style#getAppliedFonts <em>Applied Fonts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Applied Fonts</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Style#getAppliedFonts()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_AppliedFonts();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.styling.model.Styling.Style#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Style#getColor()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_Color();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.styling.model.Styling.CaseStyle <em>Case Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Style</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.CaseStyle
	 * @generated
	 */
	EClass getCaseStyle();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.styling.model.Styling.CaseStyle#getSegments <em>Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Segments</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.CaseStyle#getSegments()
	 * @see #getCaseStyle()
	 * @generated
	 */
	EReference getCaseStyle_Segments();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.reqcycle.styling.model.Styling.CaseStyle#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Icon</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.CaseStyle#getIcon()
	 * @see #getCaseStyle()
	 * @generated
	 */
	EReference getCaseStyle_Icon();

	/**
	 * Returns the meta object for the '{@link org.polarsys.reqcycle.styling.model.Styling.CaseStyle#getStyledString(java.lang.Object) <em>Get Styled String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Styled String</em>' operation.
	 * @see org.polarsys.reqcycle.styling.model.Styling.CaseStyle#getStyledString(java.lang.Object)
	 * @generated
	 */
	EOperation getCaseStyle__GetStyledString__Object();

	/**
	 * Returns the meta object for the '{@link org.polarsys.reqcycle.styling.model.Styling.CaseStyle#getImage() <em>Get Image</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Image</em>' operation.
	 * @see org.polarsys.reqcycle.styling.model.Styling.CaseStyle#getImage()
	 * @generated
	 */
	EOperation getCaseStyle__GetImage();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.styling.model.Styling.Default <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Default
	 * @generated
	 */
	EClass getDefault();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.styling.model.Styling.Styling <em>Styling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Styling</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Styling
	 * @generated
	 */
	EClass getStyling();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.styling.model.Styling.Styling#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Models</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Styling#getModels()
	 * @see #getStyling()
	 * @generated
	 */
	EReference getStyling_Models();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.styling.model.Styling.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for the '{@link org.polarsys.reqcycle.styling.model.Styling.Pattern#getPattern() <em>Get Pattern</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Pattern</em>' operation.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Pattern#getPattern()
	 * @generated
	 */
	EOperation getPattern__GetPattern();

	/**
	 * Returns the meta object for the '{@link org.polarsys.reqcycle.styling.model.Styling.Pattern#getPatternValue(java.lang.Object) <em>Get Pattern Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Pattern Value</em>' operation.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Pattern#getPatternValue(java.lang.Object)
	 * @generated
	 */
	EOperation getPattern__GetPatternValue__Object();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.styling.model.Styling.ConstantPattern <em>Constant Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Pattern</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.ConstantPattern
	 * @generated
	 */
	EClass getConstantPattern();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.styling.model.Styling.ConstantPattern#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.ConstantPattern#getValue()
	 * @see #getConstantPattern()
	 * @generated
	 */
	EAttribute getConstantPattern_Value();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.styling.model.Styling.ModelPattern <em>Model Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Pattern</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.ModelPattern
	 * @generated
	 */
	EClass getModelPattern();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.styling.model.Styling.ModelPattern#getAttributeName <em>Attribute Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Name</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.ModelPattern#getAttributeName()
	 * @see #getModelPattern()
	 * @generated
	 */
	EAttribute getModelPattern_AttributeName();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.styling.model.Styling.OperationPattern <em>Operation Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Pattern</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.OperationPattern
	 * @generated
	 */
	EClass getOperationPattern();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.styling.model.Styling.OperationPattern#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.OperationPattern#getOperation()
	 * @see #getOperationPattern()
	 * @generated
	 */
	EAttribute getOperationPattern_Operation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.styling.model.Styling.OperationPattern#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.OperationPattern#getParameters()
	 * @see #getOperationPattern()
	 * @generated
	 */
	EReference getOperationPattern_Parameters();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.styling.model.Styling.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.styling.model.Styling.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for the '{@link org.polarsys.reqcycle.styling.model.Styling.Parameter#getObjectValue() <em>Get Object Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Object Value</em>' operation.
	 * @see org.polarsys.reqcycle.styling.model.Styling.Parameter#getObjectValue()
	 * @generated
	 */
	EOperation getParameter__GetObjectValue();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.styling.model.Styling.IntParameter <em>Int Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Parameter</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.IntParameter
	 * @generated
	 */
	EClass getIntParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.styling.model.Styling.IntParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.IntParameter#getValue()
	 * @see #getIntParameter()
	 * @generated
	 */
	EAttribute getIntParameter_Value();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.styling.model.Styling.BooleanParameter <em>Boolean Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Parameter</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.BooleanParameter
	 * @generated
	 */
	EClass getBooleanParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.styling.model.Styling.BooleanParameter#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.BooleanParameter#isValue()
	 * @see #getBooleanParameter()
	 * @generated
	 */
	EAttribute getBooleanParameter_Value();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.styling.model.Styling.StringParameter <em>String Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Parameter</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.StringParameter
	 * @generated
	 */
	EClass getStringParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.styling.model.Styling.StringParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.StringParameter#getValue()
	 * @see #getStringParameter()
	 * @generated
	 */
	EAttribute getStringParameter_Value();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.styling.model.Styling.EObjectParameter <em>EObject Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject Parameter</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.EObjectParameter
	 * @generated
	 */
	EClass getEObjectParameter();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.reqcycle.styling.model.Styling.EObjectParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.EObjectParameter#getValue()
	 * @see #getEObjectParameter()
	 * @generated
	 */
	EReference getEObjectParameter_Value();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.reqcycle.styling.model.Styling.FontOption <em>Font Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Font Option</em>'.
	 * @see org.polarsys.reqcycle.styling.model.Styling.FontOption
	 * @generated
	 */
	EEnum getFontOption();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.graphics.Color <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Color</em>'.
	 * @see org.eclipse.swt.graphics.Color
	 * @model instanceClass="org.eclipse.swt.graphics.Color" serializeable="false"
	 * @generated
	 */
	EDataType getColor();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.graphics.Font <em>Font</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Font</em>'.
	 * @see org.eclipse.swt.graphics.Font
	 * @model instanceClass="org.eclipse.swt.graphics.Font" serializeable="false"
	 * @generated
	 */
	EDataType getFont();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.jface.viewers.StyledString <em>Styled String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Styled String</em>'.
	 * @see org.eclipse.jface.viewers.StyledString
	 * @model instanceClass="org.eclipse.jface.viewers.StyledString" serializeable="false"
	 * @generated
	 */
	EDataType getStyledString();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.graphics.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Image</em>'.
	 * @see org.eclipse.swt.graphics.Image
	 * @model instanceClass="org.eclipse.swt.graphics.Image" serializeable="false"
	 * @generated
	 */
	EDataType getImage();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StylingFactory getStylingFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.StylingModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingModelImpl
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getStylingModel()
		 * @generated
		 */
		EClass STYLING_MODEL = eINSTANCE.getStylingModel();

		/**
		 * The meta object literal for the '<em><b>Styles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STYLING_MODEL__STYLES = eINSTANCE.getStylingModel_Styles();

		/**
		 * The meta object literal for the '<em><b>Mode Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLING_MODEL__MODE_NAME = eINSTANCE.getStylingModel_ModeName();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STYLING_MODEL__DEFAULT = eINSTANCE.getStylingModel_Default();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.StylingPredicateImpl <em>Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPredicateImpl
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getStylingPredicate()
		 * @generated
		 */
		EClass STYLING_PREDICATE = eINSTANCE.getStylingPredicate();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STYLING_PREDICATE__PREDICATE = eINSTANCE.getStylingPredicate_Predicate();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.SegmentImpl <em>Segment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.SegmentImpl
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getSegment()
		 * @generated
		 */
		EClass SEGMENT = eINSTANCE.getSegment();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEGMENT__STYLE = eINSTANCE.getSegment_Style();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEGMENT__PATTERN = eINSTANCE.getSegment_Pattern();

		/**
		 * The meta object literal for the '<em><b>Get Color</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SEGMENT___GET_COLOR = eINSTANCE.getSegment__GetColor();

		/**
		 * The meta object literal for the '<em><b>Get Font</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SEGMENT___GET_FONT = eINSTANCE.getSegment__GetFont();

		/**
		 * The meta object literal for the '<em><b>Set Color</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SEGMENT___SET_COLOR__COLOR = eINSTANCE.getSegment__SetColor__Color();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.IconImpl <em>Icon</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.IconImpl
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getIcon()
		 * @generated
		 */
		EClass ICON = eINSTANCE.getIcon();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ICON__IMAGE = eINSTANCE.getIcon_Image();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.StyleImpl <em>Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StyleImpl
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getStyle()
		 * @generated
		 */
		EClass STYLE = eINSTANCE.getStyle();

		/**
		 * The meta object literal for the '<em><b>Applied Fonts</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__APPLIED_FONTS = eINSTANCE.getStyle_AppliedFonts();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__COLOR = eINSTANCE.getStyle_Color();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.CaseStyleImpl <em>Case Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.CaseStyleImpl
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getCaseStyle()
		 * @generated
		 */
		EClass CASE_STYLE = eINSTANCE.getCaseStyle();

		/**
		 * The meta object literal for the '<em><b>Segments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_STYLE__SEGMENTS = eINSTANCE.getCaseStyle_Segments();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_STYLE__ICON = eINSTANCE.getCaseStyle_Icon();

		/**
		 * The meta object literal for the '<em><b>Get Styled String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CASE_STYLE___GET_STYLED_STRING__OBJECT = eINSTANCE.getCaseStyle__GetStyledString__Object();

		/**
		 * The meta object literal for the '<em><b>Get Image</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CASE_STYLE___GET_IMAGE = eINSTANCE.getCaseStyle__GetImage();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.DefaultImpl <em>Default</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.DefaultImpl
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getDefault()
		 * @generated
		 */
		EClass DEFAULT = eINSTANCE.getDefault();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.StylingImpl <em>Styling</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingImpl
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getStyling()
		 * @generated
		 */
		EClass STYLING = eINSTANCE.getStyling();

		/**
		 * The meta object literal for the '<em><b>Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STYLING__MODELS = eINSTANCE.getStyling_Models();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.PatternImpl <em>Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.PatternImpl
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getPattern()
		 * @generated
		 */
		EClass PATTERN = eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '<em><b>Get Pattern</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PATTERN___GET_PATTERN = eINSTANCE.getPattern__GetPattern();

		/**
		 * The meta object literal for the '<em><b>Get Pattern Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PATTERN___GET_PATTERN_VALUE__OBJECT = eINSTANCE.getPattern__GetPatternValue__Object();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.ConstantPatternImpl <em>Constant Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.ConstantPatternImpl
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getConstantPattern()
		 * @generated
		 */
		EClass CONSTANT_PATTERN = eINSTANCE.getConstantPattern();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTANT_PATTERN__VALUE = eINSTANCE.getConstantPattern_Value();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.ModelPatternImpl <em>Model Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.ModelPatternImpl
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getModelPattern()
		 * @generated
		 */
		EClass MODEL_PATTERN = eINSTANCE.getModelPattern();

		/**
		 * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_PATTERN__ATTRIBUTE_NAME = eINSTANCE.getModelPattern_AttributeName();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.OperationPatternImpl <em>Operation Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.OperationPatternImpl
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getOperationPattern()
		 * @generated
		 */
		EClass OPERATION_PATTERN = eINSTANCE.getOperationPattern();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_PATTERN__OPERATION = eINSTANCE.getOperationPattern_Operation();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_PATTERN__PARAMETERS = eINSTANCE.getOperationPattern_Parameters();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.ParameterImpl
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Get Object Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETER___GET_OBJECT_VALUE = eINSTANCE.getParameter__GetObjectValue();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.IntParameterImpl <em>Int Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.IntParameterImpl
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getIntParameter()
		 * @generated
		 */
		EClass INT_PARAMETER = eINSTANCE.getIntParameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_PARAMETER__VALUE = eINSTANCE.getIntParameter_Value();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.BooleanParameterImpl <em>Boolean Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.BooleanParameterImpl
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getBooleanParameter()
		 * @generated
		 */
		EClass BOOLEAN_PARAMETER = eINSTANCE.getBooleanParameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_PARAMETER__VALUE = eINSTANCE.getBooleanParameter_Value();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.StringParameterImpl <em>String Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StringParameterImpl
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getStringParameter()
		 * @generated
		 */
		EClass STRING_PARAMETER = eINSTANCE.getStringParameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_PARAMETER__VALUE = eINSTANCE.getStringParameter_Value();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.styling.model.Styling.impl.EObjectParameterImpl <em>EObject Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.EObjectParameterImpl
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getEObjectParameter()
		 * @generated
		 */
		EClass EOBJECT_PARAMETER = eINSTANCE.getEObjectParameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOBJECT_PARAMETER__VALUE = eINSTANCE.getEObjectParameter_Value();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.styling.model.Styling.FontOption <em>Font Option</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.styling.model.Styling.FontOption
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getFontOption()
		 * @generated
		 */
		EEnum FONT_OPTION = eINSTANCE.getFontOption();

		/**
		 * The meta object literal for the '<em>Color</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.swt.graphics.Color
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getColor()
		 * @generated
		 */
		EDataType COLOR = eINSTANCE.getColor();

		/**
		 * The meta object literal for the '<em>Font</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.swt.graphics.Font
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getFont()
		 * @generated
		 */
		EDataType FONT = eINSTANCE.getFont();

		/**
		 * The meta object literal for the '<em>Styled String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jface.viewers.StyledString
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getStyledString()
		 * @generated
		 */
		EDataType STYLED_STRING = eINSTANCE.getStyledString();

		/**
		 * The meta object literal for the '<em>Image</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.swt.graphics.Image
		 * @see org.polarsys.reqcycle.styling.model.Styling.impl.StylingPackageImpl#getImage()
		 * @generated
		 */
		EDataType IMAGE = eINSTANCE.getImage();

	}

} //StylingPackage
