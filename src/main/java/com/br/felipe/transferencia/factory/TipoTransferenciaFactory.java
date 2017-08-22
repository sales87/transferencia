package com.br.felipe.transferencia.factory;

import com.br.felipe.transferencia.business.TipoTransferencia;
import com.br.felipe.transferencia.business.TipoTransferenciaA;
import com.br.felipe.transferencia.business.TipoTransferenciaB;
import com.br.felipe.transferencia.business.TipoTransferenciaC;
import com.br.felipe.transferencia.business.TipoTransferenciaD;

public class TipoTransferenciaFactory {

	public TipoTransferencia getTipoTransferencia(String tipo){
		switch(tipo){
		case "A":
			return new TipoTransferenciaA();
		case "B":
			return new TipoTransferenciaB();
		case "C":
			return new TipoTransferenciaC();
		case "D":
			return new TipoTransferenciaD();
		default:
			throw new RuntimeException("Tipo inválido.");
		}
	}
}
