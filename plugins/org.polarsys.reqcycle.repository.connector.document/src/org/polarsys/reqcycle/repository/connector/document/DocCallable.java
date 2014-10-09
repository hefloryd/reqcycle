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
package org.polarsys.reqcycle.repository.connector.document;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement;
import org.polarsys.kitalpha.doc.doc2model.common.Common.DocumentModel;
import org.polarsys.kitalpha.doc.doc2model.core.Doc2Model;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Cell;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Row;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.SectionContents;
import org.polarsys.reqcycle.inittypes.inittypes.Requirement;
import org.polarsys.reqcycle.repository.connector.ICallable;
import org.polarsys.reqcycle.repository.connector.ui.PropertyUtils;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class DocCallable implements ICallable {

	@Inject
	IDataManager dataManager;
	
	protected DocParser parser = ZigguratInject.make(DocParser.class);
	private ArrayList<Section> sections;
	protected List<ContentElement> listContentElement;
	List<Requirement> listValideRequirements = new ArrayList<Requirement>();

	@Override
	public void fillRequirementSource(RequirementSource source){
		RequirementSource reqSource = source;

		//transform doc to modele
		parser.setDocument(getDocumentFromModele(reqSource));
		parser.setSections(sections);		
		source.setDefaultScope(PropertyUtils.getScopeFromSource(source));
		try {
			parser.run(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public void setParser(DocParser parser) {
		this.parser = parser;
	}	
	
	protected StringBuffer getDocumentFromModele(RequirementSource source) {
		StringBuffer doc = new StringBuffer();
		if(source.getRepositoryURI() != null){
			URI docUri = URI.createURI(source.getRepositoryURI());	
			String fileString = CommonPlugin.asLocalURI(docUri).toFileString();
			Doc2Model<DocumentModel> doc2model = new Doc2Model<DocumentModel>();
			String fileType = doc2model.getFileType(fileString);
			
			sections = new ArrayList<Section>();
			
			if (fileType != null && fileType.length() > 0){
				DocumentModel result = doc2model.transform(fileString, DocumentModel.class).getDocModel();
				if (result == null){
					return new StringBuffer("");
				}
				listContentElement = new ArrayList<ContentElement>();
				
				TreeIterator<EObject> i = result.eAllContents();
				while (i.hasNext()){
					EObject e = i.next();
					if (e instanceof ContentElement && !(e instanceof SectionContents)) {
						ContentElement content = (ContentElement) e;
						listContentElement.add(content);
						doc.append(content.getTextContent());
					}
					if ((e instanceof SectionContents) || ( e instanceof Row) || (e instanceof Cell) ){
						doc.append(" ");
					}
					if (e instanceof Section){
						Section section = (Section) e;
						System.out.println(section.getTitle().getTextContent());
						if(section.getParent() != null)
						System.out.println(section.getParent().getTitle().toString());
						sections.add(section);
						
					}
				}
				System.out.println("DEBUT DOC");
				System.out.println(doc);
				System.out.println("FIN DOC");
			}		
		
		}
		return doc;
	}

	public void setListVReq(List<Requirement> listValideRequirements) {
	this.listValideRequirements = listValideRequirements;
		
	}

	
}
