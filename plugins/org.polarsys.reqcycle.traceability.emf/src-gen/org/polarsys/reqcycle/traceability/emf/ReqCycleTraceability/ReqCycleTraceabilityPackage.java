/**
 * Copyright (c) 2013 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *  Abdellah EL AYADI (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityFactory
 * @model kind="package"
 * @generated
 */
public interface ReqCycleTraceabilityPackage extends EPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String copyright = "Copyright (c) 2013 AtoS\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n Abdellah EL AYADI (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "ReqCycleTraceability";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.polarsys.org/reqcycle/1.0/tracea";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "tracea";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ReqCycleTraceabilityPackage eINSTANCE = org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ReqCycleTraceabilityPackageImpl.init();

	/**
	 * The meta object id for the ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ElementImpl <em>Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ElementImpl
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ReqCycleTraceabilityPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT__URI = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT__LABEL = 1;

	/**
	 * The number of structural features of the '<em>Element</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Get Adapter</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT___GET_ADAPTER__CLASS = 0;

	/**
	 * The number of operations of the '<em>Element</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.EReachableImpl <em>EReachable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.EReachableImpl
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ReqCycleTraceabilityPackageImpl#getEReachable()
	 * @generated
	 */
	int EREACHABLE = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EREACHABLE__URI = ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EREACHABLE__LABEL = ELEMENT__LABEL;

	/**
	 * The feature id for the '<em><b>Downwards</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EREACHABLE__DOWNWARDS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Types</b></em>' attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EREACHABLE__TYPES = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Upwards</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EREACHABLE__UPWARDS = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>EReachable</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EREACHABLE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Adapter</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EREACHABLE___GET_ADAPTER__CLASS = ELEMENT___GET_ADAPTER__CLASS;

	/**
	 * The operation id for the '<em>Get EObject</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EREACHABLE___GET_EOBJECT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>EReachable</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EREACHABLE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ELinkImpl <em>ELink</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ELinkImpl
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ReqCycleTraceabilityPackageImpl#getELink()
	 * @generated
	 */
	int ELINK = 1;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELINK__URI = ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELINK__LABEL = ELEMENT__LABEL;

	/**
	 * The feature id for the '<em><b>Upwards</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELINK__UPWARDS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Downwards</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELINK__DOWNWARDS = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELINK__ATTRIBUTES = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>ELink</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELINK_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Adapter</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELINK___GET_ADAPTER__CLASS = ELEMENT___GET_ADAPTER__CLASS;

	/**
	 * The number of operations of the '<em>ELink</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELINK_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.PropertyImpl <em>Property</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.PropertyImpl
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ReqCycleTraceabilityPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Property</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Property</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable <em>EReachable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>EReachable</em>'.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable
	 * @generated
	 */
	EClass getEReachable();

	/**
	 * Returns the meta object for the reference list ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable#getDownwards <em>Downwards</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Downwards</em>'.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable#getDownwards()
	 * @see #getEReachable()
	 * @generated
	 */
	EReference getEReachable_Downwards();

	/**
	 * Returns the meta object for the attribute list ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable#getTypes <em>Types</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Types</em>'.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable#getTypes()
	 * @see #getEReachable()
	 * @generated
	 */
	EAttribute getEReachable_Types();

	/**
	 * Returns the meta object for the reference list ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable#getUpwards <em>Upwards</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Upwards</em>'.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable#getUpwards()
	 * @see #getEReachable()
	 * @generated
	 */
	EReference getEReachable_Upwards();

	/**
	 * Returns the meta object for the ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable#getEObject() <em>Get EObject</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the '<em>Get EObject</em>' operation.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable#getEObject()
	 * @generated
	 */
	EOperation getEReachable__GetEObject();

	/**
	 * Returns the meta object for class ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ELink <em>ELink</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>ELink</em>'.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ELink
	 * @generated
	 */
	EClass getELink();

	/**
	 * Returns the meta object for the reference list ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ELink#getUpwards <em>Upwards</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Upwards</em>'.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ELink#getUpwards()
	 * @see #getELink()
	 * @generated
	 */
	EReference getELink_Upwards();

	/**
	 * Returns the meta object for the reference list ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ELink#getDownwards <em>Downwards</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Downwards</em>'.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ELink#getDownwards()
	 * @see #getELink()
	 * @generated
	 */
	EReference getELink_Downwards();

	/**
	 * Returns the meta object for the containment reference list ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ELink#getAttributes <em>Attributes</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list ' <em>Attributes</em>'.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ELink#getAttributes()
	 * @see #getELink()
	 * @generated
	 */
	EReference getELink_Attributes();

	/**
	 * Returns the meta object for class ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Element <em>Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the attribute ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Element#getURI <em>URI</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>URI</em>'.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Element#getURI()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_URI();

	/**
	 * Returns the meta object for the attribute ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Element#getLabel <em>Label</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Element#getLabel()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Label();

	/**
	 * Returns the meta object for the ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Element#getAdapter(java.lang.Class) <em>Get Adapter</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the '<em>Get Adapter</em>' operation.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Element#getAdapter(java.lang.Class)
	 * @generated
	 */
	EOperation getElement__GetAdapter__Class();

	/**
	 * Returns the meta object for class ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Property <em>Property</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Property#getName <em>Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the attribute ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Property#getValue <em>Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Property#getValue()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Value();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ReqCycleTraceabilityFactory getReqCycleTraceabilityFactory();

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
		 * The meta object literal for the ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.EReachableImpl <em>EReachable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.EReachableImpl
		 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ReqCycleTraceabilityPackageImpl#getEReachable()
		 * @generated
		 */
		EClass EREACHABLE = eINSTANCE.getEReachable();

		/**
		 * The meta object literal for the '<em><b>Downwards</b></em>' reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EREACHABLE__DOWNWARDS = eINSTANCE.getEReachable_Downwards();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' attribute list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EREACHABLE__TYPES = eINSTANCE.getEReachable_Types();

		/**
		 * The meta object literal for the '<em><b>Upwards</b></em>' reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EREACHABLE__UPWARDS = eINSTANCE.getEReachable_Upwards();

		/**
		 * The meta object literal for the '<em><b>Get EObject</b></em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation EREACHABLE___GET_EOBJECT = eINSTANCE.getEReachable__GetEObject();

		/**
		 * The meta object literal for the ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ELinkImpl <em>ELink</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ELinkImpl
		 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ReqCycleTraceabilityPackageImpl#getELink()
		 * @generated
		 */
		EClass ELINK = eINSTANCE.getELink();

		/**
		 * The meta object literal for the '<em><b>Upwards</b></em>' reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ELINK__UPWARDS = eINSTANCE.getELink_Upwards();

		/**
		 * The meta object literal for the '<em><b>Downwards</b></em>' reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ELINK__DOWNWARDS = eINSTANCE.getELink_Downwards();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ELINK__ATTRIBUTES = eINSTANCE.getELink_Attributes();

		/**
		 * The meta object literal for the ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ElementImpl <em>Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ElementImpl
		 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ReqCycleTraceabilityPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>URI</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ELEMENT__URI = eINSTANCE.getElement_URI();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ELEMENT__LABEL = eINSTANCE.getElement_Label();

		/**
		 * The meta object literal for the '<em><b>Get Adapter</b></em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation ELEMENT___GET_ADAPTER__CLASS = eINSTANCE.getElement__GetAdapter__Class();

		/**
		 * The meta object literal for the ' {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.PropertyImpl <em>Property</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.PropertyImpl
		 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ReqCycleTraceabilityPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROPERTY__VALUE = eINSTANCE.getProperty_Value();

	}

} // ReqCycleTraceabilityPackage
