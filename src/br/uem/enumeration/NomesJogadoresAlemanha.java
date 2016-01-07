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

	private final String toString;

	@Override
	public String toString() {
		return toString;
	}

	private NomesJogadoresAlemanha(String toString) {
		this.toString = toString;
	}
}
