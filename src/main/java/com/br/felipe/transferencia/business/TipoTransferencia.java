package com.br.felipe.transferencia.business;

import java.math.BigDecimal;

import com.br.felipe.transferencia.domain.Transferencia;

public interface TipoTransferencia {

	BigDecimal calculaTaxa(Transferencia transferencia);
}
