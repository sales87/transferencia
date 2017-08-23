package com.br.felipe.transferencia.business;

import java.math.BigDecimal;

import com.br.felipe.transferencia.domain.Transferencia;

public class TipoTransferenciaD implements TipoTransferencia {

	@Override
	public BigDecimal calculaTaxa(Transferencia transferencia) {
		TipoTransferencia tipoTransferencia;
		
		if(transferencia.getValor().compareTo(new BigDecimal(25000)) <= 0){
			tipoTransferencia = new TipoTransferenciaA();
		} else if(transferencia.getValor().compareTo(new BigDecimal(120000)) <= 0){
			tipoTransferencia = new TipoTransferenciaB();
		} else {
			tipoTransferencia = new TipoTransferenciaC();
		}
		
		return tipoTransferencia.calculaTaxa(transferencia);
	}

}
