/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.storage;

public class NoProjectStorageException extends Exception {

	private static final long serialVersionUID = 8137614690336157008L;

	public NoProjectStorageException() {
		super();
	}

	/*public NoProjectStorageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}*/

	public NoProjectStorageException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoProjectStorageException(String message) {
		super(message);
	}

	public NoProjectStorageException(Throwable cause) {
		super(cause);
	}
}
