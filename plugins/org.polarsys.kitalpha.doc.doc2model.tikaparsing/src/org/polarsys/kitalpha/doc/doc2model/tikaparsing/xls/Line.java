package org.polarsys.kitalpha.doc.doc2model.tikaparsing.xls;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Line implements Iterable<SubRow> {

	private List<SubRow> _subRows = new ArrayList<SubRow>() ;
	private int _lineIndex;

	public Line(){
		_lineIndex = -1;
	}


	public Line(int index){
		_lineIndex = index;
	}



	public void removeSubRow(SubRow subRow) {
		_subRows.remove(subRow);
	}

	int getLineIndex(){
		return _lineIndex;
	}

	public int getElementNb(){
		return _subRows.size();
	}

	public void addSubRow(SubRow subrow){
		_subRows.add(subrow);
	}

	@Override
	public Iterator<SubRow> iterator() {
		return _subRows.iterator();
	}

	@Override
	public String toString() {

		String str = "";
		for (SubRow subrow : _subRows) {
			str += subrow.toString();
			str += " | ";
		}


		return str;
	}



}
