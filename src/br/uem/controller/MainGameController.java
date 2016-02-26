package br.uem.controller;

import br.uem.enumeration.Ponto;
import br.uem.model.Batedor;
import br.uem.model.Goleiro;
import br.uem.model.Time;
import br.uem.model.Torcida;
import br.uem.util.Util;

/**
 * Controla todo fluxo principal do jogo
 * 
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
	}

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

	/**
	 * @param nomeBatedor
	 * @param pontoJogador
	 * 
	 *            Define o goleiro e batedor e chama os métodos que atualizam
	 *            seus perfis e verificam se foi gol e também se há vencedor
	 */
	public void direcionar(String nomeBatedor, Ponto pontoJogador) {

		Ponto pontoMaquina = Ponto.values()[Util.gerarRandomAteN(Ponto.values().length - 1)];

		Goleiro goleiro = null;
		Batedor batedor = null;

		if (isVezJogadorBater) {
			goleiro = (Goleiro) timeMaquina.getJogadores().get(10);
			batedor = JogadorController.procurarJogador(nomeBatedor, timeJogador);
			batedor = (Batedor) JogadorController.atualizarStatusJogador(batedor, torcidaJogador, torcidaMaquina);
			goleiro = (Goleiro) JogadorController.atualizarStatusJogador(goleiro, torcidaMaquina, torcidaJogador);
			testaBatedorFezGol(goleiro, pontoMaquina, batedor, pontoJogador, isVezJogadorBater);
		} else {
			goleiro = (Goleiro) timeJogador.getJogadores().get(10);
			batedor = JogadorController.procurarJogador(nomeBatedor, timeMaquina);
			batedor = (Batedor) JogadorController.atualizarStatusJogador(batedor, torcidaMaquina, torcidaJogador);
			goleiro = (Goleiro) JogadorController.atualizarStatusJogador(goleiro, torcidaJogador, torcidaMaquina);
			testaBatedorFezGol(goleiro, pontoJogador, batedor, pontoMaquina, isVezJogadorBater);
		}
		atualizarNumeroCobrancas();
	}

	/**
	 * Verifica se há vencedor e chama método que atualiza numero cobranças
	 */
	public String atualizarVencedor() {
		return calcularNomeVencedor(golsJogador, golsMaquina, numeroCobranca, jogadorComeca, isVezJogadorBater);
	}

	/**
	 * Atualiza o número de cobranças
	 */
	private void atualizarNumeroCobrancas() {
		if (jogadorComeca ^ isVezJogadorBater) {
			numeroCobranca++;
		}
	}

	/**
	 * Verifica se há vencedor e retorna seu nome
	 * 
	 * @param golsJogador
	 * @param golsMaquina
	 * @param numeroCobranca
	 * @param jogadorComeca
	 * @param isVezJogadorBater
	 * @return nome do vencedor
	 */
	private String calcularNomeVencedor(Integer golsJogador, Integer golsMaquina, Integer numeroCobranca,
			Boolean jogadorComeca, Boolean isVezJogadorBater) {
		if ((jogadorComeca && !isVezJogadorBater) || (!jogadorComeca && isVezJogadorBater)) {
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

	/**
	 * Testa se um batedor fez gol e atualiza gols, frases e histórico
	 * 
	 * @param goleiro
	 * @param pontoDefesa
	 * @param batedor
	 * @param pontoChute
	 * @param jogadorBatendo
	 */
	private void testaBatedorFezGol(Goleiro goleiro, Ponto pontoDefesa, Batedor batedor, Ponto pontoChute,
			boolean jogadorBatendo) {
		Boolean fezGol = false;
		if (pontoChute.equals(pontoDefesa)) {
			if (goleiro.defender(pontoDefesa) && batedor.chutar(pontoChute)) {
				if (batedor.getPerfil().getQualidade() > goleiro.getPerfil().getQualidade()) {
					fezGol = true;
				} else {
					fezGol = false;
				}
			} else if (goleiro.defender(pontoDefesa) && !batedor.chutar(pontoChute)) {
				fezGol = false;
			} else if (!goleiro.defender(pontoDefesa) && batedor.chutar(pontoChute)) {
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

	/**
	 * Atualiza histórico dos penaltis conforme erro ou acerto
	 * 
	 * @param jogadorBatendo
	 * @param fezGol
	 */
	private void atualizarHistoricoPenaltis(boolean jogadorBatendo, Boolean fezGol) {
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

	/**
	 * Atualiza gols se houve gol feito
	 * 
	 * @param jogadorBatendo
	 * @param fezGol
	 */
	private void atualizarGols(Boolean jogadorBatendo, Boolean fezGol) {
		if (jogadorBatendo && fezGol) {
			golsJogador += 1;
		} else if (fezGol) {
			golsMaquina += 1;
		}
	}

	/**
	 * Atualiza frases conforme erro ou acerto
	 * 
	 * @param jogadorBatendo
	 * @param fezGol
	 */
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

	public void setTorcidaMaquina(Torcida torcidaMaquina) {
		this.torcidaMaquina = torcidaMaquina;
	}

	public void setTorcidaJogador(Torcida torcidaJogador) {
		this.torcidaJogador = torcidaJogador;
	}

	public void setTimeJogador(Time timeJogador) {
		this.timeJogador = timeJogador;
	}

	public void setTimeMaquina(Time timeMaquina) {
		this.timeMaquina = timeMaquina;
	}

	public Time getTimeJogador() {
		return timeJogador;
	}

	public Time getTimeMaquina() {
		return timeMaquina;
	}

	public Boolean getJogadorComeca() {
		return jogadorComeca;
	}

	public Integer getGolsJogador() {
		return golsJogador;
	}

	public Integer getGolsMaquina() {
		return golsMaquina;
	}

	public Boolean getIsVezJogadorBater() {
		return isVezJogadorBater;
	}

	public void setIsVezJogadorBater(Boolean isVezJogadorBater) {
		this.isVezJogadorBater = isVezJogadorBater;
	}

	public String getHistoricoPenaltisJogador() {
		return historicoPenaltisJogador;
	}

	public String getHistoricoPenaltisMaquina() {
		return historicoPenaltisMaquina;
	}

	public String getFraseTorcidaMaquina() {
		return fraseTorcidaMaquina;
	}

	public String getFraseTorcidaJogador() {
		return fraseTorcidaJogador;
	}

	public void setJogadorComeca(Boolean jogadorComeca) {
		this.jogadorComeca = jogadorComeca;
	}

}
