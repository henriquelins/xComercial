package br.com.ne.comercial.uteis;

public class TabelaLembrete {
	
	private String cliente;
	private String servico;
	private int saldo;
	private int limiteMinimo;
	
		
	public TabelaLembrete(){}
	
	public TabelaLembrete(String cliente, String servico, int saldo, int limiteMinimo) {
		this.cliente = cliente;
		this.servico = servico;
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
