package com.br.felipe.transferencia.business;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.br.felipe.transferencia.domain.Transferencia;

public class TipoTransferenciaB implements TipoTransferencia {

	@Override
	public BigDecimal calculaTaxa(Transferencia transferencia) {

		Calendar calAgendado = Calendar.getInstance();
		calAgendado.setTime(transferencia.getDataAgendamento());
		calAgendado.add(Calendar.DAY_OF_YEAR, -30);
		
		if(calAgendado.before(new Date())){
			return new BigDecimal(10);
		}else{
			return new BigDecimal(8);
		}
	}

}
