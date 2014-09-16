/**
 * Copyright (c) 2014 AtoS
 *     All rights reserved. This program and the accompanying materials
 *     are made available under the terms of the Eclipse Public License v1.0
 *     which accompanies this distribution, and is available at
 *     http://www.eclipse.org/legal/epl-v10.html *
 *     Contributors:
 *       Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.impact.Impact.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polarsys.reqcycle.impact.Impact.AttributeImpacted;
import org.polarsys.reqcycle.impact.Impact.ImpactAnalysis;
import org.polarsys.reqcycle.impact.Impact.ImpactFactory;
import org.polarsys.reqcycle.impact.Impact.ImpactPackage;
import org.polarsys.reqcycle.impact.Impact.RequirementImpacted;
import org.polarsys.reqcycle.impact.Impact.TraceabilityLink;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSourceConfPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ImpactPackageImpl extends EPackageImpl implements ImpactPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass impactAnalysisEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass requirementImpactedEClass = null;
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass traceabilityLinkEClass = null;
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass attributeImpactedEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ImpactPackageImpl() {
		super(eNS_URI, ImpactFactory.eINSTANCE);
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
	 * This method is used to initialize {@link ImpactPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ImpactPackage init() {
		if (isInited)
			return (ImpactPackage) EPackage.Registry.INSTANCE.getEPackage(ImpactPackage.eNS_URI);

		// Obtain or create and register package
		ImpactPackageImpl theImpactPackage = (ImpactPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ImpactPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ImpactPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		RequirementSourceConfPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theImpactPackage.createPackageContents();

		// Initialize created meta-data
		theImpactPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theImpactPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ImpactPackage.eNS_URI, theImpactPackage);
		return theImpactPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getImpactAnalysis() {
		return impactAnalysisEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getImpactAnalysis_RequirementsAdded() {
		return (EReference) impactAnalysisEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getImpactAnalysis_RequirementsDeleted() {
		return (EReference) impactAnalysisEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getImpactAnalysis_RequirementsModified() {
		return (EReference) impactAnalysisEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getImpactAnalysis__LaunchAnalysis__RequirementSource_RequirementSource() {
		return impactAnalysisEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getImpactAnalysis__SaveAnalysis__URI() {
		return impactAnalysisEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRequirementImpacted() {
		return requirementImpactedEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRequirementImpacted_Id() {
		return (EAttribute) requirementImpactedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getRequirementImpacted_LinkList() {
		return (EReference) requirementImpactedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getRequirementImpacted_AttributesImpacted() {
		return (EReference) requirementImpactedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getRequirementImpacted__GetImpactedAttribute__String() {
		return requirementImpactedEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTraceabilityLink() {
		return traceabilityLinkEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getTraceabilityLink_LinkType() {
		return (EAttribute) traceabilityLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getTraceabilityLink_LinkDirection() {
		return (EAttribute) traceabilityLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getTraceabilityLink_LinkedElement() {
		return (EAttribute) traceabilityLinkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAttributeImpacted() {
		return attributeImpactedEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAttributeImpacted_Id() {
		return (EAttribute) attributeImpactedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAttributeImpacted_OldValue() {
		return (EAttribute) attributeImpactedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAttributeImpacted_NewValue() {
		return (EAttribute) attributeImpactedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ImpactFactory getImpactFactory() {
		return (ImpactFactory) getEFactoryInstance();
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
		impactAnalysisEClass = createEClass(IMPACT_ANALYSIS);
		createEReference(impactAnalysisEClass, IMPACT_ANALYSIS__REQUIREMENTS_ADDED);
		createEReference(impactAnalysisEClass, IMPACT_ANALYSIS__REQUIREMENTS_DELETED);
		createEReference(impactAnalysisEClass, IMPACT_ANALYSIS__REQUIREMENTS_MODIFIED);
		createEOperation(impactAnalysisEClass, IMPACT_ANALYSIS___LAUNCH_ANALYSIS__REQUIREMENTSOURCE_REQUIREMENTSOURCE);
		createEOperation(impactAnalysisEClass, IMPACT_ANALYSIS___SAVE_ANALYSIS__URI);

		requirementImpactedEClass = createEClass(REQUIREMENT_IMPACTED);
		createEAttribute(requirementImpactedEClass, REQUIREMENT_IMPACTED__ID);
		createEReference(requirementImpactedEClass, REQUIREMENT_IMPACTED__LINK_LIST);
		createEReference(requirementImpactedEClass, REQUIREMENT_IMPACTED__ATTRIBUTES_IMPACTED);
		createEOperation(requirementImpactedEClass, REQUIREMENT_IMPACTED___GET_IMPACTED_ATTRIBUTE__STRING);

		traceabilityLinkEClass = createEClass(TRACEABILITY_LINK);
		createEAttribute(traceabilityLinkEClass, TRACEABILITY_LINK__LINK_TYPE);
		createEAttribute(traceabilityLinkEClass, TRACEABILITY_LINK__LINK_DIRECTION);
		createEAttribute(traceabilityLinkEClass, TRACEABILITY_LINK__LINKED_ELEMENT);

		attributeImpactedEClass = createEClass(ATTRIBUTE_IMPACTED);
		createEAttribute(attributeImpactedEClass, ATTRIBUTE_IMPACTED__ID);
		createEAttribute(attributeImpactedEClass, ATTRIBUTE_IMPACTED__OLD_VALUE);
		createEAttribute(attributeImpactedEClass, ATTRIBUTE_IMPACTED__NEW_VALUE);

		// Create data types
		uriEDataType = createEDataType(URI);
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
		RequirementSourceConfPackage theRequirementSourceConfPackage = (RequirementSourceConfPackage) EPackage.Registry.INSTANCE.getEPackage(RequirementSourceConfPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(impactAnalysisEClass, ImpactAnalysis.class, "ImpactAnalysis", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImpactAnalysis_RequirementsAdded(), this.getRequirementImpacted(), null, "requirementsAdded", null, 0, -1, ImpactAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpactAnalysis_RequirementsDeleted(), this.getRequirementImpacted(), null, "requirementsDeleted", null, 0, -1, ImpactAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpactAnalysis_RequirementsModified(), this.getRequirementImpacted(), null, "requirementsModified", null, 0, -1, ImpactAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getImpactAnalysis__LaunchAnalysis__RequirementSource_RequirementSource(), null, "launchAnalysis", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRequirementSourceConfPackage.getRequirementSource(), "rsFrom", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRequirementSourceConfPackage.getRequirementSource(), "rstTo", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getImpactAnalysis__SaveAnalysis__URI(), null, "saveAnalysis", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getURI(), "targetName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(requirementImpactedEClass, RequirementImpacted.class, "RequirementImpacted", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRequirementImpacted_Id(), ecorePackage.getEString(), "id", null, 1, 1, RequirementImpacted.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequirementImpacted_LinkList(), this.getTraceabilityLink(), null, "LinkList", null, 0, -1, RequirementImpacted.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getRequirementImpacted_AttributesImpacted(), this.getAttributeImpacted(), null, "attributesImpacted", null, 0, -1, RequirementImpacted.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getRequirementImpacted__GetImpactedAttribute__String(), this.getAttributeImpacted(), "getImpactedAttribute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "attributeName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(traceabilityLinkEClass, TraceabilityLink.class, "TraceabilityLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTraceabilityLink_LinkType(), ecorePackage.getEString(), "linkType", null, 1, 1, TraceabilityLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceabilityLink_LinkDirection(), ecorePackage.getEString(), "linkDirection", null, 1, 1, TraceabilityLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceabilityLink_LinkedElement(), ecorePackage.getEString(), "linkedElement", null, 1, 1, TraceabilityLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeImpactedEClass, AttributeImpacted.class, "AttributeImpacted", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeImpacted_Id(), ecorePackage.getEString(), "id", null, 1, 1, AttributeImpacted.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeImpacted_OldValue(), ecorePackage.getEString(), "oldValue", null, 1, 1, AttributeImpacted.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeImpacted_NewValue(), ecorePackage.getEString(), "newValue", null, 1, 1, AttributeImpacted.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} // ImpactPackageImpl
