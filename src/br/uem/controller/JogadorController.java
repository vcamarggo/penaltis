package br.uem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.uem.enumeration.NomesJogadoresAlemanha;
import br.uem.enumeration.NomesJogadoresArgentina;
import br.uem.enumeration.NomesJogadoresBrasil;
import br.uem.enumeration.NomesJogadoresEspanha;
import br.uem.enumeration.NomesJogadoresFranca;
import br.uem.enumeration.NomesJogadoresItalia;
import br.uem.enumeration.Times;
import br.uem.model.Batedor;
import br.uem.model.Goleiro;
import br.uem.model.Jogador;
import br.uem.model.Perfil;
import br.uem.model.Time;

/**
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public class JogadorController {

	public static List<Jogador> criaListaJogadores(String nomeTime, Time t) {
		List<Jogador> listaJogadores = new ArrayList<Jogador>();

		switch (Times.valueOf(nomeTime)) {
		case ALEMANHA:
			for (NomesJogadoresAlemanha nome : NomesJogadoresAlemanha.values()) {
				listaJogadores.add(criarJogador(nome.toString(), t, true));
			}
			listaJogadores.add(criarJogador("Neuer", t, false));
			break;

		case ARGENTINA:
			for (NomesJogadoresArgentina nome : NomesJogadoresArgentina
					.values()) {
				listaJogadores.add(criarJogador(nome.toString(), t, true));
			}
			listaJogadores.add(criarJogador("Rojo", t, false));
			break;

		case BRASIL:
			for (NomesJogadoresBrasil nome : NomesJogadoresBrasil.values()) {
				listaJogadores.add(criarJogador(nome.toString(), t, true));
			}
			listaJogadores.add(criarJogador("Júlio César", t, false));
			break;

		case ESPANHA:
			for (NomesJogadoresEspanha nome : NomesJogadoresEspanha.values()) {
				listaJogadores.add(criarJogador(nome.toString(), t, true));
			}
			listaJogadores.add(criarJogador("Casillas", t, false));
			break;

		case FRANÇA:
			for (NomesJogadoresFranca nome : NomesJogadoresFranca.values()) {
				listaJogadores.add(criarJogador(nome.toString(), t, true));
			}
			listaJogadores.add(criarJogador("Hugo Lloris", t, false));
			break;

		case ITALIA:
			for (NomesJogadoresItalia nome : NomesJogadoresItalia.values()) {
				listaJogadores.add(criarJogador(nome.toString(), t, true));
			}
			listaJogadores.add(criarJogador("Buffon", t, false));
			break;

		default:
			break;

		}

		return listaJogadores;
	}

	public static Jogador criarJogador(String nome, Time t, boolean isBatedor) {
		Random r = new Random();
		Jogador jogador;
		if (isBatedor) {
			jogador = new Batedor();
		} else {
			jogador = new Goleiro();
		}
		jogador.setName(nome.toString());
		jogador.setPerfil(new Perfil(r.nextInt(10) + 1, r.nextInt(10) + 1));
		jogador.setTime(t);
		return jogador;
	}

}
