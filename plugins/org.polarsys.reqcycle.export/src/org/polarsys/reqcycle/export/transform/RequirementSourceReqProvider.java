/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Abdellah El Ayadi (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.reqcycle.export.transform;

import java.util.HashMap;
import java.util.Map;

import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class RequirementSourceReqProvider implements IRequirementProvider {

	private RequirementSource source;

	public RequirementSourceReqProvider(RequirementSource source) {
		this.source = source;
	}

	@Override
	public Iterable<Requirement> getRequirements() {
		return Lists.newArrayList(Iterators.filter(source.getContents().eAllContents(), Requirement.class));
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
	public boolean equals(Object obj) {
		if (obj instanceof RequirementSourceReqProvider) {
			RequirementSourceReqProvider scope = (RequirementSourceReqProvider) obj;
			return scope.source.equals(this.source);
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return source.hashCode();
	}

}
