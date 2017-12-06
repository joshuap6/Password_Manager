import java.util.Scanner;

public class Manager {
	static Scanner myScan;
	
	static Accounts[] accountList = new Accounts[50];
	
	public static void main(String[] args) {
		myScan = new Scanner(System.in);
		boolean isRunning = true;
		int accountCount = 0;
		while (isRunning) {
			int run = 0; //counter so intro String prints only once
			intro(); //main menu intro
			while (!myScan.hasNextInt()) { //make sure only integers are used
				System.out.println("Please enter an integer.");
				System.out.println();
				intro();
				myScan.next();
			}
			int input = myScan.nextInt();
			while (true) {
				if (input == 1) { //Input is 1
					Accounts newAcc = new Accounts();
					System.out.println("Enter the name of the account: ");
					String newName = myScan.next();
					while (!validName(newName)) {
						System.out.println("An account with this name already exists.");
						System.out.println("Pick a different name.");
						newName = myScan.next();
					}
					newAcc.setName(newName);
					System.out.println("Enter the username for the account: ");
					String newUser = myScan.next();
					newAcc.setUsername(newUser);
					Password newPass = new Password();
					boolean passTest = true;
					while (passTest) {
						System.out.println("Would you like to keep your password? Y/N");
						String keepPass = myScan.next();
						while (true) {
							if (keepPass.toUpperCase().equals("Y")) {
								newAcc.setPassword(newPass);
								passTest = false;
								break;
							} else if (keepPass.toUpperCase().equals("N")) {
								newPass = new Password();
								break;
							} else {
								System.out.println("Please enter \"Y\" or \"N\".");
								keepPass = myScan.next();
							}
						}
					}
					accountList[accountCount] = newAcc;
					accountCount++;
					break;
				} else if (input == 2) { //Input is 2
					while (run == 0) {
						System.out.println("Enter the name of the account:");
						run++; //This line won't print again until this menu is exited and reentered
					}
					String inName = myScan.next(); //Get name of account
					if (inName.toLowerCase().equals("exit")) {//Exit from this menu
						run = 0; //Reset counter so first line can be printed again
						break;
					}
					Accounts inAccount = getAccount(inName); //Searches for account using account name
					if (inAccount == null) { //Account not found
						System.out.println("Sorry, that account was not found.");
						System.out.println("Please enter a different name or type \"exit\" to exit");
					} else { //Account is found
						System.out.println("The account name is: " + inAccount.getName());
						System.out.println("The username is: " + inAccount.getUsername());
						System.out.println("The passowrd is: " + inAccount.getPassword());
						System.out.println();
						run = 0;
						break;
					}
				} else if (input == 3) {
					for (int i = 0; i < accountList.length; i++) {
						if (accountList[i] == null) {
							System.out.println();
							break;
						}
						System.out.println("[" + (i + 1) + "] " + accountList[i].getName());
					}
					break;
				} else if (input > 4 || input < 1) { //Input is not 1, 2, 3, or 4
					System.out.println("Please input a valid integer");
					System.out.println();
					break;
					//input = myScan.nextInt();					
				} else { //Input is 4
					isRunning = false;
					break;
				}
			}			
		}
		myScan.close();
	}

	private static boolean validName(String newName) {
		for (int i = 0; i < accountList.length; i++) {
			if (accountList[i] == null) {
				return true;
			}
			if (accountList[i].getName().toLowerCase().equals(newName.toLowerCase())) {
				return false;
			}
		}
		return true;
	}

	public static Accounts getAccount(String accountName) {
		for (int i = 0; i < accountList.length; i++) {
			if (accountList[i] == null) {
				return null;
			}
			if (accountList[i].getName().toLowerCase().equals(accountName.toLowerCase())) {
				return accountList[i];
			}
		}
		return null;
	}
	
	private static void intro() {
		System.out.println("What would you like to do?");
		System.out.println("[1] Store a new account");
		System.out.println("[2] Retrieve an account");
		System.out.println("[3] Show list of accounts");
		System.out.println("[4] Exit program.");
	}
}