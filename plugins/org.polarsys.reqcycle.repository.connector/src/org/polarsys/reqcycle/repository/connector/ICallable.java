package org.polarsys.reqcycle.repository.connector;

import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;

public interface ICallable {
	void fillRequirementSource(RequirementSource source) throws Exception;
}
