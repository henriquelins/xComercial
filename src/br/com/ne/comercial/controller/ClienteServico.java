package br.com.ne.comercial.controller;

public class ClienteServico {

	private int id_clienteServico;
	private String nomeDoServico;
	private String produtoDoServico;
	private String cnpjDoServico;
	private int saldoServico;
	private String observacoesServico;
	private int limiteMinimo;
	private double valorUnitario;
	private int id_cliente;
	
	public ClienteServico() {}

	public ClienteServico(int id_clienteServico, String nomeDoServico, String produtoDoServico, String cnpjDoServico,
			int saldoServico, String observacoesServico, int limiteMinimo, double valorUnitario, int id_cliente) {
		this.id_clienteServico = id_clienteServico;
		this.nomeDoServico = nomeDoServico;
		this.produtoDoServico = produtoDoServico;
		this.cnpjDoServico = cnpjDoServico;
		this.saldoServico = saldoServico;
		this.observacoesServico = observacoesServico;
		this.limiteMinimo = limiteMinimo;
		this.valorUnitario = valorUnitario;
		this.id_cliente = id_cliente;
	}

	public int getId_clienteServico() {
		return id_clienteServico;
	}

	public void setId_clienteServico(int id_clienteServico) {
		this.id_clienteServico = id_clienteServico;
	}

	public String getNomeDoServico() {
		return nomeDoServico;
	}

	public void setNomeDoServico(String nomeDoServico) {
		this.nomeDoServico = nomeDoServico;
	}

	public String getProdutoDoServico() {
		return produtoDoServico;
	}

	public void setProdutoDoServico(String produtoDoServico) {
		this.produtoDoServico = produtoDoServico;
	}

	public String getCnpjDoServico() {
		return cnpjDoServico;
	}

	public void setCnpjDoServico(String cnpjDoServico) {
		this.cnpjDoServico = cnpjDoServico;
	}

	public int getSaldoServico() {
		return saldoServico;
	}

	public void setSaldoServico(int saldoServico) {
		this.saldoServico = saldoServico;
	}

	public String getObservacoesServico() {
		return observacoesServico;
	}

	public void setObservacoesServico(String observacoesServico) {
		this.observacoesServico = observacoesServico;
	}

	public int getLimiteMinimo() {
		return limiteMinimo;
	}

	public void setLimiteMinimo(int limiteMinimo) {
		this.limiteMinimo = limiteMinimo;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpjDoServico == null) ? 0 : cnpjDoServico.hashCode());
		result = prime * result + id_cliente;
		result = prime * result + id_clienteServico;
		result = prime * result + limiteMinimo;
		result = prime * result + ((nomeDoServico == null) ? 0 : nomeDoServico.hashCode());
		result = prime * result + ((observacoesServico == null) ? 0 : observacoesServico.hashCode());
		result = prime * result + ((produtoDoServico == null) ? 0 : produtoDoServico.hashCode());
		result = prime * result + saldoServico;
		long temp;
		temp = Double.doubleToLongBits(valorUnitario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		ClienteServico other = (ClienteServico) obj;
		if (cnpjDoServico == null) {
			if (other.cnpjDoServico != null)
				return false;
		} else if (!cnpjDoServico.equals(other.cnpjDoServico))
			return false;
		if (id_cliente != other.id_cliente)
			return false;
		if (id_clienteServico != other.id_clienteServico)
			return false;
		if (limiteMinimo != other.limiteMinimo)
			return false;
		if (nomeDoServico == null) {
			if (other.nomeDoServico != null)
				return false;
		} else if (!nomeDoServico.equals(other.nomeDoServico))
			return false;
		if (observacoesServico == null) {
			if (other.observacoesServico != null)
				return false;
		} else if (!observacoesServico.equals(other.observacoesServico))
			return false;
		if (produtoDoServico == null) {
			if (other.produtoDoServico != null)
				return false;
		} else if (!produtoDoServico.equals(other.produtoDoServico))
			return false;
		if (saldoServico != other.saldoServico)
			return false;
		if (Double.doubleToLongBits(valorUnitario) != Double.doubleToLongBits(other.valorUnitario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClienteServico [id_clienteServico=" + id_clienteServico + ", nomeDoServico=" + nomeDoServico
				+ ", produtoDoServico=" + produtoDoServico + ", cnpjDoServico=" + cnpjDoServico + ", saldoServico="
				+ saldoServico + ", observacoesServico=" + observacoesServico + ", limiteMinimo=" + limiteMinimo
				+ ", valorUnitario=" + valorUnitario + ", id_cliente=" + id_cliente + "]";
	}

	

	
}
