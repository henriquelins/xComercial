package br.com.ne.comercial.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.ne.comercial.model.SetorDaEmpresaDAO;

public class SetorDaEmpresaController {

	SetorDaEmpresaDAO setorDaEmpresaDAO = new SetorDaEmpresaDAO();
	
	public boolean novoSetorDaEmpresa(SetorDaEmpresa setorDaEmpresa){
		
		boolean sucesso = false;
		
		sucesso = setorDaEmpresaDAO.novoSetorDaEmpresa(setorDaEmpresa);
		
		return sucesso;
	}
	
	public List<SetorDaEmpresa> listaSetorDaEmpresa (){
		
		List<SetorDaEmpresa> listaSetorDaEmpresa = new ArrayList<SetorDaEmpresa>();
		
		listaSetorDaEmpresa = setorDaEmpresaDAO.listaSetorDaEmpresa();
		
		return listaSetorDaEmpresa;
	}
	
	public boolean editarSetorDaEmpresa(SetorDaEmpresa setorDaEmpresa){
		
		boolean sucesso = false;
		
		sucesso = setorDaEmpresaDAO.editarSetorDaEmpresa(setorDaEmpresa);
		
		return sucesso;
	}
	
	public void excluirSetorDaEmpresa(int id_setordaempresa){
		
		setorDaEmpresaDAO.excluirSetorDaEmpresa(id_setordaempresa);
				
	}
	
	public int pesquisarSetorDaEmpresa(String nome){
		
		int id_setorDaEmpresa = setorDaEmpresaDAO.pesquisarSetorDaEmpresa(nome);
		
		return id_setorDaEmpresa;
	}
	
	
	
}
