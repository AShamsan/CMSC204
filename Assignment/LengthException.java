

/**
 * This Exception is thrown if the length of password is less than 6 characters.
 * 
 * @author Abdullah Shamsan
 *
 */
public class LengthException extends Exception {
	public LengthException() {
		super("The password must be at least 6 characters long");
	}
}