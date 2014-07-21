/**
 * 
 */
package com.mindtree.vehiclebusiness.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.mindtree.vehiclebusiness.dto.LoginDto;;

/**
 * @author m1017010
 * 
 */
@XmlRootElement(name = "users")
// Define the root element for a XML tree
public class Users {

	private List<LoginDto> loginDetails;

	public List<LoginDto> getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(List<LoginDto> loginDetails) {
		this.loginDetails = loginDetails;
	}

}
