/**
 * Copyright (c) 2013 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *   Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.repository.data.RequirementSourceConf.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.polarsys.reqcycle.repository.data.RequirementSourceConf.*;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class RequirementSourceConfFactoryImpl extends EFactoryImpl implements RequirementSourceConfFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static RequirementSourceConfFactory init() {
		try {
			RequirementSourceConfFactory theRequirementSourceConfFactory = (RequirementSourceConfFactory) EPackage.Registry.INSTANCE.getEFactory(RequirementSourceConfPackage.eNS_URI);
			if (theRequirementSourceConfFactory != null) {
				return theRequirementSourceConfFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RequirementSourceConfFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RequirementSourceConfFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case RequirementSourceConfPackage.REQUIREMENT_SOURCES:
			return createRequirementSources();
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE:
			return createRequirementSource();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RequirementSources createRequirementSources() {
		RequirementSourcesImpl requirementSources = new RequirementSourcesImpl();
		return requirementSources;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RequirementSource createRequirementSource() {
		RequirementSourceImpl requirementSource = new RequirementSourceImpl();
		return requirementSource;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RequirementSourceConfPackage getRequirementSourceConfPackage() {
		return (RequirementSourceConfPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RequirementSourceConfPackage getPackage() {
		return RequirementSourceConfPackage.eINSTANCE;
	}

} // RequirementSourceConfFactoryImpl
