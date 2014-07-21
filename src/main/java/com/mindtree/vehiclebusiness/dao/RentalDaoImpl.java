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
import com.mindtree.vehiclebusiness.entity.Login;
import com.mindtree.vehiclebusiness.entity.Vehicle;
import com.mindtree.vehiclebusiness.exception.DaoException;

/**
 * @author M1018339
 * 
 */
/*
 * this class implements the interface Rental Dao. It contains the hibernate
 * queries which are necessary to persist or fetch the data from database
 */
public class RentalDaoImpl implements RentalDao {

	/*public HibernateTemplate hibernateTemplate;

	private Logger logger = Logger.getLogger(RentalDaoImpl.class.getName());

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);

	}

	
	 * persists the vehicle into database
	 
	@Override
	public void addVehicle(Vehicle v) throws DaoException {
		try {
			hibernateTemplate.save(v);
		} catch (Exception e) {
			logger.error("Unable to save vehicle detail", e);
			throw new DaoException(e);
		}
	}

	
	 * persists the booking information into database.
	 
	@Override
	public void bookVehicle(Booking b) throws DaoException {
		try {
			hibernateTemplate.save(b);
		} catch (Exception e) {
			logger.error("Unable to save booking detail", e);
			throw new DaoException(e);
		}
	}

	
	 * fetches the number of vehicles based on category from vehicles
	 
	@Override
	public List<Object[]> getReport() throws DaoException {
		try {
			return hibernateTemplate
					.find("select cat, count(cat) from Vehicle group by cat order by cat");
		} catch (Exception e) {
			logger.error("Unable to fetch vehicle detail", e);
			throw new DaoException(e);
		}
	}

	
	 * fetches the number of booking for a vehicle based on category and also
	 * fetches the total rent earned.
	 
	@Override
	public List<Object[]> getReport2() throws DaoException {
		try {
			return hibernateTemplate
					.find("select category, count(id), sum(totalRent) from Booking group by category order by category");
		} catch (Exception e) {
			logger.error("Unable to fetch booking detail", e);
			throw new DaoException(e);
		}
	}

	
	 * fetches the registration number of vehicles of a particular category from
	 * database
	 
	@Override
	public List<String> populateVehicles(String categ) throws DaoException {
		try {
			return hibernateTemplate
					.find("select regNo from Vehicle where cat='" + categ + "'");
		} catch (Exception e) {
			throw new DaoException();
		}
	}

	
	 * fetches the daily rent of a particular vehicle based on the registration
	 * number
	 
	@Override
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

	
	 * fetches all the categories of vehicles from database
	 
	@Override
	public List<Vehicle> getAllVehicles() throws DaoException {
		try {
			return hibernateTemplate.find("from Vehicle");
		} catch (HibernateException e) {
			logger.error("Unable to fetch list of vehicles", e);
			throw new DaoException(e);
		}

	}

	
	 * persists the login information of users into database
	 
	@Override
	public void addUser(Login login) throws DaoException {
		try {
			hibernateTemplate.save(login);
		} catch (Exception e) {
			logger.error("Unable to save user detail", e);
			throw new DaoException(e);
		}

	}

	
	 * fetches the information of all users from database
	 
	@Override
	public List<Login> getAllUsers() throws DaoException {
		try {
			return hibernateTemplate.find("from Login");
		} catch (HibernateException e) {
			logger.error("Unable to fetch user detail", e);
			throw new DaoException(e);
		}
	}*/
}
