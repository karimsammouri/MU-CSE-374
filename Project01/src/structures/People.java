package structures;

/**
 * This defines the People interface.
 * @author Karim Sammouri
 *
 */
public interface People {
	
	/**
	 * Tells whether a person has COVID.
	 * @return True if person has COVID and false otherwise.
	 */
	public boolean hasCovid();
	
	/**
	 * Gives a person COVID.
	 */
	public void getsCovid();
	
	/**
	 * Tells a person's group number.
	 * @return A group number.
	 */
	public int getGroupNumber();
}
