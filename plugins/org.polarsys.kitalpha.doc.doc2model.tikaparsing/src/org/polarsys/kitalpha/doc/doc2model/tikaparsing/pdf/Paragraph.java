package org.polarsys.kitalpha.doc.doc2model.tikaparsing.pdf;

import java.util.List;


public interface Paragraph extends DocumentElement{

	public enum ParagraphType{
		Header,Simple,NL
	}


	public ParagraphType getType();

	public void setType(ParagraphType _type);

	public void addChunk(Style style,String str);
	
	public List<Chunk> getChunks();

	public String getText();
	
}
