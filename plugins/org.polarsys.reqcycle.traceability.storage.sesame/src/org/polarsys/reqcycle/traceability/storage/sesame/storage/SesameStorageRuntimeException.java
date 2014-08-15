/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.storage.sesame.storage;

/**
 * Unchecked exception raised when internal errors in
 * {@link SesameTraceabilityStorage} and related classes occurs.
 * 
 * @author rsemlal
 */
public class SesameStorageRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 144291525587554615L;

	public SesameStorageRuntimeException() {
		super();
	}

	public SesameStorageRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public SesameStorageRuntimeException(String message) {
		super(message);
	}

	public SesameStorageRuntimeException(Throwable cause) {
		super(cause);
	}

}
