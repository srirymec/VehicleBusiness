/**
 * 
 */
package com.mindtree.vehiclebusiness.service;

import java.util.List;

import com.mindtree.vehiclebusiness.dto.VehicleDto;
import com.mindtree.vehiclebusiness.exception.ServiceException;

/**
 * @author M1018439
 * 
 */
public interface VehicleService {

	public void addVehicle(VehicleDto v) throws ServiceException;

	public List<String> populateVehicles(String categ) throws ServiceException;

	public int getDailyRent(String reg) throws ServiceException;

	public List<VehicleDto> getAllVehicles() throws ServiceException;

}
