/**
 */
package org.polarsys.kitalpha.doc.doc2model.common.Common;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.CommonFactory
 * @model kind="package"
 * @generated
 */
public interface CommonPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Common";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.polarsys.org/reqcycle/0.1/common";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "comn";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommonPackage eINSTANCE = org.polarsys.kitalpha.doc.doc2model.common.Common.impl.CommonPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.impl.ContentElementImpl <em>Content Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.ContentElementImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.CommonPackageImpl#getContentElement()
	 * @generated
	 */
	int CONTENT_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_ELEMENT__TEXT_CONTENT = 0;

	/**
	 * The feature id for the '<em><b>Style Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_ELEMENT__STYLE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_ELEMENT__STYLE = 2;

	/**
	 * The number of structural features of the '<em>Content Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Regex</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_ELEMENT___REGEX__STRING = 0;

	/**
	 * The operation id for the '<em>Siblings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_ELEMENT___SIBLINGS__STRING = 1;

	/**
	 * The number of operations of the '<em>Content Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_ELEMENT_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.impl.RegexImpl <em>Regex</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.RegexImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.CommonPackageImpl#getRegex()
	 * @generated
	 */
	int REGEX = 1;

	/**
	 * The number of structural features of the '<em>Regex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>G</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX___G__INT = 0;

	/**
	 * The operation id for the '<em>Matches</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX___MATCHES = 1;

	/**
	 * The number of operations of the '<em>Regex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX_OPERATION_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.DocumentModel <em>Document Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.DocumentModel
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.CommonPackageImpl#getDocumentModel()
	 * @generated
	 */
	int DOCUMENT_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_MODEL__ATTRIBUTES = 0;

	/**
	 * The number of structural features of the '<em>Document Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Document Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_MODEL_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.AttributeImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.CommonPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.impl.StyleImpl <em>Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.StyleImpl
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.CommonPackageImpl#getStyle()
	 * @generated
	 */
	int STYLE = 4;

	/**
	 * The feature id for the '<em><b>Enums</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__ENUMS = 0;

	/**
	 * The number of structural features of the '<em>Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.StyleEnum <em>Style Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.StyleEnum
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.CommonPackageImpl#getStyleEnum()
	 * @generated
	 */
	int STYLE_ENUM = 5;


	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement <em>Content Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content Element</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement
	 * @generated
	 */
	EClass getContentElement();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement#getTextContent <em>Text Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Content</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement#getTextContent()
	 * @see #getContentElement()
	 * @generated
	 */
	EAttribute getContentElement_TextContent();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement#getStyleName <em>Style Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Style Name</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement#getStyleName()
	 * @see #getContentElement()
	 * @generated
	 */
	EAttribute getContentElement_StyleName();

	/**
	 * Returns the meta object for the containment reference '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Style</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement#getStyle()
	 * @see #getContentElement()
	 * @generated
	 */
	EReference getContentElement_Style();

	/**
	 * Returns the meta object for the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement#regex(java.lang.String) <em>Regex</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Regex</em>' operation.
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement#regex(java.lang.String)
	 * @generated
	 */
	EOperation getContentElement__Regex__String();

	/**
	 * Returns the meta object for the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement#siblings(java.lang.String) <em>Siblings</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Siblings</em>' operation.
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement#siblings(java.lang.String)
	 * @generated
	 */
	EOperation getContentElement__Siblings__String();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.Regex <em>Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Regex</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.Regex
	 * @generated
	 */
	EClass getRegex();

	/**
	 * Returns the meta object for the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.Regex#g(int) <em>G</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>G</em>' operation.
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.Regex#g(int)
	 * @generated
	 */
	EOperation getRegex__G__int();

	/**
	 * Returns the meta object for the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.Regex#matches() <em>Matches</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Matches</em>' operation.
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.Regex#matches()
	 * @generated
	 */
	EOperation getRegex__Matches();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.DocumentModel <em>Document Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Model</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.DocumentModel
	 * @generated
	 */
	EClass getDocumentModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.DocumentModel#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.DocumentModel#getAttributes()
	 * @see #getDocumentModel()
	 * @generated
	 */
	EReference getDocumentModel_Attributes();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.Attribute#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.Attribute#getKey()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Key();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.Attribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.Attribute#getValue()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Value();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.Style <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Style</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.Style
	 * @generated
	 */
	EClass getStyle();

	/**
	 * Returns the meta object for the attribute list '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.Style#getEnums <em>Enums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Enums</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.Style#getEnums()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_Enums();

	/**
	 * Returns the meta object for enum '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.StyleEnum <em>Style Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Style Enum</em>'.
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.StyleEnum
	 * @generated
	 */
	EEnum getStyleEnum();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CommonFactory getCommonFactory();

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
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.impl.ContentElementImpl <em>Content Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.ContentElementImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.CommonPackageImpl#getContentElement()
		 * @generated
		 */
		EClass CONTENT_ELEMENT = eINSTANCE.getContentElement();

		/**
		 * The meta object literal for the '<em><b>Text Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT_ELEMENT__TEXT_CONTENT = eINSTANCE.getContentElement_TextContent();

		/**
		 * The meta object literal for the '<em><b>Style Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT_ELEMENT__STYLE_NAME = eINSTANCE.getContentElement_StyleName();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTENT_ELEMENT__STYLE = eINSTANCE.getContentElement_Style();

		/**
		 * The meta object literal for the '<em><b>Regex</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTENT_ELEMENT___REGEX__STRING = eINSTANCE.getContentElement__Regex__String();

		/**
		 * The meta object literal for the '<em><b>Siblings</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTENT_ELEMENT___SIBLINGS__STRING = eINSTANCE.getContentElement__Siblings__String();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.impl.RegexImpl <em>Regex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.RegexImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.CommonPackageImpl#getRegex()
		 * @generated
		 */
		EClass REGEX = eINSTANCE.getRegex();

		/**
		 * The meta object literal for the '<em><b>G</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REGEX___G__INT = eINSTANCE.getRegex__G__int();

		/**
		 * The meta object literal for the '<em><b>Matches</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REGEX___MATCHES = eINSTANCE.getRegex__Matches();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.DocumentModel <em>Document Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.DocumentModel
		 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.CommonPackageImpl#getDocumentModel()
		 * @generated
		 */
		EClass DOCUMENT_MODEL = eINSTANCE.getDocumentModel();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_MODEL__ATTRIBUTES = eINSTANCE.getDocumentModel_Attributes();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.AttributeImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.CommonPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__KEY = eINSTANCE.getAttribute_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.impl.StyleImpl <em>Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.StyleImpl
		 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.CommonPackageImpl#getStyle()
		 * @generated
		 */
		EClass STYLE = eINSTANCE.getStyle();

		/**
		 * The meta object literal for the '<em><b>Enums</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__ENUMS = eINSTANCE.getStyle_Enums();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.StyleEnum <em>Style Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.StyleEnum
		 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.impl.CommonPackageImpl#getStyleEnum()
		 * @generated
		 */
		EEnum STYLE_ENUM = eINSTANCE.getStyleEnum();

	}

} //CommonPackage
