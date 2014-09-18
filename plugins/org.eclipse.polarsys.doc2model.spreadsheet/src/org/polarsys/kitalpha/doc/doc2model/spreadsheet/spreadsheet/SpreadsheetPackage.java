/**
 */
package org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.polarsys.kitalpha.doc.doc2model.common.Common.CommonPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetFactory
 * @model kind="package"
 * @generated
 */
public interface SpreadsheetPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "spreadsheet";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.polarsys.org/reqcycle/0.1/ssh";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ssh";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SpreadsheetPackage eINSTANCE = org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.ExcelFileImpl <em>Excel File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.ExcelFileImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getExcelFile()
	 * @generated
	 */
	int EXCEL_FILE = 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEL_FILE__ATTRIBUTES = CommonPackage.DOCUMENT_MODEL__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Sheet</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEL_FILE__SHEET = CommonPackage.DOCUMENT_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nb Sheet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEL_FILE__NB_SHEET = CommonPackage.DOCUMENT_MODEL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Excel File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEL_FILE_FEATURE_COUNT = CommonPackage.DOCUMENT_MODEL_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Excel File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEL_FILE_OPERATION_COUNT = CommonPackage.DOCUMENT_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SheetImpl <em>Sheet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SheetImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getSheet()
	 * @generated
	 */
	int SHEET = 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHEET__TEXT = 0;

	/**
	 * The feature id for the '<em><b>Image</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHEET__IMAGE = 1;

	/**
	 * The feature id for the '<em><b>Table</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHEET__TABLE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHEET__NAME = 3;

	/**
	 * The number of structural features of the '<em>Sheet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHEET_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Sheet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHEET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TextImpl <em>Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TextImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getText()
	 * @generated
	 */
	int TEXT = 2;

	/**
	 * The feature id for the '<em><b>Title</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__TEXT_CONTENT = 1;

	/**
	 * The number of structural features of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TitleImpl <em>Title</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TitleImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getTitle()
	 * @generated
	 */
	int TITLE = 3;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE__TEXT_CONTENT = CommonPackage.CONTENT_ELEMENT__TEXT_CONTENT;

	/**
	 * The feature id for the '<em><b>Style Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE__STYLE_NAME = CommonPackage.CONTENT_ELEMENT__STYLE_NAME;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE__STYLE = CommonPackage.CONTENT_ELEMENT__STYLE;

	/**
	 * The feature id for the '<em><b>Hiearchy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE__HIEARCHY = CommonPackage.CONTENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Title</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_FEATURE_COUNT = CommonPackage.CONTENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Regex</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE___REGEX__STRING = CommonPackage.CONTENT_ELEMENT___REGEX__STRING;

	/**
	 * The operation id for the '<em>Siblings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE___SIBLINGS__STRING = CommonPackage.CONTENT_ELEMENT___SIBLINGS__STRING;

	/**
	 * The number of operations of the '<em>Title</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_OPERATION_COUNT = CommonPackage.CONTENT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.ImageImpl <em>Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.ImageImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 4;

	/**
	 * The feature id for the '<em><b>Title</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Image Pos</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__IMAGE_POS = 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__WIDTH = 2;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__HEIGHT = 3;

	/**
	 * The number of structural features of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.PointImpl <em>Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.PointImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getPoint()
	 * @generated
	 */
	int POINT = 5;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__Y = 1;

	/**
	 * The number of structural features of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TableImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 6;

	/**
	 * The feature id for the '<em><b>Title</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Header</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__HEADER = 1;

	/**
	 * The feature id for the '<em><b>Row</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__ROW = 2;

	/**
	 * The feature id for the '<em><b>Nb Rows</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__NB_ROWS = 3;

	/**
	 * The feature id for the '<em><b>Nb Columns</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__NB_COLUMNS = 4;

	/**
	 * The feature id for the '<em><b>Table Pos</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__TABLE_POS = 5;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.HeaderImpl <em>Header</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.HeaderImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getHeader()
	 * @generated
	 */
	int HEADER = 7;

	/**
	 * The feature id for the '<em><b>Cell</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER__CELL = 0;

	/**
	 * The number of structural features of the '<em>Header</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Header</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.CellImpl <em>Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.CellImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getCell()
	 * @generated
	 */
	int CELL = 8;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL__TEXT_CONTENT = CommonPackage.CONTENT_ELEMENT__TEXT_CONTENT;

	/**
	 * The feature id for the '<em><b>Style Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL__STYLE_NAME = CommonPackage.CONTENT_ELEMENT__STYLE_NAME;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL__STYLE = CommonPackage.CONTENT_ELEMENT__STYLE;

	/**
	 * The feature id for the '<em><b>Pos Cell</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL__POS_CELL = CommonPackage.CONTENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_FEATURE_COUNT = CommonPackage.CONTENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Regex</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL___REGEX__STRING = CommonPackage.CONTENT_ELEMENT___REGEX__STRING;

	/**
	 * The operation id for the '<em>Siblings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL___SIBLINGS__STRING = CommonPackage.CONTENT_ELEMENT___SIBLINGS__STRING;

	/**
	 * The operation id for the '<em>Get Col Number</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL___GET_COL_NUMBER = CommonPackage.CONTENT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Row Number</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL___GET_ROW_NUMBER = CommonPackage.CONTENT_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Offset</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL___OFFSET__INT_INT = CommonPackage.CONTENT_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_OPERATION_COUNT = CommonPackage.CONTENT_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.RowImpl <em>Row</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.RowImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getRow()
	 * @generated
	 */
	int ROW = 9;

	/**
	 * The feature id for the '<em><b>Cell</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__CELL = 0;

	/**
	 * The number of structural features of the '<em>Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.ExcelFile <em>Excel File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Excel File</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.ExcelFile
	 * @generated
	 */
	EClass getExcelFile();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.ExcelFile#getSheet <em>Sheet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sheet</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.ExcelFile#getSheet()
	 * @see #getExcelFile()
	 * @generated
	 */
	EReference getExcelFile_Sheet();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.ExcelFile#getNbSheet <em>Nb Sheet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nb Sheet</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.ExcelFile#getNbSheet()
	 * @see #getExcelFile()
	 * @generated
	 */
	EAttribute getExcelFile_NbSheet();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Sheet <em>Sheet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sheet</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Sheet
	 * @generated
	 */
	EClass getSheet();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Sheet#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Text</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Sheet#getText()
	 * @see #getSheet()
	 * @generated
	 */
	EReference getSheet_Text();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Sheet#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Image</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Sheet#getImage()
	 * @see #getSheet()
	 * @generated
	 */
	EReference getSheet_Image();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Sheet#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Table</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Sheet#getTable()
	 * @see #getSheet()
	 * @generated
	 */
	EReference getSheet_Table();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Sheet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Sheet#getName()
	 * @see #getSheet()
	 * @generated
	 */
	EAttribute getSheet_Name();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Text
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Text#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Title</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Text#getTitle()
	 * @see #getText()
	 * @generated
	 */
	EReference getText_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Text#getTextContent <em>Text Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Content</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Text#getTextContent()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_TextContent();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Title <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Title</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Title
	 * @generated
	 */
	EClass getTitle();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Title#getHiearchy <em>Hiearchy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hiearchy</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Title#getHiearchy()
	 * @see #getTitle()
	 * @generated
	 */
	EAttribute getTitle_Hiearchy();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Image
	 * @generated
	 */
	EClass getImage();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Image#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Title</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Image#getTitle()
	 * @see #getImage()
	 * @generated
	 */
	EReference getImage_Title();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Image#getImagePos <em>Image Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image Pos</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Image#getImagePos()
	 * @see #getImage()
	 * @generated
	 */
	EReference getImage_ImagePos();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Image#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Image#getWidth()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Image#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Image#getHeight()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Height();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Point
	 * @generated
	 */
	EClass getPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Point#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Point#getX()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_X();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Point#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Point#getY()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_Y();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Table#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Title</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Table#getTitle()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Title();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Table#getHeader <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Header</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Table#getHeader()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Header();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Table#getRow <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Row</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Table#getRow()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Row();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Table#getNbRows <em>Nb Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nb Rows</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Table#getNbRows()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_NbRows();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Table#getNbColumns <em>Nb Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nb Columns</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Table#getNbColumns()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_NbColumns();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Table#getTablePos <em>Table Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table Pos</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Table#getTablePos()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_TablePos();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Header <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Header</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Header
	 * @generated
	 */
	EClass getHeader();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Header#getCell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cell</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Header#getCell()
	 * @see #getHeader()
	 * @generated
	 */
	EReference getHeader_Cell();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Cell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cell</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Cell
	 * @generated
	 */
	EClass getCell();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Cell#getPosCell <em>Pos Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pos Cell</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Cell#getPosCell()
	 * @see #getCell()
	 * @generated
	 */
	EReference getCell_PosCell();

	/**
	 * Returns the meta object for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Cell#getColNumber() <em>Get Col Number</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Col Number</em>' operation.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Cell#getColNumber()
	 * @generated
	 */
	EOperation getCell__GetColNumber();

	/**
	 * Returns the meta object for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Cell#getRowNumber() <em>Get Row Number</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Row Number</em>' operation.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Cell#getRowNumber()
	 * @generated
	 */
	EOperation getCell__GetRowNumber();

	/**
	 * Returns the meta object for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Cell#offset(int, int) <em>Offset</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Offset</em>' operation.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Cell#offset(int, int)
	 * @generated
	 */
	EOperation getCell__Offset__int_int();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Row <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Row</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Row
	 * @generated
	 */
	EClass getRow();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Row#getCell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cell</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Row#getCell()
	 * @see #getRow()
	 * @generated
	 */
	EReference getRow_Cell();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SpreadsheetFactory getSpreadsheetFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.ExcelFileImpl <em>Excel File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.ExcelFileImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getExcelFile()
		 * @generated
		 */
		EClass EXCEL_FILE = eINSTANCE.getExcelFile();

		/**
		 * The meta object literal for the '<em><b>Sheet</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXCEL_FILE__SHEET = eINSTANCE.getExcelFile_Sheet();

		/**
		 * The meta object literal for the '<em><b>Nb Sheet</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXCEL_FILE__NB_SHEET = eINSTANCE.getExcelFile_NbSheet();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SheetImpl <em>Sheet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SheetImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getSheet()
		 * @generated
		 */
		EClass SHEET = eINSTANCE.getSheet();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHEET__TEXT = eINSTANCE.getSheet_Text();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHEET__IMAGE = eINSTANCE.getSheet_Image();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHEET__TABLE = eINSTANCE.getSheet_Table();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHEET__NAME = eINSTANCE.getSheet_Name();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TextImpl <em>Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TextImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getText()
		 * @generated
		 */
		EClass TEXT = eINSTANCE.getText();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT__TITLE = eINSTANCE.getText_Title();

		/**
		 * The meta object literal for the '<em><b>Text Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__TEXT_CONTENT = eINSTANCE.getText_TextContent();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TitleImpl <em>Title</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TitleImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getTitle()
		 * @generated
		 */
		EClass TITLE = eINSTANCE.getTitle();

		/**
		 * The meta object literal for the '<em><b>Hiearchy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TITLE__HIEARCHY = eINSTANCE.getTitle_Hiearchy();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.ImageImpl <em>Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.ImageImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getImage()
		 * @generated
		 */
		EClass IMAGE = eINSTANCE.getImage();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE__TITLE = eINSTANCE.getImage_Title();

		/**
		 * The meta object literal for the '<em><b>Image Pos</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE__IMAGE_POS = eINSTANCE.getImage_ImagePos();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__WIDTH = eINSTANCE.getImage_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__HEIGHT = eINSTANCE.getImage_Height();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.PointImpl <em>Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.PointImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getPoint()
		 * @generated
		 */
		EClass POINT = eINSTANCE.getPoint();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__X = eINSTANCE.getPoint_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__Y = eINSTANCE.getPoint_Y();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TableImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__TITLE = eINSTANCE.getTable_Title();

		/**
		 * The meta object literal for the '<em><b>Header</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__HEADER = eINSTANCE.getTable_Header();

		/**
		 * The meta object literal for the '<em><b>Row</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__ROW = eINSTANCE.getTable_Row();

		/**
		 * The meta object literal for the '<em><b>Nb Rows</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE__NB_ROWS = eINSTANCE.getTable_NbRows();

		/**
		 * The meta object literal for the '<em><b>Nb Columns</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE__NB_COLUMNS = eINSTANCE.getTable_NbColumns();

		/**
		 * The meta object literal for the '<em><b>Table Pos</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__TABLE_POS = eINSTANCE.getTable_TablePos();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.HeaderImpl <em>Header</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.HeaderImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getHeader()
		 * @generated
		 */
		EClass HEADER = eINSTANCE.getHeader();

		/**
		 * The meta object literal for the '<em><b>Cell</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HEADER__CELL = eINSTANCE.getHeader_Cell();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.CellImpl <em>Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.CellImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getCell()
		 * @generated
		 */
		EClass CELL = eINSTANCE.getCell();

		/**
		 * The meta object literal for the '<em><b>Pos Cell</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CELL__POS_CELL = eINSTANCE.getCell_PosCell();

		/**
		 * The meta object literal for the '<em><b>Get Col Number</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CELL___GET_COL_NUMBER = eINSTANCE.getCell__GetColNumber();

		/**
		 * The meta object literal for the '<em><b>Get Row Number</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CELL___GET_ROW_NUMBER = eINSTANCE.getCell__GetRowNumber();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CELL___OFFSET__INT_INT = eINSTANCE.getCell__Offset__int_int();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.RowImpl <em>Row</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.RowImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetPackageImpl#getRow()
		 * @generated
		 */
		EClass ROW = eINSTANCE.getRow();

		/**
		 * The meta object literal for the '<em><b>Cell</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROW__CELL = eINSTANCE.getRow_Cell();

	}

} //SpreadsheetPackage
