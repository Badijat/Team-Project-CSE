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
		private String errorMessage;
		
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
		/*
		 * // get the logged in user public User getLoggedInUser() {
		 * System.out.println("Get log in"); User user; return user; }
		 */
		
		
		// calling this method creates a new user in the database
		public String newUser() {	
			this.name.length();
			// does the password have less than 8 characters 
			if(this.password.length() < 8) {
				errorMessage = "Password must at least 8 characters in length";
				return errorMessage;
			}
			
			// check if the password contain an upper case letter, lower case letter and a number
			errorMessage = checkPassword(password);
			
			// if the error message is not correct something is wrong in the password
			if(errorMessage != "correct") {
				return errorMessage;
			}
			
			// pack the users information into a User object
			final User user = new User(this.name, this.password, this.email);
			
			// validate the user trying to login. Does the account already exist
			if(users.contains(user)) {
				errorMessage = "This user already exists. Please try logging in.";
				return errorMessage;
			}
			else {
				users.add(user);
				this.name = null;
				this.password  = null;
				this.email = null;
				System.out.println(users);
				return errorMessage;
			}
			
		}
		
		public String checkPassword(String str) {
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
		    	return "Password must contain a capital letter.";
		    }
		    if(!lowerCaseFlag) {
		    	return "Password must contain a lower case letter.";
		    }
		    // if gotten this far password must be missing a number
		    else {
		    	return "Password must contain a number.";
		    }
		}
		
		// to create a new user, call these set methods and then call newUser
		public void setname(String name) {
			this.name = name;
		}

		public void setemail(String email) {
			this.email = email;
		}

		public void setPassword(String password) {
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
				return "room availability.xhtml";
			} else {
				return "error.xhtml";
			}
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
	}

