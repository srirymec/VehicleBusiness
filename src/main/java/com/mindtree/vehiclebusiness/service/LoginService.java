/**
 * 
 */
package com.mindtree.vehiclebusiness.service;

import java.util.List;

import com.mindtree.vehiclebusiness.dto.LoginDto;
import com.mindtree.vehiclebusiness.exception.ServiceException;

/**
 * @author M1018439
 *
 */
public interface LoginService {
	public List<LoginDto> getusers() throws ServiceException;

	public void addUser(LoginDto login) throws ServiceException;
}
