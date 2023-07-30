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
		ut.setpassword("Ab123456");
		ut.setemail("123@gmail.com");
		ut.newUser();
	}
	
	// password is less than 8 characters
	@Test
	void testNewUser1() {
		ut.setname("User");
		ut.setpassword("123");
		ut.setemail("123@gmail.com");
		
		assertEquals("Password must be 8 or more characters long" , ut.newUser());
	}

	 // User doesnt exist
	@Test
	void testNewUser2() {
		User user = new User("User", "123", "123@gmail.com");
		
		ArrayList<User> arr = ut.getNames();
		
		assertEquals(false , arr.contains(user));
	}

	// password is 8 or more characters 
	@Test
	void testNewUser3() {
		User user = new User("Michael", "abcdefgh", "122233443@gmail.com");
		
		ArrayList<User> arr = ut.getNames();
		
		assertEquals(false , arr.contains(user));
	}
	
	// all correct information 
	@Test
	void testNewUser4() {
		User user = new User("Michael", "Abcde123", "122233443@gmail.com");
		
		ArrayList<User> arr = ut.getNames();
		
		assertEquals(false , arr.contains(user));
	}
	
	// user already exists 
	@Test
	void testNewUser5() {
		User user = new User("William Dupont", "Pass0rd", "william@gmail.com");
		
		ArrayList<User> arr = ut.getNames();
		
		assertEquals(true , arr.contains(user));
	}
	
	@Test
	void testloginPass() {
		ut.setname("User");
		ut.setpassword("Ab123456");
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
	
	// check password, doesnt have a capital letter
	@Test
	void testcheckPassword1() {
		assertEquals("Password requires capital letter", ut.checkPassword("a1"));
	}
	
	// check password, has an upper case but doesnt have lower
	@Test
	void testcheckPassword2() {
		assertEquals("Password requires a lower case letter", ut.checkPassword("A1"));
	}
	
	// check password, has an upper case and lower case but no number
	@Test
	void testcheckPassword3() {
		assertEquals("Password requires a numnber", ut.checkPassword("Aa"));
	}
	
	// check password, has an upper case and lower case and a number (valid password combo)
	@Test
	void testcheckPassword4() {
		assertEquals("correct", ut.checkPassword("Aa1"));
	}
}
