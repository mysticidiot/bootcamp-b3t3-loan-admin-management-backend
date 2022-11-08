package com.b3t3.loanAdminManagement.Exception;

public class IdDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4518275208184345518L;
	
	public IdDoesNotExistException() {
		super("Object with given ID does not exist");
	}

}
