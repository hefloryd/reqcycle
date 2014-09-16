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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import javax.inject.Singleton;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.openrdf.OpenRDFException;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.repository.sail.SailRepositoryConnection;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.RDFParseException;
import org.openrdf.sail.memory.MemoryStore;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.savetriggers.ISaveTrigger;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.savetriggers.XMLSaveTrigger;

@Singleton
public class SesameXMLRepositoryHolder extends AbstractSesameRepositoryHolder<IProject> {

	private static final String RDF_FILE = "./.traceability.rdf";

	public SesameXMLRepositoryHolder() {
		super();
	}

	private static void loadDataFromStream(final RepositoryConnection connection, final InputStream stream) throws RepositoryException, IOException, RDFParseException {
		connection.begin();
		connection.add(stream, "", RDFFormat.RDFXML);
		connection.commit();
	}

	private static SailRepository createRepository() throws RepositoryException {
		final MemoryStore store = new MemoryStore();
		store.setPersist(false);
		store.setSyncDelay(1000L);
		final SailRepository repository = new SailRepository(store);
		repository.initialize();
		return repository;
	}

	public File getTargetFile(final IProject project) {
		final IFile ifile = getTargetIFile(project);
		final IPath fullPath = ifile.getRawLocation().makeAbsolute();
		final File file = fullPath.toFile();
		return file;
	}

	private IFile getTargetIFile(final IProject project) {
		final IFile ifile = project.getFile(RDF_FILE);
		return ifile;
	}

	protected Repository initRepository(final IProject project) throws IOException, OpenRDFException {
		final SailRepository repository = createRepository();

		final File file = getTargetFile(project);

		if (file.exists()) {
			final SailRepositoryConnection connection = repository.getConnection();
			final BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file));

			try {
				loadDataFromStream(connection, stream);
			} finally {
				stream.close();
				connection.close();
			}
		}
		return repository;
	}

	public RepositoryConnection getConnection(final InputStream inputStream) throws RepositoryException, ExecutionException, RDFParseException, IOException {
		final Repository repository = createRepository();
		final RepositoryConnection connection = repository.getConnection();
		loadDataFromStream(connection, inputStream);

		return connection;
	}

	@Override
	public ISaveTrigger getSaveTrigger(IProject project) {
		final IFile targetIFile = getTargetIFile(project);
		final File targetFile = getTargetFile(project);
		return new XMLSaveTrigger(targetIFile, targetFile);
	}
}