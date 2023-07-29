package ie.tus;

public class User {

	// user object to hold the users information

	private String name, emailAddress, password;

	public User(String name, String password, String emailAddress) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getObscuredPassword() {
		return (firstLetter(password) + "..." + lastLetter(password));
	}

	public String register2() {
		return ("show-registration");
	}

	private String firstLetter(String s) {
		return (s.substring(0, 1));
	}

	private String lastLetter(String s) {
		int length = s.length();
		return (s.substring(length - 1, length));
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (other.getClass() != this.getClass()) {
			return false;
		}
		final User otherUser = (User) other;
		
		return this.name.equals(otherUser.name) && 
			   this.emailAddress.equals(otherUser.emailAddress) && 
			   this.password.equals(otherUser.password);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", emailAddress=" + emailAddress + ", password=" + password + "]";
	}
	
	

}
