package org.polarsys.reqcycle.repository.connector.document;

import org.polarsys.reqcycle.inittypes.inittypes.Requirement;

public class DocRequirementModele {
	private int position;
	private Requirement requirement;
	private String result;
	
	public DocRequirementModele(int position, Requirement requirement,
			String result) {
		super();
		this.position = position;
		this.requirement = requirement;
		this.result = result;
	}
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Requirement getRequirement() {
		return requirement;
	}
	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	

}
