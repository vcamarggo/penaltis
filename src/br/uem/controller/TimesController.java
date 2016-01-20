package br.uem.controller;

import br.uem.enumeration.Times;
import br.uem.model.Time;
import br.uem.util.Util;

/**
 * @author V.Camargo
 * 
 * @Date 20/01/2016
 */

public class TimesController {
	private static Time timeJogador;
	private static Time timeMaquina;

	public static void createTimes(String nomeDoTime) {
		timeJogador = new Time();
		timeJogador.setNome(nomeDoTime.toUpperCase());
		timeJogador.setJogadores(JogadorController.criaListaJogadores(
				timeJogador.getNome(), timeJogador));

		int auxEscolhaTimeMaquina = 0;
		String nomeTimeMaquina;
		do {
			auxEscolhaTimeMaquina = Util
					.gerarRandomAteN(Times.values().length - 1);
			nomeTimeMaquina = Times.values()[auxEscolhaTimeMaquina].toString();
		} while (nomeTimeMaquina.equalsIgnoreCase(timeJogador.getNome()));

		timeMaquina = new Time();
		timeMaquina.setNome(nomeTimeMaquina.toUpperCase());
		timeMaquina.setJogadores(JogadorController.criaListaJogadores(
				timeMaquina.getNome(), timeMaquina));

		InicializadorGameController.getMainGameController().setTimeJogador(
				timeJogador);
		InicializadorGameController.getMainGameController().setTimeMaquina(
				timeMaquina);
		InicializadorGameController.getMainGameController().setTorcidaJogador(
				TorcidaController.createTorcida(timeJogador));
		InicializadorGameController.getMainGameController().setTorcidaMaquina(
				TorcidaController.createTorcida(timeMaquina));
	}
}
