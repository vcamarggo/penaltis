package br.uem.model;

import java.util.List;

/**
 *  Modelo que define o time
 * 
 * @author V.Camargo
 * 
 * @Date 29/12/2015
 */

public class Time {

	private String nome;
	
	private List<Jogador> jogadores;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
}
