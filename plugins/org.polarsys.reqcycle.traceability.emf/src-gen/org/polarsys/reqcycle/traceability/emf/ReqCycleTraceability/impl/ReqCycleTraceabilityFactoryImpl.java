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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ELink;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Property;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityFactory;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityPackage;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ReqCycleTraceabilityFactoryImpl extends EFactoryImpl implements ReqCycleTraceabilityFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2013 AtoS\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n Abdellah EL AYADI (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ReqCycleTraceabilityFactory init() {
		try {
			ReqCycleTraceabilityFactory theReqCycleTraceabilityFactory = (ReqCycleTraceabilityFactory) EPackage.Registry.INSTANCE.getEFactory(ReqCycleTraceabilityPackage.eNS_URI);
			if (theReqCycleTraceabilityFactory != null) {
				return theReqCycleTraceabilityFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ReqCycleTraceabilityFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ReqCycleTraceabilityFactoryImpl() {
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
		case ReqCycleTraceabilityPackage.EREACHABLE:
			return createEReachable();
		case ReqCycleTraceabilityPackage.ELINK:
			return createELink();
		case ReqCycleTraceabilityPackage.PROPERTY:
			return createProperty();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EReachable createEReachable() {
		EReachableImpl eReachable = new EReachableImpl();
		ZigguratInject.inject(eReachable);
		return eReachable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ELink createELink() {
		ELinkImpl eLink = new ELinkImpl();
		ZigguratInject.inject(eLink);
		return eLink;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ReqCycleTraceabilityPackage getReqCycleTraceabilityPackage() {
		return (ReqCycleTraceabilityPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ReqCycleTraceabilityPackage getPackage() {
		return ReqCycleTraceabilityPackage.eINSTANCE;
	}

} // ReqCycleTraceabilityFactoryImpl
