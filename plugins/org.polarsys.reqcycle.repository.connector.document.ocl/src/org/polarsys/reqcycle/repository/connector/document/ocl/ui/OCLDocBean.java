package org.polarsys.reqcycle.repository.connector.document.ocl.ui;

import org.eclipse.jface.wizard.IWizard;
import org.polarsys.reqcycle.ocl.ui.SettingBean;
import org.polarsys.reqcycle.repository.connector.document.ocl.Activator;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;

public class OCLDocBean extends SettingBean {

	public static String CLASS_NAME = Activator.PLUGIN_ID + ".className" ;
	
	private String className;

	public OCLDocBean(IWizard wizard) {
		super(wizard);
	}

	public void setHandlerClassName(String name) {
		this.className = name;
	}
	
	@Override
	public void storeProperties(RequirementSource source) {
		super.storeProperties(source);
		try {
			source.setProperty(CLASS_NAME, className);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
