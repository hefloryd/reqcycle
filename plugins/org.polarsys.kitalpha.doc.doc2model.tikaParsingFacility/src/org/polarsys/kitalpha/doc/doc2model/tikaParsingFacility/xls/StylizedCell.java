package org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility.xls;
import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.record.FontRecord;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.tika.parser.microsoft.Cell;
import org.apache.tika.sax.XHTMLContentHandler;
import org.xml.sax.SAXException;


public class StylizedCell  implements Cell  {
	
	
	
	public enum Type {
	     Number, Date, String, HyperLink
	}
	
    
	private final String _text;
	//private boolean _hasBorder=false;
	private Type _type= Type.String;
	
    private boolean _bold=false;
    private short _fontColor;
	private short _fillColor;
    private short _fontSize;
    
    
    public boolean isBold() {
		return _bold;
	}

	public short getFontColor() {
		return _fontColor;
	}

	public short getFillColor() {
		return _fillColor;
	}

	public short getFontSize() {
		return _fontSize;
	}


	
	public StylizedCell(String text,ExtendedFormatRecord efr, FontRecord fr) {
		this(text,efr,fr,Type.String);
	}
	
	public StylizedCell(String text,ExtendedFormatRecord efr, FontRecord fr,Type type) {

        this._text = text;
        this._type = type;

		if(fr.getBoldWeight() == HSSFFont.BOLDWEIGHT_BOLD){
			_bold = true;
		}
			
        
        //TODO this to change by workbook palette to have the real colors (palette Record)
		if(efr.getFillForeground() == HSSFColor.AUTOMATIC.index){
			_fillColor = -1;
		}else{
			_fillColor =efr.getFillForeground();
		}
		
		
		if(fr.getColorPaletteIndex() == HSSFColor.BLACK.index){
			_fontColor = -1;
		}else{
			_fontColor = fr.getColorPaletteIndex();
		}
		_fontSize =(short) (fr.getFontHeight()/20);

		//_hasBorder = (efr.getBorderBottom() != 0 && efr.getBorderTop() != 0 && efr.getBorderLeft() != 0 && efr.getBorderRight() != 0);
	}
	
	public StylizedCell(String text) {
		_text=text;
	}
	
	
	public String getText(){
		return _text;
	}
	
	
	public Type getType(){
		return _type;
	}
	
//	public boolean hasBorder(){
//		return _hasBorder;
//	}
	
	@Override
	public String toString() {
		return "Stylized Cell: "+ this._text;
	}
	
	@Override
	public void render(XHTMLContentHandler handler) throws SAXException {
        handler.characters(_text);		
	}
	
	
//	public boolean hasSameStyle(StylizedCell cell){
//		
//		//TODO this can be extended with font infos
//		boolean sameStyle = false;
//		sameStyle = (this._bold == cell._bold) && 
//				(this._fillColor) == cell._fillColor;
//		
//		return sameStyle;
//	}
//
//	public boolean hasFillColor() {
//		return (this._fillColor != -1);
//	}

}
