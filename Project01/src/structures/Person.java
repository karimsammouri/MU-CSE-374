package structures;

/**
 * This implements the Person class.
 * @author Karim Sammouri
 */

public class Person implements People {
	private String name;
	private int groupNumber;
	private boolean infected;

	/**
	 * Constructor
	 * @param name Name of the person.
	 */
	public Person(String name) {
		this.name = name;
		this.groupNumber = -1;
		infected = 1 + (int)(Math.random() * 100) <= 10 ? true : false;
	}
	
	/**
	 * Workhorse constructor
	 * @param name Name of the person.
	 * @param groupNumber Number of the group.
	 */
	public Person(String name, int groupNumber) {
		this.name = name;
		this.groupNumber = groupNumber;
		infected = 1 + (int)(Math.random() * 100) <= 10 ? true : false;
	}
	
	/**
	 * Prints the name of the person.
	 */
	public String toString() {
		return name;
	}

	@Override
	public boolean hasCovid() {
		return infected;
	}

	@Override
	public void getsCovid() {
		infected = true;
	}
	
	@Override
	public int getGroupNumber() {
		return groupNumber;
	}
}
