package br.uem.controller;

import java.awt.List;

import br.uem.model.Time;

/**
 * @author V.Camargo
 * 
 * @Date 09/01/2016
 */

public class SelecaoBatedorController {

	public List populaListaBatedor(List choice, Time time) {
		for (int i = 0; i < 10; i++) {
			choice.add(time.getJogadores().get(i).getName());
		}
		return choice;
	}
}
