/**
 */
package org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polarsys.kitalpha.doc.doc2model.common.Common.impl.ContentElementImpl;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetPackage;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Title;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Title</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TitleImpl#getHiearchy <em>Hiearchy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TitleImpl extends ContentElementImpl implements Title {
	/**
	 * The default value of the '{@link #getHiearchy() <em>Hiearchy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHiearchy()
	 * @generated
	 * @ordered
	 */
	protected static final String HIEARCHY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHiearchy() <em>Hiearchy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHiearchy()
	 * @generated
	 * @ordered
	 */
	protected String hiearchy = HIEARCHY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TitleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpreadsheetPackage.Literals.TITLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHiearchy() {
		return hiearchy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHiearchy(String newHiearchy) {
		String oldHiearchy = hiearchy;
		hiearchy = newHiearchy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpreadsheetPackage.TITLE__HIEARCHY, oldHiearchy, hiearchy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SpreadsheetPackage.TITLE__HIEARCHY:
				return getHiearchy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SpreadsheetPackage.TITLE__HIEARCHY:
				setHiearchy((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SpreadsheetPackage.TITLE__HIEARCHY:
				setHiearchy(HIEARCHY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SpreadsheetPackage.TITLE__HIEARCHY:
				return HIEARCHY_EDEFAULT == null ? hiearchy != null : !HIEARCHY_EDEFAULT.equals(hiearchy);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (hiearchy: ");
		result.append(hiearchy);
		result.append(')');
		return result.toString();
	}

} //TitleImpl
