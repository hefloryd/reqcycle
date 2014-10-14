package org.polarsys.kitalpha.doc.doc2model.tikaparsing.xls;

import java.util.Comparator;

public class SubRowScoreComparator implements Comparator<SubRowScore>{

	
	private static final float VARIANCE = (float) 1.0;
	
	@Override
	public int compare(SubRowScore sub1, SubRowScore sub2) {
	
		int ret = 0;
		float val1 = sub1.getScoreWeight();
		float val2 = sub2.getScoreWeight();
		
		float diff = Math.abs(val1-val2) ;
		if(diff < VARIANCE){
			ret = 0;
		}else if (val1>val2){
			ret = 1;
		}else{
			ret = -1;
		}
		
		if(ret == 0){
			val1 = sub1.getScoreHeight();
			val2 = sub2.getScoreHeight();
			
			diff = Math.abs(val1-val2) ;
			if(diff < VARIANCE){
				ret = 0;
			}else if (val1>val2){
				ret = 1;
			}else{
				ret = -1;
			}
		}
		
		if(ret == 0){
			if(sub1.getScoreFillColor() != -1 && sub2.getScoreFillColor() == -1){
				ret = 1;
			}else if(sub1.getScoreFillColor() == -1 && sub2.getScoreFillColor() != -1){
				ret = -1;
			}else{
				ret = 0;
			}
		}
		
		if(ret == 0){
			if(sub1.getScoreFontColor() != -1 && sub2.getScoreFontColor() == -1){
				ret = 1;
			}else if(sub1.getScoreFontColor() == -1 && sub2.getScoreFontColor() != -1){
				ret = -1;
			}else{
				ret = 0;
			}
		}
		
		return ret;	
	}
	
	
}