package br.uem.controller;

import br.uem.enumeration.Ponto;
import br.uem.enumeration.Times;
import br.uem.model.Batedor;
import br.uem.model.Goleiro;
import br.uem.model.Jogador;
import br.uem.model.Time;
import br.uem.util.Util;

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
			auxEscolhaTimeMaquina = Util
					.gerarRandomAteN(Times.values().length - 1);
			nomeTimeMaquina = Times.values()[auxEscolhaTimeMaquina].toString();
		} while (nomeTimeMaquina.equalsIgnoreCase(timeJogador.getNome()));

		timeMaquina = new Time();
		timeMaquina.setNome(nomeTimeMaquina.toUpperCase());
		timeMaquina.setJogadores(JogadorController.criaListaJogadores(
				timeMaquina.getNome(), timeMaquina));
	}

	public void testarBatida(String nomeJogador, Ponto ponto) {
		Goleiro goleiro = (Goleiro) timeMaquina.getJogadores().get(10);
		Batedor batedor = null;
		for (Jogador jogador : timeJogador.getJogadores()) {
			if (jogador.getName().equals(nomeJogador)) {
				batedor = (Batedor) jogador;
				break;
			}
		}
		System.out.println(batedor.getName() + "  " + goleiro.getName());
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

	public void testarDefesa(Ponto valueOf) {
		// TODO Auto-generated method stub

	}

}
