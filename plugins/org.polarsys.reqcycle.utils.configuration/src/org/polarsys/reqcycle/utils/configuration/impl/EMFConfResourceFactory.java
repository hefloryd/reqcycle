/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Mathieu Velten (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.utils.configuration.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import com.google.common.collect.Maps;

public class EMFConfResourceFactory implements Resource.Factory {

	public Resource createResource(URI uri) {
		return new EMFConfResource(uri);
	}

	public class EMFConfResource extends XMIResourceImpl {

		@Override
		protected boolean useUUIDs() {
			return true;
		}

		public EMFConfResource() {
		}

		public EMFConfResource(URI uri) {
			super(uri);
		}

		@Override
		public void save(Map<?, ?> options) throws IOException {
		}

		public void manualSave(Map options) throws IOException {
			HashMap newOptions;
			if (options == null) {
				newOptions = Maps.newHashMap();
			} else {
				newOptions = Maps.newHashMap(options);
			}

			newOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
			newOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
			newOptions.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware());
			super.save(newOptions);
		}
	}

}