package br.uem.enumeration;

/**
 * Define os nomes dos jogadores do Chile
 * 
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public enum NomesJogadoresChile {
	VIDAL("Vidal"), VARGAS("Vargas"), MEDEL("Medel"), VALDIVIA("Valdivia"), JARA(
			"Jara"), ISLA("Isla"), MENA("Mena"), PIZARRO("Pizarro"), RABELLO(
			"Rabello"), RUBIO("Rubio");

	private final String nome;

	@Override
	public String toString() {
		return nome;
	}

	private NomesJogadoresChile(String nome) {
		this.nome = nome;
	}
}
