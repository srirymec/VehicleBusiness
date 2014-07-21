/**
 * 
 */
package com.mindtree.vehiclebusiness.dao;

import java.util.List;

import com.mindtree.vehiclebusiness.entity.Booking;
import com.mindtree.vehiclebusiness.exception.DaoException;

/**
 * @author M1018439
 * 
 */
public interface BookingDao {

	public void bookVehicle(Booking b) throws DaoException;

	public List<Object[]> getReport() throws DaoException;

	public List<Object[]> getReport2() throws DaoException;

}
