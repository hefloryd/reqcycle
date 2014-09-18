/**
 * Copyright (c) 2013, 2014 AtoS and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *  Abdellah El Ayadi(AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.export.model.ReqCycleExport.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polarsys.reqcycle.export.model.ReqCycleExport.Attribute;
import org.polarsys.reqcycle.export.model.ReqCycleExport.AttributeValue;
import org.polarsys.reqcycle.export.model.ReqCycleExport.Export;
import org.polarsys.reqcycle.export.model.ReqCycleExport.Model;
import org.polarsys.reqcycle.export.model.ReqCycleExport.Property;
import org.polarsys.reqcycle.export.model.ReqCycleExport.ReqCycleExportFactory;
import org.polarsys.reqcycle.export.model.ReqCycleExport.ReqCycleExportPackage;
import org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement;
import org.polarsys.reqcycle.export.model.ReqCycleExport.Traceability;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ReqCycleExportFactoryImpl extends EFactoryImpl implements ReqCycleExportFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2013, 2014 AtoS and others\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n Abdellah El Ayadi(AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ReqCycleExportFactory init() {
		try {
			ReqCycleExportFactory theReqCycleExportFactory = (ReqCycleExportFactory)EPackage.Registry.INSTANCE.getEFactory(ReqCycleExportPackage.eNS_URI);
			if (theReqCycleExportFactory != null) {
				return theReqCycleExportFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ReqCycleExportFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReqCycleExportFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ReqCycleExportPackage.MODEL: return createModel();
			case ReqCycleExportPackage.PROPERTY: return createProperty();
			case ReqCycleExportPackage.ATTRIBUTE: return createAttribute();
			case ReqCycleExportPackage.REQUIREMENT: return createRequirement();
			case ReqCycleExportPackage.ATTRIBUTE_VALUE: return createAttributeValue();
			case ReqCycleExportPackage.TRACEABILITY: return createTraceability();
			case ReqCycleExportPackage.EXPORT: return createExport();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement createRequirement() {
		RequirementImpl requirement = new RequirementImpl();
		return requirement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeValue createAttributeValue() {
		AttributeValueImpl attributeValue = new AttributeValueImpl();
		return attributeValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Traceability createTraceability() {
		TraceabilityImpl traceability = new TraceabilityImpl();
		return traceability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Export createExport() {
		ExportImpl export = new ExportImpl();
		return export;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReqCycleExportPackage getReqCycleExportPackage() {
		return (ReqCycleExportPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ReqCycleExportPackage getPackage() {
		return ReqCycleExportPackage.eINSTANCE;
	}

} // ReqCycleExportFactoryImpl
