package org.polarsys.reqcycle.predicates.core.util;

import javax.inject.Singleton;

import org.polarsys.reqcycle.predicates.core.IPredicateEvaluator;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;

@Singleton
public class PredicateEvaluator implements IPredicateEvaluator {

	@Override
	public boolean match(IPredicate p, Object input) {
		return p.match(input);
	}

}
