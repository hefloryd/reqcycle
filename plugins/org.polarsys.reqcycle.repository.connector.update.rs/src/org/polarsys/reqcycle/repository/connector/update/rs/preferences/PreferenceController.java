/*******************************************************************************
 *  Copyright (c) 2013, 2014 AtoS and others
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *  Malick WADE (AtoS) - initial API and implementation and/or initial documentation
 *
 *******************************************************************************/
package org.polarsys.reqcycle.repository.connector.update.rs.preferences;

import java.io.IOException;
import java.util.Map;

import org.eclipse.jface.resource.StringConverter;
import org.polarsys.reqcycle.repository.connector.update.rs.Activator;
import org.polarsys.reqcycle.utils.configuration.IConfigurationManager;
import org.polarsys.reqcycle.utils.configuration.IConfigurationManager.Scope;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Maps;

public class PreferenceController {
	
	static IConfigurationManager manager = ZigguratInject.make(IConfigurationManager.class);
	
	private static int DEFAULT_REFRESH_TIME = 5 ;
	public static String PREF_MODEL = "PREF_MODEL" ;
	public static String PREF_IMPACT_ANALYSIS = "IMPACT_ANALYSIS" ;
	public static String PREF_IS_IMPACT_ANALYSIS = "IS_IMPACT_ANALYSIS" ;
	public static String PREF_REFRESH_TIME = "REFRESH_TIME" ;
	
	public static String getPathForImpactAnalysis(){
		return getPref(PREF_IMPACT_ANALYSIS);
	}
	
	public static boolean isImpactAnalysis () {
		final Boolean res = PreferenceController.<Boolean>getPref(PREF_IS_IMPACT_ANALYSIS);
		if(res != null){
			return res;
		}
		return false;
	}
	
	public static int getRefreshTime (){
		final Integer val = PreferenceController.<Integer>getPref(PREF_REFRESH_TIME);
		if(val != null){
			return val;		
		}
		return PreferenceController.DEFAULT_REFRESH_TIME;
	}
	
	public static <T> T getPref (String key){
		Map<String, Object> map = manager.getSimpleConfiguration(null, null, PREF_MODEL, true);
		if (map != null){
			return (T)map.get(key);
		}
		else {
			return null;
		}
	}
	
	public static void savePref (String key, Object value){
		Map<String, Object> map = manager.getSimpleConfiguration(null, Scope.WORKSPACE, PREF_MODEL, true);
		if (map == null){
			map = Maps.newHashMap();
		}
		map.put(key, value);
		try {
			manager.saveSimpleConfiguration(map, null, null, PREF_MODEL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
