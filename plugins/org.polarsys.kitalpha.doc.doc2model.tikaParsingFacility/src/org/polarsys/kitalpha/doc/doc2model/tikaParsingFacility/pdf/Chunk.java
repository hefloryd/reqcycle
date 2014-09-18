package org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility.pdf;

public class Chunk {


	Style _style;
	String _text ="";

	public Chunk(Style style, String text) {
		_style = style;
		_text = text;
	}

	public String getText() {
		return _text;
	}

	@Override
	public String toString() {
		return _style.toString()+" "+_text;
	}

	public Style getStyle() {
		return _style;		
	}


}
