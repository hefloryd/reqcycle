package org.polarsys.reqcycle.operations;

import java.util.Collection;

public interface IReqCycleOperationManager {
	Collection<ReqCycleOperation> getAllOperations ();
	ReqCycleOperation getOperation (String name, Class<?>[] listClass);
}
