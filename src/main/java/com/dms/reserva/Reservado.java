package com.dms.reserva;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Reservado - representa um período com uma entrada e uma saída
 * 
 * @author Diorgenes Morais
 *
 */
public class Reservado implements Serializable {

	private static final long serialVersionUID = -1425885773819823452L;
	private LocalDate entrada;
	private LocalDate saida;

	/**
	 * Criar uma reserva
	 * 
	 * @param entrada data de entrada da reserva.
	 * @param saida   data de saída.
	 */
	public Reservado(LocalDate entrada, LocalDate saida) {
		if (entrada == null || saida == null) {
			throw new NullPointerException("Nenhum parâmetro pode ser nulo - informe as datas");
		}
		this.entrada = entrada;
		this.saida = saida;
	}

	/**
	 * É disponível - verifica se esta data está disponível.
	 * 
	 * @param entrar data de início.
	 * @param sair   data de saída.
	 * @return verdadeiro se o período estiver disponível (data não foi reservada).
	 */
	public boolean isDisponivel(LocalDate entrar, LocalDate sair) {
		if (entrar.isBefore(entrada) && (sair.isBefore(entrada) || sair.isEqual(entrada))) {
			return true;
		}
		if (entrar.isEqual(saida) || entrar.isAfter(saida)) {
			return true;
		}
		return false;
	}

	/**
	 * Obter quantos dias
	 * 
	 * @return a diferença de dias entre as duas datas.
	 */
	public Long getDias() {
		return ChronoUnit.DAYS.between(this.entrada, this.saida);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entrada == null) ? 0 : entrada.hashCode());
		result = prime * result + ((saida == null) ? 0 : saida.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservado other = (Reservado) obj;
		if (entrada == null) {
			if (other.entrada != null)
				return false;
		} else if (!entrada.equals(other.entrada))
			return false;
		if (saida == null) {
			if (other.saida != null)
				return false;
		} else if (!saida.equals(other.saida))
			return false;
		return true;
	}

}
