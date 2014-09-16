package org.polarsys.reqcycle.impact.merge.filters;

import java.util.Collection;

import org.eclipse.emf.diffmerge.api.diff.IDifference;
import org.polarsys.reqcycle.impact.merge.MergerException;

public interface IDifferenceFilter {

	void filter(Collection<IDifference> diffs) throws MergerException;
}
