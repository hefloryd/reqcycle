/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Mathieu Velten (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.utils.configuration;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.EditingDomainProvider;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor;

/**
 * Utility class to have one editing domain registered
 */
public class EditingDomainUtils {

	public static AdapterFactoryEditingDomain getOrCreateEditingDomain(ResourceSet set) {
		for (Adapter a : set.eAdapters()){
			if (a instanceof IEditingDomainProvider){
				return (AdapterFactoryEditingDomain) ((IEditingDomainProvider) a).getEditingDomain();
			}
		}
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(Descriptor.Registry.INSTANCE);
		AdapterFactoryEditingDomain domain = new AdapterFactoryEditingDomain(adapterFactory, new BasicCommandStack(), set);
		set.eAdapters().add(new EditingDomainProvider(domain));
		return domain;
	}
	
}
