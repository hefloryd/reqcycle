package org.polarsys.reqcycle.utils.collect.collectors;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.polarsys.reqcycle.utils.collect.Picker;
import org.polarsys.reqcycle.utils.collect.ResultHandler;
import org.polarsys.reqcycle.utils.collect.exceptions.CannotHandleException;
import org.polarsys.reqcycle.utils.collect.exceptions.CannotPickException;
import org.polarsys.reqcycle.utils.collect.exceptions.CollectionAbortedException;

import com.google.common.collect.Lists;

/**
 * A depth harvester that keeps a trace of the longest depth the element can be found at.
 */
public class DepthMeasuringHarvester<T> extends AbstractCollector<T> {

	protected Map<T, Integer> longestPath = new HashMap<T, Integer>();

	public DepthMeasuringHarvester(T startingElement, Iterable<? extends Picker<T>> pickers) {
		super(startingElement, pickers);
	}

	@Override
	public void collect(ResultHandler<T> handler) throws CollectionAbortedException {
		getLongestPathMap().put(start, 0);
		collectDepthWise(handler, start, 0);
	}

	public Map<T, Integer> getLongestPathMap() {
		return longestPath;
	}

	protected void collectDepthWise(ResultHandler<T> handler, T element, int depth) throws CollectionAbortedException {
		try {
			handler.handleResult(element); // send result to the handler.
			for (Picker<T> picker : this.getPickers()) {
				Iterable<T> nexts = picker.getNexts(element); // getting children.
				if (nexts != null) { // some elements do not have any child.
					for (T next : nexts) {

						Integer nextOldDepth = getLongestPathMap().get(next);

						Integer nextCurrentDepth = Math.max(nextOldDepth != null ? nextOldDepth : -1, depth + 1);
						if (nextCurrentDepth != nextOldDepth) {
							getLongestPathMap().put(next, nextCurrentDepth);
						}
						this.collectDepthWise(handler, next, nextCurrentDepth); // recurse
					}
				}
			}
		} catch (CannotHandleException e) {
			// if the element cannot be handled, do nothing.
		} catch (CannotPickException e) {
			throw new CollectionAbortedException(e);
		}
	}

	/**
	 * Gets a list of the elements computed during the iteration process, from the deepest to the most shallow.
	 */
	public List<T> getElementsFromDeepest() {
		Set<T> keySet = longestPath.keySet();
		List<T> result = Lists.newArrayList(keySet);
		Collections.sort(result, new Comparator<Object>() {

			public int compare(Object arg0, Object arg1) {
				Integer depth0 = getLongestPathMap().get(arg0);
				Integer depth1 = getLongestPathMap().get(arg1);
				if (depth0 > depth1) {
					return -1;
				} else if (depth0 == depth1) {
					return 0;
				} else {
					return 1;
				}
			}
		});

		return result;
	}

}
