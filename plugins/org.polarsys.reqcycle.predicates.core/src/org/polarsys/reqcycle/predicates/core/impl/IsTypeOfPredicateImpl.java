/**
 */
package org.polarsys.reqcycle.predicates.core.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.polarsys.reqcycle.predicates.core.PredicatesPackage;
import org.polarsys.reqcycle.predicates.core.api.IsTypeOfPredicate;

import com.google.common.collect.Sets;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Is Type Of Predicate</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.polarsys.reqcycle.predicates.core.impl.IsTypeOfPredicateImpl#getDisplayName <em>Display Name</em>}</li>
 * <li>{@link org.polarsys.reqcycle.predicates.core.impl.IsTypeOfPredicateImpl#isIsStrictTypeOf <em>Is Strict Type Of</em>}</li>
 * <li>{@link org.polarsys.reqcycle.predicates.core.impl.IsTypeOfPredicateImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IsTypeOfPredicateImpl extends MinimalEObjectImpl.Container implements IsTypeOfPredicate {
	/**
	 * The default value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPLAY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected String displayName = DISPLAY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsStrictTypeOf() <em>Is Strict Type Of</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsStrictTypeOf()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_STRICT_TYPE_OF_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsStrictTypeOf() <em>Is Strict Type Of</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsStrictTypeOf()
	 * @generated
	 * @ordered
	 */
	protected boolean isStrictTypeOf = IS_STRICT_TYPE_OF_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EClass type;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IsTypeOfPredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PredicatesPackage.Literals.IS_TYPE_OF_PREDICATE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setDisplayName(String newDisplayName) {
		String oldDisplayName = displayName;
		displayName = newDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PredicatesPackage.IS_TYPE_OF_PREDICATE__DISPLAY_NAME, oldDisplayName, displayName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject) type;
			type = (EClass) eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PredicatesPackage.IS_TYPE_OF_PREDICATE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setType(EClass newType) {
		EClass oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PredicatesPackage.IS_TYPE_OF_PREDICATE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isIsStrictTypeOf() {
		return isStrictTypeOf;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setIsStrictTypeOf(boolean newIsStrictTypeOf) {
		boolean oldIsStrictTypeOf = isStrictTypeOf;
		isStrictTypeOf = newIsStrictTypeOf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PredicatesPackage.IS_TYPE_OF_PREDICATE__IS_STRICT_TYPE_OF, oldIsStrictTypeOf, isStrictTypeOf));
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
			Set<EClass> eclasses = Sets.newHashSet(eobject.eClass());
			if (!isStrictTypeOf) {
				eclasses.addAll(eobject.eClass().getEAllSuperTypes());
			}
			return eclasses.contains(this.getType());
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case PredicatesPackage.IS_TYPE_OF_PREDICATE__DISPLAY_NAME:
			return getDisplayName();
		case PredicatesPackage.IS_TYPE_OF_PREDICATE__IS_STRICT_TYPE_OF:
			return isIsStrictTypeOf();
		case PredicatesPackage.IS_TYPE_OF_PREDICATE__TYPE:
			if (resolve)
				return getType();
			return basicGetType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case PredicatesPackage.IS_TYPE_OF_PREDICATE__DISPLAY_NAME:
			setDisplayName((String) newValue);
			return;
		case PredicatesPackage.IS_TYPE_OF_PREDICATE__IS_STRICT_TYPE_OF:
			setIsStrictTypeOf((Boolean) newValue);
			return;
		case PredicatesPackage.IS_TYPE_OF_PREDICATE__TYPE:
			setType((EClass) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case PredicatesPackage.IS_TYPE_OF_PREDICATE__DISPLAY_NAME:
			setDisplayName(DISPLAY_NAME_EDEFAULT);
			return;
		case PredicatesPackage.IS_TYPE_OF_PREDICATE__IS_STRICT_TYPE_OF:
			setIsStrictTypeOf(IS_STRICT_TYPE_OF_EDEFAULT);
			return;
		case PredicatesPackage.IS_TYPE_OF_PREDICATE__TYPE:
			setType((EClass) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case PredicatesPackage.IS_TYPE_OF_PREDICATE__DISPLAY_NAME:
			return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
		case PredicatesPackage.IS_TYPE_OF_PREDICATE__IS_STRICT_TYPE_OF:
			return isStrictTypeOf != IS_STRICT_TYPE_OF_EDEFAULT;
		case PredicatesPackage.IS_TYPE_OF_PREDICATE__TYPE:
			return type != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case PredicatesPackage.IS_TYPE_OF_PREDICATE___MATCH__OBJECT:
			return match(arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (displayName: ");
		result.append(displayName);
		result.append(", isStrictTypeOf: ");
		result.append(isStrictTypeOf);
		result.append(')');
		return result.toString();
	}

} // IsTypeOfPredicateImpl
