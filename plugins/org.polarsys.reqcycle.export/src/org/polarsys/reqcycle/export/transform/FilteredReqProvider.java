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

import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class FilteredReqProvider implements IRequirementProvider {

	private IRequirementProvider provider;
	private IPredicate predicate;

	public FilteredReqProvider(IRequirementProvider provider, IPredicate predicate) {
		this.provider = provider;
		this.predicate = predicate;
	}

	@Override
	public Iterable<Requirement> getRequirements() {
		return Iterables.filter(provider.getRequirements(), new Predicate<Requirement>() {

			@Override
			public boolean apply(Requirement arg0) {
				return predicate.match(arg0);
			}
		});
	}

	@Override
	public String getLabel() {
		return provider.getLabel();
	}

	@Override
	public Map<String, String> getMetadata() {
		return provider.getMetadata();
	}

}
