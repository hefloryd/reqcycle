package org.polarsys.reqcycle.impact.merge;

import org.eclipse.core.runtime.IStatus;

public class MergerException extends ExceptionWithStatus {

	private static final long serialVersionUID = 923835820755888386L;

	public MergerException(Throwable t) {
		super(t);
	}

	public MergerException(IStatus status) {
		super(status);
	}
}
