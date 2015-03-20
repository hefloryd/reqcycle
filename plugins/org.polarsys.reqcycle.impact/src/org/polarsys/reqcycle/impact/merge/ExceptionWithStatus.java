/**
 * Copyright (c) 2014 AtoS
 *     All rights reserved. This program and the accompanying materials
 *     are made available under the terms of the Eclipse Public License v1.0
 *     which accompanies this distribution, and is available at
 *     http://www.eclipse.org/legal/epl-v10.html *
 *     Contributors:
 *       Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.impact.merge;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;

public class ExceptionWithStatus extends Exception implements IAdaptable {

	private static final long serialVersionUID = 474407109912835365L;
	private IStatus status;

	public ExceptionWithStatus(IStatus status) {
		super(StatusUtil.getStatusMessage(status, null));
		this.status = status;
	}

	public ExceptionWithStatus(IStatus status, Throwable cause) {
		super(StatusUtil.getStatusMessage(status, null), cause);
		this.status = status;
	}

	public ExceptionWithStatus(String message) {
		super(message);
	}

	public ExceptionWithStatus(String message, Throwable cause) {
		super(message, cause);
		handleCause(cause);

	}

	public ExceptionWithStatus(Throwable cause) {
		super(cause);
		handleCause(cause);
	}

	protected void handleCause(Throwable cause) {
		if (cause instanceof IAdaptable) {
			Object possibleStatus = ((IAdaptable) cause).getAdapter(IStatus.class);
			if (possibleStatus instanceof IStatus) {
				this.status = (IStatus) possibleStatus;
			}
		}
	}

	public IStatus getStatus() {
		return status;
	}

	@Override
	public Object getAdapter(Class adapter) {
		if (IStatus.class.isAssignableFrom(adapter)) {
			return status;
		}
		return null;
	}
}
