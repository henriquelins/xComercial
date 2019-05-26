package br.com.ne.comercial.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.ne.comercial.model.LancamentoServicoDAO;

public class LancamentoServicoController {

	LancamentoServicoDAO lancamentoServicoDAO = new LancamentoServicoDAO();

	public boolean fazerLancamentoDoServico(LancamentoServico lancamentoServico) {

		boolean sucesso = false;

		sucesso = lancamentoServicoDAO.fazerLancamentoDoServico(lancamentoServico);

		return sucesso;
	}

	public List<LancamentoServico> listaLancamentoServicoPorData(java.sql.Date DataSql, java.sql.Date DataSql2) {

		List<LancamentoServico> listaLancamentoServicoPorData = new ArrayList<LancamentoServico>();

		listaLancamentoServicoPorData = lancamentoServicoDAO.listaLancamentoServicoPorData(DataSql, DataSql2);

		return listaLancamentoServicoPorData;
	}

	public List<LancamentoServico> listaLancamentoIdServicoPorData(Date dataSql, Date dataSql2, int id_clienteServico) {
		
		List<LancamentoServico> listaLancamentoServicoPorData = new ArrayList<LancamentoServico>();

		listaLancamentoServicoPorData = lancamentoServicoDAO.listaLancamentoIdServicoPorData(dataSql, dataSql2, id_clienteServico);

		return listaLancamentoServicoPorData;
		
	}

	public boolean editarLancamentoDoServico (LancamentoServico lancamentoServico) {
		
		boolean sucesso = true;
		
		sucesso = lancamentoServicoDAO.editarLancamentoDoServico(lancamentoServico);
		
		return sucesso;
		
	}
	
	
	
	
	

}
