package org.polarsys.reqcycle.styling.ui.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.reqcycle.styling.model.Styling.Styling;
import org.polarsys.reqcycle.styling.model.Styling.StylingFactory;
import org.polarsys.reqcycle.styling.ui.Activator;
import org.polarsys.reqcycle.styling.ui.IStylingManager;
import org.polarsys.reqcycle.utils.configuration.IConfigurationManager;

import com.google.common.collect.Maps;

@Singleton
public class StylingManager implements IStylingManager {

	private static String PREF_ID = Activator.PLUGIN_ID + ".styling";
	private static String PREF_ID_PREFERRED = Activator.PLUGIN_ID
			+ ".styling.preferred";

	@Inject
	IConfigurationManager confManager;

	private String preferredStylingModel;

	private Styling currentModel;

	public StylingManager() {
	}

	@PostConstruct
	void postConstruct() {
		reload();
	}

	@Override
	public Styling getStyling() {
		return currentModel;
	}

	@Override
	public void setPreferredStylingModel(String stylingModel) {
		preferredStylingModel = stylingModel;
	}

	@Override
	public String getPreferredStyleModel() {
		return preferredStylingModel;
	}

	public void save() {
		try {
			confManager.saveConfiguration(currentModel, null, null, PREF_ID);

			Map<String, Object> conf = Maps.newHashMap();
			conf.put(PREF_ID_PREFERRED, preferredStylingModel);
			confManager.saveSimpleConfiguration(conf, null, null,
					PREF_ID_PREFERRED);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void reload() {
		Collection<EObject> conf = confManager.getConfiguration(null, null,
				PREF_ID, true);

		if (conf != null && conf.size() != 0) {
			EObject first = conf.iterator().next();
			if (first instanceof Styling) {
				currentModel = (Styling) first;
			} else {
				currentModel = StylingFactory.eINSTANCE.createStyling();
			}
		} else {
			currentModel = StylingFactory.eINSTANCE.createStyling();
		}

		Map<String, Object> map = confManager.getSimpleConfiguration(null,
				null, PREF_ID_PREFERRED, false);
		if (map != null) {
			preferredStylingModel = (String) map.get(PREF_ID_PREFERRED);
		}
	}
}
