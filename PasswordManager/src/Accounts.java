
public class Accounts extends Manager {
	
	/**
	 * Name of the account. 
	 * Differs from username in that the there can only be one instance with this name.
	 * This name is also used to identify the account.
	 */
	private String name;
	
	/**
	 * The username that is used for the account. Can be the same as the account name.
	 */
	private String username;
	
	/**
	 * The password for the account.
	 * <br>
	 * The password has four levels of safety:<br>
	 * - Very Strong: the password contains a special character, a capital letter, and a number<br>
	 * - Strong: the password contains either a special character or both a capital letter and a number<br>
	 * - Average: the password contains either a capital letter or a number<br>
	 * - Weak: the password is just lower case letters<br>
	 */
	private Password password;
	
	/**
	 * Contains the name, username, and password of the account.
	 */
	public Accounts() {
	}
	
	/**
	 * Sets the name of the account.
	 * @param newName The new name for the account.
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
	/**
	 * Sets the username for the account.
	 * @param newUser The new username for the account.
	 */
	public void setUsername(String newUser) {
		this.username = newUser;
	}
	
	/**
	 * Sets the password for the account.
	 * @param newPass The new password for the account.
	 */
	public void setPassword(Password newPass) {
		this.password = newPass;
	}
	
	/**
	 * Returns the name of the account.
	 * @return The name of the account.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns the username for the account.
	 * @return The username for the account.
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Returns the password for the account.
	 * @return The password for the account.
	 */
	public Password getPassword() {
		return this.password;
	}
}
