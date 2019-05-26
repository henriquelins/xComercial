package br.com.ne.comercial.controller;

import java.io.FileNotFoundException;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import br.com.ne.comercial.view.PrincipalComercialView;

public class EmailThreadComercial extends Thread {

	public EmailThreadComercial() {

	}

	public void run() {

		try {

			try {
				
				enviarEmailComercial();
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}

		} catch (EmailException e) {

			e.printStackTrace();
			
			try {
				erroAoEnviarEmailComercial(e);
			
			} catch (FileNotFoundException | EmailException e1) {
				
				e1.printStackTrace();
										
			}

		}

	}

	public void enviarEmailComercial() throws EmailException, FileNotFoundException {

		ClienteController clienteController = new ClienteController();
		VendedorController vendedorController = new VendedorController();

		Cliente cliente = new Cliente();
		cliente = clienteController.mostrarCliente(PrincipalComercialView.getClienteServico().getId_cliente());

		Vendedor vendedor = new Vendedor();
		vendedor = vendedorController.mostrarVendedor(cliente.getId_vendedor());

		// email html
		
		HtmlEmail email = new HtmlEmail();
		// host de envio smtp
		email.setHostName("smtp.uhserver.com");
		// porta smtp
		email.setSmtpPort(587);
		// login e senha do e-mail
		email.setAuthentication("crachas@nesolution.com.br", "!.Nesolution.!");
		// seu e-mail e nome
		email.setFrom("crachas@nesolution.com.br", "COMERCIAL");
		// assunto do e-mail
		email.setSubject("Prezado Vendedor " + vendedor.getLogin().toUpperCase());
		// mensagem

		// String id = email.embed(new
		// File(controller.IniciarAplicativo.email.getEndereco_imagem()));
		// imagem
		
		// Corpo do email
		StringBuilder builder = new StringBuilder();
		builder.append("<h1><font color=00044E>Atenção</h1></ font>");
		builder.append("<h1></h1>");
		builder.append("<h1><font color=00044E>" + vendedor.getLogin().toUpperCase() + ", o cliente "
				+ cliente.getNome() + " está com o saldo\n de "
				+ PrincipalComercialView.getClienteServico().getSaldoServico() + " unidade(s).</h1></ font>");
		builder.append("<h1><font color=00044E>Por favor entre em contato para renovar o saldo!</h1></ font>");

		email.setHtmlMsg(builder.toString());

		// e-mail a ser enviado e nome
		email.addTo("henriquelins@msn.com", vendedor.getNome().toUpperCase());
		// email.addTo(vendedor.getFoneComercial(), vendedor.getNome().toUpperCase());
		email.addCc("henriquelins@msn.com", "Henrique");

		// enviar
		try {
			
			email.send();
							
		} catch (EmailException e) {
			
			e.printStackTrace();		
			
		}
	}
	
	public void erroAoEnviarEmailComercial(EmailException e) throws EmailException, FileNotFoundException {
		
		ClienteController clienteController = new ClienteController();
		VendedorController vendedorController = new VendedorController();

		Cliente cliente = new Cliente();
		cliente = clienteController.mostrarCliente(PrincipalComercialView.getClienteServico().getId_cliente());

		Vendedor vendedor = new Vendedor();
		vendedor = vendedorController.mostrarVendedor(cliente.getId_vendedor());
		
		
		// email html
		HtmlEmail email = new HtmlEmail();
		// host de envio smtp
		email.setHostName("smtp.uhserver.com");
		// porta smtp
		email.setSmtpPort(587);
		// login e senha do e-mail
		email.setAuthentication("crachas@nesolution.com.br", "!.Nesolution.!");
		// seu e-mail e nome
		email.setFrom("crachas@nesolution.com.br", "COMERCIAL");
		// assunto do e-mail
		email.setSubject("Erro de envio de e-mail para o " + vendedor.getEmailComercial() + "!");
		
		// mensagem
		
		//String id = email.embed(new File(controller.IniciarAplicativo.email.getEndereco_imagem()));

		StringBuilder builder = new StringBuilder();
		builder.append("<h1><font color=00044E>E-mail não enviado!</h1></ font>");
		builder.append("<h1></h1>");
		builder.append("<p><font color=00044E>O e-mail não pôde ser enviado ao destinatário <b>" + cliente.getNome()
				+ "</b>, pois seu email está inválido ou vazio!</ font><p>");

		builder.append("<p><font color=00044E>Por Favor corrigir ou enviar o e-mail manualmente!</ font><p>");

		builder.append("<p><font color=00044E>Erro: " + e + "!</ font><p>");
		
		email.setHtmlMsg(builder.toString());

		// e-mail a ser enviado e nome
		email.addTo("henriquelins@msn.com", vendedor.getNome().toUpperCase());
		// email.addTo(vendedor.getFoneComercial(), vendedor.getNome().toUpperCase());
	    email.addCc("henriquelins@msn.com", "Henrique");

		// enviar
		try {
					
		email.send();
									
		} catch (EmailException e1) {
		
		e1.printStackTrace();		
					
		}
		
		
	}

}
