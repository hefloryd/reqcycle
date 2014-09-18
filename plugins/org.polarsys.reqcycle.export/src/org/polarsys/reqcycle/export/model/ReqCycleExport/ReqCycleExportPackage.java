/**
 * Copyright (c) 2013, 2014 AtoS and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *  Abdellah El Ayadi(AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.export.model.ReqCycleExport;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.ReqCycleExportFactory
 * @model kind="package"
 * @generated
 */
public interface ReqCycleExportPackage extends EPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2013, 2014 AtoS and others\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n Abdellah El Ayadi(AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ReqCycleExport";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.polarsys.org/reqcycle/reqexport/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "reqexp";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	ReqCycleExportPackage eINSTANCE = org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ReqCycleExportPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ModelImpl
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ReqCycleExportPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 0;

	/**
	 * The feature id for the '<em><b>Metadata</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__METADATA = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NAME = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__VERSION = 2;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ATTRIBUTES = 3;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__REQUIREMENTS = 4;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.PropertyImpl
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ReqCycleExportPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.AttributeImpl
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ReqCycleExportPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.RequirementImpl
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ReqCycleExportPackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 3;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__VALUES = 0;

	/**
	 * The feature id for the '<em><b>Downward Traceability</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DOWNWARD_TRACEABILITY = 1;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ID = 2;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.AttributeValueImpl <em>Attribute Value</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.AttributeValueImpl
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ReqCycleExportPackageImpl#getAttributeValue()
	 * @generated
	 */
	int ATTRIBUTE_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE__ATTRIBUTE = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Attribute Value</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Attribute Value</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.TraceabilityImpl <em>Traceability</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.TraceabilityImpl
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ReqCycleExportPackageImpl#getTraceability()
	 * @generated
	 */
	int TRACEABILITY = 5;

	/**
	 * The feature id for the '<em><b>Element Traced Label</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY__ELEMENT_TRACED_LABEL = 0;

	/**
	 * The feature id for the '<em><b>Traceability Values</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY__TRACEABILITY_VALUES = 1;

	/**
	 * The number of structural features of the '<em>Traceability</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Traceability</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ExportImpl <em>Export</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ExportImpl
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ReqCycleExportPackageImpl#getExport()
	 * @generated
	 */
	int EXPORT = 6;

	/**
	 * The feature id for the '<em><b>Models</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT__MODELS = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT__DATE = 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT__PATH = 2;

	/**
	 * The number of structural features of the '<em>Export</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Export</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORT_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Model <em>Model</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Model#getMetadata <em>Metadata</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metadata</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Model#getMetadata()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Metadata();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Model#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Model#getName()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Model#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Model#getVersion()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Version();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Model#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Model#getAttributes()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Model#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requirements</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Model#getRequirements()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Requirements();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Property <em>Property</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Property#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Property#getValue()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Value();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Attribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Attribute#getName()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Attribute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Attribute#getType()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Type();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement#getValues()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_Values();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement#getDownwardTraceability <em>Downward Traceability</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the containment reference list '<em>Downward Traceability</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement#getDownwardTraceability()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_DownwardTraceability();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement#getID <em>ID</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement#getID()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_ID();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.AttributeValue <em>Attribute Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Value</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.AttributeValue
	 * @generated
	 */
	EClass getAttributeValue();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.AttributeValue#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.AttributeValue#getAttribute()
	 * @see #getAttributeValue()
	 * @generated
	 */
	EReference getAttributeValue_Attribute();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.AttributeValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.AttributeValue#getValue()
	 * @see #getAttributeValue()
	 * @generated
	 */
	EAttribute getAttributeValue_Value();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Traceability <em>Traceability</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traceability</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Traceability
	 * @generated
	 */
	EClass getTraceability();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Traceability#getElementTracedLabel <em>Element Traced Label</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Traced Label</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Traceability#getElementTracedLabel()
	 * @see #getTraceability()
	 * @generated
	 */
	EAttribute getTraceability_ElementTracedLabel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Traceability#getTraceabilityValues <em>Traceability Values</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Traceability Values</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Traceability#getTraceabilityValues()
	 * @see #getTraceability()
	 * @generated
	 */
	EReference getTraceability_TraceabilityValues();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Export <em>Export</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Export</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Export
	 * @generated
	 */
	EClass getExport();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Export#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Models</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Export#getModels()
	 * @see #getExport()
	 * @generated
	 */
	EReference getExport_Models();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Export#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Export#getDate()
	 * @see #getExport()
	 * @generated
	 */
	EAttribute getExport_Date();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Export#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.Export#getPath()
	 * @see #getExport()
	 * @generated
	 */
	EAttribute getExport_Path();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ReqCycleExportFactory getReqCycleExportFactory();

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
		 * The meta object literal for the '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ModelImpl
		 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ReqCycleExportPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Metadata</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__METADATA = eINSTANCE.getModel_Metadata();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__VERSION = eINSTANCE.getModel_Version();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__ATTRIBUTES = eINSTANCE.getModel_Attributes();

		/**
		 * The meta object literal for the '<em><b>Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__REQUIREMENTS = eINSTANCE.getModel_Requirements();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.PropertyImpl
		 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ReqCycleExportPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__VALUE = eINSTANCE.getProperty_Value();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.AttributeImpl
		 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ReqCycleExportPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.RequirementImpl
		 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ReqCycleExportPackageImpl#getRequirement()
		 * @generated
		 */
		EClass REQUIREMENT = eINSTANCE.getRequirement();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__VALUES = eINSTANCE.getRequirement_Values();

		/**
		 * The meta object literal for the '<em><b>Downward Traceability</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__DOWNWARD_TRACEABILITY = eINSTANCE.getRequirement_DownwardTraceability();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__ID = eINSTANCE.getRequirement_ID();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.AttributeValueImpl <em>Attribute Value</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.AttributeValueImpl
		 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ReqCycleExportPackageImpl#getAttributeValue()
		 * @generated
		 */
		EClass ATTRIBUTE_VALUE = eINSTANCE.getAttributeValue();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_VALUE__ATTRIBUTE = eINSTANCE.getAttributeValue_Attribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_VALUE__VALUE = eINSTANCE.getAttributeValue_Value();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.TraceabilityImpl <em>Traceability</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.TraceabilityImpl
		 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ReqCycleExportPackageImpl#getTraceability()
		 * @generated
		 */
		EClass TRACEABILITY = eINSTANCE.getTraceability();

		/**
		 * The meta object literal for the '<em><b>Element Traced Label</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACEABILITY__ELEMENT_TRACED_LABEL = eINSTANCE.getTraceability_ElementTracedLabel();

		/**
		 * The meta object literal for the '<em><b>Traceability Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACEABILITY__TRACEABILITY_VALUES = eINSTANCE.getTraceability_TraceabilityValues();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ExportImpl <em>Export</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ExportImpl
		 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.impl.ReqCycleExportPackageImpl#getExport()
		 * @generated
		 */
		EClass EXPORT = eINSTANCE.getExport();

		/**
		 * The meta object literal for the '<em><b>Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPORT__MODELS = eINSTANCE.getExport_Models();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPORT__DATE = eINSTANCE.getExport_Date();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPORT__PATH = eINSTANCE.getExport_Path();

	}

} // ReqCycleExportPackage
