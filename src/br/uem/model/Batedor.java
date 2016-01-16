package br.uem.model;

import br.uem.enumeration.Ponto;

/**
 * @author V.Camargo
 * 
 * @Date 29/12/2015
 */

public class Batedor extends Jogador {

	public int chutar(Ponto ponto) {
		return ponto.errar();
	}

}
