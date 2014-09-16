/**
 */
package org.polarsys.reqcycle.predicates.core.impl;

import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polarsys.reqcycle.operations.IOperation.Result;
import org.polarsys.reqcycle.operations.IReqCycleOperationManager;
import org.polarsys.reqcycle.operations.ReqCycleOperation;
import org.polarsys.reqcycle.predicates.core.IPredicateEvaluator;
import org.polarsys.reqcycle.predicates.core.PredicatesPackage;
import org.polarsys.reqcycle.predicates.core.api.BooleanParameter;
import org.polarsys.reqcycle.predicates.core.api.EObjectParameter;
import org.polarsys.reqcycle.predicates.core.api.IntParameter;
import org.polarsys.reqcycle.predicates.core.api.OperationPredicate;
import org.polarsys.reqcycle.predicates.core.api.Parameter;
import org.polarsys.reqcycle.predicates.core.api.StringParameter;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Operation Predicate</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.polarsys.reqcycle.predicates.core.impl.OperationPredicateImpl#getOperationName <em>Operation Name</em>}</li>
 * <li>
 * {@link org.polarsys.reqcycle.predicates.core.impl.OperationPredicateImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationPredicateImpl extends IPredicateContainerImpl implements OperationPredicate {
	@Inject
	IReqCycleOperationManager reqCycleOperationlManager;

	@Inject
	IPredicateEvaluator predicateEvaluator;

	/**
	 * The default value of the '{@link #getOperationName() <em>Operation Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOperationName()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperationName() <em>Operation Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOperationName()
	 * @generated
	 * @ordered
	 */
	protected String operationName = OPERATION_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected OperationPredicateImpl() {
		super();
		ZigguratInject.inject(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PredicatesPackage.Literals.OPERATION_PREDICATE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated not
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
	public String getOperationName() {
		return operationName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setOperationName(String newOperationName) {
		String oldOperationName = operationName;
		operationName = newOperationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PredicatesPackage.OPERATION_PREDICATE__OPERATION_NAME, oldOperationName, operationName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, PredicatesPackage.OPERATION_PREDICATE__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean match(Object input) {
		if (this.operationName != null) {
			Class<?>[] listTypes = new Class<?>[this.getParameters().size() + 1];
			Object[] listValues = new Object[this.getParameters().size() + 1];
			listValues[0] = input;
			listTypes[0] = input.getClass();

			for (int i = 0; i < this.getParameters().size(); i++) {
				Parameter p = this.getParameters().get(i);
				if (p instanceof StringParameter) {
					listTypes[i + 1] = String.class;
				} else if (p instanceof IntParameter) {
					listTypes[i + 1] = Integer.class;
				} else if (p instanceof BooleanParameter) {
					listTypes[i + 1] = Boolean.class;
				} else if (p instanceof EObjectParameter) {
					listTypes[i + 1] = EObject.class;
				} else {
					return false;
				}
				listValues[i + 1] = p.getObjectValue();
			}

			ReqCycleOperation op = reqCycleOperationlManager.getOperation(this.operationName, listTypes);
			if (op != null) {
				Object obj = op.execute(listValues);
				if (obj instanceof Result<?>) {
					Result<?> result = (Result<?>) obj;
					if (result.getResultType().isInstance(Boolean.class)) {
						return (Boolean) result.getResult();
					} else {
						return predicateEvaluator.match(this.getResultPredicate(), input);
					}
				} else if (obj instanceof Boolean) {
					return (Boolean) obj;
				}
			}
		}

		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case PredicatesPackage.OPERATION_PREDICATE__PARAMETERS:
			return ((InternalEList<?>) getParameters()).basicRemove(otherEnd, msgs);
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
		case PredicatesPackage.OPERATION_PREDICATE__OPERATION_NAME:
			return getOperationName();
		case PredicatesPackage.OPERATION_PREDICATE__PARAMETERS:
			return getParameters();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case PredicatesPackage.OPERATION_PREDICATE__OPERATION_NAME:
			setOperationName((String) newValue);
			return;
		case PredicatesPackage.OPERATION_PREDICATE__PARAMETERS:
			getParameters().clear();
			getParameters().addAll((Collection<? extends Parameter>) newValue);
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
		case PredicatesPackage.OPERATION_PREDICATE__OPERATION_NAME:
			setOperationName(OPERATION_NAME_EDEFAULT);
			return;
		case PredicatesPackage.OPERATION_PREDICATE__PARAMETERS:
			getParameters().clear();
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
		case PredicatesPackage.OPERATION_PREDICATE__OPERATION_NAME:
			return OPERATION_NAME_EDEFAULT == null ? operationName != null : !OPERATION_NAME_EDEFAULT.equals(operationName);
		case PredicatesPackage.OPERATION_PREDICATE__PARAMETERS:
			return parameters != null && !parameters.isEmpty();
		}
		return super.eIsSet(featureID);
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
		result.append(" (operationName: ");
		result.append(operationName);
		result.append(')');
		return result.toString();
	}

} // OperationPredicateImpl
