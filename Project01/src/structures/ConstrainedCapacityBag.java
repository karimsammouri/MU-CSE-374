package structures;

import java.util.Iterator;

/**
 * This implements the ConstrainedCapacityBag as per the instructions.
 * @author Karim Sammouri
 * @param <Item> Type of elements,
 */
public class ConstrainedCapacityBag<Item> implements Iterable<Item> {
	private Node first;
	private int capacity;

	/**
	 * Constructor
	 * @param capacity Capacity of the bag.
	 */
	public ConstrainedCapacityBag(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Adds an element to the bag and readjusts the LinkedList accordingly.
	 * @param item Item to be added.
	 */
	public void add(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.setItem(item);
		first.setNext(oldfirst);
	}

	/**
	 * Returns the capacity of the bag.
	 * @return Capacity of the bag.
	 */
	public int getCapacity() {
		return capacity;
	}

	private class Node {
		private Item item;
		private Node next;
		public void setItem(Item item) {
			this.item = item;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}
