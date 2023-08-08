package testClasses;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ie.tus.User;
import ie.tus.Hotel.Availablity;
import ie.tus.Hotel.Hotel;
import ie.tus.Hotel.Room;
import ie.tus.Hotel.RoomType;

public class RoomTest {
	Room testRoom;
	User testUser;
	Hotel testHotel;

//    public static final RoomType standardRoom  = new RoomType("Standard" ,  98, 1);
//    public static final RoomType doubleRoom    = new RoomType("Double"   , 168, 2);
//    public static final RoomType executiveRoom = new RoomType("Executive", 398, 1);
//    public static final RoomType suiteRoom     = new RoomType("Suite"    , 598, 2);

	@BeforeEach
	void setUp() throws Exception {
		testHotel = new Hotel();
		testRoom = new Room(101, Room.standardRoom, testHotel);
		testUser = new User("Yamada", "1234567890", "yamada@gmail.com");
	}

	@Test
	void testGetters() {
		assertTrue(101 == testRoom.getRoomNo());
		assertTrue("Standard".equals(testRoom.getRoomType().getRoomName()));
		assertTrue(98.0 == testRoom.getRoomType().getPrice());
		assertTrue(1 == testRoom.getRoomType().getOccupancy());
		assertTrue(testHotel == testRoom.getParentHotel());
	}

	@Test
	void testSetters() {
		testRoom.setRoomNo(202);
		testRoom.setParentHotel(null);

		assertTrue(202 == testRoom.getRoomNo());
		assertTrue(null == testRoom.getParentHotel());
	}

	@Test
	void testConstructors() {
		Room newTestRoom = new Room(102, Room.suiteRoom, null);
		assertEquals(102, newTestRoom.getRoomNo());
		assertEquals("Suite", newTestRoom.getRoomType().getRoomName());
		assertEquals(598.0, newTestRoom.getRoomType().getPrice());
		assertEquals(2, newTestRoom.getRoomType().getOccupancy());
		assertEquals(null, newTestRoom.getParentHotel());

		newTestRoom = new Room();
		assertEquals(-1, newTestRoom.getRoomNo());
		assertEquals(null, newTestRoom.getRoomType());
		assertEquals(null, newTestRoom.getParentHotel());
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

	@Test
    void testRoomType() {
        RoomType rt = new RoomType("Single", 100.0f, 1);
        assertEquals("Single", rt.getRoomName());
        assertEquals(100.0f, rt.getPrice());
        assertEquals(1, rt.getOccupancy());
        
        rt.setRoomName("Double");
        rt.setPrice(200.0f);
        rt.setOccupancy(2);
        assertEquals("Double", rt.getRoomName());
        assertEquals(200.0f, rt.getPrice());
        assertEquals(2, rt.getOccupancy());
        
        RoomType rt2 = new RoomType();
        assertEquals("", rt2.getRoomName());
        assertEquals(-1, rt2.getPrice());
        assertEquals(-1, rt2.getOccupancy());
        
        assertNotEquals(rt2, new Hotel());
        assertNotEquals(rt2, null);
        assertNotEquals(rt2, rt);
        assertEquals(rt2, rt2);
        rt2.setRoomName("Double");
        rt2.setPrice(200.0f);
        rt2.setOccupancy(2);
        assertEquals(rt2, rt);
        
    }
}
