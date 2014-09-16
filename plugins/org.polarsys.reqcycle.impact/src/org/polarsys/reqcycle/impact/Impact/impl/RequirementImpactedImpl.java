/**
 * Copyright (c) 2014 AtoS
 *     All rights reserved. This program and the accompanying materials
 *     are made available under the terms of the Eclipse Public License v1.0
 *     which accompanies this distribution, and is available at
 *     http://www.eclipse.org/legal/epl-v10.html *
 *     Contributors:
 *       Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.impact.Impact.impl;

import java.lang.reflect.InvocationTargetException;
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
import org.polarsys.reqcycle.impact.Impact.AttributeImpacted;
import org.polarsys.reqcycle.impact.Impact.ImpactPackage;
import org.polarsys.reqcycle.impact.Impact.RequirementImpacted;
import org.polarsys.reqcycle.impact.Impact.TraceabilityLink;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement Impacted</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.impact.Impact.impl.RequirementImpactedImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.impact.Impact.impl.RequirementImpactedImpl#getLinkList <em>Link List</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.impact.Impact.impl.RequirementImpactedImpl#getAttributesImpacted <em>Attributes Impacted</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementImpactedImpl extends MinimalEObjectImpl.Container implements RequirementImpacted {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLinkList() <em>Link List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkList()
	 * @generated
	 * @ordered
	 */
	protected EList<TraceabilityLink> linkList;

	/**
	 * The cached value of the '{@link #getAttributesImpacted() <em>Attributes Impacted</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributesImpacted()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeImpacted> attributesImpacted;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementImpactedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImpactPackage.Literals.REQUIREMENT_IMPACTED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpactPackage.REQUIREMENT_IMPACTED__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TraceabilityLink> getLinkList() {
		if (linkList == null) {
			linkList = new EObjectContainmentEList<TraceabilityLink>(TraceabilityLink.class, this, ImpactPackage.REQUIREMENT_IMPACTED__LINK_LIST);
		}
		return linkList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeImpacted> getAttributesImpacted() {
		if (attributesImpacted == null) {
			attributesImpacted = new EObjectContainmentEList<AttributeImpacted>(AttributeImpacted.class, this, ImpactPackage.REQUIREMENT_IMPACTED__ATTRIBUTES_IMPACTED);
		}
		return attributesImpacted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AttributeImpacted getImpactedAttribute(String attributeName) {
		
		for(AttributeImpacted att : this.getAttributesImpacted()) {
			if (att.getId().equals(attributeName)) {
				return att;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImpactPackage.REQUIREMENT_IMPACTED__LINK_LIST:
				return ((InternalEList<?>)getLinkList()).basicRemove(otherEnd, msgs);
			case ImpactPackage.REQUIREMENT_IMPACTED__ATTRIBUTES_IMPACTED:
				return ((InternalEList<?>)getAttributesImpacted()).basicRemove(otherEnd, msgs);
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
			case ImpactPackage.REQUIREMENT_IMPACTED__ID:
				return getId();
			case ImpactPackage.REQUIREMENT_IMPACTED__LINK_LIST:
				return getLinkList();
			case ImpactPackage.REQUIREMENT_IMPACTED__ATTRIBUTES_IMPACTED:
				return getAttributesImpacted();
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
			case ImpactPackage.REQUIREMENT_IMPACTED__ID:
				setId((String)newValue);
				return;
			case ImpactPackage.REQUIREMENT_IMPACTED__LINK_LIST:
				getLinkList().clear();
				getLinkList().addAll((Collection<? extends TraceabilityLink>)newValue);
				return;
			case ImpactPackage.REQUIREMENT_IMPACTED__ATTRIBUTES_IMPACTED:
				getAttributesImpacted().clear();
				getAttributesImpacted().addAll((Collection<? extends AttributeImpacted>)newValue);
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
			case ImpactPackage.REQUIREMENT_IMPACTED__ID:
				setId(ID_EDEFAULT);
				return;
			case ImpactPackage.REQUIREMENT_IMPACTED__LINK_LIST:
				getLinkList().clear();
				return;
			case ImpactPackage.REQUIREMENT_IMPACTED__ATTRIBUTES_IMPACTED:
				getAttributesImpacted().clear();
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
			case ImpactPackage.REQUIREMENT_IMPACTED__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ImpactPackage.REQUIREMENT_IMPACTED__LINK_LIST:
				return linkList != null && !linkList.isEmpty();
			case ImpactPackage.REQUIREMENT_IMPACTED__ATTRIBUTES_IMPACTED:
				return attributesImpacted != null && !attributesImpacted.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ImpactPackage.REQUIREMENT_IMPACTED___GET_IMPACTED_ATTRIBUTE__STRING:
				return getImpactedAttribute((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //RequirementImpactedImpl
