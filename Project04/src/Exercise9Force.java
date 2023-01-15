import java.util.Arrays;

public class Exercise9Force {
	public void sort(Integer[] a) {
		double[] result = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			// Slightly changing same values to account for index.
			result[i] = a[i] + (i / a.length);
		}
		Arrays.sort(result);
		// After sorting, casting doubles to ints and cutting off the tweak to
		// ensure table sorting.
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) result[i];
		}
	}
}
