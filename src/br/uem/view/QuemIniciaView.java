package br.uem.view;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

/**
 * @author V.Camargo
 * 
 * @Date 04/01/2016
 */

public class QuemIniciaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroupQuemComeca = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuemIniciaView frame = new QuemIniciaView();
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
	public QuemIniciaView() {
		setTitle("Penâltis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(163, 152, 89, 23);
		contentPane.add(btnOk);
		
		JRadioButton rdbtnComearChutando = new JRadioButton("Começar Chutando");
		rdbtnComearChutando.setSelected(true);
		buttonGroupQuemComeca.add(rdbtnComearChutando);
		rdbtnComearChutando.setBounds(142, 48, 166, 23);
		contentPane.add(rdbtnComearChutando);
		
		JRadioButton rdbtnComputadorDecide = new JRadioButton("Computador Decide");
		buttonGroupQuemComeca.add(rdbtnComputadorDecide);
		rdbtnComputadorDecide.setBounds(142, 98, 123, 23);
		contentPane.add(rdbtnComputadorDecide);
	}
}
