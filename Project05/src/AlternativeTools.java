import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Karim Sammouri
 * CSE 374A
 * Dr. Philippe Giabbanelli
 * 6 May 2021
 * Assignment #5: Section II
 */
public class AlternativeTools<E extends Comparable<? super E>> {

	public void getNestedUnique(E[] array, int n) {
		boolean flag = false;
		for (int i = 0, count = 0; count < n && i < array.length; i++) {
			flag = true;
			for (int j = 0; j < array.length; j++) {
				if (i != j && array[i].equals(array[j])) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				System.out.print(array[i].toString() + " ");
				count++;
			}
		}
	}

	public void getSortedUnique(E[] array, int n) {
		Arrays.sort(array);
		E watchList = null;
		for (int i = 0, count = 0; count < n && i < array.length - 1; i++) {
			if (!array[i].equals(watchList) && !array[i].equals(array[i + 1])) {
				System.out.print(array[i].toString() + " ");
				count++;
			} else
				watchList = array[i];
			if (i == array.length - 2 && !array[i].equals(array[i + 1])) {
				System.out.print(array[i + 1]);
				count++;
			}
		}
	}

	// Time complexity of theta(n) and space complexity of theta(n).
	public void getMapUnique(E[] array, int n) {
		Map<E, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			map.put(array[i],
					(map.get(array[i]) == null ? 1 : map.get(array[i]) + 1));
		}
		for (E element : map.keySet()) {
			if (count < n) {
				if (map.get(element) == 1) {
					System.out.print(element + " ");
					count++;
				}
			} else
				break;
		}
	}

	public void getHeapUnique(E[] array, int n) {
		Map<E, Pair<Integer, Integer>> map = new HashMap<>();
		PriorityQueue<E> heap = new PriorityQueue<>();
		for (int i = 0; i < array.length; i++) {
			map.put(array[i],
					new ImmutablePair<>(map.get(array[i]) == null
							? 1
							: map.get(array[i]).getLeft() + 1, i));
		}
		for (E element : map.keySet()) {
			if (map.get(element).getLeft() == 1) {
				heap.add(element);
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(heap.poll() + " ");
		}
	}
}
