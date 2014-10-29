/*******************************************************************************
 *  Copyright (c) 2013, 2014 AtoS and others
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *  Malick WADE (AtoS) - initial API and implementation and/or initial documentation
 *  Raphael Faudou (samares Engineering) - Fixed partially doc Types connector on robustness:
 * 		When there were bad/partial mappings, a NPE occured and nothing happend after req source finish button was clicked.
 * 		Now req source is created empty. End user understands he/she has to check mapping.
 *
 *******************************************************************************/
package org.polarsys.reqcycle.repository.connector.document;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;
import org.polarsys.reqcycle.inittypes.inittypes.Attribute;
import org.polarsys.reqcycle.inittypes.inittypes.FileType;
import org.polarsys.reqcycle.inittypes.inittypes.Requirement;
import org.polarsys.reqcycle.inittypes.inittypes.Type;
import org.polarsys.reqcycle.repository.data.MappingModel.MappingAttribute;
import org.polarsys.reqcycle.repository.data.MappingModel.MappingElement;
import org.polarsys.reqcycle.repository.data.MappingModel.MappingModelFactory;
import org.polarsys.reqcycle.repository.data.types.IAttribute;
import org.polarsys.reqcycle.repository.data.types.IRequirementType;
import org.polarsys.reqcycle.repository.data.types.IType;
import org.polarsys.reqcycle.typesmodel.handler.ITypeManager;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class DocUtils {
	
	static ITypeManager manager = ZigguratInject.make(ITypeManager.class);

	public static List<FileType> getAllFilesInProject() {
		List<FileType> listDocumentTypes = manager.getFileTypes();
		return listDocumentTypes;
	}
	
	
	public static List<Type> getListTypes(String fileName){
		List<Type> listTypes = manager.getAllTypesPerFileTypes(fileName);
	return listTypes;
	}
	
	public static Image getImage(String file) {
	Bundle bundle = Platform.getBundle("org.polarsys.reqcycle.repository.connector.document");
	  URL url = FileLocator.find(bundle, new Path("icons/" + file), null);
	  ImageDescriptor image = ImageDescriptor.createFromURL(url);
	  return image.createImage();

	}


	public static List<Requirement> finalListRequirement(List<Requirement> requirements, Collection<IType> confTypes) {
		List<Requirement> listReq = new ArrayList<Requirement>();
			for (Requirement reqIn : requirements){
				for (IType reqConfType : confTypes){
					if(reqConfType instanceof IRequirementType){
						
					IRequirementType reqConf = (IRequirementType) reqConfType;
					if(reqIn.getNameReq().equals(reqConf.getName())){
						Requirement reqOut = reqIn;
						List<Attribute> attributesIn = new ArrayList<Attribute>();
						List<IAttribute> attributesConf = new ArrayList<IAttribute>();
						attributesIn.addAll(reqIn.getAttributesReq());
						attributesConf.addAll((List<IAttribute>) reqConf.getAttributes());
						
							for (Attribute attIn : attributesIn){
								boolean foundAtt = false;
								for (IAttribute attConf : attributesConf){
									if (attIn.getNameAttribute().equals(attConf.getName())){
										//reqOut.getAttributesReq().add(attIn);
										foundAtt= true;
										break;
									}
									
								}
								
								if(!foundAtt){
									reqOut.getAttributesReq().remove(attIn);
								}
								
							}
						listReq.add(reqOut);
					}
				}
				}
				
			}
		return listReq;
	}
	
	public static Collection<MappingElement> mappingElements(List<Requirement> requirements, Collection<IType> confTypes) {
		Collection<MappingElement> mappingElements =  new ArrayList<MappingElement>();
		List<Requirement> lstRequirements = new ArrayList<Requirement>();
		lstRequirements.addAll(finalListRequirement(requirements, confTypes));
		
		for (Requirement reqIn : lstRequirements){
				MappingElement elementMapping = MappingModelFactory.eINSTANCE.createMappingElement();
				elementMapping.setDescription(reqIn.getNameReq());
				elementMapping.setSourceQualifier(reqIn.getRegexReq().getExpression());
				elementMapping.setTargetElement(reqIn.eClass());
				
				for (Attribute att : reqIn.getAttributesReq()){
					MappingAttribute mappingAttribute = MappingModelFactory.eINSTANCE.createMappingAttribute();
					// -RFa- attribute might have no regex attribute...
					if (att.getRegexAttribute() != null) {
						mappingAttribute.setSourceId(att.getRegexAttribute().getExpression());
					}
					else {
						// @Fixme
						System.out.println("warning: attribute " + att.getNameAttribute() + " has no regex ");
					}
					mappingAttribute.setDescription(att.getNameAttribute());
					elementMapping.getAttributes().add(mappingAttribute);
				}		
				mappingElements.add(elementMapping);
				
			}
		return mappingElements;
	}

	
	

}
