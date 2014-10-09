/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.uri.model;

import org.polarsys.reqcycle.uri.exceptions.VisitableException;
import org.polarsys.reqcycle.uri.visitors.EmptyVisitable;
import org.polarsys.reqcycle.uri.visitors.IVisitable;

public class NullReachableObject implements ReachableObject {

	@Override
	public Object getAdapter(Class adapter) {
		if (IBusinessObject.class.equals(adapter)){
			return new IBusinessObject.DefaultBusinessObject(false);
		}
		return null;
	}

	@Override
	public IVisitable getVisitable() throws VisitableException {
		return new EmptyVisitable();
	}

	@Override
	public String getRevisionIdentification() {
		return null;
	}

	@Override
	public Reachable getReachable() {
		return null;
	}

}
