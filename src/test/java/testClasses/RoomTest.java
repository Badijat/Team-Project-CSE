package testClasses;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ie.tus.HotelsBean;
import ie.tus.User;
import ie.tus.Hotel.Availablity;
import ie.tus.Hotel.Hotel;
import ie.tus.Hotel.Room;

public class RoomTest {
    Room testRoom;
	User testUser;
    Hotel testHotel;
	
	@BeforeEach
    void setUp() throws Exception {
        testHotel = new Hotel();
		testRoom  = new Room(101, "Single", 87, 1, testHotel);
		testUser  = new User("Yamada", "1234567890", "yamada@gmail.com");
	}

    @Test
    void testGetters() {
        assertTrue(101  == testRoom.getRoomNo());
        assertTrue("Single".equals(testRoom.getRoomName()));
        assertTrue(87   == testRoom.getPrice());
        assertTrue(1    == testRoom.getOccupancy());
        assertTrue(testHotel == testRoom.getParentHotel());
    }
    @Test
    void testSetters() {
        testRoom.setRoomNo(202);
        testRoom.setRoomName("Double");
        testRoom.setPrice(189);
        testRoom.setOccupancy(2);
        testRoom.setParentHotel(null);

        assertTrue(202  == testRoom.getRoomNo());
        assertTrue("Double".equals(testRoom.getRoomName()));
        assertTrue(189  == testRoom.getPrice());
        assertTrue(2    == testRoom.getOccupancy());
        assertTrue(null == testRoom.getParentHotel());
    }
    @Test
    void testConstructors() {
        Room newTestRoom = new Room(102, "Suite", 589, 2, null);
        assertTrue(102  == newTestRoom.getRoomNo());
        assertTrue("Suite".equals(newTestRoom.getRoomName()));
        assertTrue(589  == newTestRoom.getPrice());
        assertTrue(2    == newTestRoom.getOccupancy());
        assertTrue(null == newTestRoom.getParentHotel());

        newTestRoom = new Room();
        assertTrue(-1   == newTestRoom.getRoomNo());
        assertTrue("".equals(newTestRoom.getRoomName()));
        assertTrue(-1   == newTestRoom.getPrice());
        assertTrue(-1   == newTestRoom.getOccupancy());
        assertTrue(null == newTestRoom.getParentHotel());
    }

    @Test
    void testAvailablities() {
        String dataStr = "2023-01-01";
        LocalDate dateLD = LocalDate.parse(dataStr);
        assertTrue(testRoom.getAvailability(dataStr).status == Availablity.AVAILABLE);
        assertTrue(testRoom.getAvailability(dataStr) == (testRoom.getAvailability(dateLD)));
        Availablity a = testRoom.getAvailability(dateLD);
        a.status = Availablity.BOOKED;
        
        assertTrue(testRoom.getAvailability(dataStr).status == Availablity.BOOKED);
        assertTrue(testRoom.getAvailability(dataStr) == (testRoom.getAvailability(dateLD)));

        assertNotEquals(testRoom.getAvailability(dataStr), null);        
        assertNotEquals(testRoom.getAvailability(dataStr), new Hotel());

        // Test permutations of equals
        Availablity testA = new Availablity();        
        Availablity testB = new Availablity();
        testB.status = Availablity.AVAILABLE;
        testB.guest = testUser;

        testA.status = testB.status;
        testA.guest = testB.guest;
        assertEquals(testA, testB);
        testA.guest = null;
        assertTrue(!a.equals(testA));
        testA.status = Availablity.BOOKED;
        assertTrue(!testB.equals(testA));
        assertTrue(testB.equals(testB));
    }
}
