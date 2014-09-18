package org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility.xls;

import java.util.Iterator;
import java.util.List;

public class SubRowDecorator implements SubRow {

	private SubRow _subrow ;

	public SubRowDecorator(SubRow subrow) {
		this._subrow = subrow;
	}

	@Override
	public Iterator<CellsGroup> iterator() {
		return _subrow.iterator();
	}

	@Override
	public int getNbColumn() {
		return _subrow.getNbColumn();
	}

	@Override
	public List<CellsGroup> get_Groups() {
		return _subrow.get_Groups();
	}

	@Override
	public List<StylizedCell> getCells() {
		return _subrow.getCells();
	}

	@Override
	public int getElementNb() {
		return _subrow.getElementNb();
	}

	@Override
	public int getCellsNb() {
		return _subrow.getCellsNb();
	}

	@Override
	public void addSubRowCellsGroup(SubRow sb) {
		_subrow.addSubRowCellsGroup(sb);		
	}

	@Override
	public void addCellsGroup(CellsGroup cg) {
		_subrow.addCellsGroup(cg);		
	}

	@Override
	public int get_firstColumn() {
		return _subrow.get_firstColumn();
	}

	@Override
	public int get_lastColumn() {
		return _subrow.get_lastColumn();
	}

	@Override
	public CellsGroup get_lastGroup() {
		return _subrow.get_lastGroup();
	}

	@Override
	public boolean isGroupWithin(CellsGroup cellgroup) {
		return _subrow.isGroupWithin(cellgroup);
	}

	@Override
	public int getRowIndex() {
		return _subrow.getRowIndex();
	}

	@Override
	public boolean isSubRowWithin(SubRow subrow) {
		return _subrow.isSubRowWithin(subrow);
	}

	@Override
	public int[] excess(SubRow subrow) {	
		return  _subrow.excess(subrow);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return _subrow.toString();
	}

	@Override
	public String getText() {
		String str = _subrow.getText();
		return str;
	}


}
