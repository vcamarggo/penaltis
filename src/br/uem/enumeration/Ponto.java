package br.uem.enumeration;

import java.util.Random;

/**
 * @author V.Camargo
 * 
 * @Date 18/12/2015
 */

public enum Ponto {

	ESQUERDA_CIMA, ESQUERDA_BAIXO, DIREITA_CIMA, DIREITA_BAIXO, MEIO_CIMA, MEIO_BAIXO;

	public int errar() {
		Random r = new Random();
		return r.nextInt(2);
	}
}
