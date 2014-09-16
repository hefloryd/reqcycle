package org.polarsys.reqcycle.impact.merge.filters;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.diffmerge.api.diff.IDifference;
import org.polarsys.reqcycle.impact.merge.MergerException;

public abstract class AbstractDifferenceFilter implements IDifferenceFilter {

	public void filter(Collection<IDifference> diffs) throws MergerException {
		Iterator<IDifference> diffsIt = diffs.iterator();
		while (diffsIt.hasNext()) {
			IDifference diff = diffsIt.next();
			if (!mergeDiff(diff)) {
				diffsIt.remove();
			}
		}
	}

	public abstract boolean mergeDiff(IDifference diff) throws MergerException;
}
