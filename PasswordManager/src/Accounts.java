
public class Accounts extends Manager {
	public static void strength() {
        String password;
        System.out.println("Create a Password (at least 8 characters");
        password = myScan.next();
        
        if (password.length() <= 8) {
        	System.out.println("Password is Too Short");
        } else {
        	if (isStrong(password)) {
        		System.out.println("Very Strong");
        	} else System.out.print("Weak");
        }	
        
    }
	private static boolean isStrong(String password){
	    return password.matches("^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]");

	  }
}
