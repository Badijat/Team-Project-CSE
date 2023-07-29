package testClasses;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ie.tus.User;

class UserTest {
	User user;
	@BeforeEach
	void setUp() throws Exception {
		user = new User("user", "password", "email@gmail.com");
	}

	@Test
	void testEquals1() {
		User compare = new User("user", "password", "email@gmail.com");
		assertEquals(true, user.equals(compare));
	}
	
	@Test
	void testEquals2() {
		User compare = new User("user3213", "password22", "email123@gmail.com");
		assertEquals(false, user.equals(compare));
	}
	
	@Test
	void testEquals3() {
		User compare = null;
		assertEquals(false, user.equals(compare));
	}
	
	@Test
	void testEquals4() {
		String compare = new String("string object");
		assertEquals(false, user.equals(compare));
	}

	@Test
	void testToString() {
		assertEquals("User [name=user, emailAddress=email@gmail.com, password=password]", user.toString());
	}
}
