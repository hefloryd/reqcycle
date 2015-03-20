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
