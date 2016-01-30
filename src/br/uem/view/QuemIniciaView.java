package br.uem.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import br.uem.util.Util;
import javax.swing.JLabel;

/**
 * Cria janela para sele��o de quem inicia as cobran�as de p�naltis
 * 
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public class QuemIniciaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroupQuemComeca = new ButtonGroup();

	/**
	 * Cria janela
	 */
	public QuemIniciaView() {
		setIconImage(StartView.getImagembola());
		setTitle(StartView.getFrasesuperiorjanela());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 251, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		JRadioButton rdbtnComearChutando = new JRadioButton("Come�ar Chutando");
		rdbtnComearChutando.setBounds(51, 47, 166, 23);
		rdbtnComearChutando.setSelected(true);
		buttonGroupQuemComeca.add(rdbtnComearChutando);
		contentPane.add(rdbtnComearChutando);

		JRadioButton rdbtnComputadorDecide = new JRadioButton(
				"Computador Decide");
		rdbtnComputadorDecide.setBounds(51, 73, 180, 23);
		buttonGroupQuemComeca.add(rdbtnComputadorDecide);
		contentPane.add(rdbtnComputadorDecide);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(77, 115, 89, 23);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnComputadorDecide.isSelected()
						&& Util.gerarRandomAteN(1) == 1) {
					// se computador decide, ent�o qualquer um pode come�ar
					// chutando
					StartView.getMainGameController().setJogadorComeca(false);
				} else {
					// sen�o, jogador come�a chutando
					StartView.getMainGameController().setJogadorComeca(true);
				}
				StartView.getMainGameController().setIsVezJogadorBater(
						StartView.getMainGameController().getJogadorComeca());
				dispose();
				MainGameView mainGameView = new MainGameView();
				mainGameView.setVisible(true);
			}
		});
		contentPane.add(btnOk);

		JLabel lblEscolhaQuemComea = new JLabel(
				"Escolha quem come\u00E7a chutando");
		lblEscolhaQuemComea.setBounds(41, 16, 190, 14);
		contentPane.add(lblEscolhaQuemComea);
	}
}
