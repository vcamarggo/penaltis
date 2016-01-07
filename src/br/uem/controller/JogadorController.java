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
				listaJogadores.add(criarBatedor(nome.toString(), t));
			}
			listaJogadores.add(criarGoleiro("Neuer", t));
			break;

		case ARGENTINA:
			for (NomesJogadoresArgentina nome : NomesJogadoresArgentina
					.values()) {
				listaJogadores.add(criarBatedor(nome.toString(), t));
			}
			listaJogadores.add(criarGoleiro("Rojo", t));
			break;

		case BRASIL:
			for (NomesJogadoresBrasil nome : NomesJogadoresBrasil.values()) {
				listaJogadores.add(criarBatedor(nome.toString(), t));
			}
			listaJogadores.add(criarGoleiro("Júlio César", t));
			break;

		case ESPANHA:
			for (NomesJogadoresEspanha nome : NomesJogadoresEspanha.values()) {
				listaJogadores.add(criarBatedor(nome.toString(), t));
			}
			listaJogadores.add(criarGoleiro("Casillas", t));
			break;

		case FRANÇA:
			for (NomesJogadoresFranca nome : NomesJogadoresFranca.values()) {
				listaJogadores.add(criarBatedor(nome.toString(), t));
			}
			listaJogadores.add(criarGoleiro("Hugo Lloris", t));
			break;

		case ITALIA:
			for (NomesJogadoresItalia nome : NomesJogadoresItalia.values()) {
				listaJogadores.add(criarBatedor(nome.toString(), t));
			}
			listaJogadores.add(criarGoleiro("Buffon", t));
			break;

		default:
			break;

		}

		return listaJogadores;
	}

	public static Jogador criarBatedor(String nome, Time t) {
		Random r = new Random();
		Batedor batedor = new Batedor();
		batedor.setName(nome.toString());
		batedor.setPerfil(new Perfil(r.nextInt(10) + 1, r.nextInt(10) + 1));
		batedor.setTime(t);
		return batedor;
	}

	public static Jogador criarGoleiro(String nome, Time t) {
		Random r = new Random();
		Goleiro goleiro = new Goleiro();
		goleiro.setName(nome.toString());
		goleiro.setPerfil(new Perfil(r.nextInt(10) + 1, r.nextInt(10) + 1));
		goleiro.setTime(t);
		return goleiro;
	}
}
