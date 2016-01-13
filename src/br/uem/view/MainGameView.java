package br.uem.view;

import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import br.uem.controller.MainGameController;
import br.uem.controller.SelecaoBatedorController;
import java.awt.Color;

/**
 * @author V.Camargo
 * 
 * @Date 13/01/2016
 */

public class MainGameView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private SelecaoBatedorController selecaoBatedorController;

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

		List list = new List();
		list.setBounds(10, 11, 169, 181);
		selecaoBatedorController = new SelecaoBatedorController();
		selecaoBatedorController.populaListaBatedor(list);

		contentPane.add(list);

		JButton btnChutar = new JButton("Chutar");
		btnChutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.remove(list.getSelectedIndex());
				repaint();
			}
		});
		btnChutar.setBounds(185, 11, 89, 23);
		contentPane.add(btnChutar);

		JRadioButton rdbtnEsquerdaCima = new JRadioButton();
		rdbtnEsquerdaCima.setOpaque(false);
		rdbtnEsquerdaCima.setFocusPainted(false);
		rdbtnEsquerdaCima.setContentAreaFilled(false);
		rdbtnEsquerdaCima.setBorderPainted(false);
		rdbtnEsquerdaCima.setBorder(null);
		rdbtnEsquerdaCima.setBackground(Color.LIGHT_GRAY);
		rdbtnEsquerdaCima.setBounds(195, 46, 21, 23);

		JRadioButton rdbtnMeioCima = new JRadioButton();
		rdbtnMeioCima.setBackground(Color.LIGHT_GRAY);
		rdbtnMeioCima.setBounds(360, 46, 21, 23);
		rdbtnMeioCima.setBorder(null);
		rdbtnMeioCima.setBorderPainted(false);
		rdbtnMeioCima.setContentAreaFilled(false);
		rdbtnMeioCima.setFocusPainted(false);
		rdbtnMeioCima.setOpaque(false);

		JRadioButton rdbtnDireitoCima = new JRadioButton();
		rdbtnDireitoCima.setOpaque(false);
		rdbtnDireitoCima.setFocusPainted(false);
		rdbtnDireitoCima.setContentAreaFilled(false);
		rdbtnDireitoCima.setBorderPainted(false);
		rdbtnDireitoCima.setBorder(null);
		rdbtnDireitoCima.setBackground(Color.LIGHT_GRAY);
		rdbtnDireitoCima.setBounds(483, 46, 21, 23);

		JRadioButton rdbtnEsquerdaBaixo = new JRadioButton();
		rdbtnEsquerdaBaixo.setOpaque(false);
		rdbtnEsquerdaBaixo.setFocusPainted(false);
		rdbtnEsquerdaBaixo.setContentAreaFilled(false);
		rdbtnEsquerdaBaixo.setBorderPainted(false);
		rdbtnEsquerdaBaixo.setBorder(null);
		rdbtnEsquerdaBaixo.setBackground(Color.LIGHT_GRAY);
		rdbtnEsquerdaBaixo.setBounds(195, 160, 21, 23);

		JRadioButton rdbtnMeioBaixo = new JRadioButton();
		rdbtnMeioBaixo.setOpaque(false);
		rdbtnMeioBaixo.setFocusPainted(false);
		rdbtnMeioBaixo.setContentAreaFilled(false);
		rdbtnMeioBaixo.setBorderPainted(false);
		rdbtnMeioBaixo.setBorder(null);
		rdbtnMeioBaixo.setBackground(Color.LIGHT_GRAY);
		rdbtnMeioBaixo.setBounds(360, 160, 21, 23);

		JRadioButton rdbtnDireitaBaixo = new JRadioButton();
		rdbtnDireitaBaixo.setOpaque(false);
		rdbtnDireitaBaixo.setFocusPainted(false);
		rdbtnDireitaBaixo.setContentAreaFilled(false);
		rdbtnDireitaBaixo.setBorderPainted(false);
		rdbtnDireitaBaixo.setBorder(null);
		rdbtnDireitaBaixo.setBackground(Color.LIGHT_GRAY);
		rdbtnDireitaBaixo.setBounds(483, 160, 21, 23);

		contentPane.add(rdbtnEsquerdaCima);
		contentPane.add(rdbtnMeioCima);
		contentPane.add(rdbtnDireitoCima);
		contentPane.add(rdbtnEsquerdaBaixo);
		contentPane.add(rdbtnMeioBaixo);
		contentPane.add(rdbtnDireitaBaixo);

		JLabel imagemGol = new JLabel("");
		imagemGol.setIcon(new ImageIcon(MainGameController.class
				.getResource("/trave.jpg")));
		imagemGol.setBounds(185, 14, 400, 200);
		contentPane.add(imagemGol);
	}

	public SelecaoBatedorController getSelecaoBatedorController() {
		return selecaoBatedorController;
	}

	public void setSelecaoBatedorController(
			SelecaoBatedorController selecaoBatedorController) {
		this.selecaoBatedorController = selecaoBatedorController;
	}
}
