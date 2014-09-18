/**
 */
package org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor;

import org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cell</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Cell#getPos <em>Pos</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage#getCell()
 * @model
 * @generated
 */
public interface Cell extends ContentElement {
	/**
	 * Returns the value of the '<em><b>Pos</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pos</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pos</em>' reference.
	 * @see #setPos(Point)
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage#getCell_Pos()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Point getPos();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Cell#getPos <em>Pos</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pos</em>' reference.
	 * @see #getPos()
	 * @generated
	 */
	void setPos(Point value);

} // Cell
