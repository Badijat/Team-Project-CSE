package ie.tus.Hotel;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {
    
	private String name;
    private ArrayList<Room> rooms;
    private ArrayList<Staff> staff;
    
    public Hotel() {
		this.name = "";
		this.rooms = new ArrayList<Room>();
		this.staff = new ArrayList<Staff>();
	}
    
    public Hotel(String name, ArrayList<Room> rooms, ArrayList<Staff> staff) {
		this.name = name;
		this.rooms = rooms;
		this.staff = staff;
	}
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	public ArrayList<Staff> getStaff() {
		return staff;
	}
	public void setStaff(ArrayList<Staff> staff) {
		this.staff = staff;
	}
	public ArrayList<Room> getAvailableRooms(String date) {
		return getAvailableRooms(LocalDate.parse(date));
	}
	public ArrayList<Room> getAvailableRooms(LocalDate date) {
		ArrayList<Room> availableRooms = new ArrayList<Room>();
        for (Room room : rooms) {
            if (room.isRoomAvailable(date)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
	}

	public boolean isRoomTypesAvailable(String startDate, String endDate, int numGuests, RoomType roomType) {
		for(Room room : rooms) {
			if(room.getRoomType().equals(roomType) && room.isAvailabilityForDates(startDate, endDate)) {
				if(numGuests > roomType.getOccupancy()) {
					numGuests -= roomType.getOccupancy();
				} else {
					return true;
				}
			}
		}
		return false;
	}

	public boolean BookRooms(String startDate, String endDate, int numGuests, RoomType roomType) {
		for(Room room : rooms) {
			if(room.getRoomType().equals(roomType) && room.isAvailabilityForDates(startDate, endDate)) {
				room.bookRoomForDates(startDate, endDate);
				if(numGuests > roomType.getOccupancy()) {
					numGuests -= roomType.getOccupancy();
				} else {
					return true;
				}
			}
		}
		return false;
	}

}
