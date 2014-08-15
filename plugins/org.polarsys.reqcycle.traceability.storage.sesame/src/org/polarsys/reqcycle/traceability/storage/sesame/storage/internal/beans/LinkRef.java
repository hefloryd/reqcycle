/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.storage.sesame.storage.internal.beans;

import org.openrdf.model.URI;
import org.polarsys.reqcycle.traceability.engine.ITraceabilityEngine.DIRECTION;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

public class LinkRef {
	private final URI id;
	private final URI kind;
	private final DIRECTION direction;

	public LinkRef(final URI id, final URI kind, final DIRECTION direction) {
		super();
		this.id = id;
		this.kind = kind;
		this.direction = direction;
	}

	/**
	 * @return the id
	 */
	public final URI getId() {
		return this.id;
	}

	/**
	 * @return the kind
	 */
	public final URI getKind() {
		return this.kind;
	}

	/**
	 * @return the direction
	 */
	public final DIRECTION getDirection() {
		return direction;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, kind, direction);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		LinkRef other = (LinkRef) obj;
		if (direction != other.direction) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (kind == null) {
			if (other.kind != null) {
				return false;
			}
		} else if (!kind.equals(other.kind)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final ToStringHelper toStringHelper = Objects.toStringHelper(this);
		toStringHelper.add("id", id);
		toStringHelper.add("kind", kind);
		toStringHelper.add("direction", direction);
		return toStringHelper.toString();
	}

}
