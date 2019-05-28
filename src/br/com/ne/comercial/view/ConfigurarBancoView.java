package br.com.ne.comercial.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import br.com.ne.comercial.controller.AbrirAplicativoComercial;
import br.com.ne.comercial.controller.LerBancoDados;

public class ConfigurarBancoView extends JDialog {

	private static final long serialVersionUID = 1320955535683077595L;

	private final JPanel contentPanel = new JPanel();
	private JTextField tfHost;
	private JTextField tfPorta;
	private JTextField tfBanco;
	private JButton btnCancelar;
	private JButton btnEditar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigurarBancoView dialog = new ConfigurarBancoView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarBancoView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarBancoView.class.getResource("/image/maos.png")));
		setTitle("COMERCIAL");
		setResizable(false);
		setType(Type.POPUP);
		setBounds(100, 100, 493, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		tfHost = new JTextField();
		tfHost.setBorder(new LineBorder(new Color(0, 0, 255)));
		tfHost.setBackground(Color.YELLOW);
		tfHost.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfHost.setEditable(false);
		tfHost.setBounds(96, 73, 295, 21);
		contentPanel.add(tfHost);
		tfHost.setColumns(10);

		JLabel lblHost = new JLabel("Host");
		lblHost.setForeground(new Color(0, 0, 255));
		lblHost.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		lblHost.setBounds(96, 54, 295, 14);
		contentPanel.add(lblHost);

		JLabel lblPorta = new JLabel("Porta");
		lblPorta.setForeground(new Color(0, 0, 255));
		lblPorta.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		lblPorta.setBounds(96, 109, 295, 14);
		contentPanel.add(lblPorta);

		tfPorta = new JTextField();
		tfPorta.setBorder(new LineBorder(new Color(0, 0, 255)));
		tfPorta.setBackground(Color.YELLOW);
		tfPorta.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfPorta.setEditable(false);
		tfPorta.setColumns(10);
		tfPorta.setBounds(97, 127, 294, 21);
		contentPanel.add(tfPorta);

		JLabel lblBanco = new JLabel("Banco");
		lblBanco.setForeground(new Color(0, 0, 255));
		lblBanco.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		lblBanco.setBounds(96, 165, 295, 14);
		contentPanel.add(lblBanco);

		tfBanco = new JTextField();
		tfBanco.setBorder(new LineBorder(new Color(0, 0, 255)));
		tfBanco.setBackground(Color.YELLOW);
		tfBanco.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfBanco.setEditable(false);
		tfBanco.setColumns(10);
		tfBanco.setBounds(97, 183, 295, 21);
		contentPanel.add(tfBanco);

		JPanel pBase = new JPanel();
		pBase.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		pBase.setBounds(-15, 247, 514, 86);
		contentPanel.add(pBase);
		pBase.setLayout(null);

		btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setRolloverIcon(new ImageIcon(ConfigurarBancoView.class.getResource("/image/botao2.jpg")));
		btnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditar.setIcon(new ImageIcon(ConfigurarBancoView.class.getResource("/image/botao.jpg")));
		btnEditar.setBorder(null);
		btnEditar.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnEditar.setBounds(216, 27, 89, 23);
		pBase.add(btnEditar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setRolloverIcon(new ImageIcon(ConfigurarBancoView.class.getResource("/image/botao2.jpg")));
		btnCancelar.setIcon(new ImageIcon(ConfigurarBancoView.class.getResource("/image/botao.jpg")));
		btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnCancelar.setBounds(321, 27, 89, 23);
		pBase.add(btnCancelar);

		getRootPane().setDefaultButton(btnCancelar);

		JLabel lblConfiguraesDoBanco = new JLabel("CONFIGURA\u00C7\u00D5ES DO BANCO DE DADOS");
		lblConfiguraesDoBanco.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfiguraesDoBanco.setForeground(new Color(0, 0, 205));
		lblConfiguraesDoBanco.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblConfiguraesDoBanco.setBounds(0, 0, 487, 30);
		contentPanel.add(lblConfiguraesDoBanco);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (btnEditar.getText().equals("Salvar")) {

					tfHost.setEditable(false);
					tfHost.setBackground(Color.YELLOW);
					tfPorta.setEditable(false);
					tfPorta.setBackground(Color.YELLOW);
					tfBanco.setEditable(false);
					tfBanco.setBackground(Color.YELLOW);

					btnEditar.setText("Editar");

				} else {

					dispose();

					AbrirAplicativoComercial iniciarAplicativo = new AbrirAplicativoComercial();
					iniciarAplicativo.Iniciar();

				}

			}
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (btnEditar.getText().equals("Editar")) {

					tfHost.setEditable(true);
					tfHost.setBackground(Color.WHITE);
					tfPorta.setEditable(true);
					tfPorta.setBackground(Color.WHITE);
					tfBanco.setEditable(true);
					tfBanco.setBackground(Color.WHITE);

					btnEditar.setText("Salvar");

				} else {

					getRootPane().setDefaultButton(btnEditar);

					try {

						LerBancoDados.GravarDadosBanco(tfHost.getText().toUpperCase(), tfPorta.getText().toUpperCase(),
								tfBanco.getText().toUpperCase());

						JOptionPane.showMessageDialog(null, "Nova configuração salva!", "Configurar banco de dados",
								JOptionPane.INFORMATION_MESSAGE);

					} catch (FileNotFoundException e1) {

						JOptionPane.showMessageDialog(null, "Erro " + e1);

					} catch (IOException e1) {

						JOptionPane.showMessageDialog(null, "Erro " + e1);
					}

					dispose();

					AbrirAplicativoComercial iniciarAplicativo = new AbrirAplicativoComercial();
					iniciarAplicativo.Iniciar();

				}

			}
		});
	}

	public JTextField getTfHost() {
		return tfHost;
	}

	public void setTfHost(JTextField tfHost) {
		this.tfHost = tfHost;
	}

	public JTextField getTfPorta() {
		return tfPorta;
	}

	public void setTfPorta(JTextField tfPorta) {
		this.tfPorta = tfPorta;
	}

	public JTextField getTfBanco() {
		return tfBanco;
	}

	public void setTfBanco(JTextField tfBanco) {
		this.tfBanco = tfBanco;
	}
}
