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

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
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
import org.polarsys.reqcycle.styling.model.ITopic;
import org.polarsys.reqcycle.styling.model.Styling.BooleanParameter;
import org.polarsys.reqcycle.styling.model.Styling.EObjectParameter;
import org.polarsys.reqcycle.styling.model.Styling.IntParameter;
import org.polarsys.reqcycle.styling.model.Styling.OperationPattern;
import org.polarsys.reqcycle.styling.model.Styling.Parameter;
import org.polarsys.reqcycle.styling.model.Styling.StringParameter;
import org.polarsys.reqcycle.styling.model.Styling.StylingPackage;
import org.polarsys.reqcycle.uri.IReachableListener;
import org.polarsys.reqcycle.uri.IReachableListenerManager;
import org.polarsys.reqcycle.uri.functions.URIFunctions;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.base.Function;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Operation Pattern</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.polarsys.reqcycle.styling.model.Styling.impl.OperationPatternImpl#getOperation
 * <em>Operation</em>}</li>
 * <li>
 * {@link org.polarsys.reqcycle.styling.model.Styling.impl.OperationPatternImpl#getParameters
 * <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated not
 */
public class OperationPatternImpl extends PatternImpl implements
		OperationPattern, IReachableListener {

	@Inject
	IReqCycleOperationManager reqCycleOperationlManager;
	@Inject
	IReachableListenerManager manager;
	
	Multimap<Reachable, Reachable> maps = HashMultimap.create();

	@Inject
	IEventBroker broker;
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2014 AtoS\r\n    All rights reserved. This program and the accompanying materials\r\n    are made available under the terms of the Eclipse Public License v1.0\r\n    which accompanies this distribution, and is available at\r\n    http://www.eclipse.org/legal/epl-v10.html *\r\n    Contributors:\r\n      Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * The default value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected String operation = OPERATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationPatternImpl() {
		super();
		ZigguratInject.inject(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StylingPackage.Literals.OPERATION_PATTERN;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperation(String newOperation) {
		String oldOperation = operation;
		operation = newOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StylingPackage.OPERATION_PATTERN__OPERATION, oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, StylingPackage.OPERATION_PATTERN__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StylingPackage.OPERATION_PATTERN__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case StylingPackage.OPERATION_PATTERN__OPERATION:
				return getOperation();
			case StylingPackage.OPERATION_PATTERN__PARAMETERS:
				return getParameters();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StylingPackage.OPERATION_PATTERN__OPERATION:
				setOperation((String)newValue);
				return;
			case StylingPackage.OPERATION_PATTERN__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
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
			case StylingPackage.OPERATION_PATTERN__OPERATION:
				setOperation(OPERATION_EDEFAULT);
				return;
			case StylingPackage.OPERATION_PATTERN__PARAMETERS:
				getParameters().clear();
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
			case StylingPackage.OPERATION_PATTERN__OPERATION:
				return OPERATION_EDEFAULT == null ? operation != null : !OPERATION_EDEFAULT.equals(operation);
			case StylingPackage.OPERATION_PATTERN__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
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
		result.append(" (operation: ");
		result.append(operation);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getPatternValue(Object object) {
		EList<Parameter> parameters = this.getParameters();
		Class<?>[] listTypes = new Class<?>[parameters.size() + 1];
		Object[] listValues = new Object[parameters.size() + 1];
		listValues[0] = object;
		listTypes[0] = object.getClass();

		for (int i = 0; i < parameters.size(); i++) {
			Parameter p = parameters.get(i);
			if (p instanceof StringParameter) {
				listTypes[i + 1] = String.class;
			} else if (p instanceof IntParameter) {
				listTypes[i + 1] = Integer.class;
			} else if (p instanceof BooleanParameter) {
				listTypes[i + 1] = Boolean.class;
			} else if (p instanceof EObjectParameter) {
				listTypes[i + 1] = EObject.class;
			} else {
				return this.getPattern();
			}
			listValues[i + 1] = p.getObjectValue();
		}

		ReqCycleOperation op = reqCycleOperationlManager.getOperation(
				this.getOperation(), listTypes);
		if (op != null) {
			String resultString = "";
			Object obj = op.execute(listValues);
			List<Object> toListen = Lists.newArrayList();
			
			// register given parameter
			toListen.add(object);
			if (obj instanceof Result<?>) {
				Result<?> result = (Result<?>) obj;
				if (result.getResult() != null) {
					if (result.getObjectsToListen() != null){
						toListen.addAll(result.getObjectsToListen());
					}
					resultString = result.getResult().toString();
				}
			}
			else {
				if (obj != null){
					resultString  = obj.toString();
				}
			}
			register(object,toListen);
			return resultString;
		}

		return this.getPattern();
	}

	private void register(Object from, Collection<Object> iterable) {
		Reachable fromR = getReachable(from);
		if (iterable != null) {
			for (Object obj : iterable) {
				Reachable reachableObject = getReachable(obj);
				manager.addReachableListener(reachableObject,
						this);
				maps.put(reachableObject,fromR);
			}
		}
	}

	private Reachable getReachable(Object obj) {
		Reachable reachableObject = null;
		if (obj instanceof Reachable) {
			reachableObject = (Reachable) obj;

		} else {
			Function<Object, Reachable> obj2RO = URIFunctions
					.newObject2ReachableFunction();
			reachableObject = obj2RO.apply(obj);
		}
		return reachableObject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	@Override
	public String getPattern() {
		String pattern = "%" + this.getOperation() + "%";
		return pattern;
	}


	@Override
	public void hasChanged(Reachable[] reachables) {
		Collection<Reachable> message = Sets.newHashSet();
		message.addAll(Arrays.asList(reachables));
		for (Reachable r : reachables){
			message.addAll(maps.get(r));
		}
		broker.post(ITopic.LISTENER , message);
	}

} // OperationPatternImpl
