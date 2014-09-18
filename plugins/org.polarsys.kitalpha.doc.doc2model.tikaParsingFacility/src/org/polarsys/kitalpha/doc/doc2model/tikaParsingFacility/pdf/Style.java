package org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility.pdf;

import java.awt.Color;

public class Style{
	
	private Color _color = new Color(0);
	private float _fontSize = 0;
	private boolean _bold = false;
	
	public Color get_color() {
		return _color;
	}

	public float get_fontSize() {
		return _fontSize;
	}

	public boolean is_bold() {
		return _bold;
	}

	public Style(Color color, float fontSize, boolean bold) {
		_color = color;
		_fontSize = fontSize;
	}
	
	@Override
	public String toString() {
		String str="";
		str+="Color:"+_color.toString()+" FontSize:"+_fontSize+" Bold:"+_bold;
		return str;
	}

	
	
	
	

}