package com.dms.reserva;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReservaImpl {

	public static void main(String[] args) {
		// reservsado 30/11 a 01/12
		Reserva r1 = new Reserva();
		r1.setId(1);
		r1.setEntrada(LocalDate.of(2019, 11, 30));
		r1.setSaida(LocalDate.of(2019, 12, 01));
		// reservado 03/12 a 04/12
		Reserva r2 = new Reserva();
		r2.setId(2);
		r2.setEntrada(LocalDate.of(2019, 12, 03));
		r2.setSaida(LocalDate.of(2019, 12, 04));

		List<Reserva> reservas = Arrays.asList(r1, r2);

		// reservar de 30/11 a 01/12
		LocalDate entrar = LocalDate.of(2019, 11, 30);
		LocalDate sair = LocalDate.of(2019, 12, 1);

		// retorna a reserva
		Optional<Reserva> reserva1 = reservas.stream().filter(r -> {
			Reservado reservado = new Reservado(r.getEntrada(), r.getSaida());
			return !reservado.isDisponivel(entrar, sair);
		}).findAny();

		// Está disponível?
		System.out.println(reserva1.isEmpty());

		// reservar de 1/12 a 2/12
		LocalDate entrar2 = LocalDate.of(2019, 12, 1);
		LocalDate sair2 = LocalDate.of(2019, 12, 2);

		Optional<Reserva> reserva2 = reservas.stream().filter(r -> {
			Reservado reservado = new Reservado(r.getEntrada(), r.getSaida());
			return !reservado.isDisponivel(entrar2, sair2);
		}).findFirst();

		// Está disponível?
		System.out.println(reserva2.isEmpty());

	}

}
