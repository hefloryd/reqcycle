package org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility.xls;

import java.util.HashMap;

public class SubRowScore extends SubRowDecorator {

	
	public enum SubRowFunction  {
		Header,Title,DataContent
	}
	
	private float _scoreFontWeight = 0;
	private float _scoreFontHeight = 0;
	private float _scoreFontColor = 0;
	private float _scoreFillColor = 0;
	private boolean _aligned = false;
	private int _hiearchy = 0;
	private SubRowFunction _subRowType = SubRowFunction.DataContent;

	
	
	public int getHiearchy() {
		return _hiearchy;
	}
	
	public void setHiearchy(int hiearchy) {
		_hiearchy=hiearchy;
	}
	
	
	public boolean isAligned() {
		return _aligned;
	}
	
	public void setAligned() {
		 _aligned=true;
	}
	
	
	public SubRowFunction getSubRowType() {
		return _subRowType;
	}
	
	
	public void setSubRowType(SubRowFunction function) {
		 _subRowType = function;
	}

	public float getScoreWeight() {
		return _scoreFontWeight;
	}

	public float getScoreHeight() {
		return _scoreFontHeight;
	}
	
	public float getScoreFontColor() {
		return _scoreFontColor;
	}

	public float getScoreFillColor() {
		return _scoreFillColor;
	}


	public SubRowScore(SubRow subrow) {
		super(subrow);
		HashMap<Integer,Integer> fontColors= new HashMap<Integer,Integer>();
		Integer fontColorMaxCount = 0;
		HashMap<Integer,Integer> fillColors= new HashMap<Integer,Integer>();
		Integer fillColorMaxCount = 0;


		

		for (CellsGroup cellsGroup : subrow) {
			for (StylizedCell stylizedCell : cellsGroup) {
				if(stylizedCell.isBold()) _scoreFontWeight++;
				_scoreFontHeight += stylizedCell.getFontSize();
				
				short fontColor = stylizedCell.getFontColor();
				short fillColor = stylizedCell.getFillColor();

				Integer countFont = fontColors.get(Integer.valueOf(fontColor));
				countFont = (countFont != null)?countFont+1:1;
				fontColors.put(Integer.valueOf(fontColor),countFont);
				
				if(countFont > fontColorMaxCount){
					fontColorMaxCount = countFont;
					_scoreFontColor = fontColor;
				}
				

				Integer countFill = fillColors.get(Integer.valueOf(fillColor));
				countFill = (countFill != null)?countFill+1:1;
				fillColors.put(Integer.valueOf(fillColor),countFill);
				
				if(countFill > fillColorMaxCount){
					fillColorMaxCount = countFill;
					_scoreFillColor = fillColor;
				}
				
			}
		}
		_scoreFontWeight = _scoreFontWeight/subrow.getCellsNb();
		_scoreFontHeight = _scoreFontHeight/subrow.getCellsNb();

	}
	




}
