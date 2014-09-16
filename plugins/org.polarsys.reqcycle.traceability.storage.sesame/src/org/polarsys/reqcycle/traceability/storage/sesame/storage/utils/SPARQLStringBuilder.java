/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.storage.sesame.storage.utils;

import java.util.HashMap;
import java.util.Map;

import org.openrdf.model.Namespace;
import org.openrdf.model.Resource;
import org.openrdf.model.URI;

/**
 * Delegate around {@link StringBuilder} that adds SPARQL query building helpers.
 * 
 * @author rsemlal
 */
public class SPARQLStringBuilder {
	private Map<String, String> namespaces = new HashMap<String, String>();
	private StringBuilder _builder;

	public SPARQLStringBuilder(final StringBuilder builder) {
		this._builder = builder;
	}

	/**
	 * @return
	 * @see java.lang.AbstractStringBuilder#length()
	 */
	public int length() {
		return _builder.length();
	}

	/**
	 * @return
	 * @see java.lang.AbstractStringBuilder#capacity()
	 */
	public int capacity() {
		return _builder.capacity();
	}

	/**
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return _builder.hashCode();
	}

	/**
	 * @param minimumCapacity
	 * @see java.lang.AbstractStringBuilder#ensureCapacity(int)
	 */
	public void ensureCapacity(int minimumCapacity) {
		_builder.ensureCapacity(minimumCapacity);
	}

	/**
	 * 
	 * @see java.lang.AbstractStringBuilder#trimToSize()
	 */
	public void trimToSize() {
		_builder.trimToSize();
	}

	/**
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		return _builder.equals(obj);
	}

	/**
	 * @param newLength
	 * @see java.lang.AbstractStringBuilder#setLength(int)
	 */
	public void setLength(int newLength) {
		_builder.setLength(newLength);
	}

	/**
	 * @param obj
	 * @return
	 * @see java.lang.StringBuilder#append(java.lang.Object)
	 */
	public StringBuilder append(Object obj) {
		return _builder.append(obj);
	}

	/**
	 * @param str
	 * @return
	 * @see java.lang.StringBuilder#append(java.lang.String)
	 */
	public StringBuilder append(String str) {
		return _builder.append(str);
	}

	/**
	 * @param sb
	 * @return
	 * @see java.lang.StringBuilder#append(java.lang.StringBuffer)
	 */
	public StringBuilder append(StringBuffer sb) {
		return _builder.append(sb);
	}

	/**
	 * @param index
	 * @return
	 * @see java.lang.AbstractStringBuilder#charAt(int)
	 */
	public char charAt(int index) {
		return _builder.charAt(index);
	}

	/**
	 * @param s
	 * @return
	 * @see java.lang.StringBuilder#append(java.lang.CharSequence)
	 */
	public StringBuilder append(CharSequence s) {
		return _builder.append(s);
	}

	/**
	 * @param s
	 * @param start
	 * @param end
	 * @return
	 * @see java.lang.StringBuilder#append(java.lang.CharSequence, int, int)
	 */
	public StringBuilder append(CharSequence s, int start, int end) {
		return _builder.append(s, start, end);
	}

	/**
	 * @param index
	 * @return
	 * @see java.lang.AbstractStringBuilder#codePointAt(int)
	 */
	public int codePointAt(int index) {
		return _builder.codePointAt(index);
	}

	/**
	 * @param str
	 * @return
	 * @see java.lang.StringBuilder#append(char[])
	 */
	public StringBuilder append(char[] str) {
		return _builder.append(str);
	}

	/**
	 * @param str
	 * @param offset
	 * @param len
	 * @return
	 * @see java.lang.StringBuilder#append(char[], int, int)
	 */
	public StringBuilder append(char[] str, int offset, int len) {
		return _builder.append(str, offset, len);
	}

	/**
	 * @param b
	 * @return
	 * @see java.lang.StringBuilder#append(boolean)
	 */
	public StringBuilder append(boolean b) {
		return _builder.append(b);
	}

	/**
	 * @param c
	 * @return
	 * @see java.lang.StringBuilder#append(char)
	 */
	public StringBuilder append(char c) {
		return _builder.append(c);
	}

	/**
	 * @param i
	 * @return
	 * @see java.lang.StringBuilder#append(int)
	 */
	public StringBuilder append(int i) {
		return _builder.append(i);
	}

	/**
	 * @param lng
	 * @return
	 * @see java.lang.StringBuilder#append(long)
	 */
	public StringBuilder append(long lng) {
		return _builder.append(lng);
	}

	/**
	 * @param f
	 * @return
	 * @see java.lang.StringBuilder#append(float)
	 */
	public StringBuilder append(float f) {
		return _builder.append(f);
	}

	/**
	 * @param d
	 * @return
	 * @see java.lang.StringBuilder#append(double)
	 */
	public StringBuilder append(double d) {
		return _builder.append(d);
	}

	/**
	 * @param codePoint
	 * @return
	 * @see java.lang.StringBuilder#appendCodePoint(int)
	 */
	public StringBuilder appendCodePoint(int codePoint) {
		return _builder.appendCodePoint(codePoint);
	}

	/**
	 * @param start
	 * @param end
	 * @return
	 * @see java.lang.StringBuilder#delete(int, int)
	 */
	public StringBuilder delete(int start, int end) {
		return _builder.delete(start, end);
	}

	/**
	 * @param index
	 * @return
	 * @see java.lang.AbstractStringBuilder#codePointBefore(int)
	 */
	public int codePointBefore(int index) {
		return _builder.codePointBefore(index);
	}

	/**
	 * @param index
	 * @return
	 * @see java.lang.StringBuilder#deleteCharAt(int)
	 */
	public StringBuilder deleteCharAt(int index) {
		return _builder.deleteCharAt(index);
	}

	/**
	 * @param start
	 * @param end
	 * @param str
	 * @return
	 * @see java.lang.StringBuilder#replace(int, int, java.lang.String)
	 */
	public StringBuilder replace(int start, int end, String str) {
		return _builder.replace(start, end, str);
	}

	/**
	 * @param index
	 * @param str
	 * @param offset
	 * @param len
	 * @return
	 * @see java.lang.StringBuilder#insert(int, char[], int, int)
	 */
	public StringBuilder insert(int index, char[] str, int offset, int len) {
		return _builder.insert(index, str, offset, len);
	}

	/**
	 * @param offset
	 * @param obj
	 * @return
	 * @see java.lang.StringBuilder#insert(int, java.lang.Object)
	 */
	public StringBuilder insert(int offset, Object obj) {
		return _builder.insert(offset, obj);
	}

	/**
	 * @param offset
	 * @param str
	 * @return
	 * @see java.lang.StringBuilder#insert(int, java.lang.String)
	 */
	public StringBuilder insert(int offset, String str) {
		return _builder.insert(offset, str);
	}

	/**
	 * @param offset
	 * @param str
	 * @return
	 * @see java.lang.StringBuilder#insert(int, char[])
	 */
	public StringBuilder insert(int offset, char[] str) {
		return _builder.insert(offset, str);
	}

	/**
	 * @param dstOffset
	 * @param s
	 * @return
	 * @see java.lang.StringBuilder#insert(int, java.lang.CharSequence)
	 */
	public StringBuilder insert(int dstOffset, CharSequence s) {
		return _builder.insert(dstOffset, s);
	}

	/**
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 * @see java.lang.AbstractStringBuilder#codePointCount(int, int)
	 */
	public int codePointCount(int beginIndex, int endIndex) {
		return _builder.codePointCount(beginIndex, endIndex);
	}

	/**
	 * @param dstOffset
	 * @param s
	 * @param start
	 * @param end
	 * @return
	 * @see java.lang.StringBuilder#insert(int, java.lang.CharSequence, int, int)
	 */
	public StringBuilder insert(int dstOffset, CharSequence s, int start, int end) {
		return _builder.insert(dstOffset, s, start, end);
	}

	/**
	 * @param offset
	 * @param b
	 * @return
	 * @see java.lang.StringBuilder#insert(int, boolean)
	 */
	public StringBuilder insert(int offset, boolean b) {
		return _builder.insert(offset, b);
	}

	/**
	 * @param offset
	 * @param c
	 * @return
	 * @see java.lang.StringBuilder#insert(int, char)
	 */
	public StringBuilder insert(int offset, char c) {
		return _builder.insert(offset, c);
	}

	/**
	 * @param offset
	 * @param i
	 * @return
	 * @see java.lang.StringBuilder#insert(int, int)
	 */
	public StringBuilder insert(int offset, int i) {
		return _builder.insert(offset, i);
	}

	/**
	 * @param offset
	 * @param l
	 * @return
	 * @see java.lang.StringBuilder#insert(int, long)
	 */
	public StringBuilder insert(int offset, long l) {
		return _builder.insert(offset, l);
	}

	/**
	 * @param index
	 * @param codePointOffset
	 * @return
	 * @see java.lang.AbstractStringBuilder#offsetByCodePoints(int, int)
	 */
	public int offsetByCodePoints(int index, int codePointOffset) {
		return _builder.offsetByCodePoints(index, codePointOffset);
	}

	/**
	 * @param offset
	 * @param f
	 * @return
	 * @see java.lang.StringBuilder#insert(int, float)
	 */
	public StringBuilder insert(int offset, float f) {
		return _builder.insert(offset, f);
	}

	/**
	 * @param offset
	 * @param d
	 * @return
	 * @see java.lang.StringBuilder#insert(int, double)
	 */
	public StringBuilder insert(int offset, double d) {
		return _builder.insert(offset, d);
	}

	/**
	 * @param str
	 * @return
	 * @see java.lang.StringBuilder#indexOf(java.lang.String)
	 */
	public int indexOf(String str) {
		return _builder.indexOf(str);
	}

	/**
	 * @param str
	 * @param fromIndex
	 * @return
	 * @see java.lang.StringBuilder#indexOf(java.lang.String, int)
	 */
	public int indexOf(String str, int fromIndex) {
		return _builder.indexOf(str, fromIndex);
	}

	/**
	 * @param str
	 * @return
	 * @see java.lang.StringBuilder#lastIndexOf(java.lang.String)
	 */
	public int lastIndexOf(String str) {
		return _builder.lastIndexOf(str);
	}

	/**
	 * @param str
	 * @param fromIndex
	 * @return
	 * @see java.lang.StringBuilder#lastIndexOf(java.lang.String, int)
	 */
	public int lastIndexOf(String str, int fromIndex) {
		return _builder.lastIndexOf(str, fromIndex);
	}

	/**
	 * @return
	 * @see java.lang.StringBuilder#reverse()
	 */
	public StringBuilder reverse() {
		return _builder.reverse();
	}

	/**
	 * @param srcBegin
	 * @param srcEnd
	 * @param dst
	 * @param dstBegin
	 * @see java.lang.AbstractStringBuilder#getChars(int, int, char[], int)
	 */
	public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
		_builder.getChars(srcBegin, srcEnd, dst, dstBegin);
	}

	/**
	 * @param index
	 * @param ch
	 * @see java.lang.AbstractStringBuilder#setCharAt(int, char)
	 */
	public void setCharAt(int index, char ch) {
		_builder.setCharAt(index, ch);
	}

	/**
	 * @param start
	 * @return
	 * @see java.lang.AbstractStringBuilder#substring(int)
	 */
	public String substring(int start) {
		return _builder.substring(start);
	}

	/**
	 * @param start
	 * @param end
	 * @return
	 * @see java.lang.AbstractStringBuilder#subSequence(int, int)
	 */
	public CharSequence subSequence(int start, int end) {
		return _builder.subSequence(start, end);
	}

	/**
	 * @param start
	 * @param end
	 * @return
	 * @see java.lang.AbstractStringBuilder#substring(int, int)
	 */
	public String substring(int start, int end) {
		return _builder.substring(start, end);
	}

	/**
	 * Appends a PREFIX clause.
	 * 
	 * @param ns
	 *            {@link Namespace} object.
	 */
	public SPARQLStringBuilder prefix(Namespace ns) {
		namespaces.put(ns.getName(), ns.getPrefix());
		_builder.append("PREFIX ").append(ns.getPrefix()).append(": <").append(ns.getName()).append("> ");
		return this;
	}

	/**
	 * Appends a FROM clause.
	 * 
	 * @param context
	 *            Context.
	 */
	public SPARQLStringBuilder from(Resource context) {
		_builder.append("FROM <").append(context.stringValue()).append("> ");
		return this;
	}

	/**
	 * Appends a SELECT clause.
	 * 
	 * @param tokens
	 *            List of tokens.
	 */
	public SPARQLStringBuilder select(String... tokens) {
		_builder.append("SELECT ");
		for (final String token : tokens) {
			_builder.append(" ?").append(token);
		}
		_builder.append(" ");
		return this;
	}

	/**
	 * Appends a {@link URI}.
	 * 
	 * @param aUri
	 *            URI to appends.
	 */
	public SPARQLStringBuilder uri(URI aUri) {
		final String namespace = aUri.getNamespace();
		final String nsname = namespaces.get(namespace);
		if (nsname != null && nsname.length() > 0) {
			_builder.append(nsname).append(':').append(aUri.getLocalName());
		} else {
			_builder.append('<').append(aUri.stringValue()).append('>');
		}
		return this;
	}

	/**
	 * Appends a token.
	 * 
	 * @param aUri
	 *            name of the token to appends.
	 */
	public SPARQLStringBuilder token(String name) {
		_builder.append('?').append(name);
		return this;
	}

	public SPARQLStringBuilder statement(URI val1, URI val2, URI val3) {
		uri(val1);
		append(' ');
		uri(val2);
		append(' ');
		uri(val3);
		append(" . ");
		return this;
	}

	public SPARQLStringBuilder statement(String val1, URI val2, URI val3) {
		token(val1);
		append(' ');
		uri(val2);
		append(' ');
		uri(val3);
		append(" . ");
		return this;
	}

	public SPARQLStringBuilder statement(String val1, String val2, URI val3) {
		token(val1);
		append(' ');
		token(val2);
		append(' ');
		uri(val3);
		append(" . ");
		return this;
	}

	public SPARQLStringBuilder statement(String val1, URI val2, String val3) {
		token(val1);
		append(' ');
		uri(val2);
		append(' ');
		token(val3);
		append(" . ");
		return this;
	}

	public SPARQLStringBuilder statement(URI val1, String val2, URI val3) {
		uri(val1);
		append(' ');
		token(val2);
		append(' ');
		uri(val3);
		append(" . ");
		return this;
	}

	public SPARQLStringBuilder statement(URI val1, String val2, String val3) {
		uri(val1);
		append(' ');
		token(val2);
		append(' ');
		token(val3);
		append(" . ");
		return this;
	}

	public SPARQLStringBuilder statement(URI val1, URI val2, String val3) {
		uri(val1);
		append(' ');
		uri(val2);
		append(' ');
		token(val3);
		append(" . ");
		return this;
	}

	public SPARQLStringBuilder statement(String val1, String val2, String val3) {
		token(val1);
		append(' ');
		token(val2);
		append(' ');
		token(val3);
		append(" . ");
		return this;
	}

	/**
	 * @return
	 * @see java.lang.StringBuilder#toString()
	 */
	public String toString() {
		return _builder.toString();
	}

}
