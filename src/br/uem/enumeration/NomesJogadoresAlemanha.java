package br.uem.enumeration;

/**
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public enum NomesJogadoresAlemanha {
	SCHWEINSTEIGER("Schweinsteiger"), PODOLSKI("Podolski"), KLOSE("Klose"), KROOS(
			"Kroos"), LAHM("Lahm"), HUMMELS("Hummels"), BOATENG("Boateng"), KHEDIRA(
			"Khedira"), REUS("Reus"), BECKENBAUER("Beckenbauer");

	private final String nome;

	@Override
	public String toString() {
		return nome;
	}

	private NomesJogadoresAlemanha(String nome) {
		this.nome = nome;
	}
}
