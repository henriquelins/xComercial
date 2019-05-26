package br.com.ne.comercial.controller;

import java.sql.Date;
import java.sql.Time;

public class LogSeguranca {
	
	private int id_logSeguranca;
	private String logado;
	private String descricao;
	private Date dataLog;
	private Time horaLog;
	
	public LogSeguranca(){	}

	public LogSeguranca(int id_logSeguranca, String logado, String descricao, Date dataLog, Time horaLog) {
		this.id_logSeguranca = id_logSeguranca;
		this.logado = logado;
		this.descricao = descricao;
		this.dataLog = dataLog;
		this.horaLog = horaLog;
	}

	public int getId_logSeguranca() {
		return id_logSeguranca;
	}

	public void setId_logSeguranca(int id_logSeguranca) {
		this.id_logSeguranca = id_logSeguranca;
	}

	public String getLogado() {
		return logado;
	}

	public void setLogado(String logado) {
		this.logado = logado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataLog() {
		return dataLog;
	}

	public void setDataLog(Date dataLog) {
		this.dataLog = dataLog;
	}

	public Time getHoraLog() {
		return horaLog;
	}

	public void setHoraLog(Time horaLog) {
		this.horaLog = horaLog;
	}
	
	
	

}
