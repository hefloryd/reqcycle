/**
 */
package org.polarsys.reqcycle.predicates.core.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.polarsys.reqcycle.predicates.core.PredicatesPackage;

import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.predicates.core.api.IPredicateContainer;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>IPredicate Container</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.predicates.core.impl.IPredicateContainerImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.predicates.core.impl.IPredicateContainerImpl#getResultPredicate <em>Result Predicate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class IPredicateContainerImpl extends MinimalEObjectImpl.Container implements IPredicateContainer {
	/**
	 * The default value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPLAY_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected String displayName = DISPLAY_NAME_EDEFAULT;
	/**
	 * The cached value of the '{@link #getResultPredicate() <em>Result Predicate</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getResultPredicate()
	 * @generated
	 * @ordered
	 */
	protected IPredicate resultPredicate;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected IPredicateContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PredicatesPackage.Literals.IPREDICATE_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayName(String newDisplayName) {
		String oldDisplayName = displayName;
		displayName = newDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PredicatesPackage.IPREDICATE_CONTAINER__DISPLAY_NAME, oldDisplayName, displayName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IPredicate getResultPredicate() {
		return resultPredicate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResultPredicate(IPredicate newResultPredicate, NotificationChain msgs) {
		IPredicate oldResultPredicate = resultPredicate;
		resultPredicate = newResultPredicate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PredicatesPackage.IPREDICATE_CONTAINER__RESULT_PREDICATE, oldResultPredicate, newResultPredicate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultPredicate(IPredicate newResultPredicate) {
		if (newResultPredicate != resultPredicate) {
			NotificationChain msgs = null;
			if (resultPredicate != null)
				msgs = ((InternalEObject)resultPredicate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PredicatesPackage.IPREDICATE_CONTAINER__RESULT_PREDICATE, null, msgs);
			if (newResultPredicate != null)
				msgs = ((InternalEObject)newResultPredicate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PredicatesPackage.IPREDICATE_CONTAINER__RESULT_PREDICATE, null, msgs);
			msgs = basicSetResultPredicate(newResultPredicate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PredicatesPackage.IPREDICATE_CONTAINER__RESULT_PREDICATE, newResultPredicate, newResultPredicate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean match(Object input) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PredicatesPackage.IPREDICATE_CONTAINER__RESULT_PREDICATE:
				return basicSetResultPredicate(null, msgs);
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
			case PredicatesPackage.IPREDICATE_CONTAINER__DISPLAY_NAME:
				return getDisplayName();
			case PredicatesPackage.IPREDICATE_CONTAINER__RESULT_PREDICATE:
				return getResultPredicate();
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
			case PredicatesPackage.IPREDICATE_CONTAINER__DISPLAY_NAME:
				setDisplayName((String)newValue);
				return;
			case PredicatesPackage.IPREDICATE_CONTAINER__RESULT_PREDICATE:
				setResultPredicate((IPredicate)newValue);
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
			case PredicatesPackage.IPREDICATE_CONTAINER__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
				return;
			case PredicatesPackage.IPREDICATE_CONTAINER__RESULT_PREDICATE:
				setResultPredicate((IPredicate)null);
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
			case PredicatesPackage.IPREDICATE_CONTAINER__DISPLAY_NAME:
				return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
			case PredicatesPackage.IPREDICATE_CONTAINER__RESULT_PREDICATE:
				return resultPredicate != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PredicatesPackage.IPREDICATE_CONTAINER___MATCH__OBJECT:
				return match(arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (displayName: ");
		result.append(displayName);
		result.append(')');
		return result.toString();
	}

} // IPredicateContainerImpl
