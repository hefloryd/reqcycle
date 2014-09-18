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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.polarsys.reqcycle.inittypes.inittypes.Attribute;
import org.polarsys.reqcycle.inittypes.inittypes.InittypesPackage;
import org.polarsys.reqcycle.inittypes.inittypes.Regex;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.inittypes.inittypes.impl.AttributeImpl#getNameAttribute <em>Name Attribute</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.inittypes.inittypes.impl.AttributeImpl#getRegexAttribute <em>Regex Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeImpl extends MinimalEObjectImpl.Container implements Attribute {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2014 AtoS\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n  Malick Wade (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * The default value of the '{@link #getNameAttribute() <em>Name Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNameAttribute() <em>Name Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameAttribute()
	 * @generated
	 * @ordered
	 */
	protected String nameAttribute = NAME_ATTRIBUTE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRegexAttribute() <em>Regex Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegexAttribute()
	 * @generated
	 * @ordered
	 */
	protected Regex regexAttribute;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InittypesPackage.Literals.ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNameAttribute() {
		return nameAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNameAttribute(String newNameAttribute) {
		String oldNameAttribute = nameAttribute;
		nameAttribute = newNameAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InittypesPackage.ATTRIBUTE__NAME_ATTRIBUTE, oldNameAttribute, nameAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Regex getRegexAttribute() {
		return regexAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRegexAttribute(Regex newRegexAttribute, NotificationChain msgs) {
		Regex oldRegexAttribute = regexAttribute;
		regexAttribute = newRegexAttribute;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InittypesPackage.ATTRIBUTE__REGEX_ATTRIBUTE, oldRegexAttribute, newRegexAttribute);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegexAttribute(Regex newRegexAttribute) {
		if (newRegexAttribute != regexAttribute) {
			NotificationChain msgs = null;
			if (regexAttribute != null)
				msgs = ((InternalEObject)regexAttribute).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InittypesPackage.ATTRIBUTE__REGEX_ATTRIBUTE, null, msgs);
			if (newRegexAttribute != null)
				msgs = ((InternalEObject)newRegexAttribute).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InittypesPackage.ATTRIBUTE__REGEX_ATTRIBUTE, null, msgs);
			msgs = basicSetRegexAttribute(newRegexAttribute, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InittypesPackage.ATTRIBUTE__REGEX_ATTRIBUTE, newRegexAttribute, newRegexAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InittypesPackage.ATTRIBUTE__REGEX_ATTRIBUTE:
				return basicSetRegexAttribute(null, msgs);
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
			case InittypesPackage.ATTRIBUTE__NAME_ATTRIBUTE:
				return getNameAttribute();
			case InittypesPackage.ATTRIBUTE__REGEX_ATTRIBUTE:
				return getRegexAttribute();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InittypesPackage.ATTRIBUTE__NAME_ATTRIBUTE:
				setNameAttribute((String)newValue);
				return;
			case InittypesPackage.ATTRIBUTE__REGEX_ATTRIBUTE:
				setRegexAttribute((Regex)newValue);
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
			case InittypesPackage.ATTRIBUTE__NAME_ATTRIBUTE:
				setNameAttribute(NAME_ATTRIBUTE_EDEFAULT);
				return;
			case InittypesPackage.ATTRIBUTE__REGEX_ATTRIBUTE:
				setRegexAttribute((Regex)null);
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
			case InittypesPackage.ATTRIBUTE__NAME_ATTRIBUTE:
				return NAME_ATTRIBUTE_EDEFAULT == null ? nameAttribute != null : !NAME_ATTRIBUTE_EDEFAULT.equals(nameAttribute);
			case InittypesPackage.ATTRIBUTE__REGEX_ATTRIBUTE:
				return regexAttribute != null;
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
		result.append(" (nameAttribute: ");
		result.append(nameAttribute);
		result.append(')');
		return result.toString();
	}

} //AttributeImpl
