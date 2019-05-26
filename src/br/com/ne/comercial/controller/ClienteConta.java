package br.com.ne.comercial.controller;

import java.sql.Date;

public class ClienteConta {

	private int id_clienteConta;
	private String nomeDaConta;
	private String cnpjDaConta;
	private int saldoAnterior;
	private int saldoAtual;
	private String observacoesConta;
	private int quantidadeDoPedido;
	private Date dataDoPedido;
	private Date dataDoLancamento;
	private int limiteMinimo;
	private Double valorUnitario;
	private int id_cliente;
	private int id_vendedor;
	private int id_servico;

	public ClienteConta() {
	}

	public ClienteConta(int id_clienteConta, String nomeDaConta, String cnpjDaConta, int saldoAnterior, int saldoAtual,
			String observacoesConta, int quantidadeDoPedido, Date dataDoPedido, Date dataDoLancamento, int limiteMinimo,
			Double valorUnitario, int id_cliente, int id_vendedor, int id_servico) {

		this.id_clienteConta = id_clienteConta;
		this.nomeDaConta = nomeDaConta;
		this.cnpjDaConta = cnpjDaConta;
		this.saldoAnterior = saldoAnterior;
		this.saldoAtual = saldoAtual;
		this.observacoesConta = observacoesConta;
		this.quantidadeDoPedido = quantidadeDoPedido;
		this.dataDoPedido = dataDoPedido;
		this.dataDoLancamento = dataDoLancamento;
		this.limiteMinimo = limiteMinimo;
		this.valorUnitario = valorUnitario;
		this.id_cliente = id_cliente;
		this.id_vendedor = id_vendedor;
		this.id_servico = id_servico;
	}

	public int getId_clienteConta() {
		return id_clienteConta;
	}

	public void setId_clienteConta(int id_clienteConta) {
		this.id_clienteConta = id_clienteConta;
	}

	public String getNomeDaConta() {
		return nomeDaConta;
	}

	public void setNomeDaConta(String nomeDaConta) {
		this.nomeDaConta = nomeDaConta;
	}

	public String getCnpjDaConta() {
		return cnpjDaConta;
	}

	public void setCnpjDaConta(String cnpjDaConta) {
		this.cnpjDaConta = cnpjDaConta;
	}

	public int getSaldoAnterior() {
		return saldoAnterior;
	}

	public void setSaldoAnterior(int saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}

	public int getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(int saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	public String getObservacoesConta() {
		return observacoesConta;
	}

	public void setObservacoesConta(String observacoesConta) {
		this.observacoesConta = observacoesConta;
	}

	public int getQuantidadeDoPedido() {
		return quantidadeDoPedido;
	}

	public void setQuantidadeDoPedido(int quantidadeDoPedido) {
		this.quantidadeDoPedido = quantidadeDoPedido;
	}

	public Date getDataDoPedido() {
		return dataDoPedido;
	}

	public void setDataDoPedido(Date dataDoPedido) {
		this.dataDoPedido = dataDoPedido;
	}

	public Date getDataDoLancamento() {
		return dataDoLancamento;
	}

	public void setDataDoLancamento(Date dataDoLancamento) {
		this.dataDoLancamento = dataDoLancamento;
	}

	public int getLimiteMinimo() {
		return limiteMinimo;
	}

	public void setLimiteMinimo(int limiteMinimo) {
		this.limiteMinimo = limiteMinimo;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_vendedor() {
		return id_vendedor;
	}

	public void setId_vendedor(int id_vendedor) {
		this.id_vendedor = id_vendedor;
	}

	public int getId_servico() {
		return id_servico;
	}

	public void setId_servico(int id_servico) {
		this.id_servico = id_servico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpjDaConta == null) ? 0 : cnpjDaConta.hashCode());
		result = prime * result + ((dataDoLancamento == null) ? 0 : dataDoLancamento.hashCode());
		result = prime * result + ((dataDoPedido == null) ? 0 : dataDoPedido.hashCode());
		result = prime * result + id_cliente;
		result = prime * result + id_clienteConta;
		result = prime * result + id_servico;
		result = prime * result + id_vendedor;
		result = prime * result + limiteMinimo;
		result = prime * result + ((nomeDaConta == null) ? 0 : nomeDaConta.hashCode());
		result = prime * result + ((observacoesConta == null) ? 0 : observacoesConta.hashCode());
		result = prime * result + quantidadeDoPedido;
		result = prime * result + saldoAnterior;
		result = prime * result + saldoAtual;
		result = prime * result + ((valorUnitario == null) ? 0 : valorUnitario.hashCode());
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
		ClienteConta other = (ClienteConta) obj;
		if (cnpjDaConta == null) {
			if (other.cnpjDaConta != null)
				return false;
		} else if (!cnpjDaConta.equals(other.cnpjDaConta))
			return false;
		if (dataDoLancamento == null) {
			if (other.dataDoLancamento != null)
				return false;
		} else if (!dataDoLancamento.equals(other.dataDoLancamento))
			return false;
		if (dataDoPedido == null) {
			if (other.dataDoPedido != null)
				return false;
		} else if (!dataDoPedido.equals(other.dataDoPedido))
			return false;
		if (id_cliente != other.id_cliente)
			return false;
		if (id_clienteConta != other.id_clienteConta)
			return false;
		if (id_servico != other.id_servico)
			return false;
		if (id_vendedor != other.id_vendedor)
			return false;
		if (limiteMinimo != other.limiteMinimo)
			return false;
		if (nomeDaConta == null) {
			if (other.nomeDaConta != null)
				return false;
		} else if (!nomeDaConta.equals(other.nomeDaConta))
			return false;
		if (observacoesConta == null) {
			if (other.observacoesConta != null)
				return false;
		} else if (!observacoesConta.equals(other.observacoesConta))
			return false;
		if (quantidadeDoPedido != other.quantidadeDoPedido)
			return false;
		if (saldoAnterior != other.saldoAnterior)
			return false;
		if (saldoAtual != other.saldoAtual)
			return false;
		if (valorUnitario == null) {
			if (other.valorUnitario != null)
				return false;
		} else if (!valorUnitario.equals(other.valorUnitario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClienteConta [id_clienteConta=" + id_clienteConta + ", nomeDaConta=" + nomeDaConta + ", cnpjDaConta="
				+ cnpjDaConta + ", saldoAnterior=" + saldoAnterior + ", saldoAtual=" + saldoAtual
				+ ", observacoesConta=" + observacoesConta + ", quantidadeDoPedido=" + quantidadeDoPedido
				+ ", dataDoPedido=" + dataDoPedido + ", dataDoLancamento=" + dataDoLancamento + ", limiteNegativo="
				+ limiteMinimo + ", valorUnitario=" + valorUnitario + ", id_cliente=" + id_cliente + ", id_vendedor="
				+ id_vendedor + ", id_servico=" + id_servico + "]";
	}

}
