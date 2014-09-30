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

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MonthVariable extends TimeVariable {

	@Override
	public String getLabel() {
		return "month";
	}

	@Override
	protected DateFormat getFormat() {
		return new SimpleDateFormat("MM");
	}

}
