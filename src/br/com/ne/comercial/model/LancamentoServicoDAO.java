package br.com.ne.comercial.model;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.ne.comercial.controller.LancamentoServico;

public class LancamentoServicoDAO {

	public boolean fazerLancamentoDoServico(LancamentoServico lancamentoServico) {

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

			sql = "INSERT INTO lancamentoservico (id_clienteservico, datadolancamento, quantidadedopedido, saldoanterior, saldoatual, observacoeslancamento ) VALUES (?, ?, ?, ?, ?, ?)";

			insereST = conexao.prepareStatement(sql);

			insereST.setInt(index, lancamentoServico.getId_clienteServico());
			insereST.setDate(++index, lancamentoServico.getDataDoLancamento());
			insereST.setInt(++index, lancamentoServico.getQuantidadeDoPedido());
			insereST.setInt(++index, lancamentoServico.getSaldoAnterior());
			insereST.setInt(++index, lancamentoServico.getSaldoAtual());
			insereST.setString(++index, lancamentoServico.getObservacoesLancamento());

			insereST.executeUpdate();

			sucesso = true;

		} catch (Exception e) {

			//JOptionPane.showMessageDialog(null, "Erro ao fazer o lançamento!" + e.getMessage());

		} finally {

			try {

				insereST.close();
				conexao.close();

			} catch (Exception e2) {

				//JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão! Mensagem: " + e2.getMessage());

			}

		}
		return sucesso;
	}

	public List<LancamentoServico> listaLancamentoServicoPorData(java.sql.Date DataSql, java.sql.Date DataSql2) {

		List<LancamentoServico> listaLancamentoServicoPorData = new ArrayList<LancamentoServico>();

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

		try {

			sql = "SELECT * FROM lancamentoservico WHERE datadolancamento between ? and ?";

			insereST = conexao.prepareStatement(sql);
			insereST.setDate(1, DataSql);
			insereST.setDate(2, DataSql2);
			rs = insereST.executeQuery();

			while (rs.next()) {

				LancamentoServico lancamentoServico = new LancamentoServico();

				lancamentoServico.setId_clienteServico(rs.getInt("id_clienteServico"));
				lancamentoServico.setDataDoLancamento(rs.getDate("datadolancamento"));
				lancamentoServico.setQuantidadeDoPedido(rs.getInt("quantidadedopedido"));
				lancamentoServico.setSaldoAnterior(rs.getInt("saldoanterior"));
				lancamentoServico.setSaldoAtual(rs.getInt("saldoatual"));
				lancamentoServico.setObservacoesLancamento(rs.getString("observacoeslancamento"));

				listaLancamentoServicoPorData.add(lancamentoServico);

			}

			return listaLancamentoServicoPorData;

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

		return listaLancamentoServicoPorData;

	}

	public List<LancamentoServico> listaLancamentoIdServicoPorData(java.sql.Date DataSql, java.sql.Date DataSql2, int id_clienteServico) {

		List<LancamentoServico> listaLancamentoServicoPorData = new ArrayList<LancamentoServico>();

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

		try {

			sql = "SELECT * FROM lancamentoservico WHERE datadolancamento between ? and ? and id_clienteservico = ?";

			insereST = conexao.prepareStatement(sql);
			insereST.setDate(1, DataSql);
			insereST.setDate(2, DataSql2);
			insereST.setInt(3, id_clienteServico);
;			rs = insereST.executeQuery();

			while (rs.next()) {

				LancamentoServico lancamentoServico = new LancamentoServico();

				lancamentoServico.setId_clienteServico(rs.getInt("id_clienteServico"));
				lancamentoServico.setDataDoLancamento(rs.getDate("datadolancamento"));
				lancamentoServico.setQuantidadeDoPedido(rs.getInt("quantidadedopedido"));
				lancamentoServico.setSaldoAnterior(rs.getInt("saldoanterior"));
				lancamentoServico.setSaldoAtual(rs.getInt("saldoatual"));
				lancamentoServico.setObservacoesLancamento(rs.getString("observacoeslancamento"));

				listaLancamentoServicoPorData.add(lancamentoServico);

			}

			return listaLancamentoServicoPorData;

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

		return listaLancamentoServicoPorData;

	}

	public boolean editarLancamentoDoServico(LancamentoServico lancamentoServico) {
		
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

			sql = "UPDATE lancamentoservico SET datadolancamento = ?, quantidadedopedido  = ?, saldoanterior = ?, saldoatual = ?, observacoeslancamento = ? WHERE id_lancamento = ?";

			insereST = conexao.prepareStatement(sql);
						
			insereST.setDate(++index, lancamentoServico.getDataDoLancamento());
			insereST.setInt(++index, lancamentoServico.getQuantidadeDoPedido());
			insereST.setInt(++index, lancamentoServico.getSaldoAnterior());
			insereST.setInt(++index, lancamentoServico.getSaldoAtual());
			insereST.setString(++index, lancamentoServico.getObservacoesLancamento());
			insereST.setInt(++index, lancamentoServico.getId_lancamento());

			insereST.executeUpdate();

			sucesso = true;
			
			return sucesso;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao editar o serviço. Mensagem: " + e.getMessage());

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

}
