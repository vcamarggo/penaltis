package br.uem.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.uem.enumeration.Times;

/**
 * Cria a tela de exibição do vencedor
 * 
 * @author V.Camargo
 * 
 * @Date 18/01/2016
 */

public class VencedorView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblVencedor = new JLabel();

	public VencedorView(String nomeTimeVencedor) {
		lblVencedor.setText(Times.valueOf(nomeTimeVencedor).toString() + " ganhou!");
		setIconImage(StartView.getImagembola());
		setTitle(StartView.getFraseSuperiorJanela());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(486, 150, 386, 240);
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
				StartView.getOpcoes().dispose();
				dispose();
				StartView window = new StartView();
				window.getFrmPenaltis().setVisible(true);
			}
		});
		btnComearDeNovo.setBounds(120, 167, 138, 23);
		contentPane.add(btnComearDeNovo);

		JLabel lblBandeiravencedor = new JLabel();
		lblBandeiravencedor
				.setIcon(new ImageIcon(VencedorView.class.getResource("/" + nomeTimeVencedor.toLowerCase() + ".gif")));
		lblBandeiravencedor.setBounds(25, 11, 115, 78);
		contentPane.add(lblBandeiravencedor);

		JLabel labelNomeVencedor = new JLabel();
		labelNomeVencedor.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeVencedor.setBounds(166, 67, 73, 33);

		JLabel labelNomePerdedor = new JLabel();
		labelNomePerdedor.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomePerdedor.setBounds(166, 111, 73, 33);

		JLabel lblGolsVencedor = new JLabel();
		lblGolsVencedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblGolsVencedor.setBounds(239, 66, 29, 33);

		JLabel lblGolsPerdedor = new JLabel();
		lblGolsPerdedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblGolsPerdedor.setBounds(239, 111, 29, 33);

		JLabel lblHistoricoVencedor = new JLabel();
		lblHistoricoVencedor.setHorizontalAlignment(SwingConstants.LEFT);
		lblHistoricoVencedor.setBounds(271, 66, 113, 33);

		JLabel lblHistoricoPerdedor = new JLabel();
		lblHistoricoPerdedor.setHorizontalAlignment(SwingConstants.LEFT);
		lblHistoricoPerdedor.setBounds(271, 111, 113, 33);

		atualizaTextosLabels(nomeTimeVencedor, labelNomeVencedor, labelNomePerdedor, lblGolsVencedor, lblGolsPerdedor,
				lblHistoricoVencedor, lblHistoricoPerdedor);
		contentPane.add(labelNomeVencedor);
		contentPane.add(labelNomePerdedor);
		contentPane.add(lblGolsVencedor);
		contentPane.add(lblGolsPerdedor);
		contentPane.add(lblHistoricoVencedor);
		contentPane.add(lblHistoricoPerdedor);
	}

	/**
	 * Atualiza labels com os valores atualizados das variaveis de gols,
	 * historicos e nomes de times.
	 * 
	 * @param nomeTimeVencedor
	 * @param labelNomeVencedor
	 * @param labelNomePerdedor
	 * @param lblGolsVencedor
	 * @param lblGolsPerdedor
	 * @param lblHistoricoVencedor
	 * @param lblHistoricoPerdedor
	 * 
	 */
	private void atualizaTextosLabels(String nomeTimeVencedor, JLabel labelNomeVencedor, JLabel labelNomePerdedor,
			JLabel lblGolsVencedor, JLabel lblGolsPerdedor, JLabel lblHistoricoVencedor, JLabel lblHistoricoPerdedor) {
		if (nomeTimeVencedor.equalsIgnoreCase(StartView.getMainGameController().getTimeJogador().getNome())) {
			labelNomeVencedor.setText(StartView.getMainGameController().getTimeJogador().getNome());
			lblGolsVencedor.setText(StartView.getMainGameController().getGolsJogador().toString());
			lblHistoricoVencedor.setText(StartView.getMainGameController().getHistoricoPenaltisJogador());
			labelNomePerdedor.setText(StartView.getMainGameController().getTimeMaquina().getNome());
			lblGolsPerdedor.setText(StartView.getMainGameController().getGolsMaquina().toString());
			lblHistoricoPerdedor.setText(StartView.getMainGameController().getHistoricoPenaltisMaquina());
		} else {
			labelNomeVencedor.setText(StartView.getMainGameController().getTimeMaquina().getNome());
			lblGolsVencedor.setText(StartView.getMainGameController().getGolsMaquina().toString());
			lblHistoricoVencedor.setText(StartView.getMainGameController().getHistoricoPenaltisMaquina());
			labelNomePerdedor.setText(StartView.getMainGameController().getTimeJogador().getNome());
			lblGolsPerdedor.setText(StartView.getMainGameController().getGolsJogador().toString());
			lblHistoricoPerdedor.setText(StartView.getMainGameController().getHistoricoPenaltisJogador());
		}
	}
}
