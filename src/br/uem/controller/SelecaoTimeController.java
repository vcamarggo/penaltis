package br.uem.controller;

import br.uem.model.Time;

/**
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public class SelecaoTimeController {

	public Time selectTime(String nomeDoTime) {
		Time t = new Time();
		t.setNome(nomeDoTime.toUpperCase());
		t.setJogadores(JogadorController.criaListaJogadores(t.getNome(), t));

		return null;
	}
}
