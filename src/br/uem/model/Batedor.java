package br.uem.model;

import br.uem.enumeration.Ponto;

/**
 * @author V.Camargo
 * 
 * @Date 29/12/2015
 */

public class Batedor extends Jogador {

	public Boolean chutar(Ponto ponto) {
		if (ponto.errar() == 1) {
			return false;
		} else {
			return true;
		}
	}

}
