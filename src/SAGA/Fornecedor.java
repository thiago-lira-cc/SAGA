package SAGA;

import java.util.HashSet;

public class Fornecedor {

	private String nome;
	private String email;
	private String telefone;
	private HashSet<Produto> produtos;
	
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashSet<Produto>();
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

	public void alteraFornecedor(String email2, String telefone2) {
		this.email = email2;
		this.telefone = telefone2;
		
	}

	public boolean cadastraProduto(String nomeProduto, String descricaoProduto, String precoProduto) {
		boolean resultado = false;
		Produto produto = new Produto(nomeProduto, descricaoProduto, precoProduto);
		if (!produtos.contains(produto)) {
			produtos.add(produto);
			resultado = true;
		}
		return resultado;
	}

	public boolean contemProduto(Produto produto) {
		boolean resultado = false;
		if (produtos.contains(produto)) {
			resultado = true;
		}
		return resultado;
	}

	public String getProduto(Produto produtoB) {
		String resultado = "";
		for (Produto produtoA : produtos) {
			if (produtoA.equals(produtoB)) {
				resultado = produtoA.toString();
			}
		}
		return resultado;
	}

	public String retornaProdutosFornecedor() {
		String resultado = "";
		for (Produto produto : produtos) {
			resultado += produto.toString() + " | ";
		}
		return resultado;
	}

	public boolean editarProduto(Produto produtoB, String precoProduto) {
		boolean resultado = false;
		for (Produto produtoA : produtos) {
			if (produtoA.equals(produtoB)) {
				produtoA.setPreco(precoProduto);
				resultado = true;
			}
		}
		return resultado;
	}

	public boolean removerProduto(Produto produtoB) {
		boolean resultado = false;
		for (Produto produtoA : produtos) {
			if (produtoA.equals(produtoB)) {
				produtos.remove(produtoA);
				resultado = true;
			}
		}
		return resultado;
	}

	public String getNome() {
		return nome;
	}
	
}
