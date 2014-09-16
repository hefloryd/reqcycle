/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/

package org.polarsys.reqcycle.repository.connector.ui.providers;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.polarsys.reqcycle.repository.connector.ConnectorDescriptor;

/**
 * Connector Label Provider
 */
public class ConnectorLabelProvider extends LabelProvider {

	@Override
	public String getText(Object obj) {
		if (obj instanceof ConnectorDescriptor) {
			return ((ConnectorDescriptor) obj).getName();
		}
		return obj.toString();
	}

	@Override
	public Image getImage(Object obj) {
		if (obj instanceof ConnectorDescriptor) {
			ConnectorDescriptor desc = (ConnectorDescriptor) obj;
			return createImage(desc, 15, 15);
		}
		return null;
	}

	public static Image createImage(ConnectorDescriptor connector, int width, int height) {
		ImageDescriptor imageDescriptor = connector.getImageDescriptor();
		if (imageDescriptor == null) {
			return null;
		}
		Image image = imageDescriptor.createImage();
		Image scaled = new Image(Display.getDefault(), width, height);
		GC gc = new GC(scaled);
		gc.setAntialias(SWT.ON);
		gc.setInterpolation(SWT.HIGH);
		gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 0, 0, width, height);
		gc.dispose();
		image.dispose();
		return scaled;
	}

}
