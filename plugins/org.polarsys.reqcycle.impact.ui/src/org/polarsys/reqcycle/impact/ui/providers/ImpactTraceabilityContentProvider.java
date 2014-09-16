package org.polarsys.reqcycle.impact.ui.providers;

import org.eclipse.jface.viewers.ILazyContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;

public class ImpactTraceabilityContentProvider implements ILazyContentProvider  {
	private TableViewer viewer;

	public ImpactTraceabilityContentProvider(TableViewer viewer) {
		this.viewer = viewer;
	}

	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, final Object newInput) {

	}

	@Override
	public void updateElement(int index) {

	}
}
