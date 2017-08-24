package com.br.felipe.transferencia.business;

import java.math.BigDecimal;

import com.br.felipe.transferencia.domain.Transferencia;

public class CalculadoraTaxa {

	public static BigDecimal calculaTaxa(Transferencia transferencia, TipoTransferencia tipoTransferencia){
		return tipoTransferencia.calculaTaxa(transferencia);
	}
}
