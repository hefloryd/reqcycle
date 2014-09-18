package org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility;

import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.ParseContext;

public abstract class AbstractTikaParser implements ITikaParser {

	@Override
	public boolean handles(String fileType) {
		for (MediaType mediaType : getParser().getSupportedTypes(new ParseContext())){
			if (mediaType.toString().equals(fileType)){
				return true;
			}
		}
		return false;
	}

}
