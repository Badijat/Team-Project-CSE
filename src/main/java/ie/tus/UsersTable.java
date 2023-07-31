package ie.tus;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="UsersTable")
@SessionScoped
public class UsersTable {
	
		private ArrayList<User> users;
		private String name, email, password;
		private User LoggedInUser;
		
		@PostConstruct
		public void init() {
			System.out.println("Datatable init");
			users = new ArrayList<User>();
			
			User firstUser = new User("William Dupont", "Pass0rd", "william@gmail.com");
			users.add(firstUser);
			
			User secondUser = new User("Harry Styles" , "NotHarryStyles", "harry@hotmail.com");
			users.add(secondUser);
			
			User thirdUser = new User ("Jon BonJovi", "jon@hotmail.com", "jon@gmail.com");
			users.add(thirdUser);
			
			User testUser = new User ("test", "test", "test@gmail.com");
			users.add(testUser);
		}
		
		// get the entire list of users 
		public ArrayList<User> getNames() {
			System.out.println("Get names");
			return users;
		}
		
		
		// calling this method creates a new user in the database
		public String newUser() {	
			// does the password have less than 8 characters 
			if(this.password.length() < 8) {
				return "Password must be 8 or more characters long";
			}
			
			// check if the password contain an upper case letter, lower case letter and a number
			String check = checkPassword(password);
			if(check != "correct") {
				return check;
			}
			
			// pack the users information into a User object
			final User user = new User(this.name, this.password, this.email);
			
			// validate the user trying to login. Does the account already exist
			if(users.contains(user)) {
				return "user already exists";
			}else {
				users.add(user);
				this.name = null;
				this.password  = null;
				this.email = null;
				System.out.println(users);
				return null;
			}
		}
		
		public static String checkPassword(String str) {
		    char ch;
		    boolean capitalFlag = false;
		    boolean lowerCaseFlag = false;
		    boolean numberFlag = false;
		    for(int i=0;i < str.length();i++) {
		        ch = str.charAt(i);
		        if(Character.isDigit(ch)) {
		            numberFlag = true;
		        }
		        else if (Character.isUpperCase(ch)) {
		            capitalFlag = true;
		        } 
		        else if (Character.isLowerCase(ch)) {
		            lowerCaseFlag = true;
		        }
		        if(numberFlag && capitalFlag && lowerCaseFlag)
		            return "correct";
		    }
		    if(!capitalFlag) {
		    	return "Password requires capital letter";
		    }
		    if(!lowerCaseFlag) {
		    	return "Password requires a lower case letter";
		    }
		    if(!numberFlag) {
		    	return "Password requires a numnber";
		    }
		    
		    // will never get to this return statement but java requires it
			return "correct";
		}
		
		// to create a new user, call these set methods and then call newUser
		public void setname(String name) {
			this.name = name;
		}

		public void setemail(String email) {
			this.email = email;
		}

		public void setpassword(String password) {
			this.password = password;
		}
		
		// these get methods may not be needed but included anyway
		public String getpassword() {
			return password;
		}

		public String getemail() {
			return email;
		}
		public String getname() {
			return name;
		}
		public String login() {
			final User login = new User(this.name, this.password, this.email);
			boolean valildLogin = users.contains(login);
			if(valildLogin) {
				LoggedInUser = login;
			}
			
			if(valildLogin == true) {
				return "success.xhtml";
			} else {
				return "error.xhtml";
			}
		}
	}

