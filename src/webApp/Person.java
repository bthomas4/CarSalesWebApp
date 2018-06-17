package webApp;

public abstract class Person {
	
	//Attributes
	protected String fName;
	protected String lName;
	protected String id;
	
	
	//Getters and Setters
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + ", id=" + id + "]";
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
