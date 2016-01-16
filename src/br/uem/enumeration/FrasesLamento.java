package br.uem.enumeration;

/**
 * @author V.Camargo
 * 
 * @Date 16/01/2016
 */

public enum FrasesLamento {
	FRASE1("Aff, seu ruim!"), FRASE2("Capricha a�!"), FRASE3(
			"Na pr�xima a gente consegue!"), FRASE4("Sai da�! Vai treinar!"), FRASE5(
			"O jeito � tentar de novo na pr�xima!");
	;

	private final String frase;

	@Override
	public String toString() {
		return frase;
	}

	private FrasesLamento(String frase) {
		this.frase = frase;
	}
}
