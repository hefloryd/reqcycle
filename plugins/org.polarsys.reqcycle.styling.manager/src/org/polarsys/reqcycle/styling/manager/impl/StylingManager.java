/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.styling.manager.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polarsys.reqcycle.styling.manager.Activator;
import org.polarsys.reqcycle.styling.manager.IStylingManager;
import org.polarsys.reqcycle.styling.model.Styling.CaseStyle;
import org.polarsys.reqcycle.styling.model.Styling.Styling;
import org.polarsys.reqcycle.styling.model.Styling.StylingFactory;
import org.polarsys.reqcycle.styling.model.Styling.StylingModel;
import org.polarsys.reqcycle.styling.model.Styling.StylingPredicate;
import org.polarsys.reqcycle.utils.configuration.IConfigurationManager;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Singleton
public class StylingManager implements IStylingManager {

	private static String PREF_ID = Activator.PLUGIN_ID + ".styling";
	private static String PREF_ID_PREFERRED = Activator.PLUGIN_ID + ".styling.preferred";

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

	public void suppressUselessPredicates() {
		CaseStyle caseStyle = null;
		List<CaseStyle> toDelete = Lists.newArrayList();
		for(StylingModel model : currentModel.getModels()) {
			for(CaseStyle style : model.getStyles()) {
				if(style instanceof StylingPredicate) {
					StylingPredicate stylingPredicate = (StylingPredicate)style;
					if (stylingPredicate != null && stylingPredicate.getPredicate() == null) {
						caseStyle = style;
						EList<CaseStyle> casesStyle = model.getStyles();
						toDelete.add(caseStyle);
					}
				}
			}
		}
		for (CaseStyle c : toDelete){
			EcoreUtil.delete(c, true);
		}
		save();
	}
	
	public void save() {
		try {
			confManager.saveConfiguration(Collections.singleton(currentModel), null, null, PREF_ID, null, null);

			Map<String, Object> conf = Maps.newHashMap();
			conf.put(PREF_ID_PREFERRED, preferredStylingModel);
			confManager.saveSimpleConfiguration(conf, null, null, PREF_ID_PREFERRED);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void reload() {
		Collection<EObject> conf = confManager.getConfiguration(null, null, PREF_ID, null, null, true);

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

		Map<String, Object> map = confManager.getSimpleConfiguration(null, null, PREF_ID_PREFERRED, false);
		if (map != null) {
			preferredStylingModel = (String) map.get(PREF_ID_PREFERRED);
		}
	}
}
