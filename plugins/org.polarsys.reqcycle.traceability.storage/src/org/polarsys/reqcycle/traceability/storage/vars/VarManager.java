/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.storage.vars;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.polarsys.reqcycle.traceability.storage.Activator;
import org.polarsys.reqcycle.traceability.storage.Variable;
import org.polarsys.reqcycle.utils.configuration.IConfigurationManager;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class VarManager {
	private static final String DEFAULT_PATH = ".traceability";
	IConfigurationManager confManager = ZigguratInject.make(IConfigurationManager.class);
	private static String EXT_ID = "pathVariable" ;
	public static String PATTERN_PREF_ID = Activator.PLUGIN_ID + ".pref" ;
	public static String PATTERN_PREF_PATH_ID = PATTERN_PREF_ID +".pattern" ;
	static Map<String, Variable> ALL_VARS = getAllVars () ;
	
	public String transformPattern(String pattern) {
		for (Variable v : ALL_VARS.values()){
			String patternFromVar = getPattern(v);
			pattern = pattern.replace(patternFromVar, v.getValue());
		}
		return pattern;
	}
	
	private String getPattern(Variable arg0) {
		return "{" + arg0.getLabel() + "}";
	}
	
	public String getPreferencePattern() {
		try {
			Map<String, Object> patternMap = confManager.getSimpleConfiguration(null, null, PATTERN_PREF_ID, true);
			boolean toSave = false ;
			if (patternMap == null){
				patternMap = Maps.newHashMap();
				patternMap.put(PATTERN_PREF_PATH_ID, DEFAULT_PATH);
				toSave = true;
			}
			String pattern = (String) patternMap.get(PATTERN_PREF_PATH_ID);
			if (pattern == null){
				patternMap.put(PATTERN_PREF_PATH_ID, DEFAULT_PATH);
				toSave = true ;
			}
			if (toSave){
				try {
					confManager.saveSimpleConfiguration(patternMap, null, null, PATTERN_PREF_ID);
				} catch (IOException e) {
				}
			}
			return pattern;
		}
		catch (Exception e){
			e.printStackTrace();
			return DEFAULT_PATH;
		}
	}
	
	public void setPreferencePattern(String pattern) {
		Map<String, Object> patternMap = confManager.getSimpleConfiguration(null, null, PATTERN_PREF_ID, true);
		if (patternMap == null){
			patternMap = Maps.newHashMap();
		}
		patternMap.put(PATTERN_PREF_PATH_ID, pattern);
		try {
			confManager.saveSimpleConfiguration(patternMap, null, null, PATTERN_PREF_ID);
		} catch (IOException e) {
		}
	}
	
	public List<String> getAllPatterns () {
		return Lists.newArrayList(Iterables.transform(ALL_VARS.values(),new Function<Variable,String>(){
			@Override
			public String apply(Variable arg0) {
				return getPattern(arg0);
			}
			
		}));
	}

	private static Map<String, Variable> getAllVars() {
		List<IConfigurationElement> elements = Arrays.asList(Platform.getExtensionRegistry().getConfigurationElementsFor(Activator.PLUGIN_ID, EXT_ID));
		Iterable<Variable> vars = Iterables.filter(Iterables.transform(elements, new Function<IConfigurationElement, Variable>() {
			@Override
			public Variable apply(IConfigurationElement arg0) {
				try {
					return (Variable) arg0.createExecutableExtension("instance");
				} catch (CoreException e) {
				}
				return null;
			}
		}),Predicates.notNull());
		return Maps.uniqueIndex(vars, new Function<Variable, String>(){
			@Override
			public String apply(Variable arg0) {
				return arg0.getLabel();
			}
		});
	}

}
