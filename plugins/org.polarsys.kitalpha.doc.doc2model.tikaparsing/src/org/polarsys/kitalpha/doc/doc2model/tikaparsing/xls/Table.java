package org.polarsys.kitalpha.doc.doc2model.tikaparsing.xls;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.tika.parser.microsoft.Cell;


public class Table implements Iterable<SubRow>,SpreadSheetElement{


	private String _title = "";
	private List<SubRow> _rows = new ArrayList<SubRow>();
	private int _maxHiearchy = 0;
	private SubRow _header;
	
	
	public Table(SubRow subrow){
		_rows.add(subrow);
	}
	
	public SubRow getHeader() {
		return _header;
	}

	
	public void setHeader(SubRow sub){
		_header = sub;
	}


	public boolean  isEmpty(){
		return _rows.isEmpty();
	}

	
	public List<SubRow> getRows(){
		return _rows;
	}
	

	public int getFirstRowIndex(){
		return _rows.get(0).getRowIndex();
	}
	
	public int getLastRowIndex(){
		return _rows.get(_rows.size()-1).getRowIndex();
	}

	public SubRow getLastSubRow(){
		//rows not empty by Construction
			return _rows.get(_rows.size()-1);
	}

	public int getNbRows(){
		return _rows.size();
	}


	public String getTitle(){
		return _title;
	}

	public void setTitle(String title){
		_title=title;
	}

	@Override
	public Iterator<SubRow> iterator() {
		return _rows.iterator();
	}
	
	
	public void addSubRow(SubRow subrow) {
		_rows.add(subrow);
	}
	
	
	public void setMaxHiearchy(int hiearchy) {
		_maxHiearchy  = hiearchy;
	}
	
	public int getMaxHiearchy() {
		return _maxHiearchy;
	}
	


	public Cell[][] finalizeTable(){

		Cell[][] returnTable = new Cell[_rows.size()+1][_header.getNbColumn()];


		//Initialization with empty Cells
		for (int i=0;i<(_rows.size()+1);i++) {
			for (int j=0;j<(_header.getNbColumn());j++) {
				returnTable[i][j]=new EmptyCell();
			}
		}


		///

		Map<Integer,Integer> headersMap = new TreeMap<Integer,Integer>();

		int cptCol=0;
		for (CellsGroup header : _header) {
			int column= header.getFirstColumn();


			for (StylizedCell cell : header) {
				returnTable[0][cptCol]=cell;
				headersMap.put(Integer.valueOf(column),Integer.valueOf(cptCol));
				column++;
				cptCol++;
			}
		}


		int cptrow = 1;
		for (SubRow row : _rows) {

			for (CellsGroup rowcg : row) {
				int column= rowcg.getFirstColumn();
				for (StylizedCell cell : rowcg) {

					//TODO this is not robust
					returnTable[cptrow][headersMap.get(Integer.valueOf(column)).intValue()]=cell;
					column++;
				}

			}

			cptrow++;
		}


		return returnTable;
	}



	public String getText(){

		Cell[][] returnTable = finalizeTable();

		String str= "-----------------------------------------------------------------------------\n";
		str+="Titre: "+_title+"\n";

		for (int i=0;i<_rows.size()+1;i++) {
			for (int j=0;j<_header.getNbColumn();j++) {

				if(returnTable[i][j] instanceof StylizedCell){
					StylizedCell cell = (StylizedCell) returnTable[i][j];
					str+=cell.getText();
					str+="|";
				}else{
					str+="NA";
					str+="|";
				}

			}
			str+="\n";
		}

		return str;
	}



	
	@Override
	public String toString() {

		String str= "-----------------------------------------------------------------------------\n";
		str += _header.toString();
		str += '\n';

		str +="Size: "+_rows.size();
		return str;

	}







}
