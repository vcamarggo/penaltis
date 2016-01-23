package br.uem.enumeration;

/**
 * Define os nomes dos jogadores da Espanha
 * 
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public enum NomesJogadoresEspanha {
	INIESTA("Iniesta", true), XAVI("Xavi", true), RAMOS("Ramos", true), TORRES(
			"Torres", true), VILLA("Villa", true), BUSQUETS("Busquets", true), MATA(
			"Mata", true), AZPILLICUETA("Azpillicueta", true), KOKE("Koke",
			true), CAZORLA("Cazorla", true), CASILLAS("Casillas", false);

	private final String nome;
	private final Boolean isBatedor;

	@Override
	public String toString() {
		return nome;
	}

	private NomesJogadoresEspanha(String nome, Boolean isBatedor) {
		this.nome = nome;
		this.isBatedor = isBatedor;
	}

	public Boolean getIsBatedor() {
		return isBatedor;
	}
}
