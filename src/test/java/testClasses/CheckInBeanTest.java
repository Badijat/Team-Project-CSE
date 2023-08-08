package testClasses;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ie.tus.CheckInBean;

public class CheckInBeanTest {

	CheckInBean checkInBean;

	@BeforeEach
	void setUpClass() throws Exception {
		checkInBean = new CheckInBean();
	}
	
	@Test
	void testCheckOut() throws Exception {
		String actual = checkInBean.checkIn();
		assertEquals("checkIn-success", actual);
	}
}
