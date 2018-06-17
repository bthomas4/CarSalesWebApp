package webApp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SalesForm {
	
	//Attributes
	private static Set<SalesForm> forms = new HashSet<>();
	private User user;
	private Vehicle vehicle;
	private Date date;
	
	
	//Constructors	
	public SalesForm() {}
	
	public SalesForm(User user, Vehicle vehicle) {
		this.user = user;
		this.vehicle = vehicle;
		this.date = new Date();
		forms.add(this); }

	
	//Getters and Setters
	public Set<SalesForm> getForms() {
		return forms;
	}

	public void setForms(Set<SalesForm> forms) {
		SalesForm.forms = forms;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
