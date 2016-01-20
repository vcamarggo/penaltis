package br.uem.model;

import br.uem.enumeration.Ponto;

/**
 * Extensão de jogador que executa chute
 * 
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
