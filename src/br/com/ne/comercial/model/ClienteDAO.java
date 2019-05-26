package br.com.ne.comercial.model;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.ne.comercial.controller.Cliente;
import br.com.ne.comercial.model.ConectarBanco;

public class ClienteDAO {

	// Comercial

	public void adicionarCliente(Cliente cliente) throws FileNotFoundException {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		PreparedStatement insereST = null;
		String sql = "";

		try {

			int index = 1;

			sql = "INSERT INTO cliente (nome, id_vendedor, contato1, email1, celular1, fixo1, contato2, email2, celular2, fixo2, detalhes, entrega, unidade, razaosocial, cnpj, inscricaoestadual, inscricaomunicipal, clientedesde, logradouro, cidade, bairro, cep, uf  ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,?)";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(index, cliente.getNome());
			insereST.setInt(++index, cliente.getId_vendedor());
			insereST.setString(++index, cliente.getContato1());
			insereST.setString(++index, cliente.getEmail1());
			insereST.setString(++index, cliente.getFoneCelular1());
			insereST.setString(++index, cliente.getFoneFixo1());
			insereST.setString(++index, cliente.getContato2());
			insereST.setString(++index, cliente.getEmail2());
			insereST.setString(++index, cliente.getFoneCelular2());
			insereST.setString(++index, cliente.getFoneFixo2());
			insereST.setString(++index, cliente.getDetalhes());
			insereST.setBoolean(++index, cliente.isEntrega());
			insereST.setString(++index, cliente.getUnidade());
			insereST.setString(++index, cliente.getRazaoSocial());
			insereST.setString(++index, cliente.getCnpj());
			insereST.setString(++index, cliente.getInscricaoEstadual());
			insereST.setString(++index, cliente.getInscricaoMunicipal());
			insereST.setDate(++index, cliente.getClienteDesde());
			insereST.setString(++index, cliente.getLogradouro());
			insereST.setString(++index, cliente.getCidade());
			insereST.setString(++index, cliente.getBairro());
			insereST.setString(++index, cliente.getCep());
			insereST.setString(++index, cliente.getUf());

			insereST.executeUpdate();

			JOptionPane.showMessageDialog(null, "O cliente foi inserido com sucesso!");

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao inserir o cliente!" + e.getMessage());

		} finally {

			try {

				insereST.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão! Mensagem: " + e2.getMessage());

			}

		}

	}

	public boolean novoCliente(Cliente cliente) throws FileNotFoundException {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		PreparedStatement insereST = null;
		String sql = "";

		boolean sucesso = false;

		try {

			int index = 1;

			sql = "INSERT INTO cliente (nome, id_vendedor, contato1, email1, celular1, fixo1, contato2, email2, celular2, fixo2, detalhes, entrega, unidade, razaoSocial, cnpj, inscricaoestadual, inscricaomunicipal, clientedesde, logradouro, cidade, bairro, cep, uf ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(index, cliente.getNome());
			insereST.setInt(++index, cliente.getId_vendedor());
			insereST.setString(++index, cliente.getContato1());
			insereST.setString(++index, cliente.getEmail1());
			insereST.setString(++index, cliente.getFoneCelular1());
			insereST.setString(++index, cliente.getFoneFixo1());
			insereST.setString(++index, cliente.getContato2());
			insereST.setString(++index, cliente.getEmail2());
			insereST.setString(++index, cliente.getFoneCelular2());
			insereST.setString(++index, cliente.getFoneFixo2());
			insereST.setString(++index, cliente.getDetalhes());
			insereST.setBoolean(++index, cliente.isEntrega());
			insereST.setString(++index, cliente.getUnidade());
			insereST.setString(++index, cliente.getRazaoSocial());
			insereST.setString(++index, cliente.getCnpj());
			insereST.setString(++index, cliente.getInscricaoEstadual());
			insereST.setString(++index, cliente.getInscricaoMunicipal());
			insereST.setDate(++index, cliente.getClienteDesde());
			insereST.setString(++index, cliente.getLogradouro());
			insereST.setString(++index, cliente.getCidade());
			insereST.setString(++index, cliente.getBairro());
			insereST.setString(++index, cliente.getCep());
			insereST.setString(++index, cliente.getUf());

			insereST.executeUpdate();

			sucesso = true;

		} catch (Exception e) {

			// JOptionPane.showMessageDialog(null, "Erro ao inserir o cliente!"
			// + e.getMessage());

		} finally {

			try {

				insereST.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão! Mensagem: " + e2.getMessage());

			}

		}
		return sucesso;

	}

	public List<Cliente> listarClientes() throws FileNotFoundException {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		PreparedStatement insereST = null;
		ResultSet rs = null;
		String sql = "";

		List<Cliente> listaCliente = new ArrayList<Cliente>();

		try {

			sql = "SELECT * FROM cliente ORDER BY nome ASC";

			insereST = conexao.prepareStatement(sql);
			rs = insereST.executeQuery();

			while (rs.next()) {

				Cliente cliente = new Cliente();

				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setId_vendedor(rs.getInt("id_vendedor"));
				cliente.setContato1(rs.getString("contato1"));
				cliente.setEmail1(rs.getString("email1"));
				cliente.setFoneCelular1(rs.getString("celular1"));
				cliente.setFoneFixo1(rs.getString("fixo1"));
				cliente.setContato2(rs.getString("contato2"));
				cliente.setEmail2(rs.getString("email2"));
				cliente.setFoneCelular2(rs.getString("celular2"));
				cliente.setFoneFixo2(rs.getString("fixo2"));
				cliente.setDetalhes(rs.getString("detalhes"));
				cliente.setEntrega(rs.getBoolean("entrega"));
				cliente.setUnidade(rs.getString("unidade"));
				cliente.setRazaoSocial(rs.getString("razaoSocial"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
				cliente.setInscricaoMunicipal(rs.getString("inscricaoMunicipal"));
				cliente.setClienteDesde(rs.getDate("clienteDesde"));
				cliente.setLogradouro(rs.getString("logradouro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCep(rs.getString("cep"));
				cliente.setUf(rs.getString("uf"));

				listaCliente.add(cliente);

			}

			return listaCliente;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao gerar a lista. Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				rs.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return listaCliente;

	}

	public List<Cliente> listarClientesPorVendedor(int id_vendedor) throws FileNotFoundException {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		PreparedStatement insereST = null;
		ResultSet rs = null;
		String sql = "";

		List<Cliente> listaCliente = new ArrayList<Cliente>();

		try {

			sql = "SELECT * FROM cliente where id_vendedor = ? order by nome asc";

			insereST = conexao.prepareStatement(sql);

			insereST.setInt(1, id_vendedor);

			rs = insereST.executeQuery();

			while (rs.next()) {

				Cliente cliente = new Cliente();

				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setId_vendedor(rs.getInt("id_vendedor"));
				cliente.setContato1(rs.getString("contato1"));
				cliente.setEmail1(rs.getString("email1"));
				cliente.setFoneCelular1(rs.getString("celular1"));
				cliente.setFoneFixo1(rs.getString("fixo1"));
				cliente.setContato2(rs.getString("contato2"));
				cliente.setEmail2(rs.getString("email2"));
				cliente.setFoneCelular2(rs.getString("celular2"));
				cliente.setFoneFixo2(rs.getString("fixo2"));
				cliente.setDetalhes(rs.getString("detalhes"));
				cliente.setEntrega(rs.getBoolean("entrega"));
				cliente.setUnidade(rs.getString("unidade"));
				cliente.setRazaoSocial(rs.getString("razaoSocial"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
				cliente.setInscricaoMunicipal(rs.getString("inscricaoMunicipal"));
				cliente.setClienteDesde(rs.getDate("clienteDesde"));
				cliente.setLogradouro(rs.getString("logradouro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCep(rs.getString("cep"));
				cliente.setUf(rs.getString("uf"));

				listaCliente.add(cliente);

			}

			return listaCliente;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao gerar a lista. Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				rs.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return listaCliente;

	}

	public void editarcliente(Cliente cliente) throws FileNotFoundException {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		PreparedStatement insereST = null;
		String sql = "";

		try {

			int index = 1;

			sql = "UPDATE cliente SET nome = ?,  id_vendedor  = ?, contato1 = ?, email1 = ?, celular1 = ?, fixo1 = ?, contato2 = ?, email2 = ?, celular2 = ?, fixo2 = ?, detalhes = ?, entrega = ?, unidade = ?, razaosocial = ?, cnpj = ?, inscricaoestadual = ?, inscricaomunicipal = ?, clienteDesde = ?, logradouro = ?, cidade = ?, bairro = ?, cep = ?, uf = ?  WHERE id_cliente = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(index, cliente.getNome());
			insereST.setInt(++index, cliente.getId_vendedor());
			insereST.setString(++index, cliente.getContato1());
			insereST.setString(++index, cliente.getEmail1());
			insereST.setString(++index, cliente.getFoneCelular1());
			insereST.setString(++index, cliente.getFoneFixo1());
			insereST.setString(++index, cliente.getContato2());
			insereST.setString(++index, cliente.getEmail2());
			insereST.setString(++index, cliente.getFoneCelular2());
			insereST.setString(++index, cliente.getFoneFixo2());
			insereST.setString(++index, cliente.getDetalhes());
			insereST.setBoolean(++index, cliente.isEntrega());
			insereST.setString(++index, cliente.getUnidade());
			insereST.setString(++index, cliente.getRazaoSocial());
			insereST.setString(++index, cliente.getCnpj());
			insereST.setString(++index, cliente.getInscricaoEstadual());
			insereST.setString(++index, cliente.getInscricaoMunicipal());
			insereST.setDate(++index, cliente.getClienteDesde());
			insereST.setString(++index, cliente.getLogradouro());
			insereST.setString(++index, cliente.getCidade());
			insereST.setString(++index, cliente.getBairro());
			insereST.setString(++index, cliente.getCep());
			insereST.setString(++index, cliente.getUf());
			insereST.setInt(++index, cliente.getId_cliente());

			insereST.executeUpdate();

			JOptionPane.showMessageDialog(null, "Cliente Alterado!");

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao alterar o cliente. Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

	}

	public Cliente selecionarCliente(int linha) throws FileNotFoundException {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		PreparedStatement insereST = null;
		ResultSet rs = null;
		String sql = "";

		Cliente cliente = new Cliente();

		try {

			sql = "SELECT * FROM cliente";

			insereST = conexao.prepareStatement(sql);
			rs = insereST.executeQuery();

			while (rs.next()) {

				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setId_vendedor(rs.getInt("id_vendedor"));
				cliente.setContato1(rs.getString("contato1"));
				cliente.setEmail1(rs.getString("email1"));
				cliente.setFoneCelular1(rs.getString("celular1"));
				cliente.setFoneFixo1(rs.getString("fixo1"));
				cliente.setContato2(rs.getString("contato2"));
				cliente.setEmail2(rs.getString("email2"));
				cliente.setFoneCelular2(rs.getString("celular2"));
				cliente.setFoneFixo2(rs.getString("fixo2"));
				cliente.setDetalhes(rs.getString("detalhes"));
				cliente.setEntrega(rs.getBoolean("entrega"));
				cliente.setUnidade(rs.getString("unidade"));
				cliente.setRazaoSocial(rs.getString("razaoSocial"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
				cliente.setInscricaoMunicipal(rs.getString("inscricaoMunicipal"));
				cliente.setClienteDesde(rs.getDate("clienteDesde"));
				cliente.setLogradouro(rs.getString("logradouro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCep(rs.getString("cep"));
				cliente.setUf(rs.getString("uf"));
			}

			return cliente;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao selecionar o cliente. Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return cliente;

	}

	public List<Cliente> pesquisarCliente(String pesquisarCliente) throws FileNotFoundException {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		PreparedStatement insereST = null;
		ResultSet rs = null;
		String sql = "";

		List<Cliente> listaCliente = new ArrayList<Cliente>();

		try {

			sql = "SELECT * FROM cliente WHERE nome like ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(1, "%" + pesquisarCliente + "%");

			rs = insereST.executeQuery();

			while (rs.next()) {

				Cliente cliente = new Cliente();

				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setId_vendedor(rs.getInt("id_vendedor"));
				cliente.setContato1(rs.getString("contato1"));
				cliente.setEmail1(rs.getString("email1"));
				cliente.setFoneCelular1(rs.getString("celular1"));
				cliente.setFoneFixo1(rs.getString("fixo1"));
				cliente.setContato2(rs.getString("contato2"));
				cliente.setEmail2(rs.getString("email2"));
				cliente.setFoneCelular2(rs.getString("celular2"));
				cliente.setFoneFixo2(rs.getString("fixo2"));
				cliente.setDetalhes(rs.getString("detalhes"));
				cliente.setEntrega(rs.getBoolean("entrega"));
				cliente.setUnidade(rs.getString("unidade"));
				cliente.setRazaoSocial(rs.getString("razaoSocial"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
				cliente.setInscricaoMunicipal(rs.getString("inscricaoMunicipal"));
				cliente.setClienteDesde(rs.getDate("clienteDesde"));
				cliente.setLogradouro(rs.getString("logradouro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCep(rs.getString("cep"));
				cliente.setUf(rs.getString("uf"));

				listaCliente.add(cliente);

			}

			return listaCliente;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao gerar a lista. Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				rs.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return listaCliente;

	}

	public int clienteOS(String nomecliente) throws FileNotFoundException {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		PreparedStatement insereST = null;
		ResultSet rs = null;
		String sql = "";
		int id_cliente = 0;

		try {

			sql = "SELECT * FROM cliente WHERE nome = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(1, nomecliente);

			rs = insereST.executeQuery();

			while (rs.next()) {

				id_cliente = rs.getInt("id_cliente");

			}

			return id_cliente;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Cliente não encontrado! Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				rs.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return id_cliente;

	}

	public Cliente mostrarCliente(int id_cliente) throws FileNotFoundException {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		PreparedStatement insereST = null;
		ResultSet rs = null;
		String sql = "";
		Cliente cliente = new Cliente();

		try {

			sql = "SELECT * FROM cliente WHERE id_cliente = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setInt(1, id_cliente);

			rs = insereST.executeQuery();

			while (rs.next()) {

				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setId_vendedor(rs.getInt("id_vendedor"));
				cliente.setContato1(rs.getString("contato1"));
				cliente.setEmail1(rs.getString("email1"));
				cliente.setFoneCelular1(rs.getString("celular1"));
				cliente.setFoneFixo1(rs.getString("fixo1"));
				cliente.setContato2(rs.getString("contato2"));
				cliente.setEmail2(rs.getString("email2"));
				cliente.setFoneCelular2(rs.getString("celular2"));
				cliente.setFoneFixo2(rs.getString("fixo2"));
				cliente.setDetalhes(rs.getString("detalhes"));
				cliente.setEntrega(rs.getBoolean("entrega"));
				cliente.setUnidade(rs.getString("unidade"));
				cliente.setRazaoSocial(rs.getString("razaoSocial"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
				cliente.setInscricaoMunicipal(rs.getString("inscricaomunicipal"));
				cliente.setClienteDesde(rs.getDate("clienteDesde"));
				cliente.setLogradouro(rs.getString("logradouro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCep(rs.getString("cep"));
				cliente.setUf(rs.getString("uf"));

			}

			return cliente;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Cliente não encontrado! Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				rs.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return cliente;

	}

	public boolean pesquisaCombo(String cliente) throws FileNotFoundException {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		PreparedStatement insereST = null;
		ResultSet rs = null;
		String sql = "";

		boolean contem = false;
		String nome = "";

		try {

			sql = "SELECT * FROM cliente WHERE nome = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(1, cliente);

			rs = insereST.executeQuery();

			while (rs.next()) {

				nome = rs.getString("nome");

				if (!nome.equals(""))

				{

					contem = true;
				}

			}

			return contem;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Cliente não encontrado! Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				rs.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return contem;

	}

	public String mostrarId_cliente(String nome) throws FileNotFoundException {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		PreparedStatement insereST = null;
		ResultSet rs = null;
		String sql = "";
		String id_cliente = null;

		try {

			sql = "SELECT * FROM cliente WHERE nome = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(1, nome);

			rs = insereST.executeQuery();

			while (rs.next()) {

				id_cliente = String.valueOf((rs.getInt("id_cliente")));

			}

			return id_cliente;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Cliente não encontrado! Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				rs.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return id_cliente;

	}

	public void excluirCliente(int id_cliente) throws FileNotFoundException {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		PreparedStatement insereST = null;
		String sql = "";

		try {

			sql = "DELETE FROM cliente WHERE id_cliente = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setInt(1, id_cliente);

			insereST.execute();
			insereST.close();

			JOptionPane.showMessageDialog(null, "O Cliente foi excluído do Banco de Dados!");

		} catch (SQLException e) {

			e.printStackTrace();

			JOptionPane.showMessageDialog(null, "O Cliente não foi excluído do  Banco de Dados! " + e);
		}

	}

	public Cliente mostrarClienteNome(String nome) throws FileNotFoundException {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		PreparedStatement insereST = null;
		ResultSet rs = null;
		String sql = "";
		Cliente cliente = new Cliente();

		try {

			sql = "SELECT * FROM cliente WHERE nome = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(1, nome);

			rs = insereST.executeQuery();

			while (rs.next()) {

				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setId_vendedor(rs.getInt("id_vendedor"));
				cliente.setContato1(rs.getString("contato1"));
				cliente.setEmail1(rs.getString("email1"));
				cliente.setFoneCelular1(rs.getString("celular1"));
				cliente.setFoneFixo1(rs.getString("fixo1"));
				cliente.setContato2(rs.getString("contato2"));
				cliente.setEmail2(rs.getString("email2"));
				cliente.setFoneCelular2(rs.getString("celular2"));
				cliente.setFoneFixo2(rs.getString("fixo2"));
				cliente.setDetalhes(rs.getString("detalhes"));
				cliente.setEntrega(rs.getBoolean("entrega"));
				cliente.setUnidade(rs.getString("unidade"));
				cliente.setRazaoSocial(rs.getString("razaoSocial"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
				cliente.setInscricaoMunicipal(rs.getString("inscricaomunicipal"));
				cliente.setClienteDesde(rs.getDate("clienteDesde"));
				cliente.setLogradouro(rs.getString("logradouro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCep(rs.getString("cep"));
				cliente.setUf(rs.getString("uf"));

			}

			return cliente;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Cliente não encontrado! Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				rs.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return cliente;

	}

	public boolean editarClienteCompleto(Cliente cliente) throws FileNotFoundException {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		boolean sucesso = false;

		PreparedStatement insereST = null;
		String sql = "";

		try {

			int index = 1;

			sql = "UPDATE cliente SET nome = ?,  contato1 = ?, email1 = ?, celular1 = ?, fixo1 = ?, contato2 = ?, email2 = ?, celular2 = ?, fixo2 = ?, detalhes = ?, entrega = ?, unidade = ?, razaosocial = ?, cnpj = ?, inscricaoestadual = ?, inscricaomunicipal = ?, clientedesde = ?, logradouro = ?, cidade = ?, bairro = ?, cep = ?, uf = ?, id_vendedor  = ?  WHERE id_cliente = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(index, cliente.getNome());
			insereST.setString(++index, cliente.getContato1());
			insereST.setString(++index, cliente.getEmail1());
			insereST.setString(++index, cliente.getFoneCelular1());
			insereST.setString(++index, cliente.getFoneFixo1());
			insereST.setString(++index, cliente.getContato2());
			insereST.setString(++index, cliente.getEmail2());
			insereST.setString(++index, cliente.getFoneCelular2());
			insereST.setString(++index, cliente.getFoneFixo2());
			insereST.setString(++index, cliente.getDetalhes());
			insereST.setBoolean(++index, cliente.isEntrega());
			insereST.setString(++index, cliente.getUnidade());
			insereST.setString(++index, cliente.getRazaoSocial());
			insereST.setString(++index, cliente.getCnpj());
			insereST.setString(++index, cliente.getInscricaoEstadual());
			insereST.setString(++index, cliente.getInscricaoMunicipal());
			insereST.setDate(++index, cliente.getClienteDesde());
			insereST.setString(++index, cliente.getLogradouro());
			insereST.setString(++index, cliente.getCidade());
			insereST.setString(++index, cliente.getBairro());
			insereST.setString(++index, cliente.getCep());
			insereST.setString(++index, cliente.getUf());
			insereST.setInt(++index, cliente.getId_vendedor());
			insereST.setInt(++index, cliente.getId_cliente());

			insereST.executeUpdate();

			sucesso = true;

			return sucesso;

		} catch (Exception e) {

			 JOptionPane.showMessageDialog(null, "Erro ao alterar o cliente. Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return sucesso;

	}

	public List<Cliente> ListarVendedores() throws FileNotFoundException {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		PreparedStatement insereST = null;
		ResultSet rs = null;
		String sql = "";

		List<Cliente> listaVendedores = new ArrayList<Cliente>();

		try {

			// sql = "SELECT DISTINCT vendedor FROM cliente order by vendedor
			// asc";

			sql = "SELECT * FROM cliente order by nome asc";

			insereST = conexao.prepareStatement(sql);
			rs = insereST.executeQuery();

			while (rs.next()) {

				Cliente cliente = new Cliente();

				cliente.setId_vendedor(rs.getInt("vendedor"));

				listaVendedores.add(cliente);

			}

			return listaVendedores;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao gerar a lista. Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				rs.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return listaVendedores;

	}

	public List<Cliente> listarClientesPorNome(String nome) throws FileNotFoundException {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		PreparedStatement insereST = null;
		ResultSet rs = null;
		String sql = "";

		List<Cliente> listaCliente = new ArrayList<Cliente>();

		try {

			sql = "SELECT * FROM cliente where nome like ? order by nome asc";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(1, "%" + nome + "%");

			rs = insereST.executeQuery();

			while (rs.next()) {

				Cliente cliente = new Cliente();

				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setId_vendedor(rs.getInt("id_vendedor"));
				cliente.setContato1(rs.getString("contato1"));
				cliente.setEmail1(rs.getString("email1"));
				cliente.setFoneCelular1(rs.getString("celular1"));
				cliente.setFoneFixo1(rs.getString("fixo1"));
				cliente.setContato2(rs.getString("contato2"));
				cliente.setEmail2(rs.getString("email2"));
				cliente.setFoneCelular2(rs.getString("celular2"));
				cliente.setFoneFixo2(rs.getString("fixo2"));
				cliente.setDetalhes(rs.getString("detalhes"));
				cliente.setEntrega(rs.getBoolean("entrega"));
				cliente.setUnidade(rs.getString("unidade"));
				cliente.setRazaoSocial(rs.getString("razaoSocial"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
				cliente.setInscricaoMunicipal(rs.getString("inscricaoMunicipal"));
				cliente.setClienteDesde(rs.getDate("clienteDesde"));
				cliente.setLogradouro(rs.getString("logradouro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCep(rs.getString("cep"));
				cliente.setUf(rs.getString("uf"));

				listaCliente.add(cliente);

			}

			return listaCliente;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao gerar a lista. Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				rs.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return listaCliente;

	}

	public List<Cliente> listarClientesPorNomeEVendedor(String nome, int id_vendedor) throws FileNotFoundException {
		
		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		PreparedStatement insereST = null;
		ResultSet rs = null;
		String sql = "";

		List<Cliente> listaCliente = new ArrayList<Cliente>();

		try {

			sql = "SELECT * FROM cliente where id_vendedor = ? and nome like ? order by nome asc";
			
			
			
			insereST = conexao.prepareStatement(sql);	
			insereST.setInt(1, id_vendedor);
			insereST.setString(2, "%" + nome + "%");				
			rs = insereST.executeQuery();

			while (rs.next()) {

				Cliente cliente = new Cliente();

				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setId_vendedor(rs.getInt("id_vendedor"));
				cliente.setContato1(rs.getString("contato1"));
				cliente.setEmail1(rs.getString("email1"));
				cliente.setFoneCelular1(rs.getString("celular1"));
				cliente.setFoneFixo1(rs.getString("fixo1"));
				cliente.setContato2(rs.getString("contato2"));
				cliente.setEmail2(rs.getString("email2"));
				cliente.setFoneCelular2(rs.getString("celular2"));
				cliente.setFoneFixo2(rs.getString("fixo2"));
				cliente.setDetalhes(rs.getString("detalhes"));
				cliente.setEntrega(rs.getBoolean("entrega"));
				cliente.setUnidade(rs.getString("unidade"));
				cliente.setRazaoSocial(rs.getString("razaoSocial"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
				cliente.setInscricaoMunicipal(rs.getString("inscricaoMunicipal"));
				cliente.setClienteDesde(rs.getDate("clienteDesde"));
				cliente.setLogradouro(rs.getString("logradouro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCep(rs.getString("cep"));
				cliente.setUf(rs.getString("uf"));

				listaCliente.add(cliente);

			}

			return listaCliente;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao gerar a lista. Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				rs.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return listaCliente;
	
	}

	public void mudarIdParaEmpresa(int id_vendedorExcluido) throws FileNotFoundException {
		
		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		PreparedStatement insereST = null;
		String sql = "";
		
		
		try {

			int index = 1;

		sql = "UPDATE cliente SET id_vendedor = 1 where id_vendedor = ?";

			insereST = conexao.prepareStatement(sql);
			
			insereST.setInt(+index, id_vendedorExcluido);
			
			insereST.executeUpdate();

		} catch (Exception e) {

			 JOptionPane.showMessageDialog(null, "Erro ao alterar o cliente. Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		
	}

}
