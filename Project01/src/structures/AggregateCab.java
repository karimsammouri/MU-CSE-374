package structures;

/**
 * This implements the AggregateCab as per the instructions.
 * @author Karim Sammouri
 */

public class AggregateCab implements Cab {
	private int seats;
	private int passengers;
	
	/**
	 * Constructor
	 * @param seats Number of car seats.
	 */
	public AggregateCab(int seats) {
		this.seats = seats;
		passengers = 0;
	}

	@Override
	public boolean isFull() {
		return passengers == seats;
	}

	@Override
	public boolean addPassenger(People p) {
		if (isFull()) {
			return false;
		}
		passengers++;
		return true;
	}

	@Override
	public int getSize() {
		return passengers;
	}
}
