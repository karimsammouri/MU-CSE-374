import java.util.Arrays;

public class Exercise2CountingSort {
	public void nonComparisonSort(int arr[]) {
		int min = Arrays.stream(arr).min().getAsInt();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] - min;
		}
		int max = Arrays.stream(arr).max().getAsInt();
		int[] histogram = new int[max + 1];
		Arrays.fill(histogram, 0);
		for (int i = 0; i < arr.length; i++) {
			histogram[arr[i]]++;
		}
		int index = 0;
		for (int bin = 0; bin < histogram.length; bin++) {
			while (histogram[bin] > 0) {
				arr[index] = bin;
				histogram[bin]--;
				index++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] + min;
		}
	}
}
