package org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility.pdf;

import org.apache.pdfbox.pdmodel.PDPage;

public class PageElement implements DocumentElement{



	PDPage _page;

	public PageElement(PDPage page ) {
		_page = page;
	}

	public PDPage getPage() {
		return _page;
	}

}
