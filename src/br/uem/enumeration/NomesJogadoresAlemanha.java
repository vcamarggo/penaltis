package br.uem.enumeration;

/**
 * Define os nomes dos jogadores da Alemanha
 * 
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public enum NomesJogadoresAlemanha {
	SCHWEINSTEIGER("Schweinsteiger", true), PODOLSKI("Podolski", true), KLOSE(
			"Klose", true), KROOS("Kroos", true), LAHM("Lahm", true), HUMMELS(
			"Hummels", true), BOATENG("Boateng", true), KHEDIRA("Khedira", true), REUS(
			"Reus", true), BECKENBAUER("Beckenbauer", true), NEUER("Neuer",
			false);

	private final String nome;
	private final Boolean isBatedor;

	@Override
	public String toString() {
		return nome;
	}

	private NomesJogadoresAlemanha(String nome, Boolean isBatedor) {
		this.nome = nome;
		this.isBatedor = isBatedor;
	}

	public Boolean getIsBatedor() {
		return isBatedor;
	}
}
