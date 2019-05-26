package br.com.ne.comercial.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
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
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.commons.mail.EmailException;

import com.toedter.calendar.JDateChooser;

import br.com.ne.comercial.controller.Cliente;
import br.com.ne.comercial.controller.ClienteController;
import br.com.ne.comercial.controller.ClienteServico;
import br.com.ne.comercial.controller.ClienteServicoController;
import br.com.ne.comercial.controller.ClienteUteis;
import br.com.ne.comercial.controller.EmailThreadComercial;
import br.com.ne.comercial.controller.LancamentoServico;
import br.com.ne.comercial.controller.LancamentoServicoController;
import br.com.ne.comercial.controller.Lembrete;
import br.com.ne.comercial.controller.LembreteController;
import br.com.ne.comercial.controller.LogSegurancaController;
import br.com.ne.comercial.controller.ProdutoDoServico;
import br.com.ne.comercial.controller.ProdutoDoServicoController;
import br.com.ne.comercial.controller.SetorDaEmpresa;
import br.com.ne.comercial.controller.SetorDaEmpresaController;
import br.com.ne.comercial.controller.Vendedor;
import br.com.ne.comercial.controller.VendedorController;
import br.com.ne.comercial.relatorio.RelatorioLancamento;
import br.com.ne.comercial.uteis.ExportarCsv;
import br.com.ne.comercial.uteis.JNumberFormatField;
import br.com.ne.comercial.uteis.PesquisarComboBox;
import br.com.ne.comercial.uteis.TabLembrete;
import br.com.ne.comercial.uteis.TabLinhas;
import br.com.ne.comercial.uteis.TabLinhasPesquisa;
import br.com.ne.comercial.uteis.TabStatus;
import br.com.ne.comercial.uteis.TabelaStatus;
import br.com.ne.comercial.uteis.TamanhoMaxTextField;
import net.sf.jasperreports.engine.JRException;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class PrincipalComercialView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8406743785886924850L;
	public static int id_os;
	public JLabel lblLogado;
	private JComboBox<String> cbCliente;
	private JPanel pnlCliente;
	private JPanel lancamentoPedidoPanel;
	private JPanel dadosClientePanel;
	private CardLayout cardlayout;
	private JTextField tfVendedor;
	private JTextField tfFoneCelular1;
	private JTextField tfFoneFixo1;
	private JTextField tfEmail1;
	private JTextField tfRazaoSocial;
	private JTextField tfContato1;
	private JTextField tfCNPJ;
	private JTextField tfInscricaoEstadual;
	private JTextField tfLogradouro;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfCep;
	private JButton btnEditarDadosCliente;
	private Cliente cliente;
	private JTextPane tpDetalhes;
	private JTextField tfUnidade;
	private JTextField tfClienteDesde;
	private JButton btnSelecionar;
	private JTextField tfNovoNomeFantasia;
	private JTextField tfNovoRazaoSocial;
	private JTextField tfNovoContato1;
	private JTextField tfNovoInscricaoEstadual;
	private JTextField tfNovoLogradouro;
	private JTextField tfNovoBairro;
	private JTextField tfNovoCidade;
	private JTextField tfNovoEmail1;
	private JFormattedTextField ftfNovoCnpj;
	private JFormattedTextField ftfNovoCelular1;
	private JFormattedTextField ftfNovoFixo1;
	private JFormattedTextField ftfNovoCEP;
	private JDateChooser dcNovoClienteDesde;
	private JComboBox<String> cbNovoVendedor;
	private JComboBox<String> cbNovoEntrega;
	private JComboBox<String> cbNovoUf;
	private JTextPane tpNovoObservacoesDoCliente;
	private JComboBox<String> cbNovoUnidade;
	private JTextField tfNomeFantasia;
	private JTextField tfNomeDoServico;
	private JTextField tfCnpjDoServico;
	private JNumberFormatField tfValorUnitario;
	private JTextField tfQuantidadeDoPedido;
	private JTextField tfObservacoesLancamento;
	private JTable tbVerLancamento;
	private JTextField tfNomeVendedor;
	private JComboBox<String> cbCadVendedor;
	private JTextField tfEmailComercial;
	private JTextField tfLoginCadVendedor;
	private JPasswordField pfSenhaVendedor;
	private JPasswordField pfRepSenhaVendedor;
	private JFormattedTextField ftfCelularComercial;
	private JComboBox<String> cbAcessoVendedor;
	private JComboBox<String> cbProdutoDoServico;
	private JTextPane tpObservacoesDoServico;
	private JTextField tfLimiteMinimo;
	private JComboBox<String> cbServicosCadastrados;
	private static List<ClienteServico> listaClienteServico;
	private JTextField tfSaldoServico;
	private JTextField tfCnpjServico;
	private JTextField tfProdutoServico;
	private JTextPane tpObsServico;
	private JNumberFormatField tfValorUnitarioServico;
	private static ClienteServico clienteServico;
	private JTextField tfNomeClienteLancamento;
	private JTextField tfServicoLancamento;
	private JTextField tfSaldoAtualLancamento;
	private JTextField tfCnpjLancamento;
	private JDateChooser dcDataDoLancamento;
	private JComboBox<String> cbTransacaoLancamento;
	private JLabel lblClienteVerLançamento;
	private JLabel lblServicoLancamento;
	private JLabel lblProdutoLancamento;
	private String ObservacoesLancamento;
	private JDateChooser dcDataInicialPesquisa;
	private JDateChooser dcDataFinalPesquisa;
	private JTextField tfNomeDoProduto;
	private JNumberFormatField tfValorUnitarioSugerido;
	private JPanel cadastroClientePanel;
	private JTextField tfPesquisarCliente;
	private JTable tbPesquisarCliente;
	private JScrollPane spPesquisarCliente;
	private List<Cliente> listaPesquisaCliente;
	private JButton btnPesquisaCliente;
	private JButton btnEditarPesquisaCliente;
	private static int tipoSalvarOuEditarCliente = 0;
	private static boolean tipoSalvarOuEditarVendedor = true;
	private static boolean tipoSalvarOuEditarProduto = true;
	private static boolean tipoSalvarOuEditarServico = true;
	private JTextField tfPesquisarEditarVendedor;
	private JTextField tfPesquisarEditarProduto;
	private JTable tbPesquisarVendedor;
	private JScrollPane spPesquisarVendedor;
	private JButton btnEditarPesquisarVendedor;
	private static List<Vendedor> listaPesquisaVendedor;
	private Vendedor vendedor;
	private JButton btnExcluirVendedor;
	private JButton btnPesquiarEditarVendedor;
	private JScrollPane spVerLancamento;
	private JTable tbStatusCliente;
	private JTextField tfTotalDeClientes;
	private JTable tbLembrete;
	private JTextField tfInscricaoMunicipal;
	private JTextField tfNovoContato2;
	private JTextField tfNovoEmail2;
	private JTextField tfEmailPessoal;
	private JTextField tfAssuntoLembrete;
	private JComboBox<String> cbVendedorDestinatario;
	private JTextPane tpDescricaoLembrete;
	private static List<Vendedor> listaVendedores;
	private JTextArea tpDescricaoRecado;
	private JFormattedTextField ftfCelularPessoal;
	private JMenu mntmProduto;
	private JMenu mnVendedor;
	private JLabel lblCadastroDeCliente;
	private JLabel lblCadastroDeVendedor;
	private JFormattedTextField ftfNovoFixo2;
	private JFormattedTextField ftfNovoCelular2;
	private JTextField tfCodigoDoProduto;
	private JComboBox<String> cbSetorDoServico;
	private JTextPane tpDescricaoProdutoDoServico;
	private JTable tbPesquisarProduto;
	private JScrollPane spPesquisarProduto;
	private JButton btnEditarProduto;
	private static List<ProdutoDoServico> listaPesquisaProduto;
	private JButton btnPesquisarEditarProduto;
	private ProdutoDoServico produtoDoServico;
	private JLabel lblCadastroDeProduto;
	private JButton btnExcluirCadastroProduto;
	private JButton btnCadastroProdutoSalvar;
	private static List<SetorDaEmpresa> listaSetorDaEmpresa;
	private JTextField tfSetorDaEmpresa;
	private JButton btnNovoSetor;
	private JButton btnEditarSetor;
	private JButton btnExcluirSetor;
	private JButton btnCancelarSetor;
	private int id_setorDaEmpresa;
	private JTextField tfContato2;
	private JTextField tfFoneFixo2;
	private JTextField tfEmail2;
	private JTextField tfFoneCelular2;
	private JTextField tfInscrMunicipal;
	private JTextField tfEntregaDadosCliente;
	private JTextField tfUfDadosCliente;
	private JButton btnSalvarCliente;
	private JButton btnCadastrarVendedor;
	private JButton btnNovaConta;
	private JLabel lblCadastroDeServiços;
	private JButton btnSalvarConta;
	private JLabel lblClienteServico;
	private JButton btnVerProduto;
	private static List<ProdutoDoServico> listaProdutoDoServico;
	private static ArrayList<LancamentoServico> listaLancamentoServicoPorData;
	private static boolean editarLancamento = true;
	private JLabel lblSaldo;
	private JTextField tfProdutoDoServico;
	private JButton btnLancamento;
	private JButton btnLancamentos;
	private JScrollPane spStatusCliente;
	private JLabel lblClientesParaRenovacao;
	private JScrollPane spLembrete;
	private JScrollPane spDescricaoRecado;
	private JButton btnApagarLembrete;
	private JLabel lblDescricaoLembrete;
	private JLabel lblLembreteFoto;
	private JLabel lblStatusFoto;
	private JMenu mnRelatorios;
	private JMenu mnLog;
	private JButton btnPesquisarLancamento;
	private JButton btnIncial;
	private JButton btnNovoLembrete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					PrincipalComercialView frame = new PrincipalComercialView();
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

	@SuppressWarnings("serial")
	public PrincipalComercialView() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setForeground(new Color(0, 0, 205));
		getContentPane().setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		setTitle("COMERCIAL");

		setName("");
		setBounds(100, 100, 1000, 700);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalComercialView.class.getResource("/image/maos.png")));

		JPanel pnlBarra = new JPanel();
		pnlBarra.setBounds(0, 589, 994, 61);
		pnlBarra.setBorder(null);

		btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setBounds(830, 92, 106, 23);
		btnSelecionar.setMnemonic('e');
		btnSelecionar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSelecionar.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnSelecionar.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnSelecionar.setContentAreaFilled(false);
		btnSelecionar.setForeground(Color.WHITE);
		btnSelecionar.setBorder(null);
		btnSelecionar.setBackground(new Color(0, 0, 205));
		btnSelecionar.setToolTipText("Selecionar Cliente");
		btnSelecionar.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));

		listaClienteServico = new ArrayList<ClienteServico>();
		clienteServico = new ClienteServico();

		listaPesquisaProduto = new ArrayList<ProdutoDoServico>();

		produtoDoServico = new ProdutoDoServico();

		listaVendedores = new ArrayList<Vendedor>();
		VendedorController vendedorController = new VendedorController();
		listaVendedores = vendedorController.listaVendedor();

		listaSetorDaEmpresa = new ArrayList<SetorDaEmpresa>();
		
		getRootPane().setDefaultButton(btnSelecionar);
		
		vendedor = new Vendedor();
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = String.valueOf(cbCliente.getSelectedItem());

				apagarPanelServicos();

				if (nome.equalsIgnoreCase("DIGITE O NOME DO CLIENTE...")) {

					JOptionPane.showMessageDialog(null, "Digite o nome do cliente!");

				} else {

					ClienteController clienteController = new ClienteController();
					
					try {
						
						cliente = clienteController.mostrarClienteNome(nome);
					
					} catch (FileNotFoundException e1) {
						
						e1.printStackTrace();
					}

					if (cliente.getId_cliente() == 0) {

						int resposta = JOptionPane.showConfirmDialog(null,
								"Cliente não encontrado, deseja cadastrar um novo cliente?", "Cliente não encontrado",
								JOptionPane.YES_OPTION);

						if (resposta == JOptionPane.YES_OPTION) {

							cbCliente.setSelectedIndex(0);
							cardlayout.show(pnlCliente, "Novo");

						} else {

							cbCliente.setSelectedIndex(0);
							cardlayout.show(pnlCliente, "Inicial");

						}

					} else {

						String entrega = "";
						DateFormat formatBR = new SimpleDateFormat("dd-MM-YYYY");

						cbCliente.setSelectedIndex(0);
						cardlayout.show(pnlCliente, "Dados");

						tfNomeFantasia.setText(cliente.getNome().toUpperCase());

						VendedorController vendedorController = new VendedorController();
						String vendedor = vendedorController.buscarNomeVendedor(cliente.getId_vendedor());

						tfVendedor.setText(vendedor.toUpperCase());

						if (cliente.isEntrega()) {

							entrega = "Sim";

						} else {

							entrega = "Não";
						}

						tfEntregaDadosCliente.setText(entrega);

						if (cliente.getRazaoSocial() == null) {

							tfRazaoSocial.setText("");

						} else {

							tfRazaoSocial.setText(cliente.getRazaoSocial().toUpperCase());

						}

						tfContato1.setText(cliente.getContato1().toUpperCase());

						if (cliente.getContato2() == null) {

							tfContato2.setText("");

						} else {

							tfContato2.setText(cliente.getContato2().toUpperCase());

						}

						if (cliente.getUnidade() == null) {

							tfUnidade.setText("");

						} else {

							tfUnidade.setText(cliente.getUnidade().toUpperCase());

						}

						if (cliente.getClienteDesde() == null) {

							tfClienteDesde.setText("00/00/0000");

						} else {

							String dataBr = formatBR.format(cliente.getClienteDesde());
							tfClienteDesde.setText(String.valueOf(dataBr));

						}

						tpDetalhes.setText(cliente.getDetalhes());
						tfFoneCelular1.setText(cliente.getFoneCelular1());
						tfFoneCelular2.setText(cliente.getFoneCelular2());
						tfFoneFixo1.setText(cliente.getFoneFixo1());
						tfFoneFixo2.setText(cliente.getFoneFixo2());
						tfCNPJ.setText(cliente.getCnpj());
						tfInscricaoEstadual.setText(cliente.getInscricaoEstadual());
						tfInscrMunicipal.setText(cliente.getInscricaoMunicipal());
						tfEmail1.setText(cliente.getEmail1().toLowerCase());

						if (cliente.getEmail2() == null) {

							tfEmail2.setText("");

						} else {

							tfEmail2.setText(cliente.getEmail2().toLowerCase());

						}

						tfLogradouro.setText(cliente.getLogradouro());
						tfCidade.setText(cliente.getCidade());
						tfBairro.setText(cliente.getBairro());
						tfCep.setText(cliente.getCep());

						tfUfDadosCliente.setText(cliente.getUf());

						cbServicosCadastrados.removeAllItems();

						ClienteServicoController clienteServicoController = new ClienteServicoController();
						listaClienteServico = clienteServicoController.listaServicoCliente(cliente.getId_cliente());

						if (listaClienteServico.isEmpty() == true) {

							cbServicosCadastrados.addItem("ADICIONE UM SERVIÇO...");

						} else {

							cbServicosCadastrados.addItem("SELECIONE O SERVIÇO...");

							for (ClienteServico cs : listaClienteServico) {

								cbServicosCadastrados.addItem(cs.getNomeDoServico().toUpperCase());
							}

						}

					}

				}

			}
		});
		
		
		JLabel lblCliente = new JLabel();
		lblCliente.setBounds(45, 61, 304, 73);
		lblCliente.setForeground(Color.BLACK);
		lblCliente.setText("SAUDA\u00C7\u00D5ES - " + LoginComercialView.getVendedor().getNome().toUpperCase());
		lblCliente.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 18));

		cbCliente = new JComboBox<String>();
		cbCliente.setBounds(469, 92, 351, 23);
		cbCliente.setBorder(new LineBorder(new Color(0, 0, 205)));

		cbCliente.setAutoscrolls(true);

		cbCliente.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		cbCliente.setEditable(true);
		cbCliente.setToolTipText("Digite o cliente");

		// Setar focus em cbEmpresa

		final JComboBox<String> cb = cbCliente;
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				cb.requestFocusInWindow();
			}
		});

		cbCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				getRootPane().setDefaultButton(btnSelecionar);

			}
		});

		new PesquisarComboBox(cbCliente);

		JLabel lblClientePesquisa = new JLabel("Cliente");
		lblClientePesquisa.setBounds(469, 75, 67, 14);
		lblClientePesquisa.setForeground(new Color(0, 0, 205));
		lblClientePesquisa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		JButton btnFechar = new JButton("Fechar");
		btnFechar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFechar.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnFechar.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnFechar.setForeground(Color.WHITE);
		btnFechar.setContentAreaFilled(false);
		btnFechar.setBorder(null);
		btnFechar.setToolTipText("Fechar");
		btnFechar.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnFechar.setBounds(859, 13, 83, 23);
		btnFechar.setMnemonic('F');
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int resposta = JOptionPane.showConfirmDialog(null, "Deseja fechar o programa?", "Fechar",
						JOptionPane.YES_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {

					LogSegurancaController.novoLogSeguranca("SAIU");

					dispose();

				}

			}
		});

		JButton btnLogout = new JButton("Logoff");
		btnLogout.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogout.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnLogout.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorder(null);
		btnLogout.setBackground(new Color(0, 0, 205));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setToolTipText("Logoff");
		btnLogout.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnLogout.setBounds(766, 13, 83, 23);
		btnLogout.setMnemonic('L');
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resposta = JOptionPane.showConfirmDialog(null, "Deseja fazer o logoff?", "Logoff",
						JOptionPane.YES_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {

					dispose();

					LogSegurancaController.novoLogSeguranca("LOGOFF");

					try {

						mntmProduto.setVisible(false);
						mnVendedor.setVisible(false);

						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
						LoginComercialView frame = new LoginComercialView();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);

					} catch (Exception e1) {

						e1.printStackTrace();

					}

				}

			}
		});

		lblLogado = new JLabel("Logado: null / null");
		lblLogado.setForeground(Color.BLACK);
		lblLogado.setBounds(45, 12, 398, 25);
		lblLogado.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		lblLogado.setText("LOGADO: " + LoginComercialView.getVendedor().getNome().toUpperCase() + " / "
				+ LoginComercialView.getVendedor().getCargo().toUpperCase());

		pnlCliente = new JPanel();
		pnlCliente.setBounds(-12, 134, 1020, 454);

		cardlayout = new CardLayout();

		pnlCliente.setLayout(cardlayout);

		JPanel inicialPanel = new JPanel();
		inicialPanel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnSelecionar);
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		inicialPanel.setBackground(Color.WHITE);
		inicialPanel.setForeground(Color.WHITE);
		inicialPanel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		inicialPanel.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		pnlCliente.add(inicialPanel, "Inicial");
		inicialPanel.setLayout(null);

		JPanel pLembrete = new JPanel();
		pLembrete.setBackground(Color.WHITE);
		pLembrete.setForeground(new Color(0, 0, 205));
		pLembrete.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		pLembrete.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 205)), "Lembrete", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 205)));
		pLembrete.setBounds(64, 11, 432, 426);
		inicialPanel.add(pLembrete);
		pLembrete.setLayout(null);

		btnApagarLembrete = new JButton("Apagar");
		btnApagarLembrete.setMnemonic('g');
		btnApagarLembrete.setVisible(false);
		btnApagarLembrete.setHorizontalTextPosition(SwingConstants.CENTER);
		btnApagarLembrete.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnApagarLembrete.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnApagarLembrete.setBorder(null);
		btnApagarLembrete.setContentAreaFilled(false);
		btnApagarLembrete.setForeground(Color.WHITE);
		btnApagarLembrete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int linhaSelecionada = tbLembrete.getSelectedRow();

				if (linhaSelecionada <= -1) {

					JOptionPane.showMessageDialog(null, "Selecione um lembrete para excluir", "Excluir lembrete",
							JOptionPane.INFORMATION_MESSAGE);

				} else {

					int resposta = JOptionPane.showConfirmDialog(null, "Deseja apagar o lembrete?", "Lembrete",
							JOptionPane.YES_OPTION);

					if (resposta == JOptionPane.YES_OPTION) {

						int id_lembrete = LoginComercialView.getListaLembreteVendedor().get(linhaSelecionada)
								.getId_lembrete();

						boolean sucesso = false;

						LembreteController lembreteController = new LembreteController();
						sucesso = lembreteController.excluirLembrete(id_lembrete);

						if (sucesso) {

							JOptionPane.showMessageDialog(null, "Lembrete excluído", "Excluir lembrete",
									JOptionPane.INFORMATION_MESSAGE);

							DefaultTableModel model = (DefaultTableModel) getTbLembrete().getModel();
							model.setNumRows(0);

							LoginComercialView.setListaLembreteVendedor(lembreteController
									.lembreteVendedor(LoginComercialView.getVendedor().getId_vendedor()));

							int id2 = 1;

							DateFormat formatBR = new SimpleDateFormat("dd-MM-YYYY");
							String dataBR = "";

							for (Lembrete l : LoginComercialView.getListaLembreteVendedor()) {

								NumberFormat tresDigitos = new DecimalFormat("000");
								dataBR = formatBR.format(l.getDataDoLembrete());

								Object[] linha = { tresDigitos.format(id2), l.getAutor(), l.getAssunto(), dataBR };

								model.addRow(linha);

								id2++;

							}

							if (LoginComercialView.getListaLembreteVendedor().isEmpty()) {

								lblDescricaoLembrete.setVisible(false);
								lblLembreteFoto.setVisible(true);
								spLembrete.setVisible(false);
								spDescricaoRecado.setVisible(false);
								btnApagarLembrete.setVisible(false);

							}

							tpDescricaoRecado.setText("");

						} else {

							JOptionPane.showMessageDialog(null, "Lembrete não excluído", "Excluir lembrete",
									JOptionPane.INFORMATION_MESSAGE);

						}

					}

				}

			}
		});
		btnApagarLembrete.setToolTipText("Apagar Lembrete");
		btnApagarLembrete.setBounds(325, 380, 89, 23);
		pLembrete.add(btnApagarLembrete);
		btnApagarLembrete.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnApagarLembrete.setActionCommand("Apagar");

		spLembrete = new JScrollPane();
		spLembrete.setVisible(false);
		spLembrete.setBackground(Color.WHITE);
		spLembrete.setForeground(new Color(0, 0, 0));
		spLembrete.setBounds(17, 25, 397, 126);
		pLembrete.add(spLembrete);
		spLembrete.setBorder(new LineBorder(new Color(0, 0, 205)));
		spLembrete.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));

		tbLembrete = new JTable();
		
		tbLembrete.setDefaultRenderer(Object.class, new TabLembrete());
		tbLembrete.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tbLembrete.setBackground(Color.WHITE);
		tbLembrete.setGridColor(new Color(0, 0, 205));
		tbLembrete.setForeground(new Color(0, 0, 205));

		tbLembrete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int linha = tbLembrete.getSelectedRow();

				if (linha > -1) {

					tpDescricaoRecado.setText(LoginComercialView.getListaLembreteVendedor().get(linha).getDescricao());

				}

			}
		});
		tbLembrete.setBorder(new LineBorder(new Color(65, 105, 225)));
		tbLembrete.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbLembrete.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		tbLembrete.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "AUTOR DO LEMBRETE", "ASSUNTO", "DATA" })
				
		{
			boolean[] columnEditables = new boolean[] {
				false, false, false,false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
			
			
	
			public Class<?> getColumnClass(int columns) {
				Class<?> returnValue;
				if ((columns >= 0) && (columns < getColumnCount())) {
				  returnValue = getValueAt(0, columns).getClass();
				} else {
				  returnValue = Object.class;
				}
				  return returnValue;
				}

		}		
				
				
		);
		
		
		
		
		tbLembrete.getColumnModel().getColumn(0).setPreferredWidth(35);
		tbLembrete.getColumnModel().getColumn(1).setPreferredWidth(130);
		tbLembrete.getColumnModel().getColumn(2).setPreferredWidth(150);
		tbLembrete.getColumnModel().getColumn(3).setPreferredWidth(80);
		
		DefaultTableModel model2 = (DefaultTableModel) tbLembrete.getModel();
		model2.setNumRows(0);
				
		RowSorter<TableModel> sorter2 =
		new TableRowSorter<TableModel>(model2);
		tbLembrete.setRowSorter(sorter2);
				
		
		spLembrete.setViewportView(tbLembrete);

		spDescricaoRecado = new JScrollPane();
		spDescricaoRecado.setVisible(false);
		spDescricaoRecado.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		spDescricaoRecado.setBackground(Color.WHITE);
		spDescricaoRecado.setBorder(null);
		spDescricaoRecado.setBounds(17, 175, 398, 194);
		pLembrete.add(spDescricaoRecado);

		tpDescricaoRecado = new JTextArea();
		tpDescricaoRecado.setDisabledTextColor(Color.WHITE);
		tpDescricaoRecado.setWrapStyleWord(true);
		tpDescricaoRecado.setBackground(Color.WHITE);
		tpDescricaoRecado.setForeground(Color.RED);
		spDescricaoRecado.setViewportView(tpDescricaoRecado);
		tpDescricaoRecado.setEditable(false);
		tpDescricaoRecado.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		tpDescricaoRecado.setBorder(new LineBorder(new Color(0, 0, 205)));

		lblDescricaoLembrete = new JLabel("Descri\u00E7\u00E3o");
		lblDescricaoLembrete.setVisible(false);
		lblDescricaoLembrete.setForeground(new Color(0, 0, 205));
		lblDescricaoLembrete.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblDescricaoLembrete.setBounds(17, 158, 109, 15);
		pLembrete.add(lblDescricaoLembrete);

		JButton btnCriarLembrete = new JButton("Novo Lembrete");
		btnCriarLembrete.setMnemonic('l');
		btnCriarLembrete.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCriarLembrete.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnCriarLembrete.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnCriarLembrete.setForeground(Color.WHITE);
		btnCriarLembrete.setContentAreaFilled(false);
		btnCriarLembrete.setBorder(null);
		btnCriarLembrete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				cardlayout.show(pnlCliente, "novoLembrete");

			}
		});
		btnCriarLembrete.setToolTipText("Novo Lembrete");
		btnCriarLembrete.setBounds(154, 380, 123, 23);
		pLembrete.add(btnCriarLembrete);
		btnCriarLembrete.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));

		lblLembreteFoto = new JLabel("");
		lblLembreteFoto.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLembreteFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblLembreteFoto.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/LEMBRETE.jpg")));
		lblLembreteFoto.setBounds(50, 29, 332, 340);
		pLembrete.add(lblLembreteFoto);

		JPanel pTotalDeClientes = new JPanel();
		pTotalDeClientes.setBackground(Color.WHITE);
		pTotalDeClientes.setForeground(new Color(0, 0, 205));
		pTotalDeClientes.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		pTotalDeClientes.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 205)), "Clientes",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		pTotalDeClientes.setBounds(523, 11, 432, 426);
		inicialPanel.add(pTotalDeClientes);
		pTotalDeClientes.setLayout(null);

		spStatusCliente = new JScrollPane();
		spStatusCliente.setBounds(26, 94, 380, 305);
		pTotalDeClientes.add(spStatusCliente);
		spStatusCliente.setVisible(false);
		spStatusCliente.setBackground(Color.WHITE);
		spStatusCliente.setForeground(new Color(0, 0, 205));
		spStatusCliente.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		spStatusCliente.setBorder(new LineBorder(new Color(0, 0, 205)));

		tbStatusCliente = new JTable();
		
		tbStatusCliente.setBackground(Color.WHITE);
		tbStatusCliente.setGridColor(new Color(0, 0, 205));
		tbStatusCliente.setForeground(new Color(0, 0, 205));
		tbStatusCliente.setDefaultRenderer(Object.class, new TabStatus());
		tbStatusCliente.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tbStatusCliente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbStatusCliente.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		tbStatusCliente.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		tbStatusCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "CLIENTE", "SERVI\u00C7O", "VENDEDOR", "SALDO", "STATUS"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
			
			
			public Class<?> getColumnClass(int columns) {
				Class<?> returnValue;
				if ((columns >= 0) && (columns < getColumnCount())) {
				  returnValue = getValueAt(0, columns).getClass();
				} else {
				  returnValue = Object.class;
				}
				  return returnValue;
				}

		});
		
		
		tbStatusCliente.getColumnModel().getColumn(0).setResizable(false);
		tbStatusCliente.getColumnModel().getColumn(0).setPreferredWidth(35);
		tbStatusCliente.getColumnModel().getColumn(1).setResizable(false);
		tbStatusCliente.getColumnModel().getColumn(1).setPreferredWidth(150);
		tbStatusCliente.getColumnModel().getColumn(2).setResizable(false);
		tbStatusCliente.getColumnModel().getColumn(2).setPreferredWidth(150);
		tbStatusCliente.getColumnModel().getColumn(3).setPreferredWidth(120);
		tbStatusCliente.getColumnModel().getColumn(4).setResizable(false);
		tbStatusCliente.getColumnModel().getColumn(4).setPreferredWidth(50);
		tbStatusCliente.getColumnModel().getColumn(5).setResizable(false);
		tbStatusCliente.getColumnModel().getColumn(5).setPreferredWidth(120);
		
		
		DefaultTableModel model = (DefaultTableModel) tbStatusCliente.getModel();
		model.setNumRows(0);
				
		RowSorter<TableModel> sorter =
		new TableRowSorter<TableModel>(model);
		tbStatusCliente.setRowSorter(sorter);
		
		spStatusCliente.setViewportView(tbStatusCliente);

		JLabel lblTotalDeClientes = new JLabel("Total de Clientes  -");
		lblTotalDeClientes.setForeground(new Color(0, 0, 0));
		lblTotalDeClientes.setBounds(21, 27, 191, 23);
		pTotalDeClientes.add(lblTotalDeClientes);
		lblTotalDeClientes.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));

		tfTotalDeClientes = new JTextField();
		tfTotalDeClientes.setBackground(Color.WHITE);
		tfTotalDeClientes.setForeground(new Color(0, 0, 0));
		tfTotalDeClientes.setEditable(false);
		tfTotalDeClientes.setBorder(null);
		tfTotalDeClientes.setBounds(217, 26, 179, 26);
		pTotalDeClientes.add(tfTotalDeClientes);
		tfTotalDeClientes.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
		tfTotalDeClientes.setColumns(10);

		lblClientesParaRenovacao = new JLabel("Clientes para renova\u00E7\u00E3o de saldo");
		lblClientesParaRenovacao.setVisible(false);
		lblClientesParaRenovacao.setForeground(new Color(0, 0, 0));
		lblClientesParaRenovacao.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblClientesParaRenovacao.setBounds(21, 63, 375, 14);
		pTotalDeClientes.add(lblClientesParaRenovacao);

		lblStatusFoto = new JLabel("");
		lblStatusFoto.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/clientes.png")));
		lblStatusFoto.setHorizontalTextPosition(SwingConstants.CENTER);
		lblStatusFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusFoto.setBounds(28, 27, 375, 372);
		pTotalDeClientes.add(lblStatusFoto);

		JPanel verLancamentoPanel = new JPanel();
		verLancamentoPanel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnPesquisarLancamento);
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnSelecionar);
				
				dcDataInicialPesquisa.setDate(null);
				dcDataFinalPesquisa.setDate(null);
			}
		});

		verLancamentoPanel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		verLancamentoPanel.setBackground(Color.WHITE);
		verLancamentoPanel.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		pnlCliente.add(verLancamentoPanel, "Ver Lançamento");
		verLancamentoPanel.setLayout(null);

		JLabel lblVerLanamento = new JLabel("VER LAN\u00C7AMENTO");
		lblVerLanamento.setHorizontalTextPosition(SwingConstants.CENTER);
		lblVerLanamento.setBounds(13, 0, 994, 30);
		lblVerLanamento.setForeground(new Color(0, 0, 205));
		lblVerLanamento.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblVerLanamento.setHorizontalAlignment(SwingConstants.CENTER);
		verLancamentoPanel.add(lblVerLanamento);

		JButton btnCancelarVerLancamento = new JButton("Cancelar");
		btnCancelarVerLancamento.setToolTipText("Cancelar");
		btnCancelarVerLancamento.setMnemonic('c');
		btnCancelarVerLancamento.setBounds(871, 420, 83, 23);
		btnCancelarVerLancamento
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnCancelarVerLancamento.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnCancelarVerLancamento.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelarVerLancamento.setContentAreaFilled(false);
		btnCancelarVerLancamento.setBorder(null);
		btnCancelarVerLancamento.setForeground(Color.WHITE);
		btnCancelarVerLancamento.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnCancelarVerLancamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limparPanelVerLancamento();

				cardlayout.show(pnlCliente, "Dados");

			}
		});
		verLancamentoPanel.add(btnCancelarVerLancamento);

		dcDataInicialPesquisa = new JDateChooser();
		
		
		dcDataInicialPesquisa.setBounds(279, 103, 95, 22);
		dcDataInicialPesquisa.setBorder(new LineBorder(new Color(0, 0, 205)));
		dcDataInicialPesquisa.setForeground(new Color(0, 0, 205));
		dcDataInicialPesquisa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		verLancamentoPanel.add(dcDataInicialPesquisa);

		dcDataFinalPesquisa = new JDateChooser();
	
		dcDataFinalPesquisa.setBounds(461, 103, 95, 22);
		dcDataFinalPesquisa.setBorder(new LineBorder(new Color(0, 0, 205)));
		dcDataFinalPesquisa.setForeground(new Color(0, 0, 205));
		dcDataFinalPesquisa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		verLancamentoPanel.add(dcDataFinalPesquisa);

		JLabel lblNewLabel = new JLabel("Data Inicial");
		lblNewLabel.setBounds(279, 83, 95, 14);
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		verLancamentoPanel.add(lblNewLabel);

		JLabel lblDataFinal = new JLabel("Data Final");
		lblDataFinal.setBounds(461, 83, 95, 14);
		lblDataFinal.setForeground(new Color(0, 0, 205));
		lblDataFinal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		verLancamentoPanel.add(lblDataFinal);

		spVerLancamento = new JScrollPane();
		spVerLancamento.setBounds(66, 136, 888, 273);
		spVerLancamento.setForeground(new Color(0, 0, 205));
		spVerLancamento.setVisible(false);
		spVerLancamento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		spVerLancamento.setBorder(new LineBorder(new Color(0, 0, 205)));
		verLancamentoPanel.add(spVerLancamento);
		
		
		
		
		
		
				
		tbVerLancamento = new JTable();
				
		tbVerLancamento.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tbVerLancamento.setBackground(Color.WHITE);
		tbVerLancamento.setBorder(new LineBorder(new Color(0, 0, 205)));
		tbVerLancamento.setForeground(new Color(0, 0, 205));
		tbVerLancamento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		tbVerLancamento.setDefaultRenderer(Object.class, new TabLinhas());
		tbVerLancamento.setGridColor(new Color(0, 0, 205));
		
		tbVerLancamento.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "LAN\u00C7AMENTO",
				"SALDO ANTERIOR", "OP", "QUANTIDADE", "=", "SALDO ATUAL", "DETALHAMENTO" }) {
			boolean[] columnEditables = new boolean[] { true, false, false, true, false, true, false, true };
			
			public Class<?> getColumnClass(int columns) {
	               Class<?> returnValue;
	               if ((columns >= 0) && (columns < getColumnCount())) {
	                 returnValue = getValueAt(0, columns).getClass();
	               } else {
	                 returnValue = Object.class;
	               }
	               return returnValue;
	             }

			public boolean isCellEditable(int row, int columns) {
				return columnEditables[columns];
			}
		});
		
			
		
		tbVerLancamento.getColumnModel().getColumn(0).setResizable(false);
		tbVerLancamento.getColumnModel().getColumn(0).setPreferredWidth(40);
		tbVerLancamento.getColumnModel().getColumn(1).setPreferredWidth(118);
		tbVerLancamento.getColumnModel().getColumn(2).setPreferredWidth(110);
		tbVerLancamento.getColumnModel().getColumn(3).setPreferredWidth(28);
		tbVerLancamento.getColumnModel().getColumn(4).setPreferredWidth(80);
		tbVerLancamento.getColumnModel().getColumn(5).setPreferredWidth(21);
		tbVerLancamento.getColumnModel().getColumn(6).setPreferredWidth(80);
		tbVerLancamento.getColumnModel().getColumn(7).setPreferredWidth(400);
		tbVerLancamento.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		
		DefaultTableModel model1 = (DefaultTableModel) tbVerLancamento.getModel();
		model.setNumRows(0);
		
		RowSorter<TableModel> sorter1 =
        new TableRowSorter<TableModel>(model1);
		tbVerLancamento.setRowSorter(sorter1);
	
		spVerLancamento.setViewportView(tbVerLancamento);

		btnPesquisarLancamento = new JButton("Pesquisar");
		btnPesquisarLancamento.setToolTipText("Pesquisar");
		btnPesquisarLancamento.setMnemonic('p');
		btnPesquisarLancamento.setBounds(640, 103, 100, 23);
		btnPesquisarLancamento
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnPesquisarLancamento.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPesquisarLancamento.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnPesquisarLancamento.setContentAreaFilled(false);
		btnPesquisarLancamento.setForeground(Color.WHITE);
		btnPesquisarLancamento.setBorder(null);
		btnPesquisarLancamento.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnPesquisarLancamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				spVerLancamento.setVisible(false);

				if (dcDataInicialPesquisa.getDate() == null) {

					JOptionPane.showMessageDialog(null, "Digite ou selecione a data inicial", "Ver lançamentos",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (dcDataFinalPesquisa.getDate() == null) {

					JOptionPane.showMessageDialog(null, "Digite ou selecione a data final", "Ver lançamentos",
							JOptionPane.INFORMATION_MESSAGE);

				} else {

					java.util.Date dataUtil = dcDataInicialPesquisa.getDate();
					java.util.Date dataUtil2 = dcDataFinalPesquisa.getDate();

					java.sql.Date DataSql = null;
					java.sql.Date DataSql2 = null;

					DataSql = new java.sql.Date(dataUtil.getTime());
					DataSql2 = new java.sql.Date(dataUtil2.getTime());

					LancamentoServicoController lancamentoServicoController = new LancamentoServicoController();
					listaLancamentoServicoPorData = new ArrayList<>();

					listaLancamentoServicoPorData = (ArrayList<LancamentoServico>) lancamentoServicoController
							.listaLancamentoIdServicoPorData(DataSql, DataSql2, clienteServico.getId_clienteServico());

					if (listaLancamentoServicoPorData.isEmpty()) {

						JOptionPane.showMessageDialog(null, "Lista vazia", "Ver lançamentos",
								JOptionPane.INFORMATION_MESSAGE);

						dcDataInicialPesquisa.setDate(null);
						dcDataFinalPesquisa.setDate(null);

					} else {

						spVerLancamento.setVisible(true);

						NumberFormat tresDigitos = new DecimalFormat("000");

						DateFormat formatBR = new SimpleDateFormat("dd/MM/YYYY");
						String dataBr = "";

						DefaultTableModel model = (DefaultTableModel) tbVerLancamento.getModel();
						model.setNumRows(0);

						int id = 1;

						for (LancamentoServico ls : listaLancamentoServicoPorData) {

							dataBr = formatBR.format(ls.getDataDoLancamento());

							String operacao = ls.getObservacoesLancamento().substring(1, 2);

							Object[] linha = { tresDigitos.format(id), dataBr, tresDigitos.format(ls.getSaldoAnterior()), operacao,
									tresDigitos.format(ls.getQuantidadeDoPedido()), "=", tresDigitos.format(ls.getSaldoAtual()),
									ls.getObservacoesLancamento().toUpperCase() };

							model.addRow(linha);

							id++;

						}

						dcDataInicialPesquisa.setDate(null);
						dcDataFinalPesquisa.setDate(null);

					}

				}

			}
		});
		verLancamentoPanel.add(btnPesquisarLancamento);

		lblClienteVerLançamento = new JLabel("Cliente");
		lblClienteVerLançamento.setHorizontalTextPosition(SwingConstants.CENTER);
		lblClienteVerLançamento.setBounds(13, 29, 994, 14);
		lblClienteVerLançamento.setForeground(new Color(0, 0, 205));
		lblClienteVerLançamento.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 14));
		lblClienteVerLançamento.setHorizontalAlignment(SwingConstants.CENTER);
		verLancamentoPanel.add(lblClienteVerLançamento);

		lblServicoLancamento = new JLabel("Servi\u00E7o");
		lblServicoLancamento.setHorizontalTextPosition(SwingConstants.CENTER);
		lblServicoLancamento.setBounds(13, 47, 994, 14);
		lblServicoLancamento.setForeground(new Color(0, 0, 205));
		lblServicoLancamento.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 14));
		lblServicoLancamento.setHorizontalAlignment(SwingConstants.CENTER);
		verLancamentoPanel.add(lblServicoLancamento);

		lblProdutoLancamento = new JLabel("Produto");
		lblProdutoLancamento.setHorizontalTextPosition(SwingConstants.CENTER);
		lblProdutoLancamento.setBounds(13, 66, 994, 14);
		lblProdutoLancamento.setForeground(new Color(0, 0, 205));
		lblProdutoLancamento.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 14));
		lblProdutoLancamento.setHorizontalAlignment(SwingConstants.CENTER);
		verLancamentoPanel.add(lblProdutoLancamento);

		JButton btnSalvar = new JButton("Exportar");
		btnSalvar.setToolTipText("Exportar Lan\u00E7amento");
		btnSalvar.setMnemonic('e');
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (spVerLancamento.isVisible() == false) {

					JOptionPane.showMessageDialog(null, "Faça uma pesquisa!", "Planilha Lançamento",
							JOptionPane.ERROR_MESSAGE);

				} else {

					ExportarCsv exportarCsv = new ExportarCsv();

					String arquivo = "C:/Comercial/lançamento";

					boolean sucesso;

					try {

						sucesso = exportarCsv.exportarCsv(arquivo, listaLancamentoServicoPorData);

						if (sucesso) {

							try {

								// Executa o excel
								Runtime.getRuntime().exec("cmd.exe /C start excel.exe " + arquivo);

							} catch (java.io.IOException e1) {

								JOptionPane.showMessageDialog(null,
										"Caminho do Arquivo esta errado, contate os Desenvolvedores " + e1,
										"Exportar tabela", JOptionPane.ERROR_MESSAGE);

							}

						}

					} catch (HeadlessException | IOException e2) {

						JOptionPane.showMessageDialog(null, "Erro, o arquivo já está aberto!\n " + e2,
								"Exportar Lançamento", JOptionPane.ERROR_MESSAGE);

					}

				}
			}
		});
		btnSalvar.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnSalvar.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnSalvar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnSalvar.setContentAreaFilled(false);
		btnSalvar.setBorder(null);
		btnSalvar.setBounds(778, 421, 83, 23);
		verLancamentoPanel.add(btnSalvar);

		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setToolTipText("Imprimir Relat\u00F3rio");
		btnImprimir.setMnemonic('i');
		btnImprimir.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (spVerLancamento.isVisible() == false) {

					JOptionPane.showMessageDialog(null, "Faça uma pesquisa!", "Imprimir Planilha",
							JOptionPane.ERROR_MESSAGE);

				} else {

					RelatorioLancamento relatorioLancamento = new RelatorioLancamento();

					try {

						relatorioLancamento.gerarRelatorioLancamento(listaLancamentoServicoPorData);

					} catch (JRException e1) {

						e1.printStackTrace();

					}

				}
			}
		});
		btnImprimir.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnImprimir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnImprimir.setForeground(Color.WHITE);
		btnImprimir.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnImprimir.setContentAreaFilled(false);
		btnImprimir.setBorder(null);
		btnImprimir.setBounds(685, 421, 83, 23);
		verLancamentoPanel.add(btnImprimir);

		JPanel servicoClientePanel = new JPanel();
		servicoClientePanel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnSalvarConta);
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnSelecionar);
				
			}
		});
		servicoClientePanel.setBackground(Color.WHITE);
		servicoClientePanel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		servicoClientePanel.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		pnlCliente.add(servicoClientePanel, "Conta");
		servicoClientePanel.setLayout(null);

		tfNomeDoServico = new JTextField();
		tfNomeDoServico.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfNomeDoServico.setToolTipText("Nome");
		tfNomeDoServico.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfNomeDoServico.setBounds(277, 107, 279, 22);
		servicoClientePanel.add(tfNomeDoServico);
		tfNomeDoServico.setColumns(10);

		JLabel lblNomeDoServico = new JLabel("Nome do Servi\u00E7o");
		lblNomeDoServico.setForeground(new Color(0, 0, 205));
		lblNomeDoServico.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNomeDoServico.setBounds(277, 87, 109, 14);
		servicoClientePanel.add(lblNomeDoServico);

		JLabel lblCnpjDoServico = new JLabel("CNPJ para cobran\u00E7a");
		lblCnpjDoServico.setForeground(new Color(0, 0, 205));
		lblCnpjDoServico.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblCnpjDoServico.setBounds(566, 87, 167, 14);
		servicoClientePanel.add(lblCnpjDoServico);

		tfCnpjDoServico = new JFormattedTextField(ClienteUteis.CNPJ(""));
		tfCnpjDoServico.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfCnpjDoServico.setToolTipText("Nome");
		tfCnpjDoServico.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfCnpjDoServico.setColumns(10);
		tfCnpjDoServico.setBounds(566, 107, 167, 22);
		servicoClientePanel.add(tfCnpjDoServico);

		JLabel lblObservacoesConta = new JLabel("Observa\u00E7\u00F5es");
		lblObservacoesConta.setForeground(new Color(0, 0, 205));
		lblObservacoesConta.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblObservacoesConta.setBounds(378, 191, 97, 14);
		servicoClientePanel.add(lblObservacoesConta);

		JLabel lblProdutoDoServico = new JLabel("Produto");
		lblProdutoDoServico.setForeground(new Color(0, 0, 205));
		lblProdutoDoServico.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblProdutoDoServico.setBounds(277, 139, 115, 14);
		servicoClientePanel.add(lblProdutoDoServico);

		cbProdutoDoServico = new JComboBox<String>();
		cbProdutoDoServico.setBorder(new LineBorder(new Color(0, 0, 205)));
		cbProdutoDoServico.addItem("SELECIONE...");

		listaProdutoDoServico = new ArrayList<ProdutoDoServico>();
		ProdutoDoServicoController produtoDoServicoController = new ProdutoDoServicoController();
		listaProdutoDoServico = produtoDoServicoController.todosOsProdutos();

		for (ProdutoDoServico pds : listaProdutoDoServico) {

			cbProdutoDoServico.addItem(pds.getNomeDoProduto());

		}

		cbProdutoDoServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cbProdutoDoServico.getSelectedIndex() == 0) {

					btnVerProduto.setVisible(false);

				} else {

					btnVerProduto.setVisible(true);

				}

			}
		});

		cbProdutoDoServico.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		cbProdutoDoServico.setBounds(277, 159, 279, 22);
		servicoClientePanel.add(cbProdutoDoServico);

		JLabel lblValorUnitario = new JLabel("Valor Unit\u00E1rio");
		lblValorUnitario.setForeground(new Color(0, 0, 205));
		lblValorUnitario.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblValorUnitario.setBounds(646, 139, 87, 14);
		servicoClientePanel.add(lblValorUnitario);

		tfValorUnitario = new JNumberFormatField(new DecimalFormat("R$ 0.00"));
		tfValorUnitario.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfValorUnitario.setToolTipText("Nome");
		tfValorUnitario.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfValorUnitario.setColumns(10);
		tfValorUnitario.setBounds(646, 159, 87, 22);
		servicoClientePanel.add(tfValorUnitario);

		JLabel lblLimiteMinimo = new JLabel("Limite M\u00EDnimo");
		lblLimiteMinimo.setForeground(new Color(0, 0, 205));
		lblLimiteMinimo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblLimiteMinimo.setBounds(277, 191, 81, 14);
		servicoClientePanel.add(lblLimiteMinimo);

		btnSalvarConta = new JButton("Salvar");
		btnSalvarConta.setMnemonic('s');
		btnSalvarConta.setToolTipText("Salvar Servi\u00E7o");
		btnSalvarConta.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnSalvarConta.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnSalvarConta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalvarConta.setBorder(null);
		btnSalvarConta.setContentAreaFilled(false);
		btnSalvarConta.setForeground(Color.WHITE);
		btnSalvarConta.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnSalvarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tfNomeDoServico.getText() == null || tfNomeDoServico.getText().trim().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Digite o nome do serviço!", "Campo Obrigatório",
							JOptionPane.ERROR_MESSAGE);
					tfNomeDoServico.requestFocus();

				} else if (tfCnpjDoServico.getText() == null || tfCnpjDoServico.getText().trim().isEmpty()
						|| tfCnpjDoServico.getText().equalsIgnoreCase("  .   .   /    -  ")) {

					JOptionPane.showMessageDialog(null, "Digite o CNPJ do serviço!", "Campo Obrigatório",
							JOptionPane.ERROR_MESSAGE);
					tfCnpjDoServico.requestFocus();

				} else if (cbProdutoDoServico.getSelectedItem().equals("SELECIONE...")) {

					JOptionPane.showMessageDialog(null, "Selecione o produto do serviço!", "Campo Obrigatório",
							JOptionPane.ERROR_MESSAGE);
					cbProdutoDoServico.requestFocus();

				} else if (tfValorUnitario.getText() == null || tfValorUnitario.getText().trim().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Digite o valor unitário do serviço!", "Campo Obrigatório",
							JOptionPane.ERROR_MESSAGE);
					tfValorUnitario.requestFocus();

				} else if (tpObservacoesDoServico.getText() == null
						|| tpObservacoesDoServico.getText().trim().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Digite as observações do serviço!", "Campo Obrigatório",
							JOptionPane.ERROR_MESSAGE);
					tpObservacoesDoServico.requestFocus();

				} else {

					if (tipoSalvarOuEditarServico == true) {

						boolean sucesso = false;

						String vu = tfValorUnitario.getText().replace("R$ ", "");

						double valorUnitario = Double.valueOf(vu.replace(",", "."));

						clienteServico = new ClienteServico();
						ClienteServicoController clienteServicoController = new ClienteServicoController();
						clienteServico.setNomeDoServico(tfNomeDoServico.getText().toUpperCase());
						clienteServico.setCnpjDoServico(tfCnpjDoServico.getText());
						clienteServico.setProdutoDoServico(
								String.valueOf(cbProdutoDoServico.getSelectedItem()).toUpperCase());
						clienteServico.setValorUnitario(valorUnitario);
						clienteServico.setLimiteMinimo(Integer.valueOf(tfLimiteMinimo.getText()));
						clienteServico.setObservacoesServico(tpObservacoesDoServico.getText());
						clienteServico.setId_cliente(cliente.getId_cliente());

						sucesso = clienteServicoController.criarServicoCliente(clienteServico);

						if (sucesso == true) {

							LogSegurancaController.novoLogSeguranca("SERVIÇO SALVO");

							JOptionPane.showMessageDialog(null, "Serviço salvo!", "Novo Serviço",
									JOptionPane.INFORMATION_MESSAGE);

							atualizarServico();

							limparServicoClientePanel();

							cardlayout.show(pnlCliente, "Dados");

						} else {

							LogSegurancaController.novoLogSeguranca("SERVIÇO NÃO SALVO");

							JOptionPane.showMessageDialog(null, "O Serviço não foi salvo!", "Novo Serviço",
									JOptionPane.ERROR_MESSAGE);

							cardlayout.show(pnlCliente, "Dados");

						}

					} else {

						boolean sucesso = false;

						String vu = tfValorUnitario.getText().replace("R$ ", "");

						double valorUnitario = Double.valueOf(vu.replace(",", "."));

						ClienteServico clienteTemp = new ClienteServico();
						ClienteServicoController clienteServicoController = new ClienteServicoController();

						clienteTemp.setId_clienteServico(clienteServico.getId_clienteServico());
						clienteTemp.setNomeDoServico(tfNomeDoServico.getText().toUpperCase());
						clienteTemp.setCnpjDoServico(tfCnpjDoServico.getText());
						clienteTemp.setProdutoDoServico(
								String.valueOf(cbProdutoDoServico.getSelectedItem()).toUpperCase());
						clienteTemp.setSaldoServico(clienteServico.getSaldoServico());
						clienteTemp.setValorUnitario(valorUnitario);
						clienteTemp.setLimiteMinimo(Integer.valueOf(tfLimiteMinimo.getText()));
						clienteTemp.setObservacoesServico(tpObservacoesDoServico.getText());
						clienteTemp.setId_cliente(cliente.getId_cliente());

						if (clienteTemp.toString().equals(clienteServico.toString())) {

							JOptionPane.showMessageDialog(null, "Não houve edição no servico!", "Editar Serviço",
									JOptionPane.ERROR_MESSAGE);

							lblCadastroDeServiços.setText("CADASTRO DO SERVIÇO");
							setTipoSalvarOuEditarServico(true);
							btnSalvarConta.setText("Salvar");

							cardlayout.show(pnlCliente, "Dados");

						} else {

							sucesso = clienteServicoController.editarServicoCliente(clienteTemp);

							if (sucesso == true) {

								LogSegurancaController.novoLogSeguranca("SERVIÇO EDITADO");

								JOptionPane.showMessageDialog(null, "Serviço editado!", "Editar Serviço",
										JOptionPane.INFORMATION_MESSAGE);

								atualizarServico();

								limparServicoClientePanel();

								cardlayout.show(pnlCliente, "Dados");

								lblCadastroDeServiços.setText("CADASTRO DO SERVIÇO");
								setTipoSalvarOuEditarServico(true);
								btnSalvarConta.setText("Salvar");

							} else {

								LogSegurancaController.novoLogSeguranca("SERVIÇO NÃO EDITADO");

								JOptionPane.showMessageDialog(null, "O Serviço não foi editado!", "Editar Serviço",
										JOptionPane.ERROR_MESSAGE);

								cardlayout.show(pnlCliente, "Dados");

								lblCadastroDeServiços.setText("CADASTRO DO SERVIÇO");
								setTipoSalvarOuEditarServico(true);
								btnSalvarConta.setText("Salvar");

							}

						}

					}

				}

			}
		});
		btnSalvarConta.setBounds(277, 302, 97, 23);
		servicoClientePanel.add(btnSalvarConta);

		JButton btnCancelarConta = new JButton("Cancelar");
		btnCancelarConta.setMnemonic('c');
		btnCancelarConta.setToolTipText("Cancelar");
		btnCancelarConta.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnCancelarConta.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnCancelarConta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelarConta.setBorder(null);
		btnCancelarConta.setContentAreaFilled(false);
		btnCancelarConta.setForeground(Color.WHITE);
		btnCancelarConta.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnCancelarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limparServicoClientePanel();

				lblCadastroDeServiços.setText("CADASTRO DO SERVIÇO");
				setTipoSalvarOuEditarServico(true);
				btnSalvarConta.setText("Salvar");

				cardlayout.show(pnlCliente, "Dados");

			}
		});
		btnCancelarConta.setBounds(644, 302, 89, 23);
		servicoClientePanel.add(btnCancelarConta);

		TamanhoMaxTextField TamanhoMax1 = new TamanhoMaxTextField();
		TamanhoMaxTextField TamanhoMax2 = new TamanhoMaxTextField();
		TamanhoMaxTextField TamanhoMax3 = new TamanhoMaxTextField();
		TamanhoMaxTextField TamanhoMax4 = new TamanhoMaxTextField();
		TamanhoMax1.setMaxChars(7);
		TamanhoMax2.setMaxChars(7);
		TamanhoMax3.setMaxChars(7);
		TamanhoMax4.setMaxChars(7);

		lblCadastroDeServiços = new JLabel("CADASTRO DO SERVI\u00C7O");
		lblCadastroDeServiços.setForeground(new Color(0, 0, 205));
		lblCadastroDeServiços.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeServiços.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblCadastroDeServiços.setBounds(13, 0, 994, 30);
		servicoClientePanel.add(lblCadastroDeServiços);

		JButton btnExcluir_1 = new JButton("Excluir");
		btnExcluir_1.setMnemonic('e');
		btnExcluir_1.setToolTipText("Excluir Servi\u00E7o");
		btnExcluir_1.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnExcluir_1.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnExcluir_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExcluir_1.setBorder(null);
		btnExcluir_1.setContentAreaFilled(false);
		btnExcluir_1.setForeground(Color.WHITE);
		btnExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resposta = 0;

				resposta = JOptionPane.showConfirmDialog(null, "Você deseja excluir o servico?", "Excluir Servico",
						JOptionPane.YES_NO_OPTION);

				if (resposta == 0) {

					boolean sucesso = false;
					ClienteServicoController clienteServicoController = new ClienteServicoController();
					sucesso = clienteServicoController.excluirServicoCliente(clienteServico.getId_clienteServico());

					if (sucesso) {

						LogSegurancaController.novoLogSeguranca("SERVIÇO EXCLUÍDO");

						JOptionPane.showMessageDialog(null, "Serviço excluído!", "Excluir Serviço",
								JOptionPane.INFORMATION_MESSAGE);

						atualizarServico();

						limparServicoClientePanel();

						cardlayout.show(pnlCliente, "Dados");

						lblCadastroDeServiços.setText("CADASTRO DO SERVIÇO");
						setTipoSalvarOuEditarServico(true);
						btnSalvarConta.setText("Salvar");

					} else {

						LogSegurancaController.novoLogSeguranca("SERVIÇO NÃO EXCLUÍDO");

						JOptionPane.showMessageDialog(null, "O Serviço não foi excluído!", "Excluir Serviço",
								JOptionPane.INFORMATION_MESSAGE);

						limparServicoClientePanel();

						cardlayout.show(pnlCliente, "Dados");

						lblCadastroDeServiços.setText("CADASTRO DO SERVIÇO");
						setTipoSalvarOuEditarServico(true);
						btnSalvarConta.setText("Salvar");

					}

				} else {

					limparServicoClientePanel();

					cardlayout.show(pnlCliente, "Dados");

					lblCadastroDeServiços.setText("CADASTRO DO SERVIÇO");
					setTipoSalvarOuEditarServico(true);
					btnSalvarConta.setText("Salvar");

				}

			}
		});
		btnExcluir_1.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnExcluir_1.setBounds(461, 302, 97, 23);
		servicoClientePanel.add(btnExcluir_1);

		JScrollPane scpObservacoesDoServico = new JScrollPane();
		scpObservacoesDoServico.setBorder(new LineBorder(new Color(0, 0, 205)));
		scpObservacoesDoServico.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scpObservacoesDoServico.setBounds(378, 211, 354, 64);
		servicoClientePanel.add(scpObservacoesDoServico);

		tpObservacoesDoServico = new JTextPane();
		tpObservacoesDoServico.setBorder(null);
		tpObservacoesDoServico.setForeground(Color.RED);
		tpObservacoesDoServico.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		scpObservacoesDoServico.setViewportView(tpObservacoesDoServico);

		tfLimiteMinimo = new JNumberFormatField();
		tfLimiteMinimo.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfLimiteMinimo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfLimiteMinimo.setBounds(277, 211, 89, 22);
		servicoClientePanel.add(tfLimiteMinimo);
		tfLimiteMinimo.setColumns(10);

		tfLimiteMinimo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {

				String caracteres = "0987654321,.-+";

				if (!caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}

			}

		});
		tfLimiteMinimo.setDocument(TamanhoMax2);

		lblClienteServico = new JLabel("Cliente");
		lblClienteServico.setForeground(new Color(0, 0, 205));
		lblClienteServico.setHorizontalAlignment(SwingConstants.CENTER);
		lblClienteServico.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 14));
		lblClienteServico.setBounds(13, 32, 994, 14);
		servicoClientePanel.add(lblClienteServico);

		btnVerProduto = new JButton("");
		btnVerProduto.setToolTipText("Visualizar o Produto");
		btnVerProduto.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/pesquisar.png")));
		btnVerProduto.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/pesquisar - Copia.png")));
		btnVerProduto.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVerProduto.setContentAreaFilled(false);
		btnVerProduto.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnVerProduto.setBorder(null);
		btnVerProduto.setForeground(Color.WHITE);
		btnVerProduto.setVisible(false);
		btnVerProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cbProdutoDoServico.getSelectedIndex() != 0) {

					int numero = cbProdutoDoServico.getSelectedIndex();

					int id_produtoDoServico = listaProdutoDoServico.get(numero - 1).getId_produtoDoServico();

					ProdutoDoServicoController produtoDoServicoController = new ProdutoDoServicoController();
					ProdutoDoServico produtoDoServico = new ProdutoDoServico();
					produtoDoServico = produtoDoServicoController.buscaProdutoDoServico(id_produtoDoServico);

					try {

						VisualizarProdutoView dialog = new VisualizarProdutoView();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setLocationRelativeTo(null);

						dialog.getTpProduto().setText(produtoDoServico.toString());

						dialog.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}

			}
		});
		btnVerProduto.setBounds(566, 139, 68, 56);
		servicoClientePanel.add(btnVerProduto);

		dadosClientePanel = new JPanel();
		dadosClientePanel.setBackground(Color.WHITE);
		dadosClientePanel.setForeground(new Color(0, 0, 205));
		dadosClientePanel.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		dadosClientePanel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		pnlCliente.add(dadosClientePanel, "Dados");

		JLabel lblNomeFantasiaEtiq = new JLabel("Nome Fantasia");
		lblNomeFantasiaEtiq.setBounds(57, 9, 165, 17);
		lblNomeFantasiaEtiq.setForeground(new Color(0, 0, 205));
		lblNomeFantasiaEtiq.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		JLabel lblRazaoSocialEtiq = new JLabel("Raz\u00E3o Social");
		lblRazaoSocialEtiq.setBounds(57, 45, 74, 17);
		lblRazaoSocialEtiq.setForeground(new Color(0, 0, 205));
		lblRazaoSocialEtiq.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		JLabel lblContatoEtiq = new JLabel("Contato 1");
		lblContatoEtiq.setBounds(57, 120, 152, 17);
		lblContatoEtiq.setForeground(new Color(0, 0, 205));
		lblContatoEtiq.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		JLabel lblFone1Etiq = new JLabel("Fone Celular 1");
		lblFone1Etiq.setBounds(413, 120, 74, 17);
		lblFone1Etiq.setForeground(new Color(0, 0, 205));
		lblFone1Etiq.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		JLabel lblFone2Etiq = new JLabel("Fone Fixo 1");
		lblFone2Etiq.setBounds(57, 159, 68, 17);
		lblFone2Etiq.setForeground(new Color(0, 0, 205));
		lblFone2Etiq.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		JLabel lblCnpjEtiq = new JLabel("CNPJ");
		lblCnpjEtiq.setBounds(57, 83, 39, 17);
		lblCnpjEtiq.setForeground(new Color(0, 0, 205));
		lblCnpjEtiq.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		JLabel lblInscrEstadualEtiq = new JLabel("Inscri\u00E7\u00E3o Estadual");
		lblInscrEstadualEtiq.setBounds(217, 83, 102, 17);
		lblInscrEstadualEtiq.setForeground(new Color(0, 0, 205));
		lblInscrEstadualEtiq.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		JLabel lblEndereEtiq = new JLabel("Endere\u00E7o (Rua / Av.)");
		lblEndereEtiq.setBounds(57, 270, 132, 17);
		lblEndereEtiq.setForeground(new Color(0, 0, 205));
		lblEndereEtiq.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		JLabel lblBairroEtiq = new JLabel("Bairro");
		lblBairroEtiq.setBounds(340, 270, 39, 17);
		lblBairroEtiq.setForeground(new Color(0, 0, 205));
		lblBairroEtiq.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		JLabel lblCidadeEtiq = new JLabel("Cidade");
		lblCidadeEtiq.setBounds(57, 305, 44, 17);
		lblCidadeEtiq.setForeground(new Color(0, 0, 205));
		lblCidadeEtiq.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		JLabel lblCepEtiq = new JLabel("CEP");
		lblCepEtiq.setBounds(311, 305, 31, 17);
		lblCepEtiq.setForeground(new Color(0, 0, 205));
		lblCepEtiq.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		JLabel lblUfEtiq = new JLabel("UF");
		lblUfEtiq.setBounds(465, 305, 25, 17);
		lblUfEtiq.setForeground(new Color(0, 0, 205));
		lblUfEtiq.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		JLabel lblEmail1 = new JLabel("E-mail 1");
		lblEmail1.setBounds(171, 159, 44, 17);
		lblEmail1.setForeground(new Color(0, 0, 205));
		lblEmail1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		tfFoneCelular1 = new JTextField();
		tfFoneCelular1.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfFoneCelular1.setForeground(Color.BLACK);
		tfFoneCelular1.setEditable(false);
		tfFoneCelular1.setBounds(413, 136, 108, 20);
		tfFoneCelular1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfFoneCelular1.setColumns(10);
		tfFoneCelular1.setBackground(Color.WHITE);

		tfFoneFixo1 = new JTextField();
		tfFoneFixo1.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfFoneFixo1.setForeground(Color.BLACK);
		tfFoneFixo1.setEditable(false);
		tfFoneFixo1.setBounds(57, 176, 103, 20);
		tfFoneFixo1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfFoneFixo1.setColumns(10);
		tfFoneFixo1.setBackground(Color.WHITE);

		tfEmail1 = new JTextField();
		tfEmail1.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfEmail1.setEditable(false);
		tfEmail1.setForeground(Color.BLACK);
		tfEmail1.setBounds(171, 176, 350, 20);
		tfEmail1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfEmail1.setColumns(10);
		tfEmail1.setBackground(Color.WHITE);

		dadosClientePanel.setLayout(null);
		dadosClientePanel.add(lblCepEtiq);
		dadosClientePanel.add(lblUfEtiq);
		dadosClientePanel.add(lblBairroEtiq);
		dadosClientePanel.add(lblCidadeEtiq);
		dadosClientePanel.add(lblEndereEtiq);
		dadosClientePanel.add(lblCnpjEtiq);
		dadosClientePanel.add(lblInscrEstadualEtiq);
		dadosClientePanel.add(lblContatoEtiq);
		dadosClientePanel.add(lblRazaoSocialEtiq);
		dadosClientePanel.add(lblNomeFantasiaEtiq);
		dadosClientePanel.add(lblFone1Etiq);
		dadosClientePanel.add(tfFoneCelular1);
		dadosClientePanel.add(lblEmail1);
		dadosClientePanel.add(lblFone2Etiq);
		dadosClientePanel.add(tfEmail1);
		dadosClientePanel.add(tfFoneFixo1);

		tfRazaoSocial = new JTextField();
		tfRazaoSocial.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfRazaoSocial.setForeground(Color.BLACK);
		tfRazaoSocial.setEditable(false);
		tfRazaoSocial.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfRazaoSocial.setColumns(10);
		tfRazaoSocial.setBackground(Color.WHITE);
		tfRazaoSocial.setBounds(57, 62, 346, 20);
		dadosClientePanel.add(tfRazaoSocial);

		tfContato1 = new JTextField();
		tfContato1.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfContato1.setForeground(Color.BLACK);
		tfContato1.setEditable(false);
		tfContato1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfContato1.setColumns(10);
		tfContato1.setBackground(Color.WHITE);
		tfContato1.setBounds(57, 136, 346, 20);
		dadosClientePanel.add(tfContato1);

		tfCNPJ = new JTextField();
		tfCNPJ.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfCNPJ.setForeground(Color.BLACK);
		tfCNPJ.setEditable(false);
		tfCNPJ.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfCNPJ.setColumns(10);
		tfCNPJ.setBackground(Color.WHITE);
		tfCNPJ.setBounds(57, 100, 152, 20);
		dadosClientePanel.add(tfCNPJ);

		tfInscricaoEstadual = new JTextField();
		tfInscricaoEstadual.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfInscricaoEstadual.setForeground(Color.BLACK);
		tfInscricaoEstadual.setEditable(false);
		tfInscricaoEstadual.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfInscricaoEstadual.setColumns(10);
		tfInscricaoEstadual.setBackground(Color.WHITE);
		tfInscricaoEstadual.setBounds(217, 100, 144, 20);
		dadosClientePanel.add(tfInscricaoEstadual);

		tfLogradouro = new JTextField();
		tfLogradouro.setForeground(Color.BLACK);
		tfLogradouro.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfLogradouro.setEditable(false);
		tfLogradouro.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfLogradouro.setColumns(10);
		tfLogradouro.setBackground(Color.WHITE);
		tfLogradouro.setBounds(57, 286, 273, 20);
		dadosClientePanel.add(tfLogradouro);

		tfBairro = new JTextField();
		tfBairro.setForeground(Color.BLACK);
		tfBairro.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfBairro.setEditable(false);
		tfBairro.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfBairro.setColumns(10);
		tfBairro.setBackground(Color.WHITE);
		tfBairro.setBounds(340, 286, 181, 20);
		dadosClientePanel.add(tfBairro);

		tfCidade = new JTextField();
		tfCidade.setForeground(Color.BLACK);
		tfCidade.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfCidade.setEditable(false);
		tfCidade.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfCidade.setColumns(10);
		tfCidade.setBackground(Color.WHITE);
		tfCidade.setBounds(57, 322, 240, 20);
		dadosClientePanel.add(tfCidade);

		tfCep = new JTextField();
		tfCep.setForeground(Color.BLACK);
		tfCep.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfCep.setEditable(false);
		tfCep.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfCep.setColumns(10);
		tfCep.setBackground(Color.WHITE);
		tfCep.setBounds(311, 322, 140, 20);
		dadosClientePanel.add(tfCep);

		JPanel pnlContasCadastradas = new JPanel();
		pnlContasCadastradas.setBackground(Color.WHITE);
		pnlContasCadastradas.setForeground(new Color(0, 0, 205));
		pnlContasCadastradas.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		pnlContasCadastradas.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 205)), "Servi\u00E7os",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		pnlContasCadastradas.setBounds(579, 11, 379, 430);
		dadosClientePanel.add(pnlContasCadastradas);

		JLabel lblSituacao = new JLabel("CNPJ:");
		lblSituacao.setBounds(37, 169, 95, 20);
		lblSituacao.setForeground(new Color(0, 0, 205));
		lblSituacao.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));

		cbServicosCadastrados = new JComboBox<String>();
		cbServicosCadastrados.setBorder(new LineBorder(new Color(0, 0, 205)));
		cbServicosCadastrados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int posicao = cbServicosCadastrados.getSelectedIndex();

				if (cbServicosCadastrados.getSelectedIndex() > 0) {
					
					getRootPane().setDefaultButton(btnLancamentos);
					
					NumberFormat tresDigitos = new DecimalFormat("000");

					ClienteServicoController clienteServicoController = new ClienteServicoController();
					clienteServico = clienteServicoController
							.buscarClienteServico(listaClienteServico.get(posicao - 1).getId_clienteServico());

					tfProdutoServico.setText(clienteServico.getProdutoDoServico().toUpperCase());
					tfSaldoServico.setText(String.valueOf(clienteServico.getSaldoServico()));
					tfValorUnitarioServico.setText(String.valueOf(clienteServico.getValorUnitario()));
					tfCnpjServico.setText(clienteServico.getCnpjDoServico());
					tpObsServico.setText(cliente.getDetalhes());

					tfProdutoServico.setText(listaClienteServico.get(posicao - 1).getProdutoDoServico().toUpperCase());
					tfSaldoServico.setText(tresDigitos.format(listaClienteServico.get(posicao - 1).getSaldoServico()));
					tfValorUnitarioServico
							.setText(String.valueOf(listaClienteServico.get(posicao - 1).getValorUnitario() * 10));
					tfCnpjServico.setText(listaClienteServico.get(posicao - 1).getCnpjDoServico());
					tpObsServico.setText(listaClienteServico.get(posicao - 1).getObservacoesServico().toUpperCase());

				} else {

					tfProdutoServico.setText("");
					tfSaldoServico.setText("");
					tfValorUnitarioServico.setText("");
					tfCnpjServico.setText("");
					tpObsServico.setText("");

				}

			}
		});
		cbServicosCadastrados.setBounds(36, 36, 306, 23);
		cbServicosCadastrados.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));

		JButton btnVerLançamento = new JButton("Ver Lan\u00E7amentos");
		btnVerLançamento.setToolTipText("Ver Lan\u00E7amentos");
		btnVerLançamento.setMnemonic('v');
		btnVerLançamento.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnVerLançamento.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnVerLançamento.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVerLançamento.setContentAreaFilled(false);
		btnVerLançamento.setBorder(null);
		btnVerLançamento.setForeground(Color.WHITE);
		btnVerLançamento.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnVerLançamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (cbServicosCadastrados.getSelectedIndex() == 0) {

					JOptionPane.showMessageDialog(null, "Selecione o serviço", "Serviços Cadastrados",
							JOptionPane.INFORMATION_MESSAGE);

				} else {

					cardlayout.show(pnlCliente, "Ver Lançamento");
					lblClienteVerLançamento.setText("CLIENTE: " + cliente.getNome().toUpperCase());
					lblServicoLancamento.setText("SERVIÇO: " + clienteServico.getNomeDoServico().toUpperCase());
					lblProdutoLancamento.setText("PRODUTO: " + clienteServico.getProdutoDoServico().toUpperCase());
					// lblProdutoLancamento.setText("PRODUTO: " + "Teste");

				}

			}
		});
		btnVerLançamento.setBounds(201, 383, 142, 23);

		JLabel lblSaldoAtual = new JLabel("Saldo:");
		lblSaldoAtual.setBounds(37, 118, 95, 20);
		lblSaldoAtual.setForeground(new Color(0, 0, 205));
		lblSaldoAtual.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		pnlContasCadastradas.setLayout(null);
		pnlContasCadastradas.add(lblSituacao);
		pnlContasCadastradas.add(lblSaldoAtual);
		pnlContasCadastradas.add(cbServicosCadastrados);
		pnlContasCadastradas.add(btnVerLançamento);

		btnLancamentos = new JButton("Fazer Lan\u00E7amento");
		btnLancamentos.setToolTipText("Fazer Lan\u00E7amento");
		btnLancamentos.setMnemonic('f');
		btnLancamentos.setVisible(false);
		btnLancamentos.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnLancamentos.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnLancamentos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLancamentos.setContentAreaFilled(false);
		btnLancamentos.setBorder(null);
		btnLancamentos.setForeground(Color.WHITE);
		btnLancamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cbServicosCadastrados.getSelectedIndex() == 0) {

					JOptionPane.showMessageDialog(null, "Selecione o serviço", "Serviços Cadastrados",
							JOptionPane.INFORMATION_MESSAGE);

				} else {

					NumberFormat tresDigitos = new DecimalFormat("000");

					cardlayout.show(pnlCliente, "Lançamento");

					tfNomeClienteLancamento.setText(cliente.getNome().toUpperCase());
					tfServicoLancamento.setText(clienteServico.getNomeDoServico());
					tfProdutoDoServico.setText(clienteServico.getProdutoDoServico().toUpperCase());
					tfSaldoAtualLancamento.setText(tresDigitos.format(clienteServico.getSaldoServico()));
					tfCnpjLancamento.setText(clienteServico.getCnpjDoServico());

				}
			}
		});
		btnLancamentos.setBounds(37, 383, 142, 23);
		pnlContasCadastradas.add(btnLancamentos);
		btnLancamentos.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));

		btnNovaConta = new JButton("Novo Servi\u00E7o");
		btnNovaConta.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnNovaConta.setToolTipText("Novo Servi\u00E7o");
		btnNovaConta.setMnemonic('n');
		btnNovaConta.setSelectedIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnNovaConta.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnNovaConta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNovaConta.setContentAreaFilled(false);
		btnNovaConta.setBorder(null);
		btnNovaConta.setForeground(Color.WHITE);
		btnNovaConta.setBounds(37, 349, 142, 23);
		pnlContasCadastradas.add(btnNovaConta);
		btnNovaConta.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));

		JButton btnEditarConta = new JButton("Editar Servi\u00E7o");
		btnEditarConta.setToolTipText("Editar Servi\u00E7o");
		btnEditarConta.setMnemonic('s');
		btnEditarConta.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnEditarConta.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnEditarConta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditarConta.setContentAreaFilled(false);
		btnEditarConta.setBorder(null);
		btnEditarConta.setForeground(Color.WHITE);
		btnEditarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cbServicosCadastrados.getSelectedIndex() == 0) {

					JOptionPane.showMessageDialog(null, "Selecione o serviço", "Serviços Cadastrados",
							JOptionPane.INFORMATION_MESSAGE);

				} else {

					lblClienteServico.setText("CLIENTE: " + cliente.getNome());

					tfNomeDoServico.setText(clienteServico.getNomeDoServico().toUpperCase());
					tfCnpjDoServico.setText(clienteServico.getCnpjDoServico());
					cbProdutoDoServico.setSelectedItem(String.valueOf(clienteServico.getProdutoDoServico()));
					// tfSaldoInicial.setText(String.valueOf(clienteServico.getSaldoServico()));
					tfValorUnitario.setText(String.valueOf(clienteServico.getValorUnitario() * 10));
					tfLimiteMinimo.setText((String.valueOf(clienteServico.getLimiteMinimo())));
					tpObservacoesDoServico.setText(clienteServico.getObservacoesServico().toUpperCase());

					lblCadastroDeServiços.setText("EDITAR O SERVIÇO");
					setTipoSalvarOuEditarServico(false);
					btnSalvarConta.setText("Editar");

					cardlayout.show(pnlCliente, "Conta");

				}

			}
		});
		btnEditarConta.setBounds(201, 349, 142, 23);
		pnlContasCadastradas.add(btnEditarConta);
		btnEditarConta.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));

		tfSaldoServico = new JTextField();
		tfSaldoServico.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfSaldoServico.setBackground(Color.WHITE);
		tfSaldoServico.setEditable(false);
		tfSaldoServico.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfSaldoServico.setBounds(37, 138, 142, 20);
		pnlContasCadastradas.add(tfSaldoServico);
		tfSaldoServico.setColumns(10);

		tfCnpjServico = new JTextField();
		tfCnpjServico.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfCnpjServico.setBackground(Color.WHITE);
		tfCnpjServico.setEditable(false);
		tfCnpjServico.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfCnpjServico.setColumns(10);
		tfCnpjServico.setBounds(37, 189, 306, 20);
		pnlContasCadastradas.add(tfCnpjServico);

		JLabel lblProdutoDoServico_1 = new JLabel("Produto do Servi\u00E7o:");
		lblProdutoDoServico_1.setForeground(new Color(0, 0, 205));
		lblProdutoDoServico_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblProdutoDoServico_1.setBounds(37, 70, 153, 20);
		pnlContasCadastradas.add(lblProdutoDoServico_1);

		tfProdutoServico = new JTextField();
		tfProdutoServico.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfProdutoServico.setBackground(Color.WHITE);
		tfProdutoServico.setEditable(false);
		tfProdutoServico.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfProdutoServico.setColumns(10);
		tfProdutoServico.setBounds(37, 90, 306, 20);
		pnlContasCadastradas.add(tfProdutoServico);

		JLabel lblObservaesDoServio = new JLabel("Observa\u00E7\u00F5es do Servi\u00E7o:");
		lblObservaesDoServio.setForeground(new Color(0, 0, 205));
		lblObservaesDoServio.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblObservaesDoServio.setBounds(37, 220, 153, 20);
		pnlContasCadastradas.add(lblObservaesDoServio);

		JScrollPane spObServico = new JScrollPane();
		spObServico.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		spObServico.setForeground(Color.RED);
		spObServico.setBorder(new LineBorder(new Color(0, 0, 205)));
		spObServico.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spObServico.setBounds(35, 242, 306, 84);
		pnlContasCadastradas.add(spObServico);

		tpObsServico = new JTextPane();
		tpObsServico.setEditable(false);
		tpObsServico.setBorder(null);
		tpObsServico.setForeground(Color.RED);
		tpObsServico.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		spObServico.setViewportView(tpObsServico);

		JLabel lblValorUnitrio = new JLabel("Valor Unit\u00E1rio");
		lblValorUnitrio.setForeground(new Color(0, 0, 205));
		lblValorUnitrio.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblValorUnitrio.setBounds(201, 118, 142, 20);
		pnlContasCadastradas.add(lblValorUnitrio);

		tfValorUnitarioServico = new JNumberFormatField(new DecimalFormat("R$ 0.00"));
		tfValorUnitarioServico.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfValorUnitarioServico.setBackground(Color.WHITE);
		tfValorUnitarioServico.setDisabledTextColor(Color.WHITE);
		tfValorUnitarioServico.setEditable(false);
		tfValorUnitarioServico.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfValorUnitarioServico.setColumns(10);
		tfValorUnitarioServico.setBounds(201, 138, 142, 20);
		pnlContasCadastradas.add(tfValorUnitarioServico);

		btnNovaConta.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				lblClienteServico.setText("CLIENTE: " + cliente.getNome());

				cardlayout.show(pnlCliente, "Conta");

			}
		});

		btnEditarDadosCliente = new JButton("Editar Cliente");
		btnEditarDadosCliente.setToolTipText("Editar Cliente");
		btnEditarDadosCliente.setMnemonic('e');
		btnEditarDadosCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditarDadosCliente
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnEditarDadosCliente.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnEditarDadosCliente.setContentAreaFilled(false);
		btnEditarDadosCliente.setBorder(null);
		btnEditarDadosCliente.setForeground(Color.WHITE);
		btnEditarDadosCliente.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnEditarDadosCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int resposta = 0;

				resposta = JOptionPane.showConfirmDialog(null, "Você deseja editar o cliente selecionado?",
						"Pesquisar Cliente", JOptionPane.YES_NO_OPTION);

				if (resposta == 0) {

					String nomeVendedor = vendedorController.buscarNomeVendedor(cliente.getId_vendedor());

					tfNovoNomeFantasia.setText(cliente.getNome());
					tfNovoRazaoSocial.setText(cliente.getRazaoSocial());
					tfNovoContato1.setText(cliente.getContato1());
					tfNovoEmail1.setText(cliente.getEmail1().toLowerCase());
					ftfNovoCelular1.setText(cliente.getFoneCelular1());
					ftfNovoFixo1.setText(cliente.getFoneFixo1());
					tfNovoContato2.setText(cliente.getContato2());

					if (cliente.getEmail2() == null) {

						cliente.setEmail2("");

					} else {

						tfNovoEmail2.setText(cliente.getEmail2().toLowerCase());

					}

					ftfNovoCelular2.setText(cliente.getFoneCelular2());
					ftfNovoFixo2.setText(cliente.getFoneFixo2());
					ftfNovoCnpj.setText(cliente.getCnpj());
					tfNovoInscricaoEstadual.setText(cliente.getInscricaoEstadual());
					tfInscricaoMunicipal.setText(cliente.getInscricaoMunicipal());
					cbNovoVendedor.setSelectedItem(nomeVendedor.toUpperCase());
					tfNovoLogradouro.setText(cliente.getLogradouro());
					tfNovoBairro.setText(cliente.getBairro());
					tfNovoCidade.setText(cliente.getCidade());
					ftfNovoCEP.setText(cliente.getCep());
					cbNovoUf.setSelectedItem(cliente.getUf());
					cbNovoEntrega.setSelectedItem(cliente.getEmail1());
					cbNovoUnidade.setSelectedItem(cliente.getUnidade());
					dcNovoClienteDesde.setDate(cliente.getClienteDesde());
					tpNovoObservacoesDoCliente.setText(cliente.getDetalhes());

					tipoSalvarOuEditarCliente = 2;

					btnSalvarCliente.setText("Editar");

					lblCadastroDeCliente.setText("EDITAR CLIENTE");

					cardlayout.show(pnlCliente, "Novo");

				}

			}
		});
		btnEditarDadosCliente.setBounds(57, 418, 122, 23);
		dadosClientePanel.add(btnEditarDadosCliente);

		tfNomeFantasia = new JTextField();
		tfNomeFantasia.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfNomeFantasia.setForeground(Color.BLACK);
		tfNomeFantasia.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfNomeFantasia.setBackground(Color.WHITE);
		tfNomeFantasia.setEditable(false);
		tfNomeFantasia.setDisabledTextColor(Color.WHITE);
		tfNomeFantasia.setBounds(57, 25, 310, 20);
		dadosClientePanel.add(tfNomeFantasia);
		tfNomeFantasia.setColumns(10);

		JLabel lblContato = new JLabel("Contato 2");
		lblContato.setForeground(new Color(0, 0, 205));
		lblContato.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblContato.setBounds(57, 197, 122, 17);
		dadosClientePanel.add(lblContato);

		JLabel lblFoneFixo_1 = new JLabel("Fone Fixo 2");
		lblFoneFixo_1.setForeground(new Color(0, 0, 205));
		lblFoneFixo_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblFoneFixo_1.setBounds(57, 234, 68, 17);
		dadosClientePanel.add(lblFoneFixo_1);

		tfContato2 = new JTextField();
		tfContato2.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfContato2.setForeground(Color.BLACK);
		tfContato2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfContato2.setEditable(false);
		tfContato2.setColumns(10);
		tfContato2.setBackground(Color.WHITE);
		tfContato2.setBounds(57, 213, 346, 20);
		dadosClientePanel.add(tfContato2);

		tfFoneFixo2 = new JTextField();
		tfFoneFixo2.setForeground(Color.BLACK);
		tfFoneFixo2.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfFoneFixo2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfFoneFixo2.setEditable(false);
		tfFoneFixo2.setColumns(10);
		tfFoneFixo2.setBackground(Color.WHITE);
		tfFoneFixo2.setBounds(57, 250, 103, 20);
		dadosClientePanel.add(tfFoneFixo2);

		JLabel lblEmail = new JLabel("E-mail 2");
		lblEmail.setForeground(new Color(0, 0, 205));
		lblEmail.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblEmail.setBounds(171, 234, 44, 17);
		dadosClientePanel.add(lblEmail);

		JLabel lblFoneCelular_1 = new JLabel("Fone Celular 2");
		lblFoneCelular_1.setForeground(new Color(0, 0, 205));
		lblFoneCelular_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblFoneCelular_1.setBounds(413, 197, 74, 17);
		dadosClientePanel.add(lblFoneCelular_1);

		tfEmail2 = new JTextField();
		tfEmail2.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfEmail2.setForeground(Color.BLACK);
		tfEmail2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfEmail2.setEditable(false);
		tfEmail2.setColumns(10);
		tfEmail2.setBackground(Color.WHITE);
		tfEmail2.setBounds(171, 250, 350, 20);
		dadosClientePanel.add(tfEmail2);

		tfFoneCelular2 = new JTextField();
		tfFoneCelular2.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfFoneCelular2.setForeground(Color.BLACK);
		tfFoneCelular2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfFoneCelular2.setEditable(false);
		tfFoneCelular2.setColumns(10);
		tfFoneCelular2.setBackground(Color.WHITE);
		tfFoneCelular2.setBounds(413, 213, 108, 20);
		dadosClientePanel.add(tfFoneCelular2);

		JLabel lblEntrega = new JLabel("Entrega");
		lblEntrega.setBounds(58, 353, 50, 17);
		dadosClientePanel.add(lblEntrega);
		lblEntrega.setForeground(new Color(0, 0, 205));
		lblEntrega.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setBounds(123, 353, 56, 17);
		dadosClientePanel.add(lblUnidade);
		lblUnidade.setForeground(new Color(0, 0, 205));
		lblUnidade.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		JLabel lblDesde = new JLabel("Cliente desde");
		lblDesde.setBounds(413, 45, 74, 17);
		dadosClientePanel.add(lblDesde);
		lblDesde.setForeground(new Color(0, 0, 205));
		lblDesde.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		tfVendedor = new JTextField();
		tfVendedor.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfVendedor.setForeground(Color.BLACK);
		tfVendedor.setBounds(377, 25, 144, 20);
		dadosClientePanel.add(tfVendedor);
		tfVendedor.setEditable(false);
		tfVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfVendedor.setColumns(10);
		tfVendedor.setBackground(Color.WHITE);

		JLabel lblContaEtiq = new JLabel("Conta de");
		lblContaEtiq.setBounds(377, 9, 50, 17);
		dadosClientePanel.add(lblContaEtiq);
		lblContaEtiq.setForeground(new Color(0, 0, 205));
		lblContaEtiq.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		tfClienteDesde = new JTextField();
		tfClienteDesde.setEditable(false);
		tfClienteDesde.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfClienteDesde.setForeground(Color.BLACK);
		tfClienteDesde.setBounds(413, 62, 108, 20);
		dadosClientePanel.add(tfClienteDesde);
		tfClienteDesde.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfClienteDesde.setBackground(Color.WHITE);
		tfClienteDesde.setColumns(10);

		tfUnidade = new JTextField();
		tfUnidade.setEditable(false);
		tfUnidade.setForeground(Color.BLACK);
		tfUnidade.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfUnidade.setBounds(123, 369, 56, 20);
		dadosClientePanel.add(tfUnidade);
		tfUnidade.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfUnidade.setBackground(Color.WHITE);
		tfUnidade.setColumns(10);

		JLabel lblInscrioMunicipal = new JLabel("Inscri\u00E7\u00E3o Municipal");
		lblInscrioMunicipal.setForeground(new Color(0, 0, 205));
		lblInscrioMunicipal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblInscrioMunicipal.setBounds(369, 83, 102, 17);
		dadosClientePanel.add(lblInscrioMunicipal);

		tfInscrMunicipal = new JTextField();
		tfInscrMunicipal.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfInscrMunicipal.setForeground(Color.BLACK);
		tfInscrMunicipal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfInscrMunicipal.setEditable(false);
		tfInscrMunicipal.setColumns(10);
		tfInscrMunicipal.setBackground(Color.WHITE);
		tfInscrMunicipal.setBounds(369, 100, 152, 20);
		dadosClientePanel.add(tfInscrMunicipal);

		tfEntregaDadosCliente = new JTextField();
		tfEntregaDadosCliente.setEditable(false);
		tfEntregaDadosCliente.setForeground(Color.BLACK);
		tfEntregaDadosCliente.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfEntregaDadosCliente.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfEntregaDadosCliente.setColumns(10);
		tfEntregaDadosCliente.setBackground(Color.WHITE);
		tfEntregaDadosCliente.setBounds(57, 369, 56, 20);
		dadosClientePanel.add(tfEntregaDadosCliente);

		tfUfDadosCliente = new JTextField();
		tfUfDadosCliente.setEditable(false);
		tfUfDadosCliente.setForeground(Color.BLACK);
		tfUfDadosCliente.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfUfDadosCliente.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfUfDadosCliente.setColumns(10);
		tfUfDadosCliente.setBackground(Color.WHITE);
		tfUfDadosCliente.setBounds(465, 322, 56, 20);
		dadosClientePanel.add(tfUfDadosCliente);

		JScrollPane spDetalhes = new JScrollPane();
		spDetalhes.setBounds(189, 369, 332, 72);
		dadosClientePanel.add(spDetalhes);
		spDetalhes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spDetalhes.setBorder(new LineBorder(new Color(0, 0, 205)));

		tpDetalhes = new JTextPane();
		tpDetalhes.setEditable(false);
		tpDetalhes.setLocation(274, 0);
		spDetalhes.setViewportView(tpDetalhes);
		tpDetalhes.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tpDetalhes.setForeground(Color.RED);

		JLabel lblDetalhes = new JLabel("Observa\u00E7\u00F5es do cliente");
		lblDetalhes.setBounds(189, 353, 269, 17);
		dadosClientePanel.add(lblDetalhes);
		lblDetalhes.setForeground(new Color(0, 0, 205));
		lblDetalhes.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		lancamentoPedidoPanel = new JPanel();
		lancamentoPedidoPanel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnLancamento);
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnSelecionar);
				
			}
		});
		lancamentoPedidoPanel.setBackground(Color.WHITE);
		lancamentoPedidoPanel.setForeground(new Color(0, 0, 205));
		lancamentoPedidoPanel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lancamentoPedidoPanel.setBorder(new LineBorder(new Color(0, 0, 205)));
		pnlCliente.add(lancamentoPedidoPanel, "Lançamento");
		lancamentoPedidoPanel.setLayout(null);

		lblSaldo = new JLabel("LAN\u00C7AMENTO");
		lblSaldo.setForeground(new Color(0, 0, 205));
		lblSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSaldo.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblSaldo.setBounds(13, 0, 994, 30);
		lancamentoPedidoPanel.add(lblSaldo);

		tfQuantidadeDoPedido = new JTextField();
		tfQuantidadeDoPedido.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfQuantidadeDoPedido.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfQuantidadeDoPedido.setBounds(461, 216, 85, 22);
		lancamentoPedidoPanel.add(tfQuantidadeDoPedido);
		tfQuantidadeDoPedido.setColumns(10);

		tfQuantidadeDoPedido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {

				String caracteres = "0987654321,.-+";

				if (!caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}

			}

		});
		tfQuantidadeDoPedido.setDocument(TamanhoMax4);

		JLabel lblQuantidadeDoPedido = new JLabel("Quantidade");
		lblQuantidadeDoPedido.setForeground(new Color(0, 0, 205));
		lblQuantidadeDoPedido.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblQuantidadeDoPedido.setBounds(461, 199, 85, 14);
		lancamentoPedidoPanel.add(lblQuantidadeDoPedido);

		btnLancamento = new JButton("Lan\u00E7amento");
		btnLancamento.setMnemonic('l');
		btnLancamento.setToolTipText("Fazer Lan\u00E7amento");
		btnLancamento.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnLancamento.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLancamento.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnLancamento.setContentAreaFilled(false);
		btnLancamento.setBorder(null);
		btnLancamento.setForeground(Color.WHITE);
		btnLancamento.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnLancamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tfQuantidadeDoPedido.getText() == null || tfQuantidadeDoPedido.getText().trim().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite a quantidade do pedido", "Campo Obrigatório",
							JOptionPane.INFORMATION_MESSAGE);
					tfQuantidadeDoPedido.requestFocus();

				} else if (dcDataDoLancamento.getDate() == null) {

					JOptionPane.showMessageDialog(null, "Selecione a data de lançamento", "Campo Obrigatório",
							JOptionPane.INFORMATION_MESSAGE);
					dcDataDoLancamento.requestFocus();

				} else if (cbTransacaoLancamento.getSelectedItem().equals("SELECIONE...")) {

					JOptionPane.showMessageDialog(null, "Selecione o tipo do lançamento", "Campo Obrigatório",
							JOptionPane.INFORMATION_MESSAGE);
					cbTransacaoLancamento.requestFocus();

				} else {

					int transacao = 0;

					if (cbTransacaoLancamento.getSelectedIndex() == 1) {

						transacao = Integer.valueOf(clienteServico.getSaldoServico())
								+ Integer.valueOf(tfQuantidadeDoPedido.getText());

						
							try {
								fazerLancamento(transacao);
							} catch (EmailException e) {
								
								e.printStackTrace();
							}
						
						
					} else if (cbTransacaoLancamento.getSelectedIndex() == 2) {

						transacao = Integer.valueOf(clienteServico.getSaldoServico())
								- Integer.valueOf(tfQuantidadeDoPedido.getText());

						try {
							fazerLancamento(transacao);
						} catch (EmailException e) {
							
							e.printStackTrace();
						}

					} else if (cbTransacaoLancamento.getSelectedIndex() == 3) {

						if (tfObservacoesLancamento.getText() == null
								|| tfObservacoesLancamento.getText().trim().equals("")) {

							JOptionPane.showMessageDialog(null, "Digite as observações da correção", "Correção Entrada",
									JOptionPane.INFORMATION_MESSAGE);

							cbTransacaoLancamento.requestFocus();

						} else {

							transacao = Integer.valueOf(clienteServico.getSaldoServico())
									- Integer.valueOf(tfQuantidadeDoPedido.getText());

							try {
								fazerLancamento(transacao);
							} catch (EmailException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}

					} else if (cbTransacaoLancamento.getSelectedIndex() == 4) {

						if (tfObservacoesLancamento.getText() == null
								|| tfObservacoesLancamento.getText().trim().equals("")) {

							JOptionPane.showMessageDialog(null, "Digite as observações da correção", "Correção Entrada",
									JOptionPane.INFORMATION_MESSAGE);

							cbTransacaoLancamento.requestFocus();

						} else {

							transacao = Integer.valueOf(clienteServico.getSaldoServico())
									+ Integer.valueOf(tfQuantidadeDoPedido.getText());

							try {
								fazerLancamento(transacao);
							} catch (EmailException e) {
								
								e.printStackTrace();
							}
						}

					}

				}
				
				ClienteServicoController clienteServicoController = new ClienteServicoController();
				listaClienteServico = clienteServicoController.listaServicoCliente(cliente.getId_cliente());
				
			}
		});
		btnLancamento.setBounds(454, 368, 111, 23);
		lancamentoPedidoPanel.add(btnLancamento);
		
		JLabel lblObservacoesLancamento = new JLabel("Observa\u00E7\u00F5es");
		lblObservacoesLancamento.setForeground(new Color(0, 0, 205));
		lblObservacoesLancamento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblObservacoesLancamento.setBounds(313, 299, 399, 14);
		lancamentoPedidoPanel.add(lblObservacoesLancamento);

		tfObservacoesLancamento = new JTextField();
		tfObservacoesLancamento.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfObservacoesLancamento.setForeground(Color.BLACK);
		tfObservacoesLancamento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfObservacoesLancamento.setColumns(10);
		tfObservacoesLancamento.setBounds(313, 316, 393, 22);
		lancamentoPedidoPanel.add(tfObservacoesLancamento);

		JButton btnCancelarLancamento = new JButton("Cancelar");
		btnCancelarLancamento.setMnemonic('c');
		btnCancelarLancamento.setToolTipText("Cancelar");
		btnCancelarLancamento
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnCancelarLancamento.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelarLancamento.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnCancelarLancamento.setContentAreaFilled(false);
		btnCancelarLancamento.setBorder(null);
		btnCancelarLancamento.setForeground(Color.WHITE);
		btnCancelarLancamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cardlayout.show(pnlCliente, "Dados");

			}
		});
		btnCancelarLancamento.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnCancelarLancamento.setBounds(604, 368, 101, 23);
		lancamentoPedidoPanel.add(btnCancelarLancamento);

		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente");
		lblNomeDoCliente.setForeground(new Color(0, 0, 205));
		lblNomeDoCliente.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNomeDoCliente.setBounds(313, 55, 394, 14);
		lancamentoPedidoPanel.add(lblNomeDoCliente);

		JLabel lblServico = new JLabel("Servi\u00E7o");
		lblServico.setForeground(new Color(0, 0, 205));
		lblServico.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblServico.setBounds(314, 101, 392, 14);
		lancamentoPedidoPanel.add(lblServico);

		JLabel lblSaldoAtualLancamento = new JLabel("Saldo");
		lblSaldoAtualLancamento.setForeground(new Color(0, 0, 205));
		lblSaldoAtualLancamento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblSaldoAtualLancamento.setBounds(313, 199, 85, 14);
		lancamentoPedidoPanel.add(lblSaldoAtualLancamento);

		JLabel lblCnpjLancamento = new JLabel("CNPJ Lan\u00E7amento");
		lblCnpjLancamento.setForeground(new Color(0, 0, 205));
		lblCnpjLancamento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblCnpjLancamento.setBounds(556, 147, 150, 14);
		lancamentoPedidoPanel.add(lblCnpjLancamento);

		JLabel lblDataDoLancamento = new JLabel("Data Lan\u00E7amento");
		lblDataDoLancamento.setForeground(new Color(0, 0, 205));
		lblDataDoLancamento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblDataDoLancamento.setBounds(610, 199, 95, 14);
		lancamentoPedidoPanel.add(lblDataDoLancamento);

		dcDataDoLancamento = new JDateChooser();
		dcDataDoLancamento.setForeground(new Color(0, 0, 205));
		dcDataDoLancamento.setBorder(new LineBorder(new Color(0, 0, 205)));
		dcDataDoLancamento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		dcDataDoLancamento.setBounds(609, 216, 95, 22);
		lancamentoPedidoPanel.add(dcDataDoLancamento);

		tfNomeClienteLancamento = new JTextField();
		tfNomeClienteLancamento.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfNomeClienteLancamento.setBackground(Color.WHITE);
		tfNomeClienteLancamento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfNomeClienteLancamento.setEditable(false);
		tfNomeClienteLancamento.setBounds(313, 72, 393, 22);
		lancamentoPedidoPanel.add(tfNomeClienteLancamento);
		tfNomeClienteLancamento.setColumns(10);

		tfServicoLancamento = new JTextField();
		tfServicoLancamento.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfServicoLancamento.setBackground(Color.WHITE);
		tfServicoLancamento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfServicoLancamento.setEditable(false);
		tfServicoLancamento.setColumns(10);
		tfServicoLancamento.setBounds(314, 117, 392, 22);
		lancamentoPedidoPanel.add(tfServicoLancamento);

		tfSaldoAtualLancamento = new JTextField();
		tfSaldoAtualLancamento.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfSaldoAtualLancamento.setBackground(Color.WHITE);
		tfSaldoAtualLancamento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfSaldoAtualLancamento.setEditable(false);
		tfSaldoAtualLancamento.setColumns(10);
		tfSaldoAtualLancamento.setBounds(313, 216, 85, 22);
		lancamentoPedidoPanel.add(tfSaldoAtualLancamento);

		tfSaldoAtualLancamento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {

				String caracteres = "0987654321,.-+";

				if (!caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}

			}

		});
		tfSaldoAtualLancamento.setDocument(TamanhoMax3);

		tfCnpjLancamento = new JTextField();
		tfCnpjLancamento.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfCnpjLancamento.setBackground(Color.WHITE);
		tfCnpjLancamento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfCnpjLancamento.setEditable(false);
		tfCnpjLancamento.setColumns(10);
		tfCnpjLancamento.setBounds(556, 164, 150, 22);
		lancamentoPedidoPanel.add(tfCnpjLancamento);

		cbTransacaoLancamento = new JComboBox<String>();
		cbTransacaoLancamento.setBorder(new LineBorder(new Color(0, 0, 205)));
		cbTransacaoLancamento.setForeground(Color.BLACK);
		cbTransacaoLancamento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		cbTransacaoLancamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cbTransacaoLancamento.getSelectedIndex() != 0) {

					int operacao = cbTransacaoLancamento.getSelectedIndex();

					switch (operacao) {
					case 1:

						ObservacoesLancamento = "(+) " + "ENTRADA (CRÉDITO)";

						break;

					case 2:

						ObservacoesLancamento = "(-) " + "SAÍDA (DÉBITO)";

						break;

					case 3:

						ObservacoesLancamento = "(-) " + "CORREÇÃO ENTRADA (DÉBITO)";

						break;

					case 4:

						ObservacoesLancamento = "(+) " + "CORREÇÃO SAÍDA (CRÉDITO)";

						break;

					default:
						break;
					}

				} else {

					tfObservacoesLancamento.setText("");

				}

			}
		});
		getContentPane().setLayout(null);
		cbTransacaoLancamento.setModel(new DefaultComboBoxModel<String>(
				new String[] { "SELECIONE...", "ENTRADA (CR\u00C9DITO)", "SA\u00CDDA (D\u00C9BITO)",
						"CORRE\u00C7\u00C3O ENTRADA (D\u00C9BITO)", "CORRE\u00C7\u00C3O SA\u00CDDA (CR\u00C9DITO)" }));
		cbTransacaoLancamento.setBounds(314, 266, 392, 22);
		lancamentoPedidoPanel.add(cbTransacaoLancamento);

		JLabel lblTipoLanamento = new JLabel("Tipo do Lan\u00E7amento");
		lblTipoLanamento.setForeground(new Color(0, 0, 205));
		lblTipoLanamento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblTipoLanamento.setBounds(313, 247, 393, 14);
		lancamentoPedidoPanel.add(lblTipoLanamento);

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setForeground(new Color(0, 0, 205));
		lblProduto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblProduto.setBounds(313, 147, 233, 14);
		lancamentoPedidoPanel.add(lblProduto);

		tfProdutoDoServico = new JTextField();
		tfProdutoDoServico.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfProdutoDoServico.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfProdutoDoServico.setEditable(false);
		tfProdutoDoServico.setColumns(10);
		tfProdutoDoServico.setBackground(Color.WHITE);
		tfProdutoDoServico.setBounds(313, 164, 233, 22);
		lancamentoPedidoPanel.add(tfProdutoDoServico);
		getContentPane().add(pnlCliente);

		cadastroClientePanel = new JPanel();
		cadastroClientePanel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnSalvarCliente);
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnSelecionar);
				
			}
		});
		cadastroClientePanel.setBackground(Color.WHITE);
		cadastroClientePanel.setForeground(new Color(0, 0, 205));
		cadastroClientePanel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		cadastroClientePanel.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		pnlCliente.add(cadastroClientePanel, "Novo");
		cadastroClientePanel.setLayout(null);

		JLabel lblNovoCep = new JLabel("CEP");
		lblNovoCep.setForeground(new Color(0, 0, 205));
		lblNovoCep.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoCep.setBounds(465, 294, 95, 17);
		cadastroClientePanel.add(lblNovoCep);

		JLabel lblNovoUF = new JLabel("UF");
		lblNovoUF.setForeground(new Color(0, 0, 205));
		lblNovoUF.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoUF.setBounds(571, 294, 52, 17);
		cadastroClientePanel.add(lblNovoUF);

		JLabel lblNovoBairro = new JLabel("Bairro");
		lblNovoBairro.setForeground(new Color(0, 0, 205));
		lblNovoBairro.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoBairro.setBounds(571, 242, 95, 17);
		cadastroClientePanel.add(lblNovoBairro);

		JLabel lblNovoCidade = new JLabel("Cidade");
		lblNovoCidade.setForeground(new Color(0, 0, 205));
		lblNovoCidade.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoCidade.setBounds(143, 293, 95, 17);
		cadastroClientePanel.add(lblNovoCidade);

		JLabel lblNovoLogradouro = new JLabel("Rua / Avenida");
		lblNovoLogradouro.setForeground(new Color(0, 0, 205));
		lblNovoLogradouro.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoLogradouro.setBounds(143, 242, 95, 17);
		cadastroClientePanel.add(lblNovoLogradouro);

		JLabel lblNovoCnpj = new JLabel("CNPJ");
		lblNovoCnpj.setForeground(new Color(0, 0, 205));
		lblNovoCnpj.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoCnpj.setBounds(143, 191, 95, 17);
		cadastroClientePanel.add(lblNovoCnpj);

		JLabel lblNovoInscricaoEstadual = new JLabel("Inscri\u00E7\u00E3o Estadual");
		lblNovoInscricaoEstadual.setForeground(new Color(0, 0, 205));
		lblNovoInscricaoEstadual.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoInscricaoEstadual.setBounds(319, 191, 95, 17);
		cadastroClientePanel.add(lblNovoInscricaoEstadual);

		JLabel lblNovoContato1 = new JLabel("Contato 1");
		lblNovoContato1.setForeground(new Color(0, 0, 205));
		lblNovoContato1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoContato1.setBounds(143, 87, 95, 17);
		cadastroClientePanel.add(lblNovoContato1);

		JLabel lblNovoRazoSocial = new JLabel("Raz\u00E3o Social");
		lblNovoRazoSocial.setForeground(new Color(0, 0, 205));
		lblNovoRazoSocial.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoRazoSocial.setBounds(517, 37, 95, 17);
		cadastroClientePanel.add(lblNovoRazoSocial);

		JLabel lblNovoNomeFantasia = new JLabel("Nome Fantasia");
		lblNovoNomeFantasia.setForeground(new Color(0, 0, 205));
		lblNovoNomeFantasia.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoNomeFantasia.setBounds(143, 37, 95, 17);
		cadastroClientePanel.add(lblNovoNomeFantasia);

		tfNovoNomeFantasia = new JTextField();
		tfNovoNomeFantasia.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfNovoNomeFantasia.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfNovoNomeFantasia.setColumns(10);
		tfNovoNomeFantasia.setBackground(Color.WHITE);
		tfNovoNomeFantasia.setBounds(143, 58, 364, 21);
		cadastroClientePanel.add(tfNovoNomeFantasia);

		JLabel lblNovoFone1 = new JLabel("Fone Celular 1");
		lblNovoFone1.setForeground(new Color(0, 0, 205));
		lblNovoFone1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoFone1.setBounds(635, 87, 95, 17);
		cadastroClientePanel.add(lblNovoFone1);

		JLabel lblNovoFone2 = new JLabel("Fone Fixo 1");
		lblNovoFone2.setForeground(new Color(0, 0, 205));
		lblNovoFone2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoFone2.setBounds(764, 87, 95, 17);
		cadastroClientePanel.add(lblNovoFone2);

		tfNovoRazaoSocial = new JTextField();
		tfNovoRazaoSocial.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfNovoRazaoSocial.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfNovoRazaoSocial.setColumns(10);
		tfNovoRazaoSocial.setBackground(Color.WHITE);
		tfNovoRazaoSocial.setBounds(517, 58, 364, 21);
		cadastroClientePanel.add(tfNovoRazaoSocial);

		tfNovoContato1 = new JTextField();
		tfNovoContato1.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfNovoContato1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfNovoContato1.setColumns(10);
		tfNovoContato1.setBackground(Color.WHITE);
		tfNovoContato1.setBounds(143, 108, 225, 21);
		cadastroClientePanel.add(tfNovoContato1);

		tfNovoInscricaoEstadual = new JTextField();
		tfNovoInscricaoEstadual.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfNovoInscricaoEstadual.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfNovoInscricaoEstadual.setColumns(10);
		tfNovoInscricaoEstadual.setBackground(Color.WHITE);
		tfNovoInscricaoEstadual.setBounds(319, 210, 167, 21);
		cadastroClientePanel.add(tfNovoInscricaoEstadual);

		tfNovoLogradouro = new JTextField();
		tfNovoLogradouro.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfNovoLogradouro.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfNovoLogradouro.setColumns(10);
		tfNovoLogradouro.setBackground(new Color(255, 255, 255));
		tfNovoLogradouro.setBounds(143, 261, 418, 21);
		cadastroClientePanel.add(tfNovoLogradouro);

		tfNovoBairro = new JTextField();
		tfNovoBairro.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfNovoBairro.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfNovoBairro.setColumns(10);
		tfNovoBairro.setBackground(Color.WHITE);
		tfNovoBairro.setBounds(571, 261, 310, 21);
		cadastroClientePanel.add(tfNovoBairro);

		tfNovoCidade = new JTextField();
		tfNovoCidade.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfNovoCidade.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfNovoCidade.setColumns(10);
		tfNovoCidade.setBackground(Color.WHITE);
		tfNovoCidade.setBounds(143, 314, 312, 21);
		cadastroClientePanel.add(tfNovoCidade);

		cbNovoUf = new JComboBox<String>();
		cbNovoUf.setForeground(Color.BLACK);
		cbNovoUf.setBorder(new LineBorder(new Color(0, 0, 205)));
		cbNovoUf.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		cbNovoUf.setModel(new DefaultComboBoxModel<String>(
				new String[] { "UF", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cbNovoUf.setBounds(571, 315, 52, 20);
		cadastroClientePanel.add(cbNovoUf);

		JLabel lblNovoVendedor = new JLabel("Vendedor");
		lblNovoVendedor.setForeground(new Color(0, 0, 205));
		lblNovoVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoVendedor.setBounds(699, 191, 95, 17);
		cadastroClientePanel.add(lblNovoVendedor);

		cbNovoVendedor = new JComboBox<String>();
		cbNovoVendedor.setBorder(new LineBorder(new Color(0, 0, 205)));
		cbNovoVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		cbNovoVendedor.setBounds(699, 210, 182, 21);
		cadastroClientePanel.add(cbNovoVendedor);

		listaVendedores = vendedorController.listaVendedor();

		cbNovoVendedor.addItem("SELECIONE...");

		for (Vendedor v : listaVendedores) {

			cbNovoVendedor.addItem(v.getNome());

		}

		JLabel lblNovoEmail1 = new JLabel("Email 1");
		lblNovoEmail1.setForeground(new Color(0, 0, 205));
		lblNovoEmail1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoEmail1.setBounds(378, 88, 235, 17);
		cadastroClientePanel.add(lblNovoEmail1);

		tfNovoEmail1 = new JTextField();
		tfNovoEmail1.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfNovoEmail1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfNovoEmail1.setColumns(10);
		tfNovoEmail1.setBackground(Color.WHITE);
		tfNovoEmail1.setBounds(378, 108, 247, 21);
		cadastroClientePanel.add(tfNovoEmail1);

		JLabel lblNovoObservacoesDoCliente = new JLabel("Observa\u00E7\u00F5es do Cliente");
		lblNovoObservacoesDoCliente.setForeground(new Color(0, 0, 205));
		lblNovoObservacoesDoCliente.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoObservacoesDoCliente.setBounds(143, 346, 473, 17);
		cadastroClientePanel.add(lblNovoObservacoesDoCliente);

		JScrollPane spObservacoesDoCliente = new JScrollPane();
		spObservacoesDoCliente.setForeground(Color.RED);
		spObservacoesDoCliente.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		spObservacoesDoCliente.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spObservacoesDoCliente.setBorder(new LineBorder(new Color(0, 0, 205)));
		spObservacoesDoCliente.setBounds(143, 368, 486, 58);
		cadastroClientePanel.add(spObservacoesDoCliente);

		tpNovoObservacoesDoCliente = new JTextPane();
		spObservacoesDoCliente.setViewportView(tpNovoObservacoesDoCliente);
		tpNovoObservacoesDoCliente.setForeground(Color.RED);
		tpNovoObservacoesDoCliente.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));

		JLabel lblNovoEntrega = new JLabel("Entrega");
		lblNovoEntrega.setForeground(new Color(0, 0, 205));
		lblNovoEntrega.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoEntrega.setBounds(632, 294, 52, 17);
		cadastroClientePanel.add(lblNovoEntrega);

		cbNovoEntrega = new JComboBox<String>();
		cbNovoEntrega.setForeground(Color.BLACK);
		cbNovoEntrega.setBorder(new LineBorder(new Color(0, 0, 205)));
		cbNovoEntrega.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		cbNovoEntrega.setModel(new DefaultComboBoxModel<String>(new String[] { "N\u00C3O", "SIM" }));
		cbNovoEntrega.setBounds(632, 315, 52, 20);
		cadastroClientePanel.add(cbNovoEntrega);

		cbNovoUnidade = new JComboBox<String>();
		cbNovoUnidade.setForeground(Color.BLACK);
		cbNovoUnidade.setBorder(new LineBorder(new Color(0, 0, 205)));
		cbNovoUnidade.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		cbNovoUnidade.setModel(new DefaultComboBoxModel<String>(new String[] { "PE", "JP", "OUTRAS" }));
		cbNovoUnidade.setBounds(694, 314, 75, 20);
		cadastroClientePanel.add(cbNovoUnidade);

		JLabel lblNovoUnidade = new JLabel("Unidade");
		lblNovoUnidade.setForeground(new Color(0, 0, 205));
		lblNovoUnidade.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoUnidade.setBounds(694, 293, 52, 17);
		cadastroClientePanel.add(lblNovoUnidade);

		btnSalvarCliente = new JButton("Salvar");
		btnSalvarCliente.setToolTipText("Salvar Cliente");
		btnSalvarCliente.setMnemonic('s');
		btnSalvarCliente.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnSalvarCliente.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnSalvarCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalvarCliente.setForeground(Color.WHITE);
		btnSalvarCliente.setContentAreaFilled(false);
		btnSalvarCliente.setBorder(null);
		btnSalvarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tfNovoNomeFantasia.getText() == null || tfNovoNomeFantasia.getText().trim().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite o nome fantasia", "Novo cliente",
							JOptionPane.INFORMATION_MESSAGE);
					tfNovoNomeFantasia.requestFocus();

				} else if (tfNovoRazaoSocial.getText() == null || tfNovoRazaoSocial.getText().trim().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite a razão social", "Novo cliente",
							JOptionPane.INFORMATION_MESSAGE);
					tfNovoRazaoSocial.requestFocus();

				} else if (tfNovoContato1.getText() == null || tfNovoContato1.getText().trim().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite o contato", "Novo cliente",
							JOptionPane.INFORMATION_MESSAGE);
					tfNovoContato1.requestFocus();
					
			} else if (ftfNovoCnpj.getText().equals("  .   .   /    -  ")) {

					JOptionPane.showMessageDialog(null, "Digite o CNPJ", "Novo cliente",
							JOptionPane.INFORMATION_MESSAGE);
					ftfNovoCnpj.requestFocus();

				} else if (cbNovoVendedor.getSelectedItem().equals("SELECIONE...")) {

					JOptionPane.showMessageDialog(null, "Selecione o Vendedor!");
					cbNovoVendedor.requestFocus();

				} else if (tfNovoLogradouro.getText() == null || tfNovoLogradouro.getText().trim().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite o nome da rua ou avenida", "Novo cliente",
							JOptionPane.INFORMATION_MESSAGE);
					tfNovoLogradouro.requestFocus();

				} else if (tfNovoBairro.getText() == null || tfNovoBairro.getText().trim().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite o nome do bairro", "Novo cliente",
							JOptionPane.INFORMATION_MESSAGE);
					tfNovoBairro.requestFocus();

				} else if (tfNovoBairro.getText() == null || tfNovoBairro.getText().trim().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite o nome do bairro", "Novo cliente",
							JOptionPane.INFORMATION_MESSAGE);
					tfNovoBairro.requestFocus();

				} else if (tfNovoCidade.getText() == null || tfNovoCidade.getText().trim().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite o nome da cidade", "Novo cliente",
							JOptionPane.INFORMATION_MESSAGE);
					tfNovoCidade.requestFocus();

				} else if (ftfNovoCEP.getText().equals("     -   ")) {

					JOptionPane.showMessageDialog(null, "Digite o CEP", "Novo cliente",
							JOptionPane.INFORMATION_MESSAGE);
					ftfNovoCEP.requestFocus();

				} else if (cbNovoUf.getSelectedItem().equals("UF")) {

					JOptionPane.showMessageDialog(null, "Selecione a Unidade Federal!");
					cbNovoUf.requestFocus();

				} else if (dcNovoClienteDesde.getDate() == null) {

					JOptionPane.showMessageDialog(null, "Preencha o Cliente Desde!");
					dcNovoClienteDesde.requestFocus();

				} else {

					int resposta = JOptionPane.showConfirmDialog(null, "Deseja salvar / editar o cliente?",
							"Novo cliente", JOptionPane.YES_OPTION);

					if (resposta == JOptionPane.YES_OPTION) {

						if (tipoSalvarOuEditarCliente == 0) {

							boolean sucesso = false;

							java.sql.Date DataSql = null;

							Cliente clienteTemp = new Cliente();

							boolean entrega = false;

							if (cbNovoEntrega.getSelectedItem().equals("SIM")) {

								entrega = true;

							} else {

								entrega = false;

							}

							if (dcNovoClienteDesde.getDate() == null) {

								DataSql = null;

							} else {

								java.util.Date dataUtil = dcNovoClienteDesde.getDate();
								DataSql = new java.sql.Date(dataUtil.getTime());

							}

							VendedorController vendedorController = new VendedorController();
							int id_vendedor = vendedorController
									.buscarIdVendedor(String.valueOf(cbNovoVendedor.getSelectedItem()).toUpperCase());

							clienteTemp.setNome(tfNovoNomeFantasia.getText().toUpperCase());
							clienteTemp.setId_vendedor(id_vendedor);
							clienteTemp.setClienteDesde(DataSql);
							clienteTemp.setEntrega(entrega);
							clienteTemp.setDetalhes(tpNovoObservacoesDoCliente.getText().toUpperCase());
							clienteTemp.setUnidade(String.valueOf(cbNovoUnidade.getSelectedItem()).toUpperCase());
							clienteTemp.setRazaoSocial(tfNovoRazaoSocial.getText().toUpperCase());
							clienteTemp.setContato1(tfNovoContato1.getText().toUpperCase());
							clienteTemp.setFoneCelular1(ftfNovoCelular1.getText().toUpperCase());
							clienteTemp.setFoneFixo1(ftfNovoFixo1.getText().toUpperCase());
							clienteTemp.setEmail1(tfNovoEmail1.getText().toLowerCase());
							clienteTemp.setContato2(tfNovoContato2.getText().toUpperCase());
							clienteTemp.setFoneCelular2(ftfNovoCelular2.getText().toUpperCase());
							clienteTemp.setFoneFixo2(ftfNovoFixo2.getText().toUpperCase());
							clienteTemp.setEmail2(tfNovoEmail2.getText().toLowerCase());
							clienteTemp.setCnpj(ftfNovoCnpj.getText().toUpperCase());
							clienteTemp.setInscricaoEstadual(tfNovoInscricaoEstadual.getText().toUpperCase());
							clienteTemp.setInscricaoMunicipal(tfInscricaoMunicipal.getText().toUpperCase());
							clienteTemp.setLogradouro(tfNovoLogradouro.getText().toUpperCase());
							clienteTemp.setCidade(tfNovoCidade.getText().toUpperCase());
							clienteTemp.setBairro(tfNovoBairro.getText().toUpperCase());
							clienteTemp.setCep(ftfNovoCEP.getText().toUpperCase());
							clienteTemp.setUf(String.valueOf(cbNovoUf.getSelectedItem()));

							ClienteController clienteController = new ClienteController();
							try {
								sucesso = clienteController.novoCliente(clienteTemp);
							} catch (FileNotFoundException e1) {
								
								e1.printStackTrace();
							}

							if (sucesso) {

								LogSegurancaController.novoLogSeguranca("NOVO CLIENTE");

								JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso", "Novo cliente",
										JOptionPane.INFORMATION_MESSAGE);

								try {
									cliente = clienteController.mostrarClienteNome(clienteTemp.getNome());
								} catch (FileNotFoundException e1) {
									
									e1.printStackTrace();
								}

								if (cliente.isEntrega() == true) {

									tfEntregaDadosCliente.setText("SIM");

								} else {

									tfEntregaDadosCliente.setText("NÃO");

								}

								limparPanelNovoCliente();

								tipoSalvarOuEditarCliente = 0;

								lblCadastroDeCliente.setText("CADASTRO DE CLIENTE");

								// ATUALIZAR

								try {
									atualizarCliente();
								} catch (FileNotFoundException e2) {
									
									e2.printStackTrace();
								}

								String etiqueta;

								if (LoginComercialView.getVendedor().getAcesso().equalsIgnoreCase("GERENCIAL")
										|| LoginComercialView.getVendedor().getAcesso().equalsIgnoreCase("COMERCIAL")
												&& LoginComercialView.getVendedor().getCargo()
														.equalsIgnoreCase("COORDENADOR DE VENDAS")) {

									etiqueta = " da empresa";
									etiqueta = " da empresa";
									try {
										LoginComercialView.listaCliente = clienteController.listarClientes();
									} catch (FileNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

								} else {

									etiqueta = " do vendedor";
									try {
										LoginComercialView.listaCliente = clienteController
												.listarClientesPorVendedor(vendedor.getId_vendedor());
									} catch (FileNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

								}

								NumberFormat tresDigitos = new DecimalFormat("000");
								getTfTotalDeClientes()
										.setText(tresDigitos.format(LoginComercialView.listaCliente.size()) + etiqueta);

								cardlayout.show(pnlCliente, "Inicial");

							} else {

								LogSegurancaController.novoLogSeguranca("ERRO AO SALVAR CLIENTE");

								JOptionPane.showMessageDialog(null, "Erro ao salvar o cliente!");

								limparPanelNovoCliente();

								tipoSalvarOuEditarCliente = 0;

								lblCadastroDeCliente.setText("CADASTRO DE CLIENTE");

								cardlayout.show(pnlCliente, "Inicial");

							}

						} else {

							boolean sucesso = false;

							java.sql.Date DataSql = null;

							Cliente clienteTemp = new Cliente();

							boolean entrega = false;

							if (cbNovoEntrega.getSelectedItem().equals("SIM")) {

								entrega = true;

							} else {

								entrega = false;

							}

							if (dcNovoClienteDesde.getDate() == null) {

								DataSql = null;

							} else {

								java.util.Date dataUtil = dcNovoClienteDesde.getDate();
								DataSql = new java.sql.Date(dataUtil.getTime());

							}

							VendedorController vendedorController = new VendedorController();
							int id_vendedor = vendedorController
									.buscarIdVendedor(String.valueOf(cbNovoVendedor.getSelectedItem()).toUpperCase());

							clienteTemp.setId_cliente(cliente.getId_cliente());
							clienteTemp.setNome(tfNovoNomeFantasia.getText().toUpperCase());
							clienteTemp.setId_vendedor(id_vendedor);
							clienteTemp.setClienteDesde(DataSql);
							clienteTemp.setEntrega(entrega);
							clienteTemp.setDetalhes(tpNovoObservacoesDoCliente.getText().toUpperCase());
							clienteTemp.setUnidade(String.valueOf(cbNovoUnidade.getSelectedItem()).toUpperCase());
							clienteTemp.setRazaoSocial(tfNovoRazaoSocial.getText().toUpperCase());
							clienteTemp.setContato1(tfNovoContato1.getText().toUpperCase());
							clienteTemp.setFoneCelular1(ftfNovoCelular1.getText().toUpperCase());
							clienteTemp.setFoneFixo1(ftfNovoFixo1.getText().toUpperCase());
							clienteTemp.setEmail1(tfNovoEmail1.getText().toLowerCase());
							clienteTemp.setContato2(tfNovoContato2.getText().toUpperCase());
							clienteTemp.setFoneCelular2(ftfNovoCelular2.getText().toUpperCase());
							clienteTemp.setFoneFixo2(ftfNovoFixo2.getText().toUpperCase());
							clienteTemp.setEmail2(tfNovoEmail2.getText().toLowerCase());
							clienteTemp.setCnpj(ftfNovoCnpj.getText().toUpperCase());
							clienteTemp.setInscricaoEstadual(tfNovoInscricaoEstadual.getText().toUpperCase());
							clienteTemp.setInscricaoMunicipal(tfInscricaoMunicipal.getText().toUpperCase());
							clienteTemp.setLogradouro(tfNovoLogradouro.getText().toUpperCase());
							clienteTemp.setCidade(tfNovoCidade.getText().toUpperCase());
							clienteTemp.setBairro(tfNovoBairro.getText().toUpperCase());
							clienteTemp.setCep(ftfNovoCEP.getText().toUpperCase());
							clienteTemp.setUf(String.valueOf(cbNovoUf.getSelectedItem()));

							// teste(clienteTemp);

							if (cliente.toString().equals(clienteTemp.toString())) {

								JOptionPane.showMessageDialog(null, "Não houve edição no cliente!", "Editar cliente",
										JOptionPane.INFORMATION_MESSAGE);

								lblCadastroDeCliente.setText("CADASTRO DE CLIENTE");

								if (tipoSalvarOuEditarCliente == 1) {

									cardlayout.show(pnlCliente, "Inicial");

								} else if (tipoSalvarOuEditarCliente == 2) {

									atualizarDadosCliente();

									cardlayout.show(pnlCliente, "Dados");

								}

								btnSalvarCliente.setText("Salvar");

								tipoSalvarOuEditarCliente = 0;

								limparNovoCliente();

							} else {

								ClienteController clienteController = new ClienteController();
								try {
									sucesso = clienteController.editarClienteCompleto(clienteTemp);
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

								if (sucesso) {

									LogSegurancaController.novoLogSeguranca("CLIENTE EDITADO");

									JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!");

									try {
										cliente = clienteController.mostrarClienteNome(clienteTemp.getNome());
									} catch (FileNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

									limparPanelNovoCliente();

									lblCadastroDeCliente.setText("CADASTRO DE CLIENTE");

									// ATUALIZAR

									btnSalvarCliente.setText("Salvar");

									try {
										atualizarCliente();
									} catch (FileNotFoundException e2) {
										// TODO Auto-generated catch block
										e2.printStackTrace();
									}

									if (tipoSalvarOuEditarCliente == 1) {

										cardlayout.show(pnlCliente, "Inicial");

									} else if (tipoSalvarOuEditarCliente == 2) {

										atualizarDadosCliente();

										cardlayout.show(pnlCliente, "Dados");

									}

									tipoSalvarOuEditarCliente = 0;

									String etiqueta;

									if (LoginComercialView.getVendedor().getAcesso().equalsIgnoreCase("GERENCIAL")
											|| LoginComercialView.getVendedor().getAcesso()
													.equalsIgnoreCase("COMERCIAL")
													&& LoginComercialView.getVendedor().getCargo()
															.equalsIgnoreCase("COORDENADOR DE VENDAS")) {

										etiqueta = " da empresa";
										try {
											LoginComercialView.listaCliente = clienteController.listarClientes();
										} catch (FileNotFoundException e1) {
											
											e1.printStackTrace();
										}

									} else {

										etiqueta = " do vendedor";
										try {
											LoginComercialView.listaCliente = clienteController
													.listarClientesPorVendedor(
															LoginComercialView.getVendedor().getId_vendedor());
										} catch (FileNotFoundException e1) {
											
											e1.printStackTrace();
										}

									}

									NumberFormat tresDigitos = new DecimalFormat("000");
									getTfTotalDeClientes().setText(
											tresDigitos.format(LoginComercialView.listaCliente.size()) + etiqueta);

								} else {

									LogSegurancaController.novoLogSeguranca("ERRO AO EDITAR O CLIENTE");

									JOptionPane.showMessageDialog(null, "Erro ao editar o cliente!");

									limparPanelNovoCliente();

									tipoSalvarOuEditarCliente = 0;

									lblCadastroDeCliente.setText("CADASTRO DE CLIENTE");

									btnSalvarCliente.setText("Salvar");

									cardlayout.show(pnlCliente, "Inicial");

								}

							}

						}

					} else {

						lblCadastroDeCliente.setText("CADASTRO DE CLIENTE");

						btnSalvarCliente.setText("Salvar");

						cardlayout.show(pnlCliente, "Inicial");

						limparNovoCliente();

					}

				}

			}
		});
		btnSalvarCliente.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnSalvarCliente.setBounds(668, 403, 101, 23);
		cadastroClientePanel.add(btnSalvarCliente);

		JButton btnNovoCancelar = new JButton("Cancelar");
		btnNovoCancelar.setMnemonic('c');
		btnNovoCancelar.setToolTipText("Cancelar");
		btnNovoCancelar.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnNovoCancelar.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnNovoCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNovoCancelar.setForeground(Color.WHITE);
		btnNovoCancelar.setContentAreaFilled(false);
		btnNovoCancelar.setBorder(null);
		btnNovoCancelar.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {

				lblCadastroDeCliente.setText("CADASTRO DE CLIENTE");

				btnSalvarCliente.setText("Salvar");

				limparPanelNovoCliente();

				if (tipoSalvarOuEditarCliente == 0 || tipoSalvarOuEditarCliente == 1) {

					cardlayout.show(pnlCliente, "Inicial");

				} else if (tipoSalvarOuEditarCliente == 2) {

					cardlayout.show(pnlCliente, "Dados");

				}

			}
		});
		btnNovoCancelar.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnNovoCancelar.setBounds(780, 403, 101, 23);
		cadastroClientePanel.add(btnNovoCancelar);

		ftfNovoCnpj = new JFormattedTextField(ClienteUteis.CNPJ(""));
		ftfNovoCnpj.setBorder(new LineBorder(new Color(0, 0, 205)));
		ftfNovoCnpj.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		ftfNovoCnpj.setBounds(143, 210, 144, 21);
		cadastroClientePanel.add(ftfNovoCnpj);

		ftfNovoCelular1 = new JFormattedTextField(ClienteUteis.TelefoneCelular(""));
		ftfNovoCelular1.setBorder(new LineBorder(new Color(0, 0, 205)));
		ftfNovoCelular1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		ftfNovoCelular1.setBounds(635, 108, 118, 21);
		cadastroClientePanel.add(ftfNovoCelular1);

		ftfNovoFixo1 = new JFormattedTextField(ClienteUteis.TelefoneFixo(""));
		ftfNovoFixo1.setBorder(new LineBorder(new Color(0, 0, 205)));
		ftfNovoFixo1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		ftfNovoFixo1.setBounds(763, 108, 118, 21);
		cadastroClientePanel.add(ftfNovoFixo1);

		ftfNovoCEP = new JFormattedTextField(ClienteUteis.CEP(""));
		ftfNovoCEP.setBorder(new LineBorder(new Color(0, 0, 205)));
		ftfNovoCEP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		ftfNovoCEP.setBounds(465, 314, 95, 21);
		cadastroClientePanel.add(ftfNovoCEP);

		dcNovoClienteDesde = new JDateChooser();
		dcNovoClienteDesde.setBorder(new LineBorder(new Color(0, 0, 205)));
		dcNovoClienteDesde.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		dcNovoClienteDesde.setBounds(779, 314, 102, 20);
		cadastroClientePanel.add(dcNovoClienteDesde);

		JLabel lblNovoClienteDesde = new JLabel("Cliente Desde");
		lblNovoClienteDesde.setForeground(new Color(0, 0, 205));
		lblNovoClienteDesde.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoClienteDesde.setBounds(779, 293, 80, 17);
		cadastroClientePanel.add(lblNovoClienteDesde);

		JLabel lblInscricaoMunicipal = new JLabel("Inscri\u00E7\u00E3o Municipal");
		lblInscricaoMunicipal.setForeground(new Color(0, 0, 205));
		lblInscricaoMunicipal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblInscricaoMunicipal.setBounds(517, 191, 149, 17);
		cadastroClientePanel.add(lblInscricaoMunicipal);

		tfInscricaoMunicipal = new JTextField();
		tfInscricaoMunicipal.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfInscricaoMunicipal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfInscricaoMunicipal.setColumns(10);
		tfInscricaoMunicipal.setBackground(Color.WHITE);
		tfInscricaoMunicipal.setBounds(517, 210, 149, 21);
		cadastroClientePanel.add(tfInscricaoMunicipal);

		JLabel lblNovoContato2 = new JLabel("Contato 2");
		lblNovoContato2.setForeground(new Color(0, 0, 205));
		lblNovoContato2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoContato2.setBounds(143, 140, 95, 17);
		cadastroClientePanel.add(lblNovoContato2);

		tfNovoContato2 = new JTextField();
		tfNovoContato2.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfNovoContato2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfNovoContato2.setColumns(10);
		tfNovoContato2.setBackground(Color.WHITE);
		tfNovoContato2.setBounds(143, 161, 225, 21);
		cadastroClientePanel.add(tfNovoContato2);

		JLabel lblNovoEmail2 = new JLabel("Email 2");
		lblNovoEmail2.setForeground(new Color(0, 0, 205));
		lblNovoEmail2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNovoEmail2.setBounds(378, 141, 235, 17);
		cadastroClientePanel.add(lblNovoEmail2);

		tfNovoEmail2 = new JTextField();
		tfNovoEmail2.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfNovoEmail2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfNovoEmail2.setColumns(10);
		tfNovoEmail2.setBackground(Color.WHITE);
		tfNovoEmail2.setBounds(378, 161, 247, 21);
		cadastroClientePanel.add(tfNovoEmail2);

		JLabel lblFoneCelular = new JLabel("Fone Celular 2");
		lblFoneCelular.setForeground(new Color(0, 0, 205));
		lblFoneCelular.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblFoneCelular.setBounds(635, 140, 95, 17);
		cadastroClientePanel.add(lblFoneCelular);

		ftfNovoCelular2 = new JFormattedTextField(ClienteUteis.TelefoneCelular(""));
		ftfNovoCelular2.setBorder(new LineBorder(new Color(0, 0, 205)));
		ftfNovoCelular2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		ftfNovoCelular2.setBounds(635, 161, 118, 21);
		cadastroClientePanel.add(ftfNovoCelular2);

		JLabel lblFoneFixo = new JLabel("Fone Fixo 2");
		lblFoneFixo.setForeground(new Color(0, 0, 205));
		lblFoneFixo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblFoneFixo.setBounds(764, 140, 95, 17);
		cadastroClientePanel.add(lblFoneFixo);

		ftfNovoFixo2 = new JFormattedTextField(ClienteUteis.TelefoneFixo(""));
		ftfNovoFixo2.setBorder(new LineBorder(new Color(0, 0, 205)));
		ftfNovoFixo2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		ftfNovoFixo2.setBounds(763, 161, 118, 21);
		cadastroClientePanel.add(ftfNovoFixo2);

		lblCadastroDeCliente = new JLabel("CADASTRO DE CLIENTE");
		lblCadastroDeCliente.setForeground(new Color(0, 0, 205));
		lblCadastroDeCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeCliente.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblCadastroDeCliente.setBounds(10, 0, 1000, 30);
		cadastroClientePanel.add(lblCadastroDeCliente);

		JPanel pesquisaEditarClientePanel = new JPanel();
		pesquisaEditarClientePanel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnPesquisaCliente);
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnSelecionar);
				
			}
		});
		pesquisaEditarClientePanel.setBackground(Color.WHITE);
		pesquisaEditarClientePanel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		pesquisaEditarClientePanel.setLayout(null);
		pesquisaEditarClientePanel.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		pnlCliente.add(pesquisaEditarClientePanel, "EditarNovo");

		tfPesquisarCliente = new JTextField();
		tfPesquisarCliente.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfPesquisarCliente.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		tfPesquisarCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {

				getRootPane().setDefaultButton(btnPesquisaCliente);
				cbCliente.setSelectedIndex(0);

			}

			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		tfPesquisarCliente.setColumns(10);
		tfPesquisarCliente.setBounds(317, 101, 273, 23);
		pesquisaEditarClientePanel.add(tfPesquisarCliente);

		btnPesquisaCliente = new JButton("Pesquisar");
		btnPesquisaCliente.setToolTipText("Pesquisar Cliente");
		btnPesquisaCliente.setMnemonic('p');
		btnPesquisaCliente
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnPesquisaCliente.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnPesquisaCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPesquisaCliente.setForeground(Color.WHITE);
		btnPesquisaCliente.setContentAreaFilled(false);
		btnPesquisaCliente.setBorder(null);
		btnPesquisaCliente.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnPesquisaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tfPesquisarCliente.getText() == null || tfPesquisarCliente.getText().trim().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite o nome do cliente", "Pesquisar Cliente",
							JOptionPane.INFORMATION_MESSAGE);
					tfPesquisarCliente.requestFocus();

					spPesquisarCliente.setVisible(false);
					btnEditarPesquisaCliente.setVisible(false);

				} else {

					ClienteController clienteController = new ClienteController();

					if (LoginComercialView.getVendedor().getAcesso().equalsIgnoreCase("GERENCIAL")) {

						try {
							listaPesquisaCliente = clienteController
									.listarClientesPorNome(tfPesquisarCliente.getText().toUpperCase());
						} catch (FileNotFoundException e) {
						
							e.printStackTrace();
						}

					} else {

						try {
							listaPesquisaCliente = clienteController.listarClientesPorNomeEVendedor(
									tfPesquisarCliente.getText().toUpperCase(),
									LoginComercialView.getVendedor().getId_vendedor());
						} catch (FileNotFoundException e) {
							
							e.printStackTrace();
						}

					}

					if (listaPesquisaCliente.isEmpty()) {

						JOptionPane.showMessageDialog(null, "A pesquisa não obteve resultado", "Pesquisar Cliente",
								JOptionPane.INFORMATION_MESSAGE);

						tfPesquisarCliente.setText("");
						spPesquisarCliente.setVisible(false);
						btnEditarPesquisaCliente.setVisible(false);

					} else {

						spPesquisarCliente.setVisible(true);
						btnEditarPesquisaCliente.setVisible(true);
						tfPesquisarCliente.setText("");

						DefaultTableModel model = (DefaultTableModel) tbPesquisarCliente.getModel();
						model.setNumRows(0);

						for (Cliente c : listaPesquisaCliente) {

							Object[] linha = { c.getNome() };

							model.addRow(linha);

						}

					}

				}

			}
		});
		btnPesquisaCliente.setBounds(614, 101, 89, 24);
		pesquisaEditarClientePanel.add(btnPesquisaCliente);

		spPesquisarCliente = new JScrollPane();
		spPesquisarCliente.setBorder(new LineBorder(new Color(0, 0, 205)));
		spPesquisarCliente.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		spPesquisarCliente.setVisible(false);
		spPesquisarCliente.setBounds(317, 162, 386, 206);
		pesquisaEditarClientePanel.add(spPesquisarCliente);

		tbPesquisarCliente = new JTable();
		tbPesquisarCliente.setGridColor(new Color(0, 0, 205));
		tbPesquisarCliente.setBorder(new LineBorder(new Color(0, 0, 205)));
		tbPesquisarCliente.setForeground(new Color(0, 0, 205));
		tbPesquisarCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {

				getRootPane().setDefaultButton(btnEditarPesquisaCliente);

			}

			@Override
			public void focusLost(FocusEvent e) {

				getRootPane().setDefaultButton(btnSelecionar);

			}
		});
		tbPesquisarCliente.setDefaultRenderer(Object.class, new TabLinhasPesquisa());
		tbPesquisarCliente.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tbPesquisarCliente.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "CLIENTE" }));
		tbPesquisarCliente.getColumnModel().getColumn(0).setPreferredWidth(378);
		spPesquisarCliente.setViewportView(tbPesquisarCliente);

		btnEditarPesquisaCliente = new JButton("Editar");
		btnEditarPesquisaCliente.setToolTipText("Editar Cliente");
		btnEditarPesquisaCliente.setMnemonic('e');
		btnEditarPesquisaCliente
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnEditarPesquisaCliente.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnEditarPesquisaCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditarPesquisaCliente.setForeground(Color.WHITE);
		btnEditarPesquisaCliente.setContentAreaFilled(false);
		btnEditarPesquisaCliente.setBorder(null);
		btnEditarPesquisaCliente.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnEditarPesquisaCliente.setVisible(false);
		btnEditarPesquisaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int posicao = tbPesquisarCliente.getSelectedRow();

				if (tbPesquisarCliente.getSelectedRow() == -1) {

					JOptionPane.showMessageDialog(null, "Selecione o cliente que quer editar", "Pesquisar Cliente",
							JOptionPane.INFORMATION_MESSAGE);

				} else {

					int resposta = 0;

					resposta = JOptionPane.showConfirmDialog(null, "Você deseja editar o cliente selecionado?",
							"Pesquisar Cliente", JOptionPane.YES_NO_OPTION);

					if (resposta == 0) {

						ClienteController clienteController = new ClienteController();
						Cliente clientePesquisa = new Cliente();

						int id_cliente = listaPesquisaCliente.get(posicao).getId_cliente();
						try {
							clientePesquisa = clienteController.mostrarCliente(id_cliente);
						} catch (FileNotFoundException e) {
						
							e.printStackTrace();
						}

						int id_vendedor = clientePesquisa.getId_vendedor();
						String nomeVendedor = vendedorController.buscarNomeVendedor(id_vendedor);

						tfNovoNomeFantasia.setText(clientePesquisa.getNome());
						tfNovoRazaoSocial.setText(clientePesquisa.getRazaoSocial());
						tfNovoContato1.setText(clientePesquisa.getContato1());
						tfNovoEmail1.setText(clientePesquisa.getEmail1().toLowerCase());
						ftfNovoCelular1.setText(clientePesquisa.getFoneCelular1());
						ftfNovoFixo1.setText(clientePesquisa.getFoneFixo1());
						tfNovoContato2.setText(clientePesquisa.getContato2());

						if (clientePesquisa.getEmail2() == null) {

							clientePesquisa.setEmail2("");

						} else {

							tfNovoEmail2.setText(clientePesquisa.getEmail2().toLowerCase());

						}

						ftfNovoCelular2.setText(clientePesquisa.getFoneCelular2());
						ftfNovoFixo2.setText(clientePesquisa.getFoneFixo2());
						ftfNovoCnpj.setText(clientePesquisa.getCnpj());
						tfNovoInscricaoEstadual.setText(clientePesquisa.getInscricaoEstadual());
						tfInscricaoMunicipal.setText(clientePesquisa.getInscricaoMunicipal());
						cbNovoVendedor.setSelectedItem(nomeVendedor.toUpperCase());
						tfNovoLogradouro.setText(clientePesquisa.getLogradouro());
						tfNovoBairro.setText(clientePesquisa.getBairro());
						tfNovoCidade.setText(clientePesquisa.getCidade());
						ftfNovoCEP.setText(clientePesquisa.getCep());
						cbNovoUf.setSelectedItem(clientePesquisa.getUf());
						cbNovoEntrega.setSelectedItem(clientePesquisa.getEmail1());
						cbNovoUnidade.setSelectedItem(clientePesquisa.getUnidade());
						dcNovoClienteDesde.setDate(clientePesquisa.getClienteDesde());
						tpNovoObservacoesDoCliente.setText(clientePesquisa.getDetalhes());

						DefaultTableModel model = (DefaultTableModel) tbPesquisarCliente.getModel();
						model.setNumRows(0);
						spPesquisarCliente.setVisible(false);
						btnEditarPesquisaCliente.setVisible(false);

						btnSalvarCliente.setText("Editar");

						cliente = clientePesquisa;

						tipoSalvarOuEditarCliente = 1;

						lblCadastroDeCliente.setText("EDITAR CLIENTE");

						cardlayout.show(pnlCliente, "Novo");

					} else {

						/*
						 * DefaultTableModel model = (DefaultTableModel) tbPesquisarCliente.getModel();
						 * model.setNumRows(0);
						 * 
						 * tfPesquisarCliente.setText("");
						 * 
						 * spPesquisarCliente.setVisible(false);
						 * btnEditarPesquisaCliente.setVisible(false);
						 * 
						 * cardlayout.show(pnlCliente, "Inicial");
						 */

					}

				}

			}

		});
		btnEditarPesquisaCliente.setBounds(465, 388, 89, 23);
		pesquisaEditarClientePanel.add(btnEditarPesquisaCliente);

		JButton btnCancelarEditarCliente = new JButton("Cancelar");
		btnCancelarEditarCliente.setToolTipText("Cancelar");
		btnCancelarEditarCliente.setMnemonic('c');
		btnCancelarEditarCliente
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnCancelarEditarCliente.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnCancelarEditarCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelarEditarCliente.setBorder(null);
		btnCancelarEditarCliente.setContentAreaFilled(false);
		btnCancelarEditarCliente.setForeground(Color.WHITE);
		btnCancelarEditarCliente.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnCancelarEditarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) tbPesquisarCliente.getModel();
				model.setNumRows(0);

				tfPesquisarCliente.setText("");

				spPesquisarCliente.setVisible(false);
				btnEditarPesquisaCliente.setVisible(false);

				cardlayout.show(pnlCliente, "Inicial");

			}
		});
		btnCancelarEditarCliente.setBounds(870, 420, 83, 23);
		pesquisaEditarClientePanel.add(btnCancelarEditarCliente);

		JLabel lblEditarCliente = new JLabel("PESQUISAR CLIENTE");
		lblEditarCliente.setForeground(new Color(0, 0, 205));
		lblEditarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarCliente.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblEditarCliente.setBounds(13, 0, 994, 30);
		pesquisaEditarClientePanel.add(lblEditarCliente);

		JPanel cadastroVendedorPanel = new JPanel();
		cadastroVendedorPanel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnCadastrarVendedor);
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnSelecionar);
				
			}
		});
		cadastroVendedorPanel.setBackground(Color.WHITE);
		cadastroVendedorPanel.setFont(new Font("Arial", Font.PLAIN, 12));
		cadastroVendedorPanel.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		pnlCliente.add(cadastroVendedorPanel, "Cadastro Vendedor");
		cadastroVendedorPanel.setLayout(null);

		JButton btnCancelarCadVendedor = new JButton("Cancelar");
		btnCancelarCadVendedor.setToolTipText("Cancelar");
		btnCancelarCadVendedor.setMnemonic('c');
		btnCancelarCadVendedor
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnCancelarCadVendedor.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnCancelarCadVendedor.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelarCadVendedor.setContentAreaFilled(false);
		btnCancelarCadVendedor.setBorder(null);
		btnCancelarCadVendedor.setForeground(Color.WHITE);
		btnCancelarCadVendedor.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnCancelarCadVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limparVendedorPanel();

				lblCadastroDeVendedor.setText("CADASTRO DE VENDEDOR");

				btnCadastrarVendedor.setText("Salvar");

				btnExcluirVendedor.setVisible(false);

				tipoSalvarOuEditarVendedor = true;

				cardlayout.show(pnlCliente, "Inicial");

			}
		});
		btnCancelarCadVendedor.setBounds(660, 361, 83, 23);
		cadastroVendedorPanel.add(btnCancelarCadVendedor);

		tfNomeVendedor = new JTextField();
		tfNomeVendedor.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfNomeVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfNomeVendedor.setBounds(277, 60, 466, 21);
		cadastroVendedorPanel.add(tfNomeVendedor);
		tfNomeVendedor.setColumns(10);

		JLabel lblNomeVendedor = new JLabel("Nome");
		lblNomeVendedor.setForeground(new Color(0, 0, 205));
		lblNomeVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNomeVendedor.setBounds(277, 41, 146, 14);
		cadastroVendedorPanel.add(lblNomeVendedor);

		JLabel lblCargoVendedor = new JLabel("Cargo");
		lblCargoVendedor.setForeground(new Color(0, 0, 205));
		lblCargoVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblCargoVendedor.setBounds(278, 97, 47, 14);
		cadastroVendedorPanel.add(lblCargoVendedor);

		cbCadVendedor = new JComboBox<String>();
		cbCadVendedor.setBorder(new LineBorder(new Color(0, 0, 205)));
		cbCadVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		cbCadVendedor.setModel(new DefaultComboBoxModel<String>(
				new String[] { "SELECIONE...", "COORDENADOR DE VENDAS", "EXECUTIVO DE CONTAS", "GERENTE COMERCIAL" }));
		cbCadVendedor.setBounds(277, 115, 261, 21);
		cadastroVendedorPanel.add(cbCadVendedor);

		ftfCelularComercial = new JFormattedTextField(ClienteUteis.TelefoneCelular(""));
		ftfCelularComercial.setBorder(new LineBorder(new Color(0, 0, 205)));
		ftfCelularComercial.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		ftfCelularComercial.setBounds(277, 166, 181, 21);
		cadastroVendedorPanel.add(ftfCelularComercial);

		JLabel lblCelularComercial = new JLabel("Celular Comercial");
		lblCelularComercial.setForeground(new Color(0, 0, 205));
		lblCelularComercial.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblCelularComercial.setBounds(277, 147, 181, 14);
		cadastroVendedorPanel.add(lblCelularComercial);

		JLabel lblEmailComercial = new JLabel("E-mail Comercial");
		lblEmailComercial.setForeground(new Color(0, 0, 205));
		lblEmailComercial.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblEmailComercial.setBounds(468, 147, 275, 14);
		cadastroVendedorPanel.add(lblEmailComercial);

		tfEmailComercial = new JTextField();
		tfEmailComercial.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfEmailComercial.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfEmailComercial.setColumns(10);
		tfEmailComercial.setBounds(468, 166, 275, 21);
		cadastroVendedorPanel.add(tfEmailComercial);

		JLabel lblLoginVendedor = new JLabel("Login");
		lblLoginVendedor.setForeground(new Color(0, 0, 205));
		lblLoginVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblLoginVendedor.setBounds(278, 249, 47, 14);
		cadastroVendedorPanel.add(lblLoginVendedor);

		tfLoginCadVendedor = new JTextField();
		tfLoginCadVendedor.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfLoginCadVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfLoginCadVendedor.setColumns(10);
		tfLoginCadVendedor.setBounds(277, 268, 466, 21);
		cadastroVendedorPanel.add(tfLoginCadVendedor);

		pfSenhaVendedor = new JPasswordField();
		pfSenhaVendedor.setBorder(new LineBorder(new Color(0, 0, 205)));
		pfSenhaVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		pfSenhaVendedor.setBounds(277, 319, 224, 21);
		cadastroVendedorPanel.add(pfSenhaVendedor);

		JLabel lblSenhaVendedor = new JLabel("Senha");
		lblSenhaVendedor.setForeground(new Color(0, 0, 205));
		lblSenhaVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblSenhaVendedor.setBounds(277, 299, 47, 14);
		cadastroVendedorPanel.add(lblSenhaVendedor);

		JLabel lblRepSenhaVendedor = new JLabel("Repetir Senha");
		lblRepSenhaVendedor.setForeground(new Color(0, 0, 205));
		lblRepSenhaVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblRepSenhaVendedor.setBounds(511, 299, 104, 14);
		cadastroVendedorPanel.add(lblRepSenhaVendedor);

		pfRepSenhaVendedor = new JPasswordField();
		pfRepSenhaVendedor.setBorder(new LineBorder(new Color(0, 0, 205)));
		pfRepSenhaVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		pfRepSenhaVendedor.setBounds(511, 319, 232, 21);
		cadastroVendedorPanel.add(pfRepSenhaVendedor);

		btnCadastrarVendedor = new JButton("Salvar");
		btnCadastrarVendedor.setToolTipText("Salvar Vendedor");
		btnCadastrarVendedor.setMnemonic('s');
		btnCadastrarVendedor
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnCadastrarVendedor.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnCadastrarVendedor.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCadastrarVendedor.setContentAreaFilled(false);
		btnCadastrarVendedor.setBorder(null);
		btnCadastrarVendedor.setForeground(Color.WHITE);
		btnCadastrarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tfNomeVendedor.getText() == null || tfNomeVendedor.getText().trim().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Digite o nome!", "Campo Obrigatório",
							JOptionPane.WARNING_MESSAGE);
					tfNomeVendedor.requestFocus();

				} else if (String.valueOf(cbCadVendedor.getSelectedItem()).equalsIgnoreCase("Selecione...")) {

					JOptionPane.showMessageDialog(null, "Selecione o cargo!", "Campo Obrigatório",
							JOptionPane.WARNING_MESSAGE);
					cbCadVendedor.setSelectedIndex(0);
					cbCadVendedor.requestFocus();

				} else if (String.valueOf(cbAcessoVendedor.getSelectedItem()).equalsIgnoreCase("Selecione...")) {

					JOptionPane.showMessageDialog(null, "Selecione tipo do Acesso!", "Campo Obrigatório",
							JOptionPane.WARNING_MESSAGE);
					cbAcessoVendedor.setSelectedIndex(0);
					cbAcessoVendedor.requestFocus();

				} else if (ftfCelularComercial.getText() == null || ftfCelularComercial.getText().trim().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Digite o telefone!", "Campo Obrigatório",
							JOptionPane.WARNING_MESSAGE);
					ftfCelularComercial.requestFocus();

				} else if (tfEmailComercial.getText() == null || tfEmailComercial.getText().trim().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Digite o e-mail!", "Campo Obrigatório",
							JOptionPane.WARNING_MESSAGE);
					tfEmailComercial.requestFocus();

				} else if (tfLoginCadVendedor.getText() == null || tfLoginCadVendedor.getText().trim().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Digite o login!", "Campo Obrigatório",
							JOptionPane.WARNING_MESSAGE);
					tfLoginCadVendedor.requestFocus();

				} else if (pfSenhaVendedor.getPassword() == null
						|| String.valueOf(pfSenhaVendedor.getPassword()).trim().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Digite a Senha!", "Campo Obrigatório",
							JOptionPane.WARNING_MESSAGE);
					pfSenhaVendedor.requestFocus();

				} else if (pfRepSenhaVendedor.getPassword() == null
						|| String.valueOf(pfRepSenhaVendedor.getPassword()).trim().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Digite a confirmação da senha!", "Campo Obrigatório",
							JOptionPane.WARNING_MESSAGE);
					pfRepSenhaVendedor.requestFocus();

				} else if (!String.valueOf(pfSenhaVendedor.getPassword())
						.equals(String.valueOf(pfRepSenhaVendedor.getPassword()))) {

					JOptionPane.showMessageDialog(null, "A confirmação da senha não está igual a senha!",
							"Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
					pfRepSenhaVendedor.setText("");
					pfRepSenhaVendedor.requestFocus();

				} else {

					if (tipoSalvarOuEditarVendedor == true) {

						vendedor.setNome(tfNomeVendedor.getText().toUpperCase());
						vendedor.setCargo(String.valueOf(cbCadVendedor.getSelectedItem()));
						vendedor.setAcesso(String.valueOf(cbAcessoVendedor.getSelectedItem()));
						vendedor.setFoneComercial(ftfCelularComercial.getText());
						vendedor.setEmailComercial(tfEmailComercial.getText().toLowerCase());
						vendedor.setFonePessoal(ftfCelularPessoal.getText());
						vendedor.setEmailPessoal(tfEmailPessoal.getText().toLowerCase());
						vendedor.setLogin(tfLoginCadVendedor.getText().toUpperCase());
						vendedor.setSenha(String.valueOf(pfSenhaVendedor.getPassword()));

						VendedorController vendedorController = new VendedorController();
						int id_operador = vendedorController.adicionarVendedor(vendedor);

						if (id_operador != -1) {

							LogSegurancaController.novoLogSeguranca("VENDEDOR SALVO");

							JOptionPane.showMessageDialog(null, "Vendedor salvo!", "Cadastro Vendedor",
									JOptionPane.INFORMATION_MESSAGE);

							limparVendedorPanel();

							btnExcluirVendedor.setVisible(false);

							// ATUALIZAR

							try {
								atualizarVendedor();
							} catch (FileNotFoundException e1) {

								e1.printStackTrace();
							}

							cardlayout.show(pnlCliente, "Inicial");

						} else {

							LogSegurancaController.novoLogSeguranca("ERRO AO SALVAR O VENDEDOR");

							JOptionPane.showMessageDialog(null, "Erro ao salvar o vendedor!", "Cadastro Vendedor",
									JOptionPane.ERROR_MESSAGE);

							limparVendedorPanel();

							btnExcluirVendedor.setVisible(false);

							cardlayout.show(pnlCliente, "Inicial");

						}

					} else {

						Vendedor vendedorTemp = new Vendedor();

						vendedorTemp.setId_vendedor(vendedor.getId_vendedor());
						vendedorTemp.setNome(tfNomeVendedor.getText().toUpperCase());
						vendedorTemp.setCargo(String.valueOf(cbCadVendedor.getSelectedItem()));
						vendedorTemp.setAcesso(String.valueOf(cbAcessoVendedor.getSelectedItem()));
						vendedorTemp.setFoneComercial(ftfCelularComercial.getText());
						vendedorTemp.setEmailComercial(tfEmailComercial.getText().toLowerCase());
						vendedorTemp.setFonePessoal(ftfCelularPessoal.getText());
						vendedorTemp.setEmailPessoal(tfEmailPessoal.getText().toLowerCase());
						vendedorTemp.setLogin(tfLoginCadVendedor.getText().toUpperCase());
						vendedorTemp.setSenha(String.valueOf(pfSenhaVendedor.getPassword()));

						VendedorController vendedorController = new VendedorController();

						if (vendedorTemp.toString().equals(vendedor.toString())) {

							JOptionPane.showMessageDialog(null, "Não houve edição no vendedor!", "Editar vendedor",
									JOptionPane.INFORMATION_MESSAGE);

							limparVendedorPanel();

							lblCadastroDeVendedor.setText("CADASTRO DE VENDEDOR");

							btnCadastrarVendedor.setText("Salvar");

							tipoSalvarOuEditarVendedor = true;

							cardlayout.show(pnlCliente, "Inicial");

						} else {

							boolean sucesso = vendedorController.editarVendedor(vendedorTemp);

							if (sucesso == true) {

								LogSegurancaController.novoLogSeguranca("VENDEDOR EDITADO");

								JOptionPane.showMessageDialog(null, "Vendedor editado!", "Editar Vendedor",
										JOptionPane.INFORMATION_MESSAGE);

								limparVendedorPanel();

								lblCadastroDeVendedor.setText("CADASTRO DE VENDEDOR");

								btnExcluirVendedor.setVisible(false);

								// ATUALIZAR
								try {
									atualizarVendedor();
								} catch (FileNotFoundException e1) {

									e1.printStackTrace();
								}

								vendedor = vendedorTemp;

								tipoSalvarOuEditarVendedor = true;

								btnCadastrarVendedor.setText("Salvar");

								cardlayout.show(pnlCliente, "Inicial");

							} else {

								LogSegurancaController.novoLogSeguranca("ERRO AO EDITAR O VENDEDOR");

								JOptionPane.showMessageDialog(null, "Erro ao editar o vendedor!", "Editar Vendedor",
										JOptionPane.ERROR_MESSAGE);

								limparVendedorPanel();

								lblCadastroDeVendedor.setText("CADASTRO DE VENDEDOR");

								tipoSalvarOuEditarVendedor = true;

								btnExcluirVendedor.setVisible(false);

								btnCadastrarVendedor.setText("Salvar");

								cardlayout.show(pnlCliente, "Inicial");
							}

						}

					}

				}

			}
		});
		btnCadastrarVendedor.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnCadastrarVendedor.setBounds(468, 361, 83, 23);
		cadastroVendedorPanel.add(btnCadastrarVendedor);

		JLabel lblAcessoVendedor = new JLabel("Tipo de Acesso");
		lblAcessoVendedor.setForeground(new Color(0, 0, 205));
		lblAcessoVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblAcessoVendedor.setBounds(548, 97, 195, 14);
		cadastroVendedorPanel.add(lblAcessoVendedor);

		cbAcessoVendedor = new JComboBox<String>();
		cbAcessoVendedor.setBorder(new LineBorder(new Color(0, 0, 205)));
		cbAcessoVendedor
				.setModel(new DefaultComboBoxModel<String>(new String[] { "SELECIONE...", "COMERCIAL", "GERENCIAL" }));
		cbAcessoVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		cbAcessoVendedor.setBounds(548, 115, 195, 21);
		cadastroVendedorPanel.add(cbAcessoVendedor);

		btnExcluirVendedor = new JButton("Excluir");
		btnExcluirVendedor.setToolTipText("Excluir Vendedor");
		btnExcluirVendedor.setMnemonic('e');
		btnExcluirVendedor
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnExcluirVendedor.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnExcluirVendedor.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExcluirVendedor.setContentAreaFilled(false);
		btnExcluirVendedor.setBorder(null);
		btnExcluirVendedor.setForeground(Color.WHITE);
		btnExcluirVendedor.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnExcluirVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o vendedor?", "Excluir vendedor",
						JOptionPane.YES_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {
					
					int id_vendedorExcluido = vendedor.getId_vendedor();
					ClienteController clienteController = new ClienteController();
					
					try {
						
						clienteController.mudarIdParaEmpresa(id_vendedorExcluido);
						
					} catch (FileNotFoundException e2) {
						
						e2.printStackTrace();
					}
					
					VendedorController vendedorController = new VendedorController();
					boolean sucesso = false;
					
					try {
						
						sucesso = vendedorController.excluirVendedor(vendedor.getId_vendedor());
					
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}

					if (sucesso == true) {

						LogSegurancaController.novoLogSeguranca("VENDEDOR EXCLUÍDO");

						JOptionPane.showMessageDialog(null, "Vendedor excluído!", "Excluir vendedor",
								JOptionPane.INFORMATION_MESSAGE);

						limparVendedorPanel();

						lblCadastroDeVendedor.setText("CADASTRO DE VENDEDOR");

						btnExcluirVendedor.setVisible(false);

						// ATUALIZAÇÃO
						try {
							atualizarVendedor();
						} catch (FileNotFoundException e) {

							e.printStackTrace();
						}

						tipoSalvarOuEditarVendedor = true;

						btnCadastrarVendedor.setText("Salvar");

						cardlayout.show(pnlCliente, "Inicial");

					} else {

						LogSegurancaController.novoLogSeguranca("O VENDEDOR NÃO FOI EXCLUÍDO");

						JOptionPane.showMessageDialog(null, "O vendedor não foi excluído!", "Excluir vendedor",
								JOptionPane.WARNING_MESSAGE);

						limparVendedorPanel();

						lblCadastroDeVendedor.setText("CADASTRO DE VENDEDOR");

						tipoSalvarOuEditarVendedor = true;

						btnCadastrarVendedor.setText("Salvar");

						btnExcluirVendedor.setVisible(false);

						cardlayout.show(pnlCliente, "Inicial");

					}

				} else {

					limparVendedorPanel();

					lblCadastroDeVendedor.setText("CADASTRO DE VENDEDOR");

					tipoSalvarOuEditarVendedor = true;

					btnCadastrarVendedor.setText("Salvar");

					btnExcluirVendedor.setVisible(false);

					cardlayout.show(pnlCliente, "Inicial");

				}

				btnExcluirVendedor.setVisible(false);

			}
		});
		btnExcluirVendedor.setVisible(false);
		btnExcluirVendedor.setBounds(277, 362, 89, 23);
		cadastroVendedorPanel.add(btnExcluirVendedor);

		JLabel lblCelularPessoal = new JLabel("Celular Pessoal");
		lblCelularPessoal.setForeground(new Color(0, 0, 205));
		lblCelularPessoal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblCelularPessoal.setBounds(277, 198, 181, 14);
		cadastroVendedorPanel.add(lblCelularPessoal);

		JLabel lblEmailPessoal = new JLabel("E-mail Pessoal");
		lblEmailPessoal.setForeground(new Color(0, 0, 205));
		lblEmailPessoal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblEmailPessoal.setBounds(468, 198, 275, 14);
		cadastroVendedorPanel.add(lblEmailPessoal);

		ftfCelularPessoal = new JFormattedTextField(ClienteUteis.TelefoneCelular(""));
		ftfCelularPessoal.setBorder(new LineBorder(new Color(0, 0, 205)));
		ftfCelularPessoal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		ftfCelularPessoal.setBounds(277, 217, 181, 21);
		cadastroVendedorPanel.add(ftfCelularPessoal);

		tfEmailPessoal = new JTextField();
		tfEmailPessoal.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfEmailPessoal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfEmailPessoal.setColumns(10);
		tfEmailPessoal.setBounds(468, 217, 275, 21);
		cadastroVendedorPanel.add(tfEmailPessoal);

		lblCadastroDeVendedor = new JLabel("CADASTRO DE VENDEDOR");
		lblCadastroDeVendedor.setForeground(Color.BLUE);
		lblCadastroDeVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeVendedor.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblCadastroDeVendedor.setBounds(13, 0, 994, 30);
		cadastroVendedorPanel.add(lblCadastroDeVendedor);

		JPanel pesquisaEditarVendedorPanel = new JPanel();
		pesquisaEditarVendedorPanel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnPesquiarEditarVendedor);
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnSelecionar);
				
			}
		});
		pesquisaEditarVendedorPanel.setBackground(Color.WHITE);
		pesquisaEditarVendedorPanel.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		pesquisaEditarVendedorPanel.setFont(new Font("Arial", Font.PLAIN, 11));
		pnlCliente.add(pesquisaEditarVendedorPanel, "EditarVendedor");
		pesquisaEditarVendedorPanel.setLayout(null);

		tfPesquisarEditarVendedor = new JTextField();
		tfPesquisarEditarVendedor.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfPesquisarEditarVendedor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {

				getRootPane().setDefaultButton(btnPesquiarEditarVendedor);
				cbCliente.setSelectedIndex(0);

			}
		});
		tfPesquisarEditarVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		tfPesquisarEditarVendedor.setColumns(10);
		tfPesquisarEditarVendedor.setBounds(317, 101, 273, 23);
		pesquisaEditarVendedorPanel.add(tfPesquisarEditarVendedor);

		btnPesquiarEditarVendedor = new JButton("Pesquisar");
		btnPesquiarEditarVendedor.setMnemonic('p');
		btnPesquiarEditarVendedor.setToolTipText("Pesquisar Vendedor");
		btnPesquiarEditarVendedor
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnPesquiarEditarVendedor.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnPesquiarEditarVendedor.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPesquiarEditarVendedor.setForeground(Color.WHITE);
		btnPesquiarEditarVendedor.setContentAreaFilled(false);
		btnPesquiarEditarVendedor.setBorder(null);
		btnPesquiarEditarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tfPesquisarEditarVendedor.getText() == null
						|| tfPesquisarEditarVendedor.getText().trim().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite o nome do vendedor", "Pesquisar Vendedor",
							JOptionPane.INFORMATION_MESSAGE);

					tfPesquisarEditarVendedor.requestFocus();
					spPesquisarVendedor.setVisible(false);
					btnEditarPesquisarVendedor.setVisible(false);

				} else {

					VendedorController vendedorController = new VendedorController();

					listaPesquisaVendedor = vendedorController
							.buscarVendedores(tfPesquisarEditarVendedor.getText().toUpperCase());

					if (listaPesquisaVendedor.isEmpty()) {

						JOptionPane.showMessageDialog(null, "A pesquisa não obteve resultado", "Pesquisar Vendedor",
								JOptionPane.INFORMATION_MESSAGE);

						tfPesquisarEditarVendedor.setText("");
						spPesquisarVendedor.setVisible(false);
						btnEditarPesquisarVendedor.setVisible(false);

					} else {

						spPesquisarVendedor.setVisible(true);
						btnEditarPesquisarVendedor.setVisible(true);
						tfPesquisarEditarVendedor.setText("");

						DefaultTableModel model = (DefaultTableModel) tbPesquisarVendedor.getModel();
						model.setNumRows(0);

						for (Vendedor v : listaPesquisaVendedor) {

							Object[] linha = { v.getNome() };

							model.addRow(linha);

						}

					}

				}

			}
		});
		btnPesquiarEditarVendedor.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnPesquiarEditarVendedor.setBounds(614, 101, 89, 24);
		pesquisaEditarVendedorPanel.add(btnPesquiarEditarVendedor);

		spPesquisarVendedor = new JScrollPane();
		spPesquisarVendedor.setFont(new Font("Arial", Font.PLAIN, 12));
		spPesquisarVendedor.setVisible(false);
		spPesquisarVendedor.setBorder(new LineBorder(new Color(0, 0, 205)));
		spPesquisarVendedor.setBounds(317, 162, 386, 206);
		pesquisaEditarVendedorPanel.add(spPesquisarVendedor);

		tbPesquisarVendedor = new JTable();
		tbPesquisarVendedor.setGridColor(new Color(0, 0, 205));
		tbPesquisarVendedor.setForeground(new Color(0, 0, 205));
		tbPesquisarVendedor.setBorder(new LineBorder(new Color(0, 0, 205)));
		tbPesquisarVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tbPesquisarVendedor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				getRootPane().setDefaultButton(btnEditarPesquisarVendedor);

			}

			@Override
			public void focusLost(FocusEvent e) {

				getRootPane().setDefaultButton(btnSelecionar);

			}
		});
		tbPesquisarVendedor.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "VENDEDOR" }) {
			boolean[] columnEditables = new boolean[] { false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbPesquisarVendedor.setDefaultRenderer(Object.class, new TabLinhasPesquisa());
		tbPesquisarVendedor.getColumnModel().getColumn(0).setPreferredWidth(450);
		tbPesquisarVendedor.getColumnModel().getColumn(0).setMinWidth(26);
		spPesquisarVendedor.setViewportView(tbPesquisarVendedor);

		btnEditarPesquisarVendedor = new JButton("Editar");
		btnEditarPesquisarVendedor.setMnemonic('e');
		btnEditarPesquisarVendedor.setToolTipText("Editar Vendedor");
		btnEditarPesquisarVendedor
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnEditarPesquisarVendedor.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnEditarPesquisarVendedor.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditarPesquisarVendedor.setContentAreaFilled(false);
		btnEditarPesquisarVendedor.setBorder(null);
		btnEditarPesquisarVendedor.setForeground(Color.WHITE);
		btnEditarPesquisarVendedor.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnEditarPesquisarVendedor.setVisible(false);
		btnEditarPesquisarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int posicao = tbPesquisarVendedor.getSelectedRow();

				if (tbPesquisarVendedor.getSelectedRow() == -1) {

					JOptionPane.showMessageDialog(null, "Selecione o vendedor que quer editar", "Pesquisar Vendedor",
							JOptionPane.INFORMATION_MESSAGE);

				} else {

					int resposta = 0;

					resposta = JOptionPane.showConfirmDialog(null, "Você deseja editar o vendedor selecionado?",
							"Pesquisar Vendedor", JOptionPane.YES_NO_OPTION);

					if (resposta == 0) {

						VendedorController vendedorController = new VendedorController();

						int id_vendedor = listaPesquisaVendedor.get(posicao).getId_vendedor();
						vendedor = vendedorController.mostrarVendedor(id_vendedor);

						tfNomeVendedor.setText(vendedor.getNome().toUpperCase());
						cbCadVendedor.setSelectedItem(vendedor.getCargo().toUpperCase());
						cbAcessoVendedor.setSelectedItem(vendedor.getAcesso().toUpperCase());
						ftfCelularComercial.setText(vendedor.getFoneComercial());
						tfEmailComercial.setText(vendedor.getEmailComercial().toLowerCase());
						ftfCelularPessoal.setText(vendedor.getFonePessoal());
						tfEmailPessoal.setText(vendedor.getEmailPessoal().toLowerCase());
						tfLoginCadVendedor.setText(vendedor.getLogin().toUpperCase());
						pfSenhaVendedor.setText(vendedor.getSenha());
						pfRepSenhaVendedor.setText(vendedor.getSenha());

						DefaultTableModel model = (DefaultTableModel) tbPesquisarVendedor.getModel();
						model.setNumRows(0);
						spPesquisarVendedor.setVisible(false);
						btnEditarPesquisarVendedor.setVisible(false);

						tipoSalvarOuEditarVendedor = false;

						btnCadastrarVendedor.setText("Editar");

						lblCadastroDeVendedor.setText("EDITAR DE VENDEDOR");

						btnExcluirVendedor.setVisible(true);

						spPesquisarVendedor.setVisible(false);

						cardlayout.show(pnlCliente, "Cadastro Vendedor");

					} else {

						/*
						 * btnEditarPesquisarVendedor.setVisible(false);
						 * spPesquisarVendedor.setVisible(false);
						 * 
						 * cardlayout.show(pnlCliente, "Inicial");
						 */

					}

				}

			}
		});
		btnEditarPesquisarVendedor.setBounds(465, 388, 89, 23);
		pesquisaEditarVendedorPanel.add(btnEditarPesquisarVendedor);

		JButton btnCancelarEditarVendedor = new JButton("Cancelar");
		btnCancelarEditarVendedor.setMnemonic('c');
		btnCancelarEditarVendedor.setToolTipText("Cancelar");
		btnCancelarEditarVendedor
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnCancelarEditarVendedor.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnCancelarEditarVendedor.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelarEditarVendedor.setContentAreaFilled(false);
		btnCancelarEditarVendedor.setForeground(Color.WHITE);
		btnCancelarEditarVendedor.setBorder(null);
		btnCancelarEditarVendedor.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnCancelarEditarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) tbPesquisarVendedor.getModel();
				model.setNumRows(0);

				btnEditarPesquisarVendedor.setVisible(false);
				spPesquisarVendedor.setVisible(false);

				cardlayout.show(pnlCliente, "Inicial");

			}
		});
		btnCancelarEditarVendedor.setBounds(870, 420, 83, 23);
		pesquisaEditarVendedorPanel.add(btnCancelarEditarVendedor);

		JLabel lblEditarVendedor = new JLabel("PESQUISAR VENDEDOR");
		lblEditarVendedor.setForeground(new Color(0, 0, 205));
		lblEditarVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarVendedor.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblEditarVendedor.setBounds(13, 0, 994, 30);
		pesquisaEditarVendedorPanel.add(lblEditarVendedor);

		JPanel cadastroProdutoPanel = new JPanel();
		cadastroProdutoPanel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnCadastroProdutoSalvar);
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnSelecionar);
				
			}
		});
		cadastroProdutoPanel.setBackground(Color.WHITE);
		cadastroProdutoPanel.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlCliente.add(cadastroProdutoPanel, "Produto");
		cadastroProdutoPanel.setLayout(null);
		cadastroProdutoPanel.setBorder(new LineBorder(new Color(0, 0, 205), 2));

		JButton btnCadastroProdutoCandelar = new JButton("Cancelar");
		btnCadastroProdutoCandelar.setToolTipText("Cancelar");
		btnCadastroProdutoCandelar.setMnemonic('c');
		btnCadastroProdutoCandelar
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnCadastroProdutoCandelar.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnCadastroProdutoCandelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCadastroProdutoCandelar.setForeground(Color.WHITE);
		btnCadastroProdutoCandelar.setContentAreaFilled(false);
		btnCadastroProdutoCandelar.setBorder(new LineBorder(new Color(0, 0, 205)));
		btnCadastroProdutoCandelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnCadastroProdutoSalvar.setText("Salvar");
				btnExcluirCadastroProduto.setVisible(false);
				lblCadastroDeProduto.setText("CADASTRO DE PRODUTO");
				tipoSalvarOuEditarProduto = true;
				cbSetorDoServico.setSelectedIndex(0);
				tfCodigoDoProduto.setText("");

				LimparCadastroProdutoPanel();

				cardlayout.show(pnlCliente, "Inicial");

			}
		});
		btnCadastroProdutoCandelar.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnCadastroProdutoCandelar.setBounds(660, 308, 83, 23);
		cadastroProdutoPanel.add(btnCadastroProdutoCandelar);

		tfNomeDoProduto = new JTextField();
		tfNomeDoProduto.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfNomeDoProduto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfNomeDoProduto.setColumns(10);
		tfNomeDoProduto.setBounds(277, 100, 466, 21);
		cadastroProdutoPanel.add(tfNomeDoProduto);

		JLabel lblNomeProduto = new JLabel("Nome do Produto");
		lblNomeProduto.setForeground(new Color(0, 0, 205));
		lblNomeProduto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNomeProduto.setBounds(277, 81, 456, 14);
		cadastroProdutoPanel.add(lblNomeProduto);

		JLabel lblCodigoDoProduto = new JLabel("C\u00F3d. do Produto");
		lblCodigoDoProduto.setForeground(new Color(0, 0, 205));
		lblCodigoDoProduto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblCodigoDoProduto.setBounds(524, 132, 97, 14);
		cadastroProdutoPanel.add(lblCodigoDoProduto);

		JLabel lblValorUnitarioDoProduto = new JLabel("Valor Unit\u00E1rio");
		lblValorUnitarioDoProduto.setForeground(new Color(0, 0, 205));
		lblValorUnitarioDoProduto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblValorUnitarioDoProduto.setBounds(642, 132, 101, 14);
		cadastroProdutoPanel.add(lblValorUnitarioDoProduto);

		tfValorUnitarioSugerido = new JNumberFormatField(new DecimalFormat("R$ 0.00"));
		tfValorUnitarioSugerido.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfValorUnitarioSugerido.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfValorUnitarioSugerido.setColumns(10);
		tfValorUnitarioSugerido.setBounds(642, 151, 100, 21);
		cadastroProdutoPanel.add(tfValorUnitarioSugerido);

		btnCadastroProdutoSalvar = new JButton("Salvar");
		btnCadastroProdutoSalvar.setMnemonic('s');
		btnCadastroProdutoSalvar.setToolTipText("Salvar Produto");
		btnCadastroProdutoSalvar
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnCadastroProdutoSalvar.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnCadastroProdutoSalvar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCadastroProdutoSalvar.setForeground(Color.WHITE);
		btnCadastroProdutoSalvar.setContentAreaFilled(false);
		btnCadastroProdutoSalvar.setBorder(new LineBorder(new Color(0, 0, 205)));
		btnCadastroProdutoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tfNomeDoProduto.getText() == null || tfNomeDoProduto.getText().trim().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite o nome do produto", "Cadastro do Produto",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (cbSetorDoServico.getSelectedItem().equals("SELECIONE...")) {

					JOptionPane.showMessageDialog(null, "Selecione o setor da empresa", "Cadastro do Produto",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (tpDescricaoProdutoDoServico.getText() == null
						|| tpDescricaoProdutoDoServico.getText().trim().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite a descrição do produto", "Cadastro do Produto",
							JOptionPane.INFORMATION_MESSAGE);

				} else {

					if (tipoSalvarOuEditarProduto == false) {

						String vu = tfValorUnitarioSugerido.getText().replace("R$ ", "");

						double valorUnitario = Double.valueOf(vu.replace(",", "."));

						ProdutoDoServico produtoTemp = new ProdutoDoServico();

						produtoTemp.setId_produtoDoServico(produtoDoServico.getId_produtoDoServico());
						produtoTemp.setNomeDoProduto(tfNomeDoProduto.getText().toUpperCase());
						produtoTemp.setSetorProdutoDoServico(
								String.valueOf(cbSetorDoServico.getSelectedItem()).toUpperCase());
						produtoTemp.setCodProdutoDoServico(tfCodigoDoProduto.getText().toUpperCase());
						produtoTemp.setValorUnitarioDoProduto(valorUnitario);
						produtoTemp.setDescricaorodutoDoServico(tpDescricaoProdutoDoServico.getText().toUpperCase());

						if (produtoTemp.toString().equals(produtoDoServico.toString())) {

							JOptionPane.showMessageDialog(null, "Não foi feita nenhuma alteração", "Editar Produto",
									JOptionPane.INFORMATION_MESSAGE);

							btnCadastroProdutoSalvar.setText("Salvar");

							btnExcluirCadastroProduto.setVisible(false);

							lblCadastroDeProduto.setText("CADASTRO DE PRODUTO");

							cardlayout.show(pnlCliente, "Inicial");

							LimparCadastroProdutoPanel();

							tipoSalvarOuEditarProduto = true;

						} else {

							boolean sucesso = false;

							ProdutoDoServicoController produtoDoServicoController = new ProdutoDoServicoController();
							sucesso = produtoDoServicoController.editarProdutoDoServico(produtoTemp);

							if (sucesso) {

								LogSegurancaController.novoLogSeguranca("PRODUTO EDITADO");

								JOptionPane.showMessageDialog(null, "Produto editado", "Editar Produto",
										JOptionPane.INFORMATION_MESSAGE);

								btnCadastroProdutoSalvar.setText("Salvar");

								btnExcluirCadastroProduto.setVisible(false);

								lblCadastroDeProduto.setText("CADASTRO DE PRODUTO");

								cardlayout.show(pnlCliente, "Inicial");

								LimparCadastroProdutoPanel();

								atualizarProduto();

								tipoSalvarOuEditarProduto = true;

							} else {

								LogSegurancaController.novoLogSeguranca("PRODUTO NÃO EDITADO");

								JOptionPane.showMessageDialog(null, "Produto não editado", "Editar Produto",
										JOptionPane.INFORMATION_MESSAGE);

								btnCadastroProdutoSalvar.setText("Salvar");

								btnExcluirCadastroProduto.setVisible(false);

								lblCadastroDeProduto.setText("CADASTRO DE PRODUTO");

								cardlayout.show(pnlCliente, "Inicial");

								LimparCadastroProdutoPanel();

								tipoSalvarOuEditarProduto = true;

							}

						}

					} else {

						boolean sucesso = false;

						String vu = tfValorUnitarioSugerido.getText().replace("R$ ", "");

						double valorUnitario = Double.valueOf(vu.replace(",", "."));

						ProdutoDoServico produtoTemp = new ProdutoDoServico();

						produtoTemp.setNomeDoProduto(tfNomeDoProduto.getText().toUpperCase());
						produtoTemp.setSetorProdutoDoServico(
								String.valueOf(cbSetorDoServico.getSelectedItem()).toUpperCase());
						produtoTemp.setCodProdutoDoServico(tfCodigoDoProduto.getText().toUpperCase());
						produtoTemp.setValorUnitarioDoProduto(valorUnitario);
						produtoTemp.setDescricaorodutoDoServico(tpDescricaoProdutoDoServico.getText().toUpperCase());

						ProdutoDoServicoController produtoDoServicoController = new ProdutoDoServicoController();
						sucesso = produtoDoServicoController.cadastrarProdutoDoServico(produtoTemp);

						if (sucesso) {

							LogSegurancaController.novoLogSeguranca("PRODUTO SALVO");

							JOptionPane.showMessageDialog(null, "Produto salvo", "Cadastro do Produto",
									JOptionPane.INFORMATION_MESSAGE);

							cardlayout.show(pnlCliente, "Inicial");

							atualizarProduto();

							LimparCadastroProdutoPanel();

						} else {

							LogSegurancaController.novoLogSeguranca("ERRO AO SALVAR O PRODUTO");

							JOptionPane.showMessageDialog(null, "Erro ao salvar o produto", "Cadastro do Produto",
									JOptionPane.ERROR_MESSAGE);

							cardlayout.show(pnlCliente, "Inicial");

							LimparCadastroProdutoPanel();
						}

					}

				}

			}
		});
		btnCadastroProdutoSalvar.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnCadastroProdutoSalvar.setBounds(470, 308, 83, 23);
		cadastroProdutoPanel.add(btnCadastroProdutoSalvar);

		JLabel lblSetorDoProduto = new JLabel("Setor da Empresa");
		lblSetorDoProduto.setForeground(new Color(0, 0, 205));
		lblSetorDoProduto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblSetorDoProduto.setBounds(277, 132, 179, 14);
		cadastroProdutoPanel.add(lblSetorDoProduto);

		cbSetorDoServico = new JComboBox<String>();
		cbSetorDoServico.setBorder(new LineBorder(new Color(0, 0, 205)));

		SetorDaEmpresaController setorDaEmpresaController = new SetorDaEmpresaController();
		listaSetorDaEmpresa = setorDaEmpresaController.listaSetorDaEmpresa();

		cbSetorDoServico.addItem("SELECIONE...");

		for (SetorDaEmpresa sde : listaSetorDaEmpresa) {

			cbSetorDoServico.addItem(sde.getNomeDoSetorDaEmpresa().toUpperCase());

		}

		cbSetorDoServico.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		cbSetorDoServico.setBounds(277, 151, 155, 21);
		cadastroProdutoPanel.add(cbSetorDoServico);

		lblCadastroDeProduto = new JLabel("CADASTRO DE PRODUTO");
		lblCadastroDeProduto.setForeground(new Color(0, 0, 205));
		lblCadastroDeProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProduto.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblCadastroDeProduto.setBounds(13, 0, 994, 30);
		cadastroProdutoPanel.add(lblCadastroDeProduto);

		JScrollPane spDescricaoProdutoDoServico = new JScrollPane();
		spDescricaoProdutoDoServico.setForeground(new Color(0, 0, 205));
		spDescricaoProdutoDoServico.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		spDescricaoProdutoDoServico.setBorder(new LineBorder(new Color(0, 0, 205)));
		spDescricaoProdutoDoServico.setBounds(277, 205, 466, 89);
		cadastroProdutoPanel.add(spDescricaoProdutoDoServico);

		tpDescricaoProdutoDoServico = new JTextPane();
		tpDescricaoProdutoDoServico.setLocation(278, 0);
		tpDescricaoProdutoDoServico.setForeground(new Color(255, 0, 0));
		tpDescricaoProdutoDoServico.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tpDescricaoProdutoDoServico.setBorder(null);
		tpDescricaoProdutoDoServico.setText("");
		spDescricaoProdutoDoServico.setViewportView(tpDescricaoProdutoDoServico);

		JLabel lblDescrioDoProduto = new JLabel("Descri\u00E7\u00E3o do Produto");
		lblDescrioDoProduto.setForeground(new Color(0, 0, 205));
		lblDescrioDoProduto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblDescrioDoProduto.setBounds(277, 187, 456, 14);
		cadastroProdutoPanel.add(lblDescrioDoProduto);

		tfCodigoDoProduto = new JTextField();
		tfCodigoDoProduto.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfCodigoDoProduto.setBackground(Color.WHITE);
		tfCodigoDoProduto.setDisabledTextColor(Color.WHITE);
		tfCodigoDoProduto.setEditable(false);
		tfCodigoDoProduto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfCodigoDoProduto.setColumns(10);
		tfCodigoDoProduto.setBounds(524, 151, 101, 21);
		cadastroProdutoPanel.add(tfCodigoDoProduto);

		JButton btnConfSetorEmpresa = new JButton("");
		btnConfSetorEmpresa.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/config.png")));
		btnConfSetorEmpresa.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConfSetorEmpresa.setForeground(Color.WHITE);
		btnConfSetorEmpresa.setContentAreaFilled(false);
		btnConfSetorEmpresa.setBorder(null);
		btnConfSetorEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (cbSetorDoServico.getSelectedItem().equals("SELECIONE...")) {

					JOptionPane.showMessageDialog(null, "Para configurar selecione um setor", "Configurar setor",
							JOptionPane.INFORMATION_MESSAGE);

				} else {

					SetorDaEmpresaController setorDaEmpresaController = new SetorDaEmpresaController();
					id_setorDaEmpresa = setorDaEmpresaController
							.pesquisarSetorDaEmpresa(String.valueOf(cbSetorDoServico.getSelectedItem()).toUpperCase());

					tfSetorDaEmpresa
							.setText(String.valueOf(cbSetorDoServico.getSelectedItem()).toUpperCase().toUpperCase());

					cardlayout.show(pnlCliente, "Setor");

				}

			}
		});

		cbSetorDoServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String setor = "";

				if (cbSetorDoServico.getSelectedItem() != null) {

					setor = String.valueOf(cbSetorDoServico.getSelectedItem().toString().substring(0, 3));

				} else {

					atualizarSetorServico();

					setor = String.valueOf(cbSetorDoServico.getSelectedItem().toString().substring(0, 3));
				}

				if (!cbSetorDoServico.getSelectedItem().equals("SELECIONE...")) {

					DecimalFormat idProduto6dig = new DecimalFormat("000");
					String codigo = new ProdutoDoServicoController().buscarCodigo(setor);

					int cod = 0;

					if (!codigo.equals("")) {

						cod = Integer.parseInt(codigo.substring(3, 6));
						tfCodigoDoProduto.setText(setor + idProduto6dig.format((cod + 1)));

					} else {

						tfCodigoDoProduto.setText(setor + idProduto6dig.format((1)));

					}

				} else {

					tfCodigoDoProduto.setText("");

				}

			}
		});

		btnConfSetorEmpresa.setToolTipText("Add, Editar e Excluir Setor");
		btnConfSetorEmpresa.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnConfSetorEmpresa.setBounds(452, 150, 55, 23);
		cadastroProdutoPanel.add(btnConfSetorEmpresa);

		btnExcluirCadastroProduto = new JButton("Excluir");
		btnExcluirCadastroProduto.setToolTipText("Excluir Produto");
		btnExcluirCadastroProduto.setMnemonic('e');
		btnExcluirCadastroProduto
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnExcluirCadastroProduto.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnExcluirCadastroProduto.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExcluirCadastroProduto.setForeground(Color.WHITE);
		btnExcluirCadastroProduto.setContentAreaFilled(false);
		btnExcluirCadastroProduto.setBorder(new LineBorder(new Color(0, 0, 205)));
		btnExcluirCadastroProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o produto?", "Excluir produto",
						JOptionPane.YES_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {

					ProdutoDoServicoController produtoDoServicoController = new ProdutoDoServicoController();
					boolean sucesso = produtoDoServicoController
							.excluirProdutoDoServico(produtoDoServico.getId_produtoDoServico());

					if (sucesso == true) {

						LogSegurancaController.novoLogSeguranca("PRODUTO EXCLUÍDO");

						JOptionPane.showMessageDialog(null, "Produto excluído", "Excluir produto",
								JOptionPane.INFORMATION_MESSAGE);

						LimparCadastroProdutoPanel();

						atualizarProduto();

						lblCadastroDeProduto.setText("CADASTRO DE PRODUTO");

						btnExcluirCadastroProduto.setVisible(false);

						cardlayout.show(pnlCliente, "Inicial");

						tipoSalvarOuEditarProduto = true;

					} else {

						LogSegurancaController.novoLogSeguranca("O PRODUTO NÃO FOI EXCLUÍDO");

						JOptionPane.showMessageDialog(null, "O produto não foi excluído", "Excluir vendedor",
								JOptionPane.WARNING_MESSAGE);

						limparVendedorPanel();

						lblCadastroDeVendedor.setText("CADASTRO DE PRODUTO");

						btnExcluirVendedor.setVisible(false);

						cardlayout.show(pnlCliente, "Inicial");

						tipoSalvarOuEditarProduto = true;

					}

				}

				btnExcluirVendedor.setVisible(false);

			}
		});
		btnExcluirCadastroProduto.setVisible(false);
		btnExcluirCadastroProduto.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnExcluirCadastroProduto.setBounds(277, 309, 83, 23);
		cadastroProdutoPanel.add(btnExcluirCadastroProduto);

		JPanel pesquisaEditarProdutoClientePanel = new JPanel();
		pesquisaEditarProdutoClientePanel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnPesquisarEditarProduto);
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnSelecionar);
				
			}
		});
		pesquisaEditarProdutoClientePanel.setBackground(Color.WHITE);
		pesquisaEditarProdutoClientePanel.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		pesquisaEditarProdutoClientePanel.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlCliente.add(pesquisaEditarProdutoClientePanel, "EditarProduto");
		pesquisaEditarProdutoClientePanel.setLayout(null);

		tfPesquisarEditarProduto = new JTextField();
		tfPesquisarEditarProduto.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfPesquisarEditarProduto.requestFocus();
		tfPesquisarEditarProduto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				getRootPane().setDefaultButton(btnPesquisarEditarProduto);
				cbCliente.setSelectedIndex(0);

			}
		});
		tfPesquisarEditarProduto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		tfPesquisarEditarProduto.setColumns(10);
		tfPesquisarEditarProduto.setBounds(317, 101, 273, 23);
		pesquisaEditarProdutoClientePanel.add(tfPesquisarEditarProduto);

		btnPesquisarEditarProduto = new JButton("Pesquisar");
		btnPesquisarEditarProduto.setMnemonic('p');
		btnPesquisarEditarProduto.setToolTipText("Pesquisar Produto");
		btnPesquisarEditarProduto
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnPesquisarEditarProduto.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnPesquisarEditarProduto.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPesquisarEditarProduto.setContentAreaFilled(false);
		btnPesquisarEditarProduto.setForeground(Color.WHITE);
		btnPesquisarEditarProduto.setBorder(null);
		btnPesquisarEditarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tfPesquisarEditarProduto.getText() == null
						|| tfPesquisarEditarProduto.getText().trim().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite o nome do produto", "Pesquisar Produto",
							JOptionPane.INFORMATION_MESSAGE);

					tfPesquisarEditarProduto.requestFocus();
					spPesquisarProduto.setVisible(false);
					btnEditarProduto.setVisible(false);

				} else {

					ProdutoDoServicoController produtoDoServicoController = new ProdutoDoServicoController();

					listaPesquisaProduto = produtoDoServicoController
							.buscaProduto(tfPesquisarEditarProduto.getText().toUpperCase());

					if (listaPesquisaProduto.isEmpty()) {

						JOptionPane.showMessageDialog(null, "A pesquisa não obteve resultado", "Pesquisar Produto",
								JOptionPane.INFORMATION_MESSAGE);

						tfPesquisarEditarProduto.setText("");
						spPesquisarProduto.setVisible(false);
						btnEditarProduto.setVisible(false);

					} else {

						spPesquisarProduto.setVisible(true);
						btnEditarProduto.setVisible(true);
						tfPesquisarEditarProduto.setText("");

						DefaultTableModel model = (DefaultTableModel) tbPesquisarProduto.getModel();
						model.setNumRows(0);

						for (ProdutoDoServico pds : listaPesquisaProduto) {

							Object[] linha = { pds.getNomeDoProduto() };

							model.addRow(linha);

						}

					}

				}

			}
		});
		btnPesquisarEditarProduto.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnPesquisarEditarProduto.setBounds(614, 101, 89, 24);
		pesquisaEditarProdutoClientePanel.add(btnPesquisarEditarProduto);

		JButton btnCancelarEditarProduto = new JButton("Cancelar");
		btnCancelarEditarProduto.setToolTipText("Cancelar");
		btnCancelarEditarProduto.setMnemonic('c');
		btnCancelarEditarProduto.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelarEditarProduto
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnCancelarEditarProduto.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnCancelarEditarProduto.setForeground(Color.WHITE);
		btnCancelarEditarProduto.setBorder(null);
		btnCancelarEditarProduto.setContentAreaFilled(false);
		btnCancelarEditarProduto.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnCancelarEditarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cardlayout.show(pnlCliente, "Inicial");

				LimparCadastroProdutoPanel();

			}
		});
		btnCancelarEditarProduto.setBounds(870, 420, 83, 23);
		pesquisaEditarProdutoClientePanel.add(btnCancelarEditarProduto);

		JLabel lblEditarProduto = new JLabel("PESQUISAR PRODUTO");
		lblEditarProduto.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEditarProduto.setForeground(new Color(0, 0, 205));
		lblEditarProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarProduto.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblEditarProduto.setBounds(13, 0, 994, 25);
		pesquisaEditarProdutoClientePanel.add(lblEditarProduto);

		spPesquisarProduto = new JScrollPane();
		spPesquisarProduto.setForeground(new Color(0, 0, 205));
		spPesquisarProduto.setVisible(false);
		spPesquisarProduto.setBorder(new LineBorder(new Color(0, 0, 205)));
		spPesquisarProduto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		spPesquisarProduto.setBounds(317, 162, 386, 206);
		pesquisaEditarProdutoClientePanel.add(spPesquisarProduto);

		tbPesquisarProduto = new JTable();
		tbPesquisarProduto.setGridColor(new Color(0, 0, 205));
		tbPesquisarProduto.setForeground(new Color(0, 0, 205));
		tbPesquisarProduto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				getRootPane().setDefaultButton(btnEditarProduto);

			}

			@Override
			public void focusLost(FocusEvent e) {

				getRootPane().setDefaultButton(btnSelecionar);

			}
		});
		tbPesquisarProduto.setBorder(new LineBorder(new Color(0, 0, 205)));
		tbPesquisarProduto.setDefaultRenderer(Object.class, new TabLinhasPesquisa());
		tbPesquisarProduto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tbPesquisarProduto.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "PRODUTO" }));
		spPesquisarProduto.setViewportView(tbPesquisarProduto);

		btnEditarProduto = new JButton("Editar");
		btnEditarProduto.setToolTipText("Editar Produto");
		btnEditarProduto.setMnemonic('e');
		btnEditarProduto.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditarProduto.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnEditarProduto.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnEditarProduto.setContentAreaFilled(false);
		btnEditarProduto.setForeground(Color.WHITE);
		btnEditarProduto.setBorder(null);
		btnEditarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int posicao = tbPesquisarProduto.getSelectedRow();

				if (tbPesquisarProduto.getSelectedRow() == -1) {

					JOptionPane.showMessageDialog(null, "Selecione o produto que quer editar", "Pesquisar Produto",
							JOptionPane.INFORMATION_MESSAGE);

				} else {

					int resposta = 0;

					resposta = JOptionPane.showConfirmDialog(null, "Você deseja editar o produto selecionado?",
							"Pesquisar Produto", JOptionPane.YES_NO_OPTION);

					if (resposta == 0) {

						ProdutoDoServicoController produtoDoServicoController = new ProdutoDoServicoController();

						int id_produtoDoServico = listaPesquisaProduto.get(posicao).getId_produtoDoServico();

						produtoDoServico = produtoDoServicoController.buscaProdutoDoServico(id_produtoDoServico);

						tfNomeDoProduto.setText(produtoDoServico.getNomeDoProduto().toUpperCase());
						cbSetorDoServico.setSelectedItem(produtoDoServico.getSetorProdutoDoServico().toUpperCase());
						tfCodigoDoProduto.setText(produtoDoServico.getCodProdutoDoServico());
						tfValorUnitarioSugerido
								.setText(String.valueOf(produtoDoServico.getValorUnitarioDoProduto()) + 00);
						tpDescricaoProdutoDoServico.setText(produtoDoServico.getDescricaorodutoDoServico());

						DefaultTableModel model = (DefaultTableModel) tbPesquisarProduto.getModel();
						model.setNumRows(0);

						spPesquisarProduto.setVisible(false);
						btnEditarProduto.setVisible(false);

						tipoSalvarOuEditarProduto = false;

						lblCadastroDeProduto.setText("EDITAR O PRODUTO");

						btnCadastroProdutoSalvar.setText("Editar");

						btnExcluirCadastroProduto.setVisible(true);

						spPesquisarProduto.setVisible(false);

						cardlayout.show(pnlCliente, "Produto");

					} else {

						/*
						 * cardlayout.show(pnlCliente, "Inicial");
						 * 
						 * LimparCadastroProdutoPanel();
						 */

					}

				}

			}
		});
		btnEditarProduto.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnEditarProduto.setVisible(false);
		btnEditarProduto.setBounds(465, 388, 89, 23);
		pesquisaEditarProdutoClientePanel.add(btnEditarProduto);

		JPanel novoLembretePanel = new JPanel();
		novoLembretePanel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnNovoLembrete);
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnSelecionar);
			}
		});
		novoLembretePanel.setBackground(Color.WHITE);
		novoLembretePanel.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		pnlCliente.add(novoLembretePanel, "novoLembrete");
		novoLembretePanel.setLayout(null);

		btnNovoLembrete = new JButton("Salvar");
		btnNovoLembrete.setToolTipText("Salvar Lembrete");
		btnNovoLembrete.setMnemonic('s');
		btnNovoLembrete.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnNovoLembrete.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnNovoLembrete.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNovoLembrete.setBorder(null);
		btnNovoLembrete.setForeground(Color.WHITE);
		btnNovoLembrete.setContentAreaFilled(false);
		btnNovoLembrete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cbVendedorDestinatario.getSelectedIndex() == 0) {

					JOptionPane.showMessageDialog(null, "Selecione o vendedor", "Novo Lembrete",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (tfAssuntoLembrete.getText() == null || tfAssuntoLembrete.getText().trim().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite o assunto", "Novo Lembrete",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (tpDescricaoLembrete.getText() == null || tpDescricaoLembrete.getText().trim().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite a descrição do lembrete", "Novo Lembrete",
							JOptionPane.INFORMATION_MESSAGE);

				} else {

					boolean sucesso = false;
					Lembrete lembrete = new Lembrete();

					Date DataDoLembrete = new Date(System.currentTimeMillis());

					int numero = cbVendedorDestinatario.getSelectedIndex() - 1;
					int id_vendedor = listaVendedores.get(numero).getId_vendedor();

					lembrete.setId_vendedor(id_vendedor);
					lembrete.setAutor(LoginComercialView.getVendedor().getLogin().toUpperCase());
					lembrete.setAssunto(tfAssuntoLembrete.getText().toUpperCase());
					lembrete.setDescricao(tpDescricaoLembrete.getText().toUpperCase());
					lembrete.setDataDoLembrete(DataDoLembrete);

					LembreteController lembreteController = new LembreteController();
					sucesso = lembreteController.novoLembrete(lembrete);

					if (sucesso) {

						LogSegurancaController.novoLogSeguranca("NOVO LEMBRETE");

						JOptionPane.showMessageDialog(null, "Lembrete salvo", "Novo Lembrete",
								JOptionPane.INFORMATION_MESSAGE);

						LoginComercialView.setListaLembreteVendedor(
								lembreteController.lembreteVendedor(LoginComercialView.getVendedor().getId_vendedor()));

						int id = 1;

						DefaultTableModel model = (DefaultTableModel) getTbLembrete().getModel();
						model.setNumRows(0);

						DateFormat formatBR = new SimpleDateFormat("dd-MM-YYYY");
						String dataBR = "";

						for (Lembrete l : LoginComercialView.getListaLembreteVendedor()) {

							NumberFormat tresDigitos = new DecimalFormat("000");
							dataBR = formatBR.format(l.getDataDoLembrete());

							Object[] linha = { tresDigitos.format(id), l.getAutor(), l.getAssunto(), dataBR };

							model.addRow(linha);

							id++;

						}

						if (!LoginComercialView.getListaLembreteVendedor().isEmpty()) {

							lblDescricaoLembrete.setVisible(true);
							lblLembreteFoto.setVisible(false);
							spLembrete.setVisible(true);
							spDescricaoRecado.setVisible(true);
							btnApagarLembrete.setVisible(true);

						}

						tpDescricaoRecado.setText("");

						limparLembretePanel();
						cardlayout.show(pnlCliente, "Inicial");

					} else {

						LogSegurancaController.novoLogSeguranca("ERRO LEMBRETE");

						JOptionPane.showMessageDialog(null, "O lembrete não foi salvo", "Novo Lembrete",
								JOptionPane.ERROR_MESSAGE);

						limparLembretePanel();
						cardlayout.show(pnlCliente, "Inicial");

					}

				}

			}
		});
		btnNovoLembrete.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnNovoLembrete.setBounds(525, 312, 89, 23);
		novoLembretePanel.add(btnNovoLembrete);

		JButton btnCancelarLembrete = new JButton("Cancelar");
		btnCancelarLembrete.setToolTipText("Cancelar");
		btnCancelarLembrete.setMnemonic('c');
		btnCancelarLembrete
				.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnCancelarLembrete.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnCancelarLembrete.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelarLembrete.setBorder(null);
		btnCancelarLembrete.setForeground(Color.WHITE);
		btnCancelarLembrete.setContentAreaFilled(false);
		btnCancelarLembrete.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnCancelarLembrete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limparLembretePanel();
				cardlayout.show(pnlCliente, "Inicial");

			}
		});
		btnCancelarLembrete.setBounds(624, 312, 89, 23);
		novoLembretePanel.add(btnCancelarLembrete);

		cbVendedorDestinatario = new JComboBox<String>();
		cbVendedorDestinatario.setBorder(new LineBorder(new Color(0, 0, 205)));
		cbVendedorDestinatario.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		cbVendedorDestinatario.setBounds(307, 135, 182, 22);
		novoLembretePanel.add(cbVendedorDestinatario);

		listaVendedores = vendedorController.listaVendedor();

		cbVendedorDestinatario.addItem("SELECIONE...");

		for (Vendedor v : listaVendedores) {

			if (!v.getNome().equalsIgnoreCase("NESOLUTION")) {

				cbVendedorDestinatario.addItem(v.getNome());

			}

		}

		tfAssuntoLembrete = new JTextField();
		tfAssuntoLembrete.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfAssuntoLembrete.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		tfAssuntoLembrete.setBounds(499, 136, 214, 20);
		novoLembretePanel.add(tfAssuntoLembrete);
		tfAssuntoLembrete.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Destinat\u00E1rio");
		lblNewLabel_1.setForeground(new Color(0, 0, 205));
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(307, 118, 182, 14);
		novoLembretePanel.add(lblNewLabel_1);

		JLabel lblAssuntoLembrete = new JLabel("Assunto");
		lblAssuntoLembrete.setForeground(new Color(0, 0, 205));
		lblAssuntoLembrete.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblAssuntoLembrete.setBounds(499, 118, 214, 14);
		novoLembretePanel.add(lblAssuntoLembrete);

		JScrollPane spDescricaoLembrete = new JScrollPane();
		spDescricaoLembrete.setBorder(null);
		spDescricaoLembrete.setFont(new Font("Arial", Font.PLAIN, 11));
		spDescricaoLembrete.setBounds(307, 205, 406, 82);
		novoLembretePanel.add(spDescricaoLembrete);

		tpDescricaoLembrete = new JTextPane();
		tpDescricaoLembrete.setBorder(new LineBorder(new Color(0, 0, 205)));
		tpDescricaoLembrete.setForeground(Color.RED);
		tpDescricaoLembrete.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		spDescricaoLembrete.setViewportView(tpDescricaoLembrete);

		JLabel lblNovoLembrete = new JLabel("NOVO LEMBRETE");
		lblNovoLembrete.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNovoLembrete.setForeground(new Color(0, 0, 205));
		lblNovoLembrete.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoLembrete.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblNovoLembrete.setBounds(13, 0, 994, 26);
		novoLembretePanel.add(lblNovoLembrete);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setForeground(new Color(0, 0, 205));
		lblDescrio.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblDescrio.setBounds(307, 188, 214, 14);
		novoLembretePanel.add(lblDescrio);

		JPanel cadastroSetorPanel = new JPanel();
		cadastroSetorPanel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnNovoSetor);
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
				
				getRootPane().setDefaultButton(btnSelecionar);
				
			}
		});
		cadastroSetorPanel.setBackground(Color.WHITE);
		cadastroSetorPanel.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		cadastroSetorPanel.setFont(new Font("Arial", Font.PLAIN, 16));
		pnlCliente.add(cadastroSetorPanel, "Setor");
		cadastroSetorPanel.setLayout(null);

		JLabel lblCadastroDeSetor = new JLabel("CADASTRO DE SETOR");
		lblCadastroDeSetor.setForeground(new Color(0, 0, 205));
		lblCadastroDeSetor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeSetor.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblCadastroDeSetor.setBounds(13, 0, 994, 30);
		cadastroSetorPanel.add(lblCadastroDeSetor);

		btnNovoSetor = new JButton("Novo");
		btnNovoSetor.setToolTipText("Novo Setor");
		btnNovoSetor.setMnemonic('n');
		btnNovoSetor.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnNovoSetor.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNovoSetor.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnNovoSetor.setBorder(null);
		btnNovoSetor.setContentAreaFilled(false);
		btnNovoSetor.setForeground(Color.WHITE);
		btnNovoSetor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (btnNovoSetor.getText().equalsIgnoreCase("Novo")) {

					tfSetorDaEmpresa.setEditable(true);
					tfSetorDaEmpresa.setBackground(Color.WHITE);
					tfSetorDaEmpresa.setText("");
					btnNovoSetor.setText("Salvar");
					btnEditarSetor.setEnabled(false);
					btnExcluirSetor.setEnabled(false);

				} else if (tfSetorDaEmpresa.getText().length() < 3) {

					JOptionPane.showMessageDialog(null, "O setor deve no mínimo 03 caracteres", "Configurar setor",
							JOptionPane.INFORMATION_MESSAGE);
					tfSetorDaEmpresa.setText("");
					tfSetorDaEmpresa.requestFocus();

				} else {

					int resposta = JOptionPane.showConfirmDialog(null, "Deseja adicionar um novo setor?",
							"Configurar setor", JOptionPane.OK_OPTION);

					if (resposta == JOptionPane.OK_OPTION) {

						SetorDaEmpresaController setorDaEmpresaController = new SetorDaEmpresaController();

						SetorDaEmpresa setorDaEmpresa = new SetorDaEmpresa();
						setorDaEmpresa.setNomeDoSetorDaEmpresa(tfSetorDaEmpresa.getText().toUpperCase());
						boolean sucesso = setorDaEmpresaController.novoSetorDaEmpresa(setorDaEmpresa);

						if (sucesso) {

							LogSegurancaController.novoLogSeguranca("SETOR SALVO");

							JOptionPane.showMessageDialog(null, "Setor salvo!", "Configurar setor",
									JOptionPane.INFORMATION_MESSAGE);

							tfSetorDaEmpresa.setEditable(false);
							tfSetorDaEmpresa.setBackground(Color.YELLOW);
							btnNovoSetor.setText("Novo");
							btnEditarSetor.setEnabled(true);
							btnExcluirSetor.setEnabled(true);

							cbSetorDoServico.removeAllItems();

							cbSetorDoServico.setSelectedIndex(0);

							cardlayout.show(pnlCliente, "Produto");

						} else {

							LogSegurancaController.novoLogSeguranca("ERRO AO SALVAR");

							JOptionPane.showMessageDialog(null, "Erro ao salvar o setor!", "Configurar setor",
									JOptionPane.INFORMATION_MESSAGE);

							tfSetorDaEmpresa.setEditable(false);
							tfSetorDaEmpresa.setBackground(Color.YELLOW);
							btnNovoSetor.setText("Novo");
							btnEditarSetor.setEnabled(true);
							btnExcluirSetor.setEnabled(true);

							cardlayout.show(pnlCliente, "Produto");

						}

					} else {

						tfSetorDaEmpresa.setEditable(false);
						tfSetorDaEmpresa.setText("");
						btnNovoSetor.setText("Novo");
						btnEditarSetor.setEnabled(true);
						btnExcluirSetor.setEnabled(true);

					}

				}

			}
		});
		btnNovoSetor.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnNovoSetor.setBounds(335, 183, 80, 23);
		cadastroSetorPanel.add(btnNovoSetor);

		btnExcluirSetor = new JButton("Excluir");
		btnExcluirSetor.setToolTipText("Excluir Setor");
		btnExcluirSetor.setMnemonic('x');
		btnExcluirSetor.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExcluirSetor.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnExcluirSetor.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnExcluirSetor.setBorder(null);
		btnExcluirSetor.setContentAreaFilled(false);
		btnExcluirSetor.setForeground(Color.WHITE);
		btnExcluirSetor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o setor?", "Configurar setor",
						JOptionPane.OK_OPTION);

				if (resposta == JOptionPane.OK_OPTION) {

					LogSegurancaController.novoLogSeguranca("SETOR EXCLUÍDO");

					SetorDaEmpresaController setorDaEmpresaController = new SetorDaEmpresaController();

					setorDaEmpresaController.excluirSetorDaEmpresa(id_setorDaEmpresa);

					// atualizarCbSetorDoServico();

					cbSetorDoServico.removeAllItems();

					cbSetorDoServico.setSelectedIndex(0);

					cardlayout.show(pnlCliente, "Produto");

				} else {

					LogSegurancaController.novoLogSeguranca("ERRO AO EXCLUÍR O SETOR");

					tfSetorDaEmpresa.setEditable(false);
					tfSetorDaEmpresa.setBackground(Color.YELLOW);
					btnNovoSetor.setEnabled(true);
					btnEditarSetor.setEnabled(true);
					btnExcluirSetor.setEnabled(true);

					cardlayout.show(pnlCliente, "Produto");

				}

			}
		});
		btnExcluirSetor.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnExcluirSetor.setBounds(512, 183, 80, 23);
		cadastroSetorPanel.add(btnExcluirSetor);

		btnEditarSetor = new JButton("Editar");
		btnEditarSetor.setMnemonic('e');
		btnEditarSetor.setToolTipText("Editar Setor");
		btnEditarSetor.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditarSetor.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnEditarSetor.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnEditarSetor.setBorder(null);
		btnEditarSetor.setContentAreaFilled(false);
		btnEditarSetor.setForeground(Color.WHITE);
		btnEditarSetor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String setorTemp = String.valueOf(cbSetorDoServico.getSelectedItem()).toUpperCase();
				tfSetorDaEmpresa.getText();

				if (btnEditarSetor.getText().equalsIgnoreCase("Editar")) {

					tfSetorDaEmpresa.setEditable(true);
					tfSetorDaEmpresa.setBackground(Color.WHITE);
					btnEditarSetor.setText("Salvar");
					btnNovoSetor.setEnabled(false);
					btnExcluirSetor.setEnabled(false);

				} else if (tfSetorDaEmpresa.getText().length() < 3) {

					JOptionPane.showMessageDialog(null, "O setor deve no mínimo 03 caracteres", "Configurar setor",
							JOptionPane.INFORMATION_MESSAGE);

					tfSetorDaEmpresa.requestFocus();

				} else {

					int resposta = JOptionPane.showConfirmDialog(null, "Deseja editar o setor?", "Configurar setor",
							JOptionPane.OK_OPTION);

					if (resposta == JOptionPane.OK_OPTION) {

						if (tfSetorDaEmpresa.getText().equalsIgnoreCase(setorTemp)) {

							JOptionPane.showMessageDialog(null, "Não houve alteração no setor", "Configurar setor",
									JOptionPane.INFORMATION_MESSAGE);

							tfSetorDaEmpresa.setEditable(false);
							tfSetorDaEmpresa.setBackground(Color.YELLOW);
							tfSetorDaEmpresa.setText("");
							btnEditarSetor.setText("Editar");
							btnNovoSetor.setEnabled(true);
							btnEditarSetor.setEnabled(true);
							btnExcluirSetor.setEnabled(true);

							cardlayout.show(pnlCliente, "Produto");

						} else {

							SetorDaEmpresaController setorDaEmpresaController = new SetorDaEmpresaController();
							SetorDaEmpresa setorDaEmpresa = new SetorDaEmpresa();

							setorDaEmpresa.setId_setorDaEmpresa(id_setorDaEmpresa);
							setorDaEmpresa.setNomeDoSetorDaEmpresa(tfSetorDaEmpresa.getText().toUpperCase());

							boolean sucesso = setorDaEmpresaController.editarSetorDaEmpresa(setorDaEmpresa);

							if (sucesso) {

								LogSegurancaController.novoLogSeguranca("SETOR EDITADO");

								JOptionPane.showMessageDialog(null, "Setor editado", "Configurar setor",
										JOptionPane.INFORMATION_MESSAGE);

								tfSetorDaEmpresa.setEditable(false);
								tfSetorDaEmpresa.setBackground(Color.YELLOW);
								btnEditarSetor.setText("Editar");
								btnNovoSetor.setEnabled(true);
								btnExcluirSetor.setEnabled(true);

								cbSetorDoServico.removeAllItems();

								cbSetorDoServico.setSelectedIndex(0);

								cardlayout.show(pnlCliente, "Produto");

							} else {

								LogSegurancaController.novoLogSeguranca("ERRO AO SALVAR O SETOR");

								JOptionPane.showMessageDialog(null, "Erro ao salva o setor", "Configurar setor",
										JOptionPane.INFORMATION_MESSAGE);

								tfSetorDaEmpresa.setEditable(false);
								tfSetorDaEmpresa.setBackground(Color.YELLOW);
								btnEditarSetor.setText("Editar");
								btnNovoSetor.setEnabled(true);
								btnExcluirSetor.setEnabled(true);

								cardlayout.show(pnlCliente, "Produto");

							}

						}

					} else {

						tfSetorDaEmpresa.setEditable(false);
						tfSetorDaEmpresa.setBackground(Color.YELLOW);
						tfSetorDaEmpresa.setText("");
						btnEditarSetor.setText("Editar");
						btnNovoSetor.setEnabled(true);
						btnEditarSetor.setEnabled(true);
						btnExcluirSetor.setEnabled(true);

						cardlayout.show(pnlCliente, "Produto");

					}

				}

			}
		});
		btnEditarSetor.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnEditarSetor.setBounds(424, 183, 80, 23);
		cadastroSetorPanel.add(btnEditarSetor);

		btnCancelarSetor = new JButton("Cancelar");
		btnCancelarSetor.setToolTipText("Cancelar");
		btnCancelarSetor.setMnemonic('c');
		btnCancelarSetor.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelarSetor.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnCancelarSetor.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnCancelarSetor.setBorder(null);
		btnCancelarSetor.setContentAreaFilled(false);
		btnCancelarSetor.setForeground(Color.WHITE);
		btnCancelarSetor.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				tfSetorDaEmpresa.setEditable(false);
				tfSetorDaEmpresa.setBackground(Color.YELLOW);
				btnNovoSetor.setText("Novo");
				btnNovoSetor.setEnabled(true);
				btnEditarSetor.setEnabled(true);
				btnExcluirSetor.setEnabled(true);

				cbSetorDoServico.setSelectedIndex(0);

				cardlayout.show(pnlCliente, "Produto");

			}
		});
		btnCancelarSetor.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnCancelarSetor.setBounds(599, 183, 85, 23);
		cadastroSetorPanel.add(btnCancelarSetor);

		tfSetorDaEmpresa = new JTextField();
		tfSetorDaEmpresa.setBorder(new LineBorder(new Color(0, 0, 205)));
		tfSetorDaEmpresa.setBackground(Color.YELLOW);
		tfSetorDaEmpresa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tfSetorDaEmpresa.setEditable(false);
		tfSetorDaEmpresa.setDisabledTextColor(Color.WHITE);
		tfSetorDaEmpresa.setColumns(10);
		tfSetorDaEmpresa.setBounds(335, 149, 349, 23);
		cadastroSetorPanel.add(tfSetorDaEmpresa);

		JLabel label = new JLabel("Setor da Empresa");
		label.setForeground(new Color(0, 0, 205));
		label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		label.setBounds(335, 132, 349, 14);
		cadastroSetorPanel.add(label);

		getContentPane().add(lblCliente);
		getContentPane().add(cbCliente);
		getContentPane().add(btnSelecionar);
		getContentPane().add(lblClientePesquisa);

		JPanel pnlNome = new JPanel();
		pnlNome.setBounds(0, 0, 994, 61);
		pnlNome.setBackground(new Color(0, 0, 205));

		JLabel lblComercial = new JLabel("COMERCIAL");
		lblComercial.setHorizontalTextPosition(SwingConstants.CENTER);
		lblComercial.setHorizontalAlignment(SwingConstants.CENTER);
		lblComercial.setForeground(Color.WHITE);
		lblComercial.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 30));
		GroupLayout gl_pnlNome = new GroupLayout(pnlNome);
		gl_pnlNome.setHorizontalGroup(gl_pnlNome.createParallelGroup(Alignment.LEADING).addComponent(lblComercial,
				GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE));
		gl_pnlNome.setVerticalGroup(gl_pnlNome.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNome.createSequentialGroup()
						.addComponent(lblComercial, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pnlNome.setLayout(gl_pnlNome);
		getContentPane().add(pnlNome);
		getContentPane().add(pnlBarra);
		pnlBarra.setLayout(null);
		pnlBarra.add(lblLogado);
		pnlBarra.add(btnLogout);
		pnlBarra.add(btnFechar);

		btnIncial = new JButton("Tela Inicial");
		btnIncial.setBounds(365, 92, 94, 23);
		btnIncial.setRolloverIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao2.jpg")));
		btnIncial.setHorizontalTextPosition(SwingConstants.CENTER);
		btnIncial.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/botao.jpg")));
		btnIncial.setContentAreaFilled(false);
		btnIncial.setBackground(new Color(0, 0, 205));
		btnIncial.setBorder(null);
		btnIncial.setForeground(Color.WHITE);
		getContentPane().add(btnIncial);
		
		btnIncial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cardlayout.show(pnlCliente, "Inicial");

			}
		});
		
		btnIncial.setToolTipText("Tela Inicial");
		btnIncial.setMnemonic('L');
		btnIncial.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(null);
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setForeground(new Color(0, 0, 205));
		mnArquivo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		mnArquivo.setBorder(new LineBorder(new Color(0, 0, 205)));
		mnArquivo.setMnemonic('A');
		menuBar.add(mnArquivo);

		JMenuItem mntmLogoff = new JMenuItem("Logoff");
		mntmLogoff.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/logout.png")));
		mntmLogoff.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		mntmLogoff.setForeground(new Color(0, 0, 205));
		mntmLogoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resposta = JOptionPane.showConfirmDialog(null, "Deseja fazer o logoff?", "Logoff",
						JOptionPane.YES_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {

					dispose();

					try {

						mntmProduto.setVisible(false);
						mnVendedor.setVisible(false);

						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
						LoginComercialView frame = new LoginComercialView();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);

					} catch (Exception e1) {

						e1.printStackTrace();

					}

				}

			}
		});
		mntmLogoff.setMnemonic('L');
		mnArquivo.add(mntmLogoff);

		JMenuItem mntmFechar = new JMenuItem("Fechar");
		mntmFechar.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/cross-mark-on-a-black-circle-background.png")));
		mntmFechar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		mntmFechar.setForeground(new Color(0, 0, 205));
		mntmFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resposta = JOptionPane.showConfirmDialog(null, "Deseja fechar o programa?", "Fechar",
						JOptionPane.YES_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {

					dispose();

				}

			}
		});
		mntmFechar.setMnemonic('F');
		mnArquivo.add(mntmFechar);

		JMenu mnCadastro = new JMenu("Cadastro");
		mnCadastro.setForeground(new Color(0, 0, 205));
		mnCadastro.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		mnCadastro.setMnemonic('c');
		menuBar.add(mnCadastro);

		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/clerk-with-tie.png")));
		mnCliente.setMnemonic('l');
		mnCliente.setForeground(new Color(0, 0, 205));
		mnCliente.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		mnCadastro.add(mnCliente);

		JMenuItem mntmClienteNovo = new JMenuItem("Novo");
		mntmClienteNovo.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/plus-symbol-in-a-rounded-black-square.png")));
		mntmClienteNovo.setMnemonic('n');
		mntmClienteNovo.setForeground(new Color(0, 0, 205));
		mntmClienteNovo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		mnCliente.add(mntmClienteNovo);

		JMenuItem mntmClienteEditar = new JMenuItem("Editar");
		mntmClienteEditar.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/writing.png")));
		mntmClienteEditar.setMnemonic('e');
		mntmClienteEditar.setForeground(new Color(0, 0, 205));
		mntmClienteEditar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		mntmClienteEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cardlayout.show(pnlCliente, "EditarNovo");

			}
		});
		mnCliente.add(mntmClienteEditar);
		mntmClienteNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cardlayout.show(pnlCliente, "Novo");

			}
		});

		mntmProduto = new JMenu("Produto");
		mntmProduto.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/product.png")));
		mntmProduto.setMnemonic('p');
		mntmProduto.setForeground(new Color(0, 0, 205));
		mntmProduto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		mntmProduto.setVisible(false);
		mnCadastro.add(mntmProduto);

		JMenuItem mntmProdutoNovo = new JMenuItem("Novo");
		mntmProdutoNovo.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/plus-symbol-in-a-rounded-black-square.png")));
		mntmProdutoNovo.setMnemonic('n');
		mntmProdutoNovo.setForeground(new Color(0, 0, 205));
		mntmProdutoNovo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		mntmProdutoNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cardlayout.show(pnlCliente, "Produto");

			}
		});
		mntmProduto.add(mntmProdutoNovo);

		JMenuItem mntmProdutoEditar = new JMenuItem("Editar");
		mntmProdutoEditar.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/writing.png")));
		mntmProdutoEditar.setMnemonic('e');
		mntmProdutoEditar.setForeground(new Color(0, 0, 205));
		mntmProdutoEditar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		mntmProdutoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				cardlayout.show(pnlCliente, "EditarProduto");

			}
		});
		mntmProduto.add(mntmProdutoEditar);

		mnVendedor = new JMenu("Vendedor");
		mnVendedor.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/businessman.png")));
		mnVendedor.setMnemonic('v');
		mnVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		mnVendedor.setForeground(new Color(0, 0, 205));
		mnVendedor.setVisible(false);
		mnCadastro.add(mnVendedor);

		JMenuItem mntmVendedorNovo = new JMenuItem("Novo");
		mntmVendedorNovo.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/plus-symbol-in-a-rounded-black-square.png")));
		mntmVendedorNovo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		mntmVendedorNovo.setForeground(new Color(0, 0, 205));
		mnVendedor.add(mntmVendedorNovo);

		JMenuItem mntmVendedorEditar = new JMenuItem("Editar");
		mntmVendedorEditar.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/writing.png")));
		mntmVendedorEditar.setForeground(new Color(0, 0, 205));
		mntmVendedorEditar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		mntmVendedorEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				cardlayout.show(pnlCliente, "EditarVendedor");

			}
		});
		mnVendedor.add(mntmVendedorEditar);
		mntmVendedorNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cardlayout.show(pnlCliente, "Cadastro Vendedor");

			}
		});

		mnRelatorios = new JMenu("Relat\u00F3rios");
		mnRelatorios.setVisible(false);
		mnRelatorios.setMnemonic('r');
		mnRelatorios.setForeground(new Color(0, 0, 205));
		mnRelatorios.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		menuBar.add(mnRelatorios);

		JMenuItem mntmRelatorio = new JMenuItem("Relatorio 1");
		mntmRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "Em produção", "Relatórios", JOptionPane.INFORMATION_MESSAGE);				
				
			}
		});
		mntmRelatorio.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/document.png")));
		mntmRelatorio.setForeground(new Color(0, 0, 205));
		mntmRelatorio.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		mnRelatorios.add(mntmRelatorio);

		mnLog = new JMenu("Log");
		mnLog.setVisible(false);
		mnLog.setMnemonic('l');
		mnLog.setForeground(new Color(0, 0, 205));
		mnLog.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		menuBar.add(mnLog);

		JMenuItem mntmExportarLog = new JMenuItem("Exportar Log");
		mntmExportarLog.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/document (3).png")));
		mntmExportarLog.setMnemonic('x');
		mntmExportarLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ExportarCsv csv = new ExportarCsv();
				try {
					csv.exportarLog();
				} catch (HeadlessException | IOException e1) {
					
					e1.printStackTrace();
				}

			}
		});
		mntmExportarLog.setForeground(new Color(0, 0, 205));
		mntmExportarLog.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		mnLog.add(mntmExportarLog);

		JMenu mnAjuda = new JMenu("Ajuda");
		mnAjuda.setForeground(new Color(0, 0, 205));
		mnAjuda.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		mnAjuda.setMnemonic('u');
		menuBar.add(mnAjuda);

		JMenuItem mntmSobreComercial = new JMenuItem("Sobre Comercial NE");
		mntmSobreComercial.setIcon(new ImageIcon(PrincipalComercialView.class.getResource("/image/question-mark.png")));
		mntmSobreComercial.setMnemonic('s');
		mntmSobreComercial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					AjudaView dialog = new AjudaView();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		mntmSobreComercial.setForeground(new Color(0, 0, 205));
		mntmSobreComercial.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		mnAjuda.add(mntmSobreComercial);

	}

	public JMenu getMnRelatorios() {
		return mnRelatorios;
	}

	public void setMnRelatorios(JMenu mnRelatorios) {
		this.mnRelatorios = mnRelatorios;
	}

	public JTextPane getTpDescricaoProdutoDoServico() {
		return tpDescricaoProdutoDoServico;
	}

	public void setTpDescricaoProdutoDoServico(JTextPane tpDescricaoProdutoDoServico) {
		this.tpDescricaoProdutoDoServico = tpDescricaoProdutoDoServico;
	}

	public JNumberFormatField getTfValorUnitarioSugerido() {
		return tfValorUnitarioSugerido;
	}

	public void setTfValorUnitarioSugerido(JNumberFormatField tfValorUnitarioSugerido) {
		this.tfValorUnitarioSugerido = tfValorUnitarioSugerido;
	}

	public PrincipalComercialView(JTextField tfCodigoDoProduto) throws HeadlessException {
		super();
		this.tfCodigoDoProduto = tfCodigoDoProduto;
	}

	public JTextField getTfNomeDoProduto() {
		return tfNomeDoProduto;
	}

	public void setTfNomeDoProduto(JTextField tfNomeDoProduto) {
		this.tfNomeDoProduto = tfNomeDoProduto;
	}

	public JComboBox<String> getCbAcessoVendedor() {
		return cbAcessoVendedor;
	}

	public void setCbAcessoVendedor(JComboBox<String> cbAcessoVendedor) {
		this.cbAcessoVendedor = cbAcessoVendedor;
	}

	public JComboBox<String> getCbCadVendedor() {
		return cbCadVendedor;
	}

	public void setCbCadVendedor(JComboBox<String> cbCadVendedor) {
		this.cbCadVendedor = cbCadVendedor;
	}

	public JTextField getTfNovoNomeFantasia() {
		return tfNovoNomeFantasia;
	}

	public void setTfNovoNomeFantasia(JTextField tfNovoNomeFantasia) {
		this.tfNovoNomeFantasia = tfNovoNomeFantasia;
	}

	public JLabel getLblServicoLancamento() {
		return lblServicoLancamento;
	}

	public void setLblServicoLancamento(JLabel lblServicoLancamento) {
		this.lblServicoLancamento = lblServicoLancamento;
	}

	public JLabel getLblProdutoLancamento() {
		return lblProdutoLancamento;
	}

	public void setLblProdutoLancamento(JLabel lblProdutoLancamento) {
		this.lblProdutoLancamento = lblProdutoLancamento;
	}

	public JTable getTbVerLancamento() {
		return tbVerLancamento;
	}

	public void setTbVerLancamento(JTable tbVerLancamento) {
		this.tbVerLancamento = tbVerLancamento;
	}

	public JTextField getTfNomeClienteLancamento() {
		return tfNomeClienteLancamento;
	}

	public void setTfNomeClienteLancamento(JTextField tfNomeClienteLancamento) {
		this.tfNomeClienteLancamento = tfNomeClienteLancamento;
	}

	public JTextField getTfServicoLancamento() {
		return tfServicoLancamento;
	}

	public void setTfServicoLancamento(JTextField tfServicoLancamento) {
		this.tfServicoLancamento = tfServicoLancamento;
	}

	public JTextField getTfSaldoAtualLancamento() {
		return tfSaldoAtualLancamento;
	}

	public void setTfSaldoAtualLancamento(JTextField tfSaldoAtualLancamento) {
		this.tfSaldoAtualLancamento = tfSaldoAtualLancamento;
	}

	public JTextField getTfValorLancamento() {
		return tfCnpjLancamento;
	}

	public void setTfValorLancamento(JTextField tfValorLancamento) {
		this.tfCnpjLancamento = tfValorLancamento;
	}

	public static ClienteServico getClienteServico() {
		return clienteServico;
	}

	public static void setClienteServico(ClienteServico clienteServico) {
		PrincipalComercialView.clienteServico = clienteServico;
	}

	public JComboBox<String> getCbCliente() {
		return cbCliente;
	}

	public void setCbCliente(JComboBox<String> cbCliente) {
		this.cbCliente = cbCliente;
	}

	/*
	 * public void corEdicao() {
	 * 
	 * tfNomeFantasia.setEditable(true);
	 * 
	 * tfVendedor.setVisible(false);
	 * 
	 * tfRazaoSocial.setEditable(true);
	 * 
	 * tfContato1.setEditable(true);
	 * 
	 * tfFoneCelular1.setEditable(true);
	 * 
	 * tfFoneFixo1.setEditable(true);
	 * 
	 * tfCNPJ.setEditable(true);
	 * 
	 * tfInscricaoEstadual.setEditable(true);
	 * 
	 * tfEmail1.setEditable(true);
	 * 
	 * tfLogradouro.setEditable(true);
	 * 
	 * tfBairro.setEditable(true);
	 * 
	 * tfCidade.setEditable(true);
	 * 
	 * tfCep.setEditable(true);
	 * 
	 * tpDetalhes.setEditable(true);
	 * 
	 * // tfEntrega.setVisible(false); tfUnidade.setVisible(false); //
	 * tfUf.setVisible(false); tfClienteDesde.setVisible(false);
	 * 
	 * // cbEntrega.setVisible(true); // cbUnidade.setVisible(true); //
	 * cbUf.setVisible(true); // dcClienteDesde.setVisible(true);
	 * 
	 * //btnEditarDadosCliente.setVisible(true); //
	 * btnCancelarEditar.setVisible(true); // btnEditarDados.setVisible(false);
	 * 
	 * }
	 * 
	 * /*public void cancelarCorEdicao() {
	 * 
	 * tfNomeFantasia.setEditable(false);
	 * 
	 * tfVendedor.setVisible(true);
	 * 
	 * tfRazaoSocial.setEditable(false);
	 * 
	 * tfContato1.setEditable(false);
	 * 
	 * tfFoneCelular1.setEditable(false);
	 * 
	 * tfFoneFixo1.setEditable(false);
	 * 
	 * tfCNPJ.setEditable(false);
	 * 
	 * tfInscricaoEstadual.setEditable(false);
	 * 
	 * tfEmail1.setEditable(false);
	 * 
	 * tfLogradouro.setEditable(false);
	 * 
	 * tfBairro.setEditable(false);
	 * 
	 * tfCidade.setEditable(false);
	 * 
	 * tfCep.setEditable(false);
	 * 
	 * // tfEntrega.setVisible(true); tfUnidade.setVisible(true); //
	 * tfUf.setVisible(true); tfClienteDesde.setVisible(true);
	 * 
	 * // cbEntrega.setVisible(false); // cbUnidade.setVisible(false); //
	 * cbUf.setVisible(false); // dcClienteDesde.setVisible(false);
	 * 
	 * //btnEditarDadosCliente.setVisible(false); //
	 * btnCancelarEditar.setVisible(false); // btnEditarDados.setVisible(true);
	 * 
	 * }
	 */

	protected boolean estaVazio(JTextField campo) {

		return campo.getText() == null || campo.getText().trim().isEmpty();

	}

	protected void limparNovoCliente() {

		tfNovoNomeFantasia.setText("");
		cbNovoVendedor.setSelectedIndex(0);
		dcNovoClienteDesde.setDate(null);
		tpNovoObservacoesDoCliente.setText("");
		cbNovoUnidade.setSelectedIndex(0);
		tfNovoRazaoSocial.setText("");
		tfNovoContato1.setText("");
		ftfNovoCelular1.setText("");
		ftfNovoFixo1.setText("");
		tfNovoEmail1.setText("");
		tfNovoContato2.setText("");
		ftfNovoCelular2.setText("");
		ftfNovoFixo2.setText("");
		tfNovoEmail2.setText("");
		ftfNovoCnpj.setText("");
		tfNovoInscricaoEstadual.setText("");
		tfInscricaoMunicipal.setText("");
		tfNovoLogradouro.setText("");
		tfNovoCidade.setText("");
		tfNovoBairro.setText("");
		ftfNovoCEP.setText("");
		cbNovoUf.setSelectedIndex(0);
		cbNovoUnidade.setSelectedIndex(0);

	}

	public JComboBox<String> getCbServicosCadastrados() {
		return cbServicosCadastrados;
	}

	public void setCbServicosCadastrados(JComboBox<String> cbServicosCadastrados) {
		this.cbServicosCadastrados = cbServicosCadastrados;
	}

	public void apagarPanelServicos() {

		tfProdutoServico.setText("");
		tfSaldoServico.setText("");
		tfValorUnitarioServico.setText("");
		tfCnpjServico.setText("");
		tpObsServico.setText("");

	}

	public void fazerLancamento(int transacao) throws EmailException {

		java.sql.Date DataSql = null;

		java.util.Date dataUtil = dcDataDoLancamento.getDate();
		DataSql = new java.sql.Date(dataUtil.getTime());

		boolean sucesso = false;

		LancamentoServico lancamentoServico = new LancamentoServico();
		LancamentoServicoController lancamentoServicoController = new LancamentoServicoController();

		lancamentoServico.setId_clienteServico(clienteServico.getId_clienteServico());
		lancamentoServico.setDataDoLancamento(DataSql);
		lancamentoServico.setQuantidadeDoPedido(Integer.valueOf(tfQuantidadeDoPedido.getText()));
		lancamentoServico.setSaldoAnterior(clienteServico.getSaldoServico());
		lancamentoServico.setSaldoAtual(Integer.valueOf(transacao));
		lancamentoServico.setObservacoesLancamento(ObservacoesLancamento + " / ( " + tfQuantidadeDoPedido.getText()
				+ " UNIDS. ) " + tfObservacoesLancamento.getText().toUpperCase());

		sucesso = lancamentoServicoController.fazerLancamentoDoServico(lancamentoServico);

		if (sucesso == false) {

			LogSegurancaController.novoLogSeguranca("ERRO AO LANÇAR O PEDIDO");

			JOptionPane.showMessageDialog(null, "Erro ao lançar o pedido");

		} else {

			LogSegurancaController.novoLogSeguranca("LANÇAMENTO SALVO");

			JOptionPane.showMessageDialog(null, "Lançamento salvo");

			clienteServico.setSaldoServico(transacao);

			ClienteServicoController clienteServicoController = new ClienteServicoController();
			boolean sucesso2 = clienteServicoController.atualizarSaldo(clienteServico);

			List<TabelaStatus> listaTabelaStatus = new ArrayList<TabelaStatus>();

			NumberFormat tresDigitos = new DecimalFormat("000");

			if (LoginComercialView.getVendedor().getAcesso().equalsIgnoreCase("GERENCIAL")) {

				listaTabelaStatus = clienteServicoController.todosServicos();

			} else {

				listaTabelaStatus = clienteServicoController
						.todosServicosPorVendedor(LoginComercialView.getVendedor().getId_vendedor());

			}

			DefaultTableModel model = (DefaultTableModel) getTbStatusCliente().getModel();
			model.setNumRows(0);

			int id = 1;

			if (listaTabelaStatus.isEmpty() == false) {

				getSpStatusCliente().setVisible(true);
				getLblClientesParaRenovacao().setVisible(true);
				getLblStatusFoto().setVisible(false);

				for (TabelaStatus ts : listaTabelaStatus) {

					String status = "RENOVAR SALDO";

					Object[] linha = { tresDigitos.format(id), ts.getCliente(), ts.getServico(),
							tresDigitos.format(ts.getSaldo()), status };

					model.addRow(linha);

					id++;

				}

				// enviar email para o vendedor
				new EmailThreadComercial().start();

			} else {

				getSpStatusCliente().setVisible(false);
				getLblClientesParaRenovacao().setVisible(false);
				getLblStatusFoto().setVisible(true);

			}

			if (sucesso2 == true) {

				clienteServico = clienteServicoController.buscarClienteServico(clienteServico.getId_clienteServico());

				tfSaldoAtualLancamento.setText(tresDigitos.format(clienteServico.getSaldoServico()));
				tfSaldoServico.setText(tresDigitos.format(clienteServico.getSaldoServico()));
				cbTransacaoLancamento.setSelectedIndex(0);
				dcDataDoLancamento.setDate(null);
				tfQuantidadeDoPedido.setText("");
				tfObservacoesLancamento.setText("");

				int resposta = JOptionPane.showConfirmDialog(null, "Deseja fazer outro lançamento?", "Lançamento",
						JOptionPane.YES_OPTION);

				if (resposta == JOptionPane.NO_OPTION) {

					cardlayout.show(pnlCliente, "Dados");

				} else {

					tfSaldoAtualLancamento.setText(tresDigitos.format(clienteServico.getSaldoServico()));

				}

			} else {

				LogSegurancaController.novoLogSeguranca("ERRO AO SALVAR O SALDO");

				JOptionPane.showMessageDialog(null, "Erro ao salvar o saldo", "Lançamento", JOptionPane.ERROR_MESSAGE);

			}

		}
	}

	public CardLayout getCardlayout() {
		return cardlayout;
	}

	public void setCardlayout(CardLayout cardlayout) {
		this.cardlayout = cardlayout;
	}

	public JPanel getPnlCliente() {
		return pnlCliente;
	}

	public void setPnlCliente(JPanel pnlCliente) {
		this.pnlCliente = pnlCliente;
	}

	public void limparPanelVerLancamento() {

		spVerLancamento.setVisible(false);
		dcDataInicialPesquisa.setDate(null);
		dcDataFinalPesquisa.setDate(null);
		DefaultTableModel model = (DefaultTableModel) tbVerLancamento.getModel();
		model.setNumRows(0);

	}

	public void limparPanelNovoCliente() {

		tfNovoNomeFantasia.setText("");
		tfNovoRazaoSocial.setText("");
		tfNovoContato1.setText("");
		tfNovoEmail1.setText("");
		ftfNovoCelular1.setText("");
		ftfNovoFixo1.setText("");
		ftfNovoCnpj.setText("");
		tfNovoInscricaoEstadual.setText("");
		cbNovoVendedor.setSelectedIndex(0);
		tfNovoLogradouro.setText("");
		tfNovoBairro.setText("");
		tfNovoCidade.setText("");
		ftfNovoCEP.setText("");
		cbNovoUf.setSelectedIndex(0);
		cbNovoUnidade.setSelectedIndex(0);
		dcNovoClienteDesde.setDate(null);
		tpNovoObservacoesDoCliente.setText("");
		tfNovoContato2.setText("");
		tfNovoEmail2.setText("");
		ftfNovoCelular2.setText("");
		ftfNovoFixo2.setText("");
		tfInscricaoMunicipal.setText("");

	}

	public JTextField getTfTotalDeClientes() {
		return tfTotalDeClientes;
	}

	public void setTfTotalDeClientes(JTextField tfTotalDeClientes) {
		this.tfTotalDeClientes = tfTotalDeClientes;
	}

	public JTable getTbStatusCliente() {
		return tbStatusCliente;
	}

	public void setTbStatusCliente(JTable tbStatusCliente) {
		this.tbStatusCliente = tbStatusCliente;
	}

	public void limparVendedorPanel() {

		tfNomeVendedor.setText("");
		cbCadVendedor.setSelectedIndex(0);
		cbAcessoVendedor.setSelectedIndex(0);
		ftfCelularComercial.setText("");
		tfEmailComercial.setText("");
		ftfCelularPessoal.setText("");
		tfEmailPessoal.setText("");
		tfLoginCadVendedor.setText("");
		pfSenhaVendedor.setText("");
		pfRepSenhaVendedor.setText("");

	}

	public void limparServicoClientePanel() {

		tfNomeDoServico.setText("");
		tfCnpjDoServico.setText("");
		cbProdutoDoServico.setSelectedIndex(0);
		tfValorUnitario.setText("");
		tfLimiteMinimo.setText("");
		tpObservacoesDoServico.setText("");

		cbServicosCadastrados.setSelectedIndex(0);

	}

	public void limparLembretePanel() {

		cbVendedorDestinatario.setSelectedIndex(0);
		tfAssuntoLembrete.setText("");
		tpDescricaoLembrete.setText("");

	}

	public JTable getTbLembrete() {
		return tbLembrete;
	}

	public void setTbLembrete(JTable tbLembrete) {
		this.tbLembrete = tbLembrete;
	}

	public JMenu getMntmProduto() {
		return mntmProduto;
	}

	public void setMntmProduto(JMenu mntmProduto) {
		this.mntmProduto = mntmProduto;
	}

	public JMenu getMnVendedor() {
		return mnVendedor;
	}

	public void setMnVendedor(JMenu mnVendedor) {
		this.mnVendedor = mnVendedor;
	}

	public void LimparCadastroProdutoPanel() {

		DefaultTableModel model = (DefaultTableModel) tbVerLancamento.getModel();
		model.setNumRows(0);

		spPesquisarProduto.setVisible(false);
		btnEditarProduto.setVisible(false);

		tfNomeDoProduto.setText("");
		cbSetorDoServico.setSelectedIndex(0);
		tfCodigoDoProduto.setText("");
		tfValorUnitarioSugerido.setText("");
		tpDescricaoProdutoDoServico.setText("");

	}

	public JComboBox<String> getCbSetorDoServico() {
		return cbSetorDoServico;
	}

	public void setCbSetorDoServico(JComboBox<String> cbSetorDoServico) {
		this.cbSetorDoServico = cbSetorDoServico;
	}

	public JLabel getLblCadastroDeProduto() {
		return lblCadastroDeProduto;
	}

	public void setLblCadastroDeProduto(JLabel lblCadastroDeProduto) {
		this.lblCadastroDeProduto = lblCadastroDeProduto;
	}

	public JPanel getCadastroClientePanel() {
		return cadastroClientePanel;
	}

	public void setCadastroClientePanel(JPanel cadastroClientePanel) {
		this.cadastroClientePanel = cadastroClientePanel;
	}

	public JLabel getLblClienteVerLançamento() {
		return lblClienteVerLançamento;
	}

	public void setLblClienteVerLançamento(JLabel lblClienteVerLançamento) {
		this.lblClienteVerLançamento = lblClienteVerLançamento;
	}

	public void atualizarDadosCliente() {

		String entrega = "";
		DateFormat formatBR = new SimpleDateFormat("dd-MM-YYYY");

		tfNomeFantasia.setText(cliente.getNome().toUpperCase());

		VendedorController vendedorController = new VendedorController();
		String vendedor = vendedorController.buscarNomeVendedor(cliente.getId_vendedor());

		tfVendedor.setText(vendedor.toUpperCase());
		tfRazaoSocial.setText(cliente.getRazaoSocial().toUpperCase());

		String dataBr = formatBR.format(cliente.getClienteDesde());
		tfClienteDesde.setText(String.valueOf(dataBr));
		tfCNPJ.setText(cliente.getCnpj());
		tfInscricaoEstadual.setText(cliente.getInscricaoEstadual());
		tfInscrMunicipal.setText(cliente.getInscricaoMunicipal());
		tfContato1.setText(cliente.getContato1().toUpperCase());
		tfFoneCelular1.setText(cliente.getFoneCelular1());
		tfFoneFixo1.setText(cliente.getFoneFixo1());
		tfEmail1.setText(cliente.getEmail1().toLowerCase());
		tfContato2.setText(cliente.getContato2().toUpperCase());
		tfFoneCelular2.setText(cliente.getFoneCelular2());
		tfFoneFixo2.setText(cliente.getFoneFixo2());
		tfEmail2.setText(cliente.getEmail2().toLowerCase());
		tfLogradouro.setText(cliente.getLogradouro());
		tfCidade.setText(cliente.getCidade());
		tfBairro.setText(cliente.getBairro());
		tfCep.setText(cliente.getCep());
		tfUfDadosCliente.setText(cliente.getUf());

		if (cliente.isEntrega()) {

			entrega = "Sim";

		} else {

			entrega = "Não";
		}

		tfEntregaDadosCliente.setText(entrega);
		tfUnidade.setText(cliente.getUnidade().toUpperCase());
		tpDetalhes.setText(cliente.getDetalhes());

	}

	public void atualizarServico() {

		ClienteServicoController clienteServicoController = new ClienteServicoController();

		cbServicosCadastrados.removeAllItems();

		listaClienteServico = clienteServicoController.listaServicoCliente(cliente.getId_cliente());

		if (listaClienteServico.isEmpty() == true) {

			cbServicosCadastrados.addItem("ADICIONE UM SERVIÇO...");

		} else {

			cbServicosCadastrados.addItem("SELECIONE O SERVIÇO...");

			for (ClienteServico cs : listaClienteServico) {

				cbServicosCadastrados.addItem(cs.getNomeDoServico().toUpperCase());
			}

		}

		cbServicosCadastrados.setSelectedIndex(0);

	}

	public void atualizarSetorServico() {

		cbSetorDoServico.removeAllItems();

		SetorDaEmpresaController setorDaEmpresaController = new SetorDaEmpresaController();

		listaSetorDaEmpresa = setorDaEmpresaController.listaSetorDaEmpresa();

		cbSetorDoServico.addItem("SELECIONE...");

		for (SetorDaEmpresa sde : listaSetorDaEmpresa) {

			cbSetorDoServico.addItem(sde.getNomeDoSetorDaEmpresa().toUpperCase());

		}

		cbSetorDoServico.setSelectedIndex(0);

		cardlayout.show(pnlCliente, "Produto");
	}

	public void atualizarVendedor() throws FileNotFoundException {

		VendedorController vendedorController = new VendedorController();

		listaVendedores = vendedorController.listaVendedor();

		cbNovoVendedor.removeAllItems();
		cbVendedorDestinatario.removeAllItems();

		cbNovoVendedor.addItem("SELECIONE...");
		cbVendedorDestinatario.addItem("SELECIONE...");

		for (Vendedor v : listaVendedores) {

			cbNovoVendedor.addItem(v.getNome());
			cbVendedorDestinatario.addItem(v.getNome());

		}

	}

	public void atualizarProduto() {

		cbProdutoDoServico.removeAllItems();

		List<ProdutoDoServico> listaProdutoDoServico = new ArrayList<ProdutoDoServico>();
		ProdutoDoServicoController produtoDoServicoController = new ProdutoDoServicoController();
		listaProdutoDoServico = produtoDoServicoController.todosOsProdutos();

		cbProdutoDoServico.addItem("SELECIONE...");

		for (ProdutoDoServico pds : listaProdutoDoServico) {

			cbProdutoDoServico.addItem(pds.getNomeDoProduto());

		}

	}

	public void atualizarCliente() throws FileNotFoundException {

		ClienteController clienteController = new ClienteController();
		ClienteServicoController clienteServicoController = new ClienteServicoController();
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		List<TabelaStatus> listaTabelaStatus = new ArrayList<TabelaStatus>();
		NumberFormat tresDigitos = new DecimalFormat("000");

		if (LoginComercialView.getVendedor().getAcesso().equalsIgnoreCase("COMERCIAL")
				&& !LoginComercialView.getVendedor().getCargo().equalsIgnoreCase("COORDENADOR DE VENDAS")) {

			listaCliente = clienteController
					.listarClientesPorVendedor(LoginComercialView.getVendedor().getId_vendedor());

			cbCliente.removeAllItems();

			if (listaCliente.isEmpty() == true) {

				cbCliente.addItem("Não existe uma lista de clientes ainda!");

			} else {

				cbCliente.addItem("DIGITE O NOME DO CLIENTE...");

			}

			tfTotalDeClientes.setText(tresDigitos.format(listaCliente.size()));

			for (Cliente c : listaCliente) {

				cbCliente.addItem(c.getNome());

			}

			cbCliente.setSelectedIndex(0);

			listaTabelaStatus = clienteServicoController.todosServicosPorVendedor(vendedor.getId_vendedor());

			DefaultTableModel model = (DefaultTableModel) getTbStatusCliente().getModel();
			model.setNumRows(0);

			int id = 1;

			for (TabelaStatus ts : listaTabelaStatus) {

				if (ts.getLimiteMinimo() >= ts.getSaldo()) {

					String status = "RENOVAR SALDO";

					Object[] linha = { tresDigitos.format(id), ts.getCliente(), ts.getServico(),
							tresDigitos.format(ts.getSaldo()), status };

					model.addRow(linha);

					id++;

				}

			}

		} else if (LoginComercialView.getVendedor().getAcesso().equalsIgnoreCase("COMERCIAL")
				&& LoginComercialView.getVendedor().getCargo().equalsIgnoreCase("COORDENADOR DE VENDAS")) {

			listaCliente = clienteController
					.listarClientesPorVendedor(LoginComercialView.getVendedor().getId_vendedor());

			cbCliente.removeAllItems();

			if (listaCliente.isEmpty() == true) {

				cbCliente.addItem("Não existe uma lista de clientes ainda!");

			} else {

				cbCliente.addItem("DIGITE O NOME DO CLIENTE...");

			}

			tfTotalDeClientes.setText(tresDigitos.format(listaCliente.size()));

			for (Cliente c : listaCliente) {

				cbCliente.addItem(c.getNome());

			}

			cbCliente.setSelectedIndex(0);

			listaTabelaStatus = clienteServicoController.todosServicosPorVendedor(vendedor.getId_vendedor());

			DefaultTableModel model = (DefaultTableModel) getTbStatusCliente().getModel();
			model.setNumRows(0);

			int id = 1;

			for (TabelaStatus ts : listaTabelaStatus) {

				if (ts.getLimiteMinimo() >= ts.getSaldo()) {

					String status = "RENOVAR SALDO";

					Object[] linha = { tresDigitos.format(id), ts.getCliente(), ts.getServico(),
							tresDigitos.format(ts.getSaldo()), status };

					model.addRow(linha);

					id++;

				}

			}

		} else if (LoginComercialView.getVendedor().getAcesso().equalsIgnoreCase("GERENCIAL")) {

			listaCliente = clienteController.listarClientes();

			cbCliente.removeAllItems();

			if (listaCliente.isEmpty() == true) {

				cbCliente.addItem("Não existe uma lista de clientes ainda!");

			} else {

				cbCliente.addItem("DIGITE O NOME DO CLIENTE...");

			}

			tfTotalDeClientes.setText(tresDigitos.format(listaCliente.size()));

			for (Cliente c : listaCliente) {

				cbCliente.addItem(c.getNome());

			}

			cbCliente.setSelectedIndex(0);

			listaTabelaStatus = clienteServicoController.todosServicos();

			DefaultTableModel model = (DefaultTableModel) getTbStatusCliente().getModel();
			model.setNumRows(0);

			int id = 1;

			for (TabelaStatus ts : listaTabelaStatus) {

				if (ts.getLimiteMinimo() >= ts.getSaldo()) {

					String status = "RENOVAR SALDO";

					Object[] linha = { tresDigitos.format(id), ts.getCliente(), ts.getServico(),
							tresDigitos.format(ts.getSaldo()), status };

					model.addRow(linha);

					id++;

				}

			}

		}

	}

	public static boolean isTipoSalvarOuEditarServico() {
		return tipoSalvarOuEditarServico;
	}

	public static void setTipoSalvarOuEditarServico(boolean tipoSalvarOuEditarServico) {
		PrincipalComercialView.tipoSalvarOuEditarServico = tipoSalvarOuEditarServico;
	}

	public static boolean isEditarLancamento() {
		return editarLancamento;
	}

	public static void setEditarLancamento(boolean editarLancamento) {
		PrincipalComercialView.editarLancamento = editarLancamento;
	}

	public JButton getBtnLancamentos() {
		return btnLancamentos;
	}

	public void setBtnLancamentos(JButton btnLancamentos) {
		this.btnLancamentos = btnLancamentos;
	}

	public JScrollPane getSpStatusCliente() {
		return spStatusCliente;
	}

	public void setSpStatusCliente(JScrollPane spStatusCliente) {
		this.spStatusCliente = spStatusCliente;
	}

	public JLabel getLblClientesParaRenovacao() {
		return lblClientesParaRenovacao;
	}

	public void setLblClientesParaRenovacao(JLabel lblClientesParaRenovacao) {
		this.lblClientesParaRenovacao = lblClientesParaRenovacao;
	}

	public JScrollPane getSpLembrete() {
		return spLembrete;
	}

	public void setSpLembrete(JScrollPane spLembrete) {
		this.spLembrete = spLembrete;
	}

	public JScrollPane getSpDescricaoRecado() {
		return spDescricaoRecado;
	}

	public void setSpDescricaoRecado(JScrollPane spDescricaoRecado) {
		this.spDescricaoRecado = spDescricaoRecado;
	}

	public JButton getBtnApagarLembrete() {
		return btnApagarLembrete;
	}

	public void setBtnApagarLembrete(JButton btnApagarLembrete) {
		this.btnApagarLembrete = btnApagarLembrete;
	}

	public JLabel getLblDescricaoLembrete() {
		return lblDescricaoLembrete;
	}

	public void setLblDescricaoLembrete(JLabel lblDescricaoLembrete) {
		this.lblDescricaoLembrete = lblDescricaoLembrete;
	}

	public JLabel getLblLembreteFoto() {
		return lblLembreteFoto;
	}

	public void setLblLembreteFoto(JLabel lblLembreteFoto) {
		this.lblLembreteFoto = lblLembreteFoto;
	}

	public JLabel getLblStatusFoto() {
		return lblStatusFoto;
	}

	public void setLblStatusFoto(JLabel lblStatusFoto) {
		this.lblStatusFoto = lblStatusFoto;
	}

	public JMenu getMnLog() {
		return mnLog;
	}

	public void setMnLog(JMenu mnLog) {
		this.mnLog = mnLog;
	}

	@SuppressWarnings("unused")
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}