package testClasses;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ie.tus.User;
import ie.tus.UsersTable;

class UsersTableTest {
	UsersTable ut;
	
	@BeforeEach
	void setUp() throws Exception {
		ut = new UsersTable();
		ut.init();
		ut.setname("User");
		ut.setpassword("123");
		ut.setemail("123@gmail.com");
		ut.newUser();
	}
	
	@Test
	void testNewUser1() {
		ut.setname("User");
		ut.setpassword("123");
		ut.setemail("123@gmail.com");
		
		assertEquals("Password must be 8 or more characters long" , ut.newUser());
	}

	@Test
	void testNewUser2() {
		User user = new User("User", "123", "123@gmail.com");
		
		ArrayList<User> arr = ut.getNames();
		
		assertEquals(true , arr.contains(user));
	}

	@Test
	void testNewUser3() {
		User user = new User("Michael", "abcdefgh", "122233443@gmail.com");
		
		ArrayList<User> arr = ut.getNames();
		
		assertEquals(false , arr.contains(user));
	}
	
	
	
	@Test
	void testloginPass() {
		ut.setname("User");
		ut.setpassword("123");
		ut.setemail("123@gmail.com");
		
		assertEquals("success.xhtml", ut.login());
	}
	
	@Test
	void testloginFail() {
		ut.setname("User");
		ut.setpassword("1333");
		ut.setemail("123@gmail.com");
		
		assertEquals("error.xhtml", ut.login());
	}
	
	
}
