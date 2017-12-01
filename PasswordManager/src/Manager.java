import java.util.Scanner;

public class Manager {
	static Scanner myScan;
	
	static Accounts[] accountList = new Accounts[50];
	
	public static void main(String[] args) {
		myScan = new Scanner(System.in);
		System.out.println("What would you like to do?");
		System.out.println("[1] Store a new account");
		System.out.println("[2] Retrieve an account");
		System.out.println("[3] Exit program.");
		int input = myScan.nextInt();
		boolean isRunning = true;
		while (isRunning == true) {
			if (input == 1) {
				
			} else if (input == 2) {
				System.out.println("Enter the name of the account:");
				String inName = myScan.next();
				Accounts inAccount = getAccount(inName);
				if (inAccount == null) {
					System.out.println("Sorry, that account was not found.");
					System.out.println("Press enter to exit");
				}
			} else if (input > 3 || input < 1) {
				System.out.println("Please input a valid integer");
				input = myScan.nextInt();
			} else {
				isRunning = false;
			}
		}
		myScan.close();
	}
	
	public static Accounts getAccount(String accountName) {
		for (int i = 0; i < accountList.length; i++) {
			if (accountList[i] == null) {
				return null;
			}
			if (accountList[i].getName() == accountName) {
				return accountList[i];
			}
		}
		return null;
	}
}