/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.polarsys.reqcycle.traceability.model.TType;

public class SerializationUtils {

	/**
	 * Returns a serialized version of the given {@link TType}. The resulting
	 * {@link String} is url safe.
	 * 
	 * @param object
	 * @return null if an error occurs
	 */
	public static String serialize(final Object object) {
		ObjectOutputStream objOutStrm = null;
		try {
			final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			objOutStrm = new ObjectOutputStream(byteArrayOutputStream);
			objOutStrm.writeObject(object);
			objOutStrm.flush();
			final byte[] bytes = byteArrayOutputStream.toByteArray();
			return encode(bytes);
		} catch (final IOException e) {
			e.printStackTrace(); // TODO Error management
		} finally {
			if (objOutStrm != null) {
				try {
					objOutStrm.close();
				} catch (final IOException e) {
					e.printStackTrace(); // TODO Error management
				}
			}
		}
		return null;
	}

	/**
	 * Return the {@link TType} serialized in the given string
	 * 
	 * @param getByteRepresentation
	 *            (inputString)
	 * @return null if an error occurs
	 * 
	 */
	public static <T> T deserialize(final String inputString) {
		ObjectInputStream stream = null;
		try {
			final byte[] inputBytes = decode(inputString);
			stream = new ObjectInputStream(new ByteArrayInputStream(inputBytes));
			@SuppressWarnings("unchecked")
			final T result = (T) stream.readObject();
			return result;
		} catch (final IOException e) {
			e.printStackTrace(); // TODO Error management
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (final IOException e) {
					e.printStackTrace(); // TODO Error management
				}
			}
		}
		return null;
	}

	private static String encode(final byte[] bytes) {
		final Base64 encoder = new Base64(true);
		return encoder.encodeToString(bytes);
	}

	private static byte[] decode(final String inputString) {
		final Base64 encoder = new Base64(true);
		return encoder.decode(inputString);
	}
}
