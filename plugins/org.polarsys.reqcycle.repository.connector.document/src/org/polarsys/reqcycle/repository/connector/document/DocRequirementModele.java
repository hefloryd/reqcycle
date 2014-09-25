/*******************************************************************************
 *  Copyright (c) 2013, 2014 AtoS and others
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *  Malick WADE (AtoS) - initial API and implementation and/or initial documentation
 *
 *******************************************************************************/
package org.polarsys.reqcycle.repository.connector.document;

import org.polarsys.reqcycle.repository.data.MappingModel.MappingElement;

public class DocRequirementModele {
	private int position;
	private MappingElement requirement;
	private String result;
	
	public DocRequirementModele(int position, MappingElement reqIn,	String result) {
		super();
		this.position = position;
		this.requirement = reqIn;
		this.result = result;
	}
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public MappingElement getRequirement() {
		return requirement;
	}
	public void setRequirement(MappingElement requirement) {
		this.requirement = requirement;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	

}
