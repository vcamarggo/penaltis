package br.uem.enumeration;

/**
 * Define os nomes dos jogadores de Portugal
 * 
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public enum NomesJogadoresPortugal {
	CR("Cristiano Ronaldo"), PEPE("Pepe"), NANI("Nani"), MOUTINHO("Moutinho"), FIGO(
			"Figo"), DECO("Deco"), QUARESMA("Quaresma"), POSTIGA("Postiga"), PAULETA(
			"Pauleta"), RMEIRELES("Raul Meireles");

	private final String nome;

	@Override
	public String toString() {
		return nome;
	}

	private NomesJogadoresPortugal(String nome) {
		this.nome = nome;
	}
}
