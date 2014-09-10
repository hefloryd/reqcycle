package org.polarsys.reqcycle.styling.ui.providers;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.polarsys.reqcycle.predicates.core.IPredicateEvaluator;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Section;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.ui.navigator.NavigatorRoot;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;

public class StylingContentProvider implements ITreeContentProvider {

	@Inject
	IPredicateEvaluator predicateEvaluator;

	private List<IPredicate> predicates;
	private List<Scope> scopes;

	private Boolean filtered;
	private Boolean ordered;
	private Boolean scope;

	private NavigatorRoot navigatorRoot;

	public StylingContentProvider() {
		super();
		ZigguratInject.inject(this);

		predicates = new LinkedList<IPredicate>();
		scopes = new LinkedList<Scope>();
		filtered = false;
		ordered = false;
		scope = false;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (newInput instanceof NavigatorRoot) {
			this.navigatorRoot = (NavigatorRoot) newInput;
		}
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof NavigatorRoot) {
			predicates = ((NavigatorRoot) inputElement).getPredicates();
			scopes = ((NavigatorRoot) inputElement).getScopes();
			filtered = ((NavigatorRoot) inputElement).isViewFiltered();
			ordered = ((NavigatorRoot) inputElement).isViewOrdered();
			scope  = ((NavigatorRoot) inputElement).isViewByScopes();

			if (ordered && (predicates.size() != 0)) {
				return predicates.toArray();
			} else if (filtered && (predicates.size() == 1)) {
				IPredicate predicate = predicates.get(0);

				return Iterators.toArray(Iterators.filter(
						((NavigatorRoot) inputElement).getSources().iterator(),
						new PPredicate(predicate)), Object.class);
			} else if (scope && (scopes.size() != 0)) {
				return scopes.toArray();
			} else {
				List<RequirementSource> sources = ((NavigatorRoot) inputElement)
						.getSources();
				return sources.toArray();
			}
		}
		return null;
	}

	@Override
	public Object[] getChildren(final Object object) {
		Collection<AbstractElement> elements = Collections.emptyList();

		if (object instanceof RequirementSource) {
			if (filtered && (predicates.size() == 1)) {
				IPredicate predicate = predicates.get(0);

				return Iterators.toArray(Iterators.filter(
						((RequirementSource) object).getRequirements()
						.iterator(), new PPredicate(predicate)),
						Object.class);
			} else {
				elements = ((RequirementSource) object).getRequirements();
			}
		} else if (object instanceof IPredicate) {
			return Iterators.toArray(Iterators.filter(Iterators
					.concat(Iterators.transform(navigatorRoot.getSources()
							.iterator(), new Source2Reqs())), new PPredicate(
									(IPredicate) object)), Object.class);
		} else if (object instanceof Section) {
			if (filtered && (predicates.size() == 1)) {
				IPredicate predicate = predicates.get(0);
				return Iterators.toArray(Iterators.filter(((Section) object)
						.getChildren().iterator(), new PPredicate(predicate)),
						Object.class);
			} else {
				elements = ((Section) object).getChildren();
			}
		} else if (object instanceof Scope) {
			return ((Scope)object).getRequirements().toArray();
		}

		if (elements.size() != 0) {
			return Iterables.toArray(elements, Object.class);
		} else {
			return null;
		}
	}

	@Override
	public Object getParent(Object object) {
		return null;
	}

	@Override
	public boolean hasChildren(Object object) {
		if (object instanceof RequirementSource) {
			if (filtered && (predicates.size() == 1)) {
				IPredicate predicate = predicates.get(0);
				List<RequirementSource> list = new LinkedList<RequirementSource>();
				list.add((RequirementSource) object);
				return Iterators.filter(
						Iterators.concat(Iterators.transform(list.iterator(),
								new Source2Reqs())),
								new PPredicate(predicate)).hasNext();
			} else {
				return !((RequirementSource) object).getRequirements()
						.isEmpty();
			}
		} else if (object instanceof IPredicate) {
			return Iterators.filter(
					Iterators.concat(Iterators.transform(navigatorRoot
							.getSources().iterator(), new Source2Reqs())),
							new PPredicate((IPredicate) object)).hasNext();
		} else if (object instanceof Section) {
			return !((Section) object).getChildren().isEmpty();
		} else if (object instanceof Scope) {
			return !((Scope)object).getRequirements().isEmpty();
		}
		return false;
	}

	private static class Source2Reqs implements
	Function<RequirementSource, Iterator<Requirement>> {

		@Override
		public Iterator<Requirement> apply(RequirementSource arg0) {
			Iterator<Requirement> result = Iterators.emptyIterator();
			for (AbstractElement a : arg0.getRequirements()) {
				result = Iterators.concat(result,
						Iterators.filter(a.eAllContents(), Requirement.class));
			}
			return result;
		}
	}

	private class PPredicate implements Predicate<Object> {
		private IPredicate p;

		public PPredicate(IPredicate p) {
			this.p = p;
		}

		@Override
		public boolean apply(Object arg0) {
			if (p == null) {
				return true;
			}
			if (arg0 instanceof RequirementSource) {
				for(AbstractElement elt : ((RequirementSource)arg0).getRequirements()) {
					if(elt instanceof Section) {
						for(AbstractElement element : ((Section)elt).getChildren()) {
							if (predicateEvaluator.match(p, element)) {
								return true;
							}
						}
					} else if (predicateEvaluator.match(p, elt)) {
						return true;
					}
				}
				return false;
			} else
			if (arg0 instanceof Section && ! (arg0 instanceof Requirement)) {
				for (AbstractElement elt : ((Section) arg0).getChildren()) {
					if (predicateEvaluator.match(p, elt)) {
						return true;
					}
				}
				return false;
			} else {
				return predicateEvaluator.match(p, arg0);
			}
		}
	}
}