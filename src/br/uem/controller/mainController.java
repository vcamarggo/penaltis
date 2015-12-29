package br.uem.controller;

import java.awt.EventQueue;

import br.uem.view.MainView;

/**
 * @author V.Camargo
 * 
 * @Date 29/12/2015
 */

public class mainController {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.getFrmPenaltis().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
