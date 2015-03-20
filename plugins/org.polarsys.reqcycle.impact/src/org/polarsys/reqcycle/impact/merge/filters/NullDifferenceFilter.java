/**
 * Copyright (c) 2014 AtoS
 *     All rights reserved. This program and the accompanying materials
 *     are made available under the terms of the Eclipse Public License v1.0
 *     which accompanies this distribution, and is available at
 *     http://www.eclipse.org/legal/epl-v10.html *
 *     Contributors:
 *       Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.impact.merge.filters;

import java.util.Collection;

import org.eclipse.emf.diffmerge.api.diff.IDifference;

public class NullDifferenceFilter implements IDifferenceFilter {

	@Override
	public void filter(Collection<IDifference> diffs) {
		// DO NOTHING
	}

}
