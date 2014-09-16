package org.polarsys.reqcycle.impact.ui.providers;

import java.util.Collection;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.polarsys.reqcycle.impact.ui.dialogs.ImpactAnalysisComposites.ImpactContainer;

public class ImpactContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Collection) {
			return ((Collection) inputElement).toArray();
		}
		return null;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof ImpactContainer) {
			return ((ImpactContainer) parentElement).getReqList().toArray();
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof ImpactContainer) {
			return ((ImpactContainer) element).getReqList().size() != 0;
		}
		return false;
	}
}
