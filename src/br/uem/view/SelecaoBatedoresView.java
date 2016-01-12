package br.uem.view;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import br.uem.controller.SelecaoBatedorController;

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
		setBounds(100, 100, 390, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		Choice batedor1 = new Choice();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, batedor1, -200,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, batedor1,125,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, batedor1, -105,
				SpringLayout.EAST, contentPane);

		Choice batedor2 = new Choice();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, batedor2, -160,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, batedor2,125,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, batedor2, -105,
				SpringLayout.EAST, contentPane);

		Choice batedor3 = new Choice();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, batedor3, -120,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, batedor3,125,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, batedor3, -105,
				SpringLayout.EAST, contentPane);

		Choice batedor4 = new Choice();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, batedor4, -80,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, batedor4,125,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, batedor4, -105,
				SpringLayout.EAST, contentPane);

		Choice batedor5 = new Choice();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, batedor5, -40,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, batedor5, 125,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, batedor5, -105,
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

		Label labelBatedores = new Label("Escolha a ordem dos batedores");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, labelBatedores, -10,
				SpringLayout.NORTH, batedor1);
		contentPane.add(labelBatedores);

		Label labelPrimeiro = new Label("1 -");
		sl_contentPane.putConstraint(SpringLayout.WEST, labelBatedores, 0,
				SpringLayout.WEST, labelPrimeiro);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, labelPrimeiro, -200,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, labelPrimeiro, 5,
				SpringLayout.WEST, batedor1);

		Label labelSegundo = new Label("2 -");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, labelSegundo, -160,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, labelSegundo, 5,
				SpringLayout.WEST, batedor2);

		Label labelTerceiro = new Label("3 -");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, labelTerceiro, -120,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, labelTerceiro, 5,
				SpringLayout.WEST, batedor3);

		Label labelQuarto = new Label("4 -");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, labelQuarto, -80,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, labelQuarto, 5,
				SpringLayout.WEST, batedor4);

		Label labelQuinto = new Label("5 -");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, labelQuinto, -40,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, labelQuinto, 5,
				SpringLayout.WEST, batedor5);

		contentPane.add(labelPrimeiro);
		contentPane.add(labelSegundo);
		contentPane.add(labelTerceiro);
		contentPane.add(labelQuarto);
		contentPane.add(labelQuinto);

		JButton btnOK = new JButton("OK");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnOK, -30,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnOK, 170,
				SpringLayout.WEST, contentPane);
		contentPane.add(btnOK);
	}

	public SelecaoBatedorController getSelecaoBatedorController() {
		return selecaoBatedorController;
	}

	public void setSelecaoBatedorController(
			SelecaoBatedorController selecaoBatedorController) {
		this.selecaoBatedorController = selecaoBatedorController;
	}
}
