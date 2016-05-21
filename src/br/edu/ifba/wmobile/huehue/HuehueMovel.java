package br.edu.ifba.wmobile.huehue;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.ifba.wmobile.huehue.produtos.IProdutos;
import br.edu.ifba.wmobile.huehue.produtos.compras.Compras;
import br.edu.ifba.wmobile.huehue.produtos.compras.DecorarCompras;
import br.edu.ifba.wmobile.huehue.produtos.compras.ICompras;
import br.edu.ifba.wmobile.huehue.produtos.cozinha.Fogao;
import br.edu.ifba.wmobile.huehue.produtos.cozinha.Geladeira;
import br.edu.ifba.wmobile.huehue.produtos.cozinha.Microondas;
import br.edu.ifba.wmobile.huehue.produtos.escritorio.CadeiraOffice;
import br.edu.ifba.wmobile.huehue.produtos.escritorio.Escrivaninha;
import br.edu.ifba.wmobile.huehue.produtos.sala.Sofa;
import br.edu.ifba.wmobile.huehue.produtos.sala.Televisao;

@ManagedBean(name = "hue")
@SessionScoped
public class HuehueMovel {
	// variavaeis necessarias na manipulação da compra
		private static List<ICompras> listaDeCompras = new ArrayList<>();
		private ICompras compras;
		private int contador;
		private static String estadoDasCompras;

	// variaveis necessarias para obtenção dos produtos
		private static List<IProdutos> listaDeProdutos = new ArrayList<IProdutos>();
		private static int cont;

	// mostra em que diretorio esta a imagem
		private String imagens;

	// variaveis teporarias dos produtos
		private String produto;
		private double preco;

	// dados do cliente
		private String email = "";
		private String nome = "";
		private String endereco = "";

	// nome das paginas
		public String getNomeCurto(int i) {
			String retorno = "";
			switch (i) {
			case 1:
				retorno = "Huehue Movel";
				break;
			case 2:
				retorno = "Cessões Disponiveis";
				break;
			case 3:
				retorno = "Produtos";
				break;
			case 4:
				retorno = "Carrinho de Compras";
				break;
			case 5:
				retorno = "Huehue";
			}
			return retorno;
		}

	// metodos get e set dos dados do cliente
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getNome() {
			return nome;
		}
	
		public void setNome(String nome) {
			this.nome = nome;
		}
	
		public String getEndereco() {
			return endereco;
		}
	
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

	// So passa da tela inicial se colocar todos os itens do cadastro
		public String estadoDoCadastro() {
			String estado = "";
			if (this.nome.equals("") || this.email.equals("") || this.endereco.equals("")) {
				estado = "";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Prencha todos os campos!");
		        FacesContext.getCurrentInstance().addMessage(null, message);
			} else {
				estado = "cessao.xhtml";
			}
			return estado;
		}
		
		
	
		// insere as cessões dos produtos
		public List<String> getTiposProduto() {
			List<String> tipos = new ArrayList<String>();
			tipos.add("COZINHA");
			tipos.add("SALA");
			tipos.add("ESCRITORIO");
	
			return tipos;
		}

	// inicia os produtos da cessão escolhidos
		public void setCessaoEscolhida(String tipoProduto) {
			if (tipoProduto.equals("COZINHA")) {
				listaDeProdutos.clear();
				cont = 0;
	
				IProdutos produto = new Fogao();
				listaDeProdutos.add(cont, produto);
				cont++;
	
				produto = new Geladeira();
				listaDeProdutos.add(cont, produto);
				cont++;
	
				produto = new Microondas();
				listaDeProdutos.add(cont, produto);
				cont++;
	
				this.setImagemProdutos("cozinha");
	
			} else if (tipoProduto.equals("SALA")) {
				listaDeProdutos.clear();
				cont = 0;
	
				IProdutos produto = new Sofa();
				listaDeProdutos.add(cont, produto);
				cont++;
	
				produto = new Televisao();
				listaDeProdutos.add(cont, produto);
				cont++;
	
				this.setImagemProdutos("sala");
	
			} else if (tipoProduto.equals("ESCRITORIO")) {
				listaDeProdutos.clear();
				cont = 0;
	
				IProdutos produto = new CadeiraOffice();
				listaDeProdutos.add(cont, produto);
				cont++;
	
				produto = new Escrivaninha();
				listaDeProdutos.add(cont, produto);
				cont++;
	
				this.setImagemProdutos("escritorio");
	
			}
	
		}

	// retorna a quantidade de produtos na listaDeProdutos
		public int getTotalItens() {
			return listaDeProdutos.size();
		}

	// metodos set e get para apontar o caminho onde se encontra a imagem desejada
		private void setImagemProdutos(String imagens) {
			this.imagens = imagens;
		}
	
		public String getImagemProdutos() {
			return imagens;
		}

	// retorna o objeto referente ao produto escolhido
		public IProdutos getProdutos(int numero) {
			return listaDeProdutos.get(numero - 1);
		}

	// decora o produto que o cliente deseja comprar
		public void fazerCompra(int n) {
			produto = "" + this.getProdutos(n).getNome();
			preco = this.getProdutos(n).getPreco();
			
			if (HuehueMovel.estadoDasCompras == null) {
				HuehueMovel.estadoDasCompras = "compra efetuada";
				this.contador = 0;
				compras = new Compras(preco, produto);
				HuehueMovel.listaDeCompras.add(contador, compras);
			} else {
				this.contador++;
				compras = new DecorarCompras(compras, preco, produto);
				HuehueMovel.listaDeCompras.add(contador, compras);
			}
		}

	// metodos para recuperar o valor total e os produtos da compra
		public String getProdutosComprados() {
			if (HuehueMovel.listaDeCompras.size() == 0)
				return "Não há nenhum item na lista";
			else
				return "" + HuehueMovel.listaDeCompras.get(contador).getNome();
		}
	
		public String getValorTotalCompra() {
			if (HuehueMovel.listaDeCompras.size() == 0)
				return "0";
			else
				return "" + HuehueMovel.listaDeCompras.get(contador).getPreco();
		}

	// limpa o carrinho de compras
	public void limparCarrinho() {
			if (HuehueMovel.listaDeCompras.size() != 0) {
				System.out.println("\nCompra encaminha para entrega na residencia do sr. " + this.nome + "\nEdereço: "
						+ this.endereco + "\nLista de compras: " + HuehueMovel.listaDeCompras.get(contador).getNome()
						+ "\nE-Mail de confirmação enviado para " + this.email);
				HuehueMovel.listaDeCompras.clear();
				HuehueMovel.estadoDasCompras = null;
			}
	
		}

	// limpa o cadastro e retorna a tela inicial
		public String getRetomarCessaoDeCadastro() {
			this.nome = "";
			this.email = "";
			this.email = "";
			return "inicio.xhtml";
		}

}
