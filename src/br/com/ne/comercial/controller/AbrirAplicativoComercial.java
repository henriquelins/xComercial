package br.com.ne.comercial.controller;

import java.net.ServerSocket;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.ne.comercial.model.ConectarBanco;
import br.com.ne.comercial.view.LoginComercialView;

public class AbrirAplicativoComercial {

	// cria��o de ServerSocket para n�o permitir uma nova inst�ncia do programa
	private static ServerSocket s;

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {

		try {

			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

			//impede que seja criada uma nova inst�ncia do programa
			setS(new ServerSocket(10004));

			boolean sucesso = ConectarBanco.TesteConex�o();

			if (sucesso) {

				AbrirAplicativoComercial iniaciarAplicativo = new AbrirAplicativoComercial();
				iniaciarAplicativo.Iniciar();

			} else {

				JOptionPane.showMessageDialog(null, "Erro ao abrir o banco de dados!", "Abrir Programa",
						JOptionPane.ERROR_MESSAGE);

				AbrirAplicativoComercial iniaciarAplicativo = new AbrirAplicativoComercial();
				iniaciarAplicativo.Iniciar();

			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "O programa j� est� aberto!", "Abrir Programa",
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

		AbrirAplicativoComercial.s = s;

	}

}
