package org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.util;

import org.eclipse.jface.viewers.ILabelProvider;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ELink;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable;
import org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityFactory;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.model.IReachableHandler;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.model.ReachableObject;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class Util {

	public static ILabelProvider getProvider(Reachable r) {
		try {
			IReachableManager manager = ZigguratInject.make(IReachableManager.class);
			IReachableHandler handler = manager.getHandlerFromReachable(r);
			ReachableObject reachableObject = handler.getFromReachable(r);
			if (reachableObject != null) {
				ILabelProvider provider = (ILabelProvider) reachableObject.getAdapter(ILabelProvider.class);
				return provider;
			}
		} catch (IReachableHandlerException e) {
		}
		return null;
	}

	public static EReachable newEReachable(Reachable reachable) {
		EReachable createReachable = ReqCycleTraceabilityFactory.eINSTANCE.createEReachable();
		ILabelProvider provider = getProvider(reachable);
		if (provider != null) {
			createReachable.setLabel(provider.getText(reachable));
		}
		createReachable.setURI(reachable.getURI().toString());
		return createReachable;
	}

	public ELink newLink() {
		return null;
	}
}
