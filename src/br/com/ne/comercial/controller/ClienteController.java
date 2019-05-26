package br.com.ne.comercial.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import br.com.ne.comercial.model.ClienteDAO;

public class ClienteController {

	ClienteDAO clienteDAO = new ClienteDAO();
	Cliente cliente = new Cliente();
	List<Cliente> listaCliente = new ArrayList<Cliente>();

	public void adicionarCliente(Cliente cliente) throws FileNotFoundException {

		clienteDAO.adicionarCliente(cliente);

	}

	public boolean novoCliente(Cliente cliente) throws FileNotFoundException {

		boolean sucesso = clienteDAO.novoCliente(cliente);

		return sucesso;

	}

	public List<Cliente> listarClientes() throws FileNotFoundException {

		listaCliente = clienteDAO.listarClientes();

		return listaCliente;
	}

	
	public List<Cliente> listarClientesPorVendedor(int id_vendedor) throws FileNotFoundException {

		listaCliente = clienteDAO.listarClientesPorVendedor(id_vendedor);

		return listaCliente;
	}

	
	public List<Cliente> listarClientesPorNome(String nome) throws FileNotFoundException {

		listaCliente = clienteDAO.listarClientesPorNome(nome);

		return listaCliente;
	}
	
	
	public List<Cliente> listarClientesPorNomeEVendedor(String nome, int id_vendedor) throws FileNotFoundException {

		listaCliente = clienteDAO.listarClientesPorNomeEVendedor(nome, id_vendedor);

		return listaCliente;
	}
	
	
	public List<Cliente> listarVendedores() throws FileNotFoundException {

		List<Cliente> listaVendedores = new ArrayList<Cliente>();
		listaVendedores = clienteDAO.ListarVendedores();

		return listaVendedores;
	}

	public void editarcliente(Cliente cliente) throws FileNotFoundException {

		clienteDAO.editarcliente(cliente);

	}

	public Cliente selecionarCliente(int linha) throws FileNotFoundException {

		cliente = clienteDAO.selecionarCliente(linha);

		return cliente;

	}

	public List<Cliente> pesquisarCliente(String pesquisarCliente) throws FileNotFoundException {

		listaCliente = clienteDAO.pesquisarCliente(pesquisarCliente);

		return listaCliente;
	}

	public int clienteOS(String nomeCliente) throws FileNotFoundException {

		int id_cliente = clienteDAO.clienteOS(nomeCliente);

		return id_cliente;
	}

	public Cliente mostrarCliente(int id_cliente) throws FileNotFoundException {

		cliente = clienteDAO.mostrarCliente(id_cliente);

		return cliente;

	}

	public Cliente mostrarClienteNome(String nome) throws FileNotFoundException {

		cliente = clienteDAO.mostrarClienteNome(nome);

		return cliente;

	}

	public boolean pesquisaCombo(String cliente) throws FileNotFoundException {

		boolean contem = clienteDAO.pesquisaCombo(cliente);

		return contem;

	}

	public String mostrarId_cliente(String nome) throws FileNotFoundException {

		String id_cliente = clienteDAO.mostrarId_cliente(nome);

		return id_cliente;
	}

	public void excluirCliente(int id_cliente) throws FileNotFoundException {

		clienteDAO.excluirCliente(id_cliente);

	}

	public boolean editarClienteCompleto(Cliente clienteCompleto) throws FileNotFoundException {

		boolean sucesso = false;

		sucesso = clienteDAO.editarClienteCompleto(clienteCompleto);

		return sucesso;
	}

	public void mudarIdParaEmpresa(int id_vendedorExcluido) throws FileNotFoundException {
		
		clienteDAO.mudarIdParaEmpresa(id_vendedorExcluido);
		
	}

}
