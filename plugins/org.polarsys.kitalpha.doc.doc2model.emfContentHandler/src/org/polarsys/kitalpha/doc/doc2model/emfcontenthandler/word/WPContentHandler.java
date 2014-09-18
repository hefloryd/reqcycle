package org.polarsys.kitalpha.doc.doc2model.emfcontenthandler.word;

import org.polarsys.kitalpha.doc.doc2model.core.IContentHandler;
import org.polarsys.kitalpha.doc.doc2model.core.ModelContentHandler;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile;

public class WPContentHandler implements IContentHandler<WPFile> {
	

	private WPSAXContentHandler wpsaxContentHandler;
	
	
	public WPContentHandler() {
	}

	@Override
	public ModelContentHandler<WPFile> getContentHandler() {
		if (wpsaxContentHandler == null){
			wpsaxContentHandler = new WPSAXContentHandler();
		}
		return wpsaxContentHandler;
	}

	@Override
	public Class<WPFile> getDocumentClass() {
		return WPFile.class;
	}

	@Override
	public String getLabel() {
		return "Word Processor";
	}
}
