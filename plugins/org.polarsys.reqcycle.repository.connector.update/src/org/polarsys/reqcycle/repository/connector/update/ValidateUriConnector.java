/*******************************************************************************
 *  Copyright (c) 2013, 2014 AtoS and others
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *  Malick WADE (AtoS) - initial API and implementation and/or initial documentation
 *
 *******************************************************************************/
package org.polarsys.reqcycle.repository.connector.update;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

public class ValidateUriConnector {

	

	private static Set<String> loadExtensions() {
		final IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.emf.ecore","extension_parser");
		HashSet<String> set = Sets.newHashSet(
				Iterables.transform(Arrays.asList(elements), new Function<IConfigurationElement, String>() {
					@Override
					public String apply(IConfigurationElement arg0) {
						return arg0.getAttribute("type").toLowerCase();
					}
				})
		) ;
		set.add("xmi");
		return set;
	}
	

	public static IStatus validateEMFSources(Object value) {
		Set<String> EXTENSIONS = loadExtensions ();
		URI uri = URI.createURI((String) value, true);

		String extension = uri.path().substring(uri.path().lastIndexOf(".")+1, uri.path().length());
		if (EXTENSIONS.contains(extension.toLowerCase())){
			return Status.OK_STATUS;
		}
		return new Status(IStatus.WARNING, Activator.PLUGIN_ID, "extension " + extension + " is not supported. Retry and choose document file");

	}
	
}
