/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.repository.data.types.internal;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.polarsys.reqcycle.repository.data.types.IAttribute;
import org.polarsys.reqcycle.repository.data.types.IType;

/**
 * The Class AttributeImpl.
 */
public class AttributeImpl implements IAttribute, IAdaptable {

	/** The eAttribute. */
	protected EStructuralFeature feature;

	/** The type. */
	protected IType type;

	protected boolean isMany = false;

	/**
	 * Instantiates a new attribute.
	 * 
	 * @param name
	 *            the attribute name
	 * @param type
	 *            the attribute type
	 */
	public AttributeImpl(String name, IType type, boolean isMany) {
		this.type = type;
		this.isMany = isMany;
		EClassifier eType = null;
		if (type instanceof IAdaptable) {
			eType = (EClassifier) ((IAdaptable) type).getAdapter(EClassifier.class);
		}
		this.feature = createFeature(name, eType, isMany);
	}

	public AttributeImpl(String name, EClassifier eType, boolean isMany) {
		this.isMany = isMany;
		this.feature = createFeature(name, eType, isMany);
		this.type = ETypeImpl.createEType(eType);
	}

	protected static EStructuralFeature createFeature(String name, EClassifier eType, boolean isMany) {
		EStructuralFeature feature = null;
		if (eType instanceof EDataType) {
			feature = EcoreFactory.eINSTANCE.createEAttribute();
		} else if (eType instanceof EClass) {
			feature = EcoreFactory.eINSTANCE.createEReference();
		} else {
			throw new RuntimeException();
		}
		feature.setEType(eType);
		feature.setName(name);
		if (isMany) {
			feature.setUpperBound(-1);
		}
		return feature;
	}

	/**
	 * Instantiates a new attribute.
	 * 
	 * @param eAttribute
	 *            the EAttribute
	 */
	protected AttributeImpl(EStructuralFeature feature) {
		this.feature = feature;
		this.type = ETypeImpl.createEType(feature.getEType());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.polarsys.reqcycle.repository.data.types.IAttribute#getName()
	 */
	@Override
	public String getName() {
		return feature != null ? feature.getName() : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.polarsys.reqcycle.repository.data.types.IAttribute#isHidden()
	 */
	@Override
	public boolean isHidden() {
		if (feature.getEAnnotation("hidden") != null) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {
		if (EStructuralFeature.class.isAssignableFrom(adapter)) {
			return feature;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.polarsys.reqcycle.repository.data.types.IAttribute#getAttributeType()
	 */
	@Override
	public IType getType() {
		return type;
	}

}
