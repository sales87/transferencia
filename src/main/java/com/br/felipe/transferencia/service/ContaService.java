package com.br.felipe.transferencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.felipe.transferencia.domain.Conta;
import com.br.felipe.transferencia.domain.Transferencia;
import com.br.felipe.transferencia.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	public List<Conta> listar(){
		return contaRepository.findAll();
	}
}
