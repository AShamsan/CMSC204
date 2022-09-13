

/**
 * This Exception is thrown if the password doesn’t contain an uppercase alpha character 
 * 
 * @author Abdullah Shamsan
 *
 */
public class NoUpperAlphaException extends Exception {
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}
}