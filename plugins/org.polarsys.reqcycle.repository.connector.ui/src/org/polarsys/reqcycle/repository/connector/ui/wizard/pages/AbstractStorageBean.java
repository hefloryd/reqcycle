package org.polarsys.reqcycle.repository.connector.ui.wizard.pages;

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

	public void storeProperties(RequirementSource source) {
		try {
			source.setProperty(ISourceConstants.PROPERTY_URI, getUri());
			source.setProperty(ISourceConstants.DESTINATION_PATH,
					getOutputPath());
			// setName(value)
			source.setProperty(ISourceConstants.NAME, getName());
			source.setProperty(ISourceConstants.DATA_MODEL, getDataModel()
					.getName());
			source.setProperty(ISourceConstants.DATA_MODEL_URI, getDataModel()
					.getDataModelURI());
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
		this.uri = uri;
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

}
