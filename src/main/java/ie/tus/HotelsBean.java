package ie.tus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ie.tus.Hotel.Hotel;
import ie.tus.Hotel.Room;
import ie.tus.Hotel.RoomType;
import ie.tus.Hotel.Staff;

@ManagedBean(name="HotelsBean")
@SessionScoped
public class HotelsBean {
	private Hotel BHD_Rose = new Hotel();
	private Hotel BHD_Mary = new Hotel();
	private Hotel BHD_Thyme = new Hotel();

	private String currentHotel;
	private Date checkInDate; // eg. "2023-01-01"
	private Date checkOutDate;
	
	private String checkInDateString; // eg. "2023-01-01"
	private String checkOutDateString;
	private int numGuests;
	private String roomName; // "Standard", "Double", "Executive", or "Suite"
	private String error;

	@PostConstruct
 	public void init() {
		System.out.println("Hotel init");

		BHD_Rose.setName("Boutique Hotels of Dublin - Rose");
		BHD_Mary.setName("Boutique Hotels of Dublin - Mary");
		BHD_Thyme.setName("Boutique Hotels of Dublin - Thyme");

		// Assign staff to all the hotels

		ArrayList<Staff> hotel_staff = new ArrayList<Staff>();
		hotel_staff.add(new Staff(1, "Esther Carbrey", "goodbuffalo63", "esther@gmail.com", BHD_Rose));
		hotel_staff.add(new Staff(2, "Christy Erna", "scaryskunk37", "christy@gmail.com", BHD_Rose));
		hotel_staff.add(new Staff(3, "Natasja Thorsten", "lazydoor40", "natasja@gmail.com", BHD_Rose));
		hotel_staff.add(new Staff(4, "Ann-Christine Maud", "murkymint90", "ann-christine@gmail.com", BHD_Rose));
		hotel_staff.add(new Staff(5, "Inga Liselotte", "lumpysneeze63", "inga@gmail.com", BHD_Rose));
		BHD_Rose.setStaff(hotel_staff);

		hotel_staff = new ArrayList<Staff>();
		hotel_staff.add(new Staff(1, "Jonna Magnus", "slowrabbit47", "jonna@gmail.com", BHD_Mary));
		hotel_staff.add(new Staff(2, "Damhnait Johannes", "jadebike83", "damhnait@gmail.com", BHD_Mary));
		hotel_staff.add(new Staff(3, "Gustav Jörgen", "oddangle73", "gustav@gmail.com", BHD_Mary));
		hotel_staff.add(new Staff(4, "Bernt Asløg", "paleyear84", "bernt@gmail.com", BHD_Mary));
		hotel_staff.add(new Staff(5, "Sture Julius", "paleyear84", "sture@gmail.com", BHD_Mary));
		BHD_Mary.setStaff(hotel_staff);

		hotel_staff = new ArrayList<Staff>();
		hotel_staff.add(new Staff(1, "Randi Nicklas", "luckysoup35", "randi@gmail.com", BHD_Thyme));
		hotel_staff.add(new Staff(2, "Christer Eleonora", "quietjam75", "christer@gmail.com", BHD_Thyme));
		hotel_staff.add(new Staff(3, "Tom Love", "freekey89", "tom@gmail.com", BHD_Thyme));
		hotel_staff.add(new Staff(4, "Vilma Thomas", "amberfish14", "vilma@gmail.com", BHD_Thyme));
		hotel_staff.add(new Staff(5, "Embla Loke", "tinykite57", "embla@gmail.com", BHD_Thyme));
		BHD_Thyme.setStaff(hotel_staff);

		// Assign rooms to all the hotels
		ArrayList<Room> hotel_rooms = new ArrayList<Room>();

		hotel_rooms.add(new Room(101, Room.standardRoom, BHD_Rose));
		hotel_rooms.add(new Room(102, Room.standardRoom, BHD_Rose));
		hotel_rooms.add(new Room(103, Room.standardRoom, BHD_Rose));
		hotel_rooms.add(new Room(104, Room.standardRoom, BHD_Rose));
		hotel_rooms.add(new Room(105, Room.standardRoom, BHD_Rose));

		hotel_rooms.add(new Room(201, Room.doubleRoom, BHD_Rose));
		hotel_rooms.add(new Room(202, Room.doubleRoom, BHD_Rose));
		hotel_rooms.add(new Room(203, Room.doubleRoom, BHD_Rose));
		hotel_rooms.add(new Room(204, Room.doubleRoom, BHD_Rose));
		hotel_rooms.add(new Room(205, Room.doubleRoom, BHD_Rose));

		hotel_rooms.add(new Room(301, Room.executiveRoom, BHD_Rose));
		hotel_rooms.add(new Room(302, Room.executiveRoom, BHD_Rose));
		hotel_rooms.add(new Room(303, Room.executiveRoom, BHD_Rose));
		hotel_rooms.add(new Room(304, Room.executiveRoom, BHD_Rose));
		hotel_rooms.add(new Room(305, Room.executiveRoom, BHD_Rose));

		hotel_rooms.add(new Room(301, Room.suiteRoom, BHD_Rose));
		hotel_rooms.add(new Room(302, Room.suiteRoom, BHD_Rose));
		hotel_rooms.add(new Room(303, Room.suiteRoom, BHD_Rose));
		hotel_rooms.add(new Room(304, Room.suiteRoom, BHD_Rose));
		hotel_rooms.add(new Room(305, Room.suiteRoom, BHD_Rose));
		BHD_Rose.setRooms(hotel_rooms);

		hotel_rooms = new ArrayList<Room>();
		hotel_rooms.add(new Room(101, Room.standardRoom, BHD_Mary));
		hotel_rooms.add(new Room(102, Room.standardRoom, BHD_Mary));
		hotel_rooms.add(new Room(103, Room.standardRoom, BHD_Mary));
		hotel_rooms.add(new Room(104, Room.standardRoom, BHD_Mary));
		hotel_rooms.add(new Room(105, Room.standardRoom, BHD_Mary));

		hotel_rooms.add(new Room(201, Room.doubleRoom, BHD_Mary));
		hotel_rooms.add(new Room(202, Room.doubleRoom, BHD_Mary));
		hotel_rooms.add(new Room(203, Room.doubleRoom, BHD_Mary));
		hotel_rooms.add(new Room(204, Room.doubleRoom, BHD_Mary));
		hotel_rooms.add(new Room(205, Room.doubleRoom, BHD_Mary));

		hotel_rooms.add(new Room(301, Room.executiveRoom, BHD_Mary));
		hotel_rooms.add(new Room(302, Room.executiveRoom, BHD_Mary));
		hotel_rooms.add(new Room(303, Room.executiveRoom, BHD_Mary));
		hotel_rooms.add(new Room(304, Room.executiveRoom, BHD_Mary));
		hotel_rooms.add(new Room(305, Room.executiveRoom, BHD_Mary));

		hotel_rooms.add(new Room(301, Room.suiteRoom, BHD_Mary));
		hotel_rooms.add(new Room(302, Room.suiteRoom, BHD_Mary));
		hotel_rooms.add(new Room(303, Room.suiteRoom, BHD_Mary));
		hotel_rooms.add(new Room(304, Room.suiteRoom, BHD_Mary));
		hotel_rooms.add(new Room(305, Room.suiteRoom, BHD_Mary));
		BHD_Mary.setRooms(hotel_rooms);

		hotel_rooms = new ArrayList<Room>();
		hotel_rooms.add(new Room(101, Room.standardRoom, BHD_Thyme));
		hotel_rooms.add(new Room(102, Room.standardRoom, BHD_Thyme));
		hotel_rooms.add(new Room(103, Room.standardRoom, BHD_Thyme));
		hotel_rooms.add(new Room(104, Room.standardRoom, BHD_Thyme));
		hotel_rooms.add(new Room(105, Room.standardRoom, BHD_Thyme));

		hotel_rooms.add(new Room(201, Room.doubleRoom, BHD_Thyme));
		hotel_rooms.add(new Room(202, Room.doubleRoom, BHD_Thyme));
		hotel_rooms.add(new Room(203, Room.doubleRoom, BHD_Thyme));
		hotel_rooms.add(new Room(204, Room.doubleRoom, BHD_Thyme));
		hotel_rooms.add(new Room(205, Room.doubleRoom, BHD_Thyme));

		hotel_rooms.add(new Room(301, Room.executiveRoom, BHD_Thyme));
		hotel_rooms.add(new Room(302, Room.executiveRoom, BHD_Thyme));
		hotel_rooms.add(new Room(303, Room.executiveRoom, BHD_Thyme));
		hotel_rooms.add(new Room(304, Room.executiveRoom, BHD_Thyme));
		hotel_rooms.add(new Room(305, Room.executiveRoom, BHD_Thyme));

		hotel_rooms.add(new Room(301, Room.suiteRoom, BHD_Thyme));
		hotel_rooms.add(new Room(302, Room.suiteRoom, BHD_Thyme));
		hotel_rooms.add(new Room(303, Room.suiteRoom, BHD_Thyme));
		hotel_rooms.add(new Room(304, Room.suiteRoom, BHD_Thyme));
		hotel_rooms.add(new Room(305, Room.suiteRoom, BHD_Thyme));
		BHD_Thyme.setRooms(hotel_rooms);
		
		
		currentHotel = "";
		checkInDate = new Date(); // eg. "2023-01-01"
		checkOutDate = new Date();
		numGuests = 0;
		roomName = ""; // "Standard", "Double", "Executive", or "Suite"

	}

	// Get the seperate Hotels
	public Hotel getBHD_Mary() {
		return BHD_Mary;
	}

	public Hotel getBHD_Rose() {
		return BHD_Rose;
	}

	public Hotel getBHD_Thyme() {
		return BHD_Thyme;
	}

	// Getters and setters for the booking pages
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

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomType) {
		this.roomName = roomType;
	}

	public ArrayList<Room> isRoomAvailableOnDay(String hotel, String date) {
		if (hotel.equals("Rose") || hotel.equals("BHD_Rose") || hotel.equals("BHD Rose")) {
			return BHD_Rose.getAvailableRooms(date);
		} else if (hotel.equals("Thyme") || hotel.equals("BHD_Thyme") || hotel.equals("BHD Thyme")) {
			return BHD_Thyme.getAvailableRooms(date);
		} else if (hotel.equals("Mary") || hotel.equals("BHD_Mary") || hotel.equals("BHD Mary")) {
			return BHD_Mary.getAvailableRooms(date);
		} else {
			return null;
		}
	}

	public ArrayList<Room> getAvailableRooms(Hotel hotel, String date) {
		return hotel.getAvailableRooms(date);
	}

	public ArrayList<Room> getAvailableRooms(Hotel hotel, LocalDate date) {
		return hotel.getAvailableRooms(date);
	}

	/*
	 * public String bookRooms(String hotelName) { return bookRooms(hotelName,
	 * checkInDate, checkOutDate, numGuests, roomName); }
	 */

	/*
	 * public String bookRooms(String hotelName, String startDate, String endDate,
	 * int numGuests, String roomName) {
	 * 
	 * // Get the room type based on the room name RoomType roomType; if
	 * (roomName.equals("Standard")) { roomType = Room.standardRoom; } else if
	 * (roomName.equals("Double")) { roomType = Room.doubleRoom; } else if
	 * (roomName.equals("Executive")) { roomType = Room.executiveRoom; } else if
	 * (roomName.equals("Suite")) { roomType = Room.suiteRoom; } else { return null;
	 * }
	 * 
	 * // Get the hotel based on the hotel name Hotel hotel; if
	 * (hotelName.equals("Rose") || hotelName.equals("BHD_Rose") ||
	 * hotelName.equals("BHD Rose")) { hotel = BHD_Rose; } else if
	 * (hotelName.equals("Thyme") || hotelName.equals("BHD_Thyme") ||
	 * hotelName.equals("BHD Thyme")) { hotel = BHD_Thyme; } else if
	 * (hotelName.equals("Mary") || hotelName.equals("BHD_Mary") ||
	 * hotelName.equals("BHD Mary")) { hotel = BHD_Mary; } else { hotel = null;
	 * return "error.xhtml"; }
	 * 
	 * boolean roomsAreAvailable = hotel.isRoomTypesAvailable(startDate, endDate,
	 * numGuests, roomType);
	 * 
	 * if (roomsAreAvailable == true) { hotel.BookRooms(startDate, endDate,
	 * numGuests, roomType); } else { return "error.xhtml"; }
	 * 
	 * return "success.xhtml"; }
	 */

	public String bookRooms() {

		// Get the room type based on the room name
		RoomType roomType;
		if (roomName.equals("Standard")) {
			roomType = Room.standardRoom;
		} else if (roomName.equals("Double")) {
			roomType = Room.doubleRoom;
		} else if (roomName.equals("Executive")) {
			roomType = Room.executiveRoom;
		} else if (roomName.equals("Suite")) {
			roomType = Room.suiteRoom;
		} else {
			return null;
		}

		// Get the hotel based on the hotel name
		Hotel hotel;
		if (currentHotel.equals("Rose") || currentHotel.equals("BHD_Rose") || currentHotel.equals("BHD Rose")) {
			hotel = BHD_Rose;
		} else if (currentHotel.equals("Thyme") || currentHotel.equals("BHD_Thyme") || currentHotel.equals("BHD Thyme")) {
			hotel = BHD_Thyme;
		} else if (currentHotel.equals("Mary") || currentHotel.equals("BHD_Mary") || currentHotel.equals("BHD Mary")) {
			hotel = BHD_Mary;
		} else {
			hotel = null;
			return "error.xhtml";
		}

		boolean roomsAreAvailable = hotel.isRoomTypesAvailable(checkInDateString, checkOutDateString, numGuests, roomType);

		if (roomsAreAvailable == true) {
			hotel.BookRooms(checkInDateString, checkOutDateString, numGuests, roomType);
		} else {
			error = "There is no rooms available."; 
			return "error.xhtml";
		}

		return "bookingConfirmation.xhtml";
	}

	public String getCurrentHotel() {
		return currentHotel;
	}

	public void setCurrentHotel(String currentHotel) {
		this.currentHotel = currentHotel;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getCheckInDateString() {
		return checkInDateString;
	}

	public void setCheckInDateString(String checkInDateString) {
		this.checkInDateString = checkInDateString;
	}

	public String getCheckOutDateString() {
		return checkOutDateString;
	}

	public void setCheckOutDateString(String checkOutDateString) {
		this.checkOutDateString = checkOutDateString;
	}
}