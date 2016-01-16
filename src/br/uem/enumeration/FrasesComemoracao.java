package br.uem.enumeration;

/**
 * @author V.Camargo
 * 
 * @Date 16/01/2016
 */

public enum FrasesComemoracao {
	FRASE1("Uhuul! É Nóiz!"), FRASE2("Só dá meu time!"), FRASE3("Vão perder!"), FRASE4(
			"Nosso time é campeão!"), FRASE5("Vamos ganhar!");

	private final String frase;

	@Override
	public String toString() {
		return frase;
	}

	private FrasesComemoracao(String frase) {
		this.frase = frase;
	}
}
