package structures;

/**
 * This defines the RemovalArray ADT as per the specifications.
 * @author Karim Sammouri
 * @param <E> Generic type.
 */
public interface RemovalArray<E> {
	
	/**
	 * Adds an object to the array.
	 * @param e Object to be added.
	 * @return True if add is successful and false otherwise.
	 */
	public boolean add(E e);
	
	/**
	 * Removes an object at a given index from the array.
	 * @param index Index of the element to be removed.
	 * @return True if successful and false otherwise.
	 */
	public boolean remove(int index);
	
	/**
	 * Removes the first occurrence of a given object from the array.
	 * @param e Object to be removed.
	 * @return True if successful and false otherwise.
	 */
	public boolean remove(E e);
}
