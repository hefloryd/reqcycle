package org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability;

import org.polarsys.reqcycle.traceability.engine.Request;

public interface IRequestManager {

	public Request getUpwardRequest(EReachable source);

	public Request getDownwardRequest(EReachable source);

}
