/**
 * 
 */
package com.mindtree.vehiclebusiness.dao;

import java.util.List;

import com.mindtree.vehiclebusiness.entity.Login;
import com.mindtree.vehiclebusiness.exception.DaoException;

/**
 * @author M1018439
 *
 */
public interface LoginDao {

	public void addUser(Login login) throws DaoException;

	public List<Login> getAllUsers() throws DaoException;
	
	
}
