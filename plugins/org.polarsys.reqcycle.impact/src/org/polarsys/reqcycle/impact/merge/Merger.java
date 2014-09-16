package org.polarsys.reqcycle.impact.merge;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.diffmerge.api.IMatchPolicy;
import org.eclipse.emf.diffmerge.api.IMergePolicy;
import org.eclipse.emf.diffmerge.api.Role;
import org.eclipse.emf.diffmerge.api.diff.IDifference;
import org.eclipse.emf.diffmerge.api.scopes.IFeaturedModelScope;
import org.eclipse.emf.diffmerge.diffdata.EComparison;
import org.eclipse.emf.diffmerge.diffdata.impl.EComparisonImpl;
import org.eclipse.emf.diffmerge.impl.scopes.RootedModelScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.polarsys.reqcycle.impact.merge.filters.IDifferenceFilter;
import org.polarsys.reqcycle.impact.merge.filters.OrderDifferenceFilter;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class Merger {

	public static class MergeResult {

		/**
		 * This map contains objects created in the repository by the merge, with their old id as key (needed to update the mapping)
		 */
		public Set<String> refAddedObjectIds = new HashSet<String>();

		/**
		 * This map contains ids of objects deleted in the repository by the merge
		 */
		public Set<String> refRemovedObjectIds = new HashSet<String>();

		public Set<String> targetAddedObjectIds = new HashSet<String>();

		public Set<String> targetRemovedObjectIds = new HashSet<String>();
	}

	public static MergeResult offlineMerge(IProgressMonitor monitor_p, List<? extends EObject> targetObjects, List<? extends EObject> refObjects, List<? extends EObject> ancestorObjects, IDifferenceFilter diffFilter) throws MergerException {
		return offlineMerge(monitor_p, targetObjects, refObjects, ancestorObjects, diffFilter, null, null);
	}

	public static MergeResult offlineMerge(IProgressMonitor monitor_p, List<? extends EObject> targetObjects, List<? extends EObject> refObjects, List<? extends EObject> ancestorObjects, IDifferenceFilter diffFilter, IMatchPolicy matchPolicy,
			IMergePolicy mergePolicy) throws MergerException {
		if (monitor_p == null) {
			monitor_p = new NullProgressMonitor();
		}

		// order differences should never been merged if there are on unordered references
		if (diffFilter == null) {
			diffFilter = new OrderDifferenceFilter();
		}

		try {
			SubMonitor monitor = SubMonitor.convert(monitor_p, "merge", 2);

			CustomRootedModelScope refScope = new CustomRootedModelScope(refObjects);
			CustomRootedModelScope targetScope = new CustomRootedModelScope(targetObjects);

			EComparison comparison = new EComparisonImpl(targetScope, refScope, ancestorObjects == null ? null : new RootedModelScope(ancestorObjects));

			comparison.compute(matchPolicy, null, mergePolicy, monitor.newChild(2));

			List<IDifference> toMergeDiffs = Lists.newArrayList(comparison.getRemainingDifferences());
			diffFilter.filter(toMergeDiffs);

			comparison.merge(toMergeDiffs, Role.TARGET, true, null);

			return computeMergeResult(targetScope, refScope);

		} catch (Exception e) {
			throw new MergerException(e);
		}
	}
	
	private static Function<EObject, String> GET_FRAGMENT_FUNCTION = new Function<EObject, String>() {

		@Override
		public String apply(EObject o) {
			if (o.eResource() != null) {
				return o.eResource().getURIFragment(o);
			}
			return "";
		}
		
	};

	public static MergeResult computeMergeResult(IFeaturedModelScope targetScope, IFeaturedModelScope refScope) {
		MergeResult result = new MergeResult();

		if (refScope instanceof ITrackingModelScope) {
			result.refAddedObjectIds.addAll(Collections2.transform(((ITrackingModelScope) refScope).getAddedObjects(), GET_FRAGMENT_FUNCTION));
			result.refRemovedObjectIds.addAll(((ITrackingModelScope) refScope).getRemovedObjectIds());
		}
		if (targetScope instanceof ITrackingModelScope) {
			result.targetAddedObjectIds.addAll(Collections2.transform(((ITrackingModelScope) targetScope).getAddedObjects(), GET_FRAGMENT_FUNCTION));
			result.targetRemovedObjectIds.addAll(((ITrackingModelScope) targetScope).getRemovedObjectIds());
		}

		return result;
	}

	public static MergeResult compareAndMerge(Resource targetRes, Resource refRes, Resource ancestorRes, String targetDisplayName, String refDisplayName, IDifferenceFilter automergeFilter) throws MergerException {
		EComparison comparison = createComparison(targetRes, refRes, ancestorRes, targetDisplayName, refDisplayName);
		comparison.compute(null, null, null, null);

		if (automergeFilter != null) {
			Collection<IDifference> toMergeDiffs = Lists.newArrayList(comparison.getRemainingDifferences());
			automergeFilter.filter(toMergeDiffs);
			if (!toMergeDiffs.isEmpty()) {
				comparison.merge(toMergeDiffs, Role.TARGET, true, null);
			}
		}

		return computeMergeResult(comparison.getTargetScope(), comparison.getReferenceScope());
	}

	public static EComparison createComparison(Resource targetRes, Resource refRes, Resource ancestorRes, String targetDisplayName, String refDisplayName) {
		TrackingFragmentedModelScope refScope = new TrackingFragmentedModelScope(refRes, refDisplayName);
		TrackingFragmentedModelScope targetScope = new TrackingFragmentedModelScope(targetRes, targetDisplayName);
		TrackingFragmentedModelScope ancestorScope = null;
		if (ancestorRes != null) {
			ancestorScope = new TrackingFragmentedModelScope(ancestorRes, null);
		}
		return new EComparisonImpl(targetScope, refScope, ancestorScope);
	}
}
