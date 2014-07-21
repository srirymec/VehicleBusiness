/**
 * 
 */
package com.mindtree.vehiclebusiness.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mindtree.vehiclebusiness.entity.Booking;
import com.mindtree.vehiclebusiness.exception.DaoException;

/**
 * @author M1018439
 * 
 */
public class BookingDaoImpl implements BookingDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mindtree.vehiclebusiness.dao.BookingDao#bookVehicle(com.mindtree.
	 * vehiclebusiness.entity.Booking)
	 */

	public HibernateTemplate hibernateTemplate;

	private Logger logger = Logger.getLogger(BookingDaoImpl.class.getName());

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	/*
	 * fetches the number of vehicles based on category from vehicles
	 */
	public List<Object[]> getReport() throws DaoException {
		try {
			return hibernateTemplate
					.find("select cat, count(cat) from Vehicle group by cat order by cat");
		} catch (Exception e) {
			logger.error("Unable to fetch vehicle detail", e);
			throw new DaoException(e);

		}
	}

	/*
	 * fetches the number of booking for a vehicle based on category and also
	 * fetches the total rent earned.
	 */
	public List<Object[]> getReport2() throws DaoException {
		try {
			return hibernateTemplate
					.find("select category, count(id), sum(totalRent) from Booking group by category order by category");
		} catch (Exception e) {
			logger.error("Unable to fetch booking detail", e);
			throw new DaoException(e);
		}
	}

	/*
	 * persists the booking information into database.
	 */

	public void bookVehicle(Booking b) throws DaoException {
		try {
			hibernateTemplate.save(b);
		} catch (Exception e) {
			logger.info("---------------------------------");
			logger.error("Unable to save booking detail", e);
			logger.info("---------------------------------");
			throw new DaoException(e);
		}
	}

}
