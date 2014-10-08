package org.polarsys.reqcycle.operations.traceability;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import org.polarsys.reqcycle.uri.model.IBusinessObject;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.model.ReachableObject;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
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

	@IOperation("Is the current requirement has broken traceability links")
	public Result<Boolean> hasBrokenLinks (Requirement req, @IParameter("Downstream analysis") Boolean downstream, @IParameter("Upstream analysis")Boolean upstream) {
		final List<Link> brokenLinks = getBrokenLinks(req, downstream, upstream);
		return new Result<Boolean>() {
			@Override
			public Collection<Object> getObjectsToListen() {
				Collection<Object> result = Lists.newArrayList();
				for (Link l : brokenLinks){
					result.add(l.getTargets().iterator().next());
				}
				return result;
			}
			
			@Override
			public Boolean getResult() {
				return brokenLinks.size() > 0;
			}

			@Override
			public Class<Boolean> getResultType() {
				return Boolean.class;
			}
		};
	}
	
	public List<Link> getBrokenLinks (Requirement req, boolean downstream, boolean upstream){
		List<Link> result = Lists.newArrayList();
		if (upstream){
			Iterator<Pair<Link, Reachable>> upwardTraceability = getTraceability(req, DIRECTION.UPWARD, DEPTH.ONE, null);
			result.addAll(getBrokenLinks(upwardTraceability));
		}
		if (downstream){
			Iterator<Pair<Link, Reachable>> downwardTraceability = getTraceability(req, DIRECTION.DOWNWARD, DEPTH.ONE, null);
			result.addAll(getBrokenLinks(downwardTraceability));
		}
		return result ;
	}
	
	public Collection<? extends Link> getBrokenLinks(
			Iterator<Pair<Link, Reachable>> traceability) {
		Collection<Link> result = Lists.newArrayList();
		while (traceability.hasNext()){
			Pair<Link, Reachable> pair = traceability.next();
			Link l = pair.getFirst();
			for (Reachable r : l.getTargets()){
				ReachableObject object;
				try {
					object = manager.getHandlerFromReachable(r).getFromReachable(r);
					IBusinessObject bO = (IBusinessObject) object.getAdapter(IBusinessObject.class);
					if (bO != null){
						if (!bO.exists()){
							result.add(l);
							continue;
						}
					}
				} catch (IReachableHandlerException e) {
				}
			}
		}
		return result;
	}

	public Iterator<Pair<Link,Reachable>> getTraceability (Requirement req, DIRECTION direction, DEPTH depth, Filter filter){
		try {
			Request request = getTraceabilityRequest(req, direction, depth,
					filter);
			try {
				return engine.getTraceability(request);
			} catch (EngineException e) {
				e.printStackTrace();
			}
		} catch (IReachableHandlerException e1) {
			e1.printStackTrace();
		}
		return Iterators.emptyIterator();
	}

	private Request getTraceabilityRequest(Requirement req,
			DIRECTION direction, DEPTH depth, Filter filter)
			throws IReachableHandlerException {
		Request request = new Request().setDepth(depth).setDirection(direction);
		if (filter != null){
			request.setFilter(filter);
		}
		request.setScope(Scopes.getWorkspaceScope());
		request.addSource(manager.getHandlerFromObject(req).getFromObject(req).getReachable());
		return request;
	}
	
	@IOperation("Is the current requirement covered")
	public Result<Boolean> isCovered(Requirement req, final @IParameter("traceability type") String traceabilityType) {
		final Set<Object> objectsToListen = Sets.newHashSet();
		
		objectsToListen.add(req);
		
		Filter f = new Filter() {

			@Override
			public boolean apply(Pair<Link, Reachable> pair) {
				return traceabilityType == null || traceabilityType.length() == 0 || pair.getFirst().getKind().getLabel().equals(traceabilityType);
			}
		};
		
		ArrayList<Pair<Link, Reachable>> list;
		list = Lists.newArrayList(getTraceability(req, DIRECTION.DOWNWARD, DEPTH.ONE, f));
		for (Pair<Link, Reachable> p : list) {
			Reachable next = p.getFirst().getSources().iterator().next();
			objectsToListen.add(next);
			objectsToListen.add(p.getSecond());
			objectsToListen.add(p.getFirst().getId());
		}
		
		final boolean cov = !list.isEmpty();
		
		return new Result<Boolean>() {
			@Override
			public Collection<Object> getObjectsToListen() {
				return objectsToListen;
			}

			@Override
			public Boolean getResult() {
				return cov;
			}

			@Override
			public Class<Boolean> getResultType() {
				return Boolean.class;
			}
		};
	}

	@IOperation("get the coverage rate the element (for a section)")
	public Result<Float> getCoverageRate(Section selection, final @IParameter("traceability type") String traceabilityType, @IParameter("Workspace Scope") Boolean workspace) {
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
				request.addSource(manager.getHandlerFromObject(r).getFromObject(r).getReachable());
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
