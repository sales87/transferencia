package com.br.felipe.transferencia.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.br.felipe.transferencia.domain.DetalhesErro;
import com.br.felipe.transferencia.service.exception.ContaInvalidaException;
import com.br.felipe.transferencia.service.exception.SaldoInsuficienteException;
import com.br.felipe.transferencia.service.exception.TransferenciaNaoEncontradaException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ContaInvalidaException.class)
	public ResponseEntity<DetalhesErro> handleContaInvalidaException(ContaInvalidaException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Conta de origem e/ou destino inválida");
		erro.setMensagemDesenvolvedor("Avise o suporte");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(SaldoInsuficienteException.class)
	public ResponseEntity<DetalhesErro> handleSaldoInsuficienteException(SaldoInsuficienteException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Saldo insuficiente para fazer a transferência");
		erro.setMensagemDesenvolvedor("Avise o suporte");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	
	@ExceptionHandler(TransferenciaNaoEncontradaException.class)
	public ResponseEntity<DetalhesErro> handleTransferenciaNaoEncontradaException(TransferenciaNaoEncontradaException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Transferencia não encontrada");
		erro.setMensagemDesenvolvedor("Avise o suporte");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
