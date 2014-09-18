/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Abdellah El Ayadi (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.reqcycle.export.xls.wizard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.acceleo.engine.AcceleoEvaluationException;
import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.IWorkbench;
import org.polarsys.reqcycle.export.AbstractExportWizard;
import org.polarsys.reqcycle.export.model.ReqCycleExport.Export;
import org.polarsys.reqcycle.export.model.ReqCycleExport.Model;
import org.polarsys.reqcycle.export.pages.RequirementSourceSelectionPage;
import org.polarsys.reqcycle.export.pages.WizardController;
import org.polarsys.reqcycle.export.xls.acceleo.Generate;
import org.polarsys.reqcycle.export.xls.acceleo.GenerateCSV;
import org.polarsys.reqcycle.export.xls.wizard.pages.ExcelOutputPage;
import org.polarsys.reqcycle.export.xls.wizard.pages.SourceAndExtensionSelectionPage;

import com.google.common.base.CharMatcher;

public class TraceabilityExportWizard extends AbstractExportWizard {

	private static final CharMatcher ALNUM = CharMatcher.inRange('a', 'z').or(CharMatcher.inRange('A', 'Z')).or(CharMatcher.inRange('0', '9')).or(CharMatcher.WHITESPACE).precomputed();

	private ExcelOutputPage excelOutputPage;

	@Override
	protected IWizardPage getOutputPage(WizardController controller) {
		excelOutputPage = new ExcelOutputPage(controller);
		return excelOutputPage;
	}

	@Override
	protected boolean isExportTraceability() {
		return controller.getProjectsResult().size() != 0;
	}

	@Override
	protected WizardController getController() {
		return new ExcelController();
	}

	@Override
	protected RequirementSourceSelectionPage getSourceSelectionPage() {
		return new SourceAndExtensionSelectionPage(controller);
	}

	@Override
	protected void doTransform(Export export, IProgressMonitor monitor) throws Exception {
		try {
			String path = export.getPath();
			File f = new File(path);
			if (f.exists()) {
				try {
					FileChannel channel = new RandomAccessFile(f, "rw").getChannel();
					channel.close();
				} catch (FileNotFoundException e) {
					throw new Exception("the file can't be written, verify if the file is not opened");
				}

			}
			for (Model m : export.getModels()) {
				m.setName(trim(m.getName()));
			}
			String folder = path.substring(0, path.lastIndexOf("/"));
			export.setPath(path.substring(path.lastIndexOf("/") + 1, path.length()));
			AbstractAcceleoGenerator g = getGenerator(export, folder);
			g.generate(BasicMonitor.toMonitor(monitor));
			IContainer iFolder = ResourcesPlugin.getWorkspace().getRoot().getContainerForLocation(new Path(folder));
			if (iFolder != null && iFolder.exists()) {
				iFolder.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
			}
		} catch (AcceleoEvaluationException e) {
			throw new Exception(e);
		}
	}

	protected AbstractAcceleoGenerator getGenerator(Export export, String folder) throws IOException {
		if (export.getPath().endsWith("xls")) {
			return new Generate(export, new File(folder), new LinkedList<Object>());
		} else if (export.getPath().endsWith("csv")) {
			return new GenerateCSV(export, new File(folder), new LinkedList<Object>());
		}
		return null;
	}

	private String trim(String name) {
		return ALNUM.negate().removeFrom(name);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		Iterator iterator = selection.iterator();
		while (iterator.hasNext()) {
			Object o = iterator.next();
			if (o instanceof IContainer) {
				IContainer container = (IContainer) o;
				try {
					controller.setOutputPath(container.getLocationURI().toURL().getFile() + "/output.xls");
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
