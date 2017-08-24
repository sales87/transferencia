package com.br.felipe.transferencia.service.exception;

public class ValorInvalidoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7947735339645694807L;

	public ValorInvalidoException(String message){
		super(message);
	}
	
	public ValorInvalidoException(String message, Throwable causa){
		super(message, causa);
	}
}
