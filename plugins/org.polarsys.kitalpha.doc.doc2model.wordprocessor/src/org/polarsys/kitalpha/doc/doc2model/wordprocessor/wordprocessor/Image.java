/**
 */
package org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Image#getWidth <em>Width</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Image#getHeight <em>Height</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Image#getTitle <em>Title</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage#getImage()
 * @model
 * @generated
 */
public interface Image extends SectionContents {
	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage#getImage_Width()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Image#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(int)
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage#getImage_Height()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Image#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' containment reference.
	 * @see #setTitle(Title)
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage#getImage_Title()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Title getTitle();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Image#getTitle <em>Title</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' containment reference.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(Title value);

} // Image
