/**
 * 
 */
package com.mindtree.vehiclebusiness.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mindtree.vehiclebusiness.entity.Booking;
import com.mindtree.vehiclebusiness.dto.LoginDto;
import com.mindtree.vehiclebusiness.entity.Vehicle;
import com.mindtree.vehiclebusiness.exception.DaoException;

/**
 * @author M1018439
 * 
 */
public class VehicleDaoImpl implements VehicleDao {

	public HibernateTemplate hibernateTemplate;

	private Logger logger = Logger.getLogger(VehicleDaoImpl.class.getName());

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);

	}

	/*
	 * persists the vehicle into database
	 */
	public void addVehicle(Vehicle v) throws DaoException {
		try {
			hibernateTemplate.save(v);
		} catch (Exception e) {
			logger.error("Unable to save vehicle detail", e);
			throw new DaoException(e);
		}
	}

	/*
	 * fetches the registration number of vehicles of a particular category from
	 * database
	 */
	public List<String> populateVehicles(String categ) throws DaoException {
		try {
			return hibernateTemplate
					.find("select regNo from Vehicle where cat='" + categ + "'");
		} catch (Exception e) {
			throw new DaoException();
		}
	}

	/*
	 * fetches the daily rent of a particular vehicle based on the registration
	 * number
	 */
	public List<Object> getDailyRent(String reg) throws DaoException {
		try {
			return hibernateTemplate
					.find("select dailyRent from Vehicle where regNo='" + reg
							+ "'");
		} catch (Exception e) {
			logger.error("Unable to fetch daily rent of a vehicle detail", e);
			throw new DaoException(e);
		}
	}

	/*
	 * fetches all the categories of vehicles from database
	 */
	public List<Vehicle> getAllVehicles() throws DaoException {
		try {
			return hibernateTemplate.find("from Vehicle");
		} catch (HibernateException e) {
			logger.error("Unable to fetch list of vehicles", e);
			throw new DaoException(e);
		}

	}

}
