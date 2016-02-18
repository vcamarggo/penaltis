package br.uem.util;

import java.util.Random;

/**
 * Controla os métodos genéricos uteis as demais classes
 * 
 * @author V.Camargo
 * 
 * @Date 15/01/2016
 */

public class Util {

	public static int gerarRandomAteN(Integer n) {
		return new Random().nextInt(n + 1);
	}

	public static boolean geraBoolean() {
		return new Random().nextBoolean();
	}
}
