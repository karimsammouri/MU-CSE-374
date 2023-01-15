package structures;

/**
 * This implements the BaggyCab as per the instructions.
 * @author Karim Sammouri
 */

public class BaggyCab implements Cab {
	private ConstrainedCapacityBag<People> passengers;
	private int size;
	
	/**
	 * Constructor
	 * @param seats Number of car seats.
	 */
	public BaggyCab(int seats) {
		passengers = new ConstrainedCapacityBag<People>(seats);
	}

	@Override
	public boolean isFull() {
		return size == passengers.getCapacity();
	}

	@Override
	public boolean addPassenger(People p) {
		if (isFull()) {
			return false;
		}
		passengers.add(p);
		size++;
		return true;
	}

	@Override
	public int getSize() {
		return size;
	}

}
