/**
 */
package org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.polarsys.kitalpha.doc.doc2model.common.Common.Attribute;

import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Sheet;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetFile;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetFileImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetFileImpl#getSheet <em>Sheet</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.SpreadsheetFileImpl#getNbSheet <em>Nb Sheet</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpreadsheetFileImpl extends MinimalEObjectImpl.Container implements SpreadsheetFile {
	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

	/**
	 * The cached value of the '{@link #getSheet() <em>Sheet</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSheet()
	 * @generated
	 * @ordered
	 */
	protected EList<Sheet> sheet;

	/**
	 * The default value of the '{@link #getNbSheet() <em>Nb Sheet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbSheet()
	 * @generated
	 * @ordered
	 */
	protected static final int NB_SHEET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNbSheet() <em>Nb Sheet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbSheet()
	 * @generated
	 * @ordered
	 */
	protected int nbSheet = NB_SHEET_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpreadsheetFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpreadsheetPackage.Literals.SPREADSHEET_FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, SpreadsheetPackage.SPREADSHEET_FILE__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Sheet> getSheet() {
		if (sheet == null) {
			sheet = new EObjectContainmentEList<Sheet>(Sheet.class, this, SpreadsheetPackage.SPREADSHEET_FILE__SHEET);
		}
		return sheet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNbSheet() {
		return nbSheet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbSheet(int newNbSheet) {
		int oldNbSheet = nbSheet;
		nbSheet = newNbSheet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpreadsheetPackage.SPREADSHEET_FILE__NB_SHEET, oldNbSheet, nbSheet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpreadsheetPackage.SPREADSHEET_FILE__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case SpreadsheetPackage.SPREADSHEET_FILE__SHEET:
				return ((InternalEList<?>)getSheet()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SpreadsheetPackage.SPREADSHEET_FILE__ATTRIBUTES:
				return getAttributes();
			case SpreadsheetPackage.SPREADSHEET_FILE__SHEET:
				return getSheet();
			case SpreadsheetPackage.SPREADSHEET_FILE__NB_SHEET:
				return getNbSheet();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SpreadsheetPackage.SPREADSHEET_FILE__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case SpreadsheetPackage.SPREADSHEET_FILE__SHEET:
				getSheet().clear();
				getSheet().addAll((Collection<? extends Sheet>)newValue);
				return;
			case SpreadsheetPackage.SPREADSHEET_FILE__NB_SHEET:
				setNbSheet((Integer)newValue);
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
			case SpreadsheetPackage.SPREADSHEET_FILE__ATTRIBUTES:
				getAttributes().clear();
				return;
			case SpreadsheetPackage.SPREADSHEET_FILE__SHEET:
				getSheet().clear();
				return;
			case SpreadsheetPackage.SPREADSHEET_FILE__NB_SHEET:
				setNbSheet(NB_SHEET_EDEFAULT);
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
			case SpreadsheetPackage.SPREADSHEET_FILE__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case SpreadsheetPackage.SPREADSHEET_FILE__SHEET:
				return sheet != null && !sheet.isEmpty();
			case SpreadsheetPackage.SPREADSHEET_FILE__NB_SHEET:
				return nbSheet != NB_SHEET_EDEFAULT;
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
		result.append(" (nbSheet: ");
		result.append(nbSheet);
		result.append(')');
		return result.toString();
	}

} //SpreadsheetFileImpl
