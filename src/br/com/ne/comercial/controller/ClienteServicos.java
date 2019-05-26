package br.com.ne.comercial.controller;

public class ClienteServicos {
	
	private int id_clienteServicos;
	private String nomeServico;
	private String descricaoServico;
		
	public ClienteServicos() {}

	public ClienteServicos(int id_clienteServicos, String nomeServico, String descricaoServico) {
		
		this.id_clienteServicos = id_clienteServicos;
		this.nomeServico = nomeServico;
		this.descricaoServico = descricaoServico;
	}

	public int getId_clienteServicos() {
		return id_clienteServicos;
	}

	public void setId_clienteServicos(int id_clienteServicos) {
		this.id_clienteServicos = id_clienteServicos;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricaoServico == null) ? 0 : descricaoServico.hashCode());
		result = prime * result + id_clienteServicos;
		result = prime * result + ((nomeServico == null) ? 0 : nomeServico.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteServicos other = (ClienteServicos) obj;
		if (descricaoServico == null) {
			if (other.descricaoServico != null)
				return false;
		} else if (!descricaoServico.equals(other.descricaoServico))
			return false;
		if (id_clienteServicos != other.id_clienteServicos)
			return false;
		if (nomeServico == null) {
			if (other.nomeServico != null)
				return false;
		} else if (!nomeServico.equals(other.nomeServico))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClienteServicos [id_clienteServicos=" + id_clienteServicos + ", nomeServico=" + nomeServico
				+ ", descricaoServico=" + descricaoServico + "]";
	}


	
	
	
}
