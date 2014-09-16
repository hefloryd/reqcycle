package org.polarsys.reqcycle.operations.traceability;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.polarsys.reqcycle.operations.IOperation;
import org.polarsys.reqcycle.operations.IOperation.Result;
import org.polarsys.reqcycle.operations.IParameter;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Section;
import org.polarsys.reqcycle.traceability.engine.ITraceabilityEngine;
import org.polarsys.reqcycle.traceability.engine.ITraceabilityEngine.DIRECTION;
import org.polarsys.reqcycle.traceability.engine.Request;
import org.polarsys.reqcycle.traceability.engine.Request.DEPTH;
import org.polarsys.reqcycle.traceability.exceptions.EngineException;
import org.polarsys.reqcycle.traceability.model.Filter;
import org.polarsys.reqcycle.traceability.model.Link;
import org.polarsys.reqcycle.traceability.model.Pair;
import org.polarsys.reqcycle.traceability.model.scopes.Scopes;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class TraceabilityOperations {

	@Inject
	ITraceabilityEngine engine;

	@Inject
	IReachableManager manager;

	public TraceabilityOperations() {
		ZigguratInject.inject(this);
	}

	@IOperation("Is the current requirement covered")
	boolean isCovered(Requirement req, final @IParameter("traceability type") String traceabilityType) {
		try {
			Request request = new Request().setDepth(DEPTH.ONE).setDirection(DIRECTION.DOWNWARD).setFilter(new Filter() {

				@Override
				public boolean apply(Pair<Link, Reachable> pair) {
					return pair.getFirst().getKind().getLabel().equals(traceabilityType);
				}
			});
			request.setScope(Scopes.getWorkspaceScope());
			request.addSource(manager.getHandlerFromObject(req).getFromObject(req).getReachable(req));
			try {
				return engine.getTraceability(request).hasNext();
			} catch (EngineException e) {
				e.printStackTrace();
			}
		} catch (IReachableHandlerException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	@IOperation("get the coverage rate the element (for a section)")
	Result<Float> getCoverageRate(Section selection, final @IParameter("traceability type") String traceabilityType, @IParameter("Workspace Scope") Boolean workspace) {
		Iterable<Requirement> requirements = Iterables.filter(selection.getChildren(), Requirement.class);
		final Set<Object> objectsToListen = Sets.newHashSet();
		try {
			Request request = new Request().setDepth(DEPTH.ONE).setDirection(DIRECTION.DOWNWARD).setFilter(new Filter() {

				@Override
				public boolean apply(Pair<Link, Reachable> pair) {
					return pair.getFirst().getKind().getLabel().equals(traceabilityType);
				}
			});
			if (workspace) {
				request.setScope(Scopes.getWorkspaceScope());
			} else {
				request.setScope(Scopes.getProjectScope(WorkspaceSynchronizer.getFile(selection.eResource())));
			}
			for (Requirement r : requirements) {
				request.addSource(manager.getHandlerFromObject(r).getFromObject(r).getReachable(r));
				objectsToListen.add(r);
			}
			ArrayList<Pair<Link, Reachable>> list;
			try {
				list = Lists.newArrayList(engine.getTraceability(request));
				Map<Reachable, Integer> map = Maps.newHashMap();
				for (Pair<Link, Reachable> p : list) {
					Reachable next = p.getFirst().getSources().iterator().next();
					Integer i = map.get(next);
					if (i == null) {
						map.put(next, 1);
					} else {
						i++;
						map.put(next, i);
					}
					objectsToListen.add(next);
					objectsToListen.add(p.getSecond());
					objectsToListen.add(p.getFirst().getId());
				}
				float total = Lists.newArrayList(requirements).size();
				float nb = 0;
				for (Map.Entry<Reachable, Integer> entry : map.entrySet()) {
					if (entry.getValue() != null && entry.getValue() > 0) {
						nb++;
					}
				}

				final float rate = (nb / total) * 100;
				return new Result<Float>() {
					@Override
					public Collection<Object> getObjectsToListen() {
						return objectsToListen;
					}

					@Override
					public Float getResult() {
						return rate;
					}

					@Override
					public Class<Float> getResultType() {
						return Float.class;
					}
				};
			} catch (EngineException e) {
				e.printStackTrace();
			}
		} catch (IReachableHandlerException e1) {
			e1.printStackTrace();
		}
		return new Result<Float>() {
			@Override
			public Collection<Object> getObjectsToListen() {
				return null;
			}

			@Override
			public Float getResult() {
				return (float) 0;
			}

			@Override
			public Class<Float> getResultType() {
				return Float.class;
			}
		};
	}

}
