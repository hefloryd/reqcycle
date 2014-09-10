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

import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.polarsys.reqcycle.repository.data.types.IType;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * The Class AttributeTypeImpl.
 */
public class ETypeImpl implements IType, IAdaptable {

	/** The attribute name. */
	private String name = null;

	/** The eDataType. */
	private EClassifier eType;

	/**
	 * Instantiates a new attribute type.
	 * 
	 * @param name
	 *            the attribute name
	 * @param eDataType
	 *            the EDataType
	 */
	protected ETypeImpl(EClassifier eType) {
		this.eType = eType;
	}

	/**
	 * Instantiates a new attribute type.
	 * 
	 * @param name
	 *            the attribute name
	 * @param eDataType
	 *            the EDataType
	 */
	protected ETypeImpl(String name, EClassifier eType) {
		this.name = name;
		this.eType = eType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.polarsys.reqcycle.repository.data.types.IAttributeType#getName()
	 */
	@Override
	public String getName() {
		if (name == null) {
			return getEType().getName();
		}
		return name;
	}

	public EClassifier getEType() {
		return eType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {
		if (EClassifier.class.isAssignableFrom(adapter)) {
			return getEType();
		}
		return null;
	}

	public static ETypeImpl createEType(EClassifier eType) {
		ETypeImpl basicType = eBasicTypesMap.get(eType);
		if (basicType != null) {
			return basicType;
		}
		return new ETypeImpl(eType);
	}

	public static final ETypeImpl BYTE = new ETypeImpl(EcorePackage.Literals.EBYTE.getName().replaceFirst("E", ""), EcorePackage.Literals.EBYTE);

	public static final ETypeImpl STRING = new ETypeImpl(EcorePackage.Literals.ESTRING.getName().replaceFirst("E", ""), EcorePackage.Literals.ESTRING);

	public static final ETypeImpl INT = new ETypeImpl(EcorePackage.Literals.EINT.getName().replaceFirst("E", ""), EcorePackage.Literals.EINT);

	public static final ETypeImpl LONG = new ETypeImpl(EcorePackage.Literals.ELONG.getName().replaceFirst("E", ""), EcorePackage.Literals.ELONG);

	public static final ETypeImpl BIG_DECIMAL = new ETypeImpl(EcorePackage.Literals.EBIG_DECIMAL.getName().replaceFirst("E", ""), EcorePackage.Literals.EBIG_DECIMAL);

	public static final ETypeImpl CHAR = new ETypeImpl(EcorePackage.Literals.ECHAR.getName().replaceFirst("E", ""), EcorePackage.Literals.ECHAR);

	public static final ETypeImpl FLOAT = new ETypeImpl(EcorePackage.Literals.EFLOAT.getName().replaceFirst("E", ""), EcorePackage.Literals.EFLOAT);

	public static final ETypeImpl DOUBLE = new ETypeImpl(EcorePackage.Literals.EDOUBLE.getName().replaceFirst("E", ""), EcorePackage.Literals.EDOUBLE);

	public static final ETypeImpl SHORT = new ETypeImpl(EcorePackage.Literals.ESHORT.getName().replaceFirst("E", ""), EcorePackage.Literals.ESHORT);

	public static final ETypeImpl BIG_INTEGER = new ETypeImpl(EcorePackage.Literals.EBIG_INTEGER.getName().replaceFirst("E", ""), EcorePackage.Literals.EBIG_INTEGER);

	public static final ETypeImpl BOOLEAN = new ETypeImpl(EcorePackage.Literals.EBOOLEAN.getName().replaceFirst("E", ""), EcorePackage.Literals.EBOOLEAN);

	public static final Set<ETypeImpl> eBasicTypes = Sets.newHashSet(BYTE, STRING, INT, LONG, BIG_DECIMAL, CHAR, FLOAT, DOUBLE, SHORT, BIG_INTEGER, BOOLEAN);

	public static final Map<EClassifier, ETypeImpl> eBasicTypesMap = Maps.uniqueIndex(eBasicTypes, new Function<ETypeImpl, EClassifier>() {

		@Override
		public EClassifier apply(ETypeImpl t) {
			return t.getEType();
		}
	});
}
