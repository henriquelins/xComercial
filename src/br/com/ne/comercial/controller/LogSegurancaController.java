package br.com.ne.comercial.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.ne.comercial.model.LogSegurancaDAO;
import br.com.ne.comercial.view.LoginComercialView;

public class LogSegurancaController {
	
	
	public static void novoLogSeguranca(String descricao) {
		
		LogSeguranca logSeguranca = new LogSeguranca();
		logSeguranca.setLogado(LoginComercialView.getVendedor().getNome().toUpperCase());
		
		logSeguranca.setDescricao(descricao);
		
		Date dataLog = new Date(System.currentTimeMillis());
		logSeguranca.setDataLog(dataLog);
		
		Time hotaLog = new Time(System.currentTimeMillis());
		logSeguranca.setHoraLog(hotaLog);
		
		LogSegurancaDAO logSegurancaDAO = new LogSegurancaDAO();
		logSegurancaDAO.novoLogSeguranca(logSeguranca);
				
	}
	
	public List<LogSeguranca> listaLog(){
		
		List<LogSeguranca> listaLog = new ArrayList<LogSeguranca>();
		LogSegurancaDAO logSegurancaDAO = new LogSegurancaDAO();
		listaLog = logSegurancaDAO.listaLog();
		
		return listaLog;
		
	}
	
	
	

}
