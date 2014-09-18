/**
 */
package org.polarsys.kitalpha.doc.doc2model.common.Common;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.common.Common.Style#getEnums <em>Enums</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.CommonPackage#getStyle()
 * @model
 * @generated
 */
public interface Style extends EObject {
	/**
	 * Returns the value of the '<em><b>Enums</b></em>' attribute list.
	 * The list contents are of type {@link org.polarsys.kitalpha.doc.doc2model.common.Common.StyleEnum}.
	 * The literals are from the enumeration {@link org.polarsys.kitalpha.doc.doc2model.common.Common.StyleEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enums</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enums</em>' attribute list.
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.StyleEnum
	 * @see org.polarsys.kitalpha.doc.doc2model.common.Common.CommonPackage#getStyle_Enums()
	 * @model
	 * @generated
	 */
	EList<StyleEnum> getEnums();

} // Style
