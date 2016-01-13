package br.uem.controller;

import java.awt.EventQueue;

import br.uem.view.StartView;

/**
 * @author V.Camargo
 * 
 * @Date 29/12/2015
 */

public class InicializadorGameController {

	private static MainGameController mainGameController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartView window = new StartView();
					window.getFrmPenaltis().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static MainGameController getMainGameController() {
		if (mainGameController == null) {
			mainGameController = new MainGameController();
		}
		return mainGameController;
	}

	public static void setMainGameController(
			MainGameController mainGameController) {
		InicializadorGameController.mainGameController = mainGameController;
	}
}
