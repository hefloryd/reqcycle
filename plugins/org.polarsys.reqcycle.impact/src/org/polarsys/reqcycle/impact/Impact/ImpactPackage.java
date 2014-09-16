/**
 * Copyright (c) 2014 AtoS
 *     All rights reserved. This program and the accompanying materials
 *     are made available under the terms of the Eclipse Public License v1.0
 *     which accompanies this distribution, and is available at
 *     http://www.eclipse.org/legal/epl-v10.html *
 *     Contributors:
 *       Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.impact.Impact;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * 
 * @see org.polarsys.reqcycle.impact.Impact.ImpactFactory
 * @model kind="package"
 * @generated
 */
public interface ImpactPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "Impact";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.polarsys.org/ReqCycle/impact/1.0";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "impact";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ImpactPackage eINSTANCE = org.polarsys.reqcycle.impact.Impact.impl.ImpactPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.impact.Impact.impl.ImpactAnalysisImpl <em>Analysis</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.polarsys.reqcycle.impact.Impact.impl.ImpactAnalysisImpl
	 * @see org.polarsys.reqcycle.impact.Impact.impl.ImpactPackageImpl#getImpactAnalysis()
	 * @generated
	 */
	int IMPACT_ANALYSIS = 0;

	/**
	 * The feature id for the '<em><b>Requirements Added</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS__REQUIREMENTS_ADDED = 0;

	/**
	 * The feature id for the '<em><b>Requirements Deleted</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS__REQUIREMENTS_DELETED = 1;

	/**
	 * The feature id for the '<em><b>Requirements Modified</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS__REQUIREMENTS_MODIFIED = 2;

	/**
	 * The number of structural features of the '<em>Analysis</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Launch Analysis</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS___LAUNCH_ANALYSIS__REQUIREMENTSOURCE_REQUIREMENTSOURCE = 0;

	/**
	 * The operation id for the '<em>Save Analysis</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS___SAVE_ANALYSIS__URI = 1;

	/**
	 * The number of operations of the '<em>Analysis</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.impact.Impact.impl.RequirementImpactedImpl <em>Requirement Impacted</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.polarsys.reqcycle.impact.Impact.impl.RequirementImpactedImpl
	 * @see org.polarsys.reqcycle.impact.Impact.impl.ImpactPackageImpl#getRequirementImpacted()
	 * @generated
	 */
	int REQUIREMENT_IMPACTED = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_IMPACTED__ID = 0;

	/**
	 * The feature id for the '<em><b>Link List</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_IMPACTED__LINK_LIST = 1;

	/**
	 * The feature id for the '<em><b>Attributes Impacted</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_IMPACTED__ATTRIBUTES_IMPACTED = 2;

	/**
	 * The number of structural features of the '<em>Requirement Impacted</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_IMPACTED_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Get Impacted Attribute</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_IMPACTED___GET_IMPACTED_ATTRIBUTE__STRING = 0;

	/**
	 * The number of operations of the '<em>Requirement Impacted</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_IMPACTED_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.impact.Impact.impl.TraceabilityLinkImpl <em>Traceability Link</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.polarsys.reqcycle.impact.Impact.impl.TraceabilityLinkImpl
	 * @see org.polarsys.reqcycle.impact.Impact.impl.ImpactPackageImpl#getTraceabilityLink()
	 * @generated
	 */
	int TRACEABILITY_LINK = 2;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY_LINK__LINK_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Link Direction</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY_LINK__LINK_DIRECTION = 1;

	/**
	 * The feature id for the '<em><b>Linked Element</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY_LINK__LINKED_ELEMENT = 2;

	/**
	 * The number of structural features of the '<em>Traceability Link</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY_LINK_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Traceability Link</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY_LINK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.impact.Impact.impl.AttributeImpactedImpl <em>Attribute Impacted</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.polarsys.reqcycle.impact.Impact.impl.AttributeImpactedImpl
	 * @see org.polarsys.reqcycle.impact.Impact.impl.ImpactPackageImpl#getAttributeImpacted()
	 * @generated
	 */
	int ATTRIBUTE_IMPACTED = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_IMPACTED__ID = 0;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_IMPACTED__OLD_VALUE = 1;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_IMPACTED__NEW_VALUE = 2;

	/**
	 * The number of structural features of the '<em>Attribute Impacted</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_IMPACTED_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Attribute Impacted</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_IMPACTED_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>URI</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.common.util.URI
	 * @see org.polarsys.reqcycle.impact.Impact.impl.ImpactPackageImpl#getURI()
	 * @generated
	 */
	int URI = 4;

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.impact.Impact.ImpactAnalysis <em>Analysis</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Analysis</em>'.
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactAnalysis
	 * @generated
	 */
	EClass getImpactAnalysis();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.impact.Impact.ImpactAnalysis#getRequirementsAdded <em>Requirements Added</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Requirements Added</em>'.
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactAnalysis#getRequirementsAdded()
	 * @see #getImpactAnalysis()
	 * @generated
	 */
	EReference getImpactAnalysis_RequirementsAdded();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.impact.Impact.ImpactAnalysis#getRequirementsDeleted <em>Requirements Deleted</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Requirements Deleted</em>'.
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactAnalysis#getRequirementsDeleted()
	 * @see #getImpactAnalysis()
	 * @generated
	 */
	EReference getImpactAnalysis_RequirementsDeleted();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.impact.Impact.ImpactAnalysis#getRequirementsModified <em>Requirements Modified</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Requirements Modified</em>'.
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactAnalysis#getRequirementsModified()
	 * @see #getImpactAnalysis()
	 * @generated
	 */
	EReference getImpactAnalysis_RequirementsModified();

	/**
	 * Returns the meta object for the '
	 * {@link org.polarsys.reqcycle.impact.Impact.ImpactAnalysis#launchAnalysis(org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource, org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource)
	 * <em>Launch Analysis</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the '<em>Launch Analysis</em>' operation.
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactAnalysis#launchAnalysis(org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource, org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource)
	 * @generated
	 */
	EOperation getImpactAnalysis__LaunchAnalysis__RequirementSource_RequirementSource();

	/**
	 * Returns the meta object for the '{@link org.polarsys.reqcycle.impact.Impact.ImpactAnalysis#saveAnalysis(org.eclipse.emf.common.util.URI) <em>Save Analysis</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the '<em>Save Analysis</em>' operation.
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactAnalysis#saveAnalysis(org.eclipse.emf.common.util.URI)
	 * @generated
	 */
	EOperation getImpactAnalysis__SaveAnalysis__URI();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.impact.Impact.RequirementImpacted <em>Requirement Impacted</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Requirement Impacted</em>'.
	 * @see org.polarsys.reqcycle.impact.Impact.RequirementImpacted
	 * @generated
	 */
	EClass getRequirementImpacted();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.impact.Impact.RequirementImpacted#getId <em>Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.polarsys.reqcycle.impact.Impact.RequirementImpacted#getId()
	 * @see #getRequirementImpacted()
	 * @generated
	 */
	EAttribute getRequirementImpacted_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.impact.Impact.RequirementImpacted#getLinkList <em>Link List</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Link List</em>'.
	 * @see org.polarsys.reqcycle.impact.Impact.RequirementImpacted#getLinkList()
	 * @see #getRequirementImpacted()
	 * @generated
	 */
	EReference getRequirementImpacted_LinkList();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.impact.Impact.RequirementImpacted#getAttributesImpacted <em>Attributes Impacted</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Attributes Impacted</em>'.
	 * @see org.polarsys.reqcycle.impact.Impact.RequirementImpacted#getAttributesImpacted()
	 * @see #getRequirementImpacted()
	 * @generated
	 */
	EReference getRequirementImpacted_AttributesImpacted();

	/**
	 * Returns the meta object for the '{@link org.polarsys.reqcycle.impact.Impact.RequirementImpacted#getImpactedAttribute(java.lang.String) <em>Get Impacted Attribute</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the '<em>Get Impacted Attribute</em>' operation.
	 * @see org.polarsys.reqcycle.impact.Impact.RequirementImpacted#getImpactedAttribute(java.lang.String)
	 * @generated
	 */
	EOperation getRequirementImpacted__GetImpactedAttribute__String();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.impact.Impact.TraceabilityLink <em>Traceability Link</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Traceability Link</em>'.
	 * @see org.polarsys.reqcycle.impact.Impact.TraceabilityLink
	 * @generated
	 */
	EClass getTraceabilityLink();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.impact.Impact.TraceabilityLink#getLinkType <em>Link Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Link Type</em>'.
	 * @see org.polarsys.reqcycle.impact.Impact.TraceabilityLink#getLinkType()
	 * @see #getTraceabilityLink()
	 * @generated
	 */
	EAttribute getTraceabilityLink_LinkType();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.impact.Impact.TraceabilityLink#getLinkDirection <em>Link Direction</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Link Direction</em>'.
	 * @see org.polarsys.reqcycle.impact.Impact.TraceabilityLink#getLinkDirection()
	 * @see #getTraceabilityLink()
	 * @generated
	 */
	EAttribute getTraceabilityLink_LinkDirection();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.impact.Impact.TraceabilityLink#getLinkedElement <em>Linked Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Linked Element</em>'.
	 * @see org.polarsys.reqcycle.impact.Impact.TraceabilityLink#getLinkedElement()
	 * @see #getTraceabilityLink()
	 * @generated
	 */
	EAttribute getTraceabilityLink_LinkedElement();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.impact.Impact.AttributeImpacted <em>Attribute Impacted</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Attribute Impacted</em>'.
	 * @see org.polarsys.reqcycle.impact.Impact.AttributeImpacted
	 * @generated
	 */
	EClass getAttributeImpacted();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.impact.Impact.AttributeImpacted#getId <em>Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.polarsys.reqcycle.impact.Impact.AttributeImpacted#getId()
	 * @see #getAttributeImpacted()
	 * @generated
	 */
	EAttribute getAttributeImpacted_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.impact.Impact.AttributeImpacted#getOldValue <em>Old Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Old Value</em>'.
	 * @see org.polarsys.reqcycle.impact.Impact.AttributeImpacted#getOldValue()
	 * @see #getAttributeImpacted()
	 * @generated
	 */
	EAttribute getAttributeImpacted_OldValue();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.impact.Impact.AttributeImpacted#getNewValue <em>New Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>New Value</em>'.
	 * @see org.polarsys.reqcycle.impact.Impact.AttributeImpacted#getNewValue()
	 * @see #getAttributeImpacted()
	 * @generated
	 */
	EAttribute getAttributeImpacted_NewValue();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ImpactFactory getImpactFactory();

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
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.impact.Impact.impl.ImpactAnalysisImpl <em>Analysis</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.polarsys.reqcycle.impact.Impact.impl.ImpactAnalysisImpl
		 * @see org.polarsys.reqcycle.impact.Impact.impl.ImpactPackageImpl#getImpactAnalysis()
		 * @generated
		 */
		EClass IMPACT_ANALYSIS = eINSTANCE.getImpactAnalysis();

		/**
		 * The meta object literal for the '<em><b>Requirements Added</b></em>' containment reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IMPACT_ANALYSIS__REQUIREMENTS_ADDED = eINSTANCE.getImpactAnalysis_RequirementsAdded();

		/**
		 * The meta object literal for the '<em><b>Requirements Deleted</b></em>' containment reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IMPACT_ANALYSIS__REQUIREMENTS_DELETED = eINSTANCE.getImpactAnalysis_RequirementsDeleted();

		/**
		 * The meta object literal for the '<em><b>Requirements Modified</b></em>' containment reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IMPACT_ANALYSIS__REQUIREMENTS_MODIFIED = eINSTANCE.getImpactAnalysis_RequirementsModified();

		/**
		 * The meta object literal for the '<em><b>Launch Analysis</b></em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation IMPACT_ANALYSIS___LAUNCH_ANALYSIS__REQUIREMENTSOURCE_REQUIREMENTSOURCE = eINSTANCE.getImpactAnalysis__LaunchAnalysis__RequirementSource_RequirementSource();

		/**
		 * The meta object literal for the '<em><b>Save Analysis</b></em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation IMPACT_ANALYSIS___SAVE_ANALYSIS__URI = eINSTANCE.getImpactAnalysis__SaveAnalysis__URI();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.impact.Impact.impl.RequirementImpactedImpl <em>Requirement Impacted</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.polarsys.reqcycle.impact.Impact.impl.RequirementImpactedImpl
		 * @see org.polarsys.reqcycle.impact.Impact.impl.ImpactPackageImpl#getRequirementImpacted()
		 * @generated
		 */
		EClass REQUIREMENT_IMPACTED = eINSTANCE.getRequirementImpacted();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REQUIREMENT_IMPACTED__ID = eINSTANCE.getRequirementImpacted_Id();

		/**
		 * The meta object literal for the '<em><b>Link List</b></em>' containment reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REQUIREMENT_IMPACTED__LINK_LIST = eINSTANCE.getRequirementImpacted_LinkList();

		/**
		 * The meta object literal for the '<em><b>Attributes Impacted</b></em>' containment reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REQUIREMENT_IMPACTED__ATTRIBUTES_IMPACTED = eINSTANCE.getRequirementImpacted_AttributesImpacted();

		/**
		 * The meta object literal for the '<em><b>Get Impacted Attribute</b></em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation REQUIREMENT_IMPACTED___GET_IMPACTED_ATTRIBUTE__STRING = eINSTANCE.getRequirementImpacted__GetImpactedAttribute__String();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.impact.Impact.impl.TraceabilityLinkImpl <em>Traceability Link</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.polarsys.reqcycle.impact.Impact.impl.TraceabilityLinkImpl
		 * @see org.polarsys.reqcycle.impact.Impact.impl.ImpactPackageImpl#getTraceabilityLink()
		 * @generated
		 */
		EClass TRACEABILITY_LINK = eINSTANCE.getTraceabilityLink();

		/**
		 * The meta object literal for the '<em><b>Link Type</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TRACEABILITY_LINK__LINK_TYPE = eINSTANCE.getTraceabilityLink_LinkType();

		/**
		 * The meta object literal for the '<em><b>Link Direction</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TRACEABILITY_LINK__LINK_DIRECTION = eINSTANCE.getTraceabilityLink_LinkDirection();

		/**
		 * The meta object literal for the '<em><b>Linked Element</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TRACEABILITY_LINK__LINKED_ELEMENT = eINSTANCE.getTraceabilityLink_LinkedElement();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.impact.Impact.impl.AttributeImpactedImpl <em>Attribute Impacted</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.polarsys.reqcycle.impact.Impact.impl.AttributeImpactedImpl
		 * @see org.polarsys.reqcycle.impact.Impact.impl.ImpactPackageImpl#getAttributeImpacted()
		 * @generated
		 */
		EClass ATTRIBUTE_IMPACTED = eINSTANCE.getAttributeImpacted();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_IMPACTED__ID = eINSTANCE.getAttributeImpacted_Id();

		/**
		 * The meta object literal for the '<em><b>Old Value</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_IMPACTED__OLD_VALUE = eINSTANCE.getAttributeImpacted_OldValue();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_IMPACTED__NEW_VALUE = eINSTANCE.getAttributeImpacted_NewValue();

		/**
		 * The meta object literal for the '<em>URI</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.common.util.URI
		 * @see org.polarsys.reqcycle.impact.Impact.impl.ImpactPackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

	}

} // ImpactPackage
