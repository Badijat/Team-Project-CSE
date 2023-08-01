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
		assertEquals(20, hb.getAvailableRooms("Rose", "2023-01-01").size());		
		assertEquals(20, hb.getAvailableRooms("Mary", "2023-01-01").size());
		assertEquals(20, hb.getAvailableRooms("Thyme", "2023-01-01").size());
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
}
