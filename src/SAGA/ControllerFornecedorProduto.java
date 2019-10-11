package SAGA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerFornecedorProduto {
	
	private Map<String, Fornecedor> fornecedores;
	private Excecao excecao;

	public ControllerFornecedorProduto() {
		this.fornecedores = new HashMap<String, Fornecedor>();
		this.excecao = new Excecao(); 
	}

	public String cadastrarFornecedor(String nome, String email, String telefone) {
		if(!fornecedores.containsKey(nome)) {
			Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
			fornecedores.put(nome, fornecedor);
			return nome;
		}else {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
	}

	public String retornarFornecedor(String nome) {
		if (fornecedores.containsKey(nome)) {
			return fornecedores.get(nome).toString(); 
		}
		throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
	}

	public String retornarFornecedores() {
		String resultado = "";
		List<Fornecedor> fornecedores = new ArrayList<>(this.fornecedores.values());
		Collections.sort(fornecedores, new Comparador());
		for (int i = 0; i < fornecedores.size(); i++) {
			if (i==fornecedores.size()-1) {
				resultado += fornecedores.get(i).toString();
			}else {
				resultado += fornecedores.get(i).toString()+" | ";
			}
		}
		return resultado;
	}

	public boolean editarFornecedor(String nome, String atributo, String novoValor) {
		boolean resultado = false;
		excecao.verificaStringNula(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		if (fornecedores.containsKey(nome)) {
			excecao.verificaStringNula(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
			excecao.verificaStringVazia(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
			excecao.verificaStringNula(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
			excecao.verificaStringVazia(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
			if(atributo.equals("nome")) {
				throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
			}else
			if(atributo.equals("telefone")) {
				fornecedores.get(nome).setTelefone(novoValor);
			}else
			if(atributo.equals("email")) {
				fornecedores.get(nome).setEmail(novoValor);
			}else {
				throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
			}
			resultado = true;
		}else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}
		return resultado;
	}

	public boolean removerFornecedor(String nome) {
		boolean resultado = false;
		excecao.verificaStringNula(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		if (fornecedores.containsKey(nome)) {
			fornecedores.remove(nome);
			resultado = true;
		}else {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
		return resultado;
	}

	public boolean cadastrarProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto, double precoProduto) {
		boolean resultado = false;
		excecao.verificaStringNula(nomeFornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nomeFornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaPreco(precoProduto, "Erro no cadastro de produto: preco invalido.");
		if(fornecedores.containsKey(nomeFornecedor)) {
			excecao.verificaStringNula(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
			excecao.verificaStringVazia(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
			excecao.verificaStringNula(descricaoProduto, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
			excecao.verificaStringVazia(descricaoProduto, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
			Produto produto = new Produto(nomeProduto, descricaoProduto); 
			if(this.fornecedores.get(nomeFornecedor).contemProduto(produto)) {
				throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
			}

			resultado = fornecedores.get(nomeFornecedor).cadastraProduto(nomeProduto, descricaoProduto, precoProduto);
		}else {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		return resultado;
	}

	public String retornarProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		excecao.verificaStringNula(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringNula(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringNula(descricaoProduto, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		excecao.verificaStringVazia(descricaoProduto, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		if (fornecedores.containsKey(nomeFornecedor)) {	
			Produto produto = new Produto(nomeProduto, descricaoProduto);
			if (fornecedores.get(nomeFornecedor).contemProduto(produto)) {
				return fornecedores.get(nomeFornecedor).getProduto(produto);
			}else {
				throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
			}
		}
		throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
	}

	public String retornarProdutosFornecedor(String nomeFornecedor) {
		excecao.verificaStringNula(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if (fornecedores.containsKey(nomeFornecedor)) {
			List<Produto> produtos = new ArrayList<>(this.fornecedores.get(nomeFornecedor).getProdutos());
			Collections.sort(produtos, new Comparador());
			String resultado = "";
			for (int i = 0; i < produtos.size(); i++) {
				if (i==produtos.size()-1) {
					resultado += nomeFornecedor + " - " +produtos.get(i).toString();
				}else {
					resultado += nomeFornecedor + " - " +produtos.get(i).toString() + " | ";
				}
			}
			return resultado;
		}
		throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
	}

	public String retronarProdutos() {
		String resultado = "";
		List<Fornecedor> fornecedores = new ArrayList<>(this.fornecedores.values());
		Collections.sort(fornecedores, new Comparador());
		
		for (int i = 0; i < fornecedores.size(); i++) {
			List<Produto> produtos = this.fornecedores.get(fornecedores.get(i).getNome()).getProdutos();
			Collections.sort(produtos, new Comparador());
			
			if (produtos.size()==0) {
				resultado += fornecedores.get(i).getNome() + " - | ";
			}else {
				for (int j = 0; j < produtos.size(); j++) {
					if (i==fornecedores.size()-1) {
						resultado += fornecedores.get(i).getNome() + " - " +produtos.get(j).toString();
					}else {
						resultado += fornecedores.get(i).getNome() + " - " +produtos.get(j).toString() + " | ";
					}
				}
			}
		}
		return resultado;
	}

	public boolean editarProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor, double novoPreco) {
		excecao.verificaStringNula(descricaoProduto, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		excecao.verificaStringVazia(descricaoProduto, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		excecao.verificaStringNula(nomeProduto, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nomeProduto, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringNula(nomeFornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nomeFornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if (fornecedores.containsKey(nomeFornecedor)) {
			Produto produto = new Produto(nomeProduto, descricaoProduto);
			if (novoPreco<0) {
				throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
			}
			if(fornecedores.get(nomeFornecedor).contemProduto(produto)) {
				return fornecedores.get(nomeFornecedor).editarProduto(produto, novoPreco);
			}
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		}
		throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
	}

	public boolean removerProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		excecao.verificaStringNula(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringNula(descricaoProduto, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		excecao.verificaStringVazia(descricaoProduto, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		excecao.verificaStringNula(nomeFornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nomeFornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		if (fornecedores.containsKey(nomeFornecedor)) {
			Produto produto = new Produto(nomeProduto, descricaoProduto);
			if (fornecedores.get(nomeFornecedor).contemProduto(produto)) {
				return fornecedores.get(nomeFornecedor).removerProduto(produto);
			}
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
		throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
	}
}
