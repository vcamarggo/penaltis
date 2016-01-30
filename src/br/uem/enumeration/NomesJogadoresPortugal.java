package br.uem.enumeration;

/**
 * Define os nomes dos jogadores de Portugal
 * 
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public enum NomesJogadoresPortugal {
	CR("Cristiano Ronaldo", true), PEPE("Pepe", true), NANI("Nani", true), MOUTINHO(
			"Moutinho", true), FIGO("Figo", true), DECO("Deco", true), QUARESMA(
			"Quaresma", true), POSTIGA("Postiga", true), PAULETA("Pauleta",
			true), RMEIRELES("Raul Meireles", true), MB("Manuel Bento", false);

	private final String nome;
	private final Boolean isBatedor;

	@Override
	public String toString() {
		return nome;
	}

	private NomesJogadoresPortugal(String nome, Boolean isBatedor) {
		this.nome = nome;
		this.isBatedor = isBatedor;
	}

	public Boolean getIsBatedor() {
		return isBatedor;
	}
}
