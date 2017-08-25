package com.br.felipe.transferencia.service.exception;

public class TransferenciaNaoEncontradaException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -768656981865345652L;

	public TransferenciaNaoEncontradaException(String message){
		super(message);
	}
	
	public TransferenciaNaoEncontradaException(String message, Throwable causa){
		super(message, causa);
	}
}
