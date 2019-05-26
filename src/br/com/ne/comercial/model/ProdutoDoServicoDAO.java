package br.com.ne.comercial.model;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.ne.comercial.controller.ProdutoDoServico;

public class ProdutoDoServicoDAO {

	public boolean cadastrarProdutoDoServico(ProdutoDoServico produtoDoServico) {

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

			sql = "INSERT INTO produtodoservico (nomedoproduto, codprodutodoservico, setorprodutodoservico, descricaoprodutodoservico, valorunitariodoproduto, quantidadedoproduto) VALUES (?, ?, ?, ?, ?, ?)";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(index, produtoDoServico.getNomeDoProduto());
			insereST.setString(++index, produtoDoServico.getCodProdutoDoServico());
			insereST.setString(++index, produtoDoServico.getSetorProdutoDoServico());
			insereST.setString(++index, produtoDoServico.getDescricaorodutoDoServico());
			insereST.setDouble(++index, produtoDoServico.getValorUnitarioDoProduto());
			insereST.setInt(++index, produtoDoServico.getQuantidadeDoProduto());

			insereST.executeUpdate();

			sucesso = true;

			return sucesso;

		} catch (Exception e) {

			// JOptionPane.showMessageDialog(null, "Erro ao inserir o produto!" +
			// e.getMessage());

		} finally {

			try {

				insereST.close();
				conexao.close();

			} catch (Exception e2) {

				// JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão! Mensagem: "
				// + e2.getMessage());

			}

		}

		return sucesso;

	}

	public boolean editarProdutoDoServico(ProdutoDoServico produtoDoServico) {

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

			sql = "UPDATE produtodoservico SET nomedoproduto = ?, codprodutodoservico = ?, setorprodutodoservico = ?, descricaoprodutodoservico = ?, valorunitariodoproduto = ?, quantidadedoproduto = ?  WHERE id_produtodoservico = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(index, produtoDoServico.getNomeDoProduto());
			insereST.setString(++index, produtoDoServico.getCodProdutoDoServico());
			insereST.setString(++index, produtoDoServico.getSetorProdutoDoServico());
			insereST.setString(++index, produtoDoServico.getDescricaorodutoDoServico());
			insereST.setDouble(++index, produtoDoServico.getValorUnitarioDoProduto());
			insereST.setInt(++index, produtoDoServico.getQuantidadeDoProduto());
			insereST.setInt(++index, produtoDoServico.getId_produtoDoServico());

			insereST.executeUpdate();

			sucesso = true;

			return sucesso;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao alterar o produto. Mensagem: " + e.getMessage());

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

	public boolean excluirProdutoDoServico(int id_produtoDoServico) {

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

			sql = "DELETE FROM produtodoservico WHERE id_produtodoservico = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setInt(1, id_produtoDoServico);

			insereST.execute();
			insereST.close();

			sucesso = true;

			return sucesso;

		} catch (SQLException e) {

			e.printStackTrace();

			JOptionPane.showMessageDialog(null, "O produto não foi excluído do Banco de Dados! " + e);
		}

		return sucesso;

	}

	public List<ProdutoDoServico> todosOsProdutosDoServico() {

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

		List<ProdutoDoServico> listaProdutoDoServico = new ArrayList<ProdutoDoServico>();

		try {

			sql = "SELECT * FROM produtodoservico order by nomedoproduto asc";

			insereST = conexao.prepareStatement(sql);
			rs = insereST.executeQuery();

			while (rs.next()) {

				ProdutoDoServico produtoDoServico = new ProdutoDoServico();

				produtoDoServico.setId_produtoDoServico(rs.getInt("id_produtodoservico"));
				produtoDoServico.setNomeDoProduto(rs.getString("nomedoproduto"));
				produtoDoServico.setCodProdutoDoServico(rs.getString("codprodutodoservico"));
				produtoDoServico.setSetorProdutoDoServico(rs.getString("setorprodutodoservico"));
				produtoDoServico.setDescricaorodutoDoServico(rs.getString("descricaoprodutodoservico"));
				produtoDoServico.setValorUnitarioDoProduto(rs.getDouble("valorunitariodoproduto"));
				produtoDoServico.setQuantidadeDoProduto(rs.getInt("quantidadedoproduto"));

				listaProdutoDoServico.add(produtoDoServico);

			}

			return listaProdutoDoServico;

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

		return listaProdutoDoServico;

	}

	public String buscarCodigo(String setor) {

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

		String codigo = "";

		try {

			sql = "SELECT codprodutodoservico FROM produtodoservico where codprodutodoservico like ? order by codprodutodoservico asc";

			insereST = conexao.prepareStatement(sql);
			insereST.setString(1, "%" + setor + "%");
			rs = insereST.executeQuery();

			while (rs.next()) {

				codigo = rs.getString("codprodutodoservico");

			}

			return codigo;

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

		return codigo;

	}

	public List<ProdutoDoServico> buscaProduto(String nome) {

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

		List<ProdutoDoServico> listaProdutoDoServico = new ArrayList<ProdutoDoServico>();

		try {

			sql = "SELECT * FROM produtodoservico where nomedoproduto like ? order by nomedoproduto asc";

			insereST = conexao.prepareStatement(sql);
			insereST.setString(1, "%" + nome + "%");
			rs = insereST.executeQuery();

			while (rs.next()) {

				ProdutoDoServico produtoDoServico = new ProdutoDoServico();

				produtoDoServico.setId_produtoDoServico(rs.getInt("id_produtodoservico"));
				produtoDoServico.setNomeDoProduto(rs.getString("nomedoproduto"));
				produtoDoServico.setCodProdutoDoServico(rs.getString("codprodutodoservico"));
				produtoDoServico.setSetorProdutoDoServico(rs.getString("setorprodutodoservico"));
				produtoDoServico.setDescricaorodutoDoServico(rs.getString("descricaoprodutodoservico"));
				produtoDoServico.setValorUnitarioDoProduto(rs.getDouble("valorunitariodoproduto"));
				produtoDoServico.setQuantidadeDoProduto(rs.getInt("quantidadedoproduto"));

				listaProdutoDoServico.add(produtoDoServico);

			}

			return listaProdutoDoServico;

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

		return listaProdutoDoServico;

	}

	public ProdutoDoServico buscaProdutoDoServico(int id_produtoDoServico) {

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

		ProdutoDoServico produtoDoServico = new ProdutoDoServico();

		try {

			sql = "SELECT * FROM produtodoservico where id_produtodoservico = ?";

			insereST = conexao.prepareStatement(sql);
			insereST.setInt(1, id_produtoDoServico);
			rs = insereST.executeQuery();

			while (rs.next()) {

				produtoDoServico.setId_produtoDoServico(rs.getInt("id_produtodoservico"));
				produtoDoServico.setNomeDoProduto(rs.getString("nomedoproduto"));
				produtoDoServico.setCodProdutoDoServico(rs.getString("codprodutodoservico"));
				produtoDoServico.setSetorProdutoDoServico(rs.getString("setorprodutodoservico"));
				produtoDoServico.setDescricaorodutoDoServico(rs.getString("descricaoprodutodoservico"));
				produtoDoServico.setValorUnitarioDoProduto(rs.getDouble("valorunitariodoproduto"));
				produtoDoServico.setQuantidadeDoProduto(rs.getInt("quantidadedoproduto"));

			}

			return produtoDoServico;

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

		return produtoDoServico;

	}

}
