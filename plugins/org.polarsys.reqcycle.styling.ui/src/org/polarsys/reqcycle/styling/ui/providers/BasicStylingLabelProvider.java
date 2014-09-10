package org.polarsys.reqcycle.styling.ui.providers;

import javax.inject.Inject;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.predicates.ui.providers.PredicatesItemProviderAdapterFactory;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.styling.model.Styling.CaseStyle;
import org.polarsys.reqcycle.styling.model.Styling.StylingModel;
import org.polarsys.reqcycle.styling.model.Styling.StylingPredicate;
import org.polarsys.reqcycle.styling.ui.IStylingManager;
import org.polarsys.reqcycle.styling.ui.dialogs.IconRegistry;
import org.polarsys.reqcycle.styling.ui.providers.StylingLabelProvider.StylingAdapter;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class BasicStylingLabelProvider extends StylingLabelProvider {

	@Inject
	IStylingManager manager;

	public BasicStylingLabelProvider() {
		super();
		ZigguratInject.inject(this);
	}
	
	@Override
	public Image getImage(Object object) {
		if (object instanceof RequirementSource) {
			return null;
		} else if (object instanceof IPredicate) {
			PredicatesItemProviderAdapterFactory factory = new PredicatesItemProviderAdapterFactory();
			return new AdapterFactoryLabelProvider(factory).getImage(object);
		} else {
			StylingModel model = getStylingModel();
			if (model != null) {
				if (model.getBasic() != null) {
					return IconRegistry.getImage(model.getBasic().getIcon()
							.getImage());
				}
			}
			return null;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> T getText(Object element, Class<T> theClass) {
		if (element instanceof EObject) {
			EObject eobject = (EObject) element;
			if (!containsAdapter(eobject)) {
				eobject.eAdapters().add(new StylingAdapter());
			}
		}

		if (element instanceof RequirementSource) {
			String label = ((RequirementSource) element).getRepositoryUri();
			if (label == null) {
				label = ((RequirementSource) element).getName();
			} else {
				label = ((RequirementSource) element).getName() + " [" + label
						+ "]";
			}
			return toT(label, theClass);
		} else {
			StylingModel model = getStylingModel();
			if (model != null) {
				if (model.getBasic() != null) {
					if (StyledString.class.equals(theClass)){
						return (T) applyStyle(element, model.getBasic());
					}
					else {
						StyledString s = applyStyle(element, model.getBasic());
						return (T) s.getString();
					}
				}
			}
		}
		return toT(element.toString(), theClass);
	}
}
