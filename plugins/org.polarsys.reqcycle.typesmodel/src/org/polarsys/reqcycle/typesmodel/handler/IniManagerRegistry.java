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
		String[] strs = strToParse.split(","); 
		for (String str : strs) {
			if (!"".equals(str)) { 
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
	
	public static void save(IFile typesFile, FileType fileType)
	{
		save(typesFile, Collections.singleton(fileType));
	}

	public static void save(IFile typesFile, Collection<FileType> fileTypes)
	{
		Ini ini = new Wini();

		StringBuilder typeNames = new StringBuilder();

		Section section = ini.add("Types"); 
		section.add("Names", typeNames); 

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

}
