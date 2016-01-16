package br.uem.model;

import br.uem.enumeration.Ponto;

/**
 * @author V.Camargo
 * 
 * @Date 29/12/2015
 */

public class Goleiro extends Jogador {

	public Boolean defender(Ponto ponto) {
		if (ponto.errar() == 1) {
			return false;
		} else {
			return true;
		}
	}
}
