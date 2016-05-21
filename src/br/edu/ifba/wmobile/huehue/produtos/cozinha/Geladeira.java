package br.edu.ifba.wmobile.huehue.produtos.cozinha;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.wmobile.huehue.produtos.IProdutos;

public class Geladeira implements IProdutos {

	@Override
	public String getCessao() {
		return "COZINHA";
	}

	@Override
	public List<String> getNome() {
		List<String> itens = new ArrayList<String>();
		itens.add("GELADEIRA");

		return itens;
	}

	@Override
	public double getPreco() {
		return 780.50;
	}

}
