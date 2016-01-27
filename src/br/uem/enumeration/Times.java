package br.uem.enumeration;

/**
 * Define os nomes dos times disponíveis no jogo
 * 
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public enum Times {

	ARGENTINA("Argentina"), ALEMANHA("Alemanha"), BRASIL("Brasil"), CHILE("Chile"), PORTUGAL("Portugal"), ESPANHA("Espanha");

	private final String nome;

	@Override
	public String toString() {
		return nome;
	}

	private Times(String nome) {
		this.nome = nome;
	}
	
}
