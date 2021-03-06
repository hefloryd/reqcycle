/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.core.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.polarsys.reqcycle.core.ILogger;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

public class InitializeConfigurationHandler extends AbstractHandler {

	protected String reqCyclePrefix = "org.polarsys.reqcycle";

	ILogger logger = ZigguratInject.make(ILogger.class);

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		initializeConf();
		return null;
	}

	protected void initializeConf() {
		boolean msg = MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "ReqCycle initialization", "- All current ReqCycle Data will be lost \n- The platform have to be restarted after this initialization.\n\nWould you continue?");
		if (!msg) {
			return;
		}

		IPath confFilePath = org.polarsys.reqcycle.utils.configuration.Activator.getDefault().getStateLocation();
		URI folderURI = URI.createURI(confFilePath.toOSString());
		cleanFolder(folderURI, reqCyclePrefix);

		byte[] buffer = new byte[1024];
		try {
			FileDialog dialog = new FileDialog(Display.getDefault().getActiveShell(), SWT.OPEN);
			String uri;
			if ((uri = dialog.open()) != null) {
				final File f = new File(uri);
				FileInputStream fileInputStream;
				fileInputStream = new FileInputStream(f);
				ZipInputStream inputStream = new ZipInputStream(fileInputStream);
				ZipEntry entry = inputStream.getNextEntry();
				while (entry != null) {
					String fileName = entry.getName();
					File newFile = new File(org.polarsys.reqcycle.utils.configuration.Activator.getDefault().getStateLocation() + File.separator + fileName);

					// create all non exists folders
					// else you will hit FileNotFoundException for compressed folder
					if (newFile.getParent() != null) {
						new File(newFile.getParent()).mkdirs();
					}
					FileOutputStream fos = new FileOutputStream(newFile);

					int len;
					while ((len = inputStream.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}

					fos.close();
					entry = inputStream.getNextEntry();
				}
				inputStream.close();
				MessageDialog.openInformation(Display.getDefault().getActiveShell(), "ReqCycle Initialization", "Please restart the platform for changes to take effect.");
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	protected void cleanFolder(URI folderURI, String namePrefix) {
		File folder = new File(folderURI.toString());
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile() && file.getName().startsWith(namePrefix)) {
				String msg = "file " + file.getName() + " has been deleted";
				if (file.delete()) {
					logger.trace(msg);
				}
			}
		}
	}

}
