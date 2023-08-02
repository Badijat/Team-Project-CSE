package ie.tus.Hotel;

public class Staff {
    private int staffId;
	private String name;
    private String email;    
    private String password;
	private Hotel placeOfWork;
    public Staff() {
		this.staffId = -1;
		this.name = "";
		this.email = "";
		this.password = "";
        this.placeOfWork = null;
	}
	public Staff(int staffId, String name,
			String password, String email, Hotel placeOfWork) {
		this.staffId = staffId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.placeOfWork = placeOfWork;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
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
	public Hotel getPlaceOfWork() {
		return placeOfWork;
	}
	public void setPlaceOfWork(Hotel placeOfWork) {
		this.placeOfWork = placeOfWork;
	}
	// public Staff deepCopy() {
	// 	return new Staff(this.staffId, this.name, this.email,
	// 		this.password, this.placeOfWork);
	// }
}
