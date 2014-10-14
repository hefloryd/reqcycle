/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Abdellah El Ayadi (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.reqcycle.export.rmf.wizard;

import java.net.MalformedURLException;
import java.util.Iterator;

import org.eclipse.core.resources.IContainer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.polarsys.reqcycle.export.rmf.page.WizardController;
import org.polarsys.reqcycle.export.rmf.transform.ReqIFExport;

public class ReqIFExportWizard extends Wizard implements IExportWizard {

	private WizardController controller;
	private RequirementSourceSelectionPage requirementSourceSelectionPage;

	public ReqIFExportWizard() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
		controller = getController();
		requirementSourceSelectionPage = new RequirementSourceSelectionPage(controller);
		addPage(requirementSourceSelectionPage);

		Iterator iterator = selection.iterator();
		while (iterator.hasNext()) {
			Object o = iterator.next();
			if (o instanceof IContainer) {
				IContainer container = (IContainer) o;
				try {
					controller.setOutputUri(URI.createFileURI(container.getLocationURI().toURL().getFile() + "/output.reqif"));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public boolean performFinish() {
		try {
			ReqIFExport export = new ReqIFExport(controller);
			export.transform();
		}
		catch (Exception e){
			if (getContainer().getCurrentPage() instanceof WizardPage) {
				WizardPage page = (WizardPage) getContainer().getCurrentPage();
				if (e.getMessage() != null){
					page.setErrorMessage(e.getMessage());
				}
				return false;
			}
		}
		return true;
	}

	protected WizardController getController() {
		return new WizardController();
	}

}
