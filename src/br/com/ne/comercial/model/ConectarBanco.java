package br.com.ne.comercial.model;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.ne.comercial.controller.LerBancoDados;

public class ConectarBanco {

	private static String login = "postgres";
	private static String senha = "1006";
	private static String host;
	private static String porta;
	private static String banco;
	private static String url;

	private static String driver;

	public Connection geraConexao() throws FileNotFoundException {

		Connection conexao = null;

		driver = "org.postgresql.Driver";

		LerBancoDados lerBancoDados = new LerBancoDados();
		lerBancoDados = LerBancoDados.lerDadosBanco();
		
	
		host = lerBancoDados.getHost();
		porta = lerBancoDados.getPorta();
		banco = lerBancoDados.getBanco();
		url = "jdbc:postgresql://" + host + ":" + porta + "/" + banco;

		try {

			Class.forName(driver);

			return DriverManager.getConnection(url, login, senha);

		} catch (ClassNotFoundException e) {

			// JOptionPane.showMessageDialog(null, "Classe não encontrada. Erro: " +
			// e.getMessage());

		} catch (SQLException e) {

			// JOptionPane.showMessageDialog(null, "Ocorreu um erro de SQL. Erro: " +
			// e.getMessage());

		}

		return conexao;
	}

	public static boolean TesteConexão() throws FileNotFoundException {

		boolean sucesso = false;

			driver = "org.postgresql.Driver";
			
			LerBancoDados lerBancoDados = new LerBancoDados();
			lerBancoDados = LerBancoDados.lerDadosBanco();
			
		
			host = lerBancoDados.getHost();
			porta = lerBancoDados.getPorta();
			banco = lerBancoDados.getBanco();
			url = "jdbc:postgresql://" + host + ":" + porta + "/" + banco;

			try {

				Class.forName(driver);

				if (!DriverManager.getConnection(url, login, senha).equals(null)) {

					// JOptionPane.showMessageDialog(null, "Conectado ao Banco");

				}

				sucesso = true;
				return sucesso;

			} catch (ClassNotFoundException e) {

				// JOptionPane.showMessageDialog(null, "Erro de acesso");

				return sucesso;

			} catch (SQLException e) {

				// JOptionPane.showMessageDialog(null, "Erro de acesso SQL");

				return sucesso;

			}


	}

	public static String getHost() {
		return host;
	}

	public static void setHost(String host) {
		ConectarBanco.host = host;
	}

	public static String getPorta() {
		return porta;
	}

	public static void setPorta(String porta) {
		ConectarBanco.porta = porta;
	}

	public static String getLogin() {
		return login;
	}

	public static void setLogin(String login) {
		ConectarBanco.login = login;
	}

	public static String getSenha() {
		return senha;
	}

	public static void setSenha(String senha) {
		ConectarBanco.senha = senha;
	}

	public static String getBanco() {
		return banco;
	}

	public static void setBanco(String banco) {
		ConectarBanco.banco = banco;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		ConectarBanco.url = url;
	}

	public static String getDriver() {
		return driver;
	}

}
