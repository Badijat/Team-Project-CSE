package ie.tus;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Room {

	private int roomId;
    private String roomName;
    private int price;
    private int occupancy;
    private Hotel parentHotel;

    public enum Availablity {
        AVAILABLE,
        NEEDS_CLEANING,
        BOOKED;
    }
    // Date used to start the index for the availability array
    // ie. the availability at index 0 is "2023-01-01" and the availability at index 1 is "2023-01-02"
    private final LocalDate startDate = LocalDate.parse("2023-01-01");
    private Availablity[] availability;

    public Room() {
		this.roomId = -1;
		this.roomName = "";
		this.price = -1;
		this.occupancy = -1;
		this.parentHotel = null;
        this.availability = new Availablity[365];
	}
    
    public Room(int roomId, String roomName, int price, int occupancy, Hotel parentHotel, Availablity[] availability) {
		this.roomId = roomId;
		this.roomName = roomName;
		this.price = price;
		this.occupancy = occupancy;
		this.parentHotel = parentHotel;
        this.availability = availability;
	}
    
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOccupancy() {
		return occupancy;
	}
	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}
	public Hotel getParentHotel() {
		return parentHotel;
	}
	public void setParentHotel(Hotel parentHotel) {
		this.parentHotel = parentHotel;
	}
    public Availablity[] getAvailability() {
        return availability;
    }
    public void setAvailability(Availablity[] availability) {
        this.availability = availability;
    }
    
    // Given an array of days to book, check if all the days are available and mark them as booked
    public boolean bookDays(String[] bookDays) {
        int[] daysToBook = new int[bookDays.length];

        // Convert to indexs so we can check if the day is available
        for(int i = 0; i < bookDays.length; i++) {
            daysToBook[i] = (int) startDate.until(LocalDate.parse(bookDays[i]), ChronoUnit.DAYS);
        }

        // Check if all the days are available
        for (int day : daysToBook) {
            if(availability[day] != Availablity.AVAILABLE) {
                return false;
            }
        }

        // Mark the days as booked
        for (int day : daysToBook) {
            availability[day] = Availablity.BOOKED;
        }
        return true;
    }
}
