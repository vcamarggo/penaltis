package br.uem.model;

import br.uem.enumeration.Ponto;

/**
 * Extensão de jogador que defende o chute
 * 
 * @author V.Camargo
 * 
 * @Date 29/12/2015
 */

public class Goleiro extends Jogador {

	public Boolean defender(Ponto ponto) {
		return ponto.errar();
	}
}
