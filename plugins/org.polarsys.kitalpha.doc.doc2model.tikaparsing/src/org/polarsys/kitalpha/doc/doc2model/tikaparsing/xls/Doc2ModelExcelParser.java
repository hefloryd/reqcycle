package org.polarsys.kitalpha.doc.doc2model.tikaparsing.xls;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AbstractParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.XHTMLContentHandler;
import org.polarsys.kitalpha.doc.doc2model.tikaparsing.xls.SubRowScore.SubRowFunction;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class Doc2ModelExcelParser extends AbstractParser {

	/**
	 * 
	 */
	private static final long serialVersionUID = -167556379616415313L;
	private static final Set<MediaType> SUPPORTED_TYPES =
			Collections.unmodifiableSet(new HashSet<MediaType>(Arrays.asList(MediaType.application("vnd.ms-excel"))));

	@Override
	public Set<MediaType> getSupportedTypes(ParseContext context){
		return SUPPORTED_TYPES;
	}

	@Override
	public void parse(InputStream stream, ContentHandler handler,
			Metadata metadata, ParseContext context) throws IOException,
			SAXException, TikaException {

		NPOIFSFileSystem npoifs = new NPOIFSFileSystem(stream);
		AdvancedTikaHSSFListener formatListener =  new AdvancedTikaHSSFListener(Locale.getDefault());
		List<SpreadSheetElement> spreadSheetElements = formatListener.processFile(npoifs,false);
		XHTMLContentHandler xhandler = new XHTMLContentHandler(handler, metadata);
		xhandler.startDocument();
		xhandler.startElement("div");
		for (SpreadSheetElement elt : spreadSheetElements) {
			if(elt instanceof Table){
				Table table = (Table) elt;
				xhandler.startElement("table");
				xhandler.startElement("tbody");
				SubRow mainHeader = table.getHeader();
				Set<Integer> headerSet = new HashSet<Integer>();
				for (CellsGroup header : mainHeader) {
					int column= header.getFirstColumn();
					for (StylizedCell cell : header) {
						headerSet.add(Integer.valueOf(column));
						column++;
					}
				}


				Map<Integer,String> rowMap = new HashMap<Integer,String>();

				for ( SubRow row : table) {

					SubRowScore ss = (SubRowScore) row;
					xhandler.startElement("tr");
					if(ss.getSubRowType() == SubRowFunction.Header){
						for (StylizedCell c : ss.getCells()){
							xhandler.startElement("td");
							xhandler.characters(c.getText());
							xhandler.endElement("td");
						}
					}
					else if(ss.getSubRowType() == SubRowFunction.DataContent){


						for (CellsGroup cellgrp : ss) {
							int column = cellgrp.getFirstColumn();
							for (StylizedCell cell : cellgrp) {
								rowMap.put(Integer.valueOf(column),cell.getText());
								column++;					
							}
						}


						Iterator<Entry<Integer, String>> rowIter = rowMap.entrySet().iterator();
						Integer lastCol = Integer.valueOf(-1);
						Integer nextCol = Integer.valueOf(-1);

						String lastValue = "";

						if(rowIter.hasNext()){
							lastCol = rowIter.next().getKey();
							lastValue = rowMap.get(lastCol);

							if(rowIter.hasNext()){
								nextCol = rowIter.next().getKey();
							}

							for(Integer col : headerSet){
								if(col.compareTo(lastCol) > 0 && nextCol.intValue() != -1 && col.compareTo(nextCol) < 0 ){

								}else if (col.compareTo(nextCol) >= 0){
									lastCol = nextCol;
									lastValue = rowMap.get(nextCol);

									if(rowIter.hasNext()){
										nextCol = rowIter.next().getKey();
									}else{
										nextCol = Integer.valueOf(-1);
									}
								}else if (nextCol.intValue() == -1){
									//TODO
								}else {
									lastValue = rowMap.get(lastCol);
								}
								xhandler.startElement("td");
								xhandler.characters(lastValue);
								xhandler.endElement("td");
							}
							
						}
					
				}
				xhandler.endElement("tr");
			}
			xhandler.endElement("tbody");
			xhandler.endElement("table");
		}


	}
	xhandler.endElement("div");
}

}
