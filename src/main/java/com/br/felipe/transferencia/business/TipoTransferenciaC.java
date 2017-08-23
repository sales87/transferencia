package com.br.felipe.transferencia.business;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import com.br.felipe.transferencia.domain.Transferencia;

public class TipoTransferenciaC implements TipoTransferencia {

	@Override
	public BigDecimal calculaTaxa(Transferencia transferencia) {
		
		LocalDate dataAgendada = transferencia.getDataAgendamento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); 
		LocalDate hoje = LocalDate.now();
		Period period = Period.between(dataAgendada, hoje);
		
		if(period.getDays() <= 5){
			return new BigDecimal(0.083);
		}else if(period.getDays() <= 10){
			return new BigDecimal(0.074);
		}else if(period.getDays() <= 15){
			return new BigDecimal(0.067);
		}else if(period.getDays() <= 20){
			return new BigDecimal(0.054);
		}else if(period.getDays() <= 25){
			return new BigDecimal(0.043);
		}else if(period.getDays() <= 30){
			return new BigDecimal(0.021);
		}else{
			return new BigDecimal(0.012);
		}
	}

}
