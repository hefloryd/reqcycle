/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.predicates;

import java.util.Iterator;
import java.util.Set;

import org.polarsys.reqcycle.traceability.model.Link;
import org.polarsys.reqcycle.traceability.model.Pair;
import org.polarsys.reqcycle.traceability.model.scopes.IScope;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.functions.URIFunctions;
import org.polarsys.reqcycle.uri.model.IBusinessObject;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.model.ReachableObject;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;

public class IsInScopePredicate implements Predicate<Pair<Link, Reachable>> {

	private IScope scope;
	private static IReachableManager manager = ZigguratInject.make(IReachableManager.class);

	public IsInScopePredicate(IScope scope) {
		this.scope = scope;
	}

	@Override
	public boolean apply(Pair<Link, Reachable> arg0) {
		if (scope == null) {
			return true;
		}
		Set<Reachable> inScope = Sets.newHashSet(scope.getReachables());
		Function<Reachable, Reachable> function = URIFunctions.newTrimFragmentFunction();
		
		Reachable[] toTest = new Reachable[]{
				function.apply(arg0.getFirst().getSources().iterator().next()),
				function.apply(arg0.getFirst().getTargets().iterator().next()),
				function.apply(arg0.getFirst().getId())
		};
		for (Reachable r : toTest){
			if (!inScope.contains(r)){
				try {
					ReachableObject object = manager.getHandlerFromReachable(r).getFromReachable(r);
					IBusinessObject bo = (IBusinessObject) object.getAdapter(IBusinessObject.class);
					if (bo == null || bo.exists()){
						// in some case undeleted links can exist. 
						// The scope shall not filtered them to help the user to fix them 
						return false;
					}
				} catch (IReachableHandlerException e) {
				}
				
			}
		}
		return true;
	}
}
