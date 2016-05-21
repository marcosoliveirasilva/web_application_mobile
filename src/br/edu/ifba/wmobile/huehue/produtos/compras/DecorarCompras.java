package br.edu.ifba.wmobile.huehue.produtos.compras;

import java.util.List;

public class DecorarCompras implements ICompras{
	private ICompras anterior;
	private double valorDaCompra;
	private String produto;
	
	public DecorarCompras(ICompras anterior, double valorDaCompra, String produto){
		this.anterior = anterior;
		this.valorDaCompra = valorDaCompra;
		this.produto = produto;
	}
	
	@Override
	public List<String> getNome() {
		List<String> itens = anterior.getNome();
        itens.add(produto);
        return itens;
	}

	@Override
	public double getPreco() {
		return this.valorDaCompra + anterior.getPreco();
	}

}
