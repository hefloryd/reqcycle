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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.polarsys.reqcycle.prefs.ui.ReqcyclePrefsExportWizard;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

/**
 * The Class ExportConfigurationHandler.
 */
public class ExportConfigurationHandler extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ReqcyclePrefsExportWizard wizard = new ReqcyclePrefsExportWizard();
		ZigguratInject.inject(wizard);
		Shell shell = Display.getDefault().getActiveShell();
		WizardDialog wd = new WizardDialog(shell, wizard);
		wd.setHelpAvailable(false);
		wd.open();
		
		return null;
	}

}
