/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.storage.impl;

import javax.inject.Singleton;

import org.polarsys.reqcycle.traceability.storage.IStoragePathProvider;
import org.polarsys.reqcycle.traceability.storage.vars.VarManager;

@Singleton
public class VarStoragePathProvider implements IStoragePathProvider {

	@Override
	public String getStoragePath() {
		VarManager varManager = new VarManager() ;
		String pattern = varManager.getPreferencePattern();
		return varManager.transformPattern (pattern);
	}
	

}
