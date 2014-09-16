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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.polarsys.reqcycle.impact.Impact.ImpactPackage;
import org.polarsys.reqcycle.impact.Impact.TraceabilityLink;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traceability Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.impact.Impact.impl.TraceabilityLinkImpl#getLinkType <em>Link Type</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.impact.Impact.impl.TraceabilityLinkImpl#getLinkDirection <em>Link Direction</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.impact.Impact.impl.TraceabilityLinkImpl#getLinkedElement <em>Linked Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceabilityLinkImpl extends MinimalEObjectImpl.Container implements TraceabilityLink {
	/**
	 * The default value of the '{@link #getLinkType() <em>Link Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkType()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkType() <em>Link Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkType()
	 * @generated
	 * @ordered
	 */
	protected String linkType = LINK_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLinkDirection() <em>Link Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkDirection()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_DIRECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkDirection() <em>Link Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkDirection()
	 * @generated
	 * @ordered
	 */
	protected String linkDirection = LINK_DIRECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLinkedElement() <em>Linked Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkedElement()
	 * @generated
	 * @ordered
	 */
	protected static final String LINKED_ELEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkedElement() <em>Linked Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkedElement()
	 * @generated
	 * @ordered
	 */
	protected String linkedElement = LINKED_ELEMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceabilityLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImpactPackage.Literals.TRACEABILITY_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkType() {
		return linkType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkType(String newLinkType) {
		String oldLinkType = linkType;
		linkType = newLinkType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpactPackage.TRACEABILITY_LINK__LINK_TYPE, oldLinkType, linkType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkDirection() {
		return linkDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkDirection(String newLinkDirection) {
		String oldLinkDirection = linkDirection;
		linkDirection = newLinkDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpactPackage.TRACEABILITY_LINK__LINK_DIRECTION, oldLinkDirection, linkDirection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkedElement() {
		return linkedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkedElement(String newLinkedElement) {
		String oldLinkedElement = linkedElement;
		linkedElement = newLinkedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpactPackage.TRACEABILITY_LINK__LINKED_ELEMENT, oldLinkedElement, linkedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImpactPackage.TRACEABILITY_LINK__LINK_TYPE:
				return getLinkType();
			case ImpactPackage.TRACEABILITY_LINK__LINK_DIRECTION:
				return getLinkDirection();
			case ImpactPackage.TRACEABILITY_LINK__LINKED_ELEMENT:
				return getLinkedElement();
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
			case ImpactPackage.TRACEABILITY_LINK__LINK_TYPE:
				setLinkType((String)newValue);
				return;
			case ImpactPackage.TRACEABILITY_LINK__LINK_DIRECTION:
				setLinkDirection((String)newValue);
				return;
			case ImpactPackage.TRACEABILITY_LINK__LINKED_ELEMENT:
				setLinkedElement((String)newValue);
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
			case ImpactPackage.TRACEABILITY_LINK__LINK_TYPE:
				setLinkType(LINK_TYPE_EDEFAULT);
				return;
			case ImpactPackage.TRACEABILITY_LINK__LINK_DIRECTION:
				setLinkDirection(LINK_DIRECTION_EDEFAULT);
				return;
			case ImpactPackage.TRACEABILITY_LINK__LINKED_ELEMENT:
				setLinkedElement(LINKED_ELEMENT_EDEFAULT);
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
			case ImpactPackage.TRACEABILITY_LINK__LINK_TYPE:
				return LINK_TYPE_EDEFAULT == null ? linkType != null : !LINK_TYPE_EDEFAULT.equals(linkType);
			case ImpactPackage.TRACEABILITY_LINK__LINK_DIRECTION:
				return LINK_DIRECTION_EDEFAULT == null ? linkDirection != null : !LINK_DIRECTION_EDEFAULT.equals(linkDirection);
			case ImpactPackage.TRACEABILITY_LINK__LINKED_ELEMENT:
				return LINKED_ELEMENT_EDEFAULT == null ? linkedElement != null : !LINKED_ELEMENT_EDEFAULT.equals(linkedElement);
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
		result.append(" (linkType: ");
		result.append(linkType);
		result.append(", linkDirection: ");
		result.append(linkDirection);
		result.append(", linkedElement: ");
		result.append(linkedElement);
		result.append(')');
		return result.toString();
	}

} //TraceabilityLinkImpl
