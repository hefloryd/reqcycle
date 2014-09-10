package org.polarsys.reqcycle.traceability.storage.sesame.exceptions;

import org.polarsys.reqcycle.traceability.storage.sesame.storage.SesameTraceabilityStorage;

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
