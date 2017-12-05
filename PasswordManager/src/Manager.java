import java.util.Scanner;

public class Manager {
	static Scanner myScan;
	
	static Accounts[] accountList = new Accounts[50];
	
	public static void main(String[] args) {
		accountList[0] = new Accounts();
		accountList[0].setName("Joey");
		accountList[0].setUsername("Joey's Account");
		myScan = new Scanner(System.in);
		boolean isRunning = true;
		int accountCount = 0;
		while (isRunning) {
			int run = 0; //counter so intro String prints only once
			intro(); //main menu intro
			while (!myScan.hasNextInt()) { //make sure only integers are used
				System.out.println("Please enter an integer.");
				intro();
				myScan.nextLine();
			}
			int input = myScan.nextInt();
			while (true) {
				if (input == 1) { //Input is 1
					Accounts newAcc = new Accounts();
					System.out.println("Enter the name of the account: ");
					String newName = myScan.next();
					newAcc.setName(newName);
					System.out.println("Enter the username for the account: ");
					String newUser = myScan.next();
					newAcc.setUsername(newUser);
					Password newPass = new Password();
					newAcc.setPassword(newPass);
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
						run = 0; //Reset counter so first time can be printed again
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
				} else if (input > 3 || input < 1) { //Input is not 1, 2, or 3
					System.out.println("Please input a valid integer");
					input = myScan.nextInt();
				} else { //Input is 3
					isRunning = false;
					break;
				}
			}			
		}
		myScan.close();
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
		System.out.println("[3] Exit program.");
	}
}