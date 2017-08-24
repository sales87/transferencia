package com.br.felipe.transferencia.factory;

import com.br.felipe.transferencia.business.TipoTransferencia;
import com.br.felipe.transferencia.business.TipoTransferenciaA;
import com.br.felipe.transferencia.business.TipoTransferenciaB;
import com.br.felipe.transferencia.business.TipoTransferenciaC;
import com.br.felipe.transferencia.business.TipoTransferenciaD;
import com.br.felipe.transferencia.service.exception.TipoTransferenciaInvalidoException;

public class TipoTransferenciaFactory {

	public static TipoTransferencia getTipoTransferencia(String tipo){
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
			throw new TipoTransferenciaInvalidoException("Tipo inválido.");
		}
	}
}
