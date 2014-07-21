/**
 * 
 */
package com.mindtree.vehiclebusiness.dao;

import java.util.List;

import com.mindtree.vehiclebusiness.entity.Vehicle;
import com.mindtree.vehiclebusiness.exception.DaoException;

/**
 * @author M1018439
 *
 */
public interface VehicleDao {

	public void addVehicle(Vehicle v) throws DaoException;


	public List<String> populateVehicles(String categ) throws DaoException;

	public List<Object> getDailyRent(String reg) throws DaoException;

	public List<Vehicle> getAllVehicles() throws DaoException;

}
