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
		Random r = new Random();

		switch (Times.valueOf(nomeTime)) {
		case ALEMANHA:
			for (NomesJogadoresAlemanha nome : NomesJogadoresAlemanha.values()) {
				Batedor batedor = new Batedor();
				batedor.setName(nome.toString());
				batedor.setPerfil(new Perfil(r.nextInt(10), r.nextInt(10)));
				batedor.setTime(t);
				listaJogadores.add(batedor);
			}
			Goleiro goleiroAlemanha = new Goleiro();
			goleiroAlemanha.setName("Neuer");
			goleiroAlemanha.setTime(t);
			goleiroAlemanha.setPerfil(new Perfil(r.nextInt(10), r.nextInt(10)));
			listaJogadores.add(goleiroAlemanha);

			break;

		case ARGENTINA:
			for (NomesJogadoresArgentina nome : NomesJogadoresArgentina
					.values()) {
				Batedor batedor = new Batedor();
				batedor.setName(nome.toString());
				batedor.setPerfil(new Perfil(r.nextInt(10), r.nextInt(10)));
				batedor.setTime(t);
				listaJogadores.add(batedor);
			}
			Goleiro goleiroArgentina = new Goleiro();
			goleiroArgentina.setName("Romero");
			goleiroArgentina.setTime(t);
			goleiroArgentina
					.setPerfil(new Perfil(r.nextInt(10), r.nextInt(10)));
			listaJogadores.add(goleiroArgentina);
			break;

		case BRASIL:
			for (NomesJogadoresBrasil nome : NomesJogadoresBrasil.values()) {
				Batedor batedor = new Batedor();
				batedor.setName(nome.toString());
				batedor.setPerfil(new Perfil(r.nextInt(10), r.nextInt(10)));
				batedor.setTime(t);
				listaJogadores.add(batedor);
			}
			Goleiro goleiroBrasil = new Goleiro();
			goleiroBrasil.setName("Rogério Ceni");
			goleiroBrasil.setTime(t);
			goleiroBrasil.setPerfil(new Perfil(r.nextInt(10), r.nextInt(10)));
			listaJogadores.add(goleiroBrasil);
			break;

		case ESPANHA:
			for (NomesJogadoresEspanha nome : NomesJogadoresEspanha.values()) {
				Batedor batedor = new Batedor();
				batedor.setName(nome.toString());
				batedor.setPerfil(new Perfil(r.nextInt(10), r.nextInt(10)));
				batedor.setTime(t);
				listaJogadores.add(batedor);
			}
			Goleiro goleiroEspanha = new Goleiro();
			goleiroEspanha.setName("Casillas");
			goleiroEspanha.setTime(t);
			goleiroEspanha.setPerfil(new Perfil(r.nextInt(10), r.nextInt(10)));
			listaJogadores.add(goleiroEspanha);
			break;

		case FRANÇA:
			for (NomesJogadoresFranca nome : NomesJogadoresFranca.values()) {
				Batedor batedor = new Batedor();
				batedor.setName(nome.toString());
				batedor.setPerfil(new Perfil(r.nextInt(10), r.nextInt(10)));
				batedor.setTime(t);
				listaJogadores.add(batedor);
			}
			Goleiro goleiroFranca = new Goleiro();
			goleiroFranca.setName("Hugo Lloris");
			goleiroFranca.setTime(t);
			goleiroFranca.setPerfil(new Perfil(r.nextInt(10), r.nextInt(10)));
			listaJogadores.add(goleiroFranca);
			break;

		case ITALIA:
			for (NomesJogadoresItalia nome : NomesJogadoresItalia.values()) {
				Batedor batedor = new Batedor();
				batedor.setName(nome.toString());
				batedor.setPerfil(new Perfil(r.nextInt(10), r.nextInt(10)));
				batedor.setTime(t);
				listaJogadores.add(batedor);
			}
			Goleiro goleiroItalia = new Goleiro();
			goleiroItalia.setName("Buffon");
			goleiroItalia.setTime(t);
			goleiroItalia.setPerfil(new Perfil(r.nextInt(10), r.nextInt(10)));
			listaJogadores.add(goleiroItalia);
			break;

		default:
			break;

		}

		return listaJogadores;
	}
}
