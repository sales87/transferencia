package com.br.felipe.transferencia.business;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import com.br.felipe.transferencia.domain.Transferencia;
import com.br.felipe.transferencia.service.exception.DataInvalidaException;

public class TipoTransferenciaB implements TipoTransferencia {

	@Override
	public BigDecimal calculaTaxa(Transferencia transferencia) {

		LocalDate dataAgendada = transferencia.getDataAgendamento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); 
		LocalDate hoje = LocalDate.now();
		long diferenca = ChronoUnit.DAYS.between(hoje, dataAgendada);

		if(diferenca < 0){
			throw new DataInvalidaException("Data inválida");
		}
		
		if(diferenca > 30){
			return new BigDecimal(10);
		}else{
			return new BigDecimal(8);
		}
	}

}
