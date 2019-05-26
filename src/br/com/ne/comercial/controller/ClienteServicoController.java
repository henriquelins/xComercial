package br.com.ne.comercial.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.ne.comercial.model.ClienteServicoDAO;
import br.com.ne.comercial.uteis.TabelaStatus;

public class ClienteServicoController {

	ClienteServicoDAO clienteServicoDAO = new ClienteServicoDAO();

	public boolean criarServicoCliente(ClienteServico clienteServico) {

		boolean sucesso = false;

		sucesso = clienteServicoDAO.criarServicoCliente(clienteServico);

		return sucesso;

	}

	public List<ClienteServico> listaServicoCliente(int id_cliente) {

		List<ClienteServico> listaServicoCliente = new ArrayList<ClienteServico>();

		listaServicoCliente = clienteServicoDAO.listaServicoCliente(id_cliente);

		return listaServicoCliente;

	}

	public ClienteServico buscarClienteServico(int id_clienteServico) {

		ClienteServico clienteServico = new ClienteServico();

		clienteServico = clienteServicoDAO.buscarClienteServico(id_clienteServico);

		return clienteServico;
	}

	public boolean atualizarSaldo(ClienteServico clienteServico) {

		boolean sucesso = false;

		sucesso = clienteServicoDAO.atualizarSaldo(clienteServico);

		return sucesso;
	}

	public List<TabelaStatus> todosServicos() {

		List<TabelaStatus> listaTabelaStatus = new ArrayList<TabelaStatus>();

		listaTabelaStatus = clienteServicoDAO.todosServicos();

		return listaTabelaStatus;
	}

	public List<TabelaStatus> todosServicosPorVendedor(int id_vendedor) {
		
		List<TabelaStatus> listaTabelaStatus = new ArrayList<TabelaStatus>();
		
		listaTabelaStatus = clienteServicoDAO.todosServicosPorVendedor(id_vendedor);

		return listaTabelaStatus;
	}

	public boolean editarServicoCliente(ClienteServico clienteTemp) {
	
		boolean sucesso = false;

		sucesso = clienteServicoDAO.editarServicoCliente(clienteTemp);

		return sucesso;
		
		
		
	}

	public boolean excluirServicoCliente(int id_clienteServico) {
		
		boolean sucesso = false;
		
		sucesso = clienteServicoDAO.excluirServicoCliente(id_clienteServico);
		
		return sucesso;
	}

	

}
