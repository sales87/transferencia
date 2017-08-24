package com.br.felipe.transferencia.service.exception;

public class DataInvalidaException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1727133832517406655L;

	public DataInvalidaException(String message){
		super(message);
	}
	
	public DataInvalidaException(String message, Throwable causa){
		super(message, causa);
	}
}
