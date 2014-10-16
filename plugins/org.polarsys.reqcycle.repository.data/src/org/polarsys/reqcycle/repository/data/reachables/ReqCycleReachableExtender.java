/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.repository.data.reachables;

import java.net.URI;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.reqcycle.emf.ui.EMFEditExtender;

public class ReqCycleReachableExtender extends EMFEditExtender {

	@Override
	public boolean handles(URI uri, Object object) {
		return ReqcycleReachableHandler.isReqcycle(org.eclipse.emf.common.util.URI.createURI(uri.toString())) && object instanceof EObject && !((EObject) object).eIsProxy();
	}

}
