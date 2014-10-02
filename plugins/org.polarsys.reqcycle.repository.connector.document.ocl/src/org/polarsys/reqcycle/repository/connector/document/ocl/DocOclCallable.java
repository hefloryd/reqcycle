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
package org.polarsys.reqcycle.repository.connector.document.ocl;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.polarsys.kitalpha.doc.doc2model.common.Common.DocumentModel;
import org.polarsys.kitalpha.doc.doc2model.core.Doc2Model;
import org.polarsys.reqcycle.ocl.OCLCallable;
import org.polarsys.reqcycle.repository.connector.document.ocl.ui.OCLDocBean;
import org.polarsys.reqcycle.repository.connector.ui.PropertyUtils;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;

public final class DocOclCallable extends OCLCallable {
	@Override
	protected TreeIterator<EObject> getIterator(RequirementSource requirementSource, ResourceSet resourceSet) {
		URI docUri = URI.createURI(PropertyUtils.getURI(requirementSource));
		String fileString = CommonPlugin.asLocalURI(docUri).toFileString();
		String className = requirementSource.getProperty(OCLDocBean.CLASS_NAME);
		//String fileType = doc2model.getFileType(fileString);
		DocumentModel result = null;
		Doc2Model<DocumentModel> doc2model = new Doc2Model<DocumentModel>();
		doc2model.setContentHandler(doc2model.getContentHandler(fileString, className));
		result = doc2model.transform(fileString, DocumentModel.class).getDocModel();
		return result.eAllContents();
	}
}