/**
 * 
 */
package com.mindtree.vehiclebusiness.service;

import java.util.List;

import com.mindtree.vehiclebusiness.dto.BookingDto;
import com.mindtree.vehiclebusiness.dto.ValueObject;
import com.mindtree.vehiclebusiness.exception.ServiceException;

/**
 * @author M1018439
 *
 */
public interface BookingService {

	public void bookVehicle(BookingDto b) throws ServiceException;
	
	public List<ValueObject> getReport() throws ServiceException;
	
	
}
