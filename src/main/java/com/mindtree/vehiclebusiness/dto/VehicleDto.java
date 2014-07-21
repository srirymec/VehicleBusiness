/**
 * 
 */
package com.mindtree.vehiclebusiness.dto;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author M1018339
 * 
 */
@XmlRootElement(name = "vehicle")
// Define the root element for a XML tree
public class VehicleDto {
	private String regNo;

	private String cat;
	private String manufacturer;
	private int dailyRent;
	private int mileage;
	private String fuelType;
	private String description;

	private Set<BookingDto> bookings;

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getDailyRent() {
		return dailyRent;
	}

	public void setDailyRent(int dailyRent) {
		this.dailyRent = dailyRent;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setBookings(Set<BookingDto> bookings) {
		this.bookings = bookings;
	}

	public Set<BookingDto> getBookings() {
		return bookings;
	}
}
