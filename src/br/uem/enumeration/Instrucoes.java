package br.uem.enumeration;

public enum Instrucoes {
	OBJETIVO("O objetivo do jogo é você fazer mais gols que o adversário."),
	COMOJOGAR("1 - Escolha um dos times para controlar. "
			+ "2 - Selecione quem começará chutando. "
			+ "3 - Na tela do jogo, selecione um dos seus "
			+ "jogares e clique em um dos pontos para chutar. ");
	
	private final String instrucoes;
	
	private Instrucoes(String instrucoes){
		this.instrucoes = instrucoes;
	}
	
	public String getInstrucoes(){
		return instrucoes;
	}
}
