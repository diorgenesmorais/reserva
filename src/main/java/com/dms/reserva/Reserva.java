package com.dms.reserva;

import java.time.LocalDate;

/**
 * Reserva - um modelo
 * 
 * @author Diorgenes Morais
 *
 */
public class Reserva {
	private Integer id;
	private LocalDate entrada;
	private LocalDate saida;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDate entrada) {
		this.entrada = entrada;
	}

	public LocalDate getSaida() {
		return saida;
	}

	public void setSaida(LocalDate saida) {
		this.saida = saida;
	}
}
