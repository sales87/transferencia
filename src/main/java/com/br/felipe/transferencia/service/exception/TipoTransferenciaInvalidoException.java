package com.br.felipe.transferencia.service.exception;

public class TipoTransferenciaInvalidoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7175411400242993148L;

	public TipoTransferenciaInvalidoException(String message){
		super(message);
	}
	
	public TipoTransferenciaInvalidoException(String message, Throwable causa){
		super(message, causa);
	}
}
