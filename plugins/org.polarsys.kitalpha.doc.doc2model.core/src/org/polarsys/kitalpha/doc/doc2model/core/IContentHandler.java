package org.polarsys.kitalpha.doc.doc2model.core;


public interface IContentHandler<T> {
	public Class<T> getDocumentClass();
	public ModelContentHandler<T> getContentHandler();
	public String getLabel () ;
}
