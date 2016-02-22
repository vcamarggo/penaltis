package br.uem.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.uem.enumeration.Instrucoes;

import javax.swing.JLabel;
import java.awt.TextArea;
import java.awt.Color;
import java.awt.Font;

public class OpcoesView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public OpcoesView() {
		setIconImage(StartView.getImagembola());
		setTitle(StartView.getFraseSuperiorJanela());
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 400, 360, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		TextArea textArea = new TextArea("", 10, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);

		textArea.setText(Instrucoes.OBJETIVO + Instrucoes.OBJETIVO.getInstrucoes() + "\n\n" + "COMO JOGAR"
				+ Instrucoes.COMOJOGAR.getInstrucoes());
		textArea.setEditable(false);
		textArea.setBounds(10, 20, 162, 179);
		contentPane.add(textArea);

		JLabel lblFundoOpcoes = new JLabel();
		lblFundoOpcoes.setIcon(new ImageIcon(OpcoesView.class.getResource("/fundoOpcoes.jpg")));
		lblFundoOpcoes.setBounds(0, 0, 354, 209);
		contentPane.add(lblFundoOpcoes);
	}
}
