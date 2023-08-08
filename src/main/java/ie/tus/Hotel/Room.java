package ie.tus.Hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import ie.tus.User;

public class Room {
    public static final RoomType standardRoom  = new RoomType("Standard" ,  98, 1);
    public static final RoomType doubleRoom    = new RoomType("Double"   , 168, 2);
    public static final RoomType executiveRoom = new RoomType("Executive", 398, 1);
    public static final RoomType suiteRoom     = new RoomType("Suite"    , 598, 2);

	private int roomNo;
    private RoomType roomType;
    private Hotel parentHotel;

    // Date used to start the index for the availability array
    // ie. the availability at index 0 is "2023-01-01" and the availability at index 1 is "2023-01-02"
    private final LocalDate startDate = LocalDate.parse("2023-01-01");
    private Availablity[] availability;

    public Room() {
		this.roomNo = -1;
		this.roomType = null;
		this.parentHotel = null;
        this.availability = new Availablity[365];
        for (int i = 0; i < availability.length; i++) {
            availability[i] = new Availablity();
        }
	}
    
    public Room(int roomNo, RoomType roomType, Hotel parentHotel) {
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.parentHotel = parentHotel;
        this.availability = new Availablity[365];
        for (int i = 0; i < availability.length; i++) {
            availability[i] = new Availablity();
        }
	}
    
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
    public RoomType getRoomType() {
        return roomType;
    }
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
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
    public boolean bookDays(String[] bookDays, User guest) {
        int[] daysToBook = new int[bookDays.length];

        // Convert to indexs so we can check if the day is available
        for(int i = 0; i < bookDays.length; i++) {
            // daysToBook[i] = (int) startDate.until(LocalDate.parse(bookDays[i]), ChronoUnit.DAYS);
            daysToBook[i] = dateToIndex(bookDays[i]);
        }

        // Check if all the days are available
        for (int day : daysToBook) {
            if(availability[day].status != Availablity.AVAILABLE) {
                return false;
            }
        }

        // Mark the days as booked
        for (int day : daysToBook) {
            availability[day].status = Availablity.BOOKED;
            availability[day].guest = guest;
        }
        return true;
    }
    public boolean isRoomAvailable(String date) {
        return isRoomAvailable(dateToIndex(date));
    }
    public boolean isRoomAvailable(LocalDate date) {
        return isRoomAvailable(dateToIndex(date));
    }
    private boolean isRoomAvailable(int index) {
        return availability[index].status == Availablity.AVAILABLE;
    }
    public int dateToIndex(String date) {
        return dateToIndex(LocalDate.parse(date));
    }
    public int dateToIndex(LocalDate date) {
        return (int) startDate.until(date, ChronoUnit.DAYS);
    }
    public Availablity getAvailability(String date) {
        return getAvailability(dateToIndex(date));
    }
    public Availablity getAvailability(LocalDate date) {
        return getAvailability(dateToIndex(date));
    }
    private Availablity getAvailability(int index) {
        return availability[index];
    }
    
    public boolean isAvailabilityForDates(String startDate, String endDate) {
        return isAvailabilityForDates(dateToIndex(startDate), dateToIndex(endDate));
    }

    private boolean isAvailabilityForDates(int startDateIdx, int endDateIdx) {
        for (int i = startDateIdx; i <= endDateIdx; i++) {
            if(availability[i].status != Availablity.AVAILABLE) {
                return false;
            }
        }
        return true;
    }
    
    public boolean bookRoomForDates(String startDate, String endDate) {
        return bookRoomForDates(dateToIndex(startDate), dateToIndex(endDate));
    }

    private boolean bookRoomForDates(int startDateIdx, int endDateIdx) {
        // Check if room is available
        for (int i = startDateIdx; i <= endDateIdx; i++) {
            if(availability[i].status != Availablity.AVAILABLE) {
                return false;
            }
        }

        // Set dates as booked
        for (int i = startDateIdx; i <= endDateIdx; i++) {
            availability[i].status = Availablity.BOOKED;
        }
        return true;
    }
}
