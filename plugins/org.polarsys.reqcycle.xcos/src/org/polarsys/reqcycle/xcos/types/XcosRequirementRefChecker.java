/*******************************************************************************
 * Copyright (c) 2014 Samares Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *    Raphael Faudou (Samares Engineering) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.xcos.types;

import org.polarsys.reqcycle.types.ITypeChecker;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.model.ReachableObject;
import org.polarsys.reqcycle.xcos.handlers.XcosReachableHandler;
import org.polarsys.reqcycle.xcos.model.XcosElement;
import org.polarsys.reqcycle.xcos.model.XcosRequirementRef;

public class XcosRequirementRefChecker implements ITypeChecker {

	@Override
	public boolean apply(Reachable reachable) {
		// XcosReachableHandler xcosReachableHandler = new XcosReachableHandler();
		// if (!xcosReachableHandler.apply(arg0)) {
		// return false;
		// }
		// ReachableObject handler = jdtReachableHandler.getFromReachable(arg0);
		// if (handler == null) {
		// return false;
		// }
		// XcosElement adapter = (XcosElement) handler
		// .getAdapter(XcosElement.class);
		// return adapter != null && adapter instanceof XcosRequirementRef;

		// TODO do real impl
		return true;
	}
}
