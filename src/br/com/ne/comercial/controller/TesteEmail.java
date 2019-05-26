package br.com.ne.comercial.controller;

import java.io.FileNotFoundException;

import org.apache.commons.mail.EmailException;

public class TesteEmail {

	public static void main(String[] args) throws FileNotFoundException, EmailException {
		// TODO Auto-generated method stub
		
		new EmailThreadComercial().run();
		
		
		/*new Runnable() {
			public void run() {
				
				System.out.println("teste 2");
				
				ClienteController clienteController = new ClienteController();
				VendedorController vendedorController = new VendedorController();
				
				Cliente cliente = new Cliente();
				try {
					cliente = clienteController.mostrarCliente(1);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Vendedor vendedor = new Vendedor();
				vendedor = vendedorController.mostrarVendedor(cliente.getId_vendedor());		
				
				EmailComercial emailComercial = new EmailComercial();				
				//emailComercial.enviarEmailComercial(vendedor);
				
				try {
					emailComercial.enviarEmailComercial2(vendedor);
				} catch (EmailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};*/
		
		//System.out.println("teste 3");
	}

}
