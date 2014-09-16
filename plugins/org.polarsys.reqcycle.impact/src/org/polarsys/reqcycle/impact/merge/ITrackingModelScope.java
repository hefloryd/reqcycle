package org.polarsys.reqcycle.impact.merge;

import java.util.Set;

import org.eclipse.emf.diffmerge.api.scopes.IFeaturedModelScope;
import org.eclipse.emf.ecore.EObject;

public interface ITrackingModelScope extends IFeaturedModelScope {

	Set<EObject> getAddedObjects();

	Set<String> getRemovedObjectIds();
}
