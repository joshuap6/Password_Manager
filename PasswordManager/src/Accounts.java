
public class Accounts extends Manager {
	
	private String name;
	
	private String username;
	
	private Password password;
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setUsername(String newUser) {
		this.username = newUser;
	}
	
	public void setPassword(Password newPass) {
		this.password = newPass;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getUsername() {
		return this.username;
	}

	
	public Password getPassword() {
		return this.password;
	}
}
