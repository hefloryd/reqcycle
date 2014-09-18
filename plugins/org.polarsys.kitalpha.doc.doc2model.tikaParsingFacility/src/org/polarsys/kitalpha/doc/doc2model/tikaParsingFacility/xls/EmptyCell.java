package org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility.xls;



/**
 * Empty Cell, used as fill cell in tables
 */
import org.apache.tika.parser.microsoft.Cell;
import org.apache.tika.sax.XHTMLContentHandler;
import org.xml.sax.SAXException;

public class EmptyCell  implements Cell  {
	
	
	public EmptyCell() {
	}
	


	public String getText(){
		return "NA";
	}
	
	@Override
	public String toString() {
		return "EmptyCell";
	}



	@Override
	public void render(XHTMLContentHandler handler) throws SAXException {
        handler.characters("NA");
	}

}
