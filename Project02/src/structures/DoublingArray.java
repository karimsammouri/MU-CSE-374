package structures;

/**
 * This implements the DoublingArray class as per the specifications.
 * @author Karim Sammouri
 * @param <E> Generic type.
 */
public class DoublingArray<E> implements RemovalArray<E> {
	public Object array[];
	public int size;
	
	/**
	 * Default Constructor
	 */
	public DoublingArray() {
		this(0);
	}
	
	/**
	 * Full Constructor
	 * @param capacity Initial length or capacity of the array.
	 */
	public DoublingArray(int capacity) {
		array = new Object[capacity];
		size = 0;
	}

	@Override
	public boolean add(E e) {
		// Create new bigger array if array is full, otherwise proceed to add element in next available index.
		if (size == array.length) {
			Object tempArray[];
			// Double array size if array length is greater than 0. If array size is 0 to begin with, create array of size 1 (latter is necessary to ensure array of size 0 can be doubled eventually (0 * 2 = 0)).
			if (array.length > 0) {
				tempArray = new Object[array.length * 2];
			} else {
				tempArray = new Object[1];
			}
			for (int i = 0; i < array.length; i++) {
				tempArray[i] = array[i];
			}
			array = tempArray;
		}
		array[size] = e;
		size++;
		return true;
	}

	@Override
	public boolean remove(int index) {
		if (index >= 0 && index < size) {
			// Creates new array with one less unit of space then copies elements, excluding element to be removed, over, ensuring there are no gaps or null values.
			Object tempArray[] = new Object[array.length - 1];
			for (int i = 0; i < index; i++) {
				tempArray[i] = array[i];
			}
			for (int i = index + 1; i < array.length; i++) {
				tempArray[i - 1] = array[i];
			}
			array = tempArray;
			size--;
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(E e) {
		return remove(contains(e));
	}

	/**
	 * Returns the index where the first occurrence of the given object was found.
	 * @param e Object whose first occurence's index is to be found.
	 * @return Index where the first occurrence of the given object was found.
	 */
	public int contains(E e) {
		for (int i = 0; i < array.length; i++) {
			if (e.equals(array[i])) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Returns a string representation of the array.
	 * @return String representation of the array.
	 */
	public String toString() {
		String result = "";
		for (Object x: array) {
			result += x + " ";
		}
		return "[" + result.trim() + "]";
	}
}
