package br.uem.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.uem.controller.InicializadorGameController;
import br.uem.controller.MainGameController;
import br.uem.controller.SelecaoBatedorController;
import br.uem.enumeration.Ponto;
import br.uem.util.Util;

/**
 * @author V.Camargo
 * 
 * @Date 13/01/2016
 */

public class MainGameView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private SelecaoBatedorController selecaoBatedorController;
	private static final String goleirao = "Defende aí goleirão!";
	private static final String batedor = "Escolhe o lugar e chuta!";
	private JLabel labelVezDeQuem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGameView frame = new MainGameView();
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
	public MainGameView() {
		setTitle("Penâltis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel imagemGol = new JLabel("");
		imagemGol.setIcon(new ImageIcon(MainGameController.class
				.getResource("/trave.jpg")));
		imagemGol.setBounds(185, 22, 420, 200);

		labelVezDeQuem = new JLabel();
		labelVezDeQuem.setHorizontalAlignment(SwingConstants.CENTER);
		labelVezDeQuem.setBounds(200, 13, 420, 22);

		List pickListJogadores = new List();
		pickListJogadores.setBounds(10, 30, 169, 185);
		selecaoBatedorController = new SelecaoBatedorController();
		selecaoBatedorController.populaListaBatedor(pickListJogadores,
				InicializadorGameController.getMainGameController()
						.getTimeJogador());

		List pickListMaquina = new List();
		pickListMaquina.setBounds(611, 30, 169, 185);
		selecaoBatedorController.populaListaBatedor(pickListMaquina,
				InicializadorGameController.getMainGameController()
						.getTimeMaquina());
		pickListMaquina.setEnabled(false);

		ImageIcon imagemBotaoDefault = null;

		if (InicializadorGameController.getMainGameController()
				.getJogadorComeca()) {
			imagemBotaoDefault = new ImageIcon(
					MainGameController.class.getResource("/chute.png"));
			labelVezDeQuem.setText(batedor);
		} else {
			imagemBotaoDefault = new ImageIcon(
					MainGameController.class.getResource("/luva.png"));
			labelVezDeQuem.setText(goleirao);
			pickListJogadores.setEnabled(false);
		}

		JButton btnEsquerdaCima = new JButton();
		btnEsquerdaCima.setName("ESQUERDA_CIMA");
		btnEsquerdaCima.setIcon(imagemBotaoDefault);
		btnEsquerdaCima.setBorder(BorderFactory.createEmptyBorder());
		btnEsquerdaCima.setContentAreaFilled(false);
		btnEsquerdaCima.setBounds(210, 47, 32, 32);

		JButton btnMeioCima = new JButton();
		btnMeioCima.setName("MEIO_CIMA");
		btnMeioCima.setIcon(imagemBotaoDefault);
		btnMeioCima.setBorder(BorderFactory.createEmptyBorder());
		btnMeioCima.setContentAreaFilled(false);
		btnMeioCima.setBounds(372, 47, 32, 32);

		JButton btnDireitoCima = new JButton();
		btnDireitoCima.setName("DIREITA_CIMA");
		btnDireitoCima.setIcon(imagemBotaoDefault);
		btnDireitoCima.setBorder(BorderFactory.createEmptyBorder());
		btnDireitoCima.setContentAreaFilled(false);
		btnDireitoCima.setBounds(532, 47, 32, 32);

		JButton btnEsquerdaBaixo = new JButton();
		btnEsquerdaBaixo.setName("ESQUERDA_BAIXO");
		btnEsquerdaBaixo.setIcon(imagemBotaoDefault);
		btnEsquerdaBaixo.setBorder(BorderFactory.createEmptyBorder());
		btnEsquerdaBaixo.setContentAreaFilled(false);
		btnEsquerdaBaixo.setBounds(210, 164, 32, 32);

		JButton btnMeioBaixo = new JButton();
		btnMeioBaixo.setName("MEIO_BAIXO");
		btnMeioBaixo.setIcon(imagemBotaoDefault);
		btnMeioBaixo.setBorder(BorderFactory.createEmptyBorder());
		btnMeioBaixo.setContentAreaFilled(false);
		btnMeioBaixo.setBounds(372, 164, 32, 32);

		JButton btnDireitaBaixo = new JButton();
		btnDireitaBaixo.setName("DIREITA_CIMA");
		btnDireitaBaixo.setIcon(imagemBotaoDefault);
		btnDireitaBaixo.setBorder(BorderFactory.createEmptyBorder());
		btnDireitaBaixo.setContentAreaFilled(false);
		btnDireitaBaixo.setBounds(536, 164, 32, 32);

		java.util.List<JButton> botoesChutarDefender = new ArrayList<JButton>();
		botoesChutarDefender.add(btnDireitaBaixo);
		botoesChutarDefender.add(btnDireitoCima);
		botoesChutarDefender.add(btnEsquerdaBaixo);
		botoesChutarDefender.add(btnEsquerdaCima);
		botoesChutarDefender.add(btnMeioBaixo);
		botoesChutarDefender.add(btnMeioCima);

		btnEsquerdaCima.addActionListener(controlaBotao(botoesChutarDefender,
				pickListJogadores, pickListMaquina));
		btnMeioCima.addActionListener(controlaBotao(botoesChutarDefender,
				pickListJogadores, pickListMaquina));
		btnDireitoCima.addActionListener(controlaBotao(botoesChutarDefender,
				pickListJogadores, pickListMaquina));
		btnEsquerdaBaixo.addActionListener(controlaBotao(botoesChutarDefender,
				pickListJogadores, pickListMaquina));
		btnMeioBaixo.addActionListener(controlaBotao(botoesChutarDefender,
				pickListJogadores, pickListMaquina));
		btnDireitaBaixo.addActionListener(controlaBotao(botoesChutarDefender,
				pickListJogadores, pickListMaquina));

		contentPane.add(btnEsquerdaCima);
		contentPane.add(btnMeioCima);
		contentPane.add(btnDireitoCima);
		contentPane.add(btnEsquerdaBaixo);
		contentPane.add(btnMeioBaixo);
		contentPane.add(btnDireitaBaixo);
		contentPane.add(pickListJogadores);
		contentPane.add(pickListMaquina);
		contentPane.add(labelVezDeQuem);
		contentPane.add(imagemGol);

		JLabel lblJogador = new JLabel("JOGADOR");
		lblJogador.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogador.setBounds(10, 10, 169, 14);
		contentPane.add(lblJogador);

		JLabel lblMquina = new JLabel("M\u00C1QUINA");
		lblMquina.setHorizontalAlignment(SwingConstants.CENTER);
		lblMquina.setBounds(611, 13, 169, 14);
		contentPane.add(lblMquina);

		JLabel lblTimeJogador = new JLabel(InicializadorGameController
				.getMainGameController().getTimeJogador().getNome());
		lblTimeJogador.setForeground(Color.BLACK);
		lblTimeJogador.setFont(new Font("Arial Unicode MS", Font.BOLD, 18));
		lblTimeJogador.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTimeJogador.setBounds(185, 233, 146, 31);
		contentPane.add(lblTimeJogador);

		JLabel lblTimeMaquina = new JLabel(InicializadorGameController
				.getMainGameController().getTimeMaquina().getNome());
		lblTimeMaquina.setForeground(Color.BLACK);
		lblTimeMaquina.setFont(new Font("Arial Unicode MS", Font.BOLD, 18));
		lblTimeMaquina.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimeMaquina.setBounds(448, 233, 146, 31);
		contentPane.add(lblTimeMaquina);

		JLabel lblPlacar = new JLabel(InicializadorGameController
				.getMainGameController().getGolsJogador().toString()
				+ "  X  "
				+ InicializadorGameController.getMainGameController()
						.getGolsMaquina().toString());
		lblPlacar.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlacar.setForeground(Color.BLACK);
		lblPlacar.setFont(new Font("Arial Unicode MS", Font.BOLD, 18));
		lblPlacar.setBounds(350, 233, 86, 31);
		contentPane.add(lblPlacar);
	}

	public SelecaoBatedorController getSelecaoBatedorController() {
		return selecaoBatedorController;
	}

	public void setSelecaoBatedorController(
			SelecaoBatedorController selecaoBatedorController) {
		this.selecaoBatedorController = selecaoBatedorController;
	}

	public ActionListener controlaBotao(java.util.List<JButton> btnList,
			List listaJogador, List listaMaquina) {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean isVezJogador = InicializadorGameController
						.getMainGameController().getIsVezJogador();
				int indiceBatedorMaquina = Util.gerarRandomAteN(listaMaquina
						.getItemCount() - 1);

				if (isVezJogador) {
					for (JButton btn : btnList) {
						btn.setIcon(new ImageIcon(MainGameController.class
								.getResource("/luva.png")));
					}

					labelVezDeQuem.setText(goleirao);
					listaMaquina.select(indiceBatedorMaquina);

					int indice = -2;
					if (listaJogador.getSelectedIndex() == -1) {
						indice = Util.gerarRandomAteN(listaJogador
								.getItemCount() - 1);
					} else {
						indice = listaJogador.getSelectedIndex();
					}
					InicializadorGameController.getMainGameController()
							.direcionar(
									listaJogador.getItem(indice),
									Ponto.valueOf(((JButton) arg0.getSource())
											.getName()));

					listaJogador.remove(indice);
					listaJogador.setEnabled(false);
				} else {
					for (JButton btn : btnList) {
						btn.setIcon(new ImageIcon(MainGameController.class
								.getResource("/chute.png")));
					}

					InicializadorGameController.getMainGameController()
							.testarDefesa(
									listaMaquina.getSelectedItem(),
									Ponto.valueOf(((JButton) arg0.getSource())
											.getName()));
					listaMaquina.remove(listaMaquina.getSelectedIndex());
					labelVezDeQuem.setText(batedor);
					listaJogador.setEnabled(true);
				}
				InicializadorGameController.getMainGameController()
						.setIsVezJogador(!isVezJogador);
				repaint();
			}
		};
		return action;
	}

	public JLabel getLabelVezDeQuem() {
		return labelVezDeQuem;
	}

	public void setLabelVezDeQuem(JLabel labelVezDeQuem) {
		this.labelVezDeQuem = labelVezDeQuem;
	}
}
