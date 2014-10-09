/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.storage.sesame.storage.savetriggers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.rdfxml.RDFXMLWriter;
import org.polarsys.reqcycle.traceability.storage.sesame.storage.repositoryholders.SesameXMLRepositoryHolder;

public class XMLSaveTrigger implements ISaveTrigger {

	private final SesameXMLRepositoryHolder repositoryHolder;
	private final IProject project;

	public XMLSaveTrigger(SesameXMLRepositoryHolder repositoryHolder, final IProject project) {
		super();
		this.project = project;
		this.repositoryHolder = repositoryHolder;
	}

	@Override
	public void doSave(RepositoryConnection connection) throws RepositoryException, RDFHandlerException, IOException, CoreException {
		final IFile targetIFile = repositoryHolder.getTargetIFile(project);
		final File targetFile = repositoryHolder.getTargetFile(project);
		final BufferedOutputStream outstream = new BufferedOutputStream(new FileOutputStream(targetFile));
		try {
			connection.export(new RDFXMLWriter(outstream));
		} finally {
			outstream.close();
		}

		targetIFile.refreshLocal(IResource.DEPTH_ONE, null);
	}

}