package br.edu.ifba.wmobile.huehue.produtos.cozinha;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.wmobile.huehue.produtos.IProdutos;

public class Fogao implements IProdutos {

	@Override
	public List<String> getNome() {
		List<String> itens = new ArrayList<String>();
		itens.add("FOGÃO");

		return itens;
	}

	@Override
	public double getPreco() {
		return 299.99;
	}

	@Override
	public String getCessao() {
		return "COZINHA";
	}

}
