package com.deveduarteo.model;

import com.deveduardo.dao.ProdutoDAO;

public class Produto {
	private int idProduto;
	private String descricao;
	private double quantidade;
	private double preco;
	private boolean onLine;

	public Produto() {

	}

	public Produto(String descricao, double quantidade, double preco, boolean onLine) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.onLine = onLine;
	}

	public Produto(int idProduto, String descricao, double quantidade, double preco, boolean onLine) {
		this.idProduto = idProduto;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.onLine = onLine;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isOnLine() {
		return onLine;
	}

	public void setOnLine(boolean onLine) {
		this.onLine = onLine;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", descricao=" + descricao + ", quantidade=" + quantidade
				+ ", preco=" + preco + ", onLine=" + onLine + "]";
	}


}
