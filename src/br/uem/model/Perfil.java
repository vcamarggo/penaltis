package br.uem.model;

/**
 * Classe que define os atributos do jogador em rela��o ao seu perfil
 * 
 * @author V.Camargo
 * 
 * @Date 29/12/2015
 */

public class Perfil {

	public Perfil(int qualidade, int confianca) {
		this.qualidade = qualidade;
		this.confianca = confianca;
	}
	
	public Perfil(){
	}

	private int qualidade;
	
	private int confianca;

	public int getQualidade() {
		return qualidade;
	}

	public void setQualidade(int qualidade) {
		this.qualidade = qualidade;
	}

	public int getConfianca() {
		return confianca;
	}

	public void setConfianca(int confianca) {
		this.confianca = confianca;
	}
	
}
