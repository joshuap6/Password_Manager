import java.util.Scanner;

public class Manager {
	/**
	 * Scanner to be used throughout whole program.
	 */
	protected static Scanner myScan;
	
	/**
	 * Empty list of accounts that will get eventually filled.
	 */
	private static Accounts[] accountList = new Accounts[50];
	
	/**
	 * Index of the next empty spot in the array.
	 */
	private static int accountCount = 0;
	
	public static void main(String[] args) {
		myScan = new Scanner(System.in);
		boolean isRunning = true; //Program is running
		while (isRunning) {
			int run = 0; //counter so first String prints only once
			intro(); //main menu
			while (!myScan.hasNextInt()) { //make sure only integers are used
				System.out.println("Please enter an integer.\n");
				intro();
				myScan.next();
			}
			int input = myScan.nextInt();
			while (true) {
				if (input == 1) { //Create a new account
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
						System.out.println("Would you like to keep your password? (Y/N)");
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
				} else if (input == 2) { //Retrieve an account
					if (accountList[0] == null) { //Check if accounts have been made, break if not
						System.out.println("You have not make any accounts yet.\n");
						break;
					}
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
						System.out.println("Account Name: " + inAccount.getName());
						System.out.println("Username: " + inAccount.getUsername());
						System.out.println("Password: " + inAccount.getPassword() + "\n");
						run = 0;
						break;
					}
				} else if (input == 3) { //List the accounts that have been created
					listOfAccounts();
					if (accountList[0] == null) { //Check if accounts have been made, break if not
						System.out.println("You have not made any accounts yet.\n");
					}
					break;
				} else if (input == 4) { //Delete one of the accounts from the list
					if (accountList[0] == null) { //Check if accounts have been made, break if not
						System.out.println("You have not make any accounts yet.\n");
						break;
					}
					System.out.println("Pick from list of accounts or type \"0\" to exit:");
					listOfAccounts();
					int index = 0;
					boolean gettingIndex = true; 
					while (gettingIndex) { //Loop for making sure index is correct
						while (!myScan.hasNextInt()) { //make sure only integers are used
							System.out.println("Please enter an integer.\n");
							myScan.next();
						}
						int newInput = myScan.nextInt();
						while (true) {
							if (newInput < 0 || newInput > accountCount) { //If input is higher than highest account # or is less than 0
								System.out.println("That account doesn't exist.");
								System.out.println("Enter a different number or type \"0\" to exit.");
								break; //Break inner loop to get a new input
							} else if (newInput == 0) {
								index = -1; //Set index so it'll skip deletion
								gettingIndex = false; //Break out of outer loop and go back to main menu
								break; //Break inner loop completely
							} else { //Valid input
								index = newInput - 1; //Index of account starts at 0 instead of 1 so index is one less than input
								gettingIndex = false; //Break out of outer loop and go back to main menu
								break; //Break inner loop completely
							}
						}
					}
					if (index == -1) { //Go back to main menu
						break;
					}
					deleteAccount(index);
					System.out.println("Account #" + (index + 1) + " has been deleted.\n");
					break;
				} else if (input > 5 || input < 1) { //Input is not 1, 2, 3, 4, or 5
					System.out.println("Please input a valid integer");
					System.out.println();
					break;				
				} else { //Input is 5
					isRunning = false; //Exit program
					break;
				}
			}			
		}
		myScan.close(); //Close scanner
	}

	/**
	 * Deletes an account at the index and moves rest of the array up to the index.<br>
	 * Sets the account counter back one so the counter will be on the first empty spot in the array again.<br>
	 * 
	 * @param index Index on the account on the array to be deleted.
	 */
	private static void deleteAccount(int index) {
		for (int i = index; i < accountList.length; i++) {
			accountList[i] = accountList[i + 1]; //Either moves the accounts up the list to cover up the account at the index or points it to a null
			if (accountList[i + 1] == null) { //End of list of accounts
				accountCount = i; //Resets counter to point to next empty spot on array
				break;
			}
		}
		
	}

	/**
	 * Prints out the list of accounts that have been created so far.
	 */
	private static void listOfAccounts() {
		for (int i = 0; i < accountList.length; i++) { //Goes through the list of accounts
			if (accountList[i] == null) { //If the account is null, that's the end of the list of accounts
				System.out.println();
				return;
			}
			System.out.println("[" + (i + 1) + "] " + accountList[i].getName()); //Prints account # and name of the account
		}
	}

	/**
	 * Checks if the name of the account isn't already being used. <br>
	 * Also makes sure the input isn't empty.
	 * 
	 * @param newName Name of the account that is being created.
	 * @return true if the name is unique, false if the name exists.
	 */
	private static boolean validName(String newName) {
		if (newName.length() == 0) {
			return false;
		}
		for (int i = 0; i < accountList.length; i++) {
			if (accountList[i] == null) { //There is no account that has been created that has the same name.
				return true;
			}
			if (accountList[i].getName().toLowerCase().equals(newName.toLowerCase())) { //Check if the names match (case-sensitive)
				return false;
			}
		}
		return true;
	}

	/**
	 * Goes through the array and searches for the specified account.
	 * 
	 * @param accountName Name of the account that is being searched.
	 * @return the account if it exists, null if the account does not exist.
	 */
	public static Accounts getAccount(String accountName) {
		for (int i = 0; i < accountList.length; i++) {
			if (accountList[i] == null) { //There is no account that has been created that has the same name
				return null;
			}
			if (accountList[i].getName().toLowerCase().equals(accountName.toLowerCase())) { //Check if the account names match (case-sensitive)
				return accountList[i];
			}
		}
		return null;
	}
	
	/**
	 * Prints out the main menu of options.
	 */
	private static void intro() {
		System.out.println("What would you like to do?");
		System.out.println("[1] Store a new account");
		System.out.println("[2] Retrieve an account");
		System.out.println("[3] Show list of accounts");
		System.out.println("[4] Delete an account");
		System.out.println("[5] Exit program");
	}
}