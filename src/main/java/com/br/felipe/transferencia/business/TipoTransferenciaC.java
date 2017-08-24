package com.br.felipe.transferencia.business;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import com.br.felipe.transferencia.domain.Transferencia;
import com.br.felipe.transferencia.service.exception.DataInvalidaException;

public class TipoTransferenciaC implements TipoTransferencia {

	@Override
	public BigDecimal calculaTaxa(Transferencia transferencia) {
		
		LocalDate dataAgendada = transferencia.getDataAgendamento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); 
		LocalDate hoje = LocalDate.now();
		long diferenca = ChronoUnit.DAYS.between(hoje, dataAgendada);

		if(diferenca < 0){
			throw new DataInvalidaException("Data inválida");
		}
		
		if(diferenca <= 5){
			return new BigDecimal(0.083);
		}else if(diferenca <= 10){
			return new BigDecimal(0.074);
		}else if(diferenca <= 15){
			return new BigDecimal(0.067);
		}else if(diferenca <= 20){
			return new BigDecimal(0.054);
		}else if(diferenca <= 25){
			return new BigDecimal(0.043);
		}else if(diferenca <= 30){
			return new BigDecimal(0.021);
		}else{
			return new BigDecimal(0.012);
		}
	}

}
