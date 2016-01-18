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
	private static final ImageIcon imagemChute = new ImageIcon(
			MainGameController.class.getResource("/chute.png"));
	private static final ImageIcon imagemLuva = new ImageIcon(
			MainGameController.class.getResource("/luva.png"));

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
		setIconImage(StartView.getImagembola());
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

		JLabel lblFraseTorcidaJogador = new JLabel();
		lblFraseTorcidaJogador.setHorizontalAlignment(SwingConstants.CENTER);
		lblFraseTorcidaJogador.setBounds(10, 221, 169, 14);
		contentPane.add(lblFraseTorcidaJogador);

		JLabel lblFraseTorcidaMaquina = new JLabel();
		lblFraseTorcidaMaquina.setHorizontalAlignment(SwingConstants.CENTER);
		lblFraseTorcidaMaquina.setBounds(611, 221, 169, 14);
		contentPane.add(lblFraseTorcidaMaquina);

		JLabel lblHistoricoPenaltisJogador = new JLabel();
		lblHistoricoPenaltisJogador
				.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistoricoPenaltisJogador.setBounds(10, 250, 169, 14);
		contentPane.add(lblHistoricoPenaltisJogador);

		JLabel lblHistoricoPenaltisMaquina = new JLabel();
		lblHistoricoPenaltisMaquina
				.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistoricoPenaltisMaquina.setBounds(611, 250, 169, 14);
		contentPane.add(lblHistoricoPenaltisMaquina);

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

		JLabel lblPlacar = new JLabel(getStringPlacar());
		lblPlacar.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlacar.setForeground(Color.BLACK);
		lblPlacar.setFont(new Font("Arial Unicode MS", Font.BOLD, 18));
		lblPlacar.setBounds(350, 233, 86, 31);
		contentPane.add(lblPlacar);

		JLabel lblVezDeQuem = new JLabel();
		lblVezDeQuem.setHorizontalAlignment(SwingConstants.CENTER);
		lblVezDeQuem.setBounds(200, 13, 420, 22);

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
			imagemBotaoDefault = imagemChute;
			lblVezDeQuem.setText(batedor);
		} else {
			imagemBotaoDefault = imagemLuva;
			lblVezDeQuem.setText(goleirao);
			pickListJogadores.setEnabled(false);
			pickListMaquina.select(Util.gerarRandomAteN(pickListMaquina
					.getItemCount() - 1));

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

		for (JButton jButton : botoesChutarDefender) {
			jButton.addActionListener(controlaBotao(botoesChutarDefender,
					pickListJogadores, pickListMaquina, lblPlacar,
					lblVezDeQuem, lblHistoricoPenaltisJogador,
					lblHistoricoPenaltisMaquina, lblFraseTorcidaMaquina,
					lblFraseTorcidaJogador));
		}

		contentPane.add(btnEsquerdaCima);
		contentPane.add(btnMeioCima);
		contentPane.add(btnDireitoCima);
		contentPane.add(btnEsquerdaBaixo);
		contentPane.add(btnMeioBaixo);
		contentPane.add(btnDireitaBaixo);
		contentPane.add(pickListJogadores);
		contentPane.add(pickListMaquina);
		contentPane.add(lblVezDeQuem);
		contentPane.add(imagemGol);

		JLabel lblJogador = new JLabel("JOGADOR");
		lblJogador.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogador.setBounds(10, 10, 169, 14);
		contentPane.add(lblJogador);

		JLabel lblMquina = new JLabel("MÁQUINA");
		lblMquina.setHorizontalAlignment(SwingConstants.CENTER);
		lblMquina.setBounds(611, 13, 169, 14);
		contentPane.add(lblMquina);

	}

	private String getStringPlacar() {
		return InicializadorGameController.getMainGameController()
				.getGolsJogador().toString()
				+ "  X  "
				+ InicializadorGameController.getMainGameController()
						.getGolsMaquina().toString();

	}

	public ActionListener controlaBotao(java.util.List<JButton> btnList,
			List listaJogador, List listaMaquina, JLabel lblPlacar,
			JLabel lblVezDeQuem, JLabel lblHistoricoPenaltisJogador,
			JLabel lblHistoricoPenaltisMaquina, JLabel lblFraseTorcidaMaquina,
			JLabel lblFraseTorcidaJogador) {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean isVezJogador = InicializadorGameController
						.getMainGameController().getIsVezJogador();
				if (isVezJogador) {
					for (JButton btn : btnList) {
						btn.setIcon(imagemLuva);
					}

					lblVezDeQuem.setText(goleirao);
					int indiceBatedorMaquina = Util
							.gerarRandomAteN(listaMaquina.getItemCount() - 1);
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
						btn.setIcon(imagemChute);
					}

					InicializadorGameController.getMainGameController()
							.direcionar(
									listaMaquina.getSelectedItem(),
									Ponto.valueOf(((JButton) arg0.getSource())
											.getName()));
					listaMaquina.remove(listaMaquina.getSelectedIndex());
					lblVezDeQuem.setText(batedor);
					listaJogador.setEnabled(true);
				}
				InicializadorGameController.getMainGameController()
						.setIsVezJogador(!isVezJogador);
				if (listaJogador.getItemCount() == 0) {
					selecaoBatedorController.populaListaBatedor(listaJogador,
							InicializadorGameController.getMainGameController()
									.getTimeJogador());
				}
				if (listaMaquina.getItemCount() == 0) {
					selecaoBatedorController.populaListaBatedor(listaMaquina,
							InicializadorGameController.getMainGameController()
									.getTimeMaquina());
				}
				lblPlacar.setText(getStringPlacar());

				lblHistoricoPenaltisJogador.setText(InicializadorGameController
						.getMainGameController().getHistoricoPenaltisJogador());
				lblFraseTorcidaJogador.setText(InicializadorGameController
						.getMainGameController().getFraseTorcidaJogador());

				lblHistoricoPenaltisMaquina.setText(InicializadorGameController
						.getMainGameController().getHistoricoPenaltisMaquina());
				lblFraseTorcidaMaquina.setText(InicializadorGameController
						.getMainGameController().getFraseTorcidaMaquina());

				repaint();

				if (InicializadorGameController.getMainGameController()
						.getNomeTimeGanhador() != null) {
					dispose();
					VencedorView vencedorView = new VencedorView();
					vencedorView.setVisible(true);
				}
			}
		};
		return action;
	}

	public SelecaoBatedorController getSelecaoBatedorController() {
		return selecaoBatedorController;
	}

	public void setSelecaoBatedorController(
			SelecaoBatedorController selecaoBatedorController) {
		this.selecaoBatedorController = selecaoBatedorController;
	}
}
