package br.uem.controller;

import br.uem.enumeration.Ponto;
import br.uem.enumeration.Times;
import br.uem.model.Batedor;
import br.uem.model.Goleiro;
import br.uem.model.Jogador;
import br.uem.model.Time;
import br.uem.model.Torcida;
import br.uem.util.Util;

/**
 * @author V.Camargo
 * 
 * @Date 09/01/2016
 */

public class MainGameController {
	private Time timeJogador;
	private Time timeMaquina;
	private Torcida torcidaJogador;
	private Torcida torcidaMaquina;
	private Boolean jogadorComeca;
	private Boolean isVezJogador;
	private Integer golsJogador;
	private Integer golsMaquina;

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

		createTorcidas();
	}

	private void createTorcidas() {
		for (int i = 1; i > 50; i++) {
			System.out.println(i);
		}
	}

	public void direcionar(String nomeJogador, Ponto ponto) {
		Goleiro goleiro = (Goleiro) timeMaquina.getJogadores().get(10);
		Batedor batedor = procurarJogador(nomeJogador);
		if (batedor.chutar(ponto) != 1) {
			goleiro.defender(Ponto.values()[Util.gerarRandomAteN(Ponto.values().length - 1)]);
		}
	}

	private Batedor procurarJogador(String nomeJogador) {
		Batedor batedor = null;
		for (Jogador jogador : timeJogador.getJogadores()) {
			if (jogador.getName().equals(nomeJogador)) {
				return batedor = (Batedor) jogador;
			}
		}
		return batedor;
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

	public void testarDefesa(String string, Ponto valueOf) {
	}

	public Integer getGolsJogador() {
		return golsJogador;
	}

	public void setGolsJogador(Integer golsJogador) {
		this.golsJogador = golsJogador;
	}

	public Integer getGolsMaquina() {
		return golsMaquina;
	}

	public void setGolsMaquina(Integer golsMaquina) {
		this.golsMaquina = golsMaquina;
	}

	public Torcida getTorcidaJogador() {
		return torcidaJogador;
	}

	public void setTorcidaJogador(Torcida torcidaJogador) {
		this.torcidaJogador = torcidaJogador;
	}

	public Torcida getTorcidaMaquina() {
		return torcidaMaquina;
	}

	public void setTorcidaMaquina(Torcida torcidaMaquina) {
		this.torcidaMaquina = torcidaMaquina;
	}

}
