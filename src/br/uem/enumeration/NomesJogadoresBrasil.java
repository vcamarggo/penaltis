package br.uem.enumeration;

/**
 * Define os nomes dos jogadores do Brasil
 * 
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public enum NomesJogadoresBrasil {
	CHULAPA("Chulapa", true), CASAGRANDE("Casagrande", true), BALTAZAR(
			"Baltazar", true), PELE("Pelé", true), RIVELLINO("Rivellino", true), SOCRATES(
			"Sócrates", true), ZICO("Zico", true), NEYMAR("Neymar", true), RONALDO(
			"Ronaldo", true), RIVALDO("Rivaldo", true), JL("Júlio César", false);

	private final String nome;
	private final Boolean isBatedor;

	@Override
	public String toString() {
		return nome;
	}

	private NomesJogadoresBrasil(String nome, Boolean isBatedor) {
		this.nome = nome;
		this.isBatedor = isBatedor;
	}

	public Boolean getIsBatedor() {
		return isBatedor;
	}
}
