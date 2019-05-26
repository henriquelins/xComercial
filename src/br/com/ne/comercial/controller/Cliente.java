package br.com.ne.comercial.controller;

import java.sql.Date;

public class Cliente {

	private int id_cliente;
	private String nome;
		
	private String contato1;
	private String email1;
	private String foneCelular1;
	private String foneFixo1;
	
	private String contato2;
	private String email2;
	private String foneCelular2;
	private String foneFixo2;
	
	private String detalhes;
	private boolean entrega;
	private String unidade;

	private String razaoSocial;
	private String cnpj;
	private String inscricaoEstadual;
	private String inscricaoMunicipal;
	private Date clienteDesde;

	private String logradouro;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	
	private Integer id_vendedor;

	public Cliente() {
	}

	public Cliente(int id_cliente, String nome, String contato1, String email1, String foneCelular1, String foneFixo1,
			String contato2, String email2, String foneCelular2, String foneFixo2, String detalhes, boolean entrega,
			String unidade, String razaoSocial, String cnpj, String inscricaoEstadual, String inscricaoMunicipal,
			Date clienteDesde, String logradouro, String bairro, String cidade, String uf, String cep,
			Integer id_vendedor) {
		
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.contato1 = contato1;
		this.email1 = email1;
		this.foneCelular1 = foneCelular1;
		this.foneFixo1 = foneFixo1;
		this.contato2 = contato2;
		this.email2 = email2;
		this.foneCelular2 = foneCelular2;
		this.foneFixo2 = foneFixo2;
		this.detalhes = detalhes;
		this.entrega = entrega;
		this.unidade = unidade;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.clienteDesde = clienteDesde;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.id_vendedor = id_vendedor;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato1() {
		return contato1;
	}

	public void setContato1(String contato1) {
		this.contato1 = contato1;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getFoneCelular1() {
		return foneCelular1;
	}

	public void setFoneCelular1(String foneCelular1) {
		this.foneCelular1 = foneCelular1;
	}

	public String getFoneFixo1() {
		return foneFixo1;
	}

	public void setFoneFixo1(String foneFixo1) {
		this.foneFixo1 = foneFixo1;
	}

	public String getContato2() {
		return contato2;
	}

	public void setContato2(String contato2) {
		this.contato2 = contato2;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getFoneCelular2() {
		return foneCelular2;
	}

	public void setFoneCelular2(String foneCelular2) {
		this.foneCelular2 = foneCelular2;
	}

	public String getFoneFixo2() {
		return foneFixo2;
	}

	public void setFoneFixo2(String foneFixo2) {
		this.foneFixo2 = foneFixo2;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public boolean isEntrega() {
		return entrega;
	}

	public void setEntrega(boolean entrega) {
		this.entrega = entrega;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public Date getClienteDesde() {
		return clienteDesde;
	}

	public void setClienteDesde(Date clienteDesde) {
		this.clienteDesde = clienteDesde;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getId_vendedor() {
		return id_vendedor;
	}

	public void setId_vendedor(Integer id_vendedor) {
		this.id_vendedor = id_vendedor;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", "
				+ "nome=" + nome + ", contato1=" + contato1 + ""
				+ ", email1=" + email1 + ", foneCelular1=" + foneCelular1 + ""
				+ ", foneFixo1=" + foneFixo1 + ", contato2=" + contato2 + ""
				+ ", email2=" + email2 + ", foneCelular2=" + foneCelular2 + ""
				+ ", foneFixo2=" + foneFixo2 + ", detalhes=" + detalhes	+ ""
				+ ", entrega=" + entrega + ", unidade=" + unidade + ""
				+ ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj
				+ ", inscricaoEstadual=" + inscricaoEstadual + ""
				+ ", inscricaoMunicipal=" + inscricaoMunicipal
				+ ", clienteDesde=" + clienteDesde + ", logradouro=" + logradouro + ""
				+ ", bairro=" + bairro + ", cidade="
				+ cidade + ", uf=" + uf + ", cep=" + cep + ""
				+ ", id_vendedor=" + id_vendedor + "]";
	}

	

}
