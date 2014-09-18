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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polarsys.reqcycle.export.model.ReqCycleExport.AttributeValue;
import org.polarsys.reqcycle.export.model.ReqCycleExport.ReqCycleExportPackage;
import org.polarsys.reqcycle.export.model.ReqCycleExport.Traceability;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Traceability</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.TraceabilityImpl#getElementTracedLabel <em>Element Traced Label</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.TraceabilityImpl#getTraceabilityValues <em>Traceability Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceabilityImpl extends MinimalEObjectImpl.Container implements Traceability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2013, 2014 AtoS and others\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n Abdellah El Ayadi(AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * The default value of the '{@link #getElementTracedLabel() <em>Element Traced Label</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getElementTracedLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_TRACED_LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementTracedLabel() <em>Element Traced Label</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getElementTracedLabel()
	 * @generated
	 * @ordered
	 */
	protected String elementTracedLabel = ELEMENT_TRACED_LABEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTraceabilityValues() <em>Traceability Values</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTraceabilityValues()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeValue> traceabilityValues;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceabilityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReqCycleExportPackage.Literals.TRACEABILITY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getElementTracedLabel() {
		return elementTracedLabel;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementTracedLabel(String newElementTracedLabel) {
		String oldElementTracedLabel = elementTracedLabel;
		elementTracedLabel = newElementTracedLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReqCycleExportPackage.TRACEABILITY__ELEMENT_TRACED_LABEL, oldElementTracedLabel, elementTracedLabel));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeValue> getTraceabilityValues() {
		if (traceabilityValues == null) {
			traceabilityValues = new EObjectContainmentEList<AttributeValue>(AttributeValue.class, this, ReqCycleExportPackage.TRACEABILITY__TRACEABILITY_VALUES);
		}
		return traceabilityValues;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ReqCycleExportPackage.TRACEABILITY__TRACEABILITY_VALUES:
				return ((InternalEList<?>)getTraceabilityValues()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ReqCycleExportPackage.TRACEABILITY__ELEMENT_TRACED_LABEL:
				return getElementTracedLabel();
			case ReqCycleExportPackage.TRACEABILITY__TRACEABILITY_VALUES:
				return getTraceabilityValues();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ReqCycleExportPackage.TRACEABILITY__ELEMENT_TRACED_LABEL:
				setElementTracedLabel((String)newValue);
				return;
			case ReqCycleExportPackage.TRACEABILITY__TRACEABILITY_VALUES:
				getTraceabilityValues().clear();
				getTraceabilityValues().addAll((Collection<? extends AttributeValue>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ReqCycleExportPackage.TRACEABILITY__ELEMENT_TRACED_LABEL:
				setElementTracedLabel(ELEMENT_TRACED_LABEL_EDEFAULT);
				return;
			case ReqCycleExportPackage.TRACEABILITY__TRACEABILITY_VALUES:
				getTraceabilityValues().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ReqCycleExportPackage.TRACEABILITY__ELEMENT_TRACED_LABEL:
				return ELEMENT_TRACED_LABEL_EDEFAULT == null ? elementTracedLabel != null : !ELEMENT_TRACED_LABEL_EDEFAULT.equals(elementTracedLabel);
			case ReqCycleExportPackage.TRACEABILITY__TRACEABILITY_VALUES:
				return traceabilityValues != null && !traceabilityValues.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (elementTracedLabel: ");
		result.append(elementTracedLabel);
		result.append(')');
		return result.toString();
	}

} // TraceabilityImpl
