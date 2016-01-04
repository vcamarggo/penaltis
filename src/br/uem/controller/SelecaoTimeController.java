package br.uem.controller;

import br.uem.enumeration.Times;
import br.uem.model.Time;

/**
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public class SelecaoTimeController {

	public Time selectTime(String nomeDoTime) {
		Time t = new Time();
		switch (Times.valueOf(nomeDoTime.toUpperCase())) {

		case BRASIL:
			t.setNome(Times.BRASIL.name());
			t.setJogadores(JogadorController.criaListaJogadores(t.getNome(), t));
			
		case ALEMANHA:
		case ARGENTINA:
			break;
		case ESPANHA:
			break;
		case FRANCA:
			break;
		case ITALIA:
			break;
		default:
			break;

		}

		return null;
	}
}
