package br.uem.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author V.Camargo
 * 
 * @Date 18/01/2016
 */

public class VencedorView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblVencedor = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VencedorView frame = new VencedorView("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VencedorView(String nomeTimeVencedor) {
		lblVencedor.setText(nomeTimeVencedor + "ganhou");
		setIconImage(StartView.getImagembola());
		setTitle("Penâltis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblVencedor.setBounds(219, 99, 338, 58);
		contentPane.add(lblVencedor);

		JButton btnComearDeNovo = new JButton("Começar de novo");
		btnComearDeNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				StartView window = new StartView();
				window.getFrmPenaltis().setVisible(true);
			}
		});
		btnComearDeNovo.setBounds(348, 220, 138, 23);
		contentPane.add(btnComearDeNovo);
	}
}
