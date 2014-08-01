package org.polarsys.reqcycle.operations.requirement;

import javax.inject.Inject;

import org.polarsys.reqcycle.operations.IOperation;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class RequirementOperations {

	@Inject
	IReachableManager manager;

	public RequirementOperations() {
		ZigguratInject.inject(this);
	}

	@IOperation("Get requirement type")
	String getRequirementType(Requirement req) {
		return req.eClass().getName();
	}

}
