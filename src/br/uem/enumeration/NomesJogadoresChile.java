package br.uem.enumeration;

/**
 * Define os nomes dos jogadores do Chile
 * 
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public enum NomesJogadoresChile {
	VIDAL("Vidal", true), VARGAS("Vargas", true), MEDEL("Medel", true), VALDIVIA(
			"Valdivia", true), JARA("Jara", true), ISLA("Isla", true), MENA(
			"Mena", true), PIZARRO("Pizarro", true), RABELLO("Rabello", true), RUBIO(
			"Rubio", true), CB("Claudio Bravo", false);

	private final String nome;
	private final Boolean isBatedor;

	@Override
	public String toString() {
		return nome;
	}

	private NomesJogadoresChile(String nome, Boolean isBatedor) {
		this.nome = nome;
		this.isBatedor = isBatedor;
	}

	public Boolean getIsBatedor() {
		return isBatedor;
	}
}
