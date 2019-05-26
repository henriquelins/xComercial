package br.com.ne.comercial.controller;

import java.sql.Date;

public class Lembrete {

	private int id_vendedor;
	private String autor;
	private String assunto;
	private String descricao;
	private Date dataDoLembrete;
	private int id_lembrete;

	public Lembrete() {
	}

	public Lembrete(int id_vendedor, String autor, String assunto, String descricao, Date dataDoLembrete,
			int id_lembrete) {
		this.id_vendedor = id_vendedor;
		this.autor = autor;
		this.assunto = assunto;
		this.descricao = descricao;
		this.dataDoLembrete = dataDoLembrete;
		this.id_lembrete = id_lembrete;
	}

	public int getId_vendedor() {
		return id_vendedor;
	}

	public void setId_vendedor(int id_vendedor) {
		this.id_vendedor = id_vendedor;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataDoLembrete() {
		return dataDoLembrete;
	}

	public void setDataDoLembrete(Date dataDoLembrete) {
		this.dataDoLembrete = dataDoLembrete;
	}

	public int getId_lembrete() {
		return id_lembrete;
	}

	public void setId_lembrete(int id_lembrete) {
		this.id_lembrete = id_lembrete;
	}

	
}
