package br.edu.ifba.wmobile.huehue.produtos.escritorio;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.wmobile.huehue.produtos.IProdutos;

public class CadeiraOffice implements IProdutos {

	@Override
	public String getCessao() {
		return "ESCRITORIO";
	}

	@Override
	public List<String> getNome() {
		List<String> itens = new ArrayList<String>();
		itens.add("CADEIRA_OFFICE");

		return itens;
	}

	@Override
	public double getPreco() {
		return 338.90;
	}
}
