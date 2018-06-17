package webApp;

import java.util.HashSet;
import java.util.Set;

public class User extends Person {
	
	//Attributes
	private static Set<User> users = new HashSet<>();
	private int index = 1000;	
	private double bidAmount;
	
	
	//Constructors
	public User() {}

	public User(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
		this.id = getfName().substring(0, 1).toLowerCase() + getlName().substring(0, 1).toLowerCase() + Integer.toString(index);
		users.add(this);
		index++; }
	
	
	//Methods
	public boolean validateLogin (String fNameIn, String lNameIn) {
		boolean result = false;
		for (User u : users) {
			if (u.fName.equals(fNameIn) && u.lName.equals(lNameIn)) {
				result = true;
				break; }
			else {
				result = false; }}
		return result; }
	
	
	public User findUser (String fName, String lName) {
		User user = new User();
		for (User u : users) {
			if (u.getfName().equals(fName) && u.getlName().equals(lName)) {
				user = u;
				break; }}
		return user; }
	
	
	//Getters and Setters
	public String getIndex () {
		return (Integer.toString(this.index));
	}
	
	public void setBidAmount(double bid) {
		this.bidAmount = bid;
	}
	
	public double getBidAmount() {
		return bidAmount; 
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		User.users = users;
	}
	
}
