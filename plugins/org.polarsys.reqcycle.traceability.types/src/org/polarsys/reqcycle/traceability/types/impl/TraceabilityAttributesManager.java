/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.types.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

import org.eclipse.core.resources.IProject;
import org.polarsys.reqcycle.traceability.storage.IStorageProvider;
import org.polarsys.reqcycle.traceability.storage.ITraceabilityStorage;
import org.polarsys.reqcycle.traceability.storage.NoProjectStorageException;
import org.polarsys.reqcycle.traceability.types.ITraceabilityAttributesManager;
import org.polarsys.reqcycle.traceability.types.ITypesConfigurationProvider;
import org.polarsys.reqcycle.traceability.types.configuration.typeconfiguration.Attribute;
import org.polarsys.reqcycle.traceability.types.configuration.typeconfiguration.Configuration;
import org.polarsys.reqcycle.traceability.types.configuration.typeconfiguration.Relation;
import org.polarsys.reqcycle.traceability.types.impl.FromStorageEditableAttribute.ILazyStorageProvider;
import org.polarsys.reqcycle.uri.model.Reachable;

import com.google.common.base.Predicate;

import static com.google.common.collect.Iterables.find;

public class TraceabilityAttributesManager implements
		ITraceabilityAttributesManager {
	public static final String RELATION_NAME = "relationKind";

	@Inject
	ITypesConfigurationProvider typesConfigurationProvider;
	@Inject
	IStorageProvider storageProvider;

	@Override
	public Collection<EditableAttribute> getAttributes(Reachable reachable) {
		// check if default configuration is set
		Configuration defaultConfiguration = typesConfigurationProvider
				.getDefaultConfiguration();
		if (defaultConfiguration == null) {
			return Collections.emptyList();
		}
		// retrieve the reachable object to get correct project
		try {
			ITraceabilityStorage storage = storageProvider.getProjectStorageFromLinkId(reachable);
			if (storage == null) {
				return Collections.emptyList();
			}
			return getAttributes(reachable, defaultConfiguration, storage);
		} catch (NoProjectStorageException e) {
			e.printStackTrace(); // TODO Error handling
		}
		return Collections.emptyList();
	}

	private Collection<EditableAttribute> getAttributes(Reachable reachable,
			Configuration configuration, ITraceabilityStorage storage) {
		final String relationName = storage.getProperty(reachable,
				RELATION_NAME);
		if (relationName != null) {
			Relation rel = find(configuration.getRelations(),
					new Predicate<Relation>() {

						@Override
						public boolean apply(Relation arg0) {
							return relationName.equals(arg0.getKind());
						}

					}, null);
			if (rel != null) {
				return getAttributes(reachable, rel);
			}
		}
		return Collections.emptyList();
	}

	private Collection<EditableAttribute> getAttributes(Reachable reachable,
			Relation rel) {
		Collection<EditableAttribute> attributes = new ArrayList<ITraceabilityAttributesManager.EditableAttribute>();
		for (Attribute a : rel.getAttributes()) {
			final LazyStorageProvider lazyStorageProvider = new LazyStorageProvider(storageProvider, reachable);
			final FromStorageEditableAttribute editableAttribute = new FromStorageEditableAttribute(a, reachable, lazyStorageProvider);
			attributes.add(editableAttribute);
		}
		return attributes;
	}
	
	private class LazyStorageProvider implements ILazyStorageProvider {
		final IStorageProvider provider;
		final Reachable reachable;
		
		public LazyStorageProvider(IStorageProvider provider, Reachable reachable) {
			super();
			this.provider = provider;
			this.reachable = reachable;
		}



		@Override
		public ITraceabilityStorage getStorage() {
			try {
				return provider.getProjectStorageFromLinkId(reachable);
			} catch (NoProjectStorageException e) {
				throw new RuntimeException("Can't open storage"); // FIXME that's nasty
			}
		}
		
	}
}
