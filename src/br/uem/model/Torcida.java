package br.uem.model;

import java.util.List;

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

	public void comemorar() {
	}

	public void lamentar() {
	}

	public List<Torcedor> getTorcedores() {
		return torcedores;
	}

	public void setTorcedores(List<Torcedor> torcedores) {
		this.torcedores = torcedores;
	}

}
