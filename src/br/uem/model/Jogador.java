package br.uem.model;

import br.uem.enumeration.Ponto;

/**
 * @author V.Camargo
 * 
 * @Date 18/12/2015
 */

public abstract class Jogador {

	private String name;

	private Time time;

	private Perfil perfil;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Ponto direcionar() {
		Ponto ponto = null;
		return ponto;
	}

}
