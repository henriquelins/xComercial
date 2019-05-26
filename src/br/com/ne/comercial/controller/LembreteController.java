package br.com.ne.comercial.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.ne.comercial.model.LembreteDAO;


public class LembreteController {
	
	LembreteDAO lembreteDAO = new LembreteDAO();
	List<Lembrete> listalembrete = new ArrayList<Lembrete>();

	public boolean novoLembrete(Lembrete lembrete) {

		boolean sucesso = lembreteDAO.novoLembrete(lembrete);

		return sucesso;

	}

	public List<Lembrete> lembreteVendedor(int id_vendedor) {
		
		List<Lembrete> listaLembreteVendedor = new ArrayList<Lembrete>();
		
		listaLembreteVendedor = lembreteDAO.lembreteVendedor(id_vendedor);
		
		return listaLembreteVendedor;
		
	}

	public void excluirLembrete() {
		// TODO Auto-generated method stub
		
	}

	public boolean excluirLembrete(int id_lembrete) {
		
		boolean sucesso = lembreteDAO.excluirLembrete(id_lembrete);

		return sucesso;
	}
	

}
