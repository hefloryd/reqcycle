package org.polarsys.kitalpha.doc.doc2model.tikaparsing.xls;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.tika.parser.microsoft.Cell;

/**
 * This Class defines successive cells belonging to a given Row and having the same style
 * @author cjaber
 *
 */
public class CellsGroup implements Iterable<StylizedCell>{

	private List<StylizedCell> _cells;
	private int _rowIndex;
	private int _firstColumn;
	private int _lastColumn;


	public CellsGroup() {
		this._cells = new ArrayList<StylizedCell>();
		_rowIndex = -1;
		_firstColumn = -1;
	}
	
	public List<StylizedCell> getCells(){
		return _cells;
	}

	public CellsGroup(Point startPoint, StylizedCell startCell) {
		this._cells = new ArrayList<StylizedCell>();
		this._cells.add(startCell);
		_rowIndex = startPoint.y;
		_firstColumn = startPoint.x;
		_lastColumn = startPoint.x;
	}

	public int getCellsNb(){
		return _cells.size();
	}

	public int getFirstColumn(){
		return _firstColumn;
	}
	public int getLastColumn(){
		return _lastColumn;
	}

	public int getRowIndex(){
		return _rowIndex;
	}

	public void addCell(Point cellPoint, StylizedCell cellToAdd){
		if(_cells.size() == 0){
			_rowIndex = cellPoint.y;
			_firstColumn = cellPoint.x;
		}
		_lastColumn= cellPoint.x;
		_cells.add(cellToAdd);
	}

	
	/**
	 * Return True if the two groups are aligned i.e.
	 * their first and last cells of each of them are in the same column
	 * @param cellgroup
	 * @return true if aligned
	 */
	public boolean isAligned(CellsGroup cellgroup){
		return (this._firstColumn == cellgroup._firstColumn) &&
				(this.getCellsNb() == cellgroup.getCellsNb()) && 
				(Math.abs(this._rowIndex-cellgroup._rowIndex) != 1);
	}
	
	
	/**
	 * Return True if the two groups are aligned i.e.
	 * their first and last cells of each of them are in the same column
	 * @param cellgroup
	 * @return true if aligned
	 */
	public boolean isWithin(CellsGroup cellgroup){
		return (this._firstColumn >= cellgroup._firstColumn) &&
				( (this._firstColumn+this.getCellsNb()) <= (cellgroup._firstColumn+cellgroup.getCellsNb()) );
	}

	/**
	 * Return True if the two groups are right aligned i.e.
	 * last cells of each of them are in the same column
	 * @param cellgroup
	 * @return true if aligned
	 */
	public boolean isRightAligned(CellsGroup cellgroup){
		return (this._firstColumn+this.getCellsNb() == cellgroup._firstColumn+cellgroup.getCellsNb()) && 
				(Math.abs(this._rowIndex-cellgroup._rowIndex) != 1);
	}

	@Override
	public String toString() {
		String str="";
		for (Cell cell : _cells) {
			if(cell instanceof StylizedCell){
				str+="<>";
				str+= ((StylizedCell)cell).getText();
			}
		}
		return str;
	}
	
	public String getText() {
		String str="";
		for (Cell cell : _cells) {
			if(cell instanceof StylizedCell){
				str+=" ";
				str+= ((StylizedCell)cell).getText();
			}
		}
		return str;
	}



	
	@Override
	public Iterator<StylizedCell> iterator(){
		return _cells.iterator();
	}
	

	public void setLastColumn(int lastColumn) {
		_lastColumn = lastColumn;
	}

}
