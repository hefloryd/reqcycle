package org.polarsys.reqcycle.repository.connector.rmf;

import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.polarsys.reqcycle.repository.connector.ICallable;
import org.polarsys.reqcycle.repository.connector.rmf.ui.RMFSettingPage;
import org.polarsys.reqcycle.repository.connector.rmf.ui.RMFSettingPage.RMFSettingPageBean;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementsContainer;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.repository.data.util.IRequirementSourceProperties;

public class RMFCallable implements ICallable {

	/** Page containing the ReqIF file and skip mapping check box */
	protected RMFSettingPage settingPage;

	protected Collection mapping;

	protected RMFSettingPageBean settingPageBean;

	protected boolean edition = false;

	@Inject
	IDataManager dataManager;

	@Override
	public void fillRequirementSource(RequirementSource requirementSource) throws Exception {

		Scope scope = null;
		IDataModel model = null;
		String requirementsResourcePath = null;

		if (settingPageBean != null) {
			scope = settingPageBean.getScope();
			model = settingPageBean.getDataPackage();
			requirementsResourcePath = settingPageBean.getDestinationPath();
			// requirementSource.setProperty("DataModel_NAME", model.getName());
			// requirementSource.setProperty("SCOPE_NAME", scope.getName());
			// requirementSource.setProperty(IRequirementSourceProperties.PROPERTY_URI,settingPageBean.getUri());
			Boolean isCopy = settingPageBean.getIsCopy();
			if (isCopy && requirementsResourcePath != null && !requirementsResourcePath.isEmpty()) {
				RequirementsContainer rc = dataManager.createRequirementsContainer(URI.createPlatformResourceURI(requirementsResourcePath, true));
				requirementSource.setContents(rc);
			}
			requirementSource.setProperty(IRequirementSourceProperties.IS_LOCAL, isCopy.toString());
		}

		if (((settingPageBean != null && !settingPageBean.getSkipMapping()) || edition) && mapping != null && !mapping.isEmpty()) {
			// it's an edition or a creation without skipping the
			// mapping
			requirementSource.getMappings().clear();
			requirementSource.getMappings().addAll(mapping);
			// requirementSource.getRequirements().clear();
			RMFUtils.fillRequirements(requirementSource, new NullProgressMonitor(), scope);
		}

	}

}
