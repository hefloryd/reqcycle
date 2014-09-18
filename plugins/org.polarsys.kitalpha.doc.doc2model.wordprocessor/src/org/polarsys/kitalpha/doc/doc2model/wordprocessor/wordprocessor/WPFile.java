/**
 */
package org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor;

import java.util.Date;

import org.polarsys.kitalpha.doc.doc2model.common.Common.DocumentModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WP File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile#getMainSection <em>Main Section</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile#getDate <em>Date</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage#getWPFile()
 * @model
 * @generated
 */
public interface WPFile extends DocumentModel {
	/**
	 * Returns the value of the '<em><b>Main Section</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Section</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Section</em>' containment reference.
	 * @see #setMainSection(Section)
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage#getWPFile_MainSection()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Section getMainSection();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile#getMainSection <em>Main Section</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Section</em>' containment reference.
	 * @see #getMainSection()
	 * @generated
	 */
	void setMainSection(Section value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage#getWPFile_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' attribute.
	 * @see #setAuthor(String)
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage#getWPFile_Author()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getAuthor();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile#getAuthor <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' attribute.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(String value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage#getWPFile_Date()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

} // WPFile
