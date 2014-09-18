/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Abdellah El Ayadi (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.reqcycle.export.xls.wizard.pages;

import org.polarsys.reqcycle.export.pages.AbstractScopeAndOutputPage;
import org.polarsys.reqcycle.export.pages.WizardController;
import org.polarsys.reqcycle.export.xls.wizard.ExcelController;

public class ExcelOutputPage extends AbstractScopeAndOutputPage {

	public ExcelOutputPage(WizardController controller) {
		super(controller);
	}

	@Override
	protected void doWidgetSelected() {

	}

	@Override
	protected String[] getAllowedExtensions() {
		return ExcelController.EXTENSIONS;
	}

	@Override
	protected String getFileDialogTitle() {
		return "Select Output file (xls, csv):";
	}

	@Override
	protected String getCurrentExtension() {
		return ((ExcelController) controller).getExtension();
	}

}
