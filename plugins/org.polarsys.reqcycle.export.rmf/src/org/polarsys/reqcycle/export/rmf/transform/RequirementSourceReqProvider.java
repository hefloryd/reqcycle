/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Abdellah El Ayadi (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.reqcycle.export.rmf.transform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.polarsys.reqcycle.repository.connector.ui.PropertyUtils;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementsContainer;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Section;
import org.polarsys.reqcycle.repository.data.types.IDataModel;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class RequirementSourceReqProvider implements IRequirementProvider {

	private RequirementSource source;

	public RequirementSourceReqProvider(RequirementSource source) {
		this.source = source;
	}

	@Override
	public EList<AbstractElement> getRequirements() {
		if (source.getContents() instanceof RequirementsContainer) {
			return source.getContents().getRequirements();
		}
		return null;
	}

	@Override
	public ArrayList<Section> getSections() {
		return Lists.newArrayList(Iterators.filter(source.getContents().eAllContents(), Section.class));
	}

	@Override
	public String getLabel() {
		return source.getName();
	}

	@Override
	public Map<String, String> getMetadata() {
		HashMap<String, String> map = Maps.newHashMap();
		map.put("DataSource URI", source.getDataModelURI());
		return map;
	}

	@Override
	public IDataModel getDataModel() {
		return PropertyUtils.getDataModelFromSource(source);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RequirementSourceReqProvider) {
			RequirementSourceReqProvider scope = (RequirementSourceReqProvider) obj;
			return scope.source.equals(this.source);
		}
		return super.equals(obj);
	}

	public RequirementSource getSource() {
		return source;
	}

	@Override
	public int hashCode() {
		return source.hashCode();
	}

}
