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

import java.io.IOException;

import org.openrdf.OpenRDFException;
import org.openrdf.repository.RepositoryConnection;

public class DummySaveTrigger implements ISaveTrigger {

	public DummySaveTrigger() {
	}

	@Override
	public void doSave(RepositoryConnection connection) throws OpenRDFException, IOException {
		// nothing
	}

}
