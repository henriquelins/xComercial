package br.com.ne.comercial.controller;

public class SetorDaEmpresa {

	private int id_setorDaEmpresa;
	private String nomeDoSetorDaEmpresa;
	
	public SetorDaEmpresa(){}

	public SetorDaEmpresa(int id_setorDaEmpresa, String nomeDoSetorDaEmpresa) {
		this.id_setorDaEmpresa = id_setorDaEmpresa;
		this.nomeDoSetorDaEmpresa = nomeDoSetorDaEmpresa;
	}

	public int getId_setorDaEmpresa() {
		return id_setorDaEmpresa;
	}

	public void setId_setorDaEmpresa(int id_setorDaEmpresa) {
		this.id_setorDaEmpresa = id_setorDaEmpresa;
	}

	public String getNomeDoSetorDaEmpresa() {
		return nomeDoSetorDaEmpresa;
	}

	public void setNomeDoSetorDaEmpresa(String nomeDoSetorDaEmpresa) {
		this.nomeDoSetorDaEmpresa = nomeDoSetorDaEmpresa;
	}
	
	
	
}
