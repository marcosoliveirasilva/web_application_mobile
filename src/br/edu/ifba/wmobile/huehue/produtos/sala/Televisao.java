package br.edu.ifba.wmobile.huehue.produtos.sala;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.wmobile.huehue.produtos.IProdutos;

public class Televisao implements IProdutos {

	@Override
	public String getCessao() {
		return "SALA";
	}

	@Override
	public List<String> getNome() {
		List<String> itens = new ArrayList<String>();
		itens.add("TELEVISAO");

		return itens;
	}

	@Override
	public double getPreco() {
		return 999.90;
	}
}
