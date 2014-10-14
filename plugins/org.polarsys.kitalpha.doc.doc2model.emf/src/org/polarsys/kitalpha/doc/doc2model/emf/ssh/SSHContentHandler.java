package org.polarsys.kitalpha.doc.doc2model.emf.ssh;

import org.polarsys.kitalpha.doc.doc2model.core.IContentHandler;
import org.polarsys.kitalpha.doc.doc2model.core.ModelContentHandler;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetFile;

public class SSHContentHandler implements IContentHandler<SpreadsheetFile> {

	@Override
	public ModelContentHandler<SpreadsheetFile> getContentHandler() {
		return new SSHSAXContentHandler();
	}

	@Override
	public Class<SpreadsheetFile> getDocumentClass() {
		return SpreadsheetFile.class;
	}
	
	@Override
	public String getLabel() {
		return "Spreadsheet";
	}

}
