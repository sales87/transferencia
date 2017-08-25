package com.br.felipe.transferencia.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.felipe.transferencia.domain.Conta;
import com.br.felipe.transferencia.service.ContaSerivce;

@RestController
@RequestMapping("/conta")
public class ContaResource {
	
	@Autowired
	private ContaSerivce contaService;
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Conta>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(contaService.listar());	
	}

}
