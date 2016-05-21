package br.edu.ifba.wmobile.huehue.produtos.compras;

import java.util.ArrayList;
import java.util.List;

public class Compras implements ICompras {
	private double valorDaCompra;
	private String produto;
	
	public Compras(double valorDaCompra, String produto){
		this.valorDaCompra = valorDaCompra;
		this.produto = produto;
	}

	@Override
	public List<String> getNome() {
		List<String> itens = new ArrayList<String>();
        itens.add(this.produto);
        
        return itens;
	}

	@Override
	public double getPreco() {
		return this.valorDaCompra;
	}

}
