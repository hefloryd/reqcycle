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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EcoreFactory;
import org.polarsys.reqcycle.repository.data.types.IEnumerationType;
import org.polarsys.reqcycle.repository.data.types.IEnumerator;

public class EnumerationTypeImpl extends ETypeImpl implements IEnumerationType, IAdaptable {

	protected Collection<IEnumerator> enumerators = new ArrayList<IEnumerator>();

	public EnumerationTypeImpl(String name) {
		super(createEEnum(name));
	}

	protected EnumerationTypeImpl(EEnum eEnum) {
		super(eEnum);
		for (EEnumLiteral eLiteral : eEnum.getELiterals()) {
			enumerators.add(new EnumeratorImpl(eLiteral));
		}
	}

	protected static EEnum createEEnum(String name) {
		EEnum eEnum = EcoreFactory.eINSTANCE.createEEnum();
		eEnum.setName(name);
		return eEnum;
	}

	@Override
	public void addEnumerator(IEnumerator enumerator) {
		EEnumLiteral eEnumLiteral = null;
		if (enumerator instanceof IAdaptable) {
			eEnumLiteral = (EEnumLiteral) ((IAdaptable) enumerator).getAdapter(EEnumLiteral.class);
		}
		if (eEnumLiteral != null) {
			getEType().getELiterals().add(eEnumLiteral);
			enumerators.add(enumerator);
		}
	}

	@Override
	public EEnum getEType() {
		return (EEnum) super.getEType();
	}

	@Override
	public Collection<IEnumerator> getEnumerators() {
		return enumerators;
	}

	public String getModelNsURI() {
		return getEType().getEPackage() != null ? getEType().getEPackage().getNsURI() : null;
	}
}
