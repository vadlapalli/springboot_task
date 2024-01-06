package com.springtask.demo.service.exceptions;

public class AttedanceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AttedanceNotFoundException(String msg) {
		super(msg);
	}

}
