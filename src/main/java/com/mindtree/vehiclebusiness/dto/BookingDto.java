/**
 * 
 */
package com.mindtree.vehiclebusiness.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author M1018339
 * 
 */

@XmlRootElement(name = "booking")
// Define the root element for a XML tree
public class BookingDto {
	private int id;
	private String custName;
	private String category;
	private Date bookedFrom;
	private Date bookedTo;
	private double totalRent;
	private String isPaid;
	private VehicleDto vehicle;
	private String emailId;
	private String regNo;

	// getters
	public String getEmailId() {
		return emailId;
	}

	// setters
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getBookedFrom() {
		return bookedFrom;
	}

	public void setBookedFrom(Date bookedFrom) {
		this.bookedFrom = bookedFrom;
	}

	public Date getBookedTo() {
		return bookedTo;
	}

	public void setBookedTo(Date bookedTo) {
		this.bookedTo = bookedTo;
	}

	public double getTotalRent() {
		return totalRent;
	}

	public void setTotalRent(double totalRent) {
		this.totalRent = totalRent;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public void setVehicle(VehicleDto vehicle) {
		this.vehicle = vehicle;
	}

	public VehicleDto getVehicle() {
		return vehicle;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

}
