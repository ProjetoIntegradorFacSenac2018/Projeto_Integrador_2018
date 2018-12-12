/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

public class VendasValor {

	private String nf;
	private String serie;
	private String cliente;
	private String produto;
	private double qtd;
	private double valor;
//	private double desconto;
	

	public VendasValor(String nf, String serie, String cliente, String produto,
			           double qtd, double valor) {
		this.nf = nf;
		this.serie = serie;
		this.cliente = cliente;
		this.produto = produto;
		this.qtd = qtd;
		this.valor = valor;
//		this.desconto = desconto;
	}


	public String getNf() {
		return nf;
	}


	public void setNf(String nf) {
		this.nf = nf;
	}


	public String getSerie() {
		return serie;
	}


	public void setSerie(String serie) {
		this.serie = serie;
	}


	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public String getProduto() {
		return produto;
	}


	public void setProduto(String produto) {
		this.produto = produto;
	}


	public double getQtd() {
		return qtd;
	}


	public void setQtd(double qtd) {
		this.qtd = qtd;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


//	public double getDesconto() {
//		return desconto;
//	}
//
//
//	public void setDesconto(double desconto) {
//		this.desconto = desconto;
//	}

}
