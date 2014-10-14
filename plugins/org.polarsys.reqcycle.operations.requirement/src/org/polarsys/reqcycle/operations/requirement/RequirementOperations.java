package org.polarsys.reqcycle.operations.requirement;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.reqcycle.operations.IOperation;
import org.polarsys.reqcycle.operations.IOperation.Result;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementsContainer;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class RequirementOperations {

	@Inject
	IReachableManager manager;

	public RequirementOperations() {
		ZigguratInject.inject(this);
	}

	@IOperation("Get requirement type")
	public String getRequirementType(Requirement req) {
		return req.eClass().getName();
	}
	
	@IOperation("Get the requirement source")
	public String getRequirementSource(Requirement req) {
		EObject container = req.eContainer();
		while (container != null){
			if (container instanceof RequirementsContainer){
				RequirementsContainer c = (RequirementsContainer) container;
				return c.getRequirementSource().getName();
			}
			container = container.eContainer();
		}
		return "";
	}

}
