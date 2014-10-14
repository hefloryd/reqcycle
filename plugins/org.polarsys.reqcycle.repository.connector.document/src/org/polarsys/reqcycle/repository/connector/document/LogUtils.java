package org.polarsys.reqcycle.repository.connector.document;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.polarsys.reqcycle.core.ILogger;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class LogUtils {
	static ILogger logger = ZigguratInject.make(ILogger.class);
	
	public static boolean isDebug (){
		return logger.isDebug(org.polarsys.reqcycle.repository.connector.Activator.OPTIONS_DEBUG, org.polarsys.reqcycle.repository.connector.Activator.getDefault());
	}
	
	public static void log (String log) {
		logger.log(new Status(IStatus.INFO, Activator.PLUGIN_ID, log));
	}
	
}
