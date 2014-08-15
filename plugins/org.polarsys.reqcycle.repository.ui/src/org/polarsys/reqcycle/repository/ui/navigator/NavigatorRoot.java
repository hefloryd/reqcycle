package org.polarsys.reqcycle.repository.ui.navigator;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.PlatformObject;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;

public class NavigatorRoot extends PlatformObject {

	private List<RequirementSource> sources = new LinkedList<RequirementSource>();

	protected List<IPredicate> predicates = new LinkedList<IPredicate>();

	private Boolean filterView = false;
	private Boolean orderView = false;

	public NavigatorRoot() {
	}

	/**
	 * @param sources2
	 */
	public void setSources(Collection<RequirementSource> sources2) {
		sources.clear();
		if (sources2 != null) {
			sources.addAll(sources2);
		}
	}

	public List<RequirementSource> getSources() {
		return Collections.unmodifiableList(sources);
	}

	public void setPredicates(Collection<IPredicate> predicates2) {
		predicates.clear();
		if (predicates2 != null) {
			predicates.addAll(predicates2);
		}
	}

	public List<IPredicate> getPredicates() {
		return Collections.unmodifiableList(predicates);
	}

	public Boolean isViewFiltered() {
		return filterView;
	}

	public Boolean isViewOredered() {
		return orderView;
	}

	public void setViewFiltered(Boolean filtered) {
		filterView = filtered;
	}

	public void setViewOredered(Boolean ordered) {
		orderView = ordered;
	}
}
