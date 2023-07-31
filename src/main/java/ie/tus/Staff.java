package ie.tus;

public class Staff {
    private int customerId;
	private String name;
    private String email;    
    private String password;
	private Hotel placeOfWork;
    public Staff() {
		this.customerId = -1;
		this.name = "";
		this.email = "";
		this.password = "";
        this.placeOfWork = null;
	}
	public Staff(int customerId, String name, String email,
			String password, Hotel placeOfWork) {
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.placeOfWork = placeOfWork;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Staff deepCopy() {
		return new Staff(this.customerId, this.name, this.email,
			this.password, this.placeOfWork);
	}
}
