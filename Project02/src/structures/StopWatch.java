package structures;

/**
 * This implements the StopWatch class as per the book and specifications.
 * @author Karim Sammouri
 */
public class StopWatch {
	private final long start;
	
	/**
	 * Constructor
	 */
	public StopWatch() {
		start = System.currentTimeMillis();
	}
	
	/**
	 * Returns the time elapsed from when the StopWatch object was initialized until this method's invocation.
	 * @return Time elapsed from when the StopWatch object was initialized until this method's invocation.
	 */
	public double elapsedTime() {
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}
}
