/**
 * 
 */
package com.mindtree.vehiclebusiness.exception;

/**
 * @author M1018339
 * 
 */
public class DaoException extends Exception {

	/*
	 * (DAO-Data Access Object) DAOException is a custom exception that help to
	 * identify the errors/exceptions in DAO.
	 */
	private static final long serialVersionUID = -495652895845573071L;

	public DaoException() {
		super();

	}

	public DaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public DaoException(String arg0) {
		super(arg0);

	}

	public DaoException(Throwable arg0) {
		super(arg0);

	}

}
