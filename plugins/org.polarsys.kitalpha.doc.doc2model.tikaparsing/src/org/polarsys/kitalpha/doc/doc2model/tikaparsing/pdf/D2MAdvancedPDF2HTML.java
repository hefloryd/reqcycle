package org.polarsys.kitalpha.doc.doc2model.tikaparsing.pdf;

import java.awt.Color;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentNameDictionary;
import org.apache.pdfbox.pdmodel.PDEmbeddedFilesNameTreeNode;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDEmbeddedFile;
import org.apache.pdfbox.pdmodel.interactive.action.type.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.type.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.apache.pdfbox.util.TextPosition;
import org.apache.tika.exception.TikaException;
import org.apache.tika.extractor.EmbeddedDocumentExtractor;
import org.apache.tika.extractor.ParsingEmbeddedDocumentExtractor;
import org.apache.tika.io.IOExceptionWithCause;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParserConfig;
import org.apache.tika.sax.EmbeddedContentHandler;
import org.apache.tika.sax.XHTMLContentHandler;
import org.polarsys.kitalpha.doc.doc2model.tikaparsing.pdf.Paragraph.ParagraphType;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class D2MAdvancedPDF2HTML extends Doc2ModelTextStripper {


	/**
	 * format used for signature dates
	 */
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

	/**
	 * Maximum recursive depth during AcroForm processing.
	 * Prevents theoretical AcroForm recursion bomb. 
	 */
	private final static int MAX_ACROFORM_RECURSIONS = 10;


	// TODO: remove once PDFBOX-1130 is fixed:
	private boolean inParagraph = false;
	List<DocumentElement>_documentElements = new LinkedList<DocumentElement>();
	Paragraph _lastParagraph = null;
	String _lastChunk = "";
	Style _lastStyle = new Style(Color.black,11,false);


	//Attributes needed to detect Header	
	Map<String,Float> headerPatternMap = new HashMap<String,Float>();






	/**
	 * Converts the given PDF document (and related metadata) to a stream
	 * of XHTML SAX events sent to the given content handler.
	 *
	 * @param document PDF document
	 * @param handler SAX content handler
	 * @param metadata PDF metadata
	 * @throws SAXException if the content handler fails to process SAX events
	 * @throws TikaException if the PDF document can not be processed
	 */
	public static void process(
			PDDocument document, ContentHandler handler, ParseContext context, Metadata metadata,
			PDFParserConfig config)
					throws SAXException, TikaException {
		try {
			// Extract text using a dummy Writer as we override the
			// key methods to output to the given content
			// handler.
			D2MAdvancedPDF2HTML pdf2XHTML = new D2MAdvancedPDF2HTML(handler, context, metadata, config);

			pdf2XHTML.writeText(document, new Writer() {
				@Override
				public void write(char[] cbuf, int off, int len) {
				}
				@Override
				public void flush() {
				}
				@Override
				public void close() {
				}
			});

		} catch (IOException e) {
			if (e.getCause() instanceof SAXException) {
				throw (SAXException) e.getCause();
			} else {
				throw new TikaException("Unable to extract PDF content", e);
			}
		}
	}

	private final ContentHandler originalHandler;
	private final ParseContext context;
	private final XHTMLContentHandler handler;
	private final PDFParserConfig config;


	public D2MAdvancedPDF2HTML(ContentHandler handler, ParseContext context, Metadata metadata, 
			PDFParserConfig config)
					throws IOException {
		//source of config (derives from context or PDFParser?) is
		//already determined in PDFParser.  No need to check context here.
		this.config = config;
		this.originalHandler = handler;
		this.context = context;
		this.handler = new XHTMLContentHandler(handler, metadata);
		setForceParsing(true);
		setSortByPosition(config.getSortByPosition());
		if (config.getEnableAutoSpace()) {
			setWordSeparator(" ");
		} else {
			setWordSeparator("");
		}
		// TODO: maybe expose setting these too:
		//setAverageCharTolerance(1.0f);
		//setSpacingTolerance(1.0f);
		setSuppressDuplicateOverlappingText(config.getSuppressDuplicateOverlappingText());
	}



	void extractBookmarkText() throws SAXException {
		PDDocumentOutline outline = document.getDocumentCatalog().getDocumentOutline();
		if (outline != null) {
			extractBookmarkText(outline);
		}
	}

	void extractBookmarkText(PDOutlineNode bookmark) throws SAXException {
		PDOutlineItem current = bookmark.getFirstChild();
		if (current != null) {
			handler.startElement("ul");
			while (current != null) {
				handler.startElement("li");
				handler.characters(current.getTitle());
				handler.endElement("li");
				// Recurse:
				extractBookmarkText(current);
				current = current.getNextSibling();
			}
			handler.endElement("ul");
		}
	}

	@Override
	protected void startDocument(PDDocument pdf) throws IOException {
		try {
			handler.startDocument();
		} catch (SAXException e) {
			throw new IOExceptionWithCause("Unable to start a document", e);
		}
	}

	@Override
	protected void endDocument(PDDocument pdf) throws IOException {
		try {
			renderDocument();
			// Extract text for any bookmarks:
			extractBookmarkText();
			extractEmbeddedDocuments(pdf, originalHandler);

			//extract acroform data at end of doc
			if (config.getExtractAcroFormContent() == true){
				extractAcroForm(pdf, handler);
			}
			handler.endDocument();
		} catch (TikaException e){
			throw new IOExceptionWithCause("Unable to end a document", e);
		} catch (SAXException e) {
			throw new IOExceptionWithCause("Unable to end a document", e);
		}
	}

	@Override
	protected void startPage(PDPage page) throws IOException {
		try {
			handler.startElement("div", "class", "page");
		} catch (SAXException e) {
			throw new IOExceptionWithCause("Unable to start a page", e);
		}
		writeParagraphStart();
	}

	@Override
	protected void endPage(PDPage page) throws IOException {


		writeParagraphEnd();
		_documentElements.add(new PageElement(page));

	}




	@Override
	protected void writeParagraphStart() throws IOException {

		// TODO: remove once PDFBOX-1130 is fixed
		if (inParagraph) {
			// Close last paragraph

			writeParagraphEnd();
		}
		assert !inParagraph;
		inParagraph = true;

		_lastParagraph = new SimpleParagraph();
	}

	@Override
	protected void writeParagraphEnd() throws IOException {
		// TODO: remove once PDFBOX-1130 is fixed
		if (!inParagraph) {
			writeParagraphStart();
		}else{
			ScoreParagraph scorePara = new ScoreParagraph(_lastParagraph);
			_documentElements.add(scorePara);
			String str = scorePara.getText().replaceAll("\\s","");
			
				Pattern matchedPattern = matchPattern(str,getHeaderOrListItemPatterns());
				if(matchedPattern != null){
					Float score = headerPatternMap.get(matchedPattern.toString());
					if(score != null){
						if(score.floatValue() < scorePara.getScoreSize()){
							headerPatternMap.put(matchedPattern.toString(),scorePara.getScoreSize());
						}
					}else{
						headerPatternMap.put(matchedPattern.toString(),Float.valueOf(scorePara.getScoreSize()));
					}
				}
			
		}
		assert inParagraph;
		inParagraph = false;
	}

	@Override
	protected void writeString(String text) throws IOException {
		_lastChunk+=text;
	}

	@Override
	protected void writeCharacters(TextPosition text) throws IOException {
		_lastChunk += text.getCharacter();
	}

	@Override
	protected void writeWordSeparator() throws IOException {
		_lastChunk += getWordSeparator();
	}

	@Override
	protected void writeLineSeparator() throws IOException {
		Paragraph para = new SimpleParagraph();
		para.setType(ParagraphType.NL);
		_documentElements.add(new ScoreParagraph(para));
	}


	@Override
	protected void writeStyleStart(Color fontColor, float fontSize, boolean bold) throws IOException{
		_lastStyle = new Style(fontColor, fontSize, bold);
	}


	@Override
	protected void writeStyleEnd() throws IOException {
		_lastParagraph.addChunk(_lastStyle,_lastChunk);
		_lastChunk = "";
	}



	void renderParagraph(Paragraph paragraph)throws SAXException{

		String span = "";
		for (Chunk chunk : paragraph.getChunks()) {
			if(chunk.getText().replaceAll("\\s","").length()>0){
				Color color = chunk.getStyle().get_color();
				span = "color:rgb("+color.getRed()+","+color.getGreen()+","+color.getBlue()+")";
				span +=";font-size:"+chunk.getStyle().get_fontSize()+"pt";

				if(chunk.getStyle().is_bold()){
					handler.startElement("b");
					handler.startElement("span","style",span);
					handler.characters(chunk.getText());
					handler.endElement("span");
					handler.endElement("b");
				}else{
					handler.startElement("span","style",span);
					handler.characters(chunk.getText());
					handler.endElement("span");
				}
			}else{
				handler.characters(chunk.getText());
			}
		}
	}


	//TODO here we gather all paragraphs and their attributes in order to make decision on their type--> add all new rules here
	//Render Paragraphs to XHTML 
	protected void renderDocument() throws IOException{
		try {
			Map<String,Integer> patternMap = new HashMap<String,Integer>();
			int hiearchy = 0;
			int currentHeaderHiearchy = 0;
			for (DocumentElement elt : _documentElements) {
				if(elt instanceof ScoreParagraph){
					ScoreParagraph para = (ScoreParagraph) elt;
					String str = para.getText().replaceAll("\\s","");
					//TODO this can be optimized (pattern matching not done twice)
					Pattern matchedPattern = matchPattern(str,getHeaderOrListItemPatterns());
					if(matchedPattern != null && para.getScoreSize()>= headerPatternMap.get(matchedPattern.toString())){
						Integer ret = patternMap.get(matchedPattern.toString());
						if(ret == null){
							hiearchy++;
							patternMap.put(matchedPattern.toString(),Integer.valueOf(hiearchy));
							currentHeaderHiearchy = (hiearchy > 6)?6:hiearchy;
							handler.startElement("h"+currentHeaderHiearchy);
							renderParagraph(para);
							handler.endElement("h"+currentHeaderHiearchy);
						}else{
							currentHeaderHiearchy = ret.intValue();
							currentHeaderHiearchy = (currentHeaderHiearchy > 6)?6:currentHeaderHiearchy;
							handler.startElement("h"+currentHeaderHiearchy);
							renderParagraph(para);
							handler.endElement("h"+currentHeaderHiearchy);
						}

					}else{
						handler.startElement("p");
						renderParagraph(para);
						handler.endElement("p");
					}
				}else if(elt instanceof PageElement){
					PDPage page = ((PageElement)elt).getPage();
					// TODO: remove once PDFBOX-1143 is fixed:
					if (config.getExtractAnnotationText()) {
						for(Object o : page.getAnnotations()) {
							if( o instanceof PDAnnotationLink ) {
								PDAnnotationLink annotationlink = (PDAnnotationLink) o;
								if (annotationlink.getAction()  != null) {
									PDAction action = annotationlink.getAction();
									if( action instanceof PDActionURI ) {
										PDActionURI uri = (PDActionURI) action;
										String link = uri.getURI();
										if (link != null) {
											handler.startElement("div", "class", "annotation");
											handler.startElement("a", "href", link);
											handler.endElement("a");
											handler.endElement("div");
										}
									}
								}
							}

							if (o instanceof PDAnnotationMarkup) {
								PDAnnotationMarkup annot = (PDAnnotationMarkup) o;
								String title = annot.getTitlePopup();
								String subject = annot.getSubject();
								String contents = annot.getContents();
								// TODO: maybe also annot.getRichContents()?
								if (title != null || subject != null || contents != null) {
									handler.startElement("div", "class", "annotation");

									if (title != null) {
										handler.startElement("div", "class", "annotationTitle");
										handler.characters(title);
										handler.endElement("div");
									}

									if (subject != null) {
										handler.startElement("div", "class", "annotationSubject");
										handler.characters(subject);
										handler.endElement("div");
									}

									if (contents != null) {
										handler.startElement("div", "class", "annotationContents");
										handler.characters(contents);
										handler.endElement("div");
									}

									handler.endElement("div");
								}
							}
						}
					}
					handler.endElement("div");
				}

			}
		} catch (SAXException e) {
			throw new IOExceptionWithCause("Unable to end a page", e);
		}
	}




	private void extractEmbeddedDocuments(PDDocument document, ContentHandler handler)
			throws IOException, SAXException, TikaException {
		PDDocumentCatalog catalog = document.getDocumentCatalog();
		PDDocumentNameDictionary names = catalog.getNames();
		if (names == null){
			return;
		}
		PDEmbeddedFilesNameTreeNode embeddedFiles = names.getEmbeddedFiles();

		if (embeddedFiles == null) {
			return;
		}

		EmbeddedDocumentExtractor embeddedExtractor = context.get(EmbeddedDocumentExtractor.class);
		if (embeddedExtractor == null) {
			embeddedExtractor = new ParsingEmbeddedDocumentExtractor(context);
		}

		Map<String, COSObjectable> embeddedFileNames = embeddedFiles.getNames();
		//For now, try to get the embeddedFileNames out of embeddedFiles or its kids.
		//This code follows: pdfbox/examples/pdmodel/ExtractEmbeddedFiles.java
		//If there is a need we could add a fully recursive search to find a non-null
		//Map<String, COSObjectable> that contains the doc info.
		if (embeddedFileNames != null){
			processEmbeddedDocNames(embeddedFileNames, embeddedExtractor);
		} else {
			List<PDNameTreeNode> kids = embeddedFiles.getKids();
			if (kids == null){
				return;
			}
			for (PDNameTreeNode n : kids){
				Map<String, COSObjectable> childNames = n.getNames();
				if (childNames != null){
					processEmbeddedDocNames(childNames, embeddedExtractor);
				}
			}
		}
	}


	private void processEmbeddedDocNames(Map<String, COSObjectable> embeddedFileNames, 
			EmbeddedDocumentExtractor embeddedExtractor) throws IOException, SAXException, TikaException {
		if (embeddedFileNames == null){
			return;
		}
		for (Map.Entry<String,COSObjectable> ent : embeddedFileNames.entrySet()) {
			PDComplexFileSpecification spec = (PDComplexFileSpecification) ent.getValue();
			PDEmbeddedFile file = spec.getEmbeddedFile();

			Metadata metadata = new Metadata();
			// TODO: other metadata?
			metadata.set(Metadata.RESOURCE_NAME_KEY, ent.getKey());
			metadata.set(Metadata.CONTENT_TYPE, file.getSubtype());
			metadata.set(Metadata.CONTENT_LENGTH, Long.toString(file.getSize()));

			if (embeddedExtractor.shouldParseEmbedded(metadata)) {
				TikaInputStream stream = TikaInputStream.get(file.createInputStream());
				try {
					embeddedExtractor.parseEmbedded(
							stream,
							new EmbeddedContentHandler(handler),
							metadata, false);
				} finally {
					stream.close();
				}
			}
		}
	}
	private void extractAcroForm(PDDocument pdf, XHTMLContentHandler handler) throws IOException, 
	SAXException {
		//Thank you, Ben Litchfield, for org.apache.pdfbox.examples.fdf.PrintFields
		//this code derives from Ben's code
		PDDocumentCatalog catalog = pdf.getDocumentCatalog();

		if (catalog == null)
			return;

		PDAcroForm form = catalog.getAcroForm();
		if (form == null)
			return;

		@SuppressWarnings("rawtypes")
		List fields = form.getFields();

		if (fields == null)
			return;

		@SuppressWarnings("rawtypes")
		ListIterator itr  = fields.listIterator();

		if (itr == null)
			return;

		handler.startElement("div", "class", "acroform");
		handler.startElement("ol");
		while (itr.hasNext()){
			Object obj = itr.next();
			if (obj != null && obj instanceof PDField){
				processAcroField((PDField)obj, handler, 0);
			}
		}
		handler.endElement("ol");
		handler.endElement("div");
	}

	private void processAcroField(PDField field, XHTMLContentHandler handler, final int recurseDepth)
			throws SAXException, IOException { 

		if (recurseDepth >= MAX_ACROFORM_RECURSIONS){
			return;
		}

		addFieldString(field, handler);

		@SuppressWarnings("rawtypes")
		List kids = field.getKids();
		if(kids != null){

			@SuppressWarnings("rawtypes")
			Iterator kidsIter = kids.iterator();
			if (kidsIter == null){
				return;
			}
			int r = recurseDepth+1;
			handler.startElement("ol");
			while(kidsIter.hasNext()){
				Object pdfObj = kidsIter.next();
				if(pdfObj != null && pdfObj instanceof PDField){
					PDField kid = (PDField)pdfObj;
					//recurse
					processAcroField(kid, handler, r);
				}
			}
			handler.endElement("ol");
		}
	}
	private void addFieldString(PDField field, XHTMLContentHandler handler) throws SAXException{
		//Pick partial name to present in content and altName for attribute
		//Ignoring FullyQualifiedName for now
		String partName = field.getPartialName();
		String altName = field.getAlternateFieldName();

		StringBuilder sb = new StringBuilder();
		AttributesImpl attrs = new AttributesImpl();

		if (partName != null){
			sb.append(partName).append(": ");
		}
		if (altName != null){
			attrs.addAttribute("", "altName", "altName", "CDATA", altName);
		}
		//return early if PDSignature field
		if (field instanceof PDSignatureField){
			handleSignature(attrs, (PDSignatureField)field, handler);
			return;
		}
		try {
			//getValue can throw an IOException if there is no value
			String value = field.getValue();
			if (value != null && ! value.equals("null")){
				sb.append(value);
			}
		} catch (IOException e) {
			//swallow
		}

		if (attrs.getLength() > 0 || sb.length() > 0){
			handler.startElement("li", attrs);
			handler.characters(sb.toString());
			handler.endElement("li");
		}
	}

	private void handleSignature(AttributesImpl parentAttributes, PDSignatureField sigField,
			XHTMLContentHandler handler) throws SAXException{


		PDSignature sig = sigField.getSignature();
		if (sig == null){
			return;
		}
		Map<String, String> vals= new TreeMap<String, String>();
		vals.put("name", sig.getName());
		vals.put("contactInfo", sig.getContactInfo());
		vals.put("location", sig.getLocation());
		vals.put("reason", sig.getReason());

		Calendar cal = sig.getSignDate();
		if (cal != null){
			dateFormat.setTimeZone(cal.getTimeZone());
			vals.put("date", dateFormat.format(cal.getTime()));
		}
		//see if there is any data
		int nonNull = 0;
		for (String val : vals.keySet()){
			if (val != null && ! val.equals("")){
				nonNull++;
			}
		}
		//if there is, process it
		if (nonNull > 0){
			handler.startElement("li", parentAttributes);

			AttributesImpl attrs = new AttributesImpl();
			attrs.addAttribute("", "type", "type", "CDATA", "signaturedata");

			handler.startElement("ol", attrs);
			for (Map.Entry<String, String> e : vals.entrySet()){
				if (e.getValue() == null || e.getValue().equals("")){
					continue;
				}
				attrs = new AttributesImpl();
				attrs.addAttribute("", "signdata", "signdata", "CDATA", e.getKey());
				handler.startElement("li", attrs);
				handler.characters(e.getValue());
				handler.endElement("li");
			}
			handler.endElement("ol");
			handler.endElement("li");
		}
	}














}
