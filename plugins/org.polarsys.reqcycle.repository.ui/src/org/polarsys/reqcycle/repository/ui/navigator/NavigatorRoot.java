package org.polarsys.reqcycle.repository.ui.navigator;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.PlatformObject;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.ui.RequirementViewDisplayType;

public class NavigatorRoot extends PlatformObject {

	private List<RequirementSource> sources = new LinkedList<RequirementSource>();

	private List<IPredicate> predicates = new LinkedList<IPredicate>();

	private List<Scope> scopes = new LinkedList<Scope>();

	private RequirementViewDisplayType displayType = RequirementViewDisplayType.NONE;
	private String reqFilter = "";

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

	public void removeSource(RequirementSource source) {
		if (sources.contains(source)) {
			sources.remove(source);
		}
	}

	public void addSource(RequirementSource source) {
		sources.add(source);
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

	public void setScopes(Collection<Scope> scopes2) {
		scopes.clear();
		if (scopes2 != null) {
			scopes.addAll(scopes2);
		}
	}

	public List<Scope> getScopes() {
		return scopes;
	}

	public void setFilter(String filter) {
		reqFilter = filter;
	}

	public String getFilter() {
		return reqFilter;
	}

	public RequirementViewDisplayType getDisplay() {
		return displayType;
	}

	public void setDisplay(RequirementViewDisplayType display) {
		this.displayType = display;
	}
}
