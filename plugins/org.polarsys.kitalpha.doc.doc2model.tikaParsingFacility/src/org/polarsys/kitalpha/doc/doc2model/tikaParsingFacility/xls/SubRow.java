package org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility.xls;

import java.util.List;

public interface SubRow extends Iterable<CellsGroup>, SpreadSheetElement{
	
	public int getNbColumn();

	public List<CellsGroup> get_Groups();

	public List<StylizedCell> getCells() ;

	public int getElementNb();

	public int getCellsNb();


	public void addSubRowCellsGroup(SubRow sb);
	public void addCellsGroup(CellsGroup cg);


	public int get_firstColumn();

	public int get_lastColumn();

	public CellsGroup get_lastGroup();

	public boolean isGroupWithin(CellsGroup cellgroup);
	public boolean isSubRowWithin(SubRow subrow);
	
	public int getRowIndex();
	public int[] excess(SubRow subrow);

}
