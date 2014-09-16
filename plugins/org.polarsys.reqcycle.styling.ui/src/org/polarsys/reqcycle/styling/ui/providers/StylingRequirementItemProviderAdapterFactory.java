package org.polarsys.reqcycle.styling.ui.providers;

import org.eclipse.emf.edit.provider.IItemLabelProvider;

public class StylingRequirementItemProviderAdapterFactory extends org.polarsys.reqcycle.repository.data.RequirementSourceData.provider.RequirementSourceDataItemProviderAdapterFactory {

	StylingLabelProvider labelP = new BasicStylingLabelProvider();

	@Override
	public Object adapt(Object object, Object type) {
		if (IItemLabelProvider.class.equals(type)) {
			return new IItemLabelProvider() {

				@Override
				public String getText(Object object) {
					return labelP.getText(object);
				}

				@Override
				public Object getImage(Object object) {
					return labelP.getImage(object);
				}
			};
		}
		// TODO Auto-generated method stub
		return super.adapt(object, type);
	}

}
