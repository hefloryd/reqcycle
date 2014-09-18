package org.polarsys.kitalpha.doc.doc2model.core;


import org.xml.sax.ContentHandler;

public interface ModelContentHandler<T> extends ContentHandler {
	T getResult ();
}