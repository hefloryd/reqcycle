package org.polarsys.reqcycle.repository.connector.document;

public class DocSectionModele {
	private String name;
	private String nameParent;
	private int position;
	private String uri;
	
	public DocSectionModele(String name, String nameParent, int position,String uri) {
		this.name = name;
		this.nameParent = nameParent;
		this.position = position;
		this.uri = uri;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameParent() {
		return nameParent;
	}

	public void setNameParent(String nameParent) {
		this.nameParent = nameParent;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	

}
