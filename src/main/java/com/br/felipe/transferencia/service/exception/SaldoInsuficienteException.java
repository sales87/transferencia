package com.br.felipe.transferencia.service.exception;

public class SaldoInsuficienteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2015683609304812926L;
	
	public SaldoInsuficienteException(String message){
		super(message);
	}
	
	public SaldoInsuficienteException(String message, Throwable causa){
		super(message, causa);
	}

}
