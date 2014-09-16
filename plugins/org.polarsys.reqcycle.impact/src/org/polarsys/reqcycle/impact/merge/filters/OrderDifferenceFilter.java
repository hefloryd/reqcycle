package org.polarsys.reqcycle.impact.merge.filters;

import java.util.Collection;

import org.eclipse.emf.diffmerge.api.diff.IDifference;
import org.eclipse.emf.diffmerge.api.diff.IValuePresence;
import org.polarsys.reqcycle.impact.merge.MergerException;

public class OrderDifferenceFilter extends AbstractDifferenceFilter {
	private IDifferenceFilter delegate;

	public OrderDifferenceFilter() {
		this(new NullDifferenceFilter());
	}

	public OrderDifferenceFilter(IDifferenceFilter delegate) {
		if (delegate == null) {
			delegate = new NullDifferenceFilter();
		}
		this.delegate = delegate;
	}

	@Override
	public void filter(Collection<IDifference> diffs) throws MergerException {
		super.filter(diffs);
		delegate.filter(diffs);
	}

	public boolean mergeDiff(IDifference diff) {
		if (orderCondition(diff)) {
			return false;
		}
		return true;
	}

	protected boolean orderCondition(IDifference diff) {
		return diff instanceof IValuePresence && ((IValuePresence) diff).isOrder() && !((IValuePresence) diff).getFeature().isOrdered();
	}
}
