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

public class StatusUtil {

	public static String getStatusMessage(IStatus status, String prefix) {

		String message = status.getMessage();
		int severity = status.getSeverity();

		String statusMsg;
		switch (severity) {
		case IStatus.ERROR:
			statusMsg = "[Error] ";
			break;
		case IStatus.WARNING:
			statusMsg = "[Warning] ";
			break;
		default:
			statusMsg = "";
			break;
		}
		statusMsg += message;

		if (prefix != null)
			statusMsg = prefix + statusMsg;

		// print out children as well
		IStatus[] children = status.getChildren();
		if (children.length != 0) {
			String newPrefix;
			if (prefix == null)
				newPrefix = "\t "; //$NON-NLS-1$
			else
				newPrefix = prefix + "\t "; //$NON-NLS-1$
			for (int i = 0; i < children.length; i++) {
				statusMsg += "\n" + getStatusMessage(children[i], newPrefix);
			}
		}
		return statusMsg;

	}

}
