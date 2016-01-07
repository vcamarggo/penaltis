package br.uem.view;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

import br.uem.controller.SelecaoTimeController;
import br.uem.enumeration.Times;

/**
 * @author V.Camargo
 * 
 * @Date 29/12/2015
 */

public class SelecaoTimeView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JRadioButton btnBrasil = new JRadioButton(Times.BRASIL.toString());
	private final JLabel bandeiraBrasil = new JLabel("");

	private JRadioButton btnArgentina = new JRadioButton(Times.ARGENTINA.toString());
	private final JLabel bandeiraArgentina = new JLabel("");

	private JRadioButton btnDeustchland = new JRadioButton(Times.ALEMANHA.toString());
	private final JLabel bandeiraDeustchland = new JLabel("");

	private JRadioButton btnEspanha = new JRadioButton(Times.ESPANHA.toString());
	private final JLabel bandeiraEspanha = new JLabel("");

	private JRadioButton btnFranca = new JRadioButton(Times.FRANÇA.toString());
	private final JLabel bandeiraFranca = new JLabel("");

	private JRadioButton btnItalia = new JRadioButton(Times.ITALIA.toString());
	private final JLabel bandeiraItalia = new JLabel("");

	private final JButton btnOK = new JButton("OK");

	private String nomeTimeEscolhido;

	private SelecaoTimeController selecaoTimeController;

	public SelecaoTimeController getSelecaoTimeController() {
		return selecaoTimeController;
	}

	public void setSelecaoTimeController(
			SelecaoTimeController selecaoTimeController) {
		this.selecaoTimeController = selecaoTimeController;
	}

	public String getNomeTimeEscolhido() {
		return nomeTimeEscolhido;
	}

	public void setNomeTimeEscolhido(String nomeTimeEscolhido) {
		this.nomeTimeEscolhido = nomeTimeEscolhido;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelecaoTimeView frame = new SelecaoTimeView();
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
	public SelecaoTimeView() {
		setTitle("Pênaltis - Seleção de time");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowHeights = new int[] { -26, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0 };
		contentPane.setLayout(gbl_contentPane);

		GridBagConstraints gbc_bandeiraArgentina = new GridBagConstraints();
		gbc_bandeiraArgentina.insets = new Insets(0, 0, 5, 5);
		gbc_bandeiraArgentina.gridx = 0;
		gbc_bandeiraArgentina.gridy = 1;
		bandeiraArgentina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnArgentina.setSelected(true);
			}
		});
		bandeiraArgentina.setIcon(new ImageIcon(SelecaoTimeController.class
				.getResource("/ar.png")));
		contentPane.add(bandeiraArgentina, gbc_bandeiraArgentina);
		GridBagConstraints gbc_btnArgentina = new GridBagConstraints();
		gbc_btnArgentina.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnArgentina.insets = new Insets(0, 0, 5, 5);
		gbc_btnArgentina.gridx = 1;
		gbc_btnArgentina.gridy = 1;
		contentPane.add(btnArgentina, gbc_btnArgentina);

		GridBagConstraints gbc_bandeiraBrasil = new GridBagConstraints();
		gbc_bandeiraBrasil.insets = new Insets(0, 0, 5, 5);
		gbc_bandeiraBrasil.gridx = 4;
		gbc_bandeiraBrasil.gridy = 1;
		bandeiraBrasil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnBrasil.setSelected(true);
			}
		});
		bandeiraBrasil.setIcon(new ImageIcon(SelecaoTimeController.class
				.getResource("/br.png")));
		contentPane.add(bandeiraBrasil, gbc_bandeiraBrasil);
		GridBagConstraints gbc_btnBrasil = new GridBagConstraints();
		gbc_btnBrasil.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBrasil.insets = new Insets(0, 0, 5, 0);
		gbc_btnBrasil.gridx = 5;
		gbc_btnBrasil.gridy = 1;
		btnBrasil.setSelected(true);
		contentPane.add(btnBrasil, gbc_btnBrasil);

		GridBagConstraints gbc_bandeiraDeustchland = new GridBagConstraints();
		gbc_bandeiraDeustchland.insets = new Insets(0, 0, 5, 5);
		gbc_bandeiraDeustchland.gridx = 0;
		gbc_bandeiraDeustchland.gridy = 3;
		bandeiraDeustchland.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnDeustchland.setSelected(true);
			}
		});
		bandeiraDeustchland.setIcon(new ImageIcon(SelecaoTimeController.class
				.getResource("/de.png")));
		contentPane.add(bandeiraDeustchland, gbc_bandeiraDeustchland);
		GridBagConstraints gbc_btnDeustchland = new GridBagConstraints();
		gbc_btnDeustchland.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnDeustchland.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeustchland.gridx = 1;
		gbc_btnDeustchland.gridy = 3;
		contentPane.add(btnDeustchland, gbc_btnDeustchland);

		GridBagConstraints gbc_bandeiraEspanha = new GridBagConstraints();
		gbc_bandeiraEspanha.insets = new Insets(0, 0, 5, 5);
		gbc_bandeiraEspanha.gridx = 4;
		gbc_bandeiraEspanha.gridy = 3;
		bandeiraEspanha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnEspanha.setSelected(true);
			}
		});
		bandeiraEspanha.setIcon(new ImageIcon(SelecaoTimeController.class
				.getResource("/es.png")));
		contentPane.add(bandeiraEspanha, gbc_bandeiraEspanha);
		GridBagConstraints gbc_btnEspanha = new GridBagConstraints();
		gbc_btnEspanha.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnEspanha.insets = new Insets(0, 0, 5, 0);
		gbc_btnEspanha.gridx = 5;
		gbc_btnEspanha.gridy = 3;
		contentPane.add(btnEspanha, gbc_btnEspanha);

		GridBagConstraints gbc_bandeiraFranca = new GridBagConstraints();
		gbc_bandeiraFranca.insets = new Insets(0, 0, 5, 5);
		gbc_bandeiraFranca.gridx = 0;
		gbc_bandeiraFranca.gridy = 5;
		bandeiraFranca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnFranca.setSelected(true);
			}
		});
		bandeiraFranca.setIcon(new ImageIcon(SelecaoTimeController.class
				.getResource("/fr.png")));
		contentPane.add(bandeiraFranca, gbc_bandeiraFranca);
		GridBagConstraints gbc_btnFranca = new GridBagConstraints();
		gbc_btnFranca.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnFranca.insets = new Insets(0, 0, 5, 5);
		gbc_btnFranca.gridx = 1;
		gbc_btnFranca.gridy = 5;
		contentPane.add(btnFranca, gbc_btnFranca);

		GridBagConstraints gbc_bandeiraItalia = new GridBagConstraints();
		gbc_bandeiraItalia.insets = new Insets(0, 0, 5, 5);
		gbc_bandeiraItalia.gridx = 4;
		gbc_bandeiraItalia.gridy = 5;
		bandeiraItalia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnItalia.setSelected(true);
			}
		});
		bandeiraItalia.setIcon(new ImageIcon(SelecaoTimeController.class
				.getResource("/it.png")));
		contentPane.add(bandeiraItalia, gbc_bandeiraItalia);
		GridBagConstraints gbc_btnItalia = new GridBagConstraints();
		gbc_btnItalia.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnItalia.insets = new Insets(0, 0, 5, 0);
		gbc_btnItalia.gridx = 5;
		gbc_btnItalia.gridy = 5;
		contentPane.add(btnItalia, gbc_btnItalia);

		ButtonGroup group = new ButtonGroup();
		group.add(btnArgentina);
		group.add(btnBrasil);
		group.add(btnDeustchland);
		group.add(btnEspanha);
		group.add(btnFranca);
		group.add(btnItalia);
		GridBagConstraints gbc_btnOK = new GridBagConstraints();
		gbc_btnOK.gridwidth = 6;
		gbc_btnOK.gridx = 0;
		gbc_btnOK.gridy = 6;
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Enumeration<AbstractButton> buttons = group.getElements(); buttons
						.hasMoreElements();) {
					AbstractButton button = buttons.nextElement();

					if (button.isSelected()) {
						nomeTimeEscolhido = button.getText();
					}
				}

				selecaoTimeController = new SelecaoTimeController();
				selecaoTimeController.criarTime(nomeTimeEscolhido);
				dispose();
				QuemIniciaView iniciaView = new QuemIniciaView();
				iniciaView.setVisible(true);
			}
		});
		contentPane.add(btnOK, gbc_btnOK);

	}
}
