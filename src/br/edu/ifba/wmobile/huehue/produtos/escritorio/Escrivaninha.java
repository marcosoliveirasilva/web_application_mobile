package br.edu.ifba.wmobile.huehue.produtos.escritorio;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.wmobile.huehue.produtos.IProdutos;

public class Escrivaninha implements IProdutos {

	@Override
	public String getCessao() {
		return "ESCRITORIO";
	}

	@Override
	public List<String> getNome() {
		List<String> itens = new ArrayList<String>();
		itens.add("ESCRIVANINHA");

		return itens;
	}

	@Override
	public double getPreco() {
		return 561.90;
	}
}
