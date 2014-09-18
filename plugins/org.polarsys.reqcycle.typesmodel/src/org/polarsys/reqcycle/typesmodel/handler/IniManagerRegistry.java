/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Anass RADOUANI (Atos) anass.radouani@atos.net - Initial API and implementation
 *  Matthieu BOIVINEAU (Atos) matthieu.boivineau@atos.net - Deletion parameters parsing added
 *  														Deletion parameters dialog management added 
 *
 *****************************************************************************/

package org.polarsys.reqcycle.typesmodel.handler;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ini4j.Ini;
import org.ini4j.Profile.Section;
import org.ini4j.Wini;
import org.polarsys.reqcycle.inittypes.inittypes.Attribute;
import org.polarsys.reqcycle.inittypes.inittypes.FileType;
import org.polarsys.reqcycle.inittypes.inittypes.InittypesFactory;
import org.polarsys.reqcycle.inittypes.inittypes.Regex;
import org.polarsys.reqcycle.inittypes.inittypes.Requirement;
import org.polarsys.reqcycle.inittypes.inittypes.Type;
import org.polarsys.reqcycle.inittypes.inittypes.TypeModel;
import org.polarsys.reqcycle.typesmodel.Activator;
import org.polarsys.reqcycle.typesmodel.Messages;
import org.topcased.windows.ini.actions.IniFileParser;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 *  Create type model 
 */
public class IniManagerRegistry implements IResourceVisitor, IResourceDeltaVisitor
{

	enum kind {
		ADD, MODIFY, DELETE
	}

	private TypeModel typeModel;;

	/**
	 * return the ini manager registry
	 */
	public IniManagerRegistry()
	{
		this.typeModel = InittypesFactory.eINSTANCE.createTypeModel();
	}

	public boolean visit(IResource resource) throws CoreException
	{
		if (resource.isAccessible())
		{
			visit(resource, kind.ADD);
			return true;
		}
		return !(resource instanceof IProject);
	}

	/**
	 * perform addition, suppression or modification of a resource
	 * @param resource the impacted resource
	 * @param type the changement type
	 */
	public void visit(IResource resource, kind type)
	{
		if (Messages.Types.equals(resource.getFileExtension()) && resource instanceof IFile)
		{
			switch (type)
			{
			case ADD:
				if (fileAdded((IFile) resource))
				{
					Activator.getDefault().debug(Messages.NewFile + resource.toString());
				}
				break;
			case DELETE:
				if (fileDeleted((IFile) resource))
				{
					Activator.getDefault().debug(Messages.DeletedFile + resource.toString());
				}
				break;
			case MODIFY:
				fileUpdated((IFile) resource);
				Activator.getDefault().debug(Messages.ModifiedFile + resource.toString());
				break;
			default:
				break;
			}
		}
	}

	private static Pattern requirementRegexPattern = Pattern.compile(Messages.RequirementRegex);
	private static Pattern requirementNamePattern = Pattern.compile(Messages.RequirementName);
	private static Pattern attributeRegexPattern = Pattern.compile(Messages.AttributeRegex);
	private static Pattern attributeNamePattern = Pattern.compile(Messages.AttributeName);
	

	private boolean fileAdded(IFile resource)
	{
		FileType fileType = parseTypesFile(resource);
		if (fileType != null){
			typeModel.getFileTypes().add(fileType);
		}

		return true;
	}

	public static FileType parseTypesFile(IFile resource) {
		FileType fileType = InittypesFactory.eINSTANCE.createFileType();
		fileType.setName(getMethodName(resource));
		IniFileParser parser = new IniFileParser(resource);
		String[] types = parser.getTypes();

		if (types == null)
		{
			Activator.getDefault().getLog().log(new Status(Status.WARNING, Activator.PLUGIN_ID, "the element : " + types + " was ignored because it's empty")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return null;
		}
		
		for (String type : types)
		{
			Section section = parser.getElements(type);
			if (section != null) {
				
			
				Type TypeInDoc = InittypesFactory.eINSTANCE.createType();
				TypeInDoc.setName(type);
				
				for (Entry<String, String> element : section.entrySet())
				{
					
					//search a requirement in section
					if (requirementNamePattern.matcher(element.getKey()).matches())
					{
						String elementId = element.getKey().replace("Name", "");						
						if (element.getValue() == null || element.getValue().length() == 0)
						{
							Activator.getDefault().getLog().log(new Status(Status.WARNING, Activator.PLUGIN_ID, "the element : " + element.getKey() + "=" + element.getValue() + " was ignored because it's empty")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
							
						}
						//Building of a requirement
						Requirement requirement = InittypesFactory.eINSTANCE.createRequirement();
						requirement.setNameReq(element.getValue());
						//listRequierements.put(elementId, requirement);
							
							//searching a regex of requirement
								for (Entry<String, String> elementReq : section.entrySet())
								{
									if (requirementRegexPattern.matcher(elementReq.getKey()).matches() && elementReq.getKey().equalsIgnoreCase(elementId))
									{
										//Building a regex
										Regex regex = InittypesFactory.eINSTANCE.createRegex();
										regex.setExpression(elementReq.getValue());
										requirement.setRegexReq(regex);
										//do a break because a requirement has at most one regex
										break;
									}
									
								}
								
								//searching all attributes of a requirement
								for (Entry<String, String> elementAttributeName : section.entrySet())
								{ 
									String elementIdAttribute = elementAttributeName.getKey().replaceAll("Attribute\\d+Name", "");
									String elementIdAttributeRegex = elementAttributeName.getKey().replace("Name", "");
									if (attributeNamePattern.matcher(elementAttributeName.getKey()).matches() && elementIdAttribute.equalsIgnoreCase(elementId))
									{
										Attribute attribute = InittypesFactory.eINSTANCE.createAttribute();
										attribute.setNameAttribute(elementAttributeName.getValue());
										for (Entry<String, String> elementAttributeRegex : section.entrySet())
										{ 
											String elementIdAttributeRegexFound = elementAttributeRegex.getKey().replace("Name", "");
											if (attributeRegexPattern.matcher(elementAttributeRegex.getKey()).matches() && elementIdAttributeRegex.equalsIgnoreCase(elementIdAttributeRegexFound))
											{
												//Building a regex
												Regex regex = InittypesFactory.eINSTANCE.createRegex();
												regex.setExpression(elementAttributeRegex.getValue());
												attribute.setRegexAttribute(regex);
												//do a break because an attribute has at most one regex
												break;
											}
											
										}
										requirement.getAttributesReq().add(attribute);
									}
																		
								}
								
							
						TypeInDoc.getRequirements().add(requirement);
					}

				}
				fileType.getTypes().add(TypeInDoc);
			}
		}

		return fileType;
	}

	private static String getMethodName(IFile resource) {
		return resource.getFullPath().toString();
	}

	public static List<String> parseCommaSeparated(String strToParse) {
		LinkedList<String> strList = new LinkedList<String>();
		String[] strs = strToParse.split(","); //$NON-NLS-1$
		for (String str : strs) {
			if (!"".equals(str)) { //$NON-NLS-1$
				strList.add(str);
			}
		}
		return strList;
	}

	public static String serializeCommaSeparated(List<String> strList) {
		StringBuilder b = new StringBuilder();
		for (String str : strList) {
			b.append(str);
			b.append(',');
		}
		// remove last ,
		if (!strList.isEmpty()) {
			b.deleteCharAt(b.length() - 1);
		}
		return b.toString();
	}

	/*protected static DeletionParameters getOrInitDeletionParameters(DocumentType documentType) {
		DeletionParameters deletionParameters = documentType.getDeletionParameters();
		if (deletionParameters == null) {
			deletionParameters = InittypesFactory.eINSTANCE.createDeletionParameters();
			documentType.setDeletionParameters(deletionParameters);
		}
		return deletionParameters;
	}
*/
	/*public String dump ()
	{
		InittypesItemProviderAdapterFactory adapterFactory = new InittypesItemProviderAdapterFactory();
		DocumentTypeItemProvider provider = new DocumentTypeItemProvider(adapterFactory);
		RegexItemProvider provider3 = new RegexItemProvider(adapterFactory);
		StringBuilder builder = new StringBuilder();
		builder.append("Type Model >\n"); //$NON-NLS-1$
		for (DocumentType d : typeModel.getDocumentTypes())
		{
			builder.append("\tId : ").append(provider.getText(d)).append(" : ").append(d.getTextType()).append(", hierarchical : ").append(d.isHierarchical()).append("\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			builder.append("\t\t").append(provider3.getText(d.getId())).append("\n"); //$NON-NLS-1$ //$NON-NLS-2$
			for (Type t : d.getTypes())
			{
				builder.append("\t\t").append(provider3.getText(t)).append(", ").append("\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
		}
		return builder.toString();
	}
*/
	/**
	 * @param element
	 * @return
	 */
	private static Regex manageId(Entry<String, String> element, EClass eclass, EStructuralFeature feature)
	{

		Regex type = (Regex) eclass.getEPackage().getEFactoryInstance().create(eclass);
		type.eSet(feature,element.getValue());
		return (Regex) type;
	}

	/**
	 * @param allElements
	 * @param element
	 */
	private static void manageElement(Map<String, Requirement> allElements, Entry<String, String> element, EClass eclass, EStructuralFeature feature)
	{
		if (element.getValue() == null || element.getValue().length() == 0)
		{
			Activator.getDefault().getLog().log(new Status(Status.WARNING, Activator.PLUGIN_ID, "the element : " + element.getKey() + "=" + element.getValue() + " was ignored because it's empty")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return;
		}
		String elementId = element.getKey().replace("Name", ""); //$NON-NLS-1$ //$NON-NLS-2$
		//elementId = elementId.replace("IsText", ""); //$NON-NLS-1$ //$NON-NLS-2$
		//elementId = elementId.replace("Label", "");//$NON-NLS-1$ //$NON-NLS-2$
		if (!allElements.containsKey(elementId))
		{
			Regex regex = create(eclass);
			//if (InittypesPackage.Literals.TYPE__IS_TEXT.equals(feature))
			//{
			//	regex.eSet(feature,Boolean.parseBoolean(element.getValue()));
			//} else {
				regex.eSet(feature,element.getValue());   
			//}
		//	allElements.put(elementId, regex);
		}
		else if (allElements.containsKey(elementId))
		{
			/*//if (InittypesPackage.Literals.TYPE__IS_TEXT.equals(feature))
			//{
				(allElements.get(elementId)).eSet(feature,Boolean.parseBoolean(element.getValue()));
			} else {*/
				(allElements.get(elementId)).eSet(feature,element.getValue());
			}
		//}
		/*if (allElements.get(elementId) instanceof Column)
		{
			Column column = (Column) allElements.get(elementId);
			column.setNumber(Integer.parseInt(elementId.replace("Column", ""))); //$NON-NLS-1$ //$NON-NLS-2$
		}*/
	}
	
	
/*	private static void manageDeletionParameters(Map<String, DeletionParemeter> allDeletionParameters, Entry<String, String> element, EClass eclass, EStructuralFeature feature)
	{
		if (element.getValue() == null || element.getValue().length() == 0)
		{
			Activator.getDefault().getLog().log(new Status(Status.WARNING, Activator.PLUGIN_ID, "The deletion parameter : " + element.getKey() + "=" + element.getValue() + " has been ignored because it is empty")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return;
		}
		String elementId = element.getKey().replace("Name", ""); //$NON-NLS-1$ //$NON-NLS-2$
		elementId = elementId.replace("Regex", ""); //$NON-NLS-1$ //$NON-NLS-2$
		if (!allDeletionParameters.containsKey(elementId))
		{
			DeletionParemeter param = create(eclass);
			param.eSet(feature,element.getValue());   
			allDeletionParameters.put(elementId, param);
		}
		else if (allDeletionParameters.containsKey(elementId))
		{
			(allDeletionParameters.get(elementId)).eSet(feature,element.getValue());
		}
	}*/


	@SuppressWarnings("unchecked")
	public static <T> T create (EClass eclass)
	{
		return (T) eclass.getEPackage().getEFactoryInstance().create(eclass);
	}

	private boolean fileDeleted(IFile resource)
	{
		boolean result = false;
		final String resourceName = getMethodName(resource);
		FileType ft = Iterables.find(typeModel.getFileTypes(), new Predicate<FileType>() {
			@Override
			public boolean apply(FileType arg0) {
				return Objects.equal(resourceName, arg0.getName());
			}
		},null);
		if (ft != null){
			EcoreUtil.delete(ft);
		}
		return result;
	}

	private void fileUpdated(IFile resource)
	{
		fileDeleted(resource);
		fileAdded(resource);
	}

	public boolean visit(IResourceDelta delta) throws CoreException
	{
		if (delta.getResource() != null)
		{
			switch (delta.getKind())
			{
			case IResourceDelta.ADDED:
				visit(delta.getResource());
				break;
			case IResourceDelta.REMOVED:
				visit(delta.getResource(), kind.DELETE);
				break;
			case IResourceDelta.CHANGED:
				visit(delta.getResource(), kind.MODIFY);
				break;
			}

		}
		return true;
	}

	/**
	 * return the type model
	 * @return type model
	 */
	public TypeModel getTypeModel()
	{
		return typeModel;
	}

	@SuppressWarnings("unchecked")
	/*public <T> List<T> getElementsByType(DocumentType documentType, final EClass eclass)
	{
		return (List<T>) Lists.newArrayList(Iterables.filter(documentType.getRequirements(), new Predicate<Requirement>()
			{
			public boolean apply(Requirement input)
			{
				return eclass.equals(input.eClass());
			}
			}));
	}*/
	
	public static void save(IFile typesFile, FileType fileType)
	{
		save(typesFile, Collections.singleton(fileType));
	}

	public static void save(IFile typesFile, Collection<FileType> fileTypes)
	{
		Ini ini = new Wini();

		StringBuilder typeNames = new StringBuilder();

		/*if (!fileTypes.isEmpty()) {
			for (FileType documentType : fileTypes) {
				//typeNames.append(documentType.getName());
				//typeNames.append(',');
				createDocumentTypeSection(ini, documentType);
			}
			// remove last ,
			typeNames.deleteCharAt(typeNames.length() - 1);
		}*/

		Section section = ini.add("Types"); //$NON-NLS-1$
		section.add("Names", typeNames); //$NON-NLS-1$

		URI uri = typesFile.getLocationURI();

		try
		{

			ini.store(new File(uri));

			if (!typesFile.exists())
			{
				typesFile.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (CoreException e)
		{
			e.printStackTrace();
		}
		
	}

	//--private static void createDocumentTypeSection(Ini ini, DocumentType documentType) {
	//--	Section section ;//= ini.add(documentType.getName());
		//section.add("Hierarchical", documentType.isHierarchical()); //$NON-NLS-1$

		//DeletionParameters deletionParameters = documentType.getDeletionParameters();
	/*	if (deletionParameters != null) {
			section.add("DeletionParameterIdRegex", deletionParameters.getRegexId()); //$NON-NLS-1$
			section.add("DeletionParameterDescriptionRegex", deletionParameters.getRegexDescription()); //$NON-NLS-1$
			section.add("DeletionIsAnd",deletionParameters.isIsAnd()); //$NON-NLS-1$
			// All the deletion parameters of the attributes
			int iAttr = 0;
			for(DeletionParemeter delParam:documentType.getDeletionParameters().getRegexAttributes()){
				section.add("DeletionParameterAttribute"+iAttr+"Name", delParam.getNameAttribute()); //$NON-NLS-1$ //$NON-NLS-2$
				section.add("DeletionParameterAttribute"+iAttr+"Regex", delParam.getRegexAttribute()); //$NON-NLS-1$ //$NON-NLS-2$
				iAttr++;
			}
			for(DeletionParemeter filterParam:documentType.getDeletionParameters().getFilterRegexAttributes()){
				section.add("FilterParameterAttribute"+iAttr+"Name", filterParam.getNameAttribute()); //$NON-NLS-1$ //$NON-NLS-2$
				section.add("FilterParameterAttribute"+iAttr+"Regex", filterParam.getRegexAttribute()); //$NON-NLS-1$ //$NON-NLS-2$
				iAttr++;
			}
		}*/

		/*String endText = documentType.getTextType();
		if (endText != null && endText.length() > 0)
		{
			section.add("EndText", endText); //$NON-NLS-1$
		}
		String descriptionRegex = documentType.getTextRegex();
		if (descriptionRegex != null && descriptionRegex.length()>0)
		{
			section.add("DescriptionRegex", descriptionRegex); //$NON-NLS-1$
		}

		Type id = documentType.getId();
		if (id instanceof Column)
		{
			section.add("Requirement" + ((Column)id).getNumber() + "Column", ((Column) id).getExpression()); //$NON-NLS-1$ //$NON-NLS-2$
		}
		else if (id instanceof Style)
		{
			section.add("Requirement1Style", ((Style) id).getLabel()); //$NON-NLS-1$
			section.add("Requirement1", ((Style) id).getExpression()); //$NON-NLS-1$
		}
		else if (id instanceof Regex)
		{
			section.add("Requirement1", ((Regex) id).getExpression()); //$NON-NLS-1$
		}*/

		//int i = 0;

		//for (Requirement type : documentType.getRequirements())
		//{
			/*if (type instanceof Column)
			{
				Column column = (Column) type;
				section.add("Column"+column.getNumber()+"Name", column.getName()); //$NON-NLS-1$ //$NON-NLS-2$
				section.add("Column"+column.getNumber()+"IsText", column.isIsText()); //$NON-NLS-1$ //$NON-NLS-2$
				if (column.getExpression() != null && column.getExpression().length() > 0)
				{
					section.add("Column"+column.getNumber(), column.getExpression()); //$NON-NLS-1$
				}

			}
			else if (type instanceof Style)
			{
				Style style = (Style) type;
				section.add("Style" + i + "Name", style.getName()); //$NON-NLS-1$ //$NON-NLS-2$
				section.add("Style" + i + "Label", style.getLabel()); //$NON-NLS-1$ //$NON-NLS-2$
				section.add("Style" + i + "IsText", style.isIsText()); //$NON-NLS-1$ //$NON-NLS-2$
				if (style.getExpression() != null  && style.getExpression().length() > 0)
				{
					section.add("Style" + i, style.getExpression()); //$NON-NLS-1$
				}
				i++;
			}*/
		// if (type instanceof Regex)
			//{
			//	Regex regex = (Regex) type;
				//section.add("Attribute" + i + "Name", regex.getName()); //$NON-NLS-1$ //$NON-NLS-2$
				//section.add("Attribute" + i, regex.getExpression()); //$NON-NLS-1$
				//section.add("Attribute" + i + "IsText", regex.isIsText()); //$NON-NLS-1$ //$NON-NLS-2$
	//			i++;
		//	}
	//	}
//	}*/
	
	

	
			 

}
