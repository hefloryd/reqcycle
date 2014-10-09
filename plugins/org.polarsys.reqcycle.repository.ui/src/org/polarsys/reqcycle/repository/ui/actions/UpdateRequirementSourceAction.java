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
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;
import org.polarsys.reqcycle.repository.connector.update.rs.pages.DialogUpdatePage;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;

public class UpdateRequirementSourceAction extends Action {

	private TreeViewer viewer;

	/** Requirement Source Manager */
	@Inject
	IDataManager requirementSourceManager;

	private List<RequirementSource> requirementsSources;
	// action come in context menu
	Boolean isContextMenuAction = false;

	public UpdateRequirementSourceAction(TreeViewer viewer, Boolean isContexMenuAction) {
		super();
		this.viewer = viewer;
		this.isContextMenuAction = isContexMenuAction;
	}

	@Override
	public void run() {
		super.run();

		requirementsSources = new ArrayList<RequirementSource>();
		if (isContextMenuAction) {
			TreeItem[] selections = viewer.getTree().getSelection();

			if (selections != null) {
				for (TreeItem sel : selections) {
					if (sel.getData() instanceof RequirementSource) {
						requirementsSources.add((RequirementSource) sel.getData());
					}
				}
			}
		} else {

			Set<RequirementSource> listReqSources = requirementSourceManager.getRequirementSources();

			for (RequirementSource rs : listReqSources) {
				if (rs instanceof RequirementSource) {
					requirementsSources.add(rs);
				}
			}
		}

		if ((requirementsSources != null) && (requirementsSources.size() > 0)) {
			Shell shell = Display.getDefault().getActiveShell();

			DialogUpdatePage updatePage = new DialogUpdatePage(shell);
			updatePage.setReqSources(requirementsSources);
			updatePage.open();

		}
	}

	public Boolean getIsContextMenu() {
		return isContextMenuAction;
	}

	public void setIsContextMenu(Boolean isContextMenu) {
		this.isContextMenuAction = isContextMenu;
	}
}
