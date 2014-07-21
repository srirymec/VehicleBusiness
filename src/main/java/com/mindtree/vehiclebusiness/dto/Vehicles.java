package com.mindtree.vehiclebusiness.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicles")
// Define the root element for a XML tree
public class Vehicles {

	List<String> vehicleList;

	public List<String> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<String> vehicleList) {
		this.vehicleList = vehicleList;
	}

}
