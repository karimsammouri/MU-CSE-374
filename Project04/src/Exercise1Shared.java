import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Exercise1Shared<E extends Comparable<? super E>> {
	public List<E> shared(List<E> L1, List<E> L2) {
		Collections.sort(L1);
		Collections.sort(L2);
		List<E> L3 = new LinkedList<>();
		Iterator<E> iter1 = L1.iterator();
		Iterator<E> iter2 = L2.iterator();
		E elem1 = null;
		E elem2 = null;
		int index1 = 0;
		int index2 = 0;
		boolean flag = true;
		while (index1 < L1.size() && index2 < L2.size()) {
			if (flag) {
				elem1 = iter1.next();
				elem2 = iter2.next();
				flag = false;
			}
			if (elem1.equals(elem2)) {
				L3.add(elem1);
				if (index1 != L1.size() - 1 && index2 != L2.size() - 1) {
					elem1 = iter1.next();
					elem2 = iter2.next();
				}
				index1++;
				index2++;
			} else if (elem1.compareTo(elem2) < 0) {
				elem1 = iter1.next();
				index1++;
			} else {
				elem2 = iter2.next();
				index2++;
			}
		}
		return L3;
	}
}
