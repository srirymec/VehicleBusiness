/**
 * 
 */
package com.mindtree.vehiclebusiness.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author M1018339
 * 
 */
// Define the root element for a XML tree
@XmlRootElement(name = "valueobject")
public class ValueObject {
	private String cat;
	private Long totalVeh;
	private Long totalRented;
	private Double totalEarned;

	// getters
	public String getCat() {
		return cat;
	}

	// setters
	public void setCat(String cat) {
		this.cat = cat;
	}

	public Long getTotalVeh() {
		return totalVeh;
	}

	public void setTotalVeh(Long totalVeh) {
		this.totalVeh = totalVeh;
	}

	public Long getTotalRented() {
		return totalRented;
	}

	public void setTotalRented(Long totalRented) {
		this.totalRented = totalRented;
	}

	public Double getTotalEarned() {
		return totalEarned;
	}

	public void setTotalEarned(Double totalEarned) {
		this.totalEarned = totalEarned;
	}
}
