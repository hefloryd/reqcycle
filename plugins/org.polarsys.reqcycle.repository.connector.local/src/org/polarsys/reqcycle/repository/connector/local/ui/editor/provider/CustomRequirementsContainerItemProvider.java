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
package org.polarsys.reqcycle.repository.connector.local.ui.editor.provider;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSourceConfPackage;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataFactory;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataPackage;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementsContainer;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.provider.RequirementsContainerItemProvider;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.repository.data.types.IRequirementType;
import org.polarsys.reqcycle.repository.data.types.IType;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Lists;

public class CustomRequirementsContainerItemProvider extends RequirementsContainerItemProvider {

	@Inject
	IDataModelManager dataManager;

	public CustomRequirementsContainerItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		ZigguratInject.inject(this);
	}

	/*
	 * ECrossReferenceAdapter c = ECrossReferenceAdapter.getCrossReferenceAdapter(this);
	 * 
	 * if(c == null) { c = new ECrossReferenceAdapter(); Resource r = this.eResource(); if(r != null) { ResourceSet rs = r.getResourceSet(); if(rs != null) { c.setTarget(rs); } else { c.setTarget(r); } } else { c.setTarget(this); } }
	 * 
	 * 
	 * EList<EObject> res = new BasicEList<EObject>(); Collection<Setting> settings = c.getInverseReferences(this, true); for(Setting s : settings) { if(oppositeRef.equals(s.getEStructuralFeature())) { res.add(s.getEObject()); } } return res;
	 */

	@Override
	public String getText(Object object) {
		if (object instanceof RequirementsContainer) {
			RequirementsContainer reqContainer = (RequirementsContainer) object;
			ECrossReferenceAdapter c = ECrossReferenceAdapter.getCrossReferenceAdapter((RequirementsContainer) object);
			if (c == null && reqContainer.eResource() != null) {
				c = new ECrossReferenceAdapter();
				reqContainer.eResource().getResourceSet().eAdapters().add(c);
			}
			if (c != null) {
				Collection<Setting> settings = c.getInverseReferences((RequirementsContainer) object, true);
				for (Setting s : settings) {
					if (RequirementSourceConfPackage.Literals.REQUIREMENT_SOURCE__CONTENTS.equals(s.getEStructuralFeature())) {
						return ((RequirementSource) s.getEObject()).getName();
					}
				}
			}
		}
		return super.getText(object);
	}

	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		// FIXME : Use element Data Model to get possible children
		// Gets Dynamic Data Model possible children
		Collection<IDataModel> dataModels = dataManager.getCurrentDataModels();
		List<IType> types = Lists.newArrayList();
		for (IDataModel dataModel : dataModels) {
			types.addAll(dataModel.getTypes());
		}
		for (IType type : types) {
			if (type instanceof IRequirementType) {
				newChildDescriptors.add(createChildParameter(RequirementSourceDataPackage.Literals.REQUIREMENTS_CONTAINER__REQUIREMENTS, ((IRequirementType) type).createInstance()));
			}
		}
		newChildDescriptors.add(createChildParameter(RequirementSourceDataPackage.Literals.REQUIREMENTS_CONTAINER__REQUIREMENTS, RequirementSourceDataFactory.eINSTANCE.createSection()));
	}

}
