package org.polarsys.reqcycle.repository.connector.rmf;

import javax.inject.Inject;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.polarsys.reqcycle.repository.connector.ICallable;
import org.polarsys.reqcycle.repository.connector.rmf.ui.RMFSettingPage;
import org.polarsys.reqcycle.repository.connector.ui.PropertyUtils;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;

public class RMFCallable implements ICallable {

	/** Page containing the ReqIF file and skip mapping check box */
	protected RMFSettingPage settingPage;

	@Inject
	IDataManager dataManager;

	@Override
	public void fillRequirementSource(RequirementSource requirementSource) throws Exception {
		Scope scope = PropertyUtils.getScopeFromSource(requirementSource);

		RMFUtils.fillRequirements(requirementSource, new NullProgressMonitor(), scope);
	}
}
