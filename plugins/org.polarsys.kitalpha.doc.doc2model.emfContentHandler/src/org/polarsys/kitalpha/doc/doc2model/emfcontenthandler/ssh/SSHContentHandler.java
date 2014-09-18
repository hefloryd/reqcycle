package org.polarsys.kitalpha.doc.doc2model.emfcontenthandler.ssh;

import org.polarsys.kitalpha.doc.doc2model.core.IContentHandler;
import org.polarsys.kitalpha.doc.doc2model.core.ModelContentHandler;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.ExcelFile;

public class SSHContentHandler implements IContentHandler<ExcelFile> {

	@Override
	public ModelContentHandler<ExcelFile> getContentHandler() {
		return new SSHSAXContentHandler();
	}

	@Override
	public Class<ExcelFile> getDocumentClass() {
		return ExcelFile.class;
	}
	
	@Override
	public String getLabel() {
		return "Spreadsheet";
	}

}
