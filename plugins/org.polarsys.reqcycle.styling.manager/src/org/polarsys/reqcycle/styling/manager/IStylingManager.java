/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.styling.manager;

import org.polarsys.reqcycle.styling.model.Styling.Styling;

public interface IStylingManager {

	/**
	 * Get the Styling
	 */
	public Styling getStyling();

	/**
	 * Set the name of the preferred Styling Model
	 */
	public void setPreferredStylingModel(String stylingModel);

	/**
	 * Get the name of the preferred Styling Model
	 */
	public String getPreferredStyleModel();

	/**
	 * Reload the previous configuration
	 */
	public void reload();

	/**
	 * Save the current configuration
	 */
	public void save();
	
	/**
	 * Suppress all Case Styles associated to IPredicate predicate
	 */
	public void suppressUselessPredicates();
}
