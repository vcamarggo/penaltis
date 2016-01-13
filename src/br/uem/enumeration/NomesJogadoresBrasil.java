package br.uem.enumeration;

/**
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public enum NomesJogadoresBrasil {
	CHULAPA("Chulapa"), CASAGRANDE("Casagrande"), BALTAZAR("Baltazar"), PELE(
			"Pelé"), RIVELLINO("Rivellino"), SOCRATES("Sócrates"), ZICO("Zico"), NEYMAR(
			"Neymar"), RONALDO("Ronaldo"), RIVALDO("Rivaldo");

	private final String nome;

	@Override
	public String toString() {
		return nome;
	}

	private NomesJogadoresBrasil(String nome) {
		this.nome = nome;
	}
}
