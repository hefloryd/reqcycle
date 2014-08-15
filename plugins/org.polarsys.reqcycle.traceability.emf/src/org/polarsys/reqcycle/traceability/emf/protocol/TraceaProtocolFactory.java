/*****************************************************************************
 * Copyright (c) 2014 AtoS.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Abdellah El Ayadi  (AtoS) abdellah.elayadi@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.polarsys.reqcycle.traceability.emf.protocol;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.polarsys.reqcycle.traceability.emf.ETraceabilityResource;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class TraceaProtocolFactory implements Factory {

	@Override
	public Resource createResource(URI uri) {
		if ("tracea".equals(uri.scheme())) {
			ETraceabilityResource eTraceabilityResource = new ETraceabilityResource();
			ZigguratInject.inject(eTraceabilityResource);
			eTraceabilityResource.setURI(uri);
			return eTraceabilityResource;
		}
		return null;
	}

}
