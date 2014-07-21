package com.mindtree.vehiclebusiness.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="valueobjects")// Define the root element for a XML tree
public class ValueObjects {

	List<ValueObject>list;

	//getters
	public List<ValueObject> getList() {
		return list;
	}
    //setters
 	public void setList(List<ValueObject> list) {
		this.list = list;
	}
	
	
	
}
