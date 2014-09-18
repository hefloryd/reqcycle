/**
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *   Malick Wade (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.inittypes.inittypes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.polarsys.reqcycle.inittypes.inittypes.InittypesFactory
 * @model kind="package"
 * @generated
 */
public interface InittypesPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2014 AtoS\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n  Malick Wade (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "inittypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.polarsys.org/inittypes/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "inittypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InittypesPackage eINSTANCE = org.polarsys.reqcycle.inittypes.inittypes.impl.InittypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.inittypes.inittypes.impl.TypeModelImpl <em>Type Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.TypeModelImpl
	 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.InittypesPackageImpl#getTypeModel()
	 * @generated
	 */
	int TYPE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>File Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_MODEL__FILE_TYPES = 0;

	/**
	 * The number of structural features of the '<em>Type Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_MODEL_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Get Document Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_MODEL___GET_DOCUMENT_TYPE__STRING = 0;

	/**
	 * The operation id for the '<em>Get Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_MODEL___GET_TYPES__STRING = 1;

	/**
	 * The number of operations of the '<em>Type Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_MODEL_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.inittypes.inittypes.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.TypeImpl
	 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.InittypesPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 1;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__REQUIREMENTS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.inittypes.inittypes.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.RequirementImpl
	 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.InittypesPackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 2;

	/**
	 * The feature id for the '<em><b>Name Req</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__NAME_REQ = 0;

	/**
	 * The feature id for the '<em><b>Regex Req</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REGEX_REQ = 1;

	/**
	 * The feature id for the '<em><b>Attributes Req</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ATTRIBUTES_REQ = 2;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.inittypes.inittypes.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.AttributeImpl
	 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.InittypesPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 3;

	/**
	 * The feature id for the '<em><b>Name Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME_ATTRIBUTE = 0;

	/**
	 * The feature id for the '<em><b>Regex Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__REGEX_ATTRIBUTE = 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.inittypes.inittypes.impl.RegexImpl <em>Regex</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.RegexImpl
	 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.InittypesPackageImpl#getRegex()
	 * @generated
	 */
	int REGEX = 4;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Regex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Matches</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX___MATCHES__STRING = 0;

	/**
	 * The number of operations of the '<em>Regex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.inittypes.inittypes.impl.FileTypeImpl <em>File Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.FileTypeImpl
	 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.InittypesPackageImpl#getFileType()
	 * @generated
	 */
	int FILE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE__TYPES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE__NAME = 1;

	/**
	 * The number of structural features of the '<em>File Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>File Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.inittypes.inittypes.TypeModel <em>Type Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Model</em>'.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.TypeModel
	 * @generated
	 */
	EClass getTypeModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.inittypes.inittypes.TypeModel#getFileTypes <em>File Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>File Types</em>'.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.TypeModel#getFileTypes()
	 * @see #getTypeModel()
	 * @generated
	 */
	EReference getTypeModel_FileTypes();

	/**
	 * Returns the meta object for the '{@link org.polarsys.reqcycle.inittypes.inittypes.TypeModel#getDocumentType(java.lang.String) <em>Get Document Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Document Type</em>' operation.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.TypeModel#getDocumentType(java.lang.String)
	 * @generated
	 */
	EOperation getTypeModel__GetDocumentType__String();

	/**
	 * Returns the meta object for the '{@link org.polarsys.reqcycle.inittypes.inittypes.TypeModel#getTypes(java.lang.String) <em>Get Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Types</em>' operation.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.TypeModel#getTypes(java.lang.String)
	 * @generated
	 */
	EOperation getTypeModel__GetTypes__String();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.inittypes.inittypes.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.inittypes.inittypes.Type#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requirements</em>'.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.Type#getRequirements()
	 * @see #getType()
	 * @generated
	 */
	EReference getType_Requirements();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.inittypes.inittypes.Type#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.Type#getName()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Name();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.inittypes.inittypes.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.inittypes.inittypes.Requirement#getNameReq <em>Name Req</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name Req</em>'.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.Requirement#getNameReq()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_NameReq();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.reqcycle.inittypes.inittypes.Requirement#getRegexReq <em>Regex Req</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Regex Req</em>'.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.Requirement#getRegexReq()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_RegexReq();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.inittypes.inittypes.Requirement#getAttributesReq <em>Attributes Req</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes Req</em>'.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.Requirement#getAttributesReq()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_AttributesReq();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.inittypes.inittypes.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.inittypes.inittypes.Attribute#getNameAttribute <em>Name Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name Attribute</em>'.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.Attribute#getNameAttribute()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_NameAttribute();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.reqcycle.inittypes.inittypes.Attribute#getRegexAttribute <em>Regex Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Regex Attribute</em>'.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.Attribute#getRegexAttribute()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_RegexAttribute();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.inittypes.inittypes.Regex <em>Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Regex</em>'.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.Regex
	 * @generated
	 */
	EClass getRegex();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.inittypes.inittypes.Regex#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.Regex#getExpression()
	 * @see #getRegex()
	 * @generated
	 */
	EAttribute getRegex_Expression();

	/**
	 * Returns the meta object for the '{@link org.polarsys.reqcycle.inittypes.inittypes.Regex#matches(java.lang.String) <em>Matches</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Matches</em>' operation.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.Regex#matches(java.lang.String)
	 * @generated
	 */
	EOperation getRegex__Matches__String();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.inittypes.inittypes.FileType <em>File Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Type</em>'.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.FileType
	 * @generated
	 */
	EClass getFileType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.inittypes.inittypes.FileType#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.FileType#getTypes()
	 * @see #getFileType()
	 * @generated
	 */
	EReference getFileType_Types();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.inittypes.inittypes.FileType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.FileType#getName()
	 * @see #getFileType()
	 * @generated
	 */
	EAttribute getFileType_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InittypesFactory getInittypesFactory();

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
		 * The meta object literal for the '{@link org.polarsys.reqcycle.inittypes.inittypes.impl.TypeModelImpl <em>Type Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.TypeModelImpl
		 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.InittypesPackageImpl#getTypeModel()
		 * @generated
		 */
		EClass TYPE_MODEL = eINSTANCE.getTypeModel();

		/**
		 * The meta object literal for the '<em><b>File Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_MODEL__FILE_TYPES = eINSTANCE.getTypeModel_FileTypes();

		/**
		 * The meta object literal for the '<em><b>Get Document Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_MODEL___GET_DOCUMENT_TYPE__STRING = eINSTANCE.getTypeModel__GetDocumentType__String();

		/**
		 * The meta object literal for the '<em><b>Get Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE_MODEL___GET_TYPES__STRING = eINSTANCE.getTypeModel__GetTypes__String();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.inittypes.inittypes.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.TypeImpl
		 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.InittypesPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE__REQUIREMENTS = eINSTANCE.getType_Requirements();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__NAME = eINSTANCE.getType_Name();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.inittypes.inittypes.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.RequirementImpl
		 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.InittypesPackageImpl#getRequirement()
		 * @generated
		 */
		EClass REQUIREMENT = eINSTANCE.getRequirement();

		/**
		 * The meta object literal for the '<em><b>Name Req</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__NAME_REQ = eINSTANCE.getRequirement_NameReq();

		/**
		 * The meta object literal for the '<em><b>Regex Req</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__REGEX_REQ = eINSTANCE.getRequirement_RegexReq();

		/**
		 * The meta object literal for the '<em><b>Attributes Req</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__ATTRIBUTES_REQ = eINSTANCE.getRequirement_AttributesReq();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.inittypes.inittypes.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.AttributeImpl
		 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.InittypesPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Name Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__NAME_ATTRIBUTE = eINSTANCE.getAttribute_NameAttribute();

		/**
		 * The meta object literal for the '<em><b>Regex Attribute</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__REGEX_ATTRIBUTE = eINSTANCE.getAttribute_RegexAttribute();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.inittypes.inittypes.impl.RegexImpl <em>Regex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.RegexImpl
		 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.InittypesPackageImpl#getRegex()
		 * @generated
		 */
		EClass REGEX = eINSTANCE.getRegex();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGEX__EXPRESSION = eINSTANCE.getRegex_Expression();

		/**
		 * The meta object literal for the '<em><b>Matches</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REGEX___MATCHES__STRING = eINSTANCE.getRegex__Matches__String();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.inittypes.inittypes.impl.FileTypeImpl <em>File Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.FileTypeImpl
		 * @see org.polarsys.reqcycle.inittypes.inittypes.impl.InittypesPackageImpl#getFileType()
		 * @generated
		 */
		EClass FILE_TYPE = eINSTANCE.getFileType();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE_TYPE__TYPES = eINSTANCE.getFileType_Types();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_TYPE__NAME = eINSTANCE.getFileType_Name();

	}

} //InittypesPackage
