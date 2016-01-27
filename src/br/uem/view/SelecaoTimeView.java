package br.uem.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import br.uem.controller.TimesController;
import br.uem.enumeration.Times;
import javax.swing.SwingConstants;

/**
 * Cria a tela de seleção de time.
 * 
 * @author V.Camargo
 * 
 * @Date 29/12/2015
 */

public class SelecaoTimeView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JRadioButton btnBrasil = new JRadioButton(Times.BRASIL.toString());
	private final JLabel bandeiraBrasil = new JLabel("");

	private JRadioButton btnArgentina = new JRadioButton(
			Times.ARGENTINA.toString());
	private final JLabel bandeiraArgentina = new JLabel("");

	private JRadioButton btnDeustchland = new JRadioButton(
			Times.ALEMANHA.toString());
	private final JLabel bandeiraDeustchland = new JLabel("");

	private JRadioButton btnEspanha = new JRadioButton(Times.ESPANHA.toString());
	private final JLabel bandeiraEspanha = new JLabel("");

	private JRadioButton btnChile = new JRadioButton(Times.CHILE.toString());
	private final JLabel bandeiraChile = new JLabel("");

	private JRadioButton btnPortugal = new JRadioButton(
			Times.PORTUGAL.toString());
	private final JLabel bandeiraPortugal = new JLabel("");

	private final JButton btnOK = new JButton("OK");

	private String nomeTimeEscolhido;
	private final JLabel lblEscolhaSeuTime = new JLabel("Escolha seu time");

	/**
	 * Cria janela
	 */
	public SelecaoTimeView() {
		setIconImage(StartView.getImagembola());
		setTitle(StartView.getFrasesuperiorjanela());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 351, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);

		bandeiraArgentina.setBounds(42, 47, 31, 20);
		bandeiraArgentina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnArgentina.setSelected(true);
			}
		});
		contentPane.setLayout(null);
		bandeiraArgentina.setIcon(new ImageIcon(SelecaoTimeView.class
				.getResource("/ar.png")));
		contentPane.add(bandeiraArgentina);
		btnArgentina.setBounds(79, 46, 95, 23);
		contentPane.add(btnArgentina);

		bandeiraBrasil.setBounds(191, 48, 29, 20);
		bandeiraBrasil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnBrasil.setSelected(true);
			}
		});

		bandeiraBrasil.setIcon(new ImageIcon(SelecaoTimeView.class
				.getResource("/br.png")));
		contentPane.add(bandeiraBrasil);
		btnBrasil.setBounds(226, 47, 89, 23);
		btnBrasil.setSelected(true);
		contentPane.add(btnBrasil);

		bandeiraDeustchland.setBounds(41, 75, 33, 20);
		bandeiraDeustchland.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnDeustchland.setSelected(true);
			}
		});
		bandeiraDeustchland.setIcon(new ImageIcon(SelecaoTimeView.class
				.getResource("/de.png")));
		contentPane.add(bandeiraDeustchland);
		btnDeustchland.setBounds(79, 74, 95, 23);
		contentPane.add(btnDeustchland);

		bandeiraEspanha.setBounds(191, 76, 30, 20);
		bandeiraEspanha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnEspanha.setSelected(true);
			}
		});
		bandeiraEspanha.setIcon(new ImageIcon(SelecaoTimeView.class
				.getResource("/es.png")));
		contentPane.add(bandeiraEspanha);
		btnEspanha.setBounds(226, 75, 89, 23);
		contentPane.add(btnEspanha);

		bandeiraPortugal.setBounds(191, 104, 30, 20);
		bandeiraPortugal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnPortugal.setSelected(true);
			}
		});
		bandeiraPortugal.setIcon(new ImageIcon(SelecaoTimeView.class
				.getResource("/pt.png")));
		contentPane.add(bandeiraPortugal);
		btnPortugal.setBounds(226, 103, 89, 23);
		contentPane.add(btnPortugal);

		bandeiraChile.setBounds(42, 103, 30, 20);
		bandeiraChile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnChile.setSelected(true);
			}
		});
		bandeiraChile.setIcon(new ImageIcon(SelecaoTimeView.class
				.getResource("/cl.png")));
		contentPane.add(bandeiraChile);
		btnChile.setBounds(79, 102, 95, 23);
		contentPane.add(btnChile);

		ButtonGroup group = new ButtonGroup();
		group.add(btnArgentina);
		group.add(btnBrasil);
		group.add(btnPortugal);
		group.add(btnDeustchland);
		group.add(btnEspanha);
		group.add(btnChile);

		btnOK.setBounds(144, 149, 56, 23);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Enumeration<AbstractButton> buttons = group.getElements(); buttons
						.hasMoreElements();) {
					AbstractButton button = buttons.nextElement();

					if (button.isSelected()) {
						nomeTimeEscolhido = button.getText();
					}
				}

				TimesController.createTimes(nomeTimeEscolhido);
				dispose();
				QuemIniciaView iniciaView = new QuemIniciaView();
				iniciaView.setVisible(true);
			}
		});
		contentPane.add(btnOK);
		lblEscolhaSeuTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscolhaSeuTime.setBounds(42, 21, 254, 14);
		
		contentPane.add(lblEscolhaSeuTime);

	}

}
