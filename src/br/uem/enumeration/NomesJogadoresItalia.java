package br.uem.enumeration;

/**
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public enum NomesJogadoresItalia {
	BAGGIO("Baggio"), PIRLO("Pirlo"), MALDINI("Maldini"), TOTTI("Totti"), ROSSI(
			"Rossi"), ALTAFINI("Altafini"), BARESI("Baresi"), CANNAVARO(
			"Cannavaro"), CAPELLO("Capello"), BALOTELLI("Balotelli");

	private final String toString;

	@Override
	public String toString() {
		return toString;
	}

	private NomesJogadoresItalia(String toString) {
		this.toString = toString;
	}
}
