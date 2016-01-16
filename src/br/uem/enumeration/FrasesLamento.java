package br.uem.enumeration;

/**
 * @author V.Camargo
 * 
 * @Date 16/01/2016
 */

public enum FrasesLamento {
	FRASE1("Aff, seu ruim!"), FRASE2("Capricha aí!"), FRASE3(
			"Na próxima a gente consegue!"), FRASE4("Sai daí! Vai treinar!"), FRASE5(
			"O jeito é tentar de novo na próxima!");
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
