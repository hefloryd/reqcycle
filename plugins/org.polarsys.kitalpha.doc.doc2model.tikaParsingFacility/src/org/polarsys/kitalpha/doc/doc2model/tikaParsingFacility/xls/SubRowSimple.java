package org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility.xls;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubRowSimple implements SubRow {

	private List<CellsGroup> _cellGroups = new ArrayList<CellsGroup>() ;

	private int _firstColumn = -1;
	private int _rowIndex = -1;




	@Override
	public int getNbColumn(){
		int count = 0;
		for (CellsGroup cg : _cellGroups) {
			count += cg.getCellsNb();
		}
		return count;
	}


	@Override
	public List<CellsGroup> get_Groups() {
		return _cellGroups;
	}

	@Override
	public List<StylizedCell> getCells() {
		ArrayList<StylizedCell> retList = new ArrayList<StylizedCell>();

		for (CellsGroup cg : _cellGroups) {
			retList.addAll(cg.getCells());
		}
		return retList;
	}

	@Override
	public int getElementNb(){
		return _cellGroups.size();
	}


	@Override
	public int getCellsNb(){
		int sum = 0;
		for (CellsGroup cg : _cellGroups) {
				sum += cg.getCellsNb();
		}
		return sum;
	}

	@Override
	public void addSubRowCellsGroup(SubRow sb) {
		_rowIndex = sb.getRowIndex();
		
		for (CellsGroup cg : sb) {
			_cellGroups.add(cg);

		}
	}


	@Override
	public void addCellsGroup(CellsGroup cg) {
			if(_cellGroups.size()== 0){
				_rowIndex = cg.getRowIndex();
				_firstColumn=cg.getFirstColumn();
			}
			_cellGroups.add(cg);
	
	}

	@Override
	public int get_firstColumn() {
		return _firstColumn;
	}

	@Override
	public int get_lastColumn() {
		return get_lastGroup().getLastColumn();
	}


	@Override
	public CellsGroup get_lastGroup() {
		return _cellGroups.get(_cellGroups.size()-1);
	}


	@Override
	public String toString() {
		String str = "";
		for (CellsGroup cg : _cellGroups) {
			str +="$"+cg.toString();
		}
		str +="\n";
		return str;
	}


	/**
	 * Return True if the group is within Header scope
	 * @param cellgroup
	 * @return true if aligned
	 */
	@Override
	public boolean isGroupWithin(CellsGroup cellgroup){
		return (this._firstColumn <= cellgroup.getFirstColumn() &&
				get_lastColumn() >= cellgroup.getLastColumn());
	}


	@Override
	public int getRowIndex(){
		return _rowIndex;
	}


	@Override
	public Iterator<CellsGroup> iterator() {
		return _cellGroups.iterator();
	}



	@Override
	public boolean isSubRowWithin(SubRow subrow) {
		return (this._firstColumn <= subrow.get_firstColumn() &&
				get_lastColumn()  >= subrow.get_lastColumn());		
	}


	@Override
	public int[] excess(SubRow subrow) {
		int excess[] = {0,0};

		excess[0] = this._firstColumn - subrow.get_firstColumn();
		excess[1] = subrow.get_lastColumn() - this.get_lastColumn();
		return excess;
	}


	@Override
	public String getText() {
		String str = "";
		for (CellsGroup cg : _cellGroups) {
			str +=" "+cg.getText();
		}
		str+="\n";
		return str;
	}

}
