/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Olivier Melois (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.utils.collect.exceptions;

/**
 * An exception class that can be thrown by collectors or results handlers in order to abort or signal abortion of the collecting process, for any reason.
 */
public class CollectionAbortedException extends Exception {

	private static final long serialVersionUID = 1L;

	public CollectionAbortedException() {
	}

	public CollectionAbortedException(String message) {
		super(message);
	}

	public CollectionAbortedException(String message, Throwable cause) {
		super(message, cause);
	}

	public CollectionAbortedException(Throwable cause) {
		super(cause);
	}
}
