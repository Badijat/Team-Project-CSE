package ie.tus;

public class User {	
	
	// user object to hold the users information

	private String name, emailAddress, password;

	public User(String name, String password, String email) {
		this.name = name;
		this.emailAddress = email;
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

}
