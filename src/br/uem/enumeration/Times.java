package br.uem.enumeration;

/**
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public enum Times {

	ARGENTINA("Argentina"), ALEMANHA("Alemanha"), BRASIL("Brasil"), ITÁLIA("Itália"), FRANÇA("França"), ESPANHA("Espanha");

	private final String nome;

	@Override
	public String toString() {
		return nome;
	}

	private Times(String nome) {
		this.nome = nome;
	}
	
}
