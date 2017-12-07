
public class Password extends Accounts {
	
	/**
	 * The actual string that contains the password.
	 */
	private String password;
	
	/**
	 * Creates a password from user input.
	 */
	public Password() {
		create();
	}
	
	/**
	 * Creates the password.
	 */
	public void create() {
        System.out.println("Create a Password (at least 8 characters)");
        password = myScan.next();
        strength(password);
	}
	
	/**
	 * Makes sure the length of the password is long enough.
	 * <br>
	 * Also tests the strength of the password.<br>
	 * The password has four levels of safety:<br>
	 * - Very Strong: the password contains a special character, a capital letter, and a number<br>
	 * - Strong: the password contains either a special character or both a capital letter and a number<br>
	 * - Average: the password contains either a capital letter or a number<br>
	 * - Weak: the password is just lower case letters<br>
	 * 
	 * @param password The string that is trying to become the password.
	 */
	public void strength(final String password) {
        if (password.length() < 8) { //Checks if the password is at least 8 characters long
        	System.out.println("Password is Too Short. Please Try Again.");
        	create(); //Indirect recursive call to get another input from the user.
        	return;
        } 
        if (isVeryStrong(password)) { //If isVeryStrong method passes
        	System.out.println("Your password is very strong.");
        	return;
        } else if (isStrong(password)) { //If isStrong method passes
        	System.out.println("Your password is strong.");
        	return;
        } else if (isMedium(password)) { //If isMedium method passes
        	System.out.println("Your password is average.");
        	return;
        } else { //If none of the tests pass, the password is weak
        	System.out.println("Your password is weak.");
        	return;
        }
    }
	/**
	 * Tests the strength of the password.
	 * <br>
	 * Password must include these things in order to pass:<br>
	 * - have at least 1 special character<br>
	 * - have at least 1 capital letter<br>
	 * - have at least 1 number<br>
	 * 
	 * @param password The string that is being tested.
	 * @return true if the string has requirements, false if the string does not.
	 */
	private static boolean isVeryStrong(String password) {
		boolean hasDigit = false;
		boolean hasCapital = false;
		boolean hasSpecial = false;
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if (Character.isUpperCase(c)) {
				hasCapital = true;
			}
			if (Character.isDigit(c)) {
				hasDigit = true;
			}
			if (!Character.isDigit(c) && !Character.isLetter(c) && !Character.isSpaceChar(c)) {
				hasSpecial = true;
			}
		}
		if (hasCapital && hasDigit && hasSpecial) {
			return true;
		}
	    return false;
	  } 
	
	/**
	 * Tests the strength of the password.
	 * <br>
	 * Password must include these things in order to pass: <br>
	 * - have at least 1 special character OR<br>
	 * - have at least 1 capital letter and at least 1 number <br>
	 * 
	 * @param password The string that is being tested.
	 * @return true if the string has requirements, false if the string does not.
	 */
	private static boolean isStrong(String password) {
		boolean hasDigit = false;
		boolean hasCapital = false;
		boolean hasSpecial = false;
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if (Character.isUpperCase(c)) {
				hasCapital = true;
			}
			if (Character.isDigit(c)) {
				hasDigit = true;
			}
			if (!Character.isDigit(c) && !Character.isLetter(c) && !Character.isSpaceChar(c)) {
				hasSpecial = true;
			}
		}
		if ((hasCapital && hasDigit) || hasSpecial) {
			return true;
		}
	    return false;
	  }
	
	/**
	 * Tests the strength of the password.
	 * <br>
	 * Password must include these things in order to pass: <br>
	 * - have at least 1 capital letter OR<br>
	 * - have at least 1 number <br>
	 * 
	 * @param password The string that is being tested.
	 * @return true if the string has requirements, false if the string does not.
	 */
	private static boolean isMedium(String password) {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				return true;
			}
			if (Character.isDigit(password.charAt(i))) {
				return true;
			}
		}
	    return false;
	    }
	
	/**
	 * Returns the password when called directly by name.
	 */
	public String toString() {
		return password;
	}
}
