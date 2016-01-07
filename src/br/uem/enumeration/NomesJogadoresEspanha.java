package br.uem.enumeration;

/**
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public enum NomesJogadoresEspanha {
	INIESTA("Iniesta"), XAVI("Xavi"), RAMOS("Ramos"), TORRES("Torres"), VILLA(
			"Villa"), BUSQUETS("Busquets"), MATA("Mata"), AZPILLICUETA(
			"Azpillicueta"), KOKE("Koke"), CAZORLA("Cazorla");

	private final String toString;

	@Override
	public String toString() {
		return toString;
	}

	private NomesJogadoresEspanha(String toString) {
		this.toString = toString;
	}
}
