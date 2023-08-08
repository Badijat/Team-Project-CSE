package ie.tus;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class AvailabilityBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date checkInDate;
    private Date checkOutDate;
    private int numGuests;
    private String roomType;
    private List<Room> availableRooms;
    private User LoggedInUser;

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public List<Room> getAvailableRooms() {
        return availableRooms;
    }

    public String checkAvailability() {

        availableRooms = new ArrayList<>();
        availableRooms.add(new Room("Standard Room", 100.0, true));
        availableRooms.add(new Room("Deluxe Room", 150.0, true));
        availableRooms.add(new Room("Suite", 250.0, false));
        return null;
    }

    // Inner class to represent a hotel room
    public static class Room {
        private String roomType;
        private double price;
        private boolean available;

        public Room(String roomType, double price, boolean available) {
            this.roomType = roomType;
            this.price = price;
            this.available = available;
        }


    }

	public User getLoggedInUser() {
		return LoggedInUser;
	}

	public void setLoggedInUser(User loggedInUser) {
		LoggedInUser = loggedInUser;
	}
}
