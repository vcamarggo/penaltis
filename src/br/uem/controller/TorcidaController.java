package br.uem.controller;

import java.util.ArrayList;
import java.util.List;

import br.uem.model.Time;
import br.uem.model.Torcedor;
import br.uem.model.Torcida;

/**
 * Controla criação da torcida e torcedores.
 * 
 * @author V.Camargo
 * 
 * @Date 20/01/2016
 */

public class TorcidaController {
	private static final int numeroTorcedores = 10;

	public static Torcida createTorcida(Time time) {
		Torcida torcida = new Torcida();
		torcida.setTime(time);
		torcida.setTorcedores(createTorcedores());

		return torcida;
	}

	private static List<Torcedor> createTorcedores() {
		List<Torcedor> torcedores = new ArrayList<Torcedor>();
		for (int i = 0; i < numeroTorcedores; i++) {
			Torcedor torcedor = new Torcedor();
			torcedores.add(torcedor);
		}
		return torcedores;
	}
}
