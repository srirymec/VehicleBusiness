/**
 * 
 */
package com.mindtree.vehiclebusiness.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.vehiclebusiness.controller.RentalController;
import com.mindtree.vehiclebusiness.dao.BookingDao;
import com.mindtree.vehiclebusiness.dto.BookingDto;
import com.mindtree.vehiclebusiness.dto.ValueObject;
import com.mindtree.vehiclebusiness.dto.VehicleDto;
import com.mindtree.vehiclebusiness.entity.Booking;
import com.mindtree.vehiclebusiness.entity.Vehicle;
import com.mindtree.vehiclebusiness.exception.DaoException;
import com.mindtree.vehiclebusiness.exception.ServiceException;

/**
 * @author M1018439
 * 
 */
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;

	/*
	 * Logger is used as custom information for admin. We can check errors in
	 * file in tomcat.
	 */
	private Logger logger = Logger
			.getLogger(BookingServiceImpl.class.getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mindtree.vehiclebusiness.service.BookingService#bookVehicle(com.mindtree
	 * .vehiclebusiness.entity.Booking)
	 */
	public void bookVehicle(BookingDto b) throws ServiceException {

		try {
			Booking booking = new Booking();
			booking.setBookedFrom(b.getBookedFrom());
			booking.setBookedTo(b.getBookedTo());
			booking.setCategory(b.getCategory());
			booking.setCustName(b.getCustName());
			booking.setEmailId(b.getEmailId());
			booking.setId(b.getId());
			booking.setIsPaid(b.getIsPaid());
			booking.setTotalRent(b.getTotalRent());
			booking.setRegNo(b.getRegNo());

			Vehicle vehicle = new Vehicle();
			VehicleDto v = b.getVehicle();
			vehicle.setCat(v.getCat());
			vehicle.setDailyRent(v.getDailyRent());
			vehicle.setDescription(v.getDescription());
			vehicle.setFuelType(v.getFuelType());
			vehicle.setManufacturer(v.getManufacturer());
			vehicle.setMileage(v.getMileage());
			vehicle.setRegNo(v.getRegNo());
			booking.setVehicle(vehicle);

			bookingDao.bookVehicle(booking);
		} catch (DaoException e) {
			logger.error(
					"hey error generated in getting booking list from Booking Service please check your code!!!!!",
					e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mindtree.vehiclebusiness.service.BookingService#getReport()
	 */
	public List<ValueObject> getReport() throws ServiceException {
		List<ValueObject> ret = new ArrayList<ValueObject>();
		try {
			List<Object[]> a1 = bookingDao.getReport();
			List<Object[]> a2 = bookingDao.getReport2();
			for (Object[] o1 : a1) {
				ValueObject vo = new ValueObject();
				vo.setCat((String) o1[0]);
				vo.setTotalVeh((Long) o1[1]);
				ret.add(vo);
			}
			for (Object[] o2 : a2) {
				for (ValueObject sel : ret) {
					if (sel.getCat().equals(o2[0])) {
						sel.setTotalRented((Long) o2[1]);
						sel.setTotalEarned((Double) o2[2]);
					}
				}
			}
			return ret;
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

}
