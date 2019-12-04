package com.dms.reserva;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

		// Exibir todas as reservas
		reservas.forEach(r -> {
			Reservado re = new Reservado(r.getEntrada(), r.getSaida());
			System.out.println(re.toString());
		});

		// reservar de 30/11 a 01/12
		LocalDate entrar = LocalDate.of(2019, 11, 30);
		LocalDate sair = LocalDate.of(2019, 12, 1);

		// retorna a reserva
		Optional<Reserva> quarto1 = reservas.stream().filter(r -> {
			Reservado reservado = new Reservado(r.getEntrada(), r.getSaida());
			return !reservado.isDisponivel(entrar, sair);
		}).findAny();

		// Está disponível?
		System.out.println(quarto1.isPresent() ? "Já tem uma reserva" : "Período disponível");

		// reservar de 1/12 a 2/12
		LocalDate entrar2 = LocalDate.of(2019, 12, 1);
		LocalDate sair2 = LocalDate.of(2019, 12, 2);

		Optional<Reserva> reservado1 = reservas.stream().filter(r -> {
			Reservado reservado = new Reservado(r.getEntrada(), r.getSaida());
			return !reservado.isDisponivel(entrar2, sair2);
		}).findFirst();

		// Exibe se tem a reserva
		hasReserva(reservado1);

		// reservar de 1/12 a 2/12
		LocalDate entrar3 = LocalDate.of(2019, 12, 1);
		LocalDate sair3 = LocalDate.of(2019, 12, 5);

		tentandoReservar(entrar3, sair3);

		// retorna a primeira reserva
		Optional<Reserva> reservado2 = reservas.stream().filter(r -> {
			Reservado reservado = new Reservado(r.getEntrada(), r.getSaida());
			return !reservado.isDisponivel(entrar3, sair3);
		}).findFirst();

		hasReserva(reservado2);

	}

	private static void tentandoReservar(LocalDate entrar3, LocalDate sair3) {
		System.out.printf("Tentando reservar de %s até %s\n", entrar3.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				sair3.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}

	private static void hasReserva(Optional<Reserva> reservado1) {
		System.out.printf("Período reservado: %s\n",
				reservado1.isPresent() ? reservado1.get().getSaida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
						: "Disponível");
	}

}
