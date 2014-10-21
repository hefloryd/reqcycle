/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Philippe Roland (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.commands.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Status;
import org.polarsys.reqcycle.commands.Activator;
import org.polarsys.reqcycle.commands.CreateRelationCommand;
import org.polarsys.reqcycle.traceability.types.ITypesConfigurationProvider;
import org.polarsys.reqcycle.traceability.types.configuration.typeconfiguration.Configuration;
import org.polarsys.reqcycle.traceability.types.configuration.typeconfiguration.Relation;
import org.polarsys.reqcycle.types.IType;
import org.polarsys.reqcycle.types.ITypesManager;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class RelationCommandUtils {

	@Inject
	static ITypesConfigurationProvider typeConfigProvider = ZigguratInject.make(ITypesConfigurationProvider.class);

	@Inject
	static ITypesManager typeManager = ZigguratInject.make(ITypesManager.class);

	public static Set<RelationCreationDescriptor> getAllRelationCommands(List<Reachable> sourceReachables, List<Reachable> targetReachables) {

		Set<RelationCreationDescriptor> set = Sets.newHashSet();
		Configuration defaultConfiguration = typeConfigProvider.getContainer().getDefaultConfiguration();
		if (defaultConfiguration != null) {
			for (Reachable sourceReachable : sourceReachables) {
				for (Reachable targetReachable : targetReachables) {
					Set<RelationCreationDescriptor> matches = getMatches(sourceReachable, targetReachable, defaultConfiguration);
					if (set.isEmpty()){
						set = matches;
					}
					else {
						set = Sets.intersection(set, matches);
					}
				}
			}
		} else {
			Activator.getDefault().getLog().log(new Status(Status.WARNING, Activator.PLUGIN_ID, "No default Reqcycle configuration was found"));
		}

		return set;
	}

	protected static Set<RelationCreationDescriptor> getMatches(Reachable sourceReachable, Reachable targetReachable, Configuration configuration) {
		Set<RelationCreationDescriptor> result = Sets.newHashSet();
		for (Relation relation : configuration.getRelations()) {
			result.addAll(Sets.newHashSet(match(relation, sourceReachable, targetReachable)));
		}
		return result;

	}

	protected static Iterable<RelationCreationDescriptor> match(Relation r, Reachable sourceReachable, Reachable targetReachable) {
		if (r.getUpstreamType() == null || r.getDownstreamType() == null) {
			return Sets.newHashSet();
		}
		boolean match = false;
		int type = 0;
		if (r.getUpstreamType().getIType().is(sourceReachable) && r.getDownstreamType().getIType().is(targetReachable)) {
			match = true;
			type = RelationCreationDescriptor.UPSTREAM_TO_DOWNSTREAM;
		}
		if (r.getUpstreamType().getIType().is(targetReachable) && r.getDownstreamType().getIType().is(sourceReachable)) {
			if (type == RelationCreationDescriptor.UPSTREAM_TO_DOWNSTREAM) {
				type = RelationCreationDescriptor.BOTH;
			} else {
				type = RelationCreationDescriptor.DOWNSTREAM_TO_UPSTREAM;
			}
			match = true;
		}

		if (match) {
			List<RelationCreationDescriptor> descs = new ArrayList<RelationCreationDescriptor>(2);
			if (type == RelationCreationDescriptor.BOTH || type == RelationCreationDescriptor.DOWNSTREAM_TO_UPSTREAM) {
				descs.add(new RelationCreationDescriptor(RelationCreationDescriptor.DOWNSTREAM_TO_UPSTREAM, r));
			}
			if (type == RelationCreationDescriptor.BOTH || type == RelationCreationDescriptor.UPSTREAM_TO_DOWNSTREAM) {
				descs.add(new RelationCreationDescriptor(RelationCreationDescriptor.UPSTREAM_TO_DOWNSTREAM, r));
			}
			return descs;
		} else {
			return Sets.newHashSet();
		}
	}

}

