package org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility.pdf;

import org.apache.tika.parser.Parser;
import org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility.AbstractTikaParser;

public class PDFTikaParser extends AbstractTikaParser{

	@Override
	public Parser getParser() {
		return new PDFParser();
	}


}
