package com.mindtree.vehiclebusiness.exception;

/*
 * ServiceException is a custom exception that help to identify the errors/exceptions in service layer.
 * */
public class ServiceException extends DaoException {

	/**
	 * 
	 * @author M1018339
	 */

	private static final long serialVersionUID = 6169599342085451086L;

	public ServiceException() {
		super();

	}

	public ServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public ServiceException(String arg0) {
		super(arg0);

	}

	public ServiceException(Throwable arg0) {
		super(arg0);

	}

}
