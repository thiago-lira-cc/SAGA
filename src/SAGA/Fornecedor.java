package SAGA;

import java.util.ArrayList;

public class Fornecedor implements Interface{

	private Excecao excecao = new Excecao();
	private String nome;
	private String email;
	private String telefone;
	private ArrayList<Produto> produtos;
	
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
		this.produtos = new ArrayList<Produto>();
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

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean cadastraProduto(String nomeProduto, String descricaoProduto, double precoProduto) {
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
		for (int i = 0; i < produtos.size(); i++) {
			if (i==produtos.size()-1) {
				resultado += produtos.get(i).toString();
			}else {
				resultado += produtos.get(i).toString() + " | ";
			}
		}

		return resultado;
	}

	public boolean editarProduto(Produto produto, double novoPreco) {
		boolean resultado = false;
		for (int i = 0; i < this.produtos.size(); i++) {
			if (produtos.get(i).equals(produto)) {
				produtos.get(i).setPreco(novoPreco);
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
	
	public ArrayList<Produto> getProdutos(){
		return this.produtos;
	}
	
	/*@Override
	public int compare(Fornecedor fornecedor1, Fornecedor fornecedor2) {
		return fornecedor1.getNome().compareTo(fornecedor2.getNome());
	}*/

	@Override
	public int compareTo(Interface o) {
		return this.nome.compareTo(o.getIdentificador());
	}

	@Override
	public String getIdentificador() {
		return this.nome;
	}
}