/**
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *   Malick Wade (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.inittypes.inittypes.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.polarsys.reqcycle.inittypes.inittypes.FileType;
import org.polarsys.reqcycle.inittypes.inittypes.InittypesPackage;
import org.polarsys.reqcycle.inittypes.inittypes.Type;
import org.polarsys.reqcycle.inittypes.inittypes.TypeModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.inittypes.inittypes.impl.TypeModelImpl#getFileTypes <em>File Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeModelImpl extends MinimalEObjectImpl.Container implements TypeModel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2014 AtoS\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n  Malick Wade (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * The cached value of the '{@link #getFileTypes() <em>File Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<FileType> fileTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InittypesPackage.Literals.TYPE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FileType> getFileTypes() {
		if (fileTypes == null) {
			fileTypes = new EObjectContainmentEList<FileType>(FileType.class, this, InittypesPackage.TYPE_MODEL__FILE_TYPES);
		}
		return fileTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getDocumentType(String name) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getTypes(String name) {
		EList<Type> listType = null ;
		EList<FileType> fileTypes = getFileTypes();
		
		for(FileType ft : fileTypes){
		if (ft.getName().equals(name)){
			listType = ft.getTypes();
		}
			
		}
		
		return listType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InittypesPackage.TYPE_MODEL__FILE_TYPES:
				return ((InternalEList<?>)getFileTypes()).basicRemove(otherEnd, msgs);
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
			case InittypesPackage.TYPE_MODEL__FILE_TYPES:
				return getFileTypes();
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
			case InittypesPackage.TYPE_MODEL__FILE_TYPES:
				getFileTypes().clear();
				getFileTypes().addAll((Collection<? extends FileType>)newValue);
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
			case InittypesPackage.TYPE_MODEL__FILE_TYPES:
				getFileTypes().clear();
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
			case InittypesPackage.TYPE_MODEL__FILE_TYPES:
				return fileTypes != null && !fileTypes.isEmpty();
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
			case InittypesPackage.TYPE_MODEL___GET_DOCUMENT_TYPE__STRING:
				return getDocumentType((String)arguments.get(0));
			case InittypesPackage.TYPE_MODEL___GET_TYPES__STRING:
				return getTypes((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //TypeModelImpl
