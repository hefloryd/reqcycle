/*******************************************************************************
 *  Copyright (c) 2013, 2014 AtoS and others
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Olivier Melois (AtoS) - initial API and implementation and/or initial documentation
 *    Raphael Faudou (Samares Engineering) - Fixed some bugs in OCL connector to manage types and align
 * 		connector on other connectors with a destination file
 *******************************************************************************/
package org.polarsys.reqcycle.ocl.ui;

import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.polarsys.reqcycle.emf.utils.EMFUtils;
import org.polarsys.reqcycle.ocl.ReqcycleOCLPlugin;
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.AbstractSettingPage;

public class SettingPage extends AbstractSettingPage {

	private Button browseButton;

	private Text tFile;

	protected SettingPage(SettingBean bean) {
		super("OCL Connector settings", bean);
		setDescription("Connector settings");
		setTitle("Connector OCL: settings page");

	}

	@Override
	protected Composite doCreateSpecific(Composite parent) {
		Composite containerComposite = parent;
		containerComposite.setLayout(new GridLayout(4, false));
		Label fileLabel = new Label(containerComposite, SWT.NONE);
		fileLabel.setText("EMF Model :");

		tFile = new Text(containerComposite, SWT.BORDER | SWT.READ_ONLY);
		tFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		tFile.setEnabled(false);
		browseButton = new Button(containerComposite, SWT.NONE);
		browseButton.setText("Browse");

		setControl(containerComposite);
		return containerComposite;
	}

	@Override
	protected void hookListeners() {
		super.hookListeners();

		getDestinationFileSelectionListener();

		browseButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				ResourceDialog dialog = new ResourceDialog(getShell(), "Select a model", SWT.NONE);
				int res = dialog.open();
				if (res == ResourceDialog.OK) {
					List<URI> uris = dialog.getURIs();
					if (!uris.isEmpty()) {
						URI uri = uris.get(0);
						Set<String> EXTENSIONS = OCLConnector.loadExtensions();
						String extension = uri.path().substring(uri.path().lastIndexOf(".")+1, uri.path().length());				
						if (EXTENSIONS.contains(extension.toLowerCase())){
							tFile.setText(uris.get(0).toString());
						}else{
							tFile.setText("");
							setErrorMessage("Your document is not supported. Retry and choose EMF file");
						}
					
					}
				}
			}
		});

	}
	
	@Override
	public boolean isPageComplete() {
		boolean result = super.isPageComplete();
		String msg = getErrorMessage();
		if (msg == null) {
			msg = "";
		}
		if (tFile.getText() == null || tFile.getText() == "") {
			result = false;
			msg += "Choose an EMF model \n";
		} else {
			String uriString = tFile.getText();
			if (uriString != null && !uriString.isEmpty()) {
				URI uri = URI.createURI(uriString);
				if (!EMFUtils.isEMF(uri, false)) {
					result = false;
					msg += "Selected file is not an EMF resource\n";
				}
			}
		}

		if (!result) {
			setErrorMessage(msg);
		}
		return result;
	}

	/**
	 * Label provider for the workspace resource dialog.
	 */
	protected static ILabelProvider labelProvider = new WorkbenchLabelProvider() {

		@Override
		public Color getForeground(Object element) {
			return Display.getDefault().getSystemColor(SWT.COLOR_BLACK);
		}

		@Override
		public Color getBackground(Object element) {
			return Display.getDefault().getSystemColor(SWT.COLOR_WHITE);
		}
	};

	protected static ViewerFilter filter = new ViewerFilter() {

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			return true;
		}
	};

	protected static ISelectionStatusValidator validator = new ISelectionStatusValidator() {

		@Override
		public IStatus validate(Object[] selection) {
			if (selection.length == 1) {
				Object o = selection[0];
				// RFa we do not want to restrict to UML files
				if (o instanceof IFile) {
					URI uri = URI.createPlatformResourceURI(((IFile) o).getFullPath().toOSString(), true);
					if (EMFUtils.isEMF(uri, false)) {
						return Status.OK_STATUS;
					}
				}
			}
			return new Status(IStatus.ERROR, ReqcycleOCLPlugin.PLUGIN_ID, "Select a single EMF file");
		}
	};

	protected void doSpecificInitDataBindings(DataBindingContext bindingContext) {

		IObservableValue observeTextFileURITextObserveWidget = WidgetProperties.text(SWT.Modify).observe(tFile);
		IObservableValue uriBeanObserveValue = PojoProperties.value("uri").observe(getBean());
		bindingContext.bindValue(observeTextFileURITextObserveWidget, uriBeanObserveValue, null, null);
	}


}
