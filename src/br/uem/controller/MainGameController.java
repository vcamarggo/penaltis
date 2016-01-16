package br.uem.controller;

import java.util.ArrayList;
import java.util.List;

import br.uem.enumeration.Ponto;
import br.uem.enumeration.Times;
import br.uem.model.Batedor;
import br.uem.model.Goleiro;
import br.uem.model.Jogador;
import br.uem.model.Time;
import br.uem.model.Torcedor;
import br.uem.model.Torcida;
import br.uem.util.Util;

/**
 * @author V.Camargo
 * 
 * @Date 09/01/2016
 */

public class MainGameController {

	public MainGameController() {
		timeJogador = null;
		timeMaquina = null;
		golsJogador = 0;
		golsMaquina = 0;
		fraseTorcidaMaquina = "";
		fraseTorcidaJogador = "";
		torcidaMaquina = null;
		torcidaJogador = null;
		historicoPenaltisJogador = "";
		historicoPenaltisMaquina = "";

	}

	private Time timeJogador;
	private Time timeMaquina;
	private Boolean jogadorComeca;
	private Boolean isVezJogador;
	private Integer golsJogador;
	private Integer golsMaquina;
	private String fraseTorcidaMaquina;
	private String fraseTorcidaJogador;
	private Torcida torcidaMaquina;
	private Torcida torcidaJogador;
	private String historicoPenaltisJogador;
	private String historicoPenaltisMaquina;

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

		torcidaMaquina = createTorcida(timeJogador);
		torcidaJogador = createTorcida(timeMaquina);
	}

	private Torcida createTorcida(Time time) {
		Torcida torcida = new Torcida();
		torcida.setTime(time);
		torcida.setTorcedores(createTorcedores());

		return torcida;
	}

	private List<Torcedor> createTorcedores() {
		List<Torcedor> torcedores = new ArrayList<Torcedor>();
		for (int i = 0; i < 30; i++) {
			Torcedor torcedor = new Torcedor();
			torcedores.add(torcedor);
		}
		return torcedores;
	}

	public void direcionar(String nomeJogador, Ponto pontoJogador) {

		Ponto pontoMaquina = Ponto.values()[Util
				.gerarRandomAteN(Ponto.values().length - 1)];

		Goleiro goleiro = null;
		Batedor batedor = null;
		if (isVezJogador) {
			goleiro = (Goleiro) timeMaquina.getJogadores().get(10);
			batedor = procurarJogador(nomeJogador, timeJogador);
			Boolean fezGol = testaBatedorFezGol(goleiro, pontoMaquina, batedor,
					pontoJogador);
			if (fezGol) {
				golsJogador += 1;
				historicoPenaltisJogador += " O ";
				fraseTorcidaJogador = torcidaJogador.comemorar();
				fraseTorcidaMaquina = torcidaMaquina.lamentar();
			} else {
				historicoPenaltisJogador += " X ";
				fraseTorcidaJogador = torcidaJogador.lamentar();
				fraseTorcidaMaquina = torcidaMaquina.comemorar();
			}
		} else {
			goleiro = (Goleiro) timeJogador.getJogadores().get(10);
			batedor = procurarJogador(nomeJogador, timeMaquina);
			Boolean defendeu = testaBatedorFezGol(goleiro, pontoJogador,
					batedor, pontoMaquina);
			if (!defendeu) {
				golsMaquina += 1;
				historicoPenaltisMaquina += " O ";
				fraseTorcidaMaquina = torcidaMaquina.comemorar();
				fraseTorcidaJogador = torcidaJogador.lamentar();
			} else {
				historicoPenaltisMaquina += " X ";
				fraseTorcidaJogador = torcidaJogador.comemorar();
				fraseTorcidaMaquina = torcidaMaquina.lamentar();
			}
		}

	}

	private Boolean testaBatedorFezGol(Goleiro goleiro, Ponto pontoDefesa,
			Batedor batedor, Ponto pontoChute) {
		if (pontoChute.equals(pontoDefesa)) {
			if (goleiro.defender(pontoDefesa) && batedor.chutar(pontoChute)) {
				if (batedor.getPerfil().getQualidade() > goleiro.getPerfil()
						.getQualidade()) {
					return true;
				} else {
					return false;
				}
			} else if (goleiro.defender(pontoDefesa)
					&& !batedor.chutar(pontoChute)) {
				return false;
			} else if (!goleiro.defender(pontoDefesa)
					&& batedor.chutar(pontoChute)) {
				return true;
			} else {
				// caso ambos errem
				return false;
			}
		} else {
			if (batedor.chutar(pontoChute)) {
				return true;
			} else {
				return false;
			}
		}

	}

	private Batedor procurarJogador(String nomeJogador, Time time) {
		Batedor batedor = null;
		for (Jogador jogador : time.getJogadores()) {
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

	public String getFraseTorcidaMaquina() {
		return fraseTorcidaMaquina;
	}

	public void setFraseTorcidaMaquina(String fraseTorcidaMaquina) {
		this.fraseTorcidaMaquina = fraseTorcidaMaquina;
	}

	public String getFraseTorcidaJogador() {
		return fraseTorcidaJogador;
	}

	public void setFraseTorcidaJogador(String fraseTorcidaJogador) {
		this.fraseTorcidaJogador = fraseTorcidaJogador;
	}

	public Torcida getTorcidaMaquina() {
		return torcidaMaquina;
	}

	public void setTorcidaMaquina(Torcida torcidaMaquina) {
		this.torcidaMaquina = torcidaMaquina;
	}

	public Torcida getTorcidaJogador() {
		return torcidaJogador;
	}

	public void setTorcidaJogador(Torcida torcidaJogador) {
		this.torcidaJogador = torcidaJogador;
	}

	public String getHistoricoPenaltisJogador() {
		return historicoPenaltisJogador;
	}

	public void setHistoricoPenaltisJogador(String historicoPenaltisJogador) {
		this.historicoPenaltisJogador = historicoPenaltisJogador;
	}

	public String getHistoricoPenaltisMaquina() {
		return historicoPenaltisMaquina;
	}

	public void setHistoricoPenaltisMaquina(String historicoPenaltisMaquina) {
		this.historicoPenaltisMaquina = historicoPenaltisMaquina;
	}

}
