package br.com.ne.comercial.model;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.ne.comercial.controller.ClienteServico;
import br.com.ne.comercial.uteis.TabelaStatus;

public class ClienteServicoDAO {

	public boolean criarServicoCliente(ClienteServico clienteServico) {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = null;
		try {
			conexao = conectarBanco.geraConexao();
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}

		PreparedStatement insereST = null;
		String sql = "";

		boolean sucesso = false;

		try {

			int index = 1;

			sql = "INSERT INTO clienteservico (nomedoservico, produtodoservico, cnpjdoservico, saldoservico, observacoesservicos, limiteminimo, valorunitario, id_cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(index, clienteServico.getNomeDoServico());
			insereST.setString(++index, clienteServico.getProdutoDoServico());
			insereST.setString(++index, clienteServico.getCnpjDoServico());
			insereST.setInt(++index, clienteServico.getSaldoServico());
			insereST.setString(++index, clienteServico.getObservacoesServico());
			insereST.setInt(++index, clienteServico.getLimiteMinimo());
			insereST.setDouble(++index, clienteServico.getValorUnitario());
			insereST.setInt(++index, clienteServico.getId_cliente());

			insereST.executeUpdate();

			sucesso = true;

		} catch (Exception e) {

			// JOptionPane.showMessageDialog(null, "Erro ao criar a conta! " +
			// e.getMessage());

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

	public List<ClienteServico> listaServicoCliente(int id_cliente) {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = null;
		try {
			conexao = conectarBanco.geraConexao();
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}

		PreparedStatement insereST = null;
		ResultSet rs = null;
		String sql = "";

		List<ClienteServico> listaServicoCliente = new ArrayList<ClienteServico>();

		try {

			sql = "SELECT * FROM clienteservico WHERE id_cliente = ? ORDER BY nomedoservico ASC";

			insereST = conexao.prepareStatement(sql);
			insereST.setInt(1, id_cliente);
			rs = insereST.executeQuery();

			while (rs.next()) {

				ClienteServico clienteServico = new ClienteServico();

				clienteServico.setId_clienteServico(rs.getInt("id_clienteservico"));
				clienteServico.setNomeDoServico(rs.getString("nomedoservico"));
				clienteServico.setProdutoDoServico(rs.getString("produtodoservico"));
				clienteServico.setCnpjDoServico(rs.getString("cnpjdoservico"));
				clienteServico.setSaldoServico(rs.getInt("saldoservico"));
				clienteServico.setObservacoesServico(rs.getString("observacoesservicos"));
				clienteServico.setLimiteMinimo(rs.getInt("limiteminimo"));
				clienteServico.setValorUnitario(rs.getInt("valorunitario"));
				clienteServico.setId_cliente(rs.getInt("id_cliente"));

				listaServicoCliente.add(clienteServico);

			}

			return listaServicoCliente;

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

		return listaServicoCliente;

	}

	public ClienteServico buscarClienteServico(int id_clienteServico) {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = null;
		try {
			conexao = conectarBanco.geraConexao();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PreparedStatement insereST = null;
		ResultSet rs = null;
		String sql = "";

		ClienteServico clienteServico = new ClienteServico();

		try {

			sql = "SELECT * FROM clienteservico WHERE id_clienteservico = ?";

			insereST = conexao.prepareStatement(sql);
			insereST.setInt(1, id_clienteServico);
			rs = insereST.executeQuery();

			while (rs.next()) {

				clienteServico.setId_cliente(rs.getInt("id_cliente"));
				clienteServico.setNomeDoServico(rs.getString("nomedoservico"));
				clienteServico.setProdutoDoServico(rs.getString("produtodoservico"));
				clienteServico.setCnpjDoServico(rs.getString("cnpjdoservico"));
				clienteServico.setSaldoServico(rs.getInt("saldoservico"));
				clienteServico.setObservacoesServico(rs.getString("observacoesservicos"));
				clienteServico.setLimiteMinimo(rs.getInt("limiteminimo"));
				clienteServico.setValorUnitario(rs.getInt("valorunitario"));
				clienteServico.setId_clienteServico(rs.getInt("id_clienteServico"));

			}

			return clienteServico;

		} catch (Exception e) {

			// JOptionPane.showMessageDialog(null, "Erro ao gerar a lista.
			// Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				rs.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return clienteServico;

	}

	public boolean atualizarSaldo(ClienteServico clienteServico) {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = null;
		try {
			conexao = conectarBanco.geraConexao();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PreparedStatement insereST = null;
		String sql = "";

		boolean sucesso = false;

		try {

			int index = 1;

			sql = "UPDATE clienteservico SET saldoservico = ?  WHERE id_clienteservico = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setInt(index, clienteServico.getSaldoServico());
			insereST.setInt(++index, clienteServico.getId_clienteServico());

			insereST.executeUpdate();

			sucesso = true;

		} catch (Exception e) {

			// JOptionPane.showMessageDialog(null, "Erro ao salvar o saldo. Mensagem: " +
			// e.getMessage());

		} finally {

			try {

				insereST.close();
				conexao.close();

			} catch (Exception e2) {

				// JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: "
				// + e2.getMessage());

			}

		}
		return sucesso;

	}

	public List<TabelaStatus> todosServicosPorVendedor(int id_vendedor) {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = null;
		try {
			conexao = conectarBanco.geraConexao();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PreparedStatement insereST = null;
		ResultSet rs = null;
		String sql = "";

		List<TabelaStatus> listaTabelaStatus = new ArrayList<TabelaStatus>();

		try {

			sql = "select * from cliente as c inner join clienteservico as cs on c.id_cliente = cs.id_cliente where c.id_vendedor = ? ORDER BY nomedoservico ASC";

			insereST = conexao.prepareStatement(sql);
			insereST.setInt(1, id_vendedor);
			rs = insereST.executeQuery();

			while (rs.next()) {
				
				TabelaStatus tabelaStatus = new TabelaStatus();
						
				if ((rs.getInt("limiteminimo") >= rs.getInt("saldoservico")) == true) {			
					
					tabelaStatus.setCliente(rs.getString("nome"));
					tabelaStatus.setServico(rs.getString("nomedoservico"));
					tabelaStatus.setId_vendedor(rs.getInt("id_vendedor"));
					tabelaStatus.setSaldo(rs.getInt("saldoservico"));
					tabelaStatus.setLimiteMinimo(rs.getInt("limiteminimo"));

					listaTabelaStatus.add(tabelaStatus);

				}

			}

			return listaTabelaStatus;

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

		return listaTabelaStatus;
	}

	public List<TabelaStatus> todosServicos() {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = null;
		try {
			conexao = conectarBanco.geraConexao();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PreparedStatement insereST = null;
		ResultSet rs = null;
		String sql = "";

		List<TabelaStatus> listaTabelaStatus = new ArrayList<TabelaStatus>();

		try {

			sql = "select * from cliente as c inner join clienteservico as cs on c.id_cliente = cs.id_cliente ORDER BY nomedoservico ASC";

			insereST = conexao.prepareStatement(sql);
			rs = insereST.executeQuery();

			while (rs.next()) {
				
				TabelaStatus tabelaStatus = new TabelaStatus();
				
				if ((rs.getInt("limiteminimo") >= rs.getInt("saldoservico")) == true) {

					tabelaStatus.setCliente(rs.getString("nome"));
					tabelaStatus.setServico(rs.getString("nomedoservico"));
					tabelaStatus.setId_vendedor(rs.getInt("id_vendedor"));
					tabelaStatus.setSaldo(rs.getInt("saldoservico"));
					tabelaStatus.setLimiteMinimo(rs.getInt("limiteminimo"));

					listaTabelaStatus.add(tabelaStatus);

				}

			}

			return listaTabelaStatus;

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

		return listaTabelaStatus;

	}

	public boolean editarServicoCliente(ClienteServico clienteTemp) {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = null;
		try {
			conexao = conectarBanco.geraConexao();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PreparedStatement insereST = null;
		String sql = "";

		boolean sucesso = false;

		try {

			int index = 1;

			sql = "UPDATE clienteservico SET nomedoservico = ?,  produtodoservico  = ?, cnpjdoservico = ?, saldoservico = ?, observacoesservicos = ?, limiteminimo = ?, valorunitario = ?, id_cliente = ? WHERE id_clienteservico = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(index, clienteTemp.getNomeDoServico());
			insereST.setString(++index, clienteTemp.getProdutoDoServico());
			insereST.setString(++index, clienteTemp.getCnpjDoServico());
			insereST.setInt(++index, clienteTemp.getSaldoServico());
			insereST.setString(++index, clienteTemp.getObservacoesServico());
			insereST.setInt(++index, clienteTemp.getLimiteMinimo());
			insereST.setDouble(++index, clienteTemp.getValorUnitario());
			insereST.setInt(++index, clienteTemp.getId_cliente());
			insereST.setInt(++index, clienteTemp.getId_clienteServico());

			insereST.executeUpdate();

			sucesso = true;

		} catch (Exception e) {

			// JOptionPane.showMessageDialog(null, "Erro ao editar o Serviço. Mensagem: " +
			// e.getMessage());

		} finally {

			try {

				insereST.close();
				conexao.close();

			} catch (Exception e2) {

				// JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: "
				// + e2.getMessage());

			}

		}
		return sucesso;
	}

	public boolean excluirServicoCliente(int id_clienteServico) {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = null;
		try {
			conexao = conectarBanco.geraConexao();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		boolean sucesso = false;

		PreparedStatement insereST = null;
		String sql = "";

		try {

			sql = "DELETE FROM clienteservico WHERE id_clienteservico = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setInt(1, id_clienteServico);

			insereST.execute();
			insereST.close();

			sucesso = true;

			return sucesso;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return sucesso;

	}

}
