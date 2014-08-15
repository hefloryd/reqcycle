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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ELink;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Property;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityFactory;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityPackage;
import org.polarsys.reqcycle.traceability.types.ITraceabilityAttributesManager;
import org.polarsys.reqcycle.traceability.types.ITraceabilityAttributesManager.EditableAttribute;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>ELink</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ELinkImpl#getUpwards
 * <em>Upwards</em>}</li>
 * <li>
 * {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ELinkImpl#getDownwards
 * <em>Downwards</em>}</li>
 * <li>
 * {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.ELinkImpl#getAttributes
 * <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ELinkImpl extends ElementImpl implements ELink {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2013 AtoS\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n Abdellah EL AYADI (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * The cached value of the '{@link #getUpwards() <em>Upwards</em>}'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUpwards()
	 * @generated
	 * @ordered
	 */
	protected EList<EReachable> upwards;

	/**
	 * The cached value of the '{@link #getDownwards() <em>Downwards</em>}'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDownwards()
	 * @generated
	 * @ordered
	 */
	protected EList<EReachable> downwards;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> attributes;

	private ITraceabilityAttributesManager attributesManager = ZigguratInject.make(ITraceabilityAttributesManager.class);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ELinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReqCycleTraceabilityPackage.Literals.ELINK;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<EReachable> getUpwards() {
		if (upwards == null) {
			upwards = new EObjectResolvingEList<EReachable>(EReachable.class, this, ReqCycleTraceabilityPackage.ELINK__UPWARDS);
		}
		return upwards;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<EReachable> getDownwards() {
		if (downwards == null) {
			downwards = new EObjectResolvingEList<EReachable>(EReachable.class, this, ReqCycleTraceabilityPackage.ELINK__DOWNWARDS);
		}
		return downwards;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Property> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Property>(Property.class, this, ReqCycleTraceabilityPackage.ELINK__ATTRIBUTES);
			initAttributes();
		}
		return attributes;
	}

	protected void initAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Property>(Property.class, this, ReqCycleTraceabilityPackage.ELINK__ATTRIBUTES);
		}
		attributes.clear();
		Reachable reachable = (Reachable) getAdapter(Reachable.class);
		Collection<EditableAttribute> editableAttributes = attributesManager.getAttributes(reachable);
		for (EditableAttribute editableAttribute : editableAttributes) {
			Property property = ReqCycleTraceabilityFactory.eINSTANCE.createProperty();
			property.setName(editableAttribute.getName());
			property.setValue(editableAttribute.getValue().toString());
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ReqCycleTraceabilityPackage.ELINK__ATTRIBUTES:
			return ((InternalEList<?>) getAttributes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ReqCycleTraceabilityPackage.ELINK__UPWARDS:
			return getUpwards();
		case ReqCycleTraceabilityPackage.ELINK__DOWNWARDS:
			return getDownwards();
		case ReqCycleTraceabilityPackage.ELINK__ATTRIBUTES:
			return getAttributes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ReqCycleTraceabilityPackage.ELINK__UPWARDS:
			return upwards != null && !upwards.isEmpty();
		case ReqCycleTraceabilityPackage.ELINK__DOWNWARDS:
			return downwards != null && !downwards.isEmpty();
		case ReqCycleTraceabilityPackage.ELINK__ATTRIBUTES:
			return attributes != null && !attributes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ELinkImpl
