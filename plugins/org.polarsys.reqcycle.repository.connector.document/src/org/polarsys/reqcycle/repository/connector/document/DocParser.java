package org.polarsys.reqcycle.repository.connector.document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section;
import org.polarsys.reqcycle.inittypes.inittypes.Attribute;
import org.polarsys.reqcycle.inittypes.inittypes.Requirement;
import org.polarsys.reqcycle.repository.connector.ui.PropertyUtils;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.types.IAttribute;
import org.polarsys.reqcycle.repository.data.types.IRequirementType;
import org.polarsys.reqcycle.repository.data.types.IType;
import org.polarsys.reqcycle.repository.data.types.internal.ETypeImpl;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class DocParser {

	private  List<Requirement> inputRequirements; 
	private StringBuffer document; 
	//private DocSettingPage docSettingPage;
	private List<Section> sections;
	private HashMap<DocSectionModele, org.polarsys.reqcycle.repository.data.RequirementSourceData.Section> sectionMapping = new HashMap<DocSectionModele, org.polarsys.reqcycle.repository.data.RequirementSourceData.Section>();


	@Inject
	IDataManager manager;
	public void run(RequirementSource requirementSource) throws Exception {
		requirementSource.clearContent();
		ArrayList<DocRequirementModele> listReqModele = new ArrayList<DocRequirementModele>();
		List<DocSectionModele> listSectionModele = new ArrayList<DocSectionModele>();
		
		//---------------------PART1 - per treatment ------------------------//
		//remove the excluded area in a document
		String finalDoc = getFinalDocument();
		
		//--------------------- PART1 - create sections ----------------------//
		listSectionModele = createSections(requirementSource);
		
		//sorting the list listSectionModele per end position of the Section
		if (listSectionModele != null){
			Collections.sort(listSectionModele, new Comparator<DocSectionModele>() {

			@Override
			public int compare(DocSectionModele sec1, DocSectionModele sec2) {
				return (sec1.getPosition() < sec2.getPosition()) ? -1 : (sec1.getPosition() > sec2.getPosition()) ? 1 : 0;
				}
			});
		
		
		//--------------------- PART2 - sorting all requirements in document----------------------//
		if (inputRequirements != null){
		//transform a requirement input to model requirement. A model requirement is a requirement plus a position in document
				for(Requirement reqIn : inputRequirements){
													
					Pattern pattern = Pattern.compile(reqIn.getRegexReq().getExpression(),Pattern.MULTILINE|Pattern.DOTALL);
					Matcher matcher = pattern.matcher(finalDoc);
					    // check all occurrence of a requirement
					    while (matcher.find()) {
					    	if (matcher.groupCount() > 0){
					    		System.out.println("req "+matcher.group(1)+" --- position : "+matcher.end());
					    	   	listReqModele.add(new DocRequirementModele(matcher.end(), reqIn, matcher.group(1)));
				    	   	}
				    	   	else {
				    	   		System.out.println("req "+matcher.group()+" --- position : "+matcher.end());
						      	listReqModele.add(new DocRequirementModele(matcher.end(), reqIn, matcher.group()));
				    	   	}
				    	   	
					    }
				}
		
					   
		//sorting the list ListReqModele per end position of the requirement
		if (listReqModele != null){
			Collections.sort(listReqModele, new Comparator<DocRequirementModele>() {

			@Override
			public int compare(DocRequirementModele req1, DocRequirementModele req2) {
				return (req1.getPosition() < req2.getPosition()) ? -1 : (req1.getPosition() > req2.getPosition()) ? 1 : 0;
				}
			});
		}
		}
		
		}	
		
		//-------------------PART3 -- parsing all requirements and attributes ------------------------// 
	
		for (int i=0; i<listReqModele.size(); i++){
			IRequirementType requirementType = (IRequirementType) PropertyUtils.getDataModelFromSource(requirementSource).getType(listReqModele.get(i).getRequirement().getNameReq());
			if (requirementType == null) {
				// error
			}
						
			
			String startReq = listReqModele.get(i).getResult();
			String endReq ="\\Z";
			if(i+1<listReqModele.size()){
			endReq = listReqModele.get(i+1).getResult();
			}
			Pattern patternS= Pattern.compile("("+startReq+".*?)"+endReq,Pattern.MULTILINE|Pattern.DOTALL);
			Matcher matcherS = patternS.matcher(finalDoc);
			
			String documentSection = " ";
			 while (matcherS.find()) {	
				 if (matcherS.groupCount() > 0){
					 System.out.println("req "+matcherS.group(1)+" ------- position : "+matcherS.end());
				    documentSection = matcherS.group(1);
		    	   	}
		    	   	else
		    	   	{
		    	   	System.out.println("req "+matcherS.group()+" ------- position : "+matcherS.end());
				    documentSection = matcherS.group();
		    	   	}
			    	
			    }
			
			
			Pattern pattern= Pattern.compile(listReqModele.get(i).getRequirement().getRegexReq().getExpression(),Pattern.MULTILINE|Pattern.DOTALL);
			Matcher matcher = pattern.matcher(documentSection);
			    // check all occurrence of a requirement
			    while (matcher.find()) {
			    	org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement requirement = requirementType.createInstance();
			    	if (matcher.groupCount() > 0){
			    		System.out.println(matcher.group(1));
				    	requirement.setId(matcher.group(1));	
		    	   	}
		    	   	else {
		    	   		System.out.println(matcher.group());
				    	requirement.setId(matcher.group());	
		    	   	}	    			    	
			    
			    //check all attributes of a current requirement
					    	List<Attribute> Attributes = listReqModele.get(i).getRequirement().getAttributesReq();
					    	
					    	for(final Attribute att : Attributes){
					    		Pattern patternAtt = Pattern.compile(att.getRegexAttribute().getExpression(),Pattern.MULTILINE|Pattern.DOTALL);
								Matcher matcherAtt = patternAtt.matcher(documentSection);
								 while (matcherAtt.find()) {
									 IAttribute attFromType = Iterables.find(requirementType.getAttributes(), new Predicate<IAttribute>() {
										 @Override
										public boolean apply(IAttribute arg0) {
											return arg0.getName().equals(att.getNameAttribute());
										}
									 }
									,null);
									 Object value = null;
									if (attFromType == null){
										// error
									}
									else {
										String stringFromDocument = null;
										if (matcherAtt.groupCount() > 0){
											stringFromDocument = matcherAtt.group(1);
							    	   	}
							    	   	else {
							    	   		stringFromDocument = matcherAtt.group();
							    	   	}
										
										System.out.println("att : "+ att.getNameAttribute()+" :"+stringFromDocument);
										value = getValueFromString(stringFromDocument ,attFromType.getType());
									}
									manager.addAttributeValue(requirement, attFromType, value );
								}
													    	
					    	}
					    	org.polarsys.reqcycle.repository.data.RequirementSourceData.Section sect = findSectionForRequirement(listReqModele.get(i).getPosition(),listSectionModele);
					    	manager.addElementsToSection(sect, requirement);
					    
				 }
				}
			}

	
	private String getFinalDocument() {
		String doc = document.toString();
		String regex = "#start_exclusion.*?#end_exclusion";
		
		if(document != null){
			Pattern pat = Pattern.compile(regex,Pattern.MULTILINE|Pattern.DOTALL);
			Matcher matcher = pat.matcher(document);
			if(matcher.find()){
			doc = matcher.replaceAll(" ");
			}
					
		}

		return doc;
	}


	private org.polarsys.reqcycle.repository.data.RequirementSourceData.Section findSectionForRequirement(int positionReq, List<DocSectionModele> listSectionModele) {
		for (int i = 0; i < listSectionModele.size(); i++){
			
			if (i +1 == listSectionModele.size()){
				if ( (listSectionModele.get(i).getPosition() <= positionReq) ){
					return (org.polarsys.reqcycle.repository.data.RequirementSourceData.Section) sectionMapping.get(listSectionModele.get(i));
				}
			}
			else if (i +1 < listSectionModele.size())
			{
				if ( (listSectionModele.get(i).getPosition() <= positionReq) && (positionReq < listSectionModele.get(i+1).getPosition())){
					return (org.polarsys.reqcycle.repository.data.RequirementSourceData.Section) sectionMapping.get(listSectionModele.get(i));
				}
			}
		}
		return null;
	}


	private Object getValueFromString(String stringFromDocument, IType attributeType) {
		if (attributeType.getName().equalsIgnoreCase(ETypeImpl.BOOLEAN.getName())){
			return Boolean.valueOf(stringFromDocument);
		}
		else if (attributeType.getName().equalsIgnoreCase(ETypeImpl.STRING.getName())){
			return stringFromDocument;
		}
		else if (attributeType.getName().equalsIgnoreCase(ETypeImpl.INT.getName())){
			return Integer.valueOf(stringFromDocument);
		}
		return null;
	}
	
	private List<DocSectionModele> createSections(RequirementSource requirementSource){
		List<DocSectionModele> listSections = new ArrayList<DocSectionModele>();
		
		for (Section sect : sections){
						
			Pattern pattern = Pattern.compile(sect.getTitle().getTextContent(),Pattern.MULTILINE|Pattern.DOTALL);
			Matcher matcher = pattern.matcher(document);
			    // check all occurrence of a requirement
			    while (matcher.find()) {
		    	   	System.out.println("non section "+matcher.group()+" ------- position section: " + matcher.end());
		    	   
		    	   	org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement section = null;
		    		String nameParent = null;
		    		
		    		if (sect.getParent() == null){
		    			DocSectionModele sectionModele = new DocSectionModele(matcher.group(), nameParent, matcher.end(), null);
		    			listSections.add(sectionModele);
			    	   	section = manager.createSection(matcher.group(), matcher.group(), null);
			    		if(section != null) {
			    			manager.addElementsToSource(requirementSource, section);
			    			//mapping manager section and section modele
			    			sectionMapping.put(sectionModele, (org.polarsys.reqcycle.repository.data.RequirementSourceData.Section) section);
			    		}
		    		}
		    		else
		    		{
		    	   	nameParent = sect.getParent().getTitle().getTextContent(); 
		    	   	DocSectionModele sectionModele = new DocSectionModele(matcher.group(), nameParent, matcher.end(), null);
		    	   	listSections.add(sectionModele);
		    	   	section = manager.createSection(matcher.group(), matcher.group(), null);
			    		if(section != null) {
			    			org.polarsys.reqcycle.repository.data.RequirementSourceData.Section parentSection = (org.polarsys.reqcycle.repository.data.RequirementSourceData.Section) sectionMapping.get(sectionModele);
			    			if(parentSection != null){
			    				manager.addElementsToSection(parentSection, section);
			    			}
			    			sectionMapping.put(sectionModele, (org.polarsys.reqcycle.repository.data.RequirementSourceData.Section) section);
			    			
			    		}
		    	   	}
		    
			    }
			
		}
		
		return listSections;

	}


	public StringBuffer getDocument() {
		return document;
	}


	public void setDocument(StringBuffer document) {
		this.document = document;
	}
	

	public List<Requirement> getInputRequirements() {
		return inputRequirements;
	}


	public void setInputRequirements(List<Requirement> inputRequirements) {
		this.inputRequirements = inputRequirements;
	}


	public void setSections(List<Section> sections) {
		this.sections = sections;
		
	}
	

	public List<Section> getSections() {
		return sections;
	}


}
