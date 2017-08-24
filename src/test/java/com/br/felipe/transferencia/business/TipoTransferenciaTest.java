package com.br.felipe.transferencia.business;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.br.felipe.transferencia.domain.Transferencia;
import com.br.felipe.transferencia.factory.TipoTransferenciaFactory;
import com.br.felipe.transferencia.service.exception.DataInvalidaException;
import com.br.felipe.transferencia.service.exception.TipoTransferenciaInvalidoException;
import com.br.felipe.transferencia.service.exception.ValorInvalidoException;


public class TipoTransferenciaTest {

	@Test(expected=TipoTransferenciaInvalidoException.class)
	public void tipoTransferenciaInvalidoTest(){
		
		TipoTransferenciaFactory.getTipoTransferencia("E");
		Assert.fail();
	}
	
	@Test
	public void calculaTaxaTipoTransferenciaATest(){
		
		Transferencia transferencia = mock(Transferencia.class);
		
		when(transferencia.getTipo()).thenReturn("A");
		when(transferencia.getValor()).thenReturn(new BigDecimal(500));
		
		TipoTransferencia tipo = TipoTransferenciaFactory.getTipoTransferencia(transferencia.getTipo());
		BigDecimal taxa = CalculadoraTaxa.calculaTaxa(transferencia, tipo);
		
		Assert.assertEquals(new BigDecimal(17).setScale(2), taxa);
	}
	
	@Test(expected=ValorInvalidoException.class)
	public void calculaTaxaTipoTransferenciaAComValorInvalidoTest(){
		Transferencia transferencia = mock(Transferencia.class);
		
		when(transferencia.getTipo()).thenReturn("A");
		when(transferencia.getValor()).thenReturn(new BigDecimal(-500));
		
		TipoTransferencia tipo = TipoTransferenciaFactory.getTipoTransferencia(transferencia.getTipo());
		CalculadoraTaxa.calculaTaxa(transferencia, tipo);
		Assert.fail();
	}
	
	@Test
	public void calculaTaxaTipoTransferenciaBDataAgendamentoMaisQue30DiasTest(){
		Transferencia transferencia = mock(Transferencia.class);
		
		when(transferencia.getTipo()).thenReturn("B");

		LocalDate localDate = LocalDate.now();
		localDate = localDate.plusDays(32);
		when(transferencia.getDataAgendamento()).thenReturn(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		TipoTransferencia tipo = TipoTransferenciaFactory.getTipoTransferencia(transferencia.getTipo());
		BigDecimal taxa = CalculadoraTaxa.calculaTaxa(transferencia, tipo);
		
		Assert.assertEquals(new BigDecimal(10), taxa);
	}
	
	@Test(expected=DataInvalidaException.class)
	public void calculaTaxaTipoTransferenciaBDataAgendamentoAnteriorDataAtualTest(){
		Transferencia transferencia = mock(Transferencia.class);
		
		when(transferencia.getTipo()).thenReturn("B");

		LocalDate localDate = LocalDate.now();
		localDate = localDate.plusDays(-2);
		when(transferencia.getDataAgendamento()).thenReturn(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		TipoTransferencia tipo = TipoTransferenciaFactory.getTipoTransferencia(transferencia.getTipo());
		CalculadoraTaxa.calculaTaxa(transferencia, tipo);
		
		Assert.fail();
	}
	
	@Test
	public void calculaTaxaTipoTransferenciaCDataAgendamentoCom7DiasTest(){
		Transferencia transferencia = mock(Transferencia.class);
		
		when(transferencia.getTipo()).thenReturn("C");

		LocalDate localDate = LocalDate.now();
		localDate = localDate.plusDays(7);
		when(transferencia.getDataAgendamento()).thenReturn(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		TipoTransferencia tipo = TipoTransferenciaFactory.getTipoTransferencia(transferencia.getTipo());
		BigDecimal taxa = CalculadoraTaxa.calculaTaxa(transferencia, tipo);
		
		Assert.assertEquals(new BigDecimal(0.074), taxa);
	}
	
	@Test(expected=DataInvalidaException.class)
	public void calculaTaxaTipoTransferenciaCDataAgendamentoAnteriorDataAtualTest(){
		Transferencia transferencia = mock(Transferencia.class);
		
		when(transferencia.getTipo()).thenReturn("C");

		LocalDate localDate = LocalDate.now();
		localDate = localDate.plusDays(-2);
		when(transferencia.getDataAgendamento()).thenReturn(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		TipoTransferencia tipo = TipoTransferenciaFactory.getTipoTransferencia(transferencia.getTipo());
		CalculadoraTaxa.calculaTaxa(transferencia, tipo);
		
		Assert.fail();
	}
	
	@Test
	public void calculaTaxaTipoTransferenciaDValorMaiorQue120000Test(){
		Transferencia transferencia = mock(Transferencia.class);
		
		when(transferencia.getTipo()).thenReturn("D");
		when(transferencia.getValor()).thenReturn(new BigDecimal(121000));

		LocalDate localDate = LocalDate.now();
		localDate = localDate.plusDays(7);
		when(transferencia.getDataAgendamento()).thenReturn(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		TipoTransferencia tipo = TipoTransferenciaFactory.getTipoTransferencia(transferencia.getTipo());
		BigDecimal taxa = CalculadoraTaxa.calculaTaxa(transferencia, tipo);
		
		Assert.assertEquals(new BigDecimal(0.074), taxa);
	}
	
	@Test(expected=ValorInvalidoException.class)
	public void calculaTaxaTipoTransferenciaDValorInvalidoTest(){
		Transferencia transferencia = mock(Transferencia.class);
		
		when(transferencia.getTipo()).thenReturn("D");
		when(transferencia.getValor()).thenReturn(BigDecimal.ZERO);

		LocalDate localDate = LocalDate.now();
		localDate = localDate.plusDays(7);
		when(transferencia.getDataAgendamento()).thenReturn(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		TipoTransferencia tipo = TipoTransferenciaFactory.getTipoTransferencia(transferencia.getTipo());
		CalculadoraTaxa.calculaTaxa(transferencia, tipo);
		
		Assert.fail();
	}
}
