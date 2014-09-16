package org.polarsys.reqcycle.impact.ui.providers;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.polarsys.reqcycle.impact.Impact.RequirementImpacted;
import org.polarsys.reqcycle.impact.ui.dialogs.ImpactAnalysisComposites.ImpactContainer;

public class ImpactLabelProvider implements ILabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
	}

	@Override
	public Image getImage(Object element) {
		return null;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof ImpactContainer) {
			return ((ImpactContainer) element).getName();
		} else if (element instanceof RequirementImpacted) {
			return ((RequirementImpacted) element).getId();
		}
		return element.toString();
	}

}
