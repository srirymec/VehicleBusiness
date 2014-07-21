/**
 * 
 */
package com.mindtree.vehiclebusiness.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author m1017010
 * 
 */
// Define the root element for a XML tree
@XmlRootElement(name = "login")
public class LoginDto {

	private String username;
	private String password;
	private int loginId;
    private String confirmPassword;
    private String email;
    private String mobileNo;
    
	public LoginDto() {
		super();
	}

		
	public LoginDto(String username, String password, int loginId,
			String confirmPassword, String email, String mobileNo) {
		super();
		this.username = username;
		this.password = password;
		this.loginId = loginId;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.mobileNo = mobileNo;
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


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	
}
