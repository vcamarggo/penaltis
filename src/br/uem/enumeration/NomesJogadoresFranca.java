package br.uem.enumeration;

/**
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public enum NomesJogadoresFranca {
	HENRY("Henry"), ZIDANE("Zidane"), DESCHAMPS("Deschamps"), BENZEMA("Benzema"), PLATINI(
			"Platini"), BLANC("Blanc"), POGBA("Pogba"), VALBUENA("Valbuena"), VIERA(
			"Viera"), CANTONA("Cantona");

	private final String nome;

	@Override
	public String toString() {
		return nome;
	}

	private NomesJogadoresFranca(String nome) {
		this.nome = nome;
	}
}
