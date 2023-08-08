package testClasses;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ie.tus.Hotel.Hotel;
import ie.tus.Hotel.Staff;


public class StaffTest {
	Staff testStaff;
    @BeforeEach
    void setUp() throws Exception {
        testStaff = new Staff();
	}

    @Test
    void testConstructors() {
        testStaff = new Staff();

        assertTrue(testStaff.getStaffId() == -1);
		assertTrue(testStaff.getName().equals(""));
		assertTrue(testStaff.getEmail().equals(""));
		assertTrue(testStaff.getPassword().equals(""));
        assertTrue(testStaff.getPlaceOfWork() == null);

        Hotel testHotel = new Hotel();
        testStaff = new Staff(1, "John", "123456", "john@gmail.com", testHotel);

        assertTrue(testStaff.getStaffId() == 1);
		assertTrue(testStaff.getName().equals("John"));
		assertTrue(testStaff.getEmail().equals("john@gmail.com"));
		assertTrue(testStaff.getPassword().equals("123456"));
        assertTrue(testStaff.getPlaceOfWork() == testHotel);
    }

    @Test
    void testSetters() {
        Hotel testHotel = new Hotel();
        testStaff.setStaffId(100);
        testStaff.setName("Yamada");
        testStaff.setEmail("yamada@gmail.com");
        testStaff.setPassword("Password123");
        testStaff.setPlaceOfWork(testHotel);

        assertTrue(testStaff.getStaffId() == 100);
		assertTrue(testStaff.getName().equals("Yamada"));
		assertTrue(testStaff.getEmail().equals("yamada@gmail.com"));
		assertTrue(testStaff.getPassword().equals("Password123"));
        assertTrue(testStaff.getPlaceOfWork() == testHotel);
    }
}
