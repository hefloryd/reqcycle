package org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility;

import org.apache.tika.parser.Parser;

public interface ITikaParser {
	Parser getParser ();
	boolean handles (String fileType);
}
