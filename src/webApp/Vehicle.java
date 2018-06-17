package webApp;

import java.time.*;
import java.util.HashSet;
import java.util.Set;

public class Vehicle {
	
	//Attributes
	private String vin;
	private String make;
	private String model;
	private int year;
	private int miles;
	private double listPrice;
	private double bidPrice;
	private double salePrice;
	private boolean isUsed;
	private LocalDate purchaseDate;
	private LocalDate saleDate;
	private String imagePath;
	private boolean is120;
	private int totalDaysOnLot;
	private static Set<Vehicle> vehicles = new HashSet<>();
	
	
	//Constructors	
	public Vehicle() {}
	
	public Vehicle(String vin, String make, String model, int year, int miles, double listPrice, boolean isUsed, String date, String imagePath) {
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.miles = miles;
		this.listPrice =listPrice;
		this.bidPrice = listPrice - (listPrice * .1);
		this.isUsed = isUsed;
		this.purchaseDate = LocalDate.parse(date);
		this.imagePath = imagePath;
		this.is120 = checkIs120();
		vehicles.add(this); }
	
	
	//Methods
	public double calculateSalePrice() {
		if (this.is120) {
			return this.bidPrice; }
		else {
			return this.listPrice; }}
	
	
	public boolean checkIs120() {
		int test = calculateDaysOnLot();
		if (test >= 120) {
			return true; }
		else {
			return false; }}
	
	
	public int calculateDaysOnLot() {
		LocalDate today = LocalDate.now();
		long test = Duration.between(this.purchaseDate.atStartOfDay(), today.atStartOfDay()).toDays();
		int testInt = (int) test;		
		return testInt; }

	
	//Getters and Setters
	public void setSaleDate() {
		LocalDate today = LocalDate.now();
		this.saleDate = today;
	}
	
	public String getSaleDate() {
		return this.saleDate.toString();
	}
	
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public String getYearString() {
		return Integer.toString(year);
	}	
	
	public void setYear(int year) {
		this.year = year;
	}

	public int getMiles() {
		return miles;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	public double getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}

	public boolean getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public boolean isIs120() {
		return is120;
	}

	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		Vehicle.vehicles = vehicles;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public void setIs120(boolean is120) {
		this.is120 = is120;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice() {
		this.salePrice = calculateSalePrice();
	}

	public int getTotalDaysOnLot() {
		return totalDaysOnLot;
	}
	
	public void setTotalDaysOnLot() {
		this.totalDaysOnLot = calculateDaysOnLot();
	}
	
}
