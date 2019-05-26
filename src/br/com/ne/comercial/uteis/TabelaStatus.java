package br.com.ne.comercial.uteis;

public class TabelaStatus {
	
	private String cliente;
	private String servico;
	private int id_vendedor;
	private int saldo;
	private int limiteMinimo;
	
	public TabelaStatus(){}

	public TabelaStatus(String cliente, String servico, int id_vendedor, int saldo, int limiteMinimo) {
		this.cliente = cliente;
		this.servico = servico;
		this.id_vendedor = id_vendedor;
		this.saldo = saldo;
		this.limiteMinimo = limiteMinimo;
	}

	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public String getServico() {
		return servico;
	}


	public void setServico(String servico) {
		this.servico = servico;
	}


	public int getId_vendedor() {
		return id_vendedor;
	}


	public void setId_vendedor(int id_vendedor) {
		this.id_vendedor = id_vendedor;
	}


	public int getSaldo() {
		return saldo;
	}


	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}


	public int getLimiteMinimo() {
		return limiteMinimo;
	}


	public void setLimiteMinimo(int limiteMinimo) {
		this.limiteMinimo = limiteMinimo;
	}
	
	

}
