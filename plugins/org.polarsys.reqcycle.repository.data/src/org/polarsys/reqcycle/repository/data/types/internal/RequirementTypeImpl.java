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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataPackage;
import org.polarsys.reqcycle.repository.data.types.IAttribute;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.repository.data.types.IRequirementType;

public class RequirementTypeImpl extends ETypeImpl implements IRequirementType, IAdaptable {

	protected Collection<IAttribute> attributes = new ArrayList<IAttribute>();

	private IDataModel dataModel;

	public RequirementTypeImpl(String name, IDataModel dataModel) {
		this(createReqEClass(name), dataModel);
	}

	protected static EClass createReqEClass(String name) {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(name);
		eClass.getESuperTypes().add(RequirementSourceDataPackage.Literals.REQUIREMENT);
		return eClass;
	}

	public RequirementTypeImpl(EClass eClass, IDataModel dataModel) {
		super(eClass);
		if (!eClass.getESuperTypes().contains(RequirementSourceDataPackage.Literals.REQUIREMENT)) {
			throw new RuntimeException();
		}
		for (EStructuralFeature feature : getEType().getEAllStructuralFeatures()) {
			attributes.add(new AttributeImpl(feature));
		}
		this.dataModel = dataModel;
	}

	@Override
	public EClass getEType() {
		return (EClass) super.getEType();
	}

	@Override
	public void addAttribute(IAttribute att) {
		EStructuralFeature feature = null;
		if (att instanceof IAdaptable) {
			feature = (EStructuralFeature) ((IAdaptable) att).getAdapter(EStructuralFeature.class);
		}
		if (feature != null) {
			attributes.add(att);
			getEType().getEStructuralFeatures().add(feature);
		}
	}

	@Override
	public void removeAttribute(IAttribute att) {
		attributes.remove(att);
		EStructuralFeature feature = null;
		if (att instanceof IAdaptable) {
			feature = (EStructuralFeature) ((IAdaptable) att).getAdapter(EStructuralFeature.class);
		}
		if (feature != null) {
			getEType().getEStructuralFeatures().remove(feature);
			if (dataModel instanceof DataModelImpl) {
				((DataModelImpl) dataModel).needsNewVersionOnSave = true;
			}
		}
	}

	@Override
	public Collection<IAttribute> getAttributes() {
		return attributes;
	}

	@Override
	public Requirement createInstance() {
		EPackage ePackage = getEType().getEPackage();
		if (ePackage != null) {
			return (Requirement) ePackage.getEFactoryInstance().create(getEType());
		}
		return null;
	}

	@Override
	public IDataModel getDataModel() {
		return dataModel;
	}

}
