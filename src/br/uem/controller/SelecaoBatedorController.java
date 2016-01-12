package br.uem.controller;

import java.awt.Choice;

import br.uem.enumeration.NomesJogadoresAlemanha;
import br.uem.enumeration.NomesJogadoresArgentina;
import br.uem.enumeration.NomesJogadoresBrasil;
import br.uem.enumeration.NomesJogadoresChile;
import br.uem.enumeration.NomesJogadoresEspanha;
import br.uem.enumeration.NomesJogadoresPortugal;
import br.uem.enumeration.Times;

/**
 * @author V.Camargo
 * 
 * @Date 09/01/2016
 */

public class SelecaoBatedorController {

	public Choice populaListaBatedor(Choice choice) {
		switch (Times.valueOf(InicializadorGameController
				.getMainGameController().getTimeJogador().getNome())) {
		case ALEMANHA:
			for (NomesJogadoresAlemanha nome : NomesJogadoresAlemanha.values()) {
				choice.add(nome.toString());
			}
			break;
		case ARGENTINA:
			for (NomesJogadoresArgentina nome : NomesJogadoresArgentina
					.values()) {
				choice.add(nome.toString());
			}
			break;
		case BRASIL:
			for (NomesJogadoresBrasil nome : NomesJogadoresBrasil.values()) {
				choice.add(nome.toString());
			}
			break;
		case ESPANHA:
			for (NomesJogadoresEspanha nome : NomesJogadoresEspanha.values()) {
				choice.add(nome.toString());
			}
			break;
		case CHILE:
			for (NomesJogadoresChile nome : NomesJogadoresChile.values()) {
				choice.add(nome.toString());
			}
			break;
		case PORTUGAL:
			for (NomesJogadoresPortugal nome : NomesJogadoresPortugal.values()) {
				choice.add(nome.toString());
			}
			break;
		default:
			break;
		}
		return choice;
	}

}
