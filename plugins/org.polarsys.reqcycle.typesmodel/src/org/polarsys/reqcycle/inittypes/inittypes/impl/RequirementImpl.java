/**
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *   Malick Wade (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.inittypes.inittypes.impl;

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

import org.polarsys.reqcycle.inittypes.inittypes.Attribute;
import org.polarsys.reqcycle.inittypes.inittypes.InittypesPackage;
import org.polarsys.reqcycle.inittypes.inittypes.Regex;
import org.polarsys.reqcycle.inittypes.inittypes.Requirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.inittypes.inittypes.impl.RequirementImpl#getNameReq <em>Name Req</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.inittypes.inittypes.impl.RequirementImpl#getRegexReq <em>Regex Req</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.inittypes.inittypes.impl.RequirementImpl#getAttributesReq <em>Attributes Req</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementImpl extends MinimalEObjectImpl.Container implements Requirement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2014 AtoS\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n  Malick Wade (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * The default value of the '{@link #getNameReq() <em>Name Req</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameReq()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_REQ_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNameReq() <em>Name Req</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameReq()
	 * @generated
	 * @ordered
	 */
	protected String nameReq = NAME_REQ_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRegexReq() <em>Regex Req</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegexReq()
	 * @generated
	 * @ordered
	 */
	protected Regex regexReq;

	/**
	 * The cached value of the '{@link #getAttributesReq() <em>Attributes Req</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributesReq()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributesReq;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InittypesPackage.Literals.REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNameReq() {
		return nameReq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNameReq(String newNameReq) {
		String oldNameReq = nameReq;
		nameReq = newNameReq;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InittypesPackage.REQUIREMENT__NAME_REQ, oldNameReq, nameReq));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Regex getRegexReq() {
		return regexReq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRegexReq(Regex newRegexReq, NotificationChain msgs) {
		Regex oldRegexReq = regexReq;
		regexReq = newRegexReq;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InittypesPackage.REQUIREMENT__REGEX_REQ, oldRegexReq, newRegexReq);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegexReq(Regex newRegexReq) {
		if (newRegexReq != regexReq) {
			NotificationChain msgs = null;
			if (regexReq != null)
				msgs = ((InternalEObject)regexReq).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InittypesPackage.REQUIREMENT__REGEX_REQ, null, msgs);
			if (newRegexReq != null)
				msgs = ((InternalEObject)newRegexReq).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InittypesPackage.REQUIREMENT__REGEX_REQ, null, msgs);
			msgs = basicSetRegexReq(newRegexReq, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InittypesPackage.REQUIREMENT__REGEX_REQ, newRegexReq, newRegexReq));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttributesReq() {
		if (attributesReq == null) {
			attributesReq = new EObjectContainmentEList<Attribute>(Attribute.class, this, InittypesPackage.REQUIREMENT__ATTRIBUTES_REQ);
		}
		return attributesReq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InittypesPackage.REQUIREMENT__REGEX_REQ:
				return basicSetRegexReq(null, msgs);
			case InittypesPackage.REQUIREMENT__ATTRIBUTES_REQ:
				return ((InternalEList<?>)getAttributesReq()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InittypesPackage.REQUIREMENT__NAME_REQ:
				return getNameReq();
			case InittypesPackage.REQUIREMENT__REGEX_REQ:
				return getRegexReq();
			case InittypesPackage.REQUIREMENT__ATTRIBUTES_REQ:
				return getAttributesReq();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InittypesPackage.REQUIREMENT__NAME_REQ:
				setNameReq((String)newValue);
				return;
			case InittypesPackage.REQUIREMENT__REGEX_REQ:
				setRegexReq((Regex)newValue);
				return;
			case InittypesPackage.REQUIREMENT__ATTRIBUTES_REQ:
				getAttributesReq().clear();
				getAttributesReq().addAll((Collection<? extends Attribute>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case InittypesPackage.REQUIREMENT__NAME_REQ:
				setNameReq(NAME_REQ_EDEFAULT);
				return;
			case InittypesPackage.REQUIREMENT__REGEX_REQ:
				setRegexReq((Regex)null);
				return;
			case InittypesPackage.REQUIREMENT__ATTRIBUTES_REQ:
				getAttributesReq().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case InittypesPackage.REQUIREMENT__NAME_REQ:
				return NAME_REQ_EDEFAULT == null ? nameReq != null : !NAME_REQ_EDEFAULT.equals(nameReq);
			case InittypesPackage.REQUIREMENT__REGEX_REQ:
				return regexReq != null;
			case InittypesPackage.REQUIREMENT__ATTRIBUTES_REQ:
				return attributesReq != null && !attributesReq.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (nameReq: ");
		result.append(nameReq);
		result.append(')');
		return result.toString();
	}

} //RequirementImpl
