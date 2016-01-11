package br.uem.view;

import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import br.uem.controller.SelecaoBatedorController;
import java.awt.Toolkit;

/**
 * @author V.Camargo
 * 
 * @Date 09/01/2016
 */

public class SelecaoBatedoresView extends JFrame {

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
					SelecaoBatedoresView frame = new SelecaoBatedoresView();
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
	public SelecaoBatedoresView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				SelecaoBatedoresView.class.getResource("/bola.jpg")));
		setTitle("Pênaltis - Seleção de batedores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		Choice batedor1 = new Choice();
		Choice batedor2 = new Choice();
		Choice batedor3 = new Choice();
		Choice batedor4 = new Choice();
		Choice batedor5 = new Choice();

		sl_contentPane.putConstraint(SpringLayout.NORTH, batedor1, 60,
				SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, batedor1, 167,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, batedor1, -151,
				SpringLayout.EAST, contentPane);

		sl_contentPane.putConstraint(SpringLayout.NORTH, batedor2, 100,
				SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, batedor2, 167,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, batedor2, -151,
				SpringLayout.EAST, contentPane);

		sl_contentPane.putConstraint(SpringLayout.NORTH, batedor3, 140,
				SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, batedor3, 167,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, batedor3, -151,
				SpringLayout.EAST, contentPane);

		sl_contentPane.putConstraint(SpringLayout.NORTH, batedor4, 180,
				SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, batedor4, 167,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, batedor4, -151,
				SpringLayout.EAST, contentPane);

		sl_contentPane.putConstraint(SpringLayout.NORTH, batedor5, 220,
				SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, batedor5, 167,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, batedor5, -151,
				SpringLayout.EAST, contentPane);

		selecaoBatedorController = new SelecaoBatedorController();
		selecaoBatedorController.populaListaBatedor(batedor1);
		selecaoBatedorController.populaListaBatedor(batedor2);
		selecaoBatedorController.populaListaBatedor(batedor3);
		selecaoBatedorController.populaListaBatedor(batedor4);
		selecaoBatedorController.populaListaBatedor(batedor5);

		contentPane.add(batedor1);
		contentPane.add(batedor2);
		contentPane.add(batedor3);
		contentPane.add(batedor4);
		contentPane.add(batedor5);

	}

	public SelecaoBatedorController getSelecaoBatedorController() {
		return selecaoBatedorController;
	}

	public void setSelecaoBatedorController(
			SelecaoBatedorController selecaoBatedorController) {
		this.selecaoBatedorController = selecaoBatedorController;
	}

}
