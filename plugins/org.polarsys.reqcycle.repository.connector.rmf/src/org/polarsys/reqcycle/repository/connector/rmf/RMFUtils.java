/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.repository.connector.rmf;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.rmf.reqif10.AttributeDefinition;
import org.eclipse.rmf.reqif10.AttributeValue;
import org.eclipse.rmf.reqif10.AttributeValueEnumeration;
import org.eclipse.rmf.reqif10.EnumValue;
import org.eclipse.rmf.reqif10.ReqIF;
import org.eclipse.rmf.reqif10.ReqIFContent;
import org.eclipse.rmf.reqif10.SpecElementWithAttributes;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.SpecObject;
import org.eclipse.rmf.reqif10.SpecObjectType;
import org.eclipse.rmf.reqif10.SpecType;
import org.eclipse.rmf.reqif10.Specification;
import org.eclipse.rmf.reqif10.XhtmlContent;
import org.eclipse.rmf.reqif10.common.util.ReqIF10Util;
import org.eclipse.rmf.reqif10.common.util.ReqIF10XhtmlUtil;
import org.polarsys.reqcycle.core.ILogger;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.MappingModel.MappingAttribute;
import org.polarsys.reqcycle.repository.data.MappingModel.MappingElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Section;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.data.types.IRequirementType;
import org.polarsys.reqcycle.repository.data.types.internal.RequirementTypeImpl;
import org.polarsys.reqcycle.repository.data.util.DataUtil;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

public class RMFUtils {

	static ILogger logger = ZigguratInject.make(ILogger.class);

	static IDataModelManager dataTypeManager = ZigguratInject.make(IDataModelManager.class);

	static IDataManager dataManager = ZigguratInject.make(IDataManager.class);

	public static final String SPECIFICATION_ID = "SpecificationId";
	public static final String SPECIFICATION_NAME = "SpecificationName";

	public static Collection<SpecType> getReqIFTypes(ResourceSet resourceSet, String fileLocation) {
		URI uriReqIf = getURI(fileLocation);
		Resource reqIfResource = resourceSet.getResource(uriReqIf, true);
		EList<EObject> contents = reqIfResource.getContents();
		if (contents.size() > 0) {
			EObject content = contents.get(0);
			if (content instanceof ReqIF) {
				ReqIFContent coreContent = ((ReqIF) content).getCoreContent();
				EList<SpecType> specTypes = coreContent.getSpecTypes();
				// Gets SpecObjectTypes, specification elements are
				// automatically transformed in sections
				return Collections2.filter(specTypes, new Predicate<SpecType>() {

					@Override
					public boolean apply(SpecType arg0) {
						if (arg0 instanceof SpecObjectType) {
							return true;
						}
						return false;
					}
				});
			}
		}
		return null;
	}

	private static URI getURI(String fileLocation) {
		URI uriReqIf = URI.createURI(fileLocation, true);
		if (uriReqIf.isPlatform()) {
			uriReqIf = URI.createURI(uriReqIf.toPlatformString(true));
		} else if (uriReqIf.isFile()) {
			uriReqIf = URI.createURI(uriReqIf.toFileString());
		}
		return uriReqIf;
	}

	public static Collection<Specification> getReqIFDocuments(ResourceSet resourceSet, String fileLocation) {
		URI uriReqIf = getURI(fileLocation);
		Resource reqIfResource = resourceSet.getResource(uriReqIf, true);
		EList<EObject> contents = reqIfResource.getContents();
		if (contents.size() > 0) {
			EObject content = contents.get(0);
			if (content instanceof ReqIF) {
				ReqIFContent coreContent = ((ReqIF) content).getCoreContent();
				return coreContent.getSpecifications();
			}
		}
		return null;
	}

	public static void fillRequirements(RequirementSource requirementSource, IProgressMonitor progressMonitor, Scope scope) {

		Collection<MappingElement> mapping = requirementSource.getMappings();
		if (mapping == null) {
			return;
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createURI(requirementSource.getRepositoryURI(), false), true);

		EList<EObject> contents = resource.getContents();
		for (EObject eObject : contents) {
			if (eObject instanceof ReqIF) {
				ReqIF reqIF = (ReqIF) eObject;

				Specification specification = getSpecification(reqIF, requirementSource.getProperty(SPECIFICATION_ID), requirementSource.getProperty(SPECIFICATION_NAME));

				EList<SpecHierarchy> specHierarchies = specification.getChildren();
				Collection<AbstractElement> children = createChildren(specHierarchies, mapping, scope);

				if (children != null && !children.isEmpty()) {
					dataManager.addElementsToSource(requirementSource, children.toArray(new AbstractElement[children.size()]));
				}
			}
		}
	}

	protected static Specification getSpecification(ReqIF reqif, String specificationId, String specificationName) {
		EList<Specification> specifications = reqif.getCoreContent().getSpecifications();
		Specification specificationByName = null;
		for (Specification specification : specifications) {
			if (specificationId.equals(specification.getIdentifier())) {
				return specification;
			}
			if (specificationName.equals(specification.getLongName())) {
				specificationByName = specification;
			}
		}
		return specificationByName;
	}

	protected static Collection<AbstractElement> createChildren(EList<SpecHierarchy> specHierarchies, Collection<MappingElement> mapping, Scope scope) {

		Collection<AbstractElement> result = new ArrayList<AbstractElement>();

		for (SpecHierarchy specHierarchy : specHierarchies) {

			Collection<AbstractElement> children = createChildren(specHierarchy.getChildren(), mapping, scope);

			AbstractElement createdObject = null;

			SpecObject specObject = specHierarchy.getObject();
			if (specObject != null) {

				SpecType specType = ReqIF10Util.getSpecType(specObject);
				String identifier = specType.getIdentifier();
				MappingElement elementMapping = DataUtil.getElementMapping(mapping, identifier, specType.getLongName());
				if (elementMapping != null) {
					String id = getID(elementMapping, specObject);
					String name = getName(elementMapping, specObject);
					createdObject = createElement(mapping, specObject, identifier, specType.getLongName(), id, name);
					if (scope != null && (createdObject instanceof Requirement)) {
						createdObject.getScopes().add(scope);
					}
				}

			} else {
				// createdObject =
				// creator.createSection(specHierarchy.getLongName(),
				// specHierarchy.getDesc(), specHierarchy.getIdentifier());
				createdObject = dataManager.createSection(specHierarchy.getLongName(), specHierarchy.getDesc(), specHierarchy.getIdentifier());
			}

			if (createdObject != null) {
				if (children != null && !children.isEmpty()) {
					if (createdObject instanceof Section) {
						dataManager.addElementsToSection((Section) createdObject, children.toArray(new AbstractElement[children.size()]));
					} else {
						logger.error("The element " + createdObject.getId() + " is not a Section Type, his children will be missed");
					}
				}
				result.add(createdObject);
			} else {
				if (children != null && !children.isEmpty()) {
					logger.error("The element " + specHierarchy.getIdentifier() + " can't be created, his children will be missed");
				}
			}
		}
		return result;
	}

	private static String getName(MappingElement elementMapping, SpecElementWithAttributes element) {
		EList<MappingAttribute> attributes = elementMapping.getAttributes();
		for (MappingAttribute attribute : attributes) {
			if ("text".equalsIgnoreCase(attribute.getTargetAttribute().getName())) {
				String sourceId = attribute.getSourceId();
				for (AttributeValue value : element.getValues()) {
					AttributeDefinition attributeDefinition = ReqIF10Util.getAttributeDefinition(value);
					if (sourceId != null && sourceId.equals(attributeDefinition.getIdentifier())) {
						return ReqIF10Util.getTheValue(value) == null ? null : getValue(value);
					} else if (attribute.getDescription() != null && attribute.getDescription().equals(attributeDefinition.getLongName())) {
						return getValue(value);
					}
				}
			}
		}
		return "";
	}

	private static String getID(MappingElement elementMapping, SpecElementWithAttributes element) {
		EList<MappingAttribute> attributes = elementMapping.getAttributes();
		for (MappingAttribute attribute : attributes) {
			if ("id".equalsIgnoreCase(attribute.getTargetAttribute().getName())) {
				String sourceId = attribute.getSourceId();
				for (AttributeValue value : element.getValues()) {
					AttributeDefinition attributeDefinition = ReqIF10Util.getAttributeDefinition(value);
					if (sourceId != null && sourceId.equals(attributeDefinition.getIdentifier())) {
						return getValue(value);
					} else if (attribute.getDescription() != null && attribute.getDescription().equals(attributeDefinition.getLongName())) {
						return getValue(value);
					}
				}
			}
		}
		return "";
	}

	private static String getValue(AttributeValue value) {
		Object theValue = ReqIF10Util.getTheValue(value);
		if (theValue instanceof XhtmlContent) {
			XhtmlContent content = (XhtmlContent) theValue;
			Document dom = ReqIF10XhtmlUtil.getXhtmlDom(content);
			return visit(dom, new StringBuffer("")).toString();
		}
		return theValue.toString();
	}

	private static StringBuffer visit(Node node, StringBuffer string) {
		// FIXME first hack to unblock people blocked by xhtml
		if (node instanceof Text) {
			if (string.length() > 0) {
				string.append("\n");
			}
			string.append(((Text) node).getData());
		}
		NodeList childNodes = node.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			visit(childNodes.item(i), string);
		}
		return string;
	}

	protected static AbstractElement createElement(Collection<MappingElement> mapping, SpecElementWithAttributes specElement, String sourceQualifier, String longName, String id, String name) {
		MappingElement elementMapping = DataUtil.getElementMapping(mapping, sourceQualifier, longName);
		AbstractElement createdObject = null;
		if (elementMapping != null) {
			try {
				IRequirementType type = new RequirementTypeImpl(elementMapping.getTargetElement(), null);
				createdObject = type.createInstance();
				createdObject.setId(id);
				createdObject.setText(name);
				createdObject.setUri(id);
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage()));
			}
			addAttributes(elementMapping, specElement.getValues(), createdObject);
		}
		return createdObject;
	}

	protected static void addAttributes(MappingElement elementMapping, Collection<AttributeValue> values, AbstractElement element) {
		for (AttributeValue attributeValue : values) {

			AttributeDefinition attributeDefinition = ReqIF10Util.getAttributeDefinition(attributeValue);
			MappingAttribute attributeMapping = DataUtil.getAttributeMapping(elementMapping, attributeDefinition.getIdentifier(), attributeDefinition.getLongName());
			if (attributeMapping == null) {
				continue;
			}
			EAttribute attributeToSet = attributeMapping.getTargetAttribute();
			if ("id".equalsIgnoreCase(attributeToSet.getName()) || "text".equalsIgnoreCase(attributeToSet.getName())) {
				continue;
			}

			try {
				if (attributeValue instanceof AttributeValueEnumeration) {
					for (EnumValue enumValue : ((AttributeValueEnumeration) attributeValue).getValues()) {
						String name = enumValue.getLongName();
						EAttribute targetAttribute = attributeToSet;
						if (targetAttribute.getEAttributeType() instanceof EEnum) {
							EEnumLiteral enumLiteral = ((EEnum) targetAttribute.getEAttributeType()).getEEnumLiteral(name);
							element.eSet(attributeToSet, enumLiteral);
							// creator.addAttribute(attributeMapping, element,
							// enumLiteral);
						}
					}
				}
				Object theValue = ReqIF10Util.getTheValue(attributeValue);
				if (attributeToSet.getEType().isInstance(theValue)) {
					element.eSet(attributeToSet, theValue);
				} else {
					logger.error("Can't add the attribute " + attributeDefinition.getIdentifier() + " to the element " + element.getText());
				}
				// creator.addAttribute(attributeMapping, element,
				// ReqIF10Util.getTheValue(attributeValue));
			} catch (Exception e) {
				logger.error("Can't add the attribute " + attributeDefinition.getIdentifier() + " to the element " + element.getText());
			}
		}
	}

	public static ITreeContentProvider contentProvider = new ITreeContentProvider() {

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		@Override
		public void dispose() {
		}

		@Override
		public boolean hasChildren(Object element) {
			return false;
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return ArrayContentProvider.getInstance().getElements(inputElement);
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			return null;
		}
	};

}
