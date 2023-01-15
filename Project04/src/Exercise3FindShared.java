import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Exercise3FindShared<E extends Comparable<? super E>> {
	public List<E> shared(List<E> L1, List<E> L2) {
		// flag to establish which list is larger.
		boolean flag = false;
		// sort smaller list.
		if (L1.size() >= L2.size()) {
			flag = true;
			Collections.sort(L2);
		} else {
			Collections.sort(L1);
		}
		List<E> L3 = new LinkedList<>();
		// depending on which list is larger (flag), iterate through that list.
		if (flag) {
			for (E element : L1) {
				if (Collections.binarySearch(L2, element) > -1) {
					L3.add(element);
				}
			}
		} else {
			for (E element : L2) {
				if (Collections.binarySearch(L1, element) > -1) {
					L3.add(element);
				}
			}
		}
		return L3;
	}
}
