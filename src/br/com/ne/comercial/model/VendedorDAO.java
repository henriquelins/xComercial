package br.com.ne.comercial.model;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.ne.comercial.controller.Vendedor;

public class VendedorDAO {

	public int adicionarVendedor(Vendedor vendedor) {

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
		ResultSet rs = null;

		int id_vendedor = -1;

		try {

			int index = 1;

			sql = "INSERT INTO vendedor (nome, cargo, acesso, fonecomercial,  emailcomercial, fonepessoal, emailpessoal, login, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ? ,?) returning id_vendedor ";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(index, vendedor.getNome());
			insereST.setString(++index, vendedor.getCargo());
			insereST.setString(++index, vendedor.getAcesso());
			insereST.setString(++index, vendedor.getFoneComercial());
			insereST.setString(++index, vendedor.getEmailComercial());
			insereST.setString(++index, vendedor.getFonePessoal());
			insereST.setString(++index, vendedor.getEmailPessoal());
			insereST.setString(++index, vendedor.getLogin());
			insereST.setString(++index, vendedor.getSenha());

			rs = insereST.executeQuery();

			while (rs.next()) {

				id_vendedor = rs.getInt("id_vendedor");

			}

			return id_vendedor;

		} catch (Exception e) {

			//JOptionPane.showMessageDialog(null, "Erro ao inserir o Operador. Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				conexao.close();

			} catch (Exception e2) {

				//JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return id_vendedor;
	}

	public Vendedor login(String login, String senha) {

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
		ResultSet resultado= null;

		Vendedor vendedor = new Vendedor();

		try {

			sql = "SELECT * FROM vendedor WHERE login = ? AND senha = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(1, login);
			insereST.setString(2, senha);
			resultado = insereST.executeQuery();

			while (resultado.next()) {

				vendedor.setId_vendedor(resultado.getInt("id_vendedor"));
				vendedor.setNome(resultado.getString("nome"));
				vendedor.setCargo(resultado.getString("cargo"));
				vendedor.setFoneComercial(resultado.getString("fonecomercial"));
				vendedor.setEmailComercial(resultado.getString("emailcomercial"));
				vendedor.setFonePessoal(resultado.getString("fonepessoal"));
				vendedor.setEmailPessoal(resultado.getString("emailpessoal"));
				vendedor.setLogin(resultado.getString("login"));
				vendedor.setSenha(resultado.getString("senha"));
				vendedor.setAcesso(resultado.getString("acesso"));

			}

			return vendedor;

		} catch (Exception e) {

			// JOptionPane.showMessageDialog(null, "Erro ao inserir o Operador.
			// Mensagem: " + e.getMessage());

		} finally {

			try {
				
				resultado.close();
				insereST.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return vendedor;

	}

	public List<Vendedor> listaVendedor() throws FileNotFoundException {

		ConectarBanco conectarBanco = new ConectarBanco();
		Connection conexao = conectarBanco.geraConexao();

		PreparedStatement insereST = null;
		ResultSet rs = null;
		String sql = "";

		List<Vendedor> ListaVendedor = new ArrayList<Vendedor>();

		try {

			sql = "SELECT * FROM vendedor ORDER BY login ASC";

			insereST = conexao.prepareStatement(sql);
			rs = insereST.executeQuery();

			while (rs.next()) {

				Vendedor vendedor = new Vendedor();

				vendedor.setId_vendedor(rs.getInt("id_vendedor"));
				vendedor.setNome(rs.getString("nome"));
				vendedor.setCargo(rs.getString("cargo"));
				vendedor.setFoneComercial(rs.getString("fonecomercial"));
				vendedor.setEmailComercial(rs.getString("emailcomercial"));
				vendedor.setFonePessoal(rs.getString("fonepessoal"));
				vendedor.setEmailPessoal(rs.getString("emailpessoal"));
				vendedor.setLogin(rs.getString("login"));
				vendedor.setSenha(rs.getString("Senha"));
				vendedor.setAcesso(rs.getString("acesso"));

				ListaVendedor.add(vendedor);

			}

			return ListaVendedor;

		} catch (Exception e) {

			//JOptionPane.showMessageDialog(null, "Erro ao gerar a lista. Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				rs.close();
				conexao.close();

			} catch (Exception e2) {

				//JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return ListaVendedor;

	}

	public int buscarIdVendedor(String nome) {

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
		int id_vendedor = 0;

		try {

			sql = "SELECT id_vendedor FROM vendedor WHERE nome = ? ";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(1, nome);
			rs = insereST.executeQuery();

			while (rs.next()) {

				id_vendedor = rs.getInt("id_vendedor");

			}

			return id_vendedor;

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

		return id_vendedor;
	}

	public String buscarNomeVendedor(Integer id_vendedor) {

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
		String nome = "";

		try {

			sql = "SELECT nome FROM vendedor WHERE id_vendedor = ? ";

			insereST = conexao.prepareStatement(sql);

			insereST.setInt(1, id_vendedor);
			rs = insereST.executeQuery();

			while (rs.next()) {

				nome = rs.getString("nome");

			}

			return nome;

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

		return nome;

	}

	public List<Vendedor> buscarVendedores(String nome) {

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

		List<Vendedor> ListaVendedores = new ArrayList<Vendedor>();

		try {

			sql = "SELECT * FROM vendedor where nome like ? ORDER BY login ASC";

			insereST = conexao.prepareStatement(sql);
			insereST.setString(1, "%" + nome + "%");
			rs = insereST.executeQuery();

			while (rs.next()) {

				Vendedor vendedor = new Vendedor();

				vendedor.setId_vendedor(rs.getInt("id_vendedor"));
				vendedor.setNome(rs.getString("nome"));
				vendedor.setCargo(rs.getString("cargo"));
				vendedor.setFoneComercial(rs.getString("fonecomercial"));
				vendedor.setEmailComercial(rs.getString("emailcomercial"));
				vendedor.setFonePessoal(rs.getString("fonepessoal"));
				vendedor.setEmailPessoal(rs.getString("emailpessoal"));
				vendedor.setLogin(rs.getString("login"));
				vendedor.setSenha(rs.getString("Senha"));
				vendedor.setAcesso(rs.getString("acesso"));

				ListaVendedores.add(vendedor);

			}

			return ListaVendedores;

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

		return ListaVendedores;

	}

	public Vendedor mostrarVendedor(int id_vendedor) {

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
		ResultSet resultado = null;
		
		Vendedor vendedor = new Vendedor();

		try {

			sql = "SELECT * FROM vendedor WHERE id_vendedor = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setInt(1, id_vendedor);
			resultado = insereST.executeQuery();

			while (resultado.next()) {

				vendedor.setId_vendedor(resultado.getInt("id_vendedor"));
				vendedor.setNome(resultado.getString("nome"));
				vendedor.setCargo(resultado.getString("cargo"));
				vendedor.setFoneComercial(resultado.getString("fonecomercial"));
				vendedor.setEmailComercial(resultado.getString("emailcomercial"));
				vendedor.setFonePessoal(resultado.getString("fonepessoal"));
				vendedor.setEmailPessoal(resultado.getString("emailpessoal"));
				vendedor.setLogin(resultado.getString("login"));
				vendedor.setSenha(resultado.getString("senha"));
				vendedor.setAcesso(resultado.getString("acesso"));

			}

			return vendedor;

		} catch (Exception e) {

			// JOptionPane.showMessageDialog(null, "Erro ao inserir o Operador.
			// Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				resultado.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return vendedor;

	}

	public boolean editarVendedor(Vendedor vendedor) {

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

			sql = "UPDATE vendedor SET nome = ?,  cargo  = ?, acesso = ?, fonecomercial = ?, emailcomercial = ?, fonepessoal = ?, emailpessoal = ?, login = ?, senha = ? WHERE id_vendedor = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(index, vendedor.getNome());
			insereST.setString(++index, vendedor.getCargo());
			insereST.setString(++index, vendedor.getAcesso());
			insereST.setString(++index, vendedor.getFoneComercial());
			insereST.setString(++index, vendedor.getEmailComercial());
			insereST.setString(++index, vendedor.getFonePessoal());
			insereST.setString(++index, vendedor.getEmailPessoal());
			insereST.setString(++index, vendedor.getLogin());
			insereST.setString(++index, vendedor.getSenha());
			insereST.setInt(++index, vendedor.getId_vendedor());

			insereST.executeUpdate();

			sucesso = true;

			//JOptionPane.showMessageDialog(null, "Vendedor alterado!");

			return sucesso;

		} catch (Exception e) {

			// JOptionPane.showMessageDialog(null, "Erro ao alterar o vendedor.
			// Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				conexao.close();

			} catch (Exception e2) {

				//JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return sucesso;
	}

	public boolean excluirVendedor(int id_vendedor) throws SQLException {

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

			sql = "DELETE FROM vendedor WHERE id_vendedor = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setInt(1, id_vendedor);

			insereST.execute();
			insereST.close();

			//JOptionPane.showMessageDialog(null, "O Cliente foi excluído do Banco de Dados!");

			sucesso = true;

			return sucesso;

		} catch (SQLException e) {

			e.printStackTrace();
			insereST.close();
			
			//JOptionPane.showMessageDialog(null, "O Cliente não foi excluído do  Banco de Dados! " + e);
		}

		return sucesso;

	}

}
