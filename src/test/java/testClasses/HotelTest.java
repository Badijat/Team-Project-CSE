package testClasses;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ie.tus.HotelsBean;
import ie.tus.User;
import ie.tus.Hotel.Hotel;
import ie.tus.Hotel.Room;


class HotelTest {
	HotelsBean hb;
	User testUser;
	
	@BeforeEach
	void setUp() throws Exception {
		hb = new HotelsBean();
		hb.init();
		testUser = new User("Yamada", "1234567890", "yamada@gmail.com");
	}

	@Test
	void testConstructors() {
        Hotel Mary = hb.getBHD_Mary();
		Hotel test = new Hotel(Mary.getName(), Mary.getRooms(), Mary.getStaff());
		assertEquals(Mary.getName(), test.getName());
		assertEquals(Mary.getRooms(), test.getRooms());
		assertEquals(Mary.getStaff(), test.getStaff());

		test = new Hotel();
		assertEquals("", test.getName());
		assertEquals(0, test.getRooms().size());
		assertEquals(0, test.getStaff().size());
    }
	
	@Test
	void testRoomsAvailableRose() {
		assertEquals(20, hb.isRoomAvailableOnDay("Rose", "2023-01-01").size());		
		assertEquals(20, hb.isRoomAvailableOnDay("Mary", "2023-01-01").size());
		assertEquals(20, hb.isRoomAvailableOnDay("Thyme", "2023-01-01").size());
	}

	@Test
	void testRoomsAvailableMary() {
		assertEquals(20, hb.getAvailableRooms(hb.getBHD_Mary(), "2023-01-01").size());
		assertEquals(20, hb.getAvailableRooms(hb.getBHD_Rose(), "2023-01-01").size());
		assertEquals(20, hb.getAvailableRooms(hb.getBHD_Thyme(), "2023-01-01").size());
	}

	@Test
	void testRoomsAvailableThyme() {
		ArrayList<Room> avilableRooms = hb.getAvailableRooms(hb.getBHD_Thyme(), "2023-05-22");
		Room firstRoom = avilableRooms.get(0);
		String[] testDays = {"2023-05-22", "2023-05-23", "2023-05-24"};
		firstRoom.bookDays(testDays, testUser);
		assertEquals(19, hb.getAvailableRooms(hb.getBHD_Thyme(), "2023-05-22").size());
	}
	
	@Test
	void testRoomsBooking() {
		
		// Standard room test
		String successfulBooking = hb.bookRooms("Mary", "2023-02-01", "2023-02-08", 1, "Standard");
		assertEquals("success.xhtml", successfulBooking);
		
		// Book out all the rooms
		hb.bookRooms("Mary", "2023-02-01", "2023-02-08", 1, "Standard");
		hb.bookRooms("Mary", "2023-02-01", "2023-02-08", 1, "Standard");
		hb.bookRooms("Mary", "2023-02-01", "2023-02-08", 1, "Standard");
		hb.bookRooms("Mary", "2023-02-01", "2023-02-08", 1, "Standard");
		
		// Rooms are all booked so try book anew room
		String unsuccessfulBooking = hb.bookRooms("Mary", "2023-02-01", "2023-02-08", 1, "Standard");
		assertEquals("error.xhtml", unsuccessfulBooking);
		



		// Double room test
		successfulBooking = hb.bookRooms("Mary", "2023-02-01", "2023-02-08", 1, "Double");
		assertEquals("success.xhtml", successfulBooking);
		
		// Book out all the rooms
		hb.bookRooms("Mary", "2023-02-01", "2023-02-08", 1, "Double");
		hb.bookRooms("Mary", "2023-02-01", "2023-02-08", 1, "Double");
		hb.bookRooms("Mary", "2023-02-01", "2023-02-08", 1, "Double");
		hb.bookRooms("Mary", "2023-02-01", "2023-02-08", 1, "Double");
		
		// Rooms are all booked so try book anew room
		unsuccessfulBooking = hb.bookRooms("Mary", "2023-02-01", "2023-02-08", 1, "Double");
		assertEquals("error.xhtml", unsuccessfulBooking);
		



		// Executive room test
		successfulBooking = hb.bookRooms("Rose", "2023-02-01", "2023-02-08", 1, "Executive");
		assertEquals("success.xhtml", successfulBooking);
		
		// Book out all the rooms
		hb.bookRooms("Rose", "2023-02-01", "2023-02-08", 1, "Executive");
		hb.bookRooms("Rose", "2023-02-01", "2023-02-08", 1, "Executive");
		hb.bookRooms("Rose", "2023-02-01", "2023-02-08", 1, "Executive");
		hb.bookRooms("Rose", "2023-02-01", "2023-02-08", 1, "Executive");
		
		// Rooms are all booked so try book anew room
		unsuccessfulBooking = hb.bookRooms("Rose", "2023-02-01", "2023-02-08", 1, "Executive");
		assertEquals("error.xhtml", unsuccessfulBooking);



		
		// Suite room test
		successfulBooking = hb.bookRooms("Thyme", "2023-02-01", "2023-02-08", 1, "Suite");
		assertEquals("success.xhtml", successfulBooking);
		
		// Book out all the rooms
		hb.bookRooms("Thyme", "2023-02-01", "2023-02-08", 1, "Suite");
		hb.bookRooms("Thyme", "2023-02-01", "2023-02-08", 1, "Suite");
		hb.bookRooms("Thyme", "2023-02-01", "2023-02-08", 1, "Suite");
		hb.bookRooms("Thyme", "2023-02-01", "2023-02-08", 1, "Suite");
		
		// Rooms are all booked so try book anew room
		unsuccessfulBooking = hb.bookRooms("Thyme", "2023-02-01", "2023-02-08", 1, "Suite");
		assertEquals("error.xhtml", unsuccessfulBooking);
	}

	@Test
	void testMultiRoomsBooking() {
		
		// Standard room test
		String successfulBooking = hb.bookRooms("Mary", "2023-02-01", "2023-02-08", 4, "Standard");
		assertEquals("success.xhtml", successfulBooking);

		String unsuccessfulBooking = hb.bookRooms("Mary", "2023-02-01", "2023-02-08", 2, "Standard");
		assertEquals("error.xhtml", unsuccessfulBooking);


		// Double room test
		successfulBooking = hb.bookRooms("Thyme", "2023-02-01", "2023-02-08", 3, "Double");
		assertEquals("success.xhtml", successfulBooking);

		successfulBooking = hb.bookRooms("Thyme", "2023-02-01", "2023-02-08", 2, "Double");
		assertEquals("success.xhtml", successfulBooking);
		
		unsuccessfulBooking = hb.bookRooms("Thyme", "2023-02-01", "2023-02-08", 5, "Double");
		assertEquals("error.xhtml", unsuccessfulBooking);


		// Executive room test
		successfulBooking = hb.bookRooms("Rose", "2023-02-01", "2023-02-08", 5, "Executive");
		assertEquals("success.xhtml", successfulBooking);

		unsuccessfulBooking = hb.bookRooms("Rose", "2023-02-01", "2023-02-08", 2, "Executive");
		assertEquals("error.xhtml", unsuccessfulBooking);

		// Suite room test
		successfulBooking = hb.bookRooms("Rose", "2023-02-01", "2023-02-08", 5, "Suite");
		assertEquals("success.xhtml", successfulBooking);
		successfulBooking = hb.bookRooms("Rose", "2023-02-07", "2023-02-20", 4, "Suite");
		assertEquals("success.xhtml", successfulBooking);

		unsuccessfulBooking = hb.bookRooms("Rose", "2023-02-07", "2023-02-11", 1, "Suite");
		assertEquals("error.xhtml", unsuccessfulBooking);
		
		
		
		// Bad Hotel Test
		unsuccessfulBooking = hb.bookRooms("Wrong Hotel", "2023-02-07", "2023-02-11", 1, "Suite");
		assertEquals("error.xhtml", unsuccessfulBooking);


	}
}
