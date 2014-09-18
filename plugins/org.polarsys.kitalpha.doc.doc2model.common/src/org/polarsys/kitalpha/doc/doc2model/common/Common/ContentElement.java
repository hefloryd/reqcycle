/**
 */
package org.polarsys.kitalpha.doc.doc2model.common.Common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Content Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement#getTextContent <em>Text Content</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement#getStyleName <em>Style Name</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement#getStyle <em>Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.CommonPackage#getContentElement()
 * @model abstract="true"
 * @generated
 */
public interface ContentElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Text Content</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Content</em>' attribute.
	 * @see #setTextContent(String)
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.CommonPackage#getContentElement_TextContent()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getTextContent();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement#getTextContent <em>Text Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Content</em>' attribute.
	 * @see #getTextContent()
	 * @generated
	 */
	void setTextContent(String value);

	/**
	 * Returns the value of the '<em><b>Style Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style Name</em>' attribute.
	 * @see #setStyleName(String)
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.CommonPackage#getContentElement_StyleName()
	 * @model
	 * @generated
	 */
	String getStyleName();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement#getStyleName <em>Style Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style Name</em>' attribute.
	 * @see #getStyleName()
	 * @generated
	 */
	void setStyleName(String value);

	/**
	 * Returns the value of the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style</em>' containment reference.
	 * @see #setStyle(Style)
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.CommonPackage#getContentElement_Style()
	 * @model containment="true"
	 * @generated
	 */
	Style getStyle();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement#getStyle <em>Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style</em>' containment reference.
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(Style value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Regex regex(String regex);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ContentElement siblings(String regex);

} // ContentElement
