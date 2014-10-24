/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Abdellah El Ayadi (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.reqcycle.export.rmf.transform;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rmf.reqif10.AttributeDefinition;
import org.eclipse.rmf.reqif10.AttributeValue;
import org.eclipse.rmf.reqif10.DatatypeDefinition;
import org.eclipse.rmf.reqif10.ReqIF;
import org.eclipse.rmf.reqif10.ReqIF10Factory;
import org.eclipse.rmf.reqif10.ReqIF10Package;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.SpecObject;
import org.eclipse.rmf.reqif10.SpecObjectType;
import org.eclipse.rmf.reqif10.Specification;
import org.eclipse.rmf.reqif10.SpecificationType;
import org.polarsys.reqcycle.export.rmf.page.WizardController;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataPackage;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Section;
import org.polarsys.reqcycle.repository.data.types.IAttribute;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.repository.data.types.IRequirementType;
import org.polarsys.reqcycle.repository.data.types.IType;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Maps;

public class ReqIFExport {

	private WizardController controller;

	static IDataModelManager modelManager = ZigguratInject.make(IDataModelManager.class);

//	private EList<SpecHierarchy> listSpecHierarchy;

	private ReqIF reqif;

	public ReqIFExport(WizardController controller) {
		super();
		this.controller = controller;
	}

	private Map<EDataType, DatatypeDefinition> basicTypesMapping;
	private Map<EDataType, EClass> attDefinitions;
	private Map<EDataType, EClass> attValues;
	private Map<EClass, SpecObjectType> specObjectTypes;
	private Map<EClass, Map<EStructuralFeature, AttributeDefinition>> attributeDefinitions;

//	private SpecObjectType sectionType;

	private SpecObjectType reqType;

	public ReqIF transform() {

		// String outputPath = controller.getOutputPath();

		URI uri = controller.getOutputUri();

		Iterator<IRequirementProvider> reqResult = controller.getReqResult().iterator();

		basicTypesMapping = Maps.newHashMap();
		attDefinitions = Maps.newHashMap();
		attValues = Maps.newHashMap();
		specObjectTypes = Maps.newHashMap();
		attributeDefinitions = Maps.newHashMap();

		reqif = ReqIF10Factory.eINSTANCE.createReqIF();

		DatatypeDefinition t = ReqIF10Factory.eINSTANCE.createDatatypeDefinitionString();
		t.setLongName("String");
		reqif.setCoreContent(ReqIF10Factory.eINSTANCE.createReqIFContent());
		reqif.getCoreContent().getDatatypes().add(t);
		basicTypesMapping.put(EcorePackage.Literals.ESTRING, t);
		attDefinitions.put(EcorePackage.Literals.ESTRING, ReqIF10Package.Literals.ATTRIBUTE_DEFINITION_STRING);
		attValues.put(EcorePackage.Literals.ESTRING, ReqIF10Package.Literals.ATTRIBUTE_VALUE_STRING);

		t = ReqIF10Factory.eINSTANCE.createDatatypeDefinitionInteger();
		t.setLongName("Integer");
		reqif.getCoreContent().getDatatypes().add(t);
		basicTypesMapping.put(EcorePackage.Literals.EINT, t);
		attDefinitions.put(EcorePackage.Literals.EINT, ReqIF10Package.Literals.ATTRIBUTE_DEFINITION_INTEGER);
		attValues.put(EcorePackage.Literals.EINT, ReqIF10Package.Literals.ATTRIBUTE_VALUE_INTEGER);

		t = ReqIF10Factory.eINSTANCE.createDatatypeDefinitionBoolean();
		t.setLongName("Boolean");
		reqif.getCoreContent().getDatatypes().add(t);
		basicTypesMapping.put(EcorePackage.Literals.EBOOLEAN, t);
		attDefinitions.put(EcorePackage.Literals.EBOOLEAN, ReqIF10Package.Literals.ATTRIBUTE_DEFINITION_BOOLEAN);
		attValues.put(EcorePackage.Literals.EBOOLEAN, ReqIF10Package.Literals.ATTRIBUTE_VALUE_BOOLEAN);

		t = ReqIF10Factory.eINSTANCE.createDatatypeDefinitionInteger();
		t.setLongName("Long");
		reqif.getCoreContent().getDatatypes().add(t);
		basicTypesMapping.put(EcorePackage.Literals.ELONG, t);
		attDefinitions.put(EcorePackage.Literals.ELONG, ReqIF10Package.Literals.ATTRIBUTE_DEFINITION_INTEGER);
		attValues.put(EcorePackage.Literals.ELONG, ReqIF10Package.Literals.ATTRIBUTE_VALUE_INTEGER);

		t = ReqIF10Factory.eINSTANCE.createDatatypeDefinitionReal();
		t.setLongName("Float");
		reqif.getCoreContent().getDatatypes().add(t);
		basicTypesMapping.put(EcorePackage.Literals.EFLOAT, t);
		attDefinitions.put(EcorePackage.Literals.EFLOAT, ReqIF10Package.Literals.ATTRIBUTE_DEFINITION_REAL);
		attValues.put(EcorePackage.Literals.EFLOAT, ReqIF10Package.Literals.ATTRIBUTE_VALUE_REAL);

		t = ReqIF10Factory.eINSTANCE.createDatatypeDefinitionReal();
		t.setLongName("Double");
		reqif.getCoreContent().getDatatypes().add(t);
		basicTypesMapping.put(EcorePackage.Literals.EDOUBLE, t);
		attDefinitions.put(EcorePackage.Literals.EDOUBLE, ReqIF10Package.Literals.ATTRIBUTE_DEFINITION_REAL);
		attValues.put(EcorePackage.Literals.EDOUBLE, ReqIF10Package.Literals.ATTRIBUTE_VALUE_REAL);

//		sectionType = ReqIF10Factory.eINSTANCE.createSpecObjectType();
//		sectionType.setLongName("Section");
//		handleAttribute(RequirementSourceDataPackage.Literals.ABSTRACT_ELEMENT__ID, RequirementSourceDataPackage.Literals.SECTION, sectionType);
//		handleAttribute(RequirementSourceDataPackage.Literals.ABSTRACT_ELEMENT__TEXT, RequirementSourceDataPackage.Literals.SECTION, sectionType);
//		reqif.getCoreContent().getSpecTypes().add(sectionType);
		
		

		reqType = ReqIF10Factory.eINSTANCE.createSpecObjectType();
		reqType.setLongName("Requirement");
		handleAttribute(RequirementSourceDataPackage.Literals.ABSTRACT_ELEMENT__ID, RequirementSourceDataPackage.Literals.REQUIREMENT, reqType);
		handleAttribute(RequirementSourceDataPackage.Literals.ABSTRACT_ELEMENT__TEXT, RequirementSourceDataPackage.Literals.REQUIREMENT, reqType);
		reqif.getCoreContent().getSpecTypes().add(reqType);

		handleTypes(reqResult);

		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(uri);
		r.getContents().add(reqif);

		try {
			r.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return reqif;
	}
	
	private void handleAttribute(EStructuralFeature newAttribute, EClass classDescriptor, SpecObjectType specType) {
		if (newAttribute.getEType() instanceof EDataType) {
			AttributeDefinition attDef = (AttributeDefinition) ReqIF10Factory.eINSTANCE.create(attDefinitions.get(newAttribute.getEType()));
			Map<EStructuralFeature, AttributeDefinition> map = attributeDefinitions.get(classDescriptor);
			if (map == null) {
				map = Maps.newHashMap();
				attributeDefinitions.put(classDescriptor, map);
			}
			map.put(newAttribute, attDef);
			attDef.setLongName(newAttribute.getName());
			EStructuralFeature typeFeature = attDef.eClass().getEStructuralFeature("type");
			attDef.eSet(typeFeature, basicTypesMapping.get(newAttribute.getEType()));
			specType.getSpecAttributes().add(attDef);
		}
	}

	private void handleTypes(Iterator<IRequirementProvider> reqResult) {
		while (reqResult.hasNext()) {
			IRequirementProvider iReqProvider = (IRequirementProvider) reqResult.next();
			if (iReqProvider instanceof RequirementSourceReqProvider) {
				RequirementSource source = ((RequirementSourceReqProvider) iReqProvider).getSource();
				
				Specification specification = ReqIF10Factory.eINSTANCE.createSpecification();
				EList<SpecHierarchy> listSpecHierarchy = specification.getChildren();
				SpecificationType specificationType = ReqIF10Factory.eINSTANCE.createSpecificationType();
				specification.setType(specificationType);
				
				specification.setLongName(source.getName());
				reqif.getCoreContent().getSpecTypes().add(specificationType);
				reqif.getCoreContent().getSpecifications().add(specification);
				
				IDataModel dataModel = modelManager.getDataModelByURI(source.getDataModelURI());
				Collection<IType> types = dataModel.getTypes();
				for (IType iType : types) {
					if (iType instanceof IRequirementType) {
						EClass classDescriptor = (EClass) ((IAdaptable) iType).getAdapter(EClass.class);
						SpecObjectType specType = ReqIF10Factory.eINSTANCE.createSpecObjectType();
						specObjectTypes.put(classDescriptor, specType);
						specType.setLongName(iType.getName());
						for (IAttribute att : ((IRequirementType) iType).getAttributes()) {
							EStructuralFeature feature = (EStructuralFeature) ((IAdaptable) att).getAdapter(EStructuralFeature.class);
							handleAttribute(feature, classDescriptor, specType);
						}
						reqif.getCoreContent().getSpecTypes().add(specType);
					}
				}
				
				

				handleSpecHierarchy(iReqProvider.getRequirements(), null, listSpecHierarchy);
			}
		}
	}

	private void handleSpecHierarchy(EList<AbstractElement> requirements, EList<SpecHierarchy> specHierarchies, EList<SpecHierarchy> listSpecHierarchy) {
		for (AbstractElement abstractElement : requirements) {
			SpecHierarchy specHierarchy = ReqIF10Factory.eINSTANCE.createSpecHierarchy();
			SpecObject so = ReqIF10Factory.eINSTANCE.createSpecObject();
			so.setDesc(abstractElement.getText());

			EClass classDescriptor = abstractElement.eClass();
			for (EStructuralFeature feature : classDescriptor.getEAllStructuralFeatures()) {
				if ("scopes".equals(feature.getName())) {
					// TODO
				} else {
					if (feature == RequirementSourceDataPackage.Literals.ABSTRACT_ELEMENT__ID || feature == RequirementSourceDataPackage.Literals.ABSTRACT_ELEMENT__TEXT
							|| !RequirementSourceDataPackage.eINSTANCE.equals(feature.getEContainingClass().getEPackage())) {
						Map<EStructuralFeature, AttributeDefinition> map = attributeDefinitions.get(classDescriptor);
						if (map != null) {
							AttributeDefinition def = map.get(feature);
							EClass attValClass = attValues.get(feature.getEType());
							AttributeValue attVal = (AttributeValue) ReqIF10Factory.eINSTANCE.create(attValClass);

							EStructuralFeature theValueFeature = attVal.eClass().getEStructuralFeature("theValue");
							attVal.eSet(theValueFeature, convert(abstractElement.eGet(feature)));
							EStructuralFeature defFeature = attVal.eClass().getEStructuralFeature("definition");
							attVal.eSet(defFeature, def);
							so.getValues().add(attVal);
						}
					}
				}
			}
			if (RequirementSourceDataPackage.Literals.SECTION.equals(abstractElement.eClass())) {
				specHierarchy.setLongName(abstractElement.getId());
			} else if (RequirementSourceDataPackage.Literals.REQUIREMENT.equals(abstractElement.eClass())) {
				so.setType(reqType);
				specHierarchy.setObject(so);
			} else {
				so.setType(specObjectTypes.get(classDescriptor));
				specHierarchy.setObject(so);
			}
			reqif.getCoreContent().getSpecObjects().add(so);
			if (specHierarchies == null) {
				listSpecHierarchy.add(specHierarchy);
			} else {
				specHierarchies.add(specHierarchy);
			}
			if (abstractElement instanceof Section && !((Section) abstractElement).getChildren().isEmpty()) {

				handleSpecHierarchy(((Section) abstractElement).getChildren(), specHierarchy.getChildren(), listSpecHierarchy);
			}

		}
	}

	private Object convert(Object obj) {
		if (obj instanceof Integer) {
			return BigInteger.valueOf((Integer) obj);
		}
		if (obj instanceof Long) {
			return BigInteger.valueOf((Long) obj);
		}
		if (obj instanceof Float) {
			return new Double((Float) obj);
		}
		return obj;
	}

}
