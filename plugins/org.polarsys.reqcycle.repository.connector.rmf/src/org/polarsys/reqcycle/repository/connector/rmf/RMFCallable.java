package org.polarsys.reqcycle.repository.connector.rmf;

import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.polarsys.reqcycle.repository.connector.ICallable;
import org.polarsys.reqcycle.repository.connector.rmf.ui.RMFSettingPage;
import org.polarsys.reqcycle.repository.connector.ui.PropertyUtils;
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.ISourceConstants;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementsContainer;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.data.types.IDataModel;

public class RMFCallable implements ICallable {

	/** Page containing the ReqIF file and skip mapping check box */
	protected RMFSettingPage settingPage;

	protected Collection mapping;

	public Collection getMapping() {
		return mapping;
	}

	public void setMapping(Collection mapping) {
		this.mapping = mapping;
	}

	@Inject
	IDataManager dataManager;

	@Override
	public void fillRequirementSource(RequirementSource requirementSource) throws Exception {

		Scope scope = null;
		IDataModel model = null;
		String requirementsResourcePath = null;

		scope = PropertyUtils.getScopeFromSource(requirementSource);
		model = PropertyUtils.getDataModelFromSource(requirementSource);
		requirementsResourcePath = requirementSource.getProperty(ISourceConstants.DESTINATION_PATH);

		Boolean isCopy = Boolean.parseBoolean(requirementSource.getProperty(IRMFConstants.RMF_IS_COPY));
		if (isCopy && requirementsResourcePath != null && !requirementsResourcePath.isEmpty()) {
			RequirementsContainer rc = dataManager.createRequirementsContainer(URI.createPlatformResourceURI(requirementsResourcePath, true));
			requirementSource.setContents(rc);
		}

		// Collection mapping = PropertyUtils.getEObjectsInSource(requirementSource, IRMFConstants.RMF_MAPPING);
		if (mapping != null && !mapping.isEmpty()) {
			// it's an edition or a creation without skipping the
			// mapping
			requirementSource.getMappings().clear();
			requirementSource.getMappings().addAll(mapping);
			RMFUtils.fillRequirements(requirementSource, new NullProgressMonitor(), scope);
		}

	}
}
