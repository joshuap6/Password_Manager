
public class Password extends Accounts {
	
	private static String password;
	
	public Password() {
		Password.create();
	}
	public static String create() {
        System.out.println("Create a Password (at least 8 characters");
        password = myScan.next();
        return password;
	}
	
	public static void strength(final String password) {
        while (password.length() < 8) {
        	System.out.println("Password is Too Short. Please Try Again.");
        	create();
        } if (isVeryStrong(password)) {
        		System.out.println("Very Strong");
        	} else if (isStrong(password)) {
        		System.out.println("Strong");
        	} else if (isMedium(password)) {
        		System.out.println("Medium");
        	} else System.out.print("Weak");
    }
	
	private static boolean isVeryStrong(String password) {
	    return password.matches("^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]");
	  } private static boolean isStrong(String password) {
	    return password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z]");
	  } private static boolean isMedium(String password) {
	    return password.matches("^(?=.*[A-Z] || ?=.*[0-9])(?=.*[a-z]");
	  }
	
	  public String getPassword() {
		  return Password.password;
	  }
}
