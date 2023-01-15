package structures;

/**
 * This implements the Greyhound class as per the instructions.
 * @author Karim Sammouri
 */
public class Greyhound implements Cab {
	private int seats;
	public People[][] passengers;
	private int size;
	
	/**
	 * Constructor
	 * @param seats Number of car seats.
	 */
	public Greyhound(int seats) {
		// Creates three dimensional array representing Greyhound with at least the required number of seats.
		passengers = new People[seats % 4 == 0? seats / 4 : (seats / 4) + 1][4];
		// Readjusts seats variable with actual number of seats including any leftover seats in contrast to just given input.
		if (seats % 4 == 0) {
			this.seats = seats;
		} else {
			this.seats = ((passengers.length - 1) * 4) + (passengers[passengers.length - 1].length);
		}
		size = 0;
	}

	@Override
	public boolean isFull() {
		return size == seats;
	}

	@Override
	public boolean addPassenger(People p) {
		if (isFull()) {
			return false;
		}
		passengers[size / 4][size % 4] = p;
		if (p.hasCovid() && size > 0) {
			System.out.println("wow");
			if ((size % 2 == 1) && (passengers[size / 4][(size - 1) % 4] != null)) {
				passengers[size / 4][(size - 1) % 4].getsCovid();
			} else if ((size % 2 == 0) && (passengers[size / 4][(size + 1) % 4] != null)) {
				passengers[size / 4][(size + 1) % 4].getsCovid();
			}
		}
		size++;
		return true;
	}

	@Override
	public int getSize() {
		return size;
	}
}
