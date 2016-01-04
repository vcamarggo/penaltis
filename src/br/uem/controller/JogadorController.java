package br.uem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.uem.enumeration.NomesJogadoresBrasil;
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
		Random r = new Random();

		switch (Times.valueOf(nomeTime)) {
		case BRASIL:
			for (NomesJogadoresBrasil nome : NomesJogadoresBrasil.values()) {
				Batedor batedor = new Batedor();
				batedor.setName(nome.toString());
				batedor.setPerfil(new Perfil(r.nextInt(10), r.nextInt(10)));
				batedor.setTime(t);
				listaJogadores.add(batedor);
			}
			Goleiro goleiro = new Goleiro();
			goleiro.setName("Rogério Ceni");
			goleiro.setTime(t);
			goleiro.setPerfil(new Perfil(r.nextInt(10), r.nextInt(10)));
			listaJogadores.add(goleiro);
			
			break;

		default:
			break;
		}

		return listaJogadores;
	}
}
