package org.polarsys.reqcycle.repository.ui;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

public enum RequirementViewDisplayType implements Enumerator {

	NONE(0, "NONE", "NONE"), REQONLY(1, "REQONLY", "REQONLY"), FILTERBYNAME(2, "FILTERBYNAME", "FILTERBYNAME"), FILTERBYPREDICATE(3, "FILTERBYPREDICATE", "FILTERBYPREDICATE"), ORDERBYPREDICATE(4, "ORDERBYPREDICATE", "ORDERBYPREDICATE"), ORDERBYSCOPE(
			5, "ORDERBYSCOPE", "ORDERBYSCOPE");

	public static final int NONE_VALUE = 0;
	public static final int REQONLY_VALUE = 1;
	public static final int FILTERBYNAME_VALUE = 2;
	public static final int FILTERBYPREDICATE_VALUE = 3;
	public static final int ORDERBYPREDICATE_VALUE = 4;
	public static final int ORDERBYSCOPE_VALUE = 5;

	private static final RequirementViewDisplayType[] VALUES_ARRAY = new RequirementViewDisplayType[] { NONE, REQONLY, FILTERBYNAME, FILTERBYPREDICATE, ORDERBYPREDICATE, ORDERBYSCOPE, };

	/**
	 * A public read-only list of all the '<em><b>Font Option</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<RequirementViewDisplayType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Font Option</b></em>' literal with the specified literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static RequirementViewDisplayType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RequirementViewDisplayType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Font Option</b></em>' literal with the specified name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static RequirementViewDisplayType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RequirementViewDisplayType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Font Option</b></em>' literal with the specified integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static RequirementViewDisplayType get(int value) {
		switch (value) {
		case NONE_VALUE:
			return NONE;
		case REQONLY_VALUE:
			return REQONLY;
		case FILTERBYNAME_VALUE:
			return FILTERBYNAME;
		case FILTERBYPREDICATE_VALUE:
			return FILTERBYPREDICATE;
		case ORDERBYPREDICATE_VALUE:
			return ORDERBYPREDICATE;
		case ORDERBYSCOPE_VALUE:
			return ORDERBYSCOPE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private RequirementViewDisplayType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

}
