package org.polarsys.reqcycle.predicates.core;

import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.uri.model.Reachable;

public interface IPredicateEvaluator {

	public boolean match(IPredicate p, Object input);

	/**
	 * An interface to listene predicate evaluator changes
	 *
	 */
	public static interface IRefresh {
		public void hasChanged(Reachable[] reachable);
	}

	public void addRefresh(IRefresh refresh);

	public void removeRefresh(IRefresh refresh);
}
