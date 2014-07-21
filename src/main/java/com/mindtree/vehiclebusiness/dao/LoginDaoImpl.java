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

import com.mindtree.vehiclebusiness.entity.Login;
import com.mindtree.vehiclebusiness.exception.DaoException;

/**
 * @author M1018439
 *
 */
public class LoginDaoImpl implements LoginDao {

	/* (non-Javadoc)
	 * @see com.mindtree.vehiclebusiness.dao.LoginDao#addUser(com.mindtree.vehiclebusiness.entity.Login)
	 */
	
	
	public HibernateTemplate hibernateTemplate;

	private Logger logger = Logger.getLogger(LoginDaoImpl.class.getName());

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);

	}

	
	
	/*
	 * persists the login information of users into database
	 */
	public void addUser(Login login) throws DaoException {
		try {
			hibernateTemplate.save(login);
		} catch (Exception e) {
			logger.error("Unable to save user detail", e);
			throw new DaoException(e);
		}

	}

	/*
	 * fetches the information of all users from database
	 */
	public List<Login> getAllUsers() throws DaoException {
		try {
			List<Login> list=(List<Login>)hibernateTemplate.find("from Login");
			if(list!=null){
			return list;
			}
			else{
				return null;
			}
		} catch (HibernateException e) {
			logger.error("Unable to fetch user detail", e);
			//throw new DaoException(e);
			return null;
		}
	}

}
