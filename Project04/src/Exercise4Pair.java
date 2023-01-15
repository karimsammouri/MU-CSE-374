import java.util.Arrays;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class Exercise4Pair<E> {
	public Pair<Integer, Integer> pair(E[] arr, E target) {
		int index = Arrays.binarySearch(arr, target);
		Pair<Integer, Integer> result;
		if (index > -1) {
			result = new ImmutablePair<>(index, arr.length - index - 1);
		} else {
			result = new ImmutablePair<>(0, 0);
		}
		return result;
	}
}
