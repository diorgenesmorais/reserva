package com.dms.reserva;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class ReservadoTest {

private Reservado reservado;

	@Before
	public void before() {
		reservado = new Reservado(LocalDate.of(2019, 11, 30), LocalDate.of(2019, 12, 2));
	}

	@Test
	public void deveSerAMesmaReservar() throws Exception {
		Reservado outra = new Reservado(LocalDate.of(2019, 11, 30), LocalDate.of(2019, 12, 2));
		
		assertTrue(reservado.equals(outra));
	}
	
	@Test
	public void deveEstarDisponivelAntesDaReserva() throws Exception {
		LocalDate entrar = LocalDate.of(2019, 11, 29);
		LocalDate sair = LocalDate.of(2019, 11, 30);
		// reservado de 30/11 a 02/12
		// entrar 29/11 e sair 30/11
		assertTrue(reservado.isDisponivel(entrar, sair));
	}
	
	@Test
	public void deveEstarDisponivelAposReserva() throws Exception {
		LocalDate entrar = LocalDate.of(2019, 12, 2);
		LocalDate sair = LocalDate.of(2019, 12, 3);
		// reservado de 30/11 a 02/12
		// entrar 2/12 e sair 3/12
		assertTrue(reservado.isDisponivel(entrar, sair));
	}
	
	@Test
	public void naoDeveEstarDisponivel() throws Exception {
		LocalDate entrar = LocalDate.of(2019, 11, 30);
		LocalDate sair = LocalDate.of(2019, 12, 1);
		// reservado de 30/11 a 02/12
		// entrar 30/11 e sair 1/12
		assertFalse(reservado.isDisponivel(entrar, sair));
	}
	
	@Test
	public void deveEstarReservado() throws Exception {
		LocalDate entrar = LocalDate.of(2019, 11, 29);
		LocalDate sair = LocalDate.of(2019, 12, 1);
		// reservado de 30/11 a 02/12
		// entrar 29/11 e sair 01/12
		assertFalse(reservado.isDisponivel(entrar, sair));
	}
}
