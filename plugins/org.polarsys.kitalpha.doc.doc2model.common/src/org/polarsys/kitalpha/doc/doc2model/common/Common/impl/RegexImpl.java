/**
 */
package org.polarsys.kitalpha.doc.doc2model.common.Common.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.polarsys.kitalpha.doc.doc2model.common.Common.CommonPackage;
import org.polarsys.kitalpha.doc.doc2model.common.Common.Regex;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Regex</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RegexImpl extends MinimalEObjectImpl.Container implements Regex {
	private String textContent;
	private Pattern p;
	private Matcher matcher;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegexImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.REGEX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public String g(int i) {
		if (matches() && matcher.groupCount() >= i){
			return matcher.group(i);
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public boolean matches() {
		if (matcher == null && p != null && textContent != null){
			matcher = p.matcher(textContent);
		}
		return matcher.matches();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CommonPackage.REGEX___G__INT:
				return g((Integer)arguments.get(0));
			case CommonPackage.REGEX___MATCHES:
				return matches();
		}
		return super.eInvoke(operationID, arguments);
	}

	public void setPattern(Pattern p) {
		matcher = null;
		this.p = p;
	}

	public void setValue(String textContent) {
		matcher = null;
		this.textContent = textContent;
	}

	public String getPattern() {
		return p.pattern();
	}

	public String getValue() {
		return textContent;
	}

} //RegexImpl
