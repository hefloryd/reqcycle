package org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility.pdf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.pdf.PDFParserConfig;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import com.google.common.collect.Sets;

public class PDFParser implements Parser{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Set<MediaType> getSupportedTypes(ParseContext arg0) {
		return Sets.newHashSet(MediaType.application("pdf"));
	}

	@Override
	public void parse(InputStream input, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) throws IOException, SAXException, TikaException {
		ParseContext context = new ParseContext();
		PDFParserConfig config = new PDFParserConfig();
		D2MAdvancedPDF2HTML strip = new D2MAdvancedPDF2HTML(contentHandler, parseContext, metadata, new PDFParserConfig());
		PDDocument  doc = PDDocument.load(input);
		strip.process(doc, contentHandler, context, metadata,config);
	}

}
