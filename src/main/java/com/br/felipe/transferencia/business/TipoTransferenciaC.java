package com.br.felipe.transferencia.business;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
			return transferencia.getValor().multiply(new BigDecimal(0.083)).setScale(2, RoundingMode.HALF_UP);
		}else if(diferenca <= 10){
			return transferencia.getValor().multiply(new BigDecimal(0.074)).setScale(2, RoundingMode.HALF_UP);
		}else if(diferenca <= 15){
			return transferencia.getValor().multiply(new BigDecimal(0.067)).setScale(2, RoundingMode.HALF_UP);
		}else if(diferenca <= 20){
			return transferencia.getValor().multiply(new BigDecimal(0.054)).setScale(2, RoundingMode.HALF_UP);
		}else if(diferenca <= 25){
			return transferencia.getValor().multiply(new BigDecimal(0.043)).setScale(2, RoundingMode.HALF_UP);
		}else if(diferenca <= 30){
			return transferencia.getValor().multiply(new BigDecimal(0.021)).setScale(2, RoundingMode.HALF_UP);
		}else{
			return transferencia.getValor().multiply(new BigDecimal(0.012)).setScale(2, RoundingMode.HALF_UP);
		}
	}

}
