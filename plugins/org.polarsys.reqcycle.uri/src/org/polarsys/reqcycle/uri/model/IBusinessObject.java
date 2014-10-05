/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.uri.model;

/**
 * {@link ReachableObject} could be adapted to this interface.
 * If yes, the method exists verifies if the business object really exist
 * if a {@link ReachableObject} is not adaptable it does not mean it does not exist
 * @author tfaure
 *
 */
public interface IBusinessObject {
	boolean exists () ;
	
	public static class DefaultBusinessObject implements IBusinessObject {
		boolean value ;
		
		public DefaultBusinessObject(boolean exist) {
			this.value = exist;
		}
		
		@Override
		public boolean exists() {
			return value;
		}
	}
}
