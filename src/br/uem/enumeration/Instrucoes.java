package br.uem.enumeration;

public enum Instrucoes {
	OBJETIVO("\nO objetivo do jogo � voc� fazer mais gols que o advers�rio."),
	COMOJOGAR("\n1 - Escolha um dos times para controlar. "
			+ "\n2 - Selecione quem come�ar� chutando. "
			+ "\n3 - Na tela do jogo, selecione um dos seus "
			+ "jogares e clique em um dos pontos para chutar. ");
	
	private final String instrucoes;
	
	private Instrucoes(String instrucoes){
		this.instrucoes = instrucoes;
	}
	
	public String getInstrucoes(){
		return instrucoes;
	}
}
