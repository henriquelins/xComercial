package br.com.ne.comercial.model;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.ne.comercial.controller.SetorDaEmpresa;

public class SetorDaEmpresaDAO {

	public boolean novoSetorDaEmpresa(SetorDaEmpresa setorDaEmpresa) {

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

			sql = "INSERT INTO setordaempresa (nomedosetordaempresa) VALUES (?)";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(index, setorDaEmpresa.getNomeDoSetorDaEmpresa());

			insereST.executeUpdate();

			sucesso = true;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao inserir o setor! " + e.getMessage());

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

	public List<SetorDaEmpresa> listaSetorDaEmpresa() {

		List<SetorDaEmpresa> listaSetorDaEmpresa = new ArrayList<SetorDaEmpresa>();
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

		try {

			sql = "SELECT * FROM setordaempresa order by nomedosetordaempresa asc";

			insereST = conexao.prepareStatement(sql);
			rs = insereST.executeQuery();

			while (rs.next()) {

				SetorDaEmpresa setorDaEmpresa = new SetorDaEmpresa();

				setorDaEmpresa.setId_setorDaEmpresa(rs.getInt("id_setorDaEmpresa"));
				setorDaEmpresa.setNomeDoSetorDaEmpresa(rs.getString("nomeDoSetorDaEmpresa"));

				listaSetorDaEmpresa.add(setorDaEmpresa);

			}

			return listaSetorDaEmpresa;

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

		return listaSetorDaEmpresa;
	}

	public boolean editarSetorDaEmpresa(SetorDaEmpresa setorDaEmpresa) {

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

			sql = "UPDATE setordaempresa SET nomedosetordaempresa = ? WHERE id_setordaempresa = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(index, setorDaEmpresa.getNomeDoSetorDaEmpresa());
			insereST.setInt(++index, setorDaEmpresa.getId_setorDaEmpresa());

			insereST.executeUpdate();

			sucesso = true;

			return sucesso;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao alterar o setor. Mensagem: " + e.getMessage());

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

	public void excluirSetorDaEmpresa(int id_setordaempresa) {

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

		try {

			sql = "DELETE FROM setordaempresa WHERE id_setordaempresa = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setInt(1, id_setordaempresa);

			insereST.execute();
			insereST.close();

			JOptionPane.showMessageDialog(null, "Setor excluído");

		} catch (SQLException e) {

			e.printStackTrace();

			JOptionPane.showMessageDialog(null, "Setor não foi excluído " + e);
		}

	}

	public int pesquisarSetorDaEmpresa(String nome) {

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
		int id_setordaempresa = 0;

		try {

			sql = "SELECT * FROM setordaempresa WHERE nomedosetordaempresa = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(1, nome);

			rs = insereST.executeQuery();

			while (rs.next()) {

				id_setordaempresa = rs.getInt("id_setordaempresa");

			}

			return id_setordaempresa;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Setor não encontrado! Mensagem: " + e.getMessage());

		} finally {

			try {

				insereST.close();
				rs.close();
				conexao.close();

			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão. Mensagem: " + e2.getMessage());

			}

		}

		return id_setordaempresa;

	}

}
