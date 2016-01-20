package br.uem.model;

import br.uem.util.Util;

/**
 *  Modelo que especifica os comportamentos dos torcedores
 * 
 * @author V.Camargo
 * 
 * @Date 29/12/2015
 */

public class Torcedor {

	public int apoiar() {
		return Util.gerarRandomAteN(10);
	}

	public int xingar() {
		return Util.gerarRandomAteN(10);
	}
}
