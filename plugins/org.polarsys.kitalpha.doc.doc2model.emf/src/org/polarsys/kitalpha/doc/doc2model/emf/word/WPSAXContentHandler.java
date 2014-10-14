package org.polarsys.kitalpha.doc.doc2model.emf.word;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.polarsys.kitalpha.doc.doc2model.common.Common.CommonFactory;
import org.polarsys.kitalpha.doc.doc2model.common.Common.Style;
import org.polarsys.kitalpha.doc.doc2model.common.Common.StyleEnum;
import org.polarsys.kitalpha.doc.doc2model.core.ModelContentHandler;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Cell;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Image;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Paragraph;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Row;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.StringChunk;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Table;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Title;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorFactory;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class WPSAXContentHandler implements ModelContentHandler<WPFile>{




	//XHTML TAGS CONSTANTS
	final static String TAG_HEAD ="head";
	final static String TAG_META ="meta";
	final static String TAG_PARAGRAPH ="p";
	final static String TAG_BOLD ="b";
	final static String TAG_TABLE ="table";
	final static String TAG_ROW ="tr";
	final static String TAG_CELL ="td";
	final static String TAG_IMG ="img";



	//XHTML ATTRIBUTES CONSTANTS
	final static String ATT_NAME ="name";
	final static String ATT_CONTENT ="content";
	final static String ATT_CLASS ="class";



	private enum TagType {Section, Paragraph , Table , Default};




	static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	static final Pattern headingPattern = Pattern.compile("h(\\d)");


	private WordprocessorFactory _factory= WordprocessorFactory.eINSTANCE;
	private WPFile _wordFile;

	private Section _lastSection;
	private Stack<Section> _sectionsStack = new Stack<Section>();




	private Paragraph _lastParagraph;
	private Table _lastTable;
	private Row _lastRow;
	private Cell _lastCell;
	private Image _lastImage;



	private TagType _lastTagType = TagType.Default;
	private boolean _isBold = false;


	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		String charStr = new String(ch, start,length);
		switch (_lastTagType) {
		case Section:
			String title = _lastSection.getTitle().getTextContent();
			_lastSection.getTitle().setTextContent(title+charStr);
			break;
		case Paragraph:
			StringChunk strChk = _factory.createStringChunk();
			strChk.setTextContent(charStr);
			if (_isBold){
				setProperty(strChk,StyleEnum.BOLD);
			}
			_isBold = false;
			_lastParagraph.getChunks().add(strChk);
			break;
		case Table:
			_lastCell.setTextContent(_lastCell.getTextContent()+charStr);
			break;
		default:
			break;
		}


	}


	private void setProperty(StringChunk strChk, StyleEnum styleEnum) {
		Style s = strChk.getStyle();
		if (s == null){
			s = CommonFactory.eINSTANCE.createStyle();
			strChk.setStyle(s);
		}
		s.getEnums().add(styleEnum);
	}


	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if(localName.equals(TAG_TABLE)){
		_lastTagType = TagType.Default;
		}

	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void startDocument() throws SAXException {
		_wordFile = _factory.createWPFile();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

		Matcher m = headingPattern.matcher(localName);

		if(localName.equals(TAG_HEAD)){
			_lastSection = _factory.createSection();
			_lastSection.setHiearchy("0");
			Title mainTitle = _factory.createTitle();
			mainTitle.setTextContent("Main Section");
			_lastSection.setTitle(mainTitle);
			_sectionsStack.add(_lastSection);
			_wordFile.setMainSection(_lastSection);
		}
		else if(localName.equals(TAG_META)){
			if (atts.getValue(ATT_NAME).equals("dc:title")){
				_wordFile.setName(atts.getValue("content"));
			}else if(atts.getValue(ATT_NAME).equals("meta:author")){
				_wordFile.setAuthor(atts.getValue("content"));
			}else if(atts.getValue(ATT_NAME).equals("meta:creation-date")){
				try {
					_wordFile.setDate(dateFormat.parse(atts.getValue("content")));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else if(m.matches()){
			_lastSection = _factory.createSection();
			_lastSection.setHiearchy(m.group(1));
			Title title = _factory.createTitle();
			_lastSection.setTitle(title);
			Section _tmpSection; 
			while(!_sectionsStack.isEmpty()){
				_tmpSection = _sectionsStack.peek();
				if(_lastSection.getHiearchy().compareTo(_tmpSection.getHiearchy()) > 0){
					_tmpSection.getSections().add(_lastSection);
					_sectionsStack.add(_lastSection);
					break;
				}
				_tmpSection = _sectionsStack.pop();
			}
			_lastTagType = TagType.Section;
		}else if(localName.equals(TAG_PARAGRAPH)){
			//Paragraphs can be encountered also within a table
			if(_lastTagType != TagType.Table){
				_lastParagraph = _factory.createParagraph();
				_lastParagraph.setStyleName(atts.getValue(ATT_CLASS));
				_lastSection.getContents().add(_lastParagraph);
				_lastTagType = TagType.Paragraph;
			}
		}else if(localName.equals(TAG_BOLD)){
			_isBold = true;
		}else if(localName.equals(TAG_IMG)){
			_lastImage = _factory.createImage();
			Title title = _factory.createTitle();
			title.setTextContent(atts.getValue("src"));
			_lastImage.setSubtitle(title);
			_lastSection.getContents().add(_lastImage);
		}else if(localName.equals(TAG_TABLE)){
			_lastTable = _factory.createTable();
			_lastSection.getContents().add(_lastTable);
			_lastTagType = TagType.Table;
		}else if(localName.equals(TAG_ROW)){
			_lastRow = _factory.createRow();
			_lastTable.getRow().add(_lastRow);
		}else if(localName.equals(TAG_CELL)){
			_lastCell = _factory.createCell();
			_lastCell.setTextContent("");
			_lastRow.getCell().add(_lastCell);
		}else {
		}
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub

	}


	@Override
	public WPFile getResult() {
		// TODO Auto-generated method stub
		return _wordFile;
	}




}