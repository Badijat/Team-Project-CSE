package ie.tus;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Confirmation {
	private boolean isChecked;
	private String error;
	
	@PostConstruct
	public void init() {
		isChecked = false;
		error = "";
	}
	public boolean getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
	public String confrimBooking() {
		if(isChecked) {
			return "registration1.xhtml";
		}else {
			error = "Please confirm that the details are correct.";
			return null;
		}
		
	}
	
	public String back() {
		return "room availability.xhtml";
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
