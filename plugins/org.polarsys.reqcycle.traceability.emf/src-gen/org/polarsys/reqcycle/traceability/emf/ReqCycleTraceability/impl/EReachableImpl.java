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

import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;

import javax.inject.Inject;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource.Internal;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.polarsys.reqcycle.traceability.emf.Activator;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ELink;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.IRequestManager;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityFactory;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityPackage;
import org.polarsys.reqcycle.traceability.engine.ITraceabilityEngine;
import org.polarsys.reqcycle.traceability.exceptions.EngineException;
import org.polarsys.reqcycle.traceability.model.Link;
import org.polarsys.reqcycle.traceability.model.Pair;
import org.polarsys.reqcycle.types.IType;
import org.polarsys.reqcycle.types.ITypesManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.model.IReachableHandler;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.model.ReachableObject;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>EReachable</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.EReachableImpl#getDownwards
 * <em>Downwards</em>}</li>
 * <li>
 * {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.EReachableImpl#getTypes
 * <em>Types</em>}</li>
 * <li>
 * {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl.EReachableImpl#getUpwards
 * <em>Upwards</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EReachableImpl extends ElementImpl implements EReachable {

	@Inject
	ITraceabilityEngine engine;

	@Inject
	IRequestManager requestManager;

	private ITypesManager typeManager = ZigguratInject.make(ITypesManager.class);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2013 AtoS\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n Abdellah EL AYADI (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * The cached value of the '{@link #getDownwards() <em>Downwards</em>}'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDownwards()
	 * @generated
	 * @ordered
	 */
	protected EList<ELink> downwards;

	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' attribute
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> types;

	/**
	 * The cached value of the '{@link #getUpwards() <em>Upwards</em>}'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUpwards()
	 * @generated
	 * @ordered
	 */
	protected EList<ELink> upwards;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EReachableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReqCycleTraceabilityPackage.Literals.EREACHABLE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<ELink> getDownwards() {
		if (downwards == null) {
			downwards = new EObjectResolvingEList<ELink>(ELink.class, this, ReqCycleTraceabilityPackage.EREACHABLE__DOWNWARDS);

			try {
				initDownwards();
			} catch (EngineException e) {
				Activator.log(IStatus.ERROR, "Error while retrieving downwards", e);
			}

		}
		return downwards;
	}

	protected void initDownwards() throws EngineException {
		if (downwards == null) {
			downwards = new EObjectResolvingEList<ELink>(ELink.class, this, ReqCycleTraceabilityPackage.EREACHABLE__DOWNWARDS);
		}
		downwards.clear();
		Iterator<Pair<Link, Reachable>> traceability = engine.getTraceability(requestManager.getDownwardRequest(this));
		while (traceability.hasNext()) {
			Pair<Link, Reachable> pair = (Pair<Link, Reachable>) traceability.next();

			Link link = pair.getFirst();
			Reachable reachable = pair.getSecond();

			URI reachableURI = reachable.getURI();
			EReachableImpl target = (EReachableImpl) this.eResource().getEObject(reachableURI.toString());

			ELink eLink = target.getUpward(link.getId().getURI());

			if (eLink == null) {
				eLink = ReqCycleTraceabilityFactory.eINSTANCE.createELink();
				eLink.setLabel(link.getLabel());
				eLink.setURI(link.getId().getURI().toString());
				eLink.getUpwards().add(this);
				eLink.getDownwards().add((EReachable) target);

				if (eLink instanceof InternalEObject && eResource() instanceof Internal) {
					((InternalEObject) eLink).eSetResource((Internal) eResource(), null);
				}
			}
			downwards.add(eLink);
		}
	}

	protected ELink getUpward(URI uri) {
		if (upwards != null && uri != null) {
			for (ELink eLink : upwards) {
				if (uri.toString().equals(eLink.getURI())) {
					return eLink;
				}
			}
		}
		return null;
	}

	protected ELink getDownward(URI uri) {
		if (downwards != null && uri != null) {
			for (ELink eLink : downwards) {
				if (uri.equals(eLink.getURI())) {
					return eLink;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<String> getTypes() {
		if (types == null) {
			initTypes();
		}
		return types;
	}

	protected void initTypes() {
		if (types == null) {
			types = new EDataTypeUniqueEList<String>(String.class, this, ReqCycleTraceabilityPackage.EREACHABLE__TYPES);
		}
		types.clear();

		Iterable<IType> reachableTypes = typeManager.getAllApplicableTypes((Reachable) getAdapter(Reachable.class));

		for (IType iType : reachableTypes) {
			types.add(iType.getLabel());
		}

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<ELink> getUpwards() {
		if (upwards == null) {
			upwards = new EObjectResolvingEList<ELink>(ELink.class, this, ReqCycleTraceabilityPackage.EREACHABLE__UPWARDS);
			try {
				initUpwards();
			} catch (EngineException e) {
				Activator.log(IStatus.ERROR, "Error while retrieving upwards", e);
			}
		}
		return upwards;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EObject getEObject() {
		Reachable r = (Reachable) getAdapter(Reachable.class);
		try {
			IReachableHandler handler = reachableManager.getHandlerFromReachable(r);
			ReachableObject reachableObject = handler.getFromReachable(r);
			return (EObject) reachableObject.getAdapter(EObject.class);
		} catch (IReachableHandlerException e) {
			Activator.log(IStatus.ERROR, "Can't element EObject", e);
		}
		return null;
	}

	protected void initUpwards() throws EngineException {
		if (upwards == null) {
			upwards = new EObjectResolvingEList<ELink>(ELink.class, this, ReqCycleTraceabilityPackage.EREACHABLE__UPWARDS);
		}
		upwards.clear();
		engine.getTraceability(requestManager.getUpwardRequest(this));
		Iterator<Pair<Link, Reachable>> traceability = engine.getTraceability(requestManager.getUpwardRequest(this));

		while (traceability.hasNext()) {
			Pair<Link, Reachable> pair = (Pair<Link, Reachable>) traceability.next();

			Link link = pair.getFirst();
			Reachable reachable = pair.getSecond();

			URI reachableURI = reachable.getURI();
			EReachableImpl target = (EReachableImpl) this.eResource().getEObject(reachableURI.toString());

			ELink eLink = target.getDownward(link.getId().getURI());

			if (eLink == null) {
				eLink = ReqCycleTraceabilityFactory.eINSTANCE.createELink();
				eLink.setURI(link.getId().toString());
				eLink.setLabel(link.getLabel());
				eLink.getDownwards().add(this);
				eLink.getUpwards().add((EReachable) target);

				if (eLink instanceof InternalEObject && eResource() instanceof Internal) {
					((InternalEObject) eLink).eSetResource((Internal) eResource(), null);
				}
			}

			upwards.add(eLink);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ReqCycleTraceabilityPackage.EREACHABLE__DOWNWARDS:
			return getDownwards();
		case ReqCycleTraceabilityPackage.EREACHABLE__TYPES:
			return getTypes();
		case ReqCycleTraceabilityPackage.EREACHABLE__UPWARDS:
			return getUpwards();
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
		case ReqCycleTraceabilityPackage.EREACHABLE__DOWNWARDS:
			return downwards != null && !downwards.isEmpty();
		case ReqCycleTraceabilityPackage.EREACHABLE__TYPES:
			return types != null && !types.isEmpty();
		case ReqCycleTraceabilityPackage.EREACHABLE__UPWARDS:
			return upwards != null && !upwards.isEmpty();
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
		case ReqCycleTraceabilityPackage.EREACHABLE___GET_EOBJECT:
			return getEObject();
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
		result.append(" (types: ");
		result.append(types);
		result.append(')');
		return result.toString();
	}

	@Override
	public Object getAdapter(Class type) {
		if (type.equals(Reachable.class)) {
			String uri = getURI();
			Reachable sourceR;
			try {
				sourceR = creator.getReachable(new URI(uri));
				return sourceR;
			} catch (URISyntaxException e) {
				Activator.log(IStatus.ERROR, "Can't Adapt element", e);
			}
		}
		return null;
	}

} // EReachableImpl
