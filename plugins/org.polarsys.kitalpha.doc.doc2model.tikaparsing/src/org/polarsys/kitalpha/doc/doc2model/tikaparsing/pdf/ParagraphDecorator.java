package org.polarsys.kitalpha.doc.doc2model.tikaparsing.pdf;

import java.util.List;

public class ParagraphDecorator implements Paragraph{

	Paragraph _para;

	public ParagraphDecorator(Paragraph para){
		_para = para;
	}

	@Override
	public ParagraphType getType() {
		return _para.getType();
	}

	@Override
	public void setType(ParagraphType _type) {
		_para.setType(_type);
	}

	@Override
	public void addChunk(Style style, String str) {
		_para.addChunk( style,  str);		
	}

	@Override
	public String getText() {
		return _para.getText();
	}

	@Override
	public List<Chunk> getChunks() {
		return _para.getChunks();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return _para.toString();
	}


}
