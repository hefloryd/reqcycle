/**
 * Copyright (c) 2013 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *  Abdellah EL AYADI (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ELink;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Element;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Property;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityFactory;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ReqCycleTraceabilityPackageImpl extends EPackageImpl implements ReqCycleTraceabilityPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2013 AtoS\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n Abdellah EL AYADI (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass eReachableEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass eLinkEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass elementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ReqCycleTraceabilityPackageImpl() {
		super(eNS_URI, ReqCycleTraceabilityFactory.eINSTANCE);
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
	 * This method is used to initialize {@link ReqCycleTraceabilityPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ReqCycleTraceabilityPackage init() {
		if (isInited)
			return (ReqCycleTraceabilityPackage) EPackage.Registry.INSTANCE.getEPackage(ReqCycleTraceabilityPackage.eNS_URI);

		// Obtain or create and register package
		ReqCycleTraceabilityPackageImpl theReqCycleTraceabilityPackage = (ReqCycleTraceabilityPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ReqCycleTraceabilityPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
				: new ReqCycleTraceabilityPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theReqCycleTraceabilityPackage.createPackageContents();

		// Initialize created meta-data
		theReqCycleTraceabilityPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theReqCycleTraceabilityPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ReqCycleTraceabilityPackage.eNS_URI, theReqCycleTraceabilityPackage);
		return theReqCycleTraceabilityPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEReachable() {
		return eReachableEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEReachable_Downwards() {
		return (EReference) eReachableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEReachable_Types() {
		return (EAttribute) eReachableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEReachable_Upwards() {
		return (EReference) eReachableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getEReachable__GetEObject() {
		return eReachableEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getELink() {
		return eLinkEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getELink_Upwards() {
		return (EReference) eLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getELink_Downwards() {
		return (EReference) eLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getELink_Attributes() {
		return (EReference) eLinkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getElement() {
		return elementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getElement_URI() {
		return (EAttribute) elementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getElement_Label() {
		return (EAttribute) elementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getElement__GetAdapter__Class() {
		return elementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getProperty_Name() {
		return (EAttribute) propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getProperty_Value() {
		return (EAttribute) propertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ReqCycleTraceabilityFactory getReqCycleTraceabilityFactory() {
		return (ReqCycleTraceabilityFactory) getEFactoryInstance();
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
		eReachableEClass = createEClass(EREACHABLE);
		createEReference(eReachableEClass, EREACHABLE__DOWNWARDS);
		createEAttribute(eReachableEClass, EREACHABLE__TYPES);
		createEReference(eReachableEClass, EREACHABLE__UPWARDS);
		createEOperation(eReachableEClass, EREACHABLE___GET_EOBJECT);

		eLinkEClass = createEClass(ELINK);
		createEReference(eLinkEClass, ELINK__UPWARDS);
		createEReference(eLinkEClass, ELINK__DOWNWARDS);
		createEReference(eLinkEClass, ELINK__ATTRIBUTES);

		elementEClass = createEClass(ELEMENT);
		createEAttribute(elementEClass, ELEMENT__URI);
		createEAttribute(elementEClass, ELEMENT__LABEL);
		createEOperation(elementEClass, ELEMENT___GET_ADAPTER__CLASS);

		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__NAME);
		createEAttribute(propertyEClass, PROPERTY__VALUE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		eReachableEClass.getESuperTypes().add(this.getElement());
		eLinkEClass.getESuperTypes().add(this.getElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(eReachableEClass, EReachable.class, "EReachable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEReachable_Downwards(), this.getELink(), null, "downwards", null, 0, -1, EReachable.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getEReachable_Types(), ecorePackage.getEString(), "types", null, 0, -1, EReachable.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEReachable_Upwards(), this.getELink(), null, "upwards", null, 0, -1, EReachable.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getEReachable__GetEObject(), ecorePackage.getEObject(), "getEObject", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eLinkEClass, ELink.class, "ELink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getELink_Upwards(), this.getEReachable(), null, "upwards", null, 0, -1, ELink.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getELink_Downwards(), this.getEReachable(), null, "downwards", null, 0, -1, ELink.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getELink_Attributes(), this.getProperty(), null, "attributes", null, 0, -1, ELink.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElement_URI(), ecorePackage.getEString(), "URI", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getElement_Label(), ecorePackage.getEString(), "label", null, 0, 1, Element.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getElement__GetAdapter__Class(), ecorePackage.getEJavaObject(), "getAdapter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaClass(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProperty_Name(), ecorePackage.getEString(), "name", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // ReqCycleTraceabilityPackageImpl
