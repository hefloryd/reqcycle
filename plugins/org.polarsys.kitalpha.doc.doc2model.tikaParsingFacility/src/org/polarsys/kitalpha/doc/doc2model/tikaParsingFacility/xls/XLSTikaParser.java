package org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility.xls;

import org.apache.tika.parser.Parser;
import org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility.AbstractTikaParser;

public class XLSTikaParser extends AbstractTikaParser{

	@Override
	public Parser getParser() {
		return new Doc2ModelExcelParser();
		};
	
}
