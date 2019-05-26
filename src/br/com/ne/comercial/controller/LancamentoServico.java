package br.com.ne.comercial.controller;

import java.sql.Date;

public class LancamentoServico {
	
	private int id_lancamento;
	private int id_clienteServico;
	private Date dataDoLancamento;
	private int quantidadeDoPedido;
	private int saldoAnterior;
	private int saldoAtual;
	private String observacoesLancamento;
	
	public LancamentoServico(){}

	public LancamentoServico(int id_lancamento, int id_clienteServico, Date dataDoLancamento,
			int quantidadeDoPedido, int saldoAnterior, int saldoAtual, String observacoesLancamento) {
		this.id_lancamento = id_lancamento;
		this.id_clienteServico = id_clienteServico;
		this.dataDoLancamento = dataDoLancamento;
		this.quantidadeDoPedido = quantidadeDoPedido;
		this.saldoAnterior = saldoAnterior;
		this.saldoAtual = saldoAtual;
		this.observacoesLancamento = observacoesLancamento;
	}

	public int getId_lancamento() {
		return id_lancamento;
	}

	public void setId_lancamento(int id_lancamento) {
		this.id_lancamento = id_lancamento;
	}

	public int getId_clienteServico() {
		return id_clienteServico;
	}

	public void setId_clienteServico(int id_clienteServico) {
		this.id_clienteServico = id_clienteServico;
	}
	
	public Date getDataDoLancamento() {
		return dataDoLancamento;
	}

	public void setDataDoLancamento(Date dataDoLancamento) {
		this.dataDoLancamento = dataDoLancamento;
	}

	public int getQuantidadeDoPedido() {
		return quantidadeDoPedido;
	}

	public void setQuantidadeDoPedido(int quantidadeDoPedido) {
		this.quantidadeDoPedido = quantidadeDoPedido;
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

	public String getObservacoesLancamento() {
		return observacoesLancamento;
	}

	public void setObservacoesLancamento(String observacoesLancamento) {
		this.observacoesLancamento = observacoesLancamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDoLancamento == null) ? 0 : dataDoLancamento.hashCode());
		result = prime * result + id_clienteServico;
		result = prime * result + id_lancamento;
		result = prime * result + ((observacoesLancamento == null) ? 0 : observacoesLancamento.hashCode());
		result = prime * result + quantidadeDoPedido;
		result = prime * result + saldoAnterior;
		result = prime * result + saldoAtual;
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
		LancamentoServico other = (LancamentoServico) obj;
		if (dataDoLancamento == null) {
			if (other.dataDoLancamento != null)
				return false;
		} else if (!dataDoLancamento.equals(other.dataDoLancamento))
			return false;
		if (id_clienteServico != other.id_clienteServico)
			return false;
		if (id_lancamento != other.id_lancamento)
			return false;
		if (observacoesLancamento == null) {
			if (other.observacoesLancamento != null)
				return false;
		} else if (!observacoesLancamento.equals(other.observacoesLancamento))
			return false;
		if (quantidadeDoPedido != other.quantidadeDoPedido)
			return false;
		if (saldoAnterior != other.saldoAnterior)
			return false;
		if (saldoAtual != other.saldoAtual)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "lancamentoServico [id_lancamento=" + id_lancamento + ", id_clienteServico=" + id_clienteServico
				+ ", dataDoLancamento=" + dataDoLancamento + ", quantidadeDoPedido="
				+ quantidadeDoPedido + ", saldoAnterior=" + saldoAnterior + ", saldoAtual=" + saldoAtual
				+ ", observacoesLancamento=" + observacoesLancamento + "]";
	}
	
	
	
	

}
