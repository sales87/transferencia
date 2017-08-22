package com.br.felipe.transferencia.business;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.br.felipe.transferencia.domain.Transferencia;

public class TipoTransferenciaA implements TipoTransferencia {

	@Override
	public BigDecimal calculaTaxa(Transferencia transferencia) {

		BigDecimal tresPorcento = transferencia.getValor().multiply(
				new BigDecimal(0.03)).setScale(2, RoundingMode.HALF_UP);
		
		return tresPorcento.add(new BigDecimal(2));
	}

}
