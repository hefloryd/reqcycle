/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Abdellah El Ayadi (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.reqcycle.export;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.polarsys.reqcycle.export.model.ReqCycleExport.Export;
import org.polarsys.reqcycle.export.pages.PredicateSelectionPage;
import org.polarsys.reqcycle.export.pages.RequirementSourceSelectionPage;
import org.polarsys.reqcycle.export.pages.WizardController;
import org.polarsys.reqcycle.export.transform.TraceabilityExport;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public abstract class AbstractExportWizard extends Wizard implements IExportWizard {

	protected RequirementSourceSelectionPage rssp;
	protected IWizardPage outputPage;
	protected PredicateSelectionPage predicatePage;
	protected IStructuredSelection selection;
	protected WizardController controller;

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		controller = getController();
		rssp = getSourceSelectionPage();
		addPage(rssp);
		outputPage = getOutputPage(controller);
		addPage(outputPage);
		predicatePage = new PredicateSelectionPage(controller);
		addPage(predicatePage);
		ZigguratInject.inject(rssp, outputPage, predicatePage);

		Iterator iterator = selection.iterator();
		while (iterator.hasNext()) {
			Object o = iterator.next();
			if (o instanceof RequirementSource) {
				RequirementSource source = (RequirementSource) o;
				rssp.select(source);
			}
		}
	}

	protected RequirementSourceSelectionPage getSourceSelectionPage() {
		return new RequirementSourceSelectionPage(controller);
	}

	protected WizardController getController() {
		return new WizardController();
	}

	protected abstract IWizardPage getOutputPage(WizardController controller);

	@Override
	public boolean performFinish() {
		try {
			getContainer().run(false, true, new IRunnableWithProgress() {

				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					try {
						monitor.beginTask("Export", 10);
						SubProgressMonitor monitor2 = new SubProgressMonitor(monitor, 9);
						Export export = new TraceabilityExport().transform(controller.getReqResult(), controller.getPredicateResult(), controller.getProjectsResult(), isExportTraceability(), controller.getOutputPath(), monitor2);
						SubProgressMonitor monitor3 = new SubProgressMonitor(monitor, 1);
						doTransform(export, monitor3);
					} catch (Exception e) {
						throw new InvocationTargetException(e);
					}
				}
			});
		} catch (InvocationTargetException e) {
			error(e.getCause());
			e.printStackTrace();
			return false;
		} catch (InterruptedException e) {
			error(e);
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			error(e);
			e.printStackTrace();
			return false;
		}
		return true;
	}

	protected void error(Throwable e) {
		if (getContainer().getCurrentPage() instanceof WizardPage) {
			WizardPage page = (WizardPage) getContainer().getCurrentPage();
			page.setErrorMessage(e.getMessage());
		}
	}

	protected abstract boolean isExportTraceability();

	protected abstract void doTransform(Export models, IProgressMonitor monitor) throws Exception;

}
