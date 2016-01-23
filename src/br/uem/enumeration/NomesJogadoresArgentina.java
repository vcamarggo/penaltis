package br.uem.enumeration;

/**
 * Define os nomes dos jogadores da Argentina
 * 
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public enum NomesJogadoresArgentina {
	MARADONA("Maradona", true), MESSI("Messi", true), MASCHERANO("Mascherano",
			true), LAVEZZI("Lavezzi", true), TEVEZ("Tevez", true), BATISTUTA(
			"Batistuta", true), SABELLA("Sabella", true), GAGO("Gago", true), CANIGGIA(
			"Caniggia", true), RIQUELME("Riquelme", true), ROJO("Rojo", false);

	private final String nome;
	private final Boolean isBatedor;

	@Override
	public String toString() {
		return nome;
	}

	private NomesJogadoresArgentina(String nome, Boolean isBatedor) {
		this.nome = nome;
		this.isBatedor = isBatedor;
	}

	public Boolean getIsBatedor() {
		return isBatedor;
	}
}
