package com.br.felipe.transferencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.felipe.transferencia.business.CalculadoraTaxa;
import com.br.felipe.transferencia.business.TipoTransferencia;
import com.br.felipe.transferencia.domain.Conta;
import com.br.felipe.transferencia.domain.Transferencia;
import com.br.felipe.transferencia.factory.TipoTransferenciaFactory;
import com.br.felipe.transferencia.repository.ContaRepository;
import com.br.felipe.transferencia.repository.TransferenciaRepository;
import com.br.felipe.transferencia.service.exception.ContaInvalidaException;
import com.br.felipe.transferencia.service.exception.SaldoInsuficienteException;
import com.br.felipe.transferencia.service.exception.TransferenciaNaoEncontradaException;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository transferenciaRepository;
	@Autowired
	private ContaRepository contaRepository;
	
	public List<Transferencia> listar(){
		return transferenciaRepository.findAll();
	}
	
	public Transferencia buscar(Long id) throws TransferenciaNaoEncontradaException{
		Transferencia transferencia = transferenciaRepository.findOne(id);
		if(transferencia == null){
			throw new TransferenciaNaoEncontradaException("Transferência não encontrada");
		}
		return transferencia;
	}
	
	public Transferencia gravar(Transferencia transferencia) throws ContaInvalidaException, SaldoInsuficienteException{
		transferencia.setId(null);
		
		TipoTransferencia tipoTransferencia = TipoTransferenciaFactory.getTipoTransferencia(transferencia.getTipo());
		transferencia.setTaxa(CalculadoraTaxa.calculaTaxa(transferencia, tipoTransferencia));
		
		Conta contaOrigem = contaRepository.findOne(transferencia.getContaOrigem().getId());
		Conta contaDestino = contaRepository.findOne(transferencia.getContaDestino().getId());
		
		if(contaOrigem == null || contaDestino ==  null){
			throw new ContaInvalidaException("Conta de origem e/ou destino inválida");
		}
		if(contaOrigem.getSaldo().compareTo(transferencia.getValor().multiply(transferencia.getTaxa())) > 0){
			throw new SaldoInsuficienteException("Saldo insuficiente para fazer a transferência");
		}
		
		transferencia = transferenciaRepository.save(transferencia);

		return transferencia;
	}
}
