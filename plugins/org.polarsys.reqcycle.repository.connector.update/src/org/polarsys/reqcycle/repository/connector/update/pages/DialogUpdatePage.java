/*******************************************************************************
 *  Copyright (c) 2013, 2014 AtoS and others
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *  Malick WADE (AtoS) - initial API and implementation and/or initial documentation
 *
 *******************************************************************************/
package org.polarsys.reqcycle.repository.connector.update.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.polarsys.reqcycle.repository.connector.ConnectorDescriptor;
import org.polarsys.reqcycle.repository.connector.IConnector;
import org.polarsys.reqcycle.repository.connector.IConnectorManager;
import org.polarsys.reqcycle.repository.connector.IURIValidatorConnector;
import org.polarsys.reqcycle.repository.connector.update.MutexRule;
import org.polarsys.reqcycle.repository.connector.update.UpdateRequirementSourcesHandler;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.base.Function;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

public class DialogUpdatePage extends TitleAreaDialog {
	// private Text txtResourcePath;
	private List<RequirementSource> reqSources;
	private Map<RequirementSource, String> mapSourcesToModify;
	IConnectorManager connManager = ZigguratInject.make(IConnectorManager.class);
	private Map<Button,Boolean> mapStatus;


	public DialogUpdatePage(Shell parent) {
		super(parent);
		setShellStyle(SWT.SHELL_TRIM);
		this.reqSources = new ArrayList<RequirementSource>();
		this.mapSourcesToModify = new HashMap<RequirementSource, String>();
		mapStatus = new HashMap<Button, Boolean>();
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Requirement updating");
	}

	@Override
	public void create() {
		super.create();
		setTitle("Requirements sources updating");
		setMessage("Change requirements sources paths and click OK for updating ");
	}


	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
		
		
	
		Composite top = new Composite (composite, SWT.None);
		top.setLayout(new GridLayout(2, false));
		top.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(top, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite composite_1 = new Composite(scrolledComposite, SWT.NONE);
		composite_1.setLayout(new GridLayout(1, false));
		
		Multimap<String, RequirementSource> allSourcesByConnector = Multimaps.index(reqSources, new Function<RequirementSource, String>() {

			@Override
			public String apply(RequirementSource arg0) {
				return connManager.get(arg0.getConnectorId()).getName();
			}
		});
		
		for (String connectorId : allSourcesByConnector.keySet()){
			Group group = new Group(composite_1, SWT.NONE);	
			group.setLayout(new GridLayout(3, false));
			group.setText(connectorId);
			group.setLayoutData(new GridData(SWT.FILL, SWT.UP, true, false, 3, 1));
			
			for (RequirementSource rs : allSourcesByConnector.get(connectorId)){
				createGroupWidgets(group, rs);
			}
		}
		
		
		scrolledComposite.setContent(composite_1);
		scrolledComposite.setMinSize(composite_1.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
				return composite;

	}

	private void createGroupWidgets(Group group, RequirementSource rs) {
		builControlLine(group, rs);
	}
	
	private Group builControlLine(Group groupWidgets, final RequirementSource reqSource) {
		
		// creation of label
		Label lblResourceName = new Label(groupWidgets, SWT.NONE);
		lblResourceName.setLayoutData(new GridData(SWT.FILL, SWT.UP, false, false, 1, 1));
		lblResourceName.setText(reqSource.getName() + " : ");

		// creation of Text
		final Text txtResourcePath = new Text(groupWidgets, SWT.BORDER);
		txtResourcePath.setEnabled(false);
		final GridData layoutData = new GridData(SWT.FILL, SWT.UP, true, false, 1, 1);
		layoutData.horizontalIndent = 3 ;
		txtResourcePath.setLayoutData(layoutData);
		txtResourcePath.setText(reqSource.getRepositoryURI());
		mapSourcesToModify.put(reqSource, txtResourcePath.getText());
		txtResourcePath.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				mapSourcesToModify.put(reqSource, txtResourcePath.getText());
			}
		});
		final ControlDecoration controlDec = new ControlDecoration(txtResourcePath,SWT.TOP | SWT.LEFT);

		// creation of browse button
		final Button Browse = new Button(groupWidgets, SWT.NONE);
		Browse.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Browse.setText("...");
		Browse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ResourceDialog dialog = new ResourceDialog(getShell(), "Select a document", SWT.NONE);

				if (Window.OK == dialog.open()) {
					List<URI> uris = dialog.getURIs();
					if (!uris.isEmpty()) {
						URI uri = uris.get(0);
						txtResourcePath.setText(uri.toString());
						Display display = getShell().getDisplay();
						FontData fontData = display.getSystemFont().getFontData()[0];
						txtResourcePath.setFont(new Font(display,fontData.getName(),fontData.getHeight(), SWT.BOLD));

						String idconnect = reqSource.getConnectorId();
						ConnectorDescriptor connectorD = connManager.get(idconnect);
						IConnector createConnector;
						try {
							createConnector = connectorD.createConnector();
							
							if (createConnector instanceof IURIValidatorConnector) {
								IURIValidatorConnector validator = (IURIValidatorConnector) createConnector;
								IStatus status = validator.validate(uri);
								mapStatus.put(Browse, true);
								controlDec.hide();
								if (!status.isOK()){
									setMessage("Some requirements sources paths are not supported. Retry and press OK to update");
									mapStatus.put(Browse, false);
									controlDec.show();
									controlDec.setDescriptionText(status.getMessage());
									if (status.getSeverity() == IStatus.ERROR){
										FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault()
												.getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
										controlDec.setImage(fieldDecoration.getImage());
									}
									else {
										FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault()
												.getFieldDecoration(FieldDecorationRegistry.DEC_WARNING);
										controlDec.setImage(fieldDecoration.getImage());
									}
								}
								
							}
							createConnector.dispose();
						} catch (CoreException e1) {
							e1.printStackTrace();
						}
					
						if (mapStatus != null && mapStatus.containsValue(false)){
							getButton(OK).setEnabled(false);
						}else{
							getButton(OK).setEnabled(true);
							setMessage("All requirements sources paths are supported. Press OK to update");
						}
					}
					
					
				}
			}
		});

		return groupWidgets;
	}

	@Override
	protected void okPressed() {
		super.okPressed();
		Job job = new Job("requirements sources updating") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				UpdateRequirementSourcesHandler updateRequirementSources = new UpdateRequirementSourcesHandler(mapSourcesToModify);
				updateRequirementSources.run(monitor);
				return Status.OK_STATUS;
			}
		};
		job.setRule(MutexRule.INSTANCE);
		job.setUser(true);
		job.schedule();
	}
	
	

	public List<RequirementSource> getReqSources() {
		return reqSources;
	}

	public void setReqSources(List<RequirementSource> reqSources) {
		this.reqSources = reqSources;
	}
}
