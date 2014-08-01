/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.uri.functions;

import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.base.Function;

public class URIFunctions {
	private static Function<Reachable, Reachable> TRIM_FRAGMENT_FUNCTION ;
	private static Function<Object, Reachable> OBJECT_TO_REACHABLE_FUNCTION ;
	
	static {
		TRIM_FRAGMENT_FUNCTION = new TrimFragmentFunction();
		OBJECT_TO_REACHABLE_FUNCTION = new Object2Reachable();
		ZigguratInject.inject(TRIM_FRAGMENT_FUNCTION,OBJECT_TO_REACHABLE_FUNCTION);
	}
	
	public static Function<Reachable, Reachable> newTrimFragmentFunction() {
		return TRIM_FRAGMENT_FUNCTION;
	}

	public static Function<Object, Reachable> newObject2ReachableFunction() {
		return OBJECT_TO_REACHABLE_FUNCTION;
	}
}
