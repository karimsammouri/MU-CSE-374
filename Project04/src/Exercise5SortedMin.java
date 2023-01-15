
public class Exercise5SortedMin<E> {
	public int min(int[] arr) {
		if (arr.length == 0) {
			return -1;
		}
		int first = 0;
		int last = arr.length - 1;
		while (first <= last) {
			if (arr[first] <= arr[last]) {
				return arr[first];
			}
			int mid = (first + last) / 2;
			if (arr[mid] >= arr[first]) {
				first = mid + 1;
			} else {
				last = mid;
			}
		}
		return -1;
	}
}
