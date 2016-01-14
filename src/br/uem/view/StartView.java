package br.uem.view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author V.Camargo
 * 
 * @Date 18/12/2015
 */

public class StartView {

	private JFrame frmPenaltis;

	/**
	 * Create the application.
	 */
	public StartView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmPenaltis(new JFrame());
		getFrmPenaltis().setIconImage(
				Toolkit.getDefaultToolkit().getImage(
						StartView.class.getResource("/bola.jpg")));
		getFrmPenaltis().setTitle("Pênaltis");
		getFrmPenaltis().setBounds(100, 100, 227, 132);
		getFrmPenaltis().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmPenaltis().getContentPane().setLayout(null);

		JButton btnComecarJogo = new JButton("Começar Jogo");
		btnComecarJogo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frmPenaltis.dispose();
				SelecaoTimeView timeview = new SelecaoTimeView();
				timeview.setVisible(true);
			}
		});

		btnComecarJogo.setBounds(28, 21, 162, 23);
		getFrmPenaltis().getContentPane().add(btnComecarJogo);

		JLabel label = new JLabel("V 1.0");
		label.setBounds(93, 60, 36, 22);
		getFrmPenaltis().getContentPane().add(label);
	}

	public JFrame getFrmPenaltis() {
		return frmPenaltis;
	}

	public void setFrmPenaltis(JFrame frmPenaltis) {
		this.frmPenaltis = frmPenaltis;
	}
}
