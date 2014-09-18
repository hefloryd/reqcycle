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

import java.util.Map;

import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

public class ScopeReqProvider implements IRequirementProvider {
	private Scope scope;

	public ScopeReqProvider(Scope scope) {
		this.scope = scope;
	}

	@Override
	public Iterable<Requirement> getRequirements() {
		return Iterables.filter(scope.getRequirements(), Requirement.class);
	}

	@Override
	public String getLabel() {
		return scope.getName();
	}

	@Override
	public Map<String, String> getMetadata() {
		return Maps.newHashMap();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ScopeReqProvider) {
			ScopeReqProvider scope = (ScopeReqProvider) obj;
			return scope.scope.equals(this.scope);
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return scope.hashCode();
	}

}
