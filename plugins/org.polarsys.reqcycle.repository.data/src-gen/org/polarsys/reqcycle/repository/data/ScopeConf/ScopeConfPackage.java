/**
 * Copyright (c) 2013 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *   Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.repository.data.ScopeConf;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polarsys.reqcycle.repository.data.ScopeConf.ScopeConfFactory
 * @model kind="package"
 * @generated
 */
public interface ScopeConfPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ScopeConf";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.polarsys.org/ReqCycle/ScopeConf";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ScopeConf";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	ScopeConfPackage eINSTANCE = org.polarsys.reqcycle.repository.data.ScopeConf.impl.ScopeConfPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.repository.data.ScopeConf.impl.ScopesImpl <em>Scopes</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.repository.data.ScopeConf.impl.ScopesImpl
	 * @see org.polarsys.reqcycle.repository.data.ScopeConf.impl.ScopeConfPackageImpl#getScopes()
	 * @generated
	 */
	int SCOPES = 0;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPES__SCOPES = 0;

	/**
	 * The number of structural features of the '<em>Scopes</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCOPES_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Scopes</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCOPES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.reqcycle.repository.data.ScopeConf.impl.ScopeImpl <em>Scope</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.polarsys.reqcycle.repository.data.ScopeConf.impl.ScopeImpl
	 * @see org.polarsys.reqcycle.repository.data.ScopeConf.impl.ScopeConfPackageImpl#getScope()
	 * @generated
	 */
	int SCOPE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCOPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE__REQUIREMENTS = 1;

	/**
	 * The feature id for the '<em><b>Data Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE__DATA_MODEL_NAME = 2;

	/**
	 * The number of structural features of the '<em>Scope</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCOPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Scope</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCOPE_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.repository.data.ScopeConf.Scopes <em>Scopes</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scopes</em>'.
	 * @see org.polarsys.reqcycle.repository.data.ScopeConf.Scopes
	 * @generated
	 */
	EClass getScopes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.reqcycle.repository.data.ScopeConf.Scopes#getScopes <em>Scopes</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scopes</em>'.
	 * @see org.polarsys.reqcycle.repository.data.ScopeConf.Scopes#getScopes()
	 * @see #getScopes()
	 * @generated
	 */
	EReference getScopes_Scopes();

	/**
	 * Returns the meta object for class '{@link org.polarsys.reqcycle.repository.data.ScopeConf.Scope <em>Scope</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scope</em>'.
	 * @see org.polarsys.reqcycle.repository.data.ScopeConf.Scope
	 * @generated
	 */
	EClass getScope();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.repository.data.ScopeConf.Scope#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polarsys.reqcycle.repository.data.ScopeConf.Scope#getName()
	 * @see #getScope()
	 * @generated
	 */
	EAttribute getScope_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.reqcycle.repository.data.ScopeConf.Scope#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requirements</em>'.
	 * @see org.polarsys.reqcycle.repository.data.ScopeConf.Scope#getRequirements()
	 * @see #getScope()
	 * @generated
	 */
	EReference getScope_Requirements();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.reqcycle.repository.data.ScopeConf.Scope#getDataModelName <em>Data Model Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Model Name</em>'.
	 * @see org.polarsys.reqcycle.repository.data.ScopeConf.Scope#getDataModelName()
	 * @see #getScope()
	 * @generated
	 */
	EAttribute getScope_DataModelName();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ScopeConfFactory getScopeConfFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
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
		 * The meta object literal for the '
		 * {@link org.polarsys.reqcycle.repository.data.ScopeConf.impl.ScopesImpl
		 * <em>Scopes</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.polarsys.reqcycle.repository.data.ScopeConf.impl.ScopesImpl
		 * @see org.polarsys.reqcycle.repository.data.ScopeConf.impl.ScopeConfPackageImpl#getScopes()
		 * @generated
		 */
		EClass SCOPES = eINSTANCE.getScopes();

		/**
		 * The meta object literal for the '<em><b>Scopes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOPES__SCOPES = eINSTANCE.getScopes_Scopes();

		/**
		 * The meta object literal for the '{@link org.polarsys.reqcycle.repository.data.ScopeConf.impl.ScopeImpl <em>Scope</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.polarsys.reqcycle.repository.data.ScopeConf.impl.ScopeImpl
		 * @see org.polarsys.reqcycle.repository.data.ScopeConf.impl.ScopeConfPackageImpl#getScope()
		 * @generated
		 */
		EClass SCOPE = eINSTANCE.getScope();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCOPE__NAME = eINSTANCE.getScope_Name();

		/**
		 * The meta object literal for the '<em><b>Requirements</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOPE__REQUIREMENTS = eINSTANCE.getScope_Requirements();

		/**
		 * The meta object literal for the '<em><b>Data Model Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCOPE__DATA_MODEL_NAME = eINSTANCE.getScope_DataModelName();

	}

} // ScopeConfPackage
