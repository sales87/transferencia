package com.br.felipe.transferencia.resource;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.felipe.transferencia.domain.Transferencia;
import com.br.felipe.transferencia.service.TransferenciaService;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaResource {

	@Autowired
	private TransferenciaService transferenciaService;
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Transferencia>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.listar());	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Transferencia transferencia){
		transferencia = transferenciaService.gravar(transferencia);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transferencia.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Transferencia> buscar(@PathVariable("id") Long id){
		Transferencia transferencia = transferenciaService.buscar(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(transferencia);
	}
}
