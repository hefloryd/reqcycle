package org.polarsys.kitalpha.doc.doc2model.tikaparsing.doc;

import java.util.Set;

import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.polarsys.kitalpha.doc.doc2model.tikaparsing.AbstractTikaParser;

import com.google.common.collect.Sets;

public class DocTikaParser extends AbstractTikaParser{

	public Parser getParser() {
		return new AutoDetectParser(){
			@Override
			public Set<MediaType> getSupportedTypes(ParseContext context) {
				return Sets.newHashSet(MediaType.application("msword"),MediaType.application("vnd.openxmlformats-officedocument.wordprocessingml.document"));
			}
		};
	}

}
