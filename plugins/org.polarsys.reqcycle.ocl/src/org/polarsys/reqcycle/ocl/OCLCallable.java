package org.polarsys.reqcycle.ocl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.polarsys.reqcycle.ocl.utils.OCLUtilities;
import org.polarsys.reqcycle.repository.connector.ICallable;
import org.polarsys.reqcycle.repository.connector.ui.PropertyUtils;
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.ISourceConstants;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.MappingModel.MappingElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementsContainer;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Section;
import org.polarsys.reqcycle.repository.data.types.IAttribute;
import org.polarsys.reqcycle.repository.data.types.IRequirementType;
import org.polarsys.reqcycle.repository.data.types.IType;
import org.polarsys.reqcycle.utils.ocl.OCLEvaluator;
import org.polarsys.reqcycle.utils.ocl.ZigguratOCLPlugin;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

public class OCLCallable implements ICallable {

	@Inject
	IDataManager dataManager;

	Map<EObject, Section> sections = Maps.newHashMap();

	@Override
	public void fillRequirementSource(RequirementSource source) throws Exception {
		// RFU add ReqContainer based on req source destination file
		RequirementsContainer rc = dataManager.createRequirementsContainer(URI.createPlatformResourceURI(source.getProperty(ISourceConstants.DESTINATION_PATH), true));
		source.setContents(rc);
		fillRequirements(source);
	}

	protected TreeIterator<EObject> getIterator(RequirementSource requirementSource, ResourceSet resourceSet) {
		String repositoryUri = requirementSource.getRepositoryUri();
		Resource resource = resourceSet.getResource(URI.createURI(repositoryUri), true);
		TreeIterator<EObject> contents = resource.getAllContents();
		return contents;
	}

	protected void fillRequirements(RequirementSource requirementSource) throws Exception {
		requirementSource.clearContent();
		Collection<MappingElement> mapping = requirementSource.getMappings();
		ResourceSet resourceSet = new ResourceSetImpl();

		OCLEvaluator evaluator = ZigguratOCLPlugin.compileOCL(resourceSet, URI.createPlatformResourceURI(requirementSource.getProperty(IOCLConstants.OCL_URI), true));

		Iterator<EObject> contents = getIterator(requirementSource, resourceSet);
		Collection<IType> types = PropertyUtils.getDataModelFromSource(requirementSource).getTypes();
		while (contents.hasNext()) {
			EObject eObject = contents.next();
			if (OCLUtilities.isSection(evaluator, eObject)) {
				String id = (String) OCLUtilities.getAttributeValue(evaluator, eObject, "getId", EcorePackage.Literals.ESTRING);
				String name = (String) OCLUtilities.getAttributeValue(evaluator, eObject, "getName", EcorePackage.Literals.ESTRING);
				Section section = dataManager.createSection(id, name, "");
				sections.put(eObject, section);
				addToSection(requirementSource, eObject, section);
			}
			for (IType type : types) {
				if (type instanceof IRequirementType && OCLUtilities.isDataType(evaluator, eObject, (IRequirementType) type)) {
					AbstractElement requirement = createRequirement(evaluator, mapping, eObject, (IRequirementType) type);
					addToSection(requirementSource, eObject, requirement);
				}
			}
		}
	}

	private void addToSection(RequirementSource requirementSource, EObject eObject, AbstractElement current) {
		Section container = null;
		EObject tmp = eObject;
		while (container == null && tmp.eContainer() != null) {
			container = sections.get(tmp.eContainer());
			tmp = tmp.eContainer();
		}
		if (container == null) {
			dataManager.addElementsToSource(requirementSource, current);
		} else {
			dataManager.addElementsToSection(container, current);
		}
	}

	protected AbstractElement createRequirement(OCLEvaluator evaluator, Collection<MappingElement> mappings, EObject eObject, IRequirementType reqType) throws Exception {
		Requirement requirement = reqType.createInstance();
		for (IAttribute attribute : Iterables.filter(reqType.getAttributes(), IAttribute.class)) {
			Object value = OCLUtilities.getAttributeValue(evaluator, eObject, attribute);
			if (value != null) {
				dataManager.addAttributeValue(requirement, attribute, value);
			}
		}
		return requirement;
	}

}
