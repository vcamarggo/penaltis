package br.uem.model;

import java.util.Random;

/**
 * @author V.Camargo
 * 
 * @Date 29/12/2015
 */

public class Torcedor {

	public int apoiar() {
		Random r = new Random();
		return r.nextInt(11);
	}

	public int xingar() {
		Random r = new Random();
		return r.nextInt(11);
	}
}
