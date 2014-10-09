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
import java.util.Map.Entry;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.polarsys.reqcycle.impact.Impact.ImpactAnalysis;
import org.polarsys.reqcycle.impact.ui.dialogs.ImpactAnalysisComposites;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;

public class DialogImpactAnalysis extends TitleAreaDialog {

	ImpactAnalysisComposites impactComposites;
	ImpactAnalysis analysis;
	private Table tableReqSources;
	Map<RequirementSource, String> inputReqSourcesMap;
	Map<RequirementSource, ImpactAnalysis> reqSourceWithImpAnalysis;
	// this map contains the final requirements sources selected in window DialogUpdatePage
	private Map<RequirementSource, ImpactAnalysis> finalMapReqSourcesWithImpactAna;

	CheckboxTableViewer cbReqSourceTv;
	List<String> selections;


	public DialogImpactAnalysis(Shell parentShell, Map<RequirementSource, String>  inputReqMap) {
		super(parentShell);
		setShellStyle(SWT.SHELL_TRIM);
		impactComposites = new ImpactAnalysisComposites();
		this.inputReqSourcesMap = inputReqMap;
		reqSourceWithImpAnalysis = new  HashMap<RequirementSource, ImpactAnalysis>();
		finalMapReqSourcesWithImpactAna = new HashMap<RequirementSource, ImpactAnalysis>();
	}
	
	
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Finalization of the update");
	}

	@Override
	public void create() {
		super.create();
		setTitle("Requirements sources updating");
		setMessage("Select requirements sources and click OK to complete the update");
	}

	
	
	@Override
	protected Control createDialogArea(Composite parent) {

		Composite composite = new Composite(parent,SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite.setLayout(new GridLayout(1, false));
		
		cbReqSourceTv = CheckboxTableViewer.newCheckList(composite, SWT.BORDER | SWT.FULL_SELECTION);
	
		tableReqSources = cbReqSourceTv.getTable();
		GridData gd_tableReqSources = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		gd_tableReqSources.heightHint = 92;
		tableReqSources.setLayoutData(gd_tableReqSources);
		cbReqSourceTv.setContentProvider(ArrayContentProvider.getInstance());
		cbReqSourceTv.setLabelProvider(new TableLabelProvider(){
			@Override
			public String getText(Object element) {
				if(element instanceof RequirementSource){
					return ((RequirementSource) element).getName();
				}
				return super.getText(element);
			}
		});
		
		cbReqSourceTv.setInput(inputReqSourcesMap.keySet());
		cbReqSourceTv.setAllChecked(true);
		
		cbReqSourceTv.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();

				if (selection instanceof IStructuredSelection) {
					Object obj = ((IStructuredSelection) selection).getFirstElement();
					if (obj != null && obj instanceof RequirementSource) {
						for( Entry<RequirementSource, ImpactAnalysis> rsImpAna : reqSourceWithImpAnalysis.entrySet()){
							if(rsImpAna.getKey().getName().equals(((RequirementSource) obj).getName())){
								ImpactAnalysis impactAnalysis = rsImpAna.getValue();
								impactComposites.setImpactResult(impactAnalysis.getRequirementsAdded(), impactAnalysis.getRequirementsDeleted(), impactAnalysis.getRequirementsModified());								
							}
						}
					
					}
				}
			}
		});
		
		cbReqSourceTv.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {			
				getSelectedElements();
			}
		});
		
		selections = new ArrayList<String>();
		getSelectedElements();
		
		Composite impactComposite = new Composite (composite, SWT.BORDER);
		impactComposite.setLayout(new GridLayout());
		impactComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		impactComposites.createImpactComposite(impactComposite);
		
		Button btnSaveAnalysis = new Button(impactComposite, SWT.NONE);
		btnSaveAnalysis.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				ContainerSelectionDialog dialog = new ContainerSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), true, "select location for save");
				URI destinationPath = null;
				if (Window.OK == dialog.open()) {
					Object[] result = dialog.getResult();
					if (result != null && result.length > 0) {
						if (result[0] instanceof IPath) {
							IPath path = (IPath) result[0];
							destinationPath = URI.createPlatformResourceURI(path.toString(), true);
						}
					}
				}

				if (destinationPath != null) {
					// transmit a selected requirements
					finalMapReqSourcesWithImpactAna.clear();
					finalMapReqSourcesWithImpactAna = getSelectedRequirementSrc(selections, reqSourceWithImpAnalysis);
					// save impact analysis of selected requirements sources
					for (Map.Entry<RequirementSource, ImpactAnalysis> finalMap : finalMapReqSourcesWithImpactAna.entrySet()) {
						finalMap.getValue().saveAnalysis(destinationPath);
					}

				}
			}
		});
		
		btnSaveAnalysis.setToolTipText("");
		btnSaveAnalysis.setAlignment(SWT.RIGHT);
		btnSaveAnalysis.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		btnSaveAnalysis.setText("Save impacts analysis");
	
		return composite;
	}
	
	private void getSelectedElements() {
		selections.clear();
		Object[] listSlectReq = cbReqSourceTv.getCheckedElements();
		for (Object obj : listSlectReq){
			selections.add(((RequirementSource) obj).getName());			
		}
	}


	public ImpactAnalysisComposites getImpactComposites() {
		return impactComposites;
	}

	public void setImpactComposites(ImpactAnalysisComposites impactComposites) {
		this.impactComposites = impactComposites;
	}

	public ImpactAnalysis getAnalysis() {
		return analysis;
	}

	public void setAnalysis(ImpactAnalysis analysis) {
		this.analysis = analysis;
	}
	
	
	public Map<RequirementSource, ImpactAnalysis> getReqSourceWithImpAnalysis() {
		return reqSourceWithImpAnalysis;
	}


	public void setReqSourceWithImpAnalysis(Map<RequirementSource, ImpactAnalysis> reqSourceWithImpAnalysis) {
		this.reqSourceWithImpAnalysis = reqSourceWithImpAnalysis;
	}
	
	public Map<RequirementSource, ImpactAnalysis> getFinalMapReqSourcesWithImpactAna() {
		return finalMapReqSourcesWithImpactAna;
	}


	public void setFinalMapReqSourcesWithImpactAna(Map<RequirementSource, ImpactAnalysis> finalMapReqSourcesWithImpactAna) {
		this.finalMapReqSourcesWithImpactAna = finalMapReqSourcesWithImpactAna;
	}


	
	@Override
	protected void okPressed() {
		super.okPressed();
		//transmit a selected requirements
		finalMapReqSourcesWithImpactAna.clear();
		finalMapReqSourcesWithImpactAna = getSelectedRequirementSrc(selections, reqSourceWithImpAnalysis);		
	}


	private Map<RequirementSource, ImpactAnalysis> getSelectedRequirementSrc(List<String> selectItems, Map<RequirementSource, ImpactAnalysis> reqSrcImpacts) {
		Map<RequirementSource, ImpactAnalysis> finalMap = new HashMap<RequirementSource, ImpactAnalysis>();
		if ( selectItems != null){
			for( Entry<RequirementSource, ImpactAnalysis> mapFinal : reqSrcImpacts.entrySet()){			
				if(selectItems.contains(mapFinal.getKey().getName())){
					finalMap.put(mapFinal.getKey(), mapFinal.getValue());
				}
			}
		}
		return finalMap;	
	}
	
	private class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}
		public String getColumnText(Object element, int columnIndex) {
			return element.toString();
		}
	}
	private static class ContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			return new Object[0];
		}
		public void dispose() {
		}
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}
}
