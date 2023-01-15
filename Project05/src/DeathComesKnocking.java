import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Karim Sammouri
 * CSE 374A
 * Dr. Philippe Giabbanelli
 * 6 May 2021
 * Assignment #5: Section IV
 */
public class DeathComesKnocking {

	public static int getInfections(int[] houses, int days) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(houses.length,
				Collections.reverseOrder());
		for (Integer house : houses) {
			heap.add(house);
		}
		int result = 0;
		for (int i = 0; i < days; i++) {
			System.out.println(heap);
			int max = heap.poll();
			result += max;
			heap.add(max / 2);
		}
		return result;
	}
}
