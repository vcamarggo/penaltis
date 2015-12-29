package br.uem.view;

import java.awt.Label;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author V.Camargo
 * 
 * @Date 18/12/2015
 */

public class MainView {

	private JFrame frmPenaltis;

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmPenaltis(new JFrame());
		getFrmPenaltis().setTitle("Pênaltis");
		getFrmPenaltis().setBounds(100, 100, 244, 244);
		getFrmPenaltis().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmPenaltis().getContentPane().setLayout(null);
		
		JButton btnComecarJogo = new JButton("Começar Jogo");
		btnComecarJogo.setBounds(31, 52, 162, 23);
		getFrmPenaltis().getContentPane().add(btnComecarJogo);
		
		JButton btnConfiguracao = new JButton("Configurações");
		btnConfiguracao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				btnConfiguracao.setText("Com Focus");
			}
			@Override
			public void focusLost(FocusEvent e) {
				btnConfiguracao.setText("Configurações");
			}
		});
		btnConfiguracao.setBounds(31, 100, 162, 23);
		getFrmPenaltis().getContentPane().add(btnConfiguracao);
		
		Label label = new Label("V 0.1");
		label.setAlignment(Label.CENTER);
		label.setBounds(83, 173, 62, 22);
		getFrmPenaltis().getContentPane().add(label);
	}

	public JFrame getFrmPenaltis() {
		return frmPenaltis;
	}

	public void setFrmPenaltis(JFrame frmPenaltis) {
		this.frmPenaltis = frmPenaltis;
	}
}
