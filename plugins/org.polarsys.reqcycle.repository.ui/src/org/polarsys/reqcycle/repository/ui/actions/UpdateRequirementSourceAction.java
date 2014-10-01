/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *  Malick WADE (AtoS) - Initial implementation of update requirement action
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.repository.ui.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.polarsys.reqcycle.repository.connector.update.rs.pages.DialogUpdatePage;
//import org.polarsys.reqcycle.repository.connector.update.rs.pages.DialogUpdatePage;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;

public class UpdateRequirementSourceAction extends Action {

	private TreeViewer viewer;

	/** Requirement Source Manager */
	@Inject
	IDataManager requirementSourceManager;

	private List<RequirementSource> requirementsSources;

	public UpdateRequirementSourceAction(TreeViewer viewer) {
		super();
		this.viewer = viewer;
	}

	@Override
	public void run() {
		super.run();
		requirementsSources = new ArrayList<RequirementSource>();
		ISelection selection = viewer.getSelection();
		Set<RequirementSource> listReqSources = requirementSourceManager.getRequirementSources();

		for (RequirementSource rs : listReqSources) {
			if (rs instanceof RequirementSource) {
				requirementsSources.add(rs);
			}
		}

		Shell shell = Display.getDefault().getActiveShell();

		DialogUpdatePage updatePage = new DialogUpdatePage(shell);
		updatePage.setReqSources(requirementsSources);
		updatePage.open();
	}
}
