package org.polarsys.reqcycle.operations;

import java.util.Collection;

public interface IReqCycleOperationManager {
	Collection<ReqCycleOperation> getAllOperations ();
	
	// Retrieve the operation with its name and all its parameters
	// for execution
	ReqCycleOperation getOperation (String name, Class<?>[] listClass);
	
	// Retrieve the operation with its name and all its parameters except the first
	// (the object on which the operation is executed) to edit these parameters
	ReqCycleOperation getOperationForEditingAttributes (String name, Class<?>[] listClass);
}
