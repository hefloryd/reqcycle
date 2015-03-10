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
package org.polarsys.reqcycle.repository.connector.ui.wizard.pages;

import org.eclipse.emf.common.util.URI;
import org.polarsys.reqcycle.repository.connector.ui.PropertyUtils;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.data.types.IDataModel;

public class AbstractStorageBean {
	private String uri;
	private String outputPath;
	private Scope scope;
	private IDataModel dataModel;
	private String name;
	private String fileName;
	private String dataModelUri;
	private Boolean isReference = false;

	public void storeProperties(RequirementSource source) {
		try {
			source.setRepositoryURI(getUri());
			if (!getIsReference()) {
				source.setDestinationURI(getOutputPath());
			}
			source.setDataModelURI(getDataModel().getDataModelURI());
			PropertyUtils.setScopeInSource(source, getScope());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		// prevent error with whitespaces
		URI u = URI.createURI(uri);
		if (u.isFile()) {
			this.uri = URI.createFileURI(u.toFileString()).toString();
		} else if (u.isPlatform()) {
			this.uri = URI.createPlatformResourceURI(u.toPlatformString(true), false).toString();
		} else {
			this.uri = uri;
		}
	}

	public String getOutputPath() {
		return outputPath;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	public Scope getScope() {
		return scope;
	}

	public void setScope(Scope scope) {
		this.scope = scope;
	}

	public IDataModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(IDataModel model) {
		this.dataModel = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDataModelUri() {
		return dataModelUri;
	}

	public void setDataModelUri(String dataModelUri) {
		this.dataModelUri = dataModelUri;
	}

	public Boolean getIsReference() {
		return isReference;
	}

	public void setIsReference(Boolean isReference) {
		this.isReference = isReference;
	}

}
