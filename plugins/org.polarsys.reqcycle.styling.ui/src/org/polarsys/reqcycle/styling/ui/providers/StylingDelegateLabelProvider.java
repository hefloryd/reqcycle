package org.polarsys.reqcycle.styling.ui.providers;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.polarsys.reqcycle.repository.data.MappingModel.provider.IDelegateLabelProvider;

public class StylingDelegateLabelProvider implements IDelegateLabelProvider {

	private BasicStylingLabelProvider lp = new BasicStylingLabelProvider();

	@Override
	public Image getImage(Object element) {
		return lp.getImage(element);
	}

	@Override
	public String getText(Object element) {
		return lp.getText(element);
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		lp.addListener(listener);
	}

	@Override
	public void dispose() {
		lp.dispose();
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return lp.isLabelProperty(element, property);
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		lp.removeListener(listener);
	}

}
