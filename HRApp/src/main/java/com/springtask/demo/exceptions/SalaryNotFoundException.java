package com.springtask.demo.exceptions;

public class SalaryNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SalaryNotFoundException(String message) {
	        super(message);
	}

}
