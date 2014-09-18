package org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility.xls;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.poi.hssf.eventusermodel.FormatTrackingHSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.CountryRecord;
import org.apache.poi.hssf.record.DateWindow1904Record;
import org.apache.poi.hssf.record.EOFRecord;
import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.record.FontRecord;
import org.apache.poi.hssf.record.FormatRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.LabelRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.MergeCellsRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.hssf.record.StringRecord;
import org.apache.poi.hssf.record.StyleRecord;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.tika.exception.EncryptedDocumentException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.microsoft.Cell;
import org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility.xls.SubRowScore.SubRowFunction;
import org.xml.sax.SAXException;
//import java.text.NumberFormat;
//import org.apache.poi.hssf.record.DrawingGroupRecord;

/**
 * HSSF Listener implementation which processes the HSSF records.
 */
public class AdvancedTikaHSSFListener implements HSSFListener {



	private SSTRecord sstRecord;
	private FormulaRecord stringFormulaRecord;

	private short previousSid;

	/**
	 * Internal <code>FormatTrackingHSSFListener</code> to handle cell
	 * formatting within the extraction.
	 */
	private FormatTrackingHSSFListener formatListener;

	/**
	 * List of worksheet names.
	 */
	private List<String> sheetNames = new ArrayList<String>();

	/**
	 * Index of the current worksheet within the workbook. Used to find the
	 * worksheet name in the {@link #sheetNames} list.
	 */
	private short currentSheetIndex;

	/**
	 * Content of the current worksheet, or <code>null</code> if no worksheet is
	 * currently active.
	 */
	private SortedMap<Point, Cell> currentSheet = null;

	/**
	 * Extra text or cells that crops up, typically as part of a worksheet but
	 * not always.
	 */
	private List<Cell> extraTextCells = new ArrayList<Cell>();

	//	/**
	//	 * Format for rendering numbers in the worksheet. Currently we just use the
	//	 * platform default formatting.
	//	 * 
	//	 * @see <a
	//	 *      href="https://issues.apache.org/jira/browse/TIKA-103">TIKA-103</a>
	//	 */
	//	private final NumberFormat format;

	//	/**
	//	 * These aren't complete when we first see them, as the depend on continue
	//	 * records that aren't always contiguous. Collect them for later processing.
	//	 */
	//	private List<DrawingGroupRecord> drawingGroups = new ArrayList<DrawingGroupRecord>();

	/**
	 * Content of the current worksheet, or <code>null</code> if no worksheet is
	 * currently active.
	 */
	private List<FontRecord> fontRecords = new ArrayList<FontRecord>();

	private List<ExtendedFormatRecord> extendedFormatRecords = new ArrayList<ExtendedFormatRecord>();
	private List<MergeCellsRecord> mergesCellsRecords = new ArrayList<MergeCellsRecord>();

	/**
	 * Potential exception thrown by the content handler. When set to non-
	 * <code>null</code>, causes all subsequent HSSF records to be ignored and
	 * the stored exception to be thrown when {@link #throwStoredException()} is
	 * invoked.
	 */
	private Exception exception = null;



	//-------------------------------------------------------------------------------
	//Processing Attributes
	//-------------------------------------------------------------------------------
	private List<Line> _lines_read = new LinkedList<Line>();
	private int _index = 0;

	//private List<Table> _finalTables = new ArrayList<Table>();
	//TODO see if LinkedList usage is important
	private LinkedList<SpreadSheetElement> _spreadSheetElements = new LinkedList<SpreadSheetElement>();





	public AdvancedTikaHSSFListener(Locale locale) {
		//this.format = NumberFormat.getInstance(locale);
		this.formatListener = new FormatTrackingHSSFListener(this, locale);

	}

	/**
	 * Entry point to listener to start the processing of a file.
	 * 
	 * @param filesystem
	 *            POI file system.
	 * @param listenForAllRecords
	 *            sets whether the listener is configured to listen for all
	 *            records types or not.
	 * @throws IOException
	 *             on any IO errors.
	 * @throws SAXException
	 *             on any SAX parsing errors.
	 */
	public List<SpreadSheetElement> processFile(NPOIFSFileSystem filesystem,
			boolean listenForAllRecords) throws IOException, SAXException,
			TikaException {
		return processFile(filesystem.getRoot(), listenForAllRecords);
	}

	public List<SpreadSheetElement> processFile(DirectoryNode root, boolean listenForAllRecords)
			throws IOException, SAXException, TikaException {

		// Set up listener and register the records we want to process
		HSSFRequest hssfRequest = new HSSFRequest();
		if (listenForAllRecords) {
			hssfRequest.addListenerForAllRecords(formatListener);
		} else {
			hssfRequest.addListener(formatListener, BOFRecord.sid);
			hssfRequest.addListener(formatListener, EOFRecord.sid);
			hssfRequest.addListener(formatListener, DateWindow1904Record.sid);
			hssfRequest.addListener(formatListener, CountryRecord.sid);
			hssfRequest.addListener(formatListener, BoundSheetRecord.sid);
			hssfRequest.addListener(formatListener, SSTRecord.sid);
			hssfRequest.addListener(formatListener, FormulaRecord.sid);
			hssfRequest.addListener(formatListener, LabelRecord.sid);
			hssfRequest.addListener(formatListener, LabelSSTRecord.sid);
			hssfRequest.addListener(formatListener, NumberRecord.sid);
			// hssfRequest.addListener(formatListener, RKRecord.sid);
			hssfRequest.addListener(formatListener, StringRecord.sid);
			// hssfRequest.addListener(formatListener, HyperlinkRecord.sid);
			// hssfRequest.addListener(formatListener, TextObjectRecord.sid);
			// hssfRequest.addListener(formatListener, SeriesTextRecord.sid);
			hssfRequest.addListener(formatListener, FormatRecord.sid);
			hssfRequest.addListener(formatListener, ExtendedFormatRecord.sid);
			// hssfRequest.addListener(formatListener, DrawingGroupRecord.sid);
			hssfRequest.addListener(formatListener, StyleRecord.sid);
			hssfRequest.addListener(formatListener, FontRecord.sid);
			hssfRequest.addListener(formatListener, MergeCellsRecord.sid);
		}

		// Create event factory and process Workbook (fire events)
		DocumentInputStream documentInputStream = root
				.createDocumentInputStream("Workbook");
		HSSFEventFactory eventFactory = new HSSFEventFactory();
		try {
			eventFactory.processEvents(hssfRequest, documentInputStream);
		} catch (org.apache.poi.EncryptedDocumentException e) {
			throw new EncryptedDocumentException(e);
		}

		// Output any extra text that came after all the sheets
		// processExtraText();

		return _spreadSheetElements;

	}

	@Override
	/**
	 * Process a HSSF record.
	 *
	 * @param record HSSF Record
	 */
	public void processRecord(Record record) {
		if (exception == null) {
			try {
				internalProcessRecord(record);
			} catch (TikaException te) {
				exception = te;
			} catch (IOException ie) {
				exception = ie;
			} catch (SAXException se) {
				exception = se;
			}
		}
	}

	private void internalProcessRecord(Record record) throws SAXException,
	TikaException, IOException {

		// System.out.println(record.getClass().toString());

		switch (record.getSid()) {
		case BOFRecord.sid: // start of workbook, worksheet etc. records
			BOFRecord bof = (BOFRecord) record;
			if (bof.getType() == BOFRecord.TYPE_WORKBOOK) {
				currentSheetIndex = -1;
			} else if (bof.getType() == BOFRecord.TYPE_CHART) {
				if (previousSid == EOFRecord.sid) {
					// This is a sheet which contains only a chart
					newSheet();
				} else {
					// This is a chart within a normal sheet
					// Handling of this is a bit hacky...
					if (currentSheet != null) {
						processSheet();
						currentSheetIndex--;
						newSheet();
					}
				}
			} else if (bof.getType() == BOFRecord.TYPE_WORKSHEET) {
				newSheet();
			}
			break;

		case EOFRecord.sid: // end of workbook, worksheet etc. records
			if (currentSheet != null) {
				processSheet();
			}
			currentSheet = null;
			break;

		case BoundSheetRecord.sid: // Worksheet index record
			BoundSheetRecord boundSheetRecord = (BoundSheetRecord) record;
			sheetNames.add(boundSheetRecord.getSheetname());
			break;

		case SSTRecord.sid: // holds all the strings for LabelSSTRecords
			sstRecord = (SSTRecord) record;
			break;

		case FormulaRecord.sid: // Cell value from a formula
			FormulaRecord formula = (FormulaRecord) record;
			if (formula.hasCachedResultString()) {
				// The String itself should be the next record
				stringFormulaRecord = formula;
			} else {
				addStylizedCell(record,
						formatListener.formatNumberDateCell(formula));
			}
			break;

		case StringRecord.sid:
			if (previousSid == FormulaRecord.sid) {
				// Cached string value of a string formula
				StringRecord sr = (StringRecord) record;
				addStylizedCell(stringFormulaRecord, sr.getString());
			} else {
				// Some other string not associated with a cell, skip
			}
			break;

		case LabelRecord.sid: // strings stored directly in the cell
			LabelRecord label = (LabelRecord) record;
			addStylizedCell(record, label.getValue());
			break;

		case LabelSSTRecord.sid: // Ref. a string in the shared string table
			LabelSSTRecord sst = (LabelSSTRecord) record;
			UnicodeString unicode = sstRecord.getString(sst.getSSTIndex());
			addStylizedCell(record, unicode.getString());
			break;

		case NumberRecord.sid: // Contains a numeric cell value
			NumberRecord number = (NumberRecord) record;

			addStylizedCell(record, formatListener.formatNumberDateCell(number));
			break;

		case ExtendedFormatRecord.sid:
			ExtendedFormatRecord ext = (ExtendedFormatRecord) record;
			extendedFormatRecords.add(ext);
			break;

		case FontRecord.sid:
			FontRecord fr = (FontRecord) record;
			fontRecords.add(fr);
			break;

		case MergeCellsRecord.sid:
			MergeCellsRecord mergeRecord = (MergeCellsRecord) record;
			mergesCellsRecords.add(mergeRecord);
			break;
		}

		previousSid = record.getSid();

		if (stringFormulaRecord != record) {
			stringFormulaRecord = null;
		}
	}

	/**
	 * Adds the given cell (unless <code>null</code>) to the current worksheet
	 * (if any) at the position (if any) of the given record.
	 * 
	 * @param record
	 *            record that holds the cell value
	 * @param cell
	 *            cell value (or <code>null</code>)
	 */
	private void addCell(Record record, Cell cell) throws SAXException {
		if (cell == null) {
			// Ignore empty cells
		} else if (currentSheet != null
				&& record instanceof CellValueRecordInterface) {
			// Normal cell inside a worksheet
			CellValueRecordInterface value = (CellValueRecordInterface) record;
			Point point = new Point(value.getColumn(), value.getRow());
			currentSheet.put(point, cell);
		} else {
			// Cell outside the worksheets
			extraTextCells.add(cell);
		}
	}

	/**
	 * Adds Style and Format infos to the text.
	 * 
	 * @param record
	 *            record that holds the text value
	 * @param text
	 *            text content, may be <code>null</code>
	 * @throws SAXException
	 */
	private void addStylizedCell(Record record, String text)
			throws SAXException {

		if (text != null) {
			text = text.trim();
			if (text.length() > 0) {
				if (record instanceof CellValueRecordInterface) {
					// Normal cell inside a worksheet
					CellValueRecordInterface value = (CellValueRecordInterface) record;

					ExtendedFormatRecord efr = extendedFormatRecords.get(value
							.getXFIndex());

					short index = efr.getFontIndex();
					if (index > 4) {
						index -= 1; // adjust for "There is no 4" //See
					}
					addCell(record,
							new StylizedCell(text, efr, fontRecords.get(index)));
				} else {
					addCell(record,
							new StylizedCell(text));
				}
			}
		}

	}

	private void newSheet() {
		currentSheetIndex++;
		currentSheet = new TreeMap<Point, Cell>(new PointComparator());
	}




	private CellRangeAddress getMergedArea(int rowIndex, int colIndex){
		Iterator<MergeCellsRecord> iteratorMergeRecords = mergesCellsRecords.iterator();
		CellRangeAddress ret = null;
		boolean found = false;
		while (iteratorMergeRecords.hasNext() && !found) {
			MergeCellsRecord record = iteratorMergeRecords.next();
			int index = 0;
			while (index < record.getNumAreas() && !found) {
				ret = record.getAreaAt(index);
				if (rowIndex >= ret.getFirstRow()
						&& rowIndex <= ret.getLastRow()) {
					if (colIndex >= ret.getFirstColumn()
							&& colIndex <= ret.getLastColumn()) {
						found = true;
					}
				}
				index++;
			}
		}

		return (found)?ret:null;
	}

	/**
	 * When the row Index belongs to a merged area, this function returns the
	 * last row of this latter area
	 * 
	 * @param rowIndex
	 * @return
	 */
	//TODO searching in mergesCellsRecords can be optimized by using a custom map of Areas
	private int mergedAreaLastRow(SubRow row) {

		Iterator<CellsGroup> iteratorRow = row.iterator();
		CellRangeAddress area = null;
		while (iteratorRow.hasNext()) {
			CellsGroup cellsGroup = iteratorRow.next();
			area = getMergedArea(cellsGroup.getRowIndex(), cellsGroup.getFirstColumn());
			if(area != null) return area.getLastRow();
		}
		return row.getRowIndex();
	}


	/**
	 * When the row Index belongs to a merged area, this function returns the
	 * last row of this latter area
	 * 
	 * @param rowIndex
	 * @return
	 */
	//TODO searching in mergesCellsRecords can be optimized by using a custom map of Areas
	private int mergedAreaLastColumn(CellsGroup cellsGroup) {
		CellRangeAddress area = getMergedArea(cellsGroup.getRowIndex(), cellsGroup.getLastColumn());
		if(area != null) return area.getLastColumn();

		return cellsGroup.getLastColumn();
	}







	/***
	 * Decide whether this new cellsGroup belongs to the given table header
	 * @param previousPoint
	 * @param currentPoint
	 * @return
	 */
	private CellRangeAddress areContiguous(Point previousPoint, Point currentPoint){

		CellRangeAddress ret = null;
		//Checking whether the two are contiguous
		if(currentPoint.y == previousPoint.y && currentPoint.x != previousPoint.x){


			CellRangeAddress area = getMergedArea(previousPoint.y, previousPoint.x);
			if(area != null &&
					currentPoint.x == area.getLastColumn()+1){
				ret = area;
			}
		}

		return ret;
	}


	/**
	 * 
	 * @param subrow
	 * @return
	 */
	public Table findTable(SubRow subrow){

		SubRowScore subrowScore = new SubRowScore(subrow);

		LinkedList<SubRowScore> arrayScore = new LinkedList<SubRowScore>();
		arrayScore.add(subrowScore);


		Table table = new Table(subrowScore);
		table.setHeader(subrowScore);


		List<SubRow> subRowsReferences = new ArrayList<SubRow>();
		subRowsReferences.add(subrowScore);

		List<Line> LinesReferences = new ArrayList<Line>();
		LinesReferences.add(_lines_read.get(_index));


		//This is used to group all nextLine subrow elements within the current subrow
		SubRow tmpSubrow = subrow;
		boolean goOut = false;
		int indexSave = _index;
		SubRow maxNumberSubRow = subrow;
		int maxNbElement = subrow.getCellsNb();
		int alignedSubRowNb = 0;
		int LastAreaRow = 0;


		//Creating a set of columns number present in header
		//TODO This is not completely optimal because this operation is done twice
		HashSet<Integer> setCol = new HashSet<Integer>();

		for (CellsGroup cg : maxNumberSubRow) {
			int column= cg.getFirstColumn();
			for (int i = 0;i < cg.getCellsNb();i++) {
				setCol.add(Integer.valueOf(column));
				column++;
			}						
		}
		/////////RULE//////////////
		while(!goOut && indexSave < _lines_read.size()){
			int nextLineNumber=_lines_read.get(indexSave).getLineIndex();
			LastAreaRow = mergedAreaLastRow(tmpSubrow);
			int offset = 1;
			while(nextLineNumber < LastAreaRow+1 && (indexSave+offset)<_lines_read.size()){
				nextLineNumber=_lines_read.get(indexSave+offset).getLineIndex();
				offset++ ;
			}

			Iterator<SubRow> nextLineIterator = null;
			if(nextLineNumber != LastAreaRow+1){ //This is due to the absence of a next line
				if(table.getNbRows() == 1){
					goOut=true;
				}
				break;
			}else{
				indexSave += (offset-1);
				nextLineIterator = _lines_read.get(indexSave).iterator() ; 
			}

			tmpSubrow = new SubRowSimple();
			while(!goOut  && nextLineIterator.hasNext() ){
				SubRow nextSubrow = nextLineIterator.next();
				//Here One can put Rules on each element of the nextSubRow elements
				int excess[] = subrow.excess(nextSubrow);
				if(excess[0] <=0 && excess[1] <=0 ){
					tmpSubrow.addSubRowCellsGroup(nextSubrow);
					subRowsReferences.add(nextSubrow);
					LinesReferences.add(_lines_read.get(indexSave));
				}else if (nextSubrow.get_lastColumn() < subrow.get_firstColumn() || subrow.get_lastColumn() < nextSubrow.get_firstColumn()){
					break;
				}else{
					goOut = true;
				}
			}

			//This is due to the absence of subrow within line
			if(tmpSubrow.getCellsNb() == 0){
				goOut = true;				
			}else{

				//Decorate the final tmpSubrow with its score
				subrowScore = new SubRowScore(tmpSubrow);
				table.addSubRow(subrowScore);
				arrayScore.add(subrowScore);

				int nbElements = subrowScore.getCellsNb();
				//Detection of a row having more element elements (Goal=> to find the max one)
				if(nbElements > maxNbElement){
					//TODO take into account the case where data rows contains more than header
					//Determining the last column for this row . So This is done only for header candidates for optimization

					maxNbElement = nbElements;
					maxNumberSubRow = subrowScore;
					table.setHeader(subrowScore);
					alignedSubRowNb = 0;

					//Creating a set of columns number present in this header candidate
					setCol = new HashSet<Integer>();

					for (CellsGroup cg : maxNumberSubRow) {
						int column= cg.getFirstColumn();
						for (int i = 0;i < cg.getCellsNb();i++) {
							setCol.add(Integer.valueOf(column));
							column++;
						}						
					}
				}
			}

		}



		if(goOut) return null;

		/////////RULE//////////////

		for (SubRow row : table) {
			//Checking that every element of the next Line is aligned with a header element
			Iterator<CellsGroup> iterator = row.iterator();
			boolean goOutMax = false;
			while (iterator.hasNext() && !goOutMax) {
				CellsGroup cg = iterator.next();
				int column= cg.getFirstColumn();
				int cpt = 0;
				while (cpt < cg.getCellsNb() && !goOutMax) {
					if(!setCol.contains(Integer.valueOf(column))) goOutMax = true;
					column++;
					cpt++;
				}
			}
			if(!goOutMax){
				((SubRowScore)row).setAligned();
				alignedSubRowNb++;		
			}
		}



		//TODO here you can add new rules on table detection based on the overall bloc
		//if the percentage of line aligned with the best header candidate is not enough
		//this can not be a real table
		float percentage = ((float)alignedSubRowNb)/(table.getNbRows());
		//TODO make this percentage configurable
		if(percentage < 0.5) return null;




		//POST PROCESSING
		//Sort Score
		Collections.sort(arrayScore,new SubRowScoreComparator());
		Iterator<SubRowScore> iteratorScore = arrayScore.iterator();

		//Assigning Hierarchy 
		int hiearchy = 0;
		SubRowScore previousScore = iteratorScore.next();
		previousScore.setHiearchy(hiearchy);
		if(previousScore.getRowIndex() < table.getHeader().getRowIndex()) goOut=true; 

		while(iteratorScore.hasNext() && !goOut ){
			SubRowScore score = iteratorScore.next();
			if(new SubRowScoreComparator().compare(score,previousScore) != 0) hiearchy++;
			score.setHiearchy(hiearchy);
			if(hiearchy > 0 && score.getRowIndex() < table.getHeader().getRowIndex()) goOut=true; 
			previousScore = score;
		}

		if(goOut) return null;


		//set the final max element Row as a Header
		((SubRowScore) table.getHeader()).setSubRowType(SubRowFunction.Header);
		//Set the max Hiearchy level 
		table.setMaxHiearchy(hiearchy);


		//Cleaning in order to not re process them

		//Only When the cells are really a table
		Line line;
		//Remove from lines structure for later parsing optimization 
		for (int ref = 0; ref < subRowsReferences.size(); ref++) {


		line = LinesReferences.get(ref);
		line.removeSubRow(subRowsReferences.get(ref));
	}



		return table;
	}



	private void processStructuredSheet() throws IOException{
		Line currentLine = new Line();
		Iterator<Line> linesIterator = _lines_read.iterator();

		while(linesIterator.hasNext()){
			currentLine = linesIterator.next();
			Iterator<SubRow> iteratorSubRow = currentLine.iterator();
			while (iteratorSubRow.hasNext()) {
				SubRow subrow = iteratorSubRow.next();
				Table table=findTable(subrow);
				if(table != null){
					defineTableElements(table);
					System.out.println(table.getText());
					_spreadSheetElements.add(table);
				}else{
					_spreadSheetElements.add(subrow);
				}
			}

			_index++;
		}

		_lines_read.clear();

	}




	private void defineTableElements(Table table) {
		//Title detection
		String title = "";
		Iterator<SpreadSheetElement> it = _spreadSheetElements.descendingIterator();
		while(it.hasNext()){
			SpreadSheetElement elt = it.next();

			if(elt instanceof Table){
				Table previoustable = (Table) elt;
				if(previoustable.getLastRowIndex() < table.getFirstRowIndex()){
					break;
				}
			}else{
				SubRow subrow = (SubRow) elt;
				if(subrow.getCellsNb() == 1){
					if(table.getHeader().excess(subrow)[0] <= 0 && subrow.get_firstColumn() < table.getHeader().get_lastColumn() ){ //is Left aligned or is over the header
						title = subrow.getText();
						break;
					}else{
						if(title.length() == 0){
							//TODO this can be perhaps being more accurate
							title = subrow.getText();
						}
					}
				}
			}
		}
		table.setTitle(title);


		if(table.getMaxHiearchy() != 0){
			//Table SubTitle and headers detection
			for (SubRow subRow : table) {
				SubRowScore ss = (SubRowScore) subRow;
				if(ss.getHiearchy() != 0){
					Iterator<CellsGroup> grpIterator = ss.iterator();
					CellsGroup previousGrp = grpIterator.next(); //SubRow in a table cannot be empty by construction
					CellsGroup currentGrp = previousGrp;
					//Searching for Gaps in subrow => if yes it can not be a header
					boolean gap = false;
					while(grpIterator.hasNext() && !gap ) {
						currentGrp =  grpIterator.next();
						if(currentGrp.getFirstColumn() != previousGrp.getLastColumn()+1) gap = true;
						previousGrp = currentGrp;
					}
					if(!gap && currentGrp.getLastColumn() == table.getHeader().get_lastGroup().getLastColumn() && ss.getCellsNb() > 1){
						ss.setSubRowType(SubRowFunction.Header);
					}else{
						ss.setSubRowType(SubRowFunction.Title);
						//TODO Detect incomplete Headers
					}
				}else{
					ss.setSubRowType(SubRowFunction.DataContent);
				}
			}
		}else{
			//TODO when no formating exists
			
			((SubRowScore) table.getHeader()).setSubRowType(SubRowFunction.Header);
		}
		
		for (SubRow subRow : table) {
			SubRowScore subrowScore = (SubRowScore) subRow;
			System.out.println(subrowScore.getRowIndex()+"--"+subrowScore.getScoreHeight()+" "+subrowScore.getScoreWeight()+" "+subrowScore.getScoreFontColor()+" "+subrowScore.getScoreFillColor()+"-->"+subrowScore.getHiearchy());
		}
	}




	/**
	 * Process an excel sheet.
	 * 
	 * @throws SAXException
	 *             if an error occurs
	 * @throws IOException
	 */
	private void processSheet() throws SAXException, IOException {

		Iterator<Point> iterator = ((TreeMap<Point, Cell>) currentSheet)
				.descendingKeySet().descendingIterator();


		Point previousPoint = new Point(-1, -1);
		Point currentPoint = new Point(-1, -1);
		StylizedCell currentCell = new StylizedCell("");
		Line currentLine = new Line();
		_lines_read.clear();
		_index = 0;



		CellsGroup currentCellGroup = new CellsGroup();
		SubRow currentSubrow = new SubRowSimple();


		while (iterator.hasNext()) {

			currentPoint = iterator.next();
			currentCell = (StylizedCell) currentSheet.get(currentPoint);

			if (previousPoint.y != currentPoint.y) { // New Row Detection


				currentCellGroup.setLastColumn(mergedAreaLastColumn(currentCellGroup));
				// New Line , SubRow and CellsGroup
				currentCellGroup = new CellsGroup(currentPoint, currentCell);
				currentSubrow = new SubRowSimple();
				currentSubrow.addCellsGroup(currentCellGroup);



				currentLine = new Line(currentPoint.y);
				currentLine.addSubRow(currentSubrow);
				_lines_read.add(currentLine);



			} else if (currentPoint.x != previousPoint.x + 1) { 
				// Line Gap Detection

				CellRangeAddress area = areContiguous(previousPoint, currentPoint);
				if(area == null){
					currentSubrow = new SubRowSimple();
					currentLine.addSubRow(currentSubrow);
					currentCellGroup.setLastColumn(previousPoint.x);
				}else{
					currentCellGroup.setLastColumn(area.getLastColumn());
				}

				currentCellGroup = new CellsGroup(currentPoint, currentCell);
				currentSubrow.addCellsGroup(currentCellGroup);

			} else {
				currentCellGroup.addCell(currentPoint, currentCell);
			}

			previousPoint = currentPoint;
		}


		//Processing

		processStructuredSheet();




	}

	/**
	 * Utility comparator for points.
	 */
	private static class PointComparator implements Comparator<Point> {

		public int compare(Point a, Point b) {
			int diff = a.y - b.y;
			if (diff == 0) {
				diff = a.x - b.x;
			}
			return diff;
		}

	}

}