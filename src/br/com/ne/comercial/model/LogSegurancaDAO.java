package br.com.ne.comercial.model;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.ne.comercial.controller.LogSeguranca;

public class LogSegurancaDAO {

	public void novoLogSeguranca(LogSeguranca logSeguranca) {

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

			int index = 1;

			sql = "INSERT INTO logseguranca (logado, descricao, dataLog, horaLog) VALUES (?, ?, ?, ?)";

			insereST = conexao.prepareStatement(sql);

			insereST.setString(index, logSeguranca.getLogado());
			insereST.setString(++index, logSeguranca.getDescricao());
			insereST.setDate(++index, logSeguranca.getDataLog());
			insereST.setTime(++index, logSeguranca.getHoraLog());

			insereST.executeUpdate();

		} catch (Exception e) {

			// JOptionPane.showMessageDialog(null, "Erro ao inserir o lembrete!"
			// + e.getMessage());

		} finally {

			try {

				insereST.close();
				conexao.close();

			} catch (Exception e2) {

				// JOptionPane.showMessageDialog(null, "Erro ao encerrar a Conexão! Mensagem: "
				// + e2.getMessage());

			}

		}

	}

	public  List<LogSeguranca> listaLog() {

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

		List<LogSeguranca> listaLog = new ArrayList<LogSeguranca>();

		try {

			sql = "SELECT * FROM logseguranca ORDER BY id_logseguranca ASC";

			insereST = conexao.prepareStatement(sql);

			rs = insereST.executeQuery();

			while (rs.next()) {

				LogSeguranca logSeguranca = new LogSeguranca();

				logSeguranca.setId_logSeguranca(rs.getInt("id_logseguranca"));
				logSeguranca.setLogado(rs.getString("logado"));
				logSeguranca.setDescricao(rs.getString("descricao"));
				logSeguranca.setDataLog(rs.getDate("datalog"));
				logSeguranca.setHoraLog(rs.getTime("horalog"));

				listaLog.add(logSeguranca);

			}

			return listaLog;

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

		return listaLog;

	}

}
