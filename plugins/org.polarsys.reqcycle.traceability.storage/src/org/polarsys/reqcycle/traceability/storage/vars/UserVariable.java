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
package org.polarsys.reqcycle.traceability.storage.vars;

import org.polarsys.reqcycle.traceability.storage.Variable;

public class UserVariable implements Variable {

	@Override
	public String getLabel() {
		return "user";
	}

	@Override
	public String getValue() {
		return System.getProperty("user.name");
	}

}
