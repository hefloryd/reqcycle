/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.styling.ui.providers;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.polarsys.reqcycle.predicates.core.IPredicateEvaluator;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Section;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.ui.RequirementViewDisplayType;
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
	private String reqFilter;

	private RequirementViewDisplayType displayType;

	private NavigatorRoot navigatorRoot;

	public StylingContentProvider() {
		super();
		ZigguratInject.inject(this);

		predicates = new LinkedList<IPredicate>();
		scopes = new LinkedList<Scope>();
		displayType = RequirementViewDisplayType.NONE;
		reqFilter = "";
	}

	@Override
	public void dispose() {
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
			reqFilter = ((NavigatorRoot) inputElement).getFilter();
			displayType = ((NavigatorRoot) inputElement).getDisplay();

			switch (displayType) {
			case FILTERBYNAME:
				if ((reqFilter != null) && (!reqFilter.equals(""))) {
					final Pattern p = Pattern.compile(".*" + reqFilter + ".*", Pattern.DOTALL);
					final Predicate<Object> attPredicate = new Predicate<Object>(){
						@Override
						public boolean apply(Object arg0) {
							if (arg0 instanceof Requirement) {
								Requirement req = (Requirement) arg0;
								return req.getId() != null && p.matcher(req.getId()).matches();
							}
							return true;
						}
					};
					return Iterators.toArray(Iterators.filter(((NavigatorRoot) inputElement).getSources().iterator(), attPredicate), Object.class);
				} else {
					List<RequirementSource> sources = ((NavigatorRoot) inputElement).getSources();
					return sources.toArray();
				}
			case FILTERBYPREDICATE:
				if (predicates.size() == 1) {
					IPredicate predicate = predicates.get(0);
					
					return Iterators.toArray(Iterators.filter(((NavigatorRoot) inputElement).getSources().iterator(), new PPredicate(predicate)), Object.class);
				} else {
					List<RequirementSource> sources = ((NavigatorRoot) inputElement).getSources();
					return sources.toArray();
				}
			case ORDERBYPREDICATE:
				if (predicates.size() != 0) {
					return predicates.toArray();
				} else {
					List<RequirementSource> sources = ((NavigatorRoot) inputElement).getSources();
					return sources.toArray();
				}
			case ORDERBYSCOPE:
				if (scopes.size() != 0) {
					return scopes.toArray();
				} else {
					List<RequirementSource> sources = ((NavigatorRoot) inputElement).getSources();
					return sources.toArray();
				}
			case REQONLY:
			case NONE:
			default:
				List<RequirementSource> sources = ((NavigatorRoot) inputElement).getSources();
				return sources.toArray();
			}
		}
		return null;
	}
	
	@Override
	public Object[] getChildren(final Object object) {
		Collection<AbstractElement> elements = Collections.emptyList();

		if (object instanceof RequirementSource) {
			RequirementSource requirementSource = (RequirementSource) object;
			if ((displayType.equals(RequirementViewDisplayType.FILTERBYPREDICATE)) && (predicates.size() == 1)) {
				IPredicate predicate = predicates.get(0);

				return Iterators.toArray(Iterators.filter(requirementSource.getRequirements().iterator(), new PPredicate(predicate)), Object.class);
			} else if (displayType.equals(RequirementViewDisplayType.FILTERBYNAME)) {
				final Pattern p = Pattern.compile(".*" + reqFilter + ".*", Pattern.DOTALL);
				final Predicate<Object> attPredicate = new Predicate<Object>(){
					@Override
					public boolean apply(Object arg0) {
						if (arg0 instanceof Requirement) {
							Requirement req = (Requirement) arg0;
							return req.getId() != null && p.matcher(req.getId()).matches();
						}
						return false;
					}
				};
				return Iterators.toArray(Iterators.filter(new Source2Reqs().apply(requirementSource), attPredicate), Object.class);
			} else {
				if (displayType.equals(RequirementViewDisplayType.REQONLY)) {
					return Iterators.toArray(Iterators.concat(Iterators.transform(Collections.singletonList(requirementSource).iterator(), new Source2Reqs())), Object.class);
				} else {
					elements = requirementSource.getRequirements();
				}
			}
		} else if (object instanceof IPredicate) {
			return Iterators.toArray(Iterators.filter(Iterators.concat(Iterators.transform(navigatorRoot.getSources().iterator(), new Source2Reqs())), new PPredicate((IPredicate) object)), Object.class);
		} else if (object instanceof Section) {
			if ((displayType.equals(RequirementViewDisplayType.FILTERBYPREDICATE)) && (predicates.size() == 1)) {
				IPredicate predicate = predicates.get(0);
				return Iterators.toArray(Iterators.filter(((Section) object).getChildren().iterator(), new PPredicate(predicate)), Object.class);
			} else {
				elements = ((Section) object).getChildren();
			}
		} else if (object instanceof Scope) {
			return ((Scope) object).getRequirements().toArray();
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
			if ((displayType.equals(RequirementViewDisplayType.FILTERBYPREDICATE)) && (predicates.size() == 1)) {
				IPredicate predicate = predicates.get(0);
				return Iterators.filter(Iterators.concat(Iterators.transform(Collections.singletonList((RequirementSource) object).iterator(), new Source2Reqs())), new PPredicate(predicate)).hasNext();
			} else {
				return !((RequirementSource) object).getRequirements().isEmpty();
			}
		} else if (object instanceof IPredicate) {
			return Iterators.filter(Iterators.concat(Iterators.transform(navigatorRoot.getSources().iterator(), new Source2Reqs())), new PPredicate((IPredicate) object)).hasNext();
		} else if (object instanceof Section) {
			return !((Section) object).getChildren().isEmpty();
		} else if (object instanceof Scope) {
			return !((Scope) object).getRequirements().isEmpty();
		}
		return false;
	}
	
	private static class Source2Reqs implements Function<RequirementSource, Iterator<Requirement>> {

		@Override
		public Iterator<Requirement> apply(RequirementSource arg0) {
			Iterator<Requirement> result = Iterators.filter(arg0.getRequirements().iterator(), Requirement.class);
			Iterator<Iterator<EObject>> allChildren = Iterators.transform(arg0.getRequirements().iterator(), new Function<AbstractElement, Iterator<EObject>>() {

				@Override
				public Iterator<EObject> apply(AbstractElement arg0) {
					return arg0.eAllContents();
				}
			});
			Iterator<Requirement> allReqChildren = Iterators.filter(Iterators.concat(allChildren), Requirement.class);
			result = Iterators.concat(result, allReqChildren);
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
				for (AbstractElement elt : ((RequirementSource) arg0).getRequirements()) {
					if (elt instanceof Section) {
						if (apply(elt)) {
							return true;
						}
					} else if (predicateEvaluator.match(p, elt)) {
						return true;
					}
				}
				return false;
			} else if (arg0 instanceof Requirement) {
				return predicateEvaluator.match(p, arg0);
			} else if (arg0 instanceof Section) {
				for (AbstractElement elt : ((Section) arg0).getChildren()) {
					if (elt instanceof Requirement) {
						if (predicateEvaluator.match(p, elt)) {
							return true;
						}
					} else {
						if (apply(elt)) {
							return true;
						}
					}
				}
				return false;
			}
			return false;
		}
	}
}