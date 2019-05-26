package br.com.ne.comercial.controller;

import java.net.ServerSocket;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.ne.comercial.model.ConectarBanco;
import br.com.ne.comercial.view.LoginComercialView;

public class AbrirComercial {

	// criação de ServerSocket para não permitir uma nova instância do programa
	private static ServerSocket s;

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {

		try {

			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

			//impede que seja criada uma nova instância do programa
			setS(new ServerSocket(10004));

			boolean sucesso = ConectarBanco.TesteConexão();

			if (sucesso) {

				AbrirComercial iniaciarAplicativo = new AbrirComercial();
				iniaciarAplicativo.Iniciar();

			} else {

				JOptionPane.showMessageDialog(null, "Erro ao abrir o banco de dados!", "Abrir Programa",
						JOptionPane.ERROR_MESSAGE);

				AbrirComercial iniaciarAplicativo = new AbrirComercial();
				iniaciarAplicativo.Iniciar();

			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "O programa já está aberto!", "Abrir Programa",
					JOptionPane.ERROR_MESSAGE);

		}

	}

	public void Iniciar() {

		try {

			LoginComercialView frame = new LoginComercialView();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static ServerSocket getS() {

		return s;

	}

	public static void setS(ServerSocket s) {

		AbrirComercial.s = s;

	}

}
