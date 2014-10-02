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
package org.polarsys.reqcycle.repository.connector.update.rs.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
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
import org.polarsys.reqcycle.repository.connector.update.rs.IConnectorId;
import org.polarsys.reqcycle.repository.connector.update.rs.UpdateRequirementSourcesHandler;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;

public class DialogUpdatePage extends Dialog {
	// private Text txtResourcePath;
	private List<RequirementSource> reqSources;
	private Map<RequirementSource, String> mapSourcesModified;
	DataBindingContext bindingContext;

	private final String DOC_TITLE = "Document (using .types files)";
	private final String OCL_TITLE = "OCL Connector";
	private final String DOD_OCL_TITLE = "Document (using OCL files)";
	private final String LOCAL_TITLE = "Local";
	private final String REQIF_TITLE = "ReqIF";
	
	
	public DialogUpdatePage(Shell parent) {

		super(parent);
		setShellStyle(SWT.SHELL_TRIM);
		parent.setText("Requirement updating");
		this.reqSources = new ArrayList<RequirementSource>();
		this.mapSourcesModified = new HashMap<RequirementSource, String>();
		bindingContext= new DataBindingContext();
	}


	@Override
	protected Control createContents(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Group groupLocal = null;
		Group groupDocument = null;
		Group groupDocOcl = null;
		Group groupOcl = null;
		Group groupReqIf = null;
		for (RequirementSource rs : reqSources) {
			String idConnector = rs.getConnectorId();
			
			if(idConnector.equals(IConnectorId.ID_OCL_CONNECTOR)){				
				groupOcl = createGroupWidgets(composite, groupOcl, rs, OCL_TITLE);				
				}
			else if (idConnector.equals(IConnectorId.ID_DOC_CONNECTOR)){
				groupDocument = createGroupWidgets(composite, groupDocument, rs, DOC_TITLE);				
				}
			else if (idConnector.equals(IConnectorId.ID_DOC_OCL_CONNECTOR)){				
				groupDocOcl = createGroupWidgets(composite, groupDocOcl, rs, DOD_OCL_TITLE);				
				}
			else if (idConnector.equals(IConnectorId.ID_LOCAL_CONNECTOR)){				
				groupLocal = createGroupWidgets(composite, groupLocal, rs, LOCAL_TITLE);			
				}
			else if (idConnector.equals(IConnectorId.ID_RMF_CONNECTOR)){		
				groupReqIf = createGroupWidgets(composite, groupReqIf, rs, REQIF_TITLE);
				}
			
		}

		Control control = super.createContents(composite);
		control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));

		return control;

	}

	private Group createGroupWidgets(Composite composite, Group group, RequirementSource rs, String title) {
		if(group == null){
			group = new Group(composite, SWT.NONE);	
			group.setLayout(new GridLayout(3, false));
			group.setText(title);
			group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
			
		
		}
		group = builControlLine(group, rs);
		return group;
	}

	private Group builControlLine(Group groupWidgets, final RequirementSource reqSource) {
		
		// creation of label
		Label lblResourceName = new Label(groupWidgets, SWT.NONE);
		lblResourceName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblResourceName.setText(reqSource.getName());

		// creation of Text
		final Text txtResourcePath = new Text(groupWidgets, SWT.BORDER);
		txtResourcePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtResourcePath.setText(reqSource.getRepositoryURI());
		txtResourcePath.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				boolean found = false;

				mapSourcesModified.put(reqSource, txtResourcePath.getText());
			}
		});
		

		// creation of browse button
		Button Browse = new Button(groupWidgets, SWT.NONE);
		Browse.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Browse.setText("...");
		Browse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ResourceDialog dialog = new ResourceDialog(getShell(), "Select a document", SWT.NONE);

				if (Window.OK == dialog.open()) {
					List<URI> uris = dialog.getURIs();
					if (!uris.isEmpty()) {
						txtResourcePath.setText(uris.get(0).toString());
						Display display = getShell().getDisplay();
						FontData fontData = display.getSystemFont().getFontData()[0];
						txtResourcePath.setFont(new Font(display,fontData.getName(),fontData.getHeight(), SWT.BOLD));

						String idconnect = reqSource.getConnectorId();
						if(idconnect.equals(IConnectorId.ID_OCL_CONNECTOR)){	
							//ValidateUriConnector.validateEMFSources(uris.get(0));
							
						}
						else if (idconnect.equals(IConnectorId.ID_DOC_CONNECTOR)){
							
						}
						else if (idconnect.equals(IConnectorId.ID_DOC_OCL_CONNECTOR)){				
							
						}
						else if (idconnect.equals(IConnectorId.ID_LOCAL_CONNECTOR)){				
							
						}
						else if (idconnect.equals(IConnectorId.ID_RMF_CONNECTOR)){		
							
						}
					}
					
					
				}
			}
		});

		/*
		IObservableValue observeTextTxtResourcePathObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtResourcePath);
		IObservableValue uriBeanObserveValue = PojoProperties.value("uri").observe(getBean());
		Binding bind = bindingContext.bindValue(observeTextTxtSelectedDocObserveWidget, uriBeanObserveValue, null, null);
		ControlDecorationSupport.create(bind, SWT.TOP | SWT.LEFT);*/
		return groupWidgets;
	}
	
	protected void dataBindings() {
	
		
	}


	@Override
	protected void okPressed() {
		super.okPressed();
		UpdateRequirementSourcesHandler updateRequirementSources = new UpdateRequirementSourcesHandler(mapSourcesModified);
	}

	public List<RequirementSource> getReqSources() {
		return reqSources;
	}

	public void setReqSources(List<RequirementSource> reqSources) {
		this.reqSources = reqSources;
	}

}
