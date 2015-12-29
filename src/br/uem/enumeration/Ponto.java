package br.uem.enumeration;

import java.util.Random;

/**
 * @author V.Camargo
 * 
 * @Date 18/12/2015
 */

public enum Ponto {

	ESQUERDA_CIMA, ESQUERDABAIXO, DIREITACIMA, DIREITABAIXO, MEIOCIMA, MEIOBAIXO;

	public int errar() {
		Random r = new Random();
		return r.nextInt(1);
	}
}
