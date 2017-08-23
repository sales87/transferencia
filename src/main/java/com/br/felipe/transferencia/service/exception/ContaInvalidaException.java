package com.br.felipe.transferencia.service.exception;

public class ContaInvalidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3088646657145452096L;

	public ContaInvalidaException(String message){
		super(message);
	}
	
	public ContaInvalidaException(String message, Throwable causa){
		super(message, causa);
	}
}
