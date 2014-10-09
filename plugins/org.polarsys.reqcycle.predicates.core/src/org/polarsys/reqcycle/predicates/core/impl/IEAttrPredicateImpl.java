/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Papa Issa Diakhate (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
/**
 */
package org.polarsys.reqcycle.predicates.core.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polarsys.reqcycle.predicates.core.PredicatesPackage;
import org.polarsys.reqcycle.predicates.core.api.IEAttrPredicate;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>IE Attr Predicate</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.predicates.core.impl.IEAttrPredicateImpl#getTypedElement <em>Typed Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IEAttrPredicateImpl extends IPredicateContainerImpl implements IEAttrPredicate {

	/**
	 * The cached value of the '{@link #getTypedElement() <em>Typed Element</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTypedElement()
	 * @generated
	 * @ordered
	 */
	protected EAttribute typedElement;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected IEAttrPredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PredicatesPackage.Literals.IE_ATTR_PREDICATE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTypedElement() {
		if (typedElement != null && ((EObject)typedElement).eIsProxy()) {
			InternalEObject oldTypedElement = (InternalEObject)typedElement;
			typedElement = (EAttribute)eResolveProxy(oldTypedElement);
			if (typedElement != oldTypedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PredicatesPackage.IE_ATTR_PREDICATE__TYPED_ELEMENT, oldTypedElement, typedElement));
			}
		}
		return typedElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetTypedElement() {
		return typedElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTypedElement(EAttribute newTypedElement) {
		EAttribute oldTypedElement = typedElement;
		typedElement = newTypedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PredicatesPackage.IE_ATTR_PREDICATE__TYPED_ELEMENT, oldTypedElement, typedElement));
	}

	/**
	 * @param eObj
	 * @return The input value from the specified object.
	 */
	protected Object getInputValueFromEObject(final Object eObj) {
		assertIsEObject(eObj);
		EAttribute aTypedElement = getTypedElement();
		if (aTypedElement == null) {
			return null;
		}
		Object value = ((EObject) eObj).eGet(get(aTypedElement, (EObject) eObj));
		return value;
	}

	private EStructuralFeature get(EStructuralFeature typedElement2, EObject eObj) {
		for (EStructuralFeature f : eObj.eClass().getEAllStructuralFeatures()) {
			if (EcoreUtil.equals(f, typedElement2)) {
				return f;
			}
		}
		return typedElement2;
	}

	protected void assertIsEObject(final Object input) {
		if (!(input instanceof EObject)) {
			throw new IllegalArgumentException("The input must be of type 'EObject'.");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PredicatesPackage.IE_ATTR_PREDICATE__TYPED_ELEMENT:
				if (resolve) return getTypedElement();
				return basicGetTypedElement();
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
			case PredicatesPackage.IE_ATTR_PREDICATE__TYPED_ELEMENT:
				setTypedElement((EAttribute)newValue);
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
			case PredicatesPackage.IE_ATTR_PREDICATE__TYPED_ELEMENT:
				setTypedElement((EAttribute)null);
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
			case PredicatesPackage.IE_ATTR_PREDICATE__TYPED_ELEMENT:
				return typedElement != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	@Override
	public boolean match(Object input) {
		if (input instanceof EObject) {
			EObject eobject = (EObject) input;
			EAttribute a = getTypedElement();
			if (a != null && getResultPredicate() != null) {
				Object result = eobject.eGet(a);
				return getResultPredicate().match(result);
			}
		}
		return false;
	}

} // IEAttrPredicateImpl
