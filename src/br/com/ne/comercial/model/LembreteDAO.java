package br.com.ne.comercial.model;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.ne.comercial.controller.Lembrete;

public class LembreteDAO {

	public boolean novoLembrete(Lembrete lembrete) {

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

			sql = "INSERT INTO lembrete (id_vendedor, autor, assunto, descricao, datadolembrete) VALUES (?, ?, ?, ?, ?)";

			insereST = conexao.prepareStatement(sql);

			insereST.setInt(index, lembrete.getId_vendedor());
			insereST.setString(++index, lembrete.getAutor());
			insereST.setString(++index, lembrete.getAssunto());
			insereST.setString(++index, lembrete.getDescricao());
			insereST.setDate(++index, lembrete.getDataDoLembrete());

			insereST.executeUpdate();

			sucesso = true;

		} catch (Exception e) {

			// JOptionPane.showMessageDialog(null, "Erro ao inserir o lembrete!"
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

	public List<Lembrete> lembreteVendedor(int id_vendedor) {

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

		List<Lembrete> listaLembreteVendedor = new ArrayList<Lembrete>();

		try {

			sql = "SELECT * FROM lembrete WHERE id_vendedor = ? ORDER BY id_lembrete ASC";

			insereST = conexao.prepareStatement(sql);
			insereST.setInt(1, id_vendedor);
			rs = insereST.executeQuery();

			while (rs.next()) {

				Lembrete lembrete = new Lembrete();

				lembrete.setId_vendedor(rs.getInt("id_vendedor"));
				lembrete.setAutor(rs.getString("autor"));
				lembrete.setAssunto(rs.getString("assunto"));
				lembrete.setDescricao(rs.getString("descricao"));
				lembrete.setDataDoLembrete(rs.getDate("datadolembrete"));
				lembrete.setId_lembrete(rs.getInt("id_lembrete"));

				listaLembreteVendedor.add(lembrete);

			}

			return listaLembreteVendedor;

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

		return listaLembreteVendedor;

	}

	public boolean excluirLembrete(int id_lembrete) {

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

			sql = "DELETE FROM lembrete WHERE id_lembrete = ?";

			insereST = conexao.prepareStatement(sql);

			insereST.setInt(1, id_lembrete);

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
