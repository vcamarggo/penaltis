package br.uem.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.uem.util.Util;
import javax.swing.SwingConstants;

/**
 * @author V.Camargo
 * 
 * @Date 18/01/2016
 */

public class VencedorView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblVencedor = new JLabel();

	public VencedorView(String nomeTimeVencedor) {
		lblVencedor.setText(Util.toName(nomeTimeVencedor) + " ganhou!");
		setIconImage(StartView.getImagembola());
		setTitle(StartView.getFrasesuperiorjanela());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 386, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		lblVencedor.setBounds(189, 22, 185, 33);
		contentPane.add(lblVencedor);

		JButton btnComearDeNovo = new JButton("Jogar novamente");
		btnComearDeNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				StartView window = new StartView();
				window.getFrmPenaltis().setVisible(true);
			}
		});
		btnComearDeNovo.setBounds(120, 167, 138, 23);
		contentPane.add(btnComearDeNovo);

		JLabel lblBandeiravencedor = new JLabel();
		lblBandeiravencedor.setIcon(new ImageIcon(VencedorView.class
				.getResource("/" + nomeTimeVencedor.toLowerCase() + ".gif")));
		lblBandeiravencedor.setBounds(25, 11, 115, 78);
		contentPane.add(lblBandeiravencedor);
		String nomeVencedor;
		String golsVencedor;
		String historicoVencedor;
		String nomePerdedor;
		String golsPerdedor;
		String historicoPerdedor;

		if (nomeTimeVencedor.equalsIgnoreCase(StartView.getMainGameController()
				.getTimeJogador().getNome())) {
			nomeVencedor = StartView.getMainGameController().getTimeJogador()
					.getNome();
			golsVencedor = StartView.getMainGameController().getGolsJogador()
					.toString();
			historicoVencedor = StartView.getMainGameController()
					.getHistoricoPenaltisJogador();
			nomePerdedor = StartView.getMainGameController().getTimeMaquina()
					.getNome();
			golsPerdedor = StartView.getMainGameController().getGolsMaquina()
					.toString();
			historicoPerdedor = StartView.getMainGameController()
					.getHistoricoPenaltisMaquina();
		} else {
			nomeVencedor = StartView.getMainGameController().getTimeMaquina()
					.getNome();
			golsVencedor = StartView.getMainGameController().getGolsMaquina()
					.toString();
			historicoVencedor = StartView.getMainGameController()
					.getHistoricoPenaltisMaquina();
			nomePerdedor = StartView.getMainGameController().getTimeJogador()
					.getNome();
			golsPerdedor = StartView.getMainGameController().getGolsJogador()
					.toString();
			historicoPerdedor = StartView.getMainGameController()
					.getHistoricoPenaltisJogador();
		}

		JLabel labelNomeVencedor = new JLabel();
		labelNomeVencedor.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeVencedor.setText(nomeVencedor);
		labelNomeVencedor.setBounds(166, 67, 73, 33);
		contentPane.add(labelNomeVencedor);

		JLabel labelNomePerdedor = new JLabel();
		labelNomePerdedor.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomePerdedor.setText(nomePerdedor);
		labelNomePerdedor.setBounds(166, 111, 73, 33);
		contentPane.add(labelNomePerdedor);

		JLabel lblGolsVencedor = new JLabel();
		lblGolsVencedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblGolsVencedor.setText(golsVencedor);
		lblGolsVencedor.setBounds(239, 66, 29, 33);
		contentPane.add(lblGolsVencedor);

		JLabel lblGolsPerdedor = new JLabel();
		lblGolsPerdedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblGolsPerdedor.setText(golsPerdedor);
		lblGolsPerdedor.setBounds(239, 111, 29, 33);
		contentPane.add(lblGolsPerdedor);

		JLabel lblHistoricoVencedor = new JLabel();
		lblHistoricoVencedor.setText(historicoVencedor);
		lblHistoricoVencedor.setHorizontalAlignment(SwingConstants.LEFT);
		lblHistoricoVencedor.setBounds(271, 66, 113, 33);
		contentPane.add(lblHistoricoVencedor);

		JLabel lblHistoricoPerdedor = new JLabel();
		lblHistoricoPerdedor.setText(historicoPerdedor);
		lblHistoricoPerdedor.setHorizontalAlignment(SwingConstants.LEFT);
		lblHistoricoPerdedor.setBounds(271, 111, 113, 33);
		contentPane.add(lblHistoricoPerdedor);
	}
}
