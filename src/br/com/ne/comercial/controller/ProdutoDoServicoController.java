package br.com.ne.comercial.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.ne.comercial.model.ProdutoDoServicoDAO;

public class ProdutoDoServicoController {

	ProdutoDoServicoDAO produtoDoServicoDAO = new ProdutoDoServicoDAO();

	public boolean cadastrarProdutoDoServico(ProdutoDoServico produtoDoServico) {

		boolean sucesso = false;

		sucesso = produtoDoServicoDAO.cadastrarProdutoDoServico(produtoDoServico);

		return sucesso;

	}

	public boolean editarProdutoDoServico(ProdutoDoServico editarProdutoDoServico) {
		
		boolean sucesso = false;
		
		sucesso = produtoDoServicoDAO.editarProdutoDoServico(editarProdutoDoServico);
		
		return sucesso;

	}

	public boolean excluirProdutoDoServico(int id_produtoDoServico) {

		boolean sucesso = false;

		sucesso = produtoDoServicoDAO.excluirProdutoDoServico(id_produtoDoServico);

		return sucesso;

	}

	public List<ProdutoDoServico> todosOsProdutos() {

		List<ProdutoDoServico> listaProdutoDoServico = new ArrayList<ProdutoDoServico>();

		listaProdutoDoServico = produtoDoServicoDAO.todosOsProdutosDoServico();

		return listaProdutoDoServico;

	}

	public String buscarCodigo(String setor) {

		
		String codigo = produtoDoServicoDAO.buscarCodigo(setor);

		return codigo;
	}

	public List<ProdutoDoServico> buscaProduto(String nome) {
		
		List<ProdutoDoServico> listaProdutoDoServico = new ArrayList<ProdutoDoServico>();

		listaProdutoDoServico = produtoDoServicoDAO.buscaProduto(nome);

		return listaProdutoDoServico;
		
	}

	public ProdutoDoServico buscaProdutoDoServico(int id_produtoDoServico) {
		
		ProdutoDoServico produtoDoServico = new ProdutoDoServico();
		
		produtoDoServico = produtoDoServicoDAO.buscaProdutoDoServico(id_produtoDoServico);
		
		return produtoDoServico;
		
	}

}
