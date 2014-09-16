package org.polarsys.reqcycle.impact.merge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.diffmerge.impl.scopes.RootedModelScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;


public class CustomRootedModelScope extends RootedModelScope implements ITrackingModelScope {

	protected Set<EObject> addedObjects = new HashSet<EObject>();

	protected Set<String> removedObjectIds = new HashSet<String>();

	public CustomRootedModelScope(List<? extends EObject> roots_p) {
		super(roots_p);
	}

	@Override
	public Set<EObject> getAddedObjects() {
		return addedObjects;
	}

	@Override
	public Set<String> getRemovedObjectIds() {
		return removedObjectIds;
	}

	@Override
	public boolean add(EObject source_p, EReference reference_p, EObject value_p) {
		if (!source_p.eResource().equals(value_p.eResource()) && reference_p.isContainment()) {
			addedObjects.add(value_p);
		}
		return super.add(source_p, reference_p, value_p);
	}

	@Override
	public boolean add(EObject element_p) {
		addedObjects.add(element_p);
		return super.add(element_p);
	}

	@Override
	public boolean remove(EObject element_p) {
		if (element_p.eResource() != null) {
			String id = element_p.eResource().getURIFragment(element_p);
			removedObjectIds.add(id);
		}
		return super.remove(element_p);
	}

}
