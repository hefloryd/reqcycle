/**
 * Copyright (c) 2014 AtoS
 *     All rights reserved. This program and the accompanying materials
 *     are made available under the terms of the Eclipse Public License v1.0
 *     which accompanies this distribution, and is available at
 *     http://www.eclipse.org/legal/epl-v10.html *
 *     Contributors:
 *       Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.styling.model.Styling.impl;

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

import org.polarsys.reqcycle.styling.model.Styling.Basic;
import org.polarsys.reqcycle.styling.model.Styling.CaseStyle;
import org.polarsys.reqcycle.styling.model.Styling.Default;
import org.polarsys.reqcycle.styling.model.Styling.StylingModel;
import org.polarsys.reqcycle.styling.model.Styling.StylingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.styling.model.Styling.impl.StylingModelImpl#getStyles <em>Styles</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.styling.model.Styling.impl.StylingModelImpl#getModeName <em>Mode Name</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.styling.model.Styling.impl.StylingModelImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.styling.model.Styling.impl.StylingModelImpl#getBasic <em>Basic</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StylingModelImpl extends MinimalEObjectImpl.Container implements StylingModel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2014 AtoS\r\n    All rights reserved. This program and the accompanying materials\r\n    are made available under the terms of the Eclipse Public License v1.0\r\n    which accompanies this distribution, and is available at\r\n    http://www.eclipse.org/legal/epl-v10.html *\r\n    Contributors:\r\n      Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * The cached value of the '{@link #getStyles() <em>Styles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyles()
	 * @generated
	 * @ordered
	 */
	protected EList<CaseStyle> styles;

	/**
	 * The default value of the '{@link #getModeName() <em>Mode Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModeName()
	 * @generated
	 * @ordered
	 */
	protected static final String MODE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModeName() <em>Mode Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModeName()
	 * @generated
	 * @ordered
	 */
	protected String modeName = MODE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected Default default_;

	/**
	 * The cached value of the '{@link #getBasic() <em>Basic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasic()
	 * @generated
	 * @ordered
	 */
	protected Basic basic;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StylingModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StylingPackage.Literals.STYLING_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CaseStyle> getStyles() {
		if (styles == null) {
			styles = new EObjectContainmentEList<CaseStyle>(CaseStyle.class, this, StylingPackage.STYLING_MODEL__STYLES);
		}
		return styles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModeName() {
		return modeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModeName(String newModeName) {
		String oldModeName = modeName;
		modeName = newModeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StylingPackage.STYLING_MODEL__MODE_NAME, oldModeName, modeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Default getDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefault(Default newDefault, NotificationChain msgs) {
		Default oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StylingPackage.STYLING_MODEL__DEFAULT, oldDefault, newDefault);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(Default newDefault) {
		if (newDefault != default_) {
			NotificationChain msgs = null;
			if (default_ != null)
				msgs = ((InternalEObject)default_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StylingPackage.STYLING_MODEL__DEFAULT, null, msgs);
			if (newDefault != null)
				msgs = ((InternalEObject)newDefault).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StylingPackage.STYLING_MODEL__DEFAULT, null, msgs);
			msgs = basicSetDefault(newDefault, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StylingPackage.STYLING_MODEL__DEFAULT, newDefault, newDefault));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Basic getBasic() {
		return basic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBasic(Basic newBasic, NotificationChain msgs) {
		Basic oldBasic = basic;
		basic = newBasic;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StylingPackage.STYLING_MODEL__BASIC, oldBasic, newBasic);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasic(Basic newBasic) {
		if (newBasic != basic) {
			NotificationChain msgs = null;
			if (basic != null)
				msgs = ((InternalEObject)basic).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StylingPackage.STYLING_MODEL__BASIC, null, msgs);
			if (newBasic != null)
				msgs = ((InternalEObject)newBasic).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StylingPackage.STYLING_MODEL__BASIC, null, msgs);
			msgs = basicSetBasic(newBasic, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StylingPackage.STYLING_MODEL__BASIC, newBasic, newBasic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StylingPackage.STYLING_MODEL__STYLES:
				return ((InternalEList<?>)getStyles()).basicRemove(otherEnd, msgs);
			case StylingPackage.STYLING_MODEL__DEFAULT:
				return basicSetDefault(null, msgs);
			case StylingPackage.STYLING_MODEL__BASIC:
				return basicSetBasic(null, msgs);
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
			case StylingPackage.STYLING_MODEL__STYLES:
				return getStyles();
			case StylingPackage.STYLING_MODEL__MODE_NAME:
				return getModeName();
			case StylingPackage.STYLING_MODEL__DEFAULT:
				return getDefault();
			case StylingPackage.STYLING_MODEL__BASIC:
				return getBasic();
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
			case StylingPackage.STYLING_MODEL__STYLES:
				getStyles().clear();
				getStyles().addAll((Collection<? extends CaseStyle>)newValue);
				return;
			case StylingPackage.STYLING_MODEL__MODE_NAME:
				setModeName((String)newValue);
				return;
			case StylingPackage.STYLING_MODEL__DEFAULT:
				setDefault((Default)newValue);
				return;
			case StylingPackage.STYLING_MODEL__BASIC:
				setBasic((Basic)newValue);
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
			case StylingPackage.STYLING_MODEL__STYLES:
				getStyles().clear();
				return;
			case StylingPackage.STYLING_MODEL__MODE_NAME:
				setModeName(MODE_NAME_EDEFAULT);
				return;
			case StylingPackage.STYLING_MODEL__DEFAULT:
				setDefault((Default)null);
				return;
			case StylingPackage.STYLING_MODEL__BASIC:
				setBasic((Basic)null);
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
			case StylingPackage.STYLING_MODEL__STYLES:
				return styles != null && !styles.isEmpty();
			case StylingPackage.STYLING_MODEL__MODE_NAME:
				return MODE_NAME_EDEFAULT == null ? modeName != null : !MODE_NAME_EDEFAULT.equals(modeName);
			case StylingPackage.STYLING_MODEL__DEFAULT:
				return default_ != null;
			case StylingPackage.STYLING_MODEL__BASIC:
				return basic != null;
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
		result.append(" (modeName: ");
		result.append(modeName);
		result.append(')');
		return result.toString();
	}

} //StylingModelImpl
