/**
 * Copyright (c) 2013 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *   Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.repository.data.ScopeConf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataPackage;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.data.ScopeConf.ScopeConfPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Scope</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.repository.data.ScopeConf.impl.ScopeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.repository.data.ScopeConf.impl.ScopeImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.repository.data.ScopeConf.impl.ScopeImpl#getDataModelName <em>Data Model Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScopeImpl extends MinimalEObjectImpl.Container implements Scope {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataModelName() <em>Data Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataModelName()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_MODEL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataModelName() <em>Data Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataModelName()
	 * @generated
	 * @ordered
	 */
	protected String dataModelName = DATA_MODEL_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScopeConfPackage.Literals.SCOPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScopeConfPackage.SCOPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	@Override
	public EList<AbstractElement> getRequirements() {
		return (EList<AbstractElement>) getOppositeObjs(RequirementSourceDataPackage.Literals.ABSTRACT_ELEMENT__SCOPES);
	}

	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// *
	// * @generated not
	// */
	// @Override
	// public EList<AbstractElement> getRequirements() {
	// return
	// (EList<AbstractElement>)getOppositeObjs(RequirementSourceDataPackage.Literals.ABSTRACT_ELEMENT__SCOPES);
	// }

	public EList<? extends EObject> getOppositeObjs(EReference oppositeRef) {

		ECrossReferenceAdapter c = ECrossReferenceAdapter.getCrossReferenceAdapter(this);
		if (c == null) {
			c = new ECrossReferenceAdapter();
		}

		if (c.getTarget() == null) {
			Resource r = this.eResource();
			if (r != null) {
				ResourceSet rs = r.getResourceSet();
				if (rs != null) {
					c.setTarget(rs);
				} else {
					c.setTarget(r);
				}
			} else {
				c.setTarget(this);
			}
		}

		EList<EObject> res = new BasicEList<EObject>();
		Collection<Setting> settings = c.getInverseReferences(this, true);
		for (Setting s : settings) {
			if (oppositeRef.equals(s.getEStructuralFeature())) {
				res.add(s.getEObject());
			}
		}
		return res;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	@Override
	public boolean isSetRequirements() {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataModelName() {
		return dataModelName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataModelName(String newDataModelName) {
		String oldDataModelName = dataModelName;
		dataModelName = newDataModelName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScopeConfPackage.SCOPE__DATA_MODEL_NAME, oldDataModelName, dataModelName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScopeConfPackage.SCOPE__NAME:
				return getName();
			case ScopeConfPackage.SCOPE__REQUIREMENTS:
				return getRequirements();
			case ScopeConfPackage.SCOPE__DATA_MODEL_NAME:
				return getDataModelName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ScopeConfPackage.SCOPE__NAME:
				setName((String)newValue);
				return;
			case ScopeConfPackage.SCOPE__DATA_MODEL_NAME:
				setDataModelName((String)newValue);
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
			case ScopeConfPackage.SCOPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ScopeConfPackage.SCOPE__DATA_MODEL_NAME:
				setDataModelName(DATA_MODEL_NAME_EDEFAULT);
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
			case ScopeConfPackage.SCOPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ScopeConfPackage.SCOPE__REQUIREMENTS:
				return isSetRequirements();
			case ScopeConfPackage.SCOPE__DATA_MODEL_NAME:
				return DATA_MODEL_NAME_EDEFAULT == null ? dataModelName != null : !DATA_MODEL_NAME_EDEFAULT.equals(dataModelName);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", dataModelName: ");
		result.append(dataModelName);
		result.append(')');
		return result.toString();
	}

} // ScopeImpl
