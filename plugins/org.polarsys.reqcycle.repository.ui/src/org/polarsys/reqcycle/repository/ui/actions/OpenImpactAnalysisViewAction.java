package org.polarsys.reqcycle.repository.ui.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.util.DataUtil;
import org.polarsys.reqcycle.repository.ui.views.ImpactView;

public class OpenImpactAnalysisViewAction extends Action {

	private TreeViewer viewer;

	public OpenImpactAnalysisViewAction(TreeViewer viewer) {
		this.viewer = viewer;
	}

	@Override
	public void run() {
		ISelection selection = viewer.getSelection();
		if (selection instanceof IStructuredSelection) {

			Collection<Object> selectedObj = new ArrayList<Object>();
			for (Iterator<?> iterator = ((IStructuredSelection) selection)
					.iterator(); iterator.hasNext();) {
				selectedObj.add(iterator.next());
			}

			Collection<RequirementSource> input = new ArrayList<RequirementSource>();
			for (Iterator<Object> iterator = selectedObj.iterator(); iterator
					.hasNext();) {
				Object obj = iterator.next();
				input.addAll(DataUtil.getRepositories(obj));
			}

			if (!input.isEmpty()) {
				// TODO
				ImpactView.openNewImpactView(input);
			}
		}
	}
}
