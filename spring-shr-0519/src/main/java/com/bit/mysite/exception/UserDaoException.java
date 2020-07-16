package com.bit.mysite.exception;

public class UserDaoException extends RuntimeException{

	private static final long serialVersionUID = 3609157017229644896L;
	
	public UserDaoException() {
		super("User Not Found");
	}
}
