import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise7Diff<E> {

	public int compare(List<E> list, Comparator<E> comp1,
			Comparator<E> comp2) {
		
		int count = 0;

		List<E> tempList = new ArrayList<>(list);
		
		Collections.sort(list, comp1);
		Collections.sort(tempList, comp2);

		int index = 0;
		for (E x : list) {
			if (x.equals(tempList.get(index))) {
				count++;
			}
			index++;
		}

		return count;
	}
}
