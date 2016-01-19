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
		numeroCobranca = 1;
		nomeTimeGanhador = null;
	}

	private static final int numeroTorcedores = 15;
	private Time timeJogador;
	private Time timeMaquina;
	private Boolean jogadorComeca;
	private Boolean isVezJogadorBater;
	private Integer golsJogador;
	private Integer golsMaquina;
	private String fraseTorcidaMaquina;
	private String fraseTorcidaJogador;
	private Torcida torcidaMaquina;
	private Torcida torcidaJogador;
	private String historicoPenaltisJogador;
	private String historicoPenaltisMaquina;
	private Integer numeroCobranca;
	private String nomeTimeGanhador;

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
		for (int i = 0; i < numeroTorcedores; i++) {
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
		if (isVezJogadorBater) {
			goleiro = (Goleiro) timeMaquina.getJogadores().get(10);
			batedor = procurarJogador(nomeJogador, timeJogador);
			batedor = (Batedor) atualizarStatusJogador(batedor, torcidaJogador,
					torcidaMaquina);
			goleiro = (Goleiro) atualizarStatusJogador(goleiro, torcidaMaquina,
					torcidaJogador);
			testaBatedorFezGol(goleiro, pontoMaquina, batedor, pontoJogador,
					isVezJogadorBater);

		} else {
			goleiro = (Goleiro) timeJogador.getJogadores().get(10);
			batedor = procurarJogador(nomeJogador, timeMaquina);
			batedor = (Batedor) atualizarStatusJogador(batedor, torcidaMaquina,
					torcidaJogador);
			goleiro = (Goleiro) atualizarStatusJogador(goleiro, torcidaJogador,
					torcidaMaquina);
			testaBatedorFezGol(goleiro, pontoJogador, batedor, pontoMaquina,
					isVezJogadorBater);

		}
		atualizarVencedor();
	}

	private Jogador atualizarStatusJogador(Jogador jogador,
			Torcida torcidaQueApoiaBatedor, Torcida torcidaContraBatedor) {
		jogador.getPerfil().setConfianca(
				jogador.getPerfil().getConfianca()
						+ torcidaQueApoiaBatedor.aplaudir()
						- torcidaContraBatedor.vaiar());
		jogador.getPerfil().setQualidade(
				jogador.getPerfil().getQualidade()
						* (jogador.getPerfil().getConfianca() / 100));
		return jogador;
	}

	private void atualizarVencedor() {
		nomeTimeGanhador = calcularNomeVencedor(golsJogador, golsMaquina,
				numeroCobranca, jogadorComeca, isVezJogadorBater);
		atualizarNumeroCobrancas();
	}

	private void atualizarNumeroCobrancas() {
		if (jogadorComeca && !isVezJogadorBater) {
			numeroCobranca++;
		}
		if (!jogadorComeca && isVezJogadorBater) {
			numeroCobranca++;
		}
	}

	// tem que corrigir
	private String calcularNomeVencedor(Integer golsJogador,
			Integer golsMaquina, Integer numeroCobranca, Boolean jogadorComeca,
			Boolean isVezJogadorBater) {
		if ((jogadorComeca && !isVezJogadorBater)
				|| (!jogadorComeca && isVezJogadorBater)) {
			int diferencaDeGols = Math.abs(golsJogador - golsMaquina);
			if (numeroCobranca <= 5) {
				if (diferencaDeGols > (5 - numeroCobranca)) {
					if (golsJogador > golsMaquina) {
						return timeJogador.getNome();
					} else {
						return timeMaquina.getNome();
					}
				}
			} else {
				if (diferencaDeGols == 1) {
					if (golsJogador > golsMaquina) {
						return timeJogador.getNome();
					} else {
						return timeMaquina.getNome();
					}
				}
			}
		}
		return null;
	}

	private void testaBatedorFezGol(Goleiro goleiro, Ponto pontoDefesa,
			Batedor batedor, Ponto pontoChute, boolean jogadorBatendo) {
		Boolean fezGol = false;
		if (pontoChute.equals(pontoDefesa)) {
			if (goleiro.defender(pontoDefesa) && batedor.chutar(pontoChute)) {
				if (batedor.getPerfil().getQualidade() > goleiro.getPerfil()
						.getQualidade()) {
					fezGol = true;
				} else {
					fezGol = false;
				}
			} else if (goleiro.defender(pontoDefesa)
					&& !batedor.chutar(pontoChute)) {
				fezGol = false;
			} else if (!goleiro.defender(pontoDefesa)
					&& batedor.chutar(pontoChute)) {
				fezGol = true;
			} else {
				// caso ambos errem
				fezGol = false;
			}
		} else {
			if (batedor.chutar(pontoChute)) {
				fezGol = true;
			} else {
				fezGol = false;
			}
		}
		atualizarGols(jogadorBatendo, fezGol);
		atualizarFrase(jogadorBatendo, fezGol);
		atualizarHistoricoPenaltis(jogadorBatendo, fezGol);

	}

	private void atualizarHistoricoPenaltis(boolean jogadorBatendo,
			Boolean fezGol) {
		if (jogadorBatendo) {
			if (fezGol) {
				historicoPenaltisJogador += " O ";
			} else {
				historicoPenaltisJogador += " X ";
				fraseTorcidaJogador = torcidaJogador.lamentar();
				fraseTorcidaMaquina = torcidaMaquina.comemorar();
			}
		} else {
			if (fezGol) {
				historicoPenaltisMaquina += " O ";
			} else {
				historicoPenaltisMaquina += " X ";
			}
		}

	}

	private void atualizarGols(Boolean jogadorBatendo, Boolean fezGol) {
		if (jogadorBatendo && fezGol) {
			golsJogador += 1;
		} else if (fezGol) {
			golsMaquina += 1;
		}
	}

	private void atualizarFrase(Boolean jogadorBatendo, Boolean fezGol) {
		if (jogadorBatendo) {
			if (fezGol) {
				fraseTorcidaJogador = torcidaJogador.comemorar();
				fraseTorcidaMaquina = torcidaMaquina.lamentar();
			} else {
				fraseTorcidaJogador = torcidaJogador.lamentar();
				fraseTorcidaMaquina = torcidaMaquina.comemorar();
			}
		} else {
			if (fezGol) {
				fraseTorcidaMaquina = torcidaMaquina.comemorar();
				fraseTorcidaJogador = torcidaJogador.lamentar();
			} else {
				fraseTorcidaJogador = torcidaJogador.comemorar();
				fraseTorcidaMaquina = torcidaMaquina.lamentar();
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

	public Integer getNumeroCobranca() {
		return numeroCobranca;
	}

	public void setNumeroCobranca(Integer numeroCobranca) {
		this.numeroCobranca = numeroCobranca;
	}

	public String getNomeTimeGanhador() {
		return nomeTimeGanhador;
	}

	public void setNomeTimeGanhador(String nomeTimeGanhador) {
		this.nomeTimeGanhador = nomeTimeGanhador;
	}

	public Boolean getIsVezJogadorBater() {
		return isVezJogadorBater;
	}

	public void setIsVezJogadorBater(Boolean isVezJogadorBater) {
		this.isVezJogadorBater = isVezJogadorBater;
	}

}
