package br.uem.model;

/**
 * @author V.Camargo
 * 
 * @Date 18/12/2015
 */

public class Torcida {

	private Time time;

	private Torcedor torcedor;
	
	public Torcedor getTorcedor() {
		return torcedor;
	}

	public void setTorcedor(Torcedor torcedor) {
		this.torcedor = torcedor;
	}

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

}
