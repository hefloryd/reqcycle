package org.polarsys.reqcycle.impact.merge.filters;

import java.util.Collection;

import org.eclipse.emf.diffmerge.api.diff.IDifference;

public class NullDifferenceFilter implements IDifferenceFilter {

	@Override
	public void filter(Collection<IDifference> diffs) {
		// DO NOTHING
	}

}
