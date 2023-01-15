package structures;

/**
 * This implements the SwappyArray class as per the specifications.
 * @author Karim Sammouri
 * @param <E> Generic type.
 */
public class SwappyArray<E> implements RemovalArray<E> {
	public Object array[];
	public int size;
	
	/**
	 * Default Constructor
	 */
	public SwappyArray() {
		this(0);
	}
	
	/**
	 * Full Constructor
	 * @param capacity Initial length or capacity of the array.
	 */
	public SwappyArray(int capacity) {
		array = new Object[capacity];
		size = 0;
	}
	
	@Override
	public boolean add(E e) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean remove(int index) {
		if (index >= 0 && index < size) {
			array[index] = array[size - 1];
			array[size - 1] = null;
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
