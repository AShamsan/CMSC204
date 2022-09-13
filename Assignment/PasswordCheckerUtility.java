import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Abdullah Shamsan
 *
 */

public class PasswordCheckerUtility {


	/**
	 * 
	 * @param password
	 * @return
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,
			NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {

		if (isValidLength(password)) //Checks the length first
		{
			return hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) 
					&& hasSpecialChar(password) && NoSameCharInSequence(password); // Return true if the password is valid
				
		}
		return false;
	}

	
	/**
	 * 
	 * @param password
	 * @return
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		
		if(password.length() <= 9 && password.length() >= 6)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param password
	 * @return
	 * @throws WeakPasswordException
	 */
	static boolean isWeakPassword(String password) throws WeakPasswordException
	{
		try
		{
			if (!(hasBetweenSixAndNineChars(password)) && isValidPassword(password)) //Checks if the password is not valid and not between 6 and 9 inclusively
				return false;
		}
		catch (Exception e)
		{
			throw new WeakPasswordException();
		}
		throw new WeakPasswordException();
	}


	
	/**
	 * 
	 * @param password
	 * @return
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> password) {
		
			ArrayList<String> invalidPassword = new ArrayList<String>();
			
			for (String temp : password) { //Checks every password in the ArrayList
			try{
				isValidPassword(temp);
				}
			
			catch( Exception e) {
				invalidPassword.add(temp + " -> " + e.getMessage());
			}
		}
		return invalidPassword;
	}
	
	
	
	/**
	 * 
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{

		if (!(password.equals(passwordConfirm))) //Checks if the password and it confirm does not match
		{
			throw new UnmatchedException();
		}
		
	}
	
	
	
	/**
	 * 
	 * @param password
	 * @param passwordConfirm
	 * @return
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm){
		
		if (password.equals(passwordConfirm)) //Checks if the password and it confirm match
		{
				return true;
		}
		
		return false;
	}
	
	
	
	
	/**
	 * 
	 * @param password
	 * @return
	 * @throws LengthException
	 */
	public static boolean isValidLength(String password) throws LengthException {
		if (password.length() < 6) { // Checks that the password is less than 6 characters
			throw new LengthException();
		}
		return true;

	}
	
	
	/**
	 * 
	 * @param password
	 * @return
	 * @throws NoDigitException
	 */
	static boolean hasDigit(String password) throws NoDigitException
	{
		String[] temp = password.split("");
        for (String s : temp) //Checks every password in the ArrayList 
        	
		if (s.matches(".*\\d.*")) // Checks that the password has a digit
		{
			return true;
		}
        throw new NoDigitException();
	}

	
	/**
	 * 
	 * @param password
	 * @return
	 * @throws NoLowerAlphaException
	 */
    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
    {
    	String[] temp = password.split("");
        for (String s : temp) //Checks every password in the ArrayList 
        	
            if (s.matches("[a-z]"))  // Checks that the password has a lower case letter
            {
                return true;
            }
        
        throw new NoLowerAlphaException();

    }

    
    /**
     * 
     * @param password
     * @return
     * @throws NoSpecialCharacterException
     */
    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException
    {
        String[] temp = password.split("");
        for (String s : temp)  //Checks every password in the ArrayList 
        {
            if (s.matches("[^\\w]")) // Checks that the password has a special character
            {
                return true;
            }
        }
        throw new NoSpecialCharacterException();

    }

    
    /**
     * 
     * @param password
     * @return
     * @throws NoUpperAlphaException
     */
    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
    {
        String[] temp = password.split("");  //Checks every password in the ArrayList 
        for (String s : temp)
        {
            if (s.matches("[A-Z]")) // Checks that the password has an upper case letter
            {
                return true;
            }
        }
        throw new NoUpperAlphaException();

    }


    /**
     * 
     * @param password
     * @return
     * @throws InvalidSequenceException
     */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException
	{
		for (int i = 0; i < password.length(); i++)
		{
			if (password.charAt(i+1) == password.charAt(i)) // Checks if a two characters are the same in a sequence
				throw new InvalidSequenceException();
		}
		return true;
	}

}