/**
 * 
 */
package com.mindtree.vehiclebusiness.entity;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author m1017010
 * 
 */
@XmlRootElement
// Define the root element for a XML tree
public class Login {

	private String username;
	private String password;
	private int loginId;
	private String email;
	private String confirmPassword;
	private String mobileNo;

	public Login() {
		super();
	}

	
	// getters
	public String getUsername() {
		return username;
	}

	// setters
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public Login(String username, String password, int loginId, String email,
			String confirmPassword, String mobileNo) {
		super();
		this.username = username;
		this.password = password;
		this.loginId = loginId;
		this.email = email;
		this.confirmPassword = confirmPassword;
		this.mobileNo = mobileNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
 
	
	
	
}
