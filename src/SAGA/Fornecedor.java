package SAGA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Fornecedor implements InterfaceUsuarios{

	private Excecao excecao = new Excecao();
	private String nome;
	private String email;
	private String telefone;
	private Map<Cliente, Conta> contas;
	private ArrayList<InterfaceProdutos> allProdutos;
	
	public Fornecedor(String nome, String email, String telefone) {
		excecao.verificaStringNula(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringNula(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		excecao.verificaStringNula(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.contas = new HashMap<Cliente, Conta>();
		this.allProdutos = new ArrayList<InterfaceProdutos>();
	}

	public boolean cadastraProduto(String nomeProduto, String descricaoProduto, double precoProduto) {
		boolean resultado = false;
		ProdutoSimples produto = new ProdutoSimples(nomeProduto, descricaoProduto, precoProduto);
		if (!allProdutos.contains(produto)) {
			allProdutos.add(produto);
			resultado = true;
		}
		return resultado;
	}

	public boolean contemProduto(InterfaceProdutos produto) {
		boolean resultado = false;
		if (allProdutos.contains(produto)) {
			resultado = true;
		}
		return resultado;
	}

	public String getProduto(ProdutoSimples produtoB) {
		String resultado = "";
		for (InterfaceProdutos produtoA : allProdutos) {
			if (produtoA.equals(produtoB)) {
				resultado = produtoA.toString();
			}
		}
		return resultado;
	}

	public String retornaProdutosFornecedor() {
		String resultado = "";
		for (int i = 0; i < allProdutos.size(); i++) {
			if (i==allProdutos.size()-1) {
				resultado += allProdutos.get(i).toString();
			}else {
				resultado += allProdutos.get(i).toString() + " | ";
			}
		}

		return resultado;
	}

	public boolean editarProduto(ProdutoSimples produto, double novoPreco) {
		boolean resultado = false;
		for (int i = 0; i < this.allProdutos.size(); i++) {
			if (allProdutos.get(i).equals(produto)) {
				allProdutos.get(i).setPreco(novoPreco);
				resultado = true;
			}
		}
		return resultado;
	}

	public boolean removerProduto(ProdutoSimples produtoB) {
		boolean resultado = false;
		for (InterfaceProdutos produtoA : allProdutos) {
			if (produtoA.equals(produtoB)) {
				allProdutos.remove(produtoA);
				resultado = true;
			}
		}
		return resultado;
	}
	
	public boolean cadastraCombo(String nomeCombo, String descricaoCombo, double fator, InterfaceProdutos produto1, InterfaceProdutos produto2) {
		ProdutoCombo combo = new ProdutoCombo(nomeCombo, descricaoCombo, fator, produto1, produto2);
		if (!allProdutos.contains(combo)) {
			allProdutos.add(combo);
			return true;
		}
		
		throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
	}

	public String getNome() {
		return nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPrecoProd(ProdutoSimples produto) {
		for (int i = 0; i < allProdutos.size(); i++) {
			if (this.allProdutos.get(i).equals(produto)) {
				return allProdutos.get(i).getPreco();
			}
		}
		throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int compareTo(InterfaceUsuarios o) {
		return this.nome.compareTo(o.getIdentificador());
	}

	@Override
	public String getIdentificador() {
		return this.nome;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome + " - " + email + " - " + telefone;
	}
	
	public ArrayList<InterfaceProdutos> getProdutos(){
		return this.allProdutos;
	}

	public boolean adicionaCompra(Cliente cliente, String data, String nome_prod, String desc_prod, double preco) {
		if (this.contas.containsKey(cliente)) {
			this.contas.get(cliente).adicionaCompra(data, nome_prod, desc_prod, preco);
		}else {
			Conta conta = new Conta();
			this.contas.put(cliente, conta);
			this.contas.get(cliente).adicionaCompra(data, nome_prod, desc_prod, preco);
		}
		return false;
	}

	public String getDebito(Cliente cliente) {
		if (this.contas.containsKey(cliente)) {
			return this.contas.get(cliente).getDebito();
		}
		throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
	}

	public String exibeContas(Cliente cliente) {
		if (contas.containsKey(cliente)) {
			return this.contas.get(cliente).exibeContas();
		}
		throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
	}

	public boolean contemConta(Cliente cliente) {
		if (contas.containsKey(cliente)) {
			return true;
		}
		return false;
	}

}