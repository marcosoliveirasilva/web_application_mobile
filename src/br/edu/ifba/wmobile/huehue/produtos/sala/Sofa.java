package br.edu.ifba.wmobile.huehue.produtos.sala;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.wmobile.huehue.produtos.IProdutos;

public class Sofa implements IProdutos {

	@Override
	public String getCessao() {
		return "SALA";
	}

	@Override
	public List<String> getNome() {
		List<String> itens = new ArrayList<String>();
		itens.add("SOFA");

		return itens;
	}

	@Override
	public double getPreco() {
		return 480;
	}
}
