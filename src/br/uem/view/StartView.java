package br.uem.view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import br.uem.controller.MainGameController;
import br.uem.util.Util;

/**
 * Cria a janela inicial da aplicação.
 * 
 * @author V.Camargo
 * 
 * @Date 18/12/2015
 */

public class StartView {

	private static MainGameController mainGameController;
	private static Util util;

	private JFrame frmPenaltis;
	private static final Image imagemBola = Toolkit.getDefaultToolkit()
			.getImage(StartView.class.getResource("/bola.jpg"));
	private static final String fraseSuperiorJanela = "Pênaltis";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Instancia uma nova StartView e torna ela visível
					StartView window = new StartView();
					window.getFrmPenaltis().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria a aplicação
	 */
	public StartView() {
		initialize();
	}

	/**
	 * Inicializa os componentes da janela
	 */
	private void initialize() {
		setFrmPenaltis(new JFrame());
		getFrmPenaltis().setIconImage(imagemBola);
		getFrmPenaltis().setTitle(fraseSuperiorJanela);
		getFrmPenaltis().setBounds(100, 100, 227, 132);
		getFrmPenaltis().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmPenaltis().getContentPane().setLayout(null);

		JButton btnComecarJogo = new JButton("Começar Jogo");
		btnComecarJogo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frmPenaltis.dispose();
				setMainGameController(new MainGameController());
				SelecaoTimeView timeview = new SelecaoTimeView();
				timeview.setVisible(true);
			}
		});

		btnComecarJogo.setBounds(28, 21, 162, 23);
		getFrmPenaltis().getContentPane().add(btnComecarJogo);

		JLabel label = new JLabel("Bom jogo!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(62, 55, 100, 22);
		getFrmPenaltis().getContentPane().add(label);
	}

	public JFrame getFrmPenaltis() {
		return frmPenaltis;
	}

	public void setFrmPenaltis(JFrame frmPenaltis) {
		this.frmPenaltis = frmPenaltis;
	}

	public static Image getImagembola() {
		return imagemBola;
	}

	public static MainGameController getMainGameController() {
		return mainGameController;
	}

	public static Util getUtil() {
		if (util == null) {
			util = new Util();
		}
		return util;
	}

	public static void setMainGameController(
			MainGameController mainGameController) {
		StartView.mainGameController = mainGameController;
	}

	public static String getFrasesuperiorjanela() {
		return fraseSuperiorJanela;
	}

}
