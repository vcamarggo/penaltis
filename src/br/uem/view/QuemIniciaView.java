package br.uem.view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import br.uem.controller.InicializadorGameController;
import br.uem.util.Util;

/**
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public class QuemIniciaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroupQuemComeca = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuemIniciaView frame = new QuemIniciaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuemIniciaView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				QuemIniciaView.class.getResource("/bola.jpg")));
		setTitle("Pênaltis - Quem começa chutando?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JRadioButton rdbtnComearChutando = new JRadioButton("Começar Chutando");
		rdbtnComearChutando.setBounds(139, 22, 166, 23);
		rdbtnComearChutando.setSelected(true);
		buttonGroupQuemComeca.add(rdbtnComearChutando);
		contentPane.add(rdbtnComearChutando);

		JRadioButton rdbtnComputadorDecide = new JRadioButton(
				"Computador Decide");
		rdbtnComputadorDecide.setBounds(139, 58, 180, 23);
		buttonGroupQuemComeca.add(rdbtnComputadorDecide);
		contentPane.add(rdbtnComputadorDecide);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(160, 100, 89, 23);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnComputadorDecide.isSelected()
						&& Util.gerarRandomAteN(1) == 1) {
					InicializadorGameController.getMainGameController()
							.setJogadorComeca(false);
				} else {
					InicializadorGameController.getMainGameController()
							.setJogadorComeca(true);
				}
				InicializadorGameController.getMainGameController()
						.setIsVezJogador(
								InicializadorGameController
										.getMainGameController()
										.getJogadorComeca());
				dispose();
				MainGameView mainGameView = new MainGameView();
				mainGameView.setVisible(true);
			}
		});
		contentPane.add(btnOk);
	}
}
