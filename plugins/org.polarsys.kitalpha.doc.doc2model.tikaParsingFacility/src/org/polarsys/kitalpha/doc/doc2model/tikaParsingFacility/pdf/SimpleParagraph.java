package org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility.pdf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleParagraph implements Iterable<Chunk>,Paragraph{

	protected List<Chunk> _chunks = new ArrayList<Chunk>();
	protected ParagraphType _type = ParagraphType.Simple;

	public SimpleParagraph() {}

	public ParagraphType getType() {
		return _type;
	}

	public void setType(ParagraphType _type) {
		this._type = _type;
	}

	public void addChunk(Style style,String str){
		_chunks.add(new Chunk(style,str));
	}
	

	public String getText(){
		String str="";
		for (Chunk elt : _chunks) {
			str+= elt.getText();
		}
		return str;
	}

	@Override
	public Iterator<Chunk> iterator() {
		return _chunks.iterator();
	}

	@Override
	public String toString() {
		String str="";
		for (Chunk elt : _chunks) {
			str+="|"+elt.toString();
		}
		return str;
	}

	@Override
	public List<Chunk> getChunks() {
		return _chunks;
	}

}
