package br.uem.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.uem.enumeration.Instrucoes;

import javax.swing.JLabel;
import java.awt.TextArea;
import java.awt.Color;

public class OpcoesView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	public OpcoesView() {
		setIconImage(StartView.getImagembola());
		setTitle(StartView.getFrasesuperiorjanela());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 400, 360, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		TextArea textArea = new TextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setText(Instrucoes.OBJETIVO.getInstrucoes()+ Instrucoes.COMOJOGAR.getInstrucoes());
		//textArea.
		textArea.setEditable(false);
		textArea.setBounds(10, 20, 162, 179);
		contentPane.add(textArea);
		
		JLabel lblFundoOpcoes = new JLabel();
		lblFundoOpcoes.setIcon(new ImageIcon(OpcoesView.class.getResource("/fundoOpcoes.jpg")));
		lblFundoOpcoes.setBounds(0, 0, 354, 209);
		contentPane.add(lblFundoOpcoes);
	}
}
