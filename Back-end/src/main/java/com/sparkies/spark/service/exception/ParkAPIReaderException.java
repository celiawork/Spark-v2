package com.sparkies.spark.service.exception;

public class ParkAPIReaderException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParkAPIReaderException() {
		super();
		
	}

	public ParkAPIReaderException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ParkAPIReaderException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ParkAPIReaderException(String message) {
		super(message);
		
	}

	public ParkAPIReaderException(Throwable cause) {
		super(cause);
		
	}

}
