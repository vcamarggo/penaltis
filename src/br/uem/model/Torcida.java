package br.uem.model;

import java.util.List;

import br.uem.enumeration.FrasesComemoracao;
import br.uem.enumeration.FrasesLamento;
import br.uem.util.Util;

/**
 * @author V.Camargo
 * 
 * @Date 18/12/2015
 */

public class Torcida {

	private Time time;

	private List<Torcedor> torcedores;

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public int aplaudir() {
		return 0;
	}

	public int vaiar() {
		return 0;
	}

	public String comemorar() {
		return FrasesComemoracao.values()[Util
				.gerarRandomAteN(FrasesComemoracao.values().length - 1)]
				.toString();
	}

	public String lamentar() {
		return FrasesLamento.values()[Util
		                  				.gerarRandomAteN(FrasesLamento.values().length - 1)]
		                  				.toString();
		                  	}

	public List<Torcedor> getTorcedores() {
		return torcedores;
	}

	public void setTorcedores(List<Torcedor> torcedores) {
		this.torcedores = torcedores;
	}

}
