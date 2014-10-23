/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.styling.ui.providers;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.ReflectiveItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSourceConfPackage;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataPackage;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class ItemAdapterFactory extends ReflectiveItemProviderAdapterFactory {
	
	BasicStylingLabelProvider lp = new BasicStylingLabelProvider();
	IDataModelManager dmM = ZigguratInject.make(IDataModelManager.class);
	
	
	public ItemAdapterFactory() {
		super();
		reflectiveItemProviderAdapter = new ReflectiveItemProvider(this){
			@Override
			public Object getImage(Object object) {
				return lp.getImage(object);
			}
			
			@Override
			public String getText(Object object) {
				return lp.getText(object);
			}
			
			@Override
			public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
				String result = super.getCreateChildText(owner, feature, child, selection);
				if (child instanceof Requirement){
					Requirement r = (Requirement) child ;
					if (r.eClass() != null && r.eClass().getEPackage() != null){
						if (r.eClass().getEPackage() != RequirementSourceDataPackage.eINSTANCE){
							result += " ("+ r.eClass().getEPackage().getName() +  ")";
						}
					}
				}
				return result;
			}
			@Override
			protected List<EClass> getAllEClasses(EClass eClass) {
				List<EClass> eclasses = Lists.newArrayList(super.getAllEClasses(eClass));
				Set<EClass> set = Sets.newHashSet(eclasses);
				for (IDataModel d : dmM.getCurrentDataModels()){
					if (d instanceof IAdaptable) {
						IAdaptable adaptable = (IAdaptable) d;
						EPackage ap = (EPackage) adaptable.getAdapter(EPackage.class);
						for (EClassifier e : ap.getEClassifiers()){
							if (e instanceof EClass) {
								EClass eclass = (EClass) e;
								if (!set.contains(eclass)){
									eclasses.add(eclass);
								}
							}
						}
					}
				}
				return eclasses;
			}
			
			@Override
			protected List<EPackage> getAllEPackages(EClass eClass) {
				List<EPackage> packages = Lists.newArrayList(super.getAllEPackages(eClass));
				Set<EPackage> set = Sets.newHashSet(packages);
				for (IDataModel d : dmM.getCurrentDataModels()){
					if (d instanceof IAdaptable) {
						IAdaptable adaptable = (IAdaptable) d;
						EPackage ap = (EPackage) adaptable.getAdapter(EPackage.class);
						if (!set.contains(ap)){
							packages.add(ap);
						}
					}
				}
				return packages;
			}
		};
	}
	
	public boolean isRecognizedEPackage (EPackage ep){
		return ep != null && (ep == RequirementSourceDataPackage.eINSTANCE 
				|| ep == RequirementSourceConfPackage.eINSTANCE
				|| ep.getNsURI().startsWith(IDataModelManager.MODEL_NS_URI));
	}
	
	@Override
	public boolean isFactoryForType(Object object) {
		if (supportedTypes.contains(object)){
			return true;
		}
		if (object instanceof EPackage) {
			return isRecognizedEPackage((EPackage) object);
		}
		if (object instanceof EObject) {
			return isRecognizedEPackage(((EObject)object).eClass().getEPackage());
		}
		return false;
	}
	
}
