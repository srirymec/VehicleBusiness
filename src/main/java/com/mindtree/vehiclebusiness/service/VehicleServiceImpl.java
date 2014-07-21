/**
 * 
 */
package com.mindtree.vehiclebusiness.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.vehiclebusiness.controller.RentalController;
import com.mindtree.vehiclebusiness.dao.VehicleDao;
import com.mindtree.vehiclebusiness.dto.VehicleDto;
import com.mindtree.vehiclebusiness.entity.Vehicle;
import com.mindtree.vehiclebusiness.exception.DaoException;
import com.mindtree.vehiclebusiness.exception.ServiceException;

/**
 * @author M1018439
 * 
 */
public class VehicleServiceImpl implements VehicleService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mindtree.vehiclebusiness.service.VehicleService#addVehicle(com.mindtree
	 * .vehiclebusiness.entity.Vehicle)
	 */

	@Autowired
	private VehicleDao vehicleDao;

	/*
	 * Logger is used as custom information for admin. We can check errors in
	 * file in tomcat.
	 */
	private Logger logger = Logger
			.getLogger(VehicleServiceImpl.class.getName());

	public void addVehicle(VehicleDto v) throws ServiceException {

		try {
			Vehicle vehicle = new Vehicle();
			vehicle.setCat(v.getCat());
			vehicle.setDailyRent(v.getDailyRent());
			vehicle.setDescription(v.getDescription());
			vehicle.setFuelType(v.getFuelType());
			vehicle.setManufacturer(v.getManufacturer());
			vehicle.setMileage(v.getMileage());
			vehicle.setRegNo(v.getRegNo());

			vehicleDao.addVehicle(vehicle);

		} catch (DaoException e) {
			logger.error(
					"hey error generated in getting user list please check your code!!!!!",
					e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mindtree.vehiclebusiness.service.VehicleService#populateVehicles(
	 * java.lang.String)
	 */
	public List<String> populateVehicles(String categ) throws ServiceException {

		try {
			return vehicleDao.populateVehicles(categ);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mindtree.vehiclebusiness.service.VehicleService#getDailyRent(java
	 * .lang.String)
	 */
	public int getDailyRent(String reg) throws ServiceException {

		List<Object> arr;
		try {
			arr = vehicleDao.getDailyRent(reg);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		int ret = (Integer) arr.get(0);
		return ret;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mindtree.vehiclebusiness.service.VehicleService#getAllVehicles()
	 */
	public List<VehicleDto> getAllVehicles() throws ServiceException {
		List<VehicleDto> list = new ArrayList<VehicleDto>();
		List<Vehicle> list2;
		try {
			list2 = vehicleDao.getAllVehicles();
			for (Vehicle vehicle : list2) {

				VehicleDto dto = new VehicleDto();
				dto.setCat(vehicle.getCat());
				dto.setDailyRent(vehicle.getDailyRent());
				dto.setDescription(vehicle.getDescription());
				dto.setFuelType(vehicle.getFuelType());
				dto.setManufacturer(vehicle.getManufacturer());
				dto.setMileage(vehicle.getMileage());
				dto.setRegNo(vehicle.getRegNo());
				list.add(dto);
			}
		} catch (DaoException e) {
			logger.error(
					"hey error generated in getting all vehicles list in Vehicle Service please check your code!!!!!",
					e);
		}
		return list;
	}

}
