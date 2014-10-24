package org.polarsys.reqcycle.repository.connector.rmf.ui;

import org.eclipse.rmf.reqif10.Specification;
import org.polarsys.reqcycle.repository.connector.rmf.RMFUtils;
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.AbstractStorageBean;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;

public class RMFBean extends AbstractStorageBean {

	private Specification specification;

	@Override
	public void storeProperties(RequirementSource source) {
		super.storeProperties(source);
		try {
			source.setProperty(RMFUtils.SPECIFICATION_ID, specification.getIdentifier());
			source.setProperty(RMFUtils.SPECIFICATION_NAME, specification.getLongName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Specification getSpecification() {
		return specification;
	}

	public void setSpecification(Specification specification) {
		this.specification = specification;
	}

}
