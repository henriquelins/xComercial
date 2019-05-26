package br.com.ne.comercial.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import br.com.ne.comercial.controller.Cliente;
import br.com.ne.comercial.controller.ClienteController;
import br.com.ne.comercial.controller.ClienteServico;
import br.com.ne.comercial.controller.ClienteServicoController;
import br.com.ne.comercial.controller.Lembrete;
import br.com.ne.comercial.controller.LembreteController;
import br.com.ne.comercial.controller.LerBancoDados;
import br.com.ne.comercial.controller.LogSegurancaController;
import br.com.ne.comercial.controller.Vendedor;
import br.com.ne.comercial.controller.VendedorController;
import br.com.ne.comercial.uteis.PesquisarComboBox;
import br.com.ne.comercial.uteis.TabelaStatus;
import br.com.ne.comercial.uteis.TamanhoMaxTextField;

public class LoginComercialView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5922907749894607031L;
	private JPanel contentPane;
	private JPasswordField pfSenha;
	private JComboBox<String> cbLogin;
	private static Vendedor vendedor = new Vendedor();
	private JPanel panelCentral;
	private JButton btnConfirmar;
	private JPanel panelNome;
	private JLabel lblNomeTela;
	private JButton btnFechar;
	static List<Cliente> listaCliente;
	private static List<Vendedor> listaVendedor;
	private static List<ClienteServico> listaClienteServico;
	private static List<Lembrete> listaLembreteVendedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					LoginComercialView frame = new LoginComercialView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws FileNotFoundException
	 */
	public LoginComercialView() throws FileNotFoundException {
		setBackground(Color.WHITE);
		setTitle("COMERCIAL");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginComercialView.class.getResource("/image/maos.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 262, 260);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		TamanhoMaxTextField TamanhoMax = new TamanhoMaxTextField();
		TamanhoMax.setMaxChars(7);
		contentPane.setLayout(null);

		panelNome = new JPanel();
		panelNome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panelNome.setBounds(0, -1, 256, 61);
		panelNome.setBackground(new Color(0, 0, 205));
		contentPane.add(panelNome);

		lblNomeTela = new JLabel("LOGIN");
		lblNomeTela.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNomeTela.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeTela.setForeground(Color.WHITE);
		lblNomeTela.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 30));
		GroupLayout gl_panelNome = new GroupLayout(panelNome);
		gl_panelNome.setHorizontalGroup(gl_panelNome.createParallelGroup(Alignment.LEADING).addComponent(lblNomeTela,
				GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE));
		gl_panelNome.setVerticalGroup(gl_panelNome.createParallelGroup(Alignment.TRAILING).addComponent(lblNomeTela,
				Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE));
		panelNome.setLayout(gl_panelNome);

		panelCentral = new JPanel();
		panelCentral.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panelCentral.setBounds(10, 71, 236, 129);
		panelCentral.setBorder(new LineBorder(Color.BLUE));
		contentPane.add(panelCentral);
		panelCentral.setLayout(null);

		cbLogin = new JComboBox<String>();
		cbLogin.setForeground(new Color(112, 128, 144));
		cbLogin.setToolTipText("Digite o Login");
		cbLogin.setModel(new DefaultComboBoxModel<String>(new String[] { "" }));
		cbLogin.setBounds(82, 11, 139, 30);
		panelCentral.add(cbLogin);
		cbLogin.setBorder(new LineBorder(Color.BLUE));
		cbLogin.setEditable(true);
		cbLogin.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));

		cbLogin.setEditable(true);
		new PesquisarComboBox(cbLogin);

		setListaClienteServico(new ArrayList<ClienteServico>());
		listaLembreteVendedor = new ArrayList<Lembrete>();

		VendedorController vendedorController = new VendedorController();
		listaVendedor = new ArrayList<Vendedor>();

		listaVendedor = vendedorController.listaVendedor();

		for (Vendedor vd : listaVendedor) {

			if (!vd.getLogin().endsWith("NESOLUTION")) {

				cbLogin.addItem(vd.getLogin());

			}

		}

		pfSenha = new JPasswordField();
		pfSenha.setSelectionColor(new Color(70, 130, 180));
		pfSenha.setHorizontalAlignment(SwingConstants.LEFT);
		pfSenha.setForeground(new Color(0, 0, 0));
		pfSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {

				getRootPane().setDefaultButton(btnConfirmar);

			}

			@Override
			public void focusLost(FocusEvent arg0) {

				getRootPane().setDefaultButton(null);

			}
		});
		pfSenha.setToolTipText("Digite a senha");
		pfSenha.setBounds(82, 52, 139, 30);
		panelCentral.add(pfSenha);
		pfSenha.setBorder(new LineBorder(Color.BLUE));
		pfSenha.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		pfSenha.setDocument(TamanhoMax);

		JLabel lblNick = new JLabel("LOGIN");
		lblNick.setForeground(Color.BLUE);
		lblNick.setBounds(14, 12, 65, 25);
		panelCentral.add(lblNick);
		lblNick.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setForeground(Color.BLUE);
		lblSenha.setBounds(14, 55, 55, 25);
		panelCentral.add(lblSenha);
		lblSenha.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		btnConfirmar = new JButton("Fazer Login");
		btnConfirmar.setRolloverIcon(new ImageIcon(LoginComercialView.class.getResource("/image/botao2.jpg")));
		btnConfirmar.setBorderPainted(false);
		btnConfirmar.setIcon(new ImageIcon(LoginComercialView.class.getResource("/image/botao.jpg")));
		btnConfirmar.setBorder(null);
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setBounds(10, 93, 111, 23);
		panelCentral.add(btnConfirmar);
		btnConfirmar.setMnemonic('F');
		btnConfirmar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConfirmar.setToolTipText("Fazer login");

		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (cbLogin.getSelectedItem().equals("") && String.valueOf(pfSenha.getPassword()).equals("")) {

					JOptionPane.showMessageDialog(null, "Digite o Login e a senha", "Campos Obrigatórios",
							JOptionPane.ERROR_MESSAGE);
					cbLogin.requestFocus();

				} else if (cbLogin.getSelectedItem().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite o Login", "Campo Obrigatório",
							JOptionPane.ERROR_MESSAGE);
					cbLogin.requestFocus();

				} else if (String.valueOf(pfSenha.getPassword()).equals("")) {

					JOptionPane.showMessageDialog(null, "Digite a senha", "Campo Obrigatório",
							JOptionPane.ERROR_MESSAGE);
					pfSenha.requestFocus();

				} else {

					ClienteController clienteController = new ClienteController();
					VendedorController vendedorController = new VendedorController();

					vendedor = vendedorController.login(String.valueOf(cbLogin.getSelectedItem()).toUpperCase(),
							String.valueOf(pfSenha.getPassword()));

					if (vendedor.getLogin() != null && vendedor.getSenha() != null) {

						try {

							UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
							PrincipalComercialView frame = new PrincipalComercialView();
							listaCliente = new ArrayList<Cliente>();
							List<TabelaStatus> listaTabelaStatus = new ArrayList<TabelaStatus>();
							ClienteServicoController clienteServicoController = new ClienteServicoController();
													
							NumberFormat tresDigitos = new DecimalFormat("000");

							LogSegurancaController.novoLogSeguranca("LOGIN");

							if (vendedor.getAcesso().equalsIgnoreCase("COMERCIAL")
									&& !vendedor.getCargo().equalsIgnoreCase("COORDENADOR DE VENDAS")) {

								listaCliente = clienteController.listarClientesPorVendedor(vendedor.getId_vendedor());

								listaTabelaStatus = clienteServicoController
										.todosServicosPorVendedor(vendedor.getId_vendedor());

								LembreteController lembrete = new LembreteController();
								listaLembreteVendedor = lembrete.lembreteVendedor(vendedor.getId_vendedor());

								if (listaCliente.isEmpty() == true) {

									frame.getCbCliente().addItem("NÃO EXISTE UMA LISTA DE CLIENTES AINDA!");

								} else {

									frame.getCbCliente().addItem("DIGITE O NOME DO CLIENTE...");

								}

								frame.getTfTotalDeClientes()
										.setText(tresDigitos.format(listaCliente.size()) + " do Vendedor");

								for (Cliente c : listaCliente) {

									frame.getCbCliente().addItem(c.getNome());

								}

								DefaultTableModel model = (DefaultTableModel) frame.getTbStatusCliente().getModel();
								model.setNumRows(0);

								int id = 1;

								if (listaTabelaStatus.isEmpty() == false) {

									frame.getSpStatusCliente().setVisible(true);
									frame.getLblClientesParaRenovacao().setVisible(true);
									frame.getLblStatusFoto().setVisible(false);
									
									String nomeVendedor = "";
									
									for (TabelaStatus ts : listaTabelaStatus) {

										String status = "RENOVAR SALDO";
																				
										nomeVendedor = vendedorController.buscarNomeVendedor(ts.getId_vendedor());

										Object[] linha = { tresDigitos.format(id), ts.getCliente(), ts.getServico(), nomeVendedor,
												tresDigitos.format(ts.getSaldo()), status };

										model.addRow(linha);

										id++;

									}
								}

								DefaultTableModel model2 = (DefaultTableModel) frame.getTbLembrete().getModel();
								model2.setNumRows(0);

								int id2 = 1;

								DateFormat formatBR = new SimpleDateFormat("dd-MM-YYYY");
								String dataBR = "";

								if (listaLembreteVendedor.isEmpty() == false) {

									frame.getSpLembrete().setVisible(true);
									frame.getSpDescricaoRecado().setVisible(true);
									frame.getBtnApagarLembrete().setVisible(true);
									frame.getLblDescricaoLembrete().setVisible(true);
									frame.getLblLembreteFoto().setVisible(false);

									for (Lembrete l : listaLembreteVendedor) {

										dataBR = formatBR.format(l.getDataDoLembrete());

										Object[] linha = { tresDigitos.format(id2), l.getAutor(), l.getAssunto(),
												dataBR };

										model2.addRow(linha);

										id2++;

									}

								}

							} else if (vendedor.getAcesso().equalsIgnoreCase("COMERCIAL")
									&& vendedor.getCargo().equalsIgnoreCase("COORDENADOR DE VENDAS")) {

								frame.getBtnLancamentos().setVisible(true);
								frame.getMntmProduto().setVisible(true);
								frame.getMnVendedor().setVisible(true);
								frame.getMnRelatorios().setVisible(true);
								frame.getMnLog().setVisible(true);

								listaCliente = clienteController.listarClientesPorVendedor(vendedor.getId_vendedor());

								listaTabelaStatus = clienteServicoController
										.todosServicosPorVendedor(vendedor.getId_vendedor());

								LembreteController lembrete = new LembreteController();
								listaLembreteVendedor = lembrete.lembreteVendedor(vendedor.getId_vendedor());

								if (listaCliente.isEmpty() == true) {

									frame.getCbCliente().addItem("NÃO EXISTE UMA LISTA DE CLIENTES AINDA!");

								} else {

									frame.getCbCliente().addItem("DIGITE O NOME DO CLIENTE...");

								}

								frame.getTfTotalDeClientes()
										.setText(tresDigitos.format(listaCliente.size()) + " do Vendedor");

								for (Cliente c : listaCliente) {

									frame.getCbCliente().addItem(c.getNome().toUpperCase());

								}

								DefaultTableModel model = (DefaultTableModel) frame.getTbStatusCliente().getModel();
								model.setNumRows(0);

								int id = 1;

								if (listaTabelaStatus.isEmpty() == false) {

									frame.getSpStatusCliente().setVisible(true);
									frame.getLblClientesParaRenovacao().setVisible(true);
									frame.getLblStatusFoto().setVisible(false);

									String nomeVendedor = "";
									
									for (TabelaStatus ts : listaTabelaStatus) {

										String status = "RENOVAR SALDO";
																				
										nomeVendedor = vendedorController.buscarNomeVendedor(ts.getId_vendedor());

										Object[] linha = { tresDigitos.format(id), ts.getCliente(), ts.getServico(), nomeVendedor,
												tresDigitos.format(ts.getSaldo()), status };

										model.addRow(linha);

										id++;

									}
								}

								DateFormat formatBR = new SimpleDateFormat("dd-MM-YYYY");
								String dataBR = "";

								DefaultTableModel model2 = (DefaultTableModel) frame.getTbLembrete().getModel();
								model2.setNumRows(0);

								int id2 = 1;

								if (listaLembreteVendedor.isEmpty() == false) {

									frame.getSpLembrete().setVisible(true);
									frame.getSpDescricaoRecado().setVisible(true);
									frame.getBtnApagarLembrete().setVisible(true);
									frame.getLblDescricaoLembrete().setVisible(true);
									frame.getLblLembreteFoto().setVisible(false);

									for (Lembrete l : listaLembreteVendedor) {

										dataBR = formatBR.format(l.getDataDoLembrete());

										Object[] linha = { tresDigitos.format(id2), l.getAutor(), l.getAssunto(),
												dataBR };

										model2.addRow(linha);

										id2++;

									}

								}

							} else if (vendedor.getAcesso().equalsIgnoreCase("")) {

								frame.getTfTotalDeClientes().setText(tresDigitos.format(listaCliente.size()));

							} else if (vendedor.getAcesso().equalsIgnoreCase("GERENCIAL")) {

								frame.getBtnLancamentos().setVisible(true);
								frame.getMntmProduto().setVisible(true);
								frame.getMnVendedor().setVisible(true);
								frame.getMnRelatorios().setVisible(true);
								frame.getMnLog().setVisible(true);

								listaCliente = clienteController.listarClientes();

								listaTabelaStatus = clienteServicoController.todosServicos();

								LembreteController lembrete = new LembreteController();
								listaLembreteVendedor = lembrete.lembreteVendedor(vendedor.getId_vendedor());

								if (listaCliente.isEmpty() == true) {

									frame.getCbCliente().addItem("NÃO EXISTE UMA LISTA DE CLIENTES AINDA!");

								} else {

									frame.getCbCliente().addItem("DIGITE O NOME DO CLIENTE...");

								}

								frame.getTfTotalDeClientes()
										.setText(tresDigitos.format(listaCliente.size()) + " na Empresa");

								for (Cliente c : listaCliente) {

									frame.getCbCliente().addItem(c.getNome().toUpperCase());

								}

								DefaultTableModel model = (DefaultTableModel) frame.getTbStatusCliente().getModel();
								model.setNumRows(0);

								int id = 1;

								if (listaTabelaStatus.isEmpty() == false) {

									frame.getSpStatusCliente().setVisible(true);
									frame.getLblClientesParaRenovacao().setVisible(true);
									frame.getLblStatusFoto().setVisible(false);

									String nomeVendedor = "";
									
									for (TabelaStatus ts : listaTabelaStatus) {

										String status = "RENOVAR SALDO";
																				
										nomeVendedor = vendedorController.buscarNomeVendedor(ts.getId_vendedor());

										Object[] linha = { tresDigitos.format(id), ts.getCliente(), ts.getServico(), nomeVendedor,
												tresDigitos.format(ts.getSaldo()), status };

										model.addRow(linha);

										id++;

									}
								}

								DateFormat formatBR = new SimpleDateFormat("dd-MM-YYYY");
								String dataBR = "";

								DefaultTableModel model2 = (DefaultTableModel) frame.getTbLembrete().getModel();
								model2.setNumRows(0);

								int id2 = 1;

								if (listaLembreteVendedor.isEmpty() == false) {

									frame.getSpLembrete().setVisible(true);
									frame.getSpDescricaoRecado().setVisible(true);
									frame.getBtnApagarLembrete().setVisible(true);
									frame.getLblDescricaoLembrete().setVisible(true);
									frame.getLblLembreteFoto().setVisible(false);

									for (Lembrete l : listaLembreteVendedor) {

										dataBR = formatBR.format(l.getDataDoLembrete());

										Object[] linha = { tresDigitos.format(id2), l.getAutor(), l.getAssunto(),
												dataBR };

										model2.addRow(linha);

										id2++;

									}

								}

							}

							frame.setVisible(true);
							frame.setLocationRelativeTo(null);

						} catch (Exception e) {

							e.printStackTrace();

							JOptionPane.showMessageDialog(null,
									"Login com tipo de acesso não cadastrado,\n         tente com outro login",
									"Erro de Login", JOptionPane.ERROR_MESSAGE);

							System.exit(0);

						}

						dispose();

					} else {

						JOptionPane.showMessageDialog(null, "Login não confirmado", "Erro de Login",
								JOptionPane.ERROR_MESSAGE);

						cbLogin.setSelectedIndex(0);
						pfSenha.setText("");
						cbLogin.requestFocus();

					}

				}
			}
		});
		btnConfirmar.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));

		btnFechar = new JButton("Fechar");
		btnFechar.setBorderPainted(false);
		btnFechar.setRolloverIcon(new ImageIcon(LoginComercialView.class.getResource("/image/botao2.jpg")));
		btnFechar.setIcon(new ImageIcon(LoginComercialView.class.getResource("/image/botao.jpg")));
		btnFechar.setBorder(new LineBorder(Color.BLUE));
		btnFechar.setForeground(Color.WHITE);
		btnFechar.setBackground(new Color(70, 130, 180));
		btnFechar.setBounds(139, 93, 82, 23);
		panelCentral.add(btnFechar);
		btnFechar.setMnemonic('F');
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resposta = JOptionPane.showConfirmDialog(null, "Deseja fechar o programa?", "Fechar",
						JOptionPane.YES_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {

					dispose();

				} else {

					cbLogin.setSelectedIndex(0);
					pfSenha.setText("");
					cbLogin.requestFocus();

				}

			}
		});
		btnFechar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFechar.setToolTipText("Fechar");
		btnFechar.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));

		JButton btnNewButton = new JButton("Clique aqui para o Banco de Dados");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

				try {

					ConfigurarBancoView cb = new ConfigurarBancoView();

					cb.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					cb.setLocationRelativeTo(null);
					
					LerBancoDados lerBancoDados = new LerBancoDados();
					lerBancoDados = LerBancoDados.lerDadosBanco();
										
					cb.getTfHost().setText(lerBancoDados.getHost());
					cb.getTfPorta().setText(lerBancoDados.getPorta());
					cb.getTfBanco().setText(lerBancoDados.getBanco());

					if (cbLogin.getSelectedItem().equals("")) {

						try {

							LerBancoDados.GravarDadosBanco(cb.getTfHost().getText().toUpperCase(),
									cb.getTfPorta().getText().toUpperCase(), cb.getTfBanco().getText().toUpperCase());

						} catch (IOException e1) {

							e1.printStackTrace();

						}

					} else {

					}
					
					cb.setVisible(true);

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBounds(10, 199, 236, 32);
		contentPane.add(btnNewButton);

	}

	public static Vendedor getVendedor() {
		return vendedor;
	}

	public static void setVendedor(Vendedor vendedor) {
		LoginComercialView.vendedor = vendedor;
	}

	public JComboBox<String> getCbLogin() {
		return cbLogin;
	}

	public void setCbLogin(JComboBox<String> cbLogin) {
		this.cbLogin = cbLogin;
	}

	public static List<Lembrete> getListaLembreteVendedor() {
		return listaLembreteVendedor;
	}

	public static void setListaLembreteVendedor(List<Lembrete> listaLembreteVendedor) {
		LoginComercialView.listaLembreteVendedor = listaLembreteVendedor;
	}

	public List<ClienteServico> getListaClienteServico() {
		return listaClienteServico;
	}

	public void setListaClienteServico(List<ClienteServico> listaClienteServico) {
		LoginComercialView.listaClienteServico = listaClienteServico;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		LoginComercialView.listaCliente = listaCliente;
	}
}
