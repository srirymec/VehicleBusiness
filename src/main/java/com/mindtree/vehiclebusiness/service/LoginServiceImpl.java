/**
 * 
 */
package com.mindtree.vehiclebusiness.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.vehiclebusiness.controller.RentalController;
import com.mindtree.vehiclebusiness.dao.LoginDao;
import com.mindtree.vehiclebusiness.dto.LoginDto;
import com.mindtree.vehiclebusiness.entity.Login;
import com.mindtree.vehiclebusiness.exception.DaoException;
import com.mindtree.vehiclebusiness.exception.ServiceException;

/**
 * @author M1018439
 * 
 */
public class LoginServiceImpl implements LoginService {

	public static String ADMIN_USERNAME = Admin.getString("ADMIN_USERNAME"); //$NON-NLS-1$
	public static String ADMIN_PASSWORD = Admin.getString("ADMIN_PASSWORD"); //$NON-NLS-1$

	@Autowired
	private LoginDao loginDao;

	/*
	 * Logger is used as custom information for admin. We can check errors in
	 * file in tomcat.
	 */
	private Logger logger = Logger.getLogger(LoginServiceImpl.class.getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mindtree.vehiclebusiness.service.LoginService#getusers()
	 */
	public List<LoginDto> getusers() throws ServiceException {
		List<Login> Llist = new ArrayList<Login>();

		List<LoginDto> listDto = new ArrayList<LoginDto>();
		try {
			Llist = loginDao.getAllUsers();
			if (Llist != null) {
				for (Login login : Llist) {
					LoginDto l = new LoginDto();
					l.setUsername(login.getUsername());
					l.setPassword(login.getPassword());
					l.setLoginId(login.getLoginId());
					listDto.add(l);
				}
			}

			LoginDto l = new LoginDto();
			l.setUsername(ADMIN_USERNAME);
			l.setPassword(ADMIN_PASSWORD);
			listDto.add(l);
			return listDto;
		} catch (DaoException e) {
			logger.error(
					"hey error generated in getting user in Login Dto list please check your code!!!!!",
					e);
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mindtree.vehiclebusiness.service.LoginService#addUser(com.mindtree
	 * .vehiclebusiness.entity.Login)
	 */
	public void addUser(LoginDto login) throws ServiceException {
		try {
			Login login2 = new Login();
			login2.setLoginId(login.getLoginId());
			login2.setUsername(login.getUsername());
			login2.setPassword(login.getPassword());
			login2.setConfirmPassword(login.getConfirmPassword());
			login2.setEmail(login.getEmail());
			login2.setMobileNo(login.getMobileNo());
			loginDao.addUser(login2);
		} catch (DaoException e) {
			logger.error(
					"hey error generated in adding user in Login DTO list please check your code!!!!!",
					e);
		}
	}

}
