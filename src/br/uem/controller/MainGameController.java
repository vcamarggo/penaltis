package br.uem.controller;

import java.util.Random;

import br.uem.enumeration.Times;
import br.uem.model.Time;

/**
 * @author V.Camargo
 * 
 * @Date 09/01/2016
 */

public class MainGameController {
	private Time timeJogador;
	private Time timeMaquina;
	private Boolean jogadorComeca;
	private Boolean isVezJogador;

	public void createTimes(String nomeDoTime) {
		timeJogador = new Time();
		timeJogador.setNome(nomeDoTime.toUpperCase());
		timeJogador.setJogadores(JogadorController.criaListaJogadores(
				timeJogador.getNome(), timeJogador));

		int auxEscolhaTimeMaquina = 0;
		String nomeTimeMaquina;
		do {
			auxEscolhaTimeMaquina = new Random().nextInt(Times.values().length);
			nomeTimeMaquina = Times.values()[auxEscolhaTimeMaquina].toString();
		} while (nomeTimeMaquina.equalsIgnoreCase(timeJogador.getNome()));

		timeMaquina = new Time();
		timeMaquina.setNome(nomeTimeMaquina.toUpperCase());
		timeMaquina.setJogadores(JogadorController.criaListaJogadores(
				timeMaquina.getNome(), timeMaquina));
	}

	public Time getTimeJogador() {
		return timeJogador;
	}

	public void setTimeJogador(Time timeJogador) {
		this.timeJogador = timeJogador;
	}

	public Time getTimeMaquina() {
		return timeMaquina;
	}

	public void setTimeMaquina(Time timeMaquina) {
		this.timeMaquina = timeMaquina;
	}

	public Boolean getJogadorComeca() {
		return jogadorComeca;
	}

	public void setJogadorComeca(Boolean jogadorComeca) {
		this.jogadorComeca = jogadorComeca;
	}

	public Boolean getIsVezJogador() {
		return isVezJogador;
	}

	public void setIsVezJogador(Boolean isVezJogador) {
		this.isVezJogador = isVezJogador;
	}

}
