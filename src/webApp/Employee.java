package webApp;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Employee extends Person {
	
	//Attributes
	private static Set<Employee> employees = new HashSet<>();
	private String code = "12345";
	
	
	//Constructors
	public Employee() {}

	public Employee(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
		this.id = createID();
		employees.add(this); }


	//Methods
	public String createID() {
		Random crazyNum = new Random();
		int randomNum = crazyNum.nextInt(899) + 100;
		
		id += getfName().substring(0, 1).toLowerCase();
		id += getlName().toLowerCase();
		id += randomNum;
		return id; }

	
	public boolean validateLogin(String fName, String lName, String code) {
		boolean result = false;
		for (Employee e : employees) {
			if (e.fName.equals(fName) && e.lName.equals(lName) && code.equals(e.code)) {
				result = true;
				break; }
			else {
				result = false; }}
		return result; }
	
	
	public Employee findUser(String fName, String lName) {
		Employee employee = new Employee();
		for (Employee e : employees) {
			if (e.getfName().equals(fName) && e.getlName().equals(lName)) {
				employee = e;
				break; }}
		return employee; }

	
	//Getters and Setters
	public static Set<Employee> getEmployees() {
		return employees;
	}

	public static void setEmployees(Set<Employee> employees) {
		Employee.employees = employees;
	}

}
