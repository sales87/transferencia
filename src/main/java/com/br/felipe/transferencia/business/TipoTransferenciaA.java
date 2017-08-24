package com.br.felipe.transferencia.business;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.br.felipe.transferencia.domain.Transferencia;
import com.br.felipe.transferencia.service.exception.ValorInvalidoException;

public class TipoTransferenciaA implements TipoTransferencia {

	@Override
	public BigDecimal calculaTaxa(Transferencia transferencia) {

		if(transferencia.getValor().compareTo(BigDecimal.ZERO) <=0 ){
			throw new ValorInvalidoException("O valor é negativo ou igual a 0.");
		}
		
		BigDecimal tresPorcento = transferencia.getValor().multiply(
				new BigDecimal(0.03)).setScale(2, RoundingMode.HALF_UP);
		
		return tresPorcento.add(new BigDecimal(2));
	}

}
