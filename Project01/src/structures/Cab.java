package structures;

/**
 * This defines the Cab interface.
 * @author Karim Sammouri
 */

public interface Cab {
	
	/**
	 * Tells whether a cab is full.
	 * @return True if the cab is full and false otherwise.
	 */
	public boolean isFull();
	
	/**
	 * Adds a passenger to the cab.
	 * @param p Passenger to be added.
	 * @return True if the addition was successful and falsa otherwise.
	 */
	public boolean addPassenger(People p);
	
	/**
	 * Returns the size capacity of the cab.
	 * @return Capacity of the cab.
	 */
	public int getSize();
}
