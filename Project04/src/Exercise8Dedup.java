import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exercise8Dedup {
	public String[] dedup(String[] a) {
		int duplicities = 0;
		Set<String> presentStrings = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			if (presentStrings.contains(a[i])) {
				duplicities++;
			} else {
				presentStrings.add(a[i]);
			}
		}
		String[] result = new String[a.length - duplicities];
		presentStrings = new HashSet<>();
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			if (!presentStrings.contains(a[i])) {
				result[index] = a[i];
				presentStrings.add(a[i]);
				index++;
			}
		}
		Arrays.sort(result);
		return result;
	}
}
