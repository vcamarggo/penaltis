package br.uem.controller;

import java.awt.EventQueue;

import br.uem.util.Util;
import br.uem.view.StartView;

/**
 * @author V.Camargo
 * 
 * @Date 29/12/2015
 */

public class InicializadorGameController {

	private static MainGameController mainGameController;
	private static Util util;

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
		return mainGameController;
	}

	public static void setMainGameController(
			MainGameController mainGameController) {
		InicializadorGameController.mainGameController = mainGameController;
	}

	public static Util getUtil() {
		if (util == null) {
			util = new Util();
		}
		return util;
	}

	public static void setUtil(Util util) {
		InicializadorGameController.util = util;
	}
}
