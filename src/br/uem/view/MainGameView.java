package br.uem.view;

import java.awt.EventQueue;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel imagemGol = new JLabel("");
		imagemGol.setIcon(new ImageIcon(MainGameController.class
				.getResource("/trave.jpg")));
		imagemGol.setBounds(185, 14, 400, 200);

		labelVezDeQuem = new JLabel();
		labelVezDeQuem.setHorizontalAlignment(SwingConstants.CENTER);
		labelVezDeQuem.setBounds(190, 11, 312, 22);

		List pickListJogadores = new List();
		pickListJogadores.setBounds(10, 11, 169, 181);
		selecaoBatedorController = new SelecaoBatedorController();
		selecaoBatedorController.populaListaBatedor(pickListJogadores);

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
		btnEsquerdaCima.setIcon(imagemBotaoDefault);
		btnEsquerdaCima.setBorder(BorderFactory.createEmptyBorder());
		btnEsquerdaCima.setContentAreaFilled(false);
		btnEsquerdaCima.setBounds(190, 46, 32, 32);

		JButton btnMeioCima = new JButton();
		btnMeioCima.setIcon(imagemBotaoDefault);
		btnMeioCima.setBorder(BorderFactory.createEmptyBorder());
		btnMeioCima.setContentAreaFilled(false);
		btnMeioCima.setBounds(340, 46, 32, 32);

		JButton btnDireitoCima = new JButton();
		btnDireitoCima.setIcon(imagemBotaoDefault);
		btnDireitoCima.setBorder(BorderFactory.createEmptyBorder());
		btnDireitoCima.setContentAreaFilled(false);
		btnDireitoCima.setBounds(470, 46, 32, 32);

		JButton btnEsquerdaBaixo = new JButton();
		btnEsquerdaBaixo.setIcon(imagemBotaoDefault);
		btnEsquerdaBaixo.setBorder(BorderFactory.createEmptyBorder());
		btnEsquerdaBaixo.setContentAreaFilled(false);
		btnEsquerdaBaixo.setBounds(190, 150, 32, 32);

		JButton btnMeioBaixo = new JButton();
		btnMeioBaixo.setIcon(imagemBotaoDefault);
		btnMeioBaixo.setBorder(BorderFactory.createEmptyBorder());
		btnMeioBaixo.setContentAreaFilled(false);
		btnMeioBaixo.setBounds(340, 150, 32, 32);

		JButton btnDireitaBaixo = new JButton();
		btnDireitaBaixo.setIcon(imagemBotaoDefault);
		btnDireitaBaixo.setBorder(BorderFactory.createEmptyBorder());
		btnDireitaBaixo.setContentAreaFilled(false);
		btnDireitaBaixo.setBounds(470, 150, 32, 32);

		java.util.List<JButton> botoesChutarDefender = new ArrayList<JButton>();
		botoesChutarDefender.add(btnDireitaBaixo);
		botoesChutarDefender.add(btnDireitoCima);
		botoesChutarDefender.add(btnEsquerdaBaixo);
		botoesChutarDefender.add(btnEsquerdaCima);
		botoesChutarDefender.add(btnMeioBaixo);
		botoesChutarDefender.add(btnMeioCima);

		btnEsquerdaCima.addActionListener(controlaBotao(botoesChutarDefender,
				pickListJogadores));
		btnMeioCima.addActionListener(controlaBotao(botoesChutarDefender,
				pickListJogadores));
		btnDireitoCima.addActionListener(controlaBotao(botoesChutarDefender,
				pickListJogadores));
		btnEsquerdaBaixo.addActionListener(controlaBotao(botoesChutarDefender,
				pickListJogadores));
		btnMeioBaixo.addActionListener(controlaBotao(botoesChutarDefender,
				pickListJogadores));
		btnDireitaBaixo.addActionListener(controlaBotao(botoesChutarDefender,
				pickListJogadores));

		contentPane.add(btnEsquerdaCima);
		contentPane.add(btnMeioCima);
		contentPane.add(btnDireitoCima);
		contentPane.add(btnEsquerdaBaixo);
		contentPane.add(btnMeioBaixo);
		contentPane.add(btnDireitaBaixo);
		contentPane.add(pickListJogadores);
		contentPane.add(labelVezDeQuem);
		contentPane.add(imagemGol);

	}

	public SelecaoBatedorController getSelecaoBatedorController() {
		return selecaoBatedorController;
	}

	public void setSelecaoBatedorController(
			SelecaoBatedorController selecaoBatedorController) {
		this.selecaoBatedorController = selecaoBatedorController;
	}

	public ActionListener controlaBotao(java.util.List<JButton> btnList,
			List listaJogador) {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean isVezJogador = InicializadorGameController
						.getMainGameController().getIsVezJogador();
				if (listaJogador.getSelectedIndex() != -1 || !isVezJogador) {
					if (isVezJogador) {
						for (JButton btn : btnList) {
							btn.setIcon(new ImageIcon(MainGameController.class
									.getResource("/luva.png")));
						}
						labelVezDeQuem.setText(goleirao);
						listaJogador.remove(listaJogador.getSelectedIndex());
						listaJogador.setEnabled(false);
					} else {
						for (JButton btn : btnList) {
							btn.setIcon(new ImageIcon(MainGameController.class
									.getResource("/chute.png")));
						}
						labelVezDeQuem.setText(batedor);
						listaJogador.setEnabled(true);
					}
					InicializadorGameController.getMainGameController()
							.setIsVezJogador(!isVezJogador);
					repaint();
				}
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
