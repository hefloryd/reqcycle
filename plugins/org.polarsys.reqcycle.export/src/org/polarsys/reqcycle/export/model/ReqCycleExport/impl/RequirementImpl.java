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
import org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement;
import org.polarsys.reqcycle.export.model.ReqCycleExport.Traceability;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Requirement</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.RequirementImpl#getValues <em>Values</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.RequirementImpl#getDownwardTraceability <em>Downward Traceability</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.export.model.ReqCycleExport.impl.RequirementImpl#getID <em>ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementImpl extends MinimalEObjectImpl.Container implements Requirement {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2013, 2014 AtoS and others\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n Abdellah El Ayadi(AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeValue> values;

	/**
	 * The cached value of the '{@link #getDownwardTraceability() <em>Downward Traceability</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDownwardTraceability()
	 * @generated
	 * @ordered
	 */
	protected EList<Traceability> downwardTraceability;

	/**
	 * The default value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReqCycleExportPackage.Literals.REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeValue> getValues() {
		if (values == null) {
			values = new EObjectContainmentEList<AttributeValue>(AttributeValue.class, this, ReqCycleExportPackage.REQUIREMENT__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Traceability> getDownwardTraceability() {
		if (downwardTraceability == null) {
			downwardTraceability = new EObjectContainmentEList<Traceability>(Traceability.class, this, ReqCycleExportPackage.REQUIREMENT__DOWNWARD_TRACEABILITY);
		}
		return downwardTraceability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getID() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setID(String newID) {
		String oldID = id;
		id = newID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReqCycleExportPackage.REQUIREMENT__ID, oldID, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ReqCycleExportPackage.REQUIREMENT__VALUES:
				return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
			case ReqCycleExportPackage.REQUIREMENT__DOWNWARD_TRACEABILITY:
				return ((InternalEList<?>)getDownwardTraceability()).basicRemove(otherEnd, msgs);
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
			case ReqCycleExportPackage.REQUIREMENT__VALUES:
				return getValues();
			case ReqCycleExportPackage.REQUIREMENT__DOWNWARD_TRACEABILITY:
				return getDownwardTraceability();
			case ReqCycleExportPackage.REQUIREMENT__ID:
				return getID();
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
			case ReqCycleExportPackage.REQUIREMENT__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends AttributeValue>)newValue);
				return;
			case ReqCycleExportPackage.REQUIREMENT__DOWNWARD_TRACEABILITY:
				getDownwardTraceability().clear();
				getDownwardTraceability().addAll((Collection<? extends Traceability>)newValue);
				return;
			case ReqCycleExportPackage.REQUIREMENT__ID:
				setID((String)newValue);
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
			case ReqCycleExportPackage.REQUIREMENT__VALUES:
				getValues().clear();
				return;
			case ReqCycleExportPackage.REQUIREMENT__DOWNWARD_TRACEABILITY:
				getDownwardTraceability().clear();
				return;
			case ReqCycleExportPackage.REQUIREMENT__ID:
				setID(ID_EDEFAULT);
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
			case ReqCycleExportPackage.REQUIREMENT__VALUES:
				return values != null && !values.isEmpty();
			case ReqCycleExportPackage.REQUIREMENT__DOWNWARD_TRACEABILITY:
				return downwardTraceability != null && !downwardTraceability.isEmpty();
			case ReqCycleExportPackage.REQUIREMENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		result.append(" (ID: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} // RequirementImpl
