package br.uem.enumeration;

/**
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public enum NomesJogadoresArgentina {
	MARADONA("Maradona"), MESSI("Messi"), MASCHERANO("Mascherano"), LAVEZZI(
			"Lavezzi"), ROJO("Rojo"), BATISTUTA("Batistuta"), SABELLA("Sabella"), GAGO(
			"Gago"), CANIGGIA("Caniggia"), RIQUELME("Riquelme");

	private final String nome;

	@Override
	public String toString() {
		return nome;
	}

	private NomesJogadoresArgentina(String nome) {
		this.nome = nome;
	}
}
