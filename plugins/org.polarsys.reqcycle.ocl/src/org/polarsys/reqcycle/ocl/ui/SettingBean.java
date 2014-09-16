package org.polarsys.reqcycle.ocl.ui;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.polarsys.reqcycle.ocl.IOCLConstants;
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.AbstractStorageBean;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;

public class SettingBean extends AbstractStorageBean {

	/**
	 * 
	 */
	private final IWizard wizard;
	private String oclUri = "";

	public SettingBean(IWizard oclConnector) {
		this.wizard = oclConnector;
	}

	public String getOclUri() {
		return oclUri;
	}

	public void setOclUri(String oclUri) {
		this.oclUri = oclUri;
		notifyChange();
	}

	public void notifyChange() {
		IWizardPage[] pages = this.wizard.getPages();
		if (pages != null) {
			for (int i = 0; i < pages.length; i++) {
				IWizardPage iWizardPage = pages[i];
				iWizardPage.getWizard().getContainer().updateButtons();
				if (iWizardPage instanceof Listener) {
					((Listener) iWizardPage).handleEvent(new Event());
				}
			}
		}
	}

	@Override
	public void storeProperties(RequirementSource source) {
		super.storeProperties(source);
		try {
			source.setProperty(IOCLConstants.OCL_URI, this.getOclUri());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}