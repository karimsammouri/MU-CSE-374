import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class Exercise10Farthest {
	public static Pair<Double, Double> farthestPair(double a[]) {
		double min = a[0];
		double max = a[0];
		for (double x : a) {
			if (x < min) {
				min = x;
			}
			if (x > max) {
				max = x;
			}
		}
		Pair<Double, Double> result = new ImmutablePair<>(min, max);
		return result;
	}
}
