package org.polarsys.kitalpha.doc.doc2model.tikaparsing.pdf;

public class ScoreParagraph extends ParagraphDecorator {

	private float _scoreSize = 0;
	private boolean _bold = false;


	public float getScoreSize() {
		return _scoreSize;
	}



	public boolean isBold() {
		return _bold;
	}



	public ScoreParagraph(Paragraph para){
		super(para); 

		float sizeBold = 0;

		int nb_char = 0;
		int chunk_char = 0;

		for (Chunk elt : getChunks()) {
			chunk_char = elt.getText().length();
			nb_char += chunk_char;
			_scoreSize += elt.getStyle().get_fontSize()*chunk_char;
			sizeBold += ((elt.getStyle().is_bold())?1:0)*chunk_char;
		}

		if(nb_char > 0){
			_scoreSize = _scoreSize/nb_char;
			_bold = (sizeBold/nb_char)> 0.5;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+("Score: "+_scoreSize+"| Bold: "+_bold );
	}

}
