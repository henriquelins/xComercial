package br.com.ne.comercial.controller;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ne.comercial.model.VendedorDAO;

public class VendedorController {

	VendedorDAO vendedorDAO = new VendedorDAO();

	public int adicionarVendedor(Vendedor vendedor) {

		int id_operador = 0;

		id_operador = vendedorDAO.adicionarVendedor(vendedor);

		return id_operador;

	}
	
	public Vendedor login(String login, String senha) {

		Vendedor vendedor = new Vendedor();

		vendedor = vendedorDAO.login(login, senha);

		return vendedor;

	}
	
	public List<Vendedor> listaVendedor() throws FileNotFoundException {

		List<Vendedor> listaVendedor = new ArrayList<Vendedor>();

		listaVendedor = vendedorDAO.listaVendedor();

		return listaVendedor;

	}

	public int buscarIdVendedor(String nome) {
		
		int id_vendedor = vendedorDAO.buscarIdVendedor(nome);
		
		return id_vendedor;
	}

	public String buscarNomeVendedor(Integer id_vendedor) {
		
		String nome = vendedorDAO.buscarNomeVendedor(id_vendedor);
		
		return nome;
	}

	public List<Vendedor> buscarVendedores(String nome) {
		
		List<Vendedor> listaVendedores = new ArrayList<Vendedor>();

		listaVendedores = vendedorDAO.buscarVendedores(nome);

		return listaVendedores;
		
		
	}

	public Vendedor mostrarVendedor(int id_vendedor) {
		
		Vendedor vendedor = new Vendedor();
		
		vendedor = vendedorDAO.mostrarVendedor(id_vendedor);
		
		return vendedor;
	}

	public boolean editarVendedor(Vendedor vendedor) {
		
		boolean sucesso = false;
		
		sucesso = vendedorDAO.editarVendedor(vendedor);
				
		return sucesso;
		
	}

	public boolean excluirVendedor(int id_vendedor) throws SQLException {
		
		boolean sucesso = false;
		
		sucesso = vendedorDAO.excluirVendedor(id_vendedor);
				
		return sucesso;
	}
	

}
