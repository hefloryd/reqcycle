package org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.polarsys.reqcycle.traceability.builder.IBuildingTraceabilityEngine;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.IRequestManager;
import org.polarsys.reqcycle.traceability.engine.ITraceabilityEngine.DIRECTION;
import org.polarsys.reqcycle.traceability.engine.Request;
import org.polarsys.reqcycle.traceability.engine.Request.DEPTH;
import org.polarsys.reqcycle.traceability.model.scopes.CompositeScope;
import org.polarsys.reqcycle.traceability.model.scopes.Scopes;
import org.polarsys.reqcycle.traceability.types.conditions.TypeConditions;
import org.polarsys.reqcycle.types.IType;
import org.polarsys.reqcycle.uri.IReachableCreator;
import org.polarsys.reqcycle.uri.model.Reachable;

@Singleton
public class RequestManager implements IRequestManager {

	private Object target;

	@Inject
	IReachableCreator creator;

	@Override
	public Request getUpwardRequest(EReachable source) {

		return getRequest(source, DIRECTION.UPWARD);
	}

	@Override
	public Request getDownwardRequest(EReachable source) {

		return getRequest(source, DIRECTION.DOWNWARD);
	}

	protected Request getRequest(EReachable source, DIRECTION direction) {
		Reachable sourceR = (Reachable) source.getAdapter(Reachable.class);
		CompositeScope scope = new CompositeScope();
		scope.add(Scopes.getWorkspaceScope());
		// scope.add(new ConfigurationScope());
		Request request = new Request().setDirection(direction).setScope(scope).setDepth(DEPTH.ONE).addProperty(IBuildingTraceabilityEngine.OPTION_CHECK_CACHE, false); // FIXME
		// .addProperty(RequestContentProvider.CONF_KEY,
		// btnFilterOnCurrent.getSelection());
		if (target == null) {
			request.addSource(sourceR);
		} else {
			if (target instanceof Reachable) {
				request.addSourceAndTarget(sourceR, (Reachable) target);
			} else if (target instanceof IType) {
				request.addSourceAndCondition(sourceR, TypeConditions.is((IType) target));
			}
			request.setDepth(DEPTH.ONE);
		}
		// traceabilityTreeViewer.setInput(request);
		return request;
	}

	// protected Request getRequest(ELink source, DIRECTION direction) {
	// Link sourceR = (Link) source.getAdapter(Link.class);
	// CompositeScope scope = new CompositeScope();
	// scope.add(Scopes.getWorkspaceScope());
	// //scope.add(new ConfigurationScope());
	// Request request = new Request()
	// .setDirection(direction)
	// .setScope(scope)
	// .setDepth(DEPTH.ONE)
	// .addProperty(
	// IBuildingTraceabilityEngine.OPTION_CHECK_CACHE,
	// false); //FIXME
	// // .addProperty(RequestContentProvider.CONF_KEY,
	// // btnFilterOnCurrent.getSelection());
	// if (target == null) {
	// request.addSource(sourceR);
	// } else {
	// if (target instanceof Reachable) {
	// request.addSourceAndTarget(sourceR, (Reachable) target);
	// } else if (target instanceof IType) {
	// request.addSourceAndCondition(sourceR,
	// TypeConditions.is((IType) target));
	// }
	// request.setDepth(DEPTH.ONE);
	// }
	// // traceabilityTreeViewer.setInput(request);
	// return request;
	// }
	//
	// @Override
	// public Request getUpwardRequest(ELink source) {
	//
	// return getRequest(source,DIRECTION.UPWARD);
	// }
	//
	// @Override
	// public Request getDownwardRequest(ELink source) {
	// return getRequest(source,DIRECTION.DOWNWARD);
	// }

}
