/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.storage.sesame.storage.repositoryholders;

import java.io.File;
import java.io.IOException;

import javax.inject.Singleton;

import org.openrdf.OpenRDFException;
import org.openrdf.repository.Repository;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.sail.nativerdf.NativeStore;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.savetriggers.DummySaveTrigger;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.savetriggers.ISaveTrigger;

@Singleton
public class SesameBinaryRepositoryHolder extends AbstractSesameRepositoryHolder<String> {

	private static final String REPOSITORY_FOLDER = "/binary";

	public SesameBinaryRepositoryHolder() {
		super();
	}

	@Override
	protected Repository initRepository(String path) throws IOException, OpenRDFException {
		final NativeStore store = new NativeStore(new File(path + REPOSITORY_FOLDER));
		final Repository repository = new SailRepository(store);
		repository.initialize();
		return repository;
	}

	@Override
	public ISaveTrigger getSaveTrigger(String key) {
		return new DummySaveTrigger();
	}
}