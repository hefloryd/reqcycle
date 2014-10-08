package org.polarsys.reqcycle.uri.adapters;

import org.eclipse.core.runtime.IAdapterFactory;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class ReachableAdapterFactory implements IAdapterFactory {

	private static IReachableManager manager = ZigguratInject.make(IReachableManager.class);

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (Reachable.class.equals(adapterType)) {
			try {
				return manager.getHandlerFromObject(adaptableObject).getFromObject(adaptableObject).getReachable();
			} catch (IReachableHandlerException e) {
			}
		}
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return new Class[] { Reachable.class };
	}

}
