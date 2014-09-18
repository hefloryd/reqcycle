package org.polarsys.kitalpha.doc.doc2model.emfcontenthandler.ssh;

import org.eclipse.emf.ecore.EClass;
import org.polarsys.kitalpha.doc.doc2model.core.ModelContentHandler;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Cell;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.ExcelFile;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Row;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Sheet;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetFactory;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetPackage;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Table;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class SSHSAXContentHandler implements ModelContentHandler<ExcelFile>{
	
	
	//XHTML TAGS CONSTANTS
	final static String TAG_HEAD ="head";
	final static String TAG_META ="meta";
	//final static String TAG_PARAGRAPH ="p";
	final static String TAG_BOLD ="b";
	final static String TAG_TABLE ="table";
	final static String TAG_ROW ="tr";
	final static String TAG_CELL ="td";
	final static String TAG_TABLE_HEADER ="th";
	//final static String TAG_IMG ="img";
	
	
	private EClass _lastECLASS = null ;
	private SpreadsheetFactory _factory= SpreadsheetFactory.eINSTANCE;
	private ExcelFile _excelFile;
	private Sheet _sheet;
	private Table _lastTable;
	private Row _lastRow ;
	private Cell _lastCell;
	


	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String charStr = new String(ch, start,length);
		if (_lastECLASS != null){
			switch (_lastECLASS.getClassifierID()) {
			case SpreadsheetPackage.TABLE:
				break;
			case SpreadsheetPackage.CELL:	
				_lastCell.setTextContent(charStr);
			default:
				break;
			}
		}
	}

	@Override
	public void endDocument() throws SAXException {
		
	}

	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		
	}

	@Override
	public void endPrefixMapping(String arg0) throws SAXException {
		
	}

	@Override
	public void ignorableWhitespace(char[] arg0, int arg1, int arg2) throws SAXException {
		
	}

	@Override
	public void processingInstruction(String arg0, String arg1) throws SAXException {
		
	}

	@Override
	public void setDocumentLocator(Locator arg0) {
	}

	@Override
	public void skippedEntity(String arg0) throws SAXException {
		
	}

	@Override
	public void startDocument() throws SAXException {
		_excelFile = _factory.createExcelFile();
		_sheet = _factory.createSheet();
		_excelFile.getSheet().add(_sheet);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		if(localName.equals(TAG_TABLE)){
			_lastTable = _factory.createTable();
			_lastECLASS = _lastTable.eClass();
			_sheet.getTable().add(_lastTable);
		}else{
			if (TAG_ROW.equals(localName)){
				_lastRow = _factory.createRow();
				_lastTable.getRow().add(_lastRow);
				_lastECLASS = _lastRow.eClass();
			}
			else if (TAG_CELL.equals(localName)){
				_lastCell = _factory.createCell();
				_lastRow.getCell().add(_lastCell);
				_lastECLASS = _lastCell.eClass();
			}
		}
		
	}

	@Override
	public void startPrefixMapping(String arg0, String arg1) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExcelFile getResult() {
		// TODO Auto-generated method stub
		return _excelFile;
	}
	

}
