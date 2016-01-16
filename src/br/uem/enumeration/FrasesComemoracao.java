package br.uem.enumeration;

/**
 * @author V.Camargo
 * 
 * @Date 16/01/2016
 */

public enum FrasesComemoracao {
	FRASE1("Uhuul! � N�iz!"), FRASE2("S� d� meu time!"), FRASE3("V�o perder!"), FRASE4(
			"Nosso time � campe�o!"), FRASE5("Vamos ganhar!");

	private final String frase;

	@Override
	public String toString() {
		return frase;
	}

	private FrasesComemoracao(String frase) {
		this.frase = frase;
	}
}
