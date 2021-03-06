package br.uem.enumeration;

import br.uem.util.Util;

/**
 * Define os pontos de chute e defesa
 * 
 * @author V.Camargo
 * 
 * @Date 18/12/2015
 */

public enum Ponto {

	ESQUERDA_CIMA, ESQUERDA_BAIXO, DIREITA_CIMA, DIREITA_BAIXO, MEIO_CIMA, MEIO_BAIXO;

	public boolean errar() {
		return Util.geraBoolean();
	}
}
