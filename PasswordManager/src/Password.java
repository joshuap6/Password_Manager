
public class Password extends Accounts {
	
	private String password;
	
	public Password() {
		create();
	}
	public void create() {
        System.out.println("Create a Password (at least 8 characters)");
        password = myScan.next();
        strength(password);
	}
	
	public void strength(final String password) {
        if (password.length() < 8) {
        	System.out.println("Password is Too Short. Please Try Again.");
        	create();
        	return;
        } 
        if (isVeryStrong(password)) {
        	System.out.println("Your password is very strong.");
        	return;
        } else if (isStrong(password)) {
        	System.out.println("Your password is strong.");
        	return;
        } else if (isMedium(password)) {
        	System.out.println("Your password is average.");
        	return;
        } else {
        	System.out.println("Your password is weak.");
        	return;
        }
    }
	
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
	
	public String toString() {
		return password;
	}
	
	/*
	 * "(^(?=.*[A-Z] || ?=.*[0-9])(?=.*[a-z]))" med
	 * 
	 */
}
