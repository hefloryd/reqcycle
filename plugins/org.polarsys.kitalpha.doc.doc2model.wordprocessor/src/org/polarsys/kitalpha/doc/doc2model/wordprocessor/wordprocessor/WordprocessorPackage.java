/**
 */
package org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor;

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
 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorFactory
 * @model kind="package"
 * @generated
 */
public interface WordprocessorPackage extends EPackage {
	
	
	/**
	 * @generated NOT
	 */
	static String FILE_EXTENSION = "wp";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "wordprocessor";
	

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.polarsys.org/reqcycle/0.1/wp";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "wp";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WordprocessorPackage eINSTANCE = org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WPFileImpl <em>WP File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WPFileImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getWPFile()
	 * @generated
	 */
	int WP_FILE = 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WP_FILE__ATTRIBUTES = CommonPackage.DOCUMENT_MODEL__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Main Section</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WP_FILE__MAIN_SECTION = CommonPackage.DOCUMENT_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WP_FILE__AUTHOR = CommonPackage.DOCUMENT_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WP_FILE__DATE = CommonPackage.DOCUMENT_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WP_FILE__NAME = CommonPackage.DOCUMENT_MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>WP File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WP_FILE_FEATURE_COUNT = CommonPackage.DOCUMENT_MODEL_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>WP File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WP_FILE_OPERATION_COUNT = CommonPackage.DOCUMENT_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.SectionImpl <em>Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.SectionImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getSection()
	 * @generated
	 */
	int SECTION = 1;

	/**
	 * The feature id for the '<em><b>Title</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Image</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__IMAGE = 1;

	/**
	 * The feature id for the '<em><b>Table</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__TABLE = 2;

	/**
	 * The feature id for the '<em><b>Paragraph</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__PARAGRAPH = 3;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__CONTENTS = 4;

	/**
	 * The feature id for the '<em><b>Hiearchy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__HIEARCHY = 5;

	/**
	 * The feature id for the '<em><b>Sections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__SECTIONS = 6;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__PARENT = 7;

	/**
	 * The number of structural features of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.TitleImpl <em>Title</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.TitleImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getTitle()
	 * @generated
	 */
	int TITLE = 2;

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
	 * The number of structural features of the '<em>Title</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_FEATURE_COUNT = CommonPackage.CONTENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Regex</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE___REGEX__STRING = CommonPackage.CONTENT_ELEMENT___REGEX__STRING;

	/**
	 * The number of operations of the '<em>Title</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_OPERATION_COUNT = CommonPackage.CONTENT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.SectionContents <em>Section Contents</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.SectionContents
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getSectionContents()
	 * @generated
	 */
	int SECTION_CONTENTS = 10;

	/**
	 * The feature id for the '<em><b>Subtitle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_CONTENTS__SUBTITLE = 0;

	/**
	 * The number of structural features of the '<em>Section Contents</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_CONTENTS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Section Contents</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_CONTENTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.ImageImpl <em>Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.ImageImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 3;

	/**
	 * The feature id for the '<em><b>Subtitle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__SUBTITLE = SECTION_CONTENTS__SUBTITLE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__WIDTH = SECTION_CONTENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__HEIGHT = SECTION_CONTENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Title</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__TITLE = SECTION_CONTENTS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FEATURE_COUNT = SECTION_CONTENTS_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_OPERATION_COUNT = SECTION_CONTENTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.TableImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 4;

	/**
	 * The feature id for the '<em><b>Subtitle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__SUBTITLE = SECTION_CONTENTS__SUBTITLE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__TITLE = SECTION_CONTENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__HEADER = SECTION_CONTENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Row</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__ROW = SECTION_CONTENTS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = SECTION_CONTENTS_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Cell</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE___GET_CELL__INT_INT = SECTION_CONTENTS_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_OPERATION_COUNT = SECTION_CONTENTS_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.HeaderImpl <em>Header</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.HeaderImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getHeader()
	 * @generated
	 */
	int HEADER = 5;

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
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.CellImpl <em>Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.CellImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getCell()
	 * @generated
	 */
	int CELL = 6;

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
	 * The feature id for the '<em><b>Pos</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL__POS = CommonPackage.CONTENT_ELEMENT_FEATURE_COUNT + 0;

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
	 * The number of operations of the '<em>Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_OPERATION_COUNT = CommonPackage.CONTENT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.PointImpl <em>Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.PointImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getPoint()
	 * @generated
	 */
	int POINT = 7;

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
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.RowImpl <em>Row</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.RowImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getRow()
	 * @generated
	 */
	int ROW = 8;

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
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.StringChunkImpl <em>String Chunk</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.StringChunkImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getStringChunk()
	 * @generated
	 */
	int STRING_CHUNK = 9;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CHUNK__TEXT_CONTENT = CommonPackage.CONTENT_ELEMENT__TEXT_CONTENT;

	/**
	 * The feature id for the '<em><b>Style Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CHUNK__STYLE_NAME = CommonPackage.CONTENT_ELEMENT__STYLE_NAME;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CHUNK__STYLE = CommonPackage.CONTENT_ELEMENT__STYLE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CHUNK__TITLE = CommonPackage.CONTENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Chunk</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CHUNK_FEATURE_COUNT = CommonPackage.CONTENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Regex</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CHUNK___REGEX__STRING = CommonPackage.CONTENT_ELEMENT___REGEX__STRING;

	/**
	 * The number of operations of the '<em>String Chunk</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CHUNK_OPERATION_COUNT = CommonPackage.CONTENT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.ParagraphImpl <em>Paragraph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.ParagraphImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getParagraph()
	 * @generated
	 */
	int PARAGRAPH = 11;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__TEXT_CONTENT = CommonPackage.CONTENT_ELEMENT__TEXT_CONTENT;

	/**
	 * The feature id for the '<em><b>Style Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__STYLE_NAME = CommonPackage.CONTENT_ELEMENT__STYLE_NAME;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__STYLE = CommonPackage.CONTENT_ELEMENT__STYLE;

	/**
	 * The feature id for the '<em><b>Subtitle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__SUBTITLE = CommonPackage.CONTENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Chunks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__CHUNKS = CommonPackage.CONTENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Paragraph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH_FEATURE_COUNT = CommonPackage.CONTENT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Regex</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH___REGEX__STRING = CommonPackage.CONTENT_ELEMENT___REGEX__STRING;

	/**
	 * The number of operations of the '<em>Paragraph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH_OPERATION_COUNT = CommonPackage.CONTENT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile <em>WP File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WP File</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile
	 * @generated
	 */
	EClass getWPFile();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile#getMainSection <em>Main Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Main Section</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile#getMainSection()
	 * @see #getWPFile()
	 * @generated
	 */
	EReference getWPFile_MainSection();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile#getName()
	 * @see #getWPFile()
	 * @generated
	 */
	EAttribute getWPFile_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile#getAuthor()
	 * @see #getWPFile()
	 * @generated
	 */
	EAttribute getWPFile_Author();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile#getDate()
	 * @see #getWPFile()
	 * @generated
	 */
	EAttribute getWPFile_Date();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section
	 * @generated
	 */
	EClass getSection();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Title</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section#getTitle()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_Title();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Image</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section#getImage()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_Image();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Table</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section#getTable()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_Table();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section#getParagraph <em>Paragraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Paragraph</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section#getParagraph()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_Paragraph();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section#getContents()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_Contents();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section#getHiearchy <em>Hiearchy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hiearchy</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section#getHiearchy()
	 * @see #getSection()
	 * @generated
	 */
	EAttribute getSection_Hiearchy();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section#getSections <em>Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sections</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section#getSections()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_Sections();

	/**
	 * Returns the meta object for the container reference '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section#getParent()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_Parent();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Title <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Title</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Title
	 * @generated
	 */
	EClass getTitle();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Image
	 * @generated
	 */
	EClass getImage();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Image#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Image#getWidth()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Image#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Image#getHeight()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Height();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Image#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Title</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Image#getTitle()
	 * @see #getImage()
	 * @generated
	 */
	EReference getImage_Title();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Table#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Title</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Table#getTitle()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Title();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Table#getHeader <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Header</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Table#getHeader()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Header();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Table#getRow <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Row</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Table#getRow()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Row();

	/**
	 * Returns the meta object for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Table#getCell(int, int) <em>Get Cell</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Cell</em>' operation.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Table#getCell(int, int)
	 * @generated
	 */
	EOperation getTable__GetCell__int_int();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Header <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Header</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Header
	 * @generated
	 */
	EClass getHeader();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Header#getCell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cell</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Header#getCell()
	 * @see #getHeader()
	 * @generated
	 */
	EReference getHeader_Cell();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Cell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cell</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Cell
	 * @generated
	 */
	EClass getCell();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Cell#getPos <em>Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pos</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Cell#getPos()
	 * @see #getCell()
	 * @generated
	 */
	EReference getCell_Pos();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Point
	 * @generated
	 */
	EClass getPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Point#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Point#getX()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_X();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Point#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Point#getY()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_Y();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Row <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Row</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Row
	 * @generated
	 */
	EClass getRow();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Row#getCell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cell</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Row#getCell()
	 * @see #getRow()
	 * @generated
	 */
	EReference getRow_Cell();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.StringChunk <em>String Chunk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Chunk</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.StringChunk
	 * @generated
	 */
	EClass getStringChunk();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.StringChunk#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Title</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.StringChunk#getTitle()
	 * @see #getStringChunk()
	 * @generated
	 */
	EReference getStringChunk_Title();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.SectionContents <em>Section Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section Contents</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.SectionContents
	 * @generated
	 */
	EClass getSectionContents();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.SectionContents#getSubtitle <em>Subtitle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Subtitle</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.SectionContents#getSubtitle()
	 * @see #getSectionContents()
	 * @generated
	 */
	EReference getSectionContents_Subtitle();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Paragraph <em>Paragraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Paragraph</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Paragraph
	 * @generated
	 */
	EClass getParagraph();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Paragraph#getChunks <em>Chunks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Chunks</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Paragraph#getChunks()
	 * @see #getParagraph()
	 * @generated
	 */
	EReference getParagraph_Chunks();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WordprocessorFactory getWordprocessorFactory();

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
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WPFileImpl <em>WP File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WPFileImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getWPFile()
		 * @generated
		 */
		EClass WP_FILE = eINSTANCE.getWPFile();

		/**
		 * The meta object literal for the '<em><b>Main Section</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WP_FILE__MAIN_SECTION = eINSTANCE.getWPFile_MainSection();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WP_FILE__NAME = eINSTANCE.getWPFile_Name();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WP_FILE__AUTHOR = eINSTANCE.getWPFile_Author();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WP_FILE__DATE = eINSTANCE.getWPFile_Date();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.SectionImpl <em>Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.SectionImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getSection()
		 * @generated
		 */
		EClass SECTION = eINSTANCE.getSection();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION__TITLE = eINSTANCE.getSection_Title();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION__IMAGE = eINSTANCE.getSection_Image();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION__TABLE = eINSTANCE.getSection_Table();

		/**
		 * The meta object literal for the '<em><b>Paragraph</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION__PARAGRAPH = eINSTANCE.getSection_Paragraph();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION__CONTENTS = eINSTANCE.getSection_Contents();

		/**
		 * The meta object literal for the '<em><b>Hiearchy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECTION__HIEARCHY = eINSTANCE.getSection_Hiearchy();

		/**
		 * The meta object literal for the '<em><b>Sections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION__SECTIONS = eINSTANCE.getSection_Sections();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION__PARENT = eINSTANCE.getSection_Parent();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.TitleImpl <em>Title</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.TitleImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getTitle()
		 * @generated
		 */
		EClass TITLE = eINSTANCE.getTitle();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.ImageImpl <em>Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.ImageImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getImage()
		 * @generated
		 */
		EClass IMAGE = eINSTANCE.getImage();

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
		 * The meta object literal for the '<em><b>Title</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE__TITLE = eINSTANCE.getImage_Title();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.TableImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__TITLE = eINSTANCE.getTable_Title();

		/**
		 * The meta object literal for the '<em><b>Header</b></em>' containment reference feature.
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
		 * The meta object literal for the '<em><b>Get Cell</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TABLE___GET_CELL__INT_INT = eINSTANCE.getTable__GetCell__int_int();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.HeaderImpl <em>Header</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.HeaderImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getHeader()
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
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.CellImpl <em>Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.CellImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getCell()
		 * @generated
		 */
		EClass CELL = eINSTANCE.getCell();

		/**
		 * The meta object literal for the '<em><b>Pos</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CELL__POS = eINSTANCE.getCell_Pos();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.PointImpl <em>Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.PointImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getPoint()
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
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.RowImpl <em>Row</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.RowImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getRow()
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

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.StringChunkImpl <em>String Chunk</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.StringChunkImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getStringChunk()
		 * @generated
		 */
		EClass STRING_CHUNK = eINSTANCE.getStringChunk();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_CHUNK__TITLE = eINSTANCE.getStringChunk_Title();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.SectionContents <em>Section Contents</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.SectionContents
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getSectionContents()
		 * @generated
		 */
		EClass SECTION_CONTENTS = eINSTANCE.getSectionContents();

		/**
		 * The meta object literal for the '<em><b>Subtitle</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION_CONTENTS__SUBTITLE = eINSTANCE.getSectionContents_Subtitle();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.ParagraphImpl <em>Paragraph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.ParagraphImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.WordprocessorPackageImpl#getParagraph()
		 * @generated
		 */
		EClass PARAGRAPH = eINSTANCE.getParagraph();

		/**
		 * The meta object literal for the '<em><b>Chunks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAGRAPH__CHUNKS = eINSTANCE.getParagraph_Chunks();

	}

} //WordprocessorPackage
