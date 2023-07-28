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
		
		@PostConstruct
		public void init() {
			System.out.println("Datatable init");
			users = new ArrayList<User>();
			User firstName = new User("William Dupont", "Pass0rd", "william@gmail.com");
			users.add(firstName);
			
			User secondName = new User("Harry Styles" , "NotHarryStyles", "harry@hotmail.com");
			users.add(secondName);
			
			User thirdName = new User ("Jon BonJovi", "jon@hotmail.com", "jon@gmail.com");
			users.add (thirdName);
		}
		
		// get the entire list of users 
		public ArrayList<User> getNames() {
			System.out.println("Get names");
			return users;
		}
		
		
		// calling this method creates a new user in the database
		public String newUser() {
			final User user = new User(this.name, this.password, this.email);
			users.add(user);
			this.name = null;
			this.password  = null;
			this.email = null;
			System.out.println(users);
			return null;
		}
		
		// put the information from the form into these set methods and then call newUser to create a new user
		public void setname(String name) {
			this.name = name;
		}

		public void setemail(String email) {
			this.email = email;
		}

		public void setpassword(String password) {
			this.password = password;
		}
		
		// these methods may not be needed
		public String getpassword() {
			return password;
		}

		public String getemail() {
			return email;
		}
		public String getname() {
			return name;
		}
	}

