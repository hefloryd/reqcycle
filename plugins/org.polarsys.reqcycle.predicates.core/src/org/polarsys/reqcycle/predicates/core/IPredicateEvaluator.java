package org.polarsys.reqcycle.predicates.core;

import org.polarsys.reqcycle.predicates.core.api.IPredicate;

public interface IPredicateEvaluator {

	public boolean match(IPredicate p, Object input);
}
