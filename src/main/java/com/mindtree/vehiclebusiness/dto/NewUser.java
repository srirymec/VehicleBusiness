/**
 * 
 */
package com.mindtree.vehiclebusiness.dto;

/**
 * @author m1017010
 *
 */
public class NewUser {
	
	private String username;
	private String password;
	private String confirmationPassword;
	/**
	 * 
	 */
	public NewUser() {
		super();
	}
	/**
	 * @param username
	 * @param password
	 * @param confirmationPassword
	 */
	public NewUser(String username, String password, String confirmationPassword) {
		super();
		this.username = username;
		this.password = password;
		this.confirmationPassword = confirmationPassword;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the confirmationPassword
	 */
	public String getConfirmationPassword() {
		return confirmationPassword;
	}
	/**
	 * @param confirmationPassword the confirmationPassword to set
	 */
	public void setConfirmationPassword(String confirmationPassword) {
		this.confirmationPassword = confirmationPassword;
	}
	
	

}
