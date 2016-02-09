package br.uem.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import br.uem.util.Util;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Cria janela para seleção de quem inicia as cobranças de pênaltis
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
		setBounds(500, 150, 360, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		JRadioButton rdbtnComecarChutando = new JRadioButton("Começar Chutando");
		rdbtnComecarChutando.setBounds(99, 64, 158, 23);
		rdbtnComecarChutando.setBackground(new Color(245, 222, 179));
		rdbtnComecarChutando.setSelected(true);
		buttonGroupQuemComeca.add(rdbtnComecarChutando);
		contentPane.add(rdbtnComecarChutando);

		JRadioButton rdbtnComputadorDecide = new JRadioButton(
				"Computador Decide");
		rdbtnComputadorDecide.setBounds(99, 104, 158, 23);
		rdbtnComputadorDecide.setBackground(new Color(245, 222, 179));
		buttonGroupQuemComeca.add(rdbtnComputadorDecide);
		contentPane.add(rdbtnComputadorDecide);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(151, 149, 54, 23);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnComputadorDecide.isSelected()
						&& Util.gerarRandomAteN(1) == 1) {
					// se computador decide, então qualquer um pode começar
					// chutando
					StartView.getMainGameController().setJogadorComeca(false);
				} else {
					// senão, jogador começa chutando
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

		JLabel lblEscolhaQuemComeca = new JLabel(
				"Escolha quem come\u00E7a chutando");
		lblEscolhaQuemComeca.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscolhaQuemComeca.setBounds(65, 25, 223, 14);
		lblEscolhaQuemComeca.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEscolhaQuemComeca.setForeground(Color.WHITE);
		contentPane.add(lblEscolhaQuemComeca);
		
		contentPane.add(lblEscolhaQuemComeca);
		JLabel lblFundoSelecao = new JLabel();
		lblFundoSelecao.setIcon(new ImageIcon(OpcoesView.class.getResource("/fundoOpcoes.jpg")));
		lblFundoSelecao.setBounds(0, 0, 354, 209);
		contentPane.add(lblFundoSelecao);
	}
}
