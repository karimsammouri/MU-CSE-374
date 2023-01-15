package structures;

/**
 * This implements the Individuals class as per the instructions.
 * @author Karim Sammouri
 */
public class IndividualsCab implements Cab {
	private People[] passengers;
	private int size;
	
	/**
	 * Constructor
	 * @param seats Number of car seats.
	 */
	public IndividualsCab(int seats) {
		passengers = new People[seats];
		size = 0;
	}

	@Override
	public boolean isFull() {
		return size == passengers.length;
	}

	@Override
	public boolean addPassenger(People p) {
		if (isFull()) {
			return false;
		}
		passengers[size] = p;
		size++;
		return true;
	}

	@Override
	public int getSize() {
		return size;
	}
}
