package br.uem.controller;

import java.util.ArrayList;
import java.util.List;

import br.uem.enumeration.NomesJogadoresAlemanha;
import br.uem.enumeration.NomesJogadoresArgentina;
import br.uem.enumeration.NomesJogadoresBrasil;
import br.uem.enumeration.NomesJogadoresChile;
import br.uem.enumeration.NomesJogadoresEspanha;
import br.uem.enumeration.NomesJogadoresPortugal;
import br.uem.enumeration.Times;
import br.uem.model.Batedor;
import br.uem.model.Goleiro;
import br.uem.model.Jogador;
import br.uem.model.Perfil;
import br.uem.model.Time;
import br.uem.model.Torcida;
import br.uem.util.Util;

/**
 * Controla o crud dos jogares
 * 
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
				listaJogadores.add(criarJogador(nome.toString(), t,
						nome.getIsBatedor()));
			}
			break;

		case ARGENTINA:
			for (NomesJogadoresArgentina nome : NomesJogadoresArgentina
					.values()) {
				listaJogadores.add(criarJogador(nome.toString(), t,
						nome.getIsBatedor()));
			}
			break;

		case BRASIL:
			for (NomesJogadoresBrasil nome : NomesJogadoresBrasil.values()) {
				listaJogadores.add(criarJogador(nome.toString(), t,
						nome.getIsBatedor()));
			}
			break;

		case ESPANHA:
			for (NomesJogadoresEspanha nome : NomesJogadoresEspanha.values()) {
				listaJogadores.add(criarJogador(nome.toString(), t,
						nome.getIsBatedor()));
			}
			break;

		case CHILE:
			for (NomesJogadoresChile nome : NomesJogadoresChile.values()) {
				listaJogadores.add(criarJogador(nome.toString(), t,
						nome.getIsBatedor()));
			}
			break;

		case PORTUGAL:
			for (NomesJogadoresPortugal nome : NomesJogadoresPortugal.values()) {
				listaJogadores.add(criarJogador(nome.toString(), t,
						nome.getIsBatedor()));
			}
			break;

		default:
			break;

		}

		return listaJogadores;
	}

	public static Jogador criarJogador(String nome, Time t, boolean isBatedor) {
		Jogador jogador;
		if (isBatedor) {
			jogador = new Batedor();
		} else {
			jogador = new Goleiro();
		}
		jogador.setName(nome.toString());
		jogador.setPerfil(new Perfil(Util.gerarRandomAteN(10), Util
				.gerarRandomAteN(10)));
		jogador.setTime(t);
		return jogador;
	}

	public static Jogador atualizarStatusJogador(Jogador jogador,
			Torcida torcidaQueApoiaBatedor, Torcida torcidaContraBatedor) {
		jogador.getPerfil().setConfianca(
				jogador.getPerfil().getConfianca()
						+ torcidaQueApoiaBatedor.aplaudir()
						- torcidaContraBatedor.vaiar());
		jogador.getPerfil().setQualidade(
				jogador.getPerfil().getQualidade()
						* (jogador.getPerfil().getConfianca() / 100));
		return jogador;
	}

	public static Batedor procurarJogador(String nomeJogador, Time time) {
		Batedor batedor = null;
		for (Jogador jogador : time.getJogadores()) {
			if (jogador.getName().equals(nomeJogador)) {
				return batedor = (Batedor) jogador;
			}
		}
		return batedor;
	}
}
