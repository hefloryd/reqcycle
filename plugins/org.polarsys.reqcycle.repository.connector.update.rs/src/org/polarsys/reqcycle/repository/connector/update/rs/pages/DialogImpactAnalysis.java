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

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.polarsys.reqcycle.impact.Impact.ImpactAnalysis;
import org.polarsys.reqcycle.impact.Impact.ImpactFactory;
import org.polarsys.reqcycle.impact.ui.dialogs.ImpactAnalysisComposites;

public class DialogImpactAnalysis extends Dialog {
	ImpactAnalysisComposites impactComposites;
	ImpactAnalysis analysis;




	public DialogImpactAnalysis(Shell parentShell, ImpactAnalysis analysis) {
		super(parentShell);
		setShellStyle(SWT.SHELL_TRIM);
		impactComposites = new ImpactAnalysisComposites();
		this.analysis = analysis;
	}
	
	@Override
	protected Control createContents(Composite parent) {

		Composite composite = (Composite) super.createDialogArea(parent);		
		//Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite.setLayout(new GridLayout(1, false));

		composite = impactComposites.createImpactComposite(composite);
		impactComposites.setImpactResult(analysis.getRequirementsAdded(), analysis.getRequirementsDeleted(), analysis.getRequirementsModified());
		
		Control control = super.createContents(composite);
		control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 3,1));

		return control;
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
	
	@Override
	protected void okPressed() {
		super.okPressed();
	}
}
