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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataFactory;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataPackage;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Section;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.provider.SectionItemProvider;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.repository.data.types.IRequirementType;
import org.polarsys.reqcycle.repository.data.types.IType;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Lists;

/**
 * The Class CustomSectionItemProvider.
 */
public class CustomSectionItemProvider extends SectionItemProvider {

	IDataModelManager manager = ZigguratInject.make(IDataModelManager.class);

	/**
	 * Instantiates a new custom section item provider.
	 * 
	 * @param adapterFactory
	 *            the adapter factory
	 */
	public CustomSectionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		String result = "";

		String id = ((Section) object).getId();
		String text = ((Section) object).getText();

		if (id != null && !id.isEmpty()) {
			result += "[ id : " + id;
		}

		if (text != null && !text.isEmpty()) {
			result += result.isEmpty() ? "[ " : " | ";
			result += "text : " + text;
		}

		if (!result.isEmpty()) {
			result += " ]";
		}

		return "Section " + result;
	}

	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		// FIXME : Use element Data Model to get possible children
		// Gets Dynamic Data Model possible children
		Collection<IDataModel> dataModels = manager.getCurrentDataModels();
		List<IType> types = Lists.newArrayList();
		for (IDataModel dataModel : dataModels) {
			types.addAll(dataModel.getTypes());
		}
		for (IType type : types) {
			if (type instanceof IRequirementType) {
				newChildDescriptors.add(createChildParameter(RequirementSourceDataPackage.Literals.SECTION__CHILDREN, ((IRequirementType) type).createInstance()));
			}
		}
		newChildDescriptors.add(createChildParameter(RequirementSourceDataPackage.Literals.SECTION__CHILDREN, RequirementSourceDataFactory.eINSTANCE.createSection()));
	}

}
