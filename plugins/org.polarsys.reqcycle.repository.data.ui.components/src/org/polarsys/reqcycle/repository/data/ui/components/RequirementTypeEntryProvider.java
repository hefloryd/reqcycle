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
package org.polarsys.reqcycle.repository.data.ui.components;

import java.util.ArrayList;

import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.repository.data.types.IType;
import org.polarsys.reqcycle.ui.eattrpropseditor.api.AbstractPropsEditor;
import org.polarsys.reqcycle.ui.eattrpropseditor.api.AbstractPropsEditorComponent;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Lists;


public class RequirementTypeEntryProvider extends AbstractPropsEditor<String> {

	IDataModelManager dataModelManager = ZigguratInject.make(IDataModelManager.class);

	@Override
	protected AbstractPropsEditorComponent<String> initAndGetComponent() {
		ArrayList<IType> availablesTypes = Lists.newArrayList();
		for (IDataModel dataModel : dataModelManager.getCurrentDataModels()) {
			availablesTypes.addAll(dataModel.getTypes());
		}
		return new ComboComponent(getAttributeName(), availablesTypes, getContainer());
	}

}
