package SAGA;

import java.util.HashMap;

public class ControllerFornecedorProduto {
	
	private HashMap<String, Fornecedor> fornecedores;
	private Excecao excecao;

	public ControllerFornecedorProduto() {
		this.fornecedores = new HashMap<String, Fornecedor>();
		this.excecao = new Excecao(); 
	}

	public String cadastrarFornecedor(String nome, String email, String telefone) {
		if(!fornecedores.containsKey(nome)) {
			excecao.verificaFornecedor(nome, email, telefone);
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
		for (String fornecedor : fornecedores.keySet()) {
			resultado += fornecedores.get(fornecedor).toString()+" | ";
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
			resultado = fornecedores.get(nomeFornecedor).cadastraProduto(nomeProduto, descricaoProduto, precoProduto);
		}else {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor ja existe.");
		}
		return resultado;
	}

	public String retornarProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto) {
		String resultado = "Fornecedor não cadastrado!";
		if (fornecedores.containsKey(nomeFornecedor)) {
			Produto produto = new Produto(nomeProduto, descricaoProduto);
			if (fornecedores.get(nomeFornecedor).contemProduto(produto)) {
				resultado = fornecedores.get(nomeFornecedor).getNome() +" - "+ fornecedores.get(nomeFornecedor).getProduto(produto);
			}else {
				resultado = "Produto não cadastrado!";
			}
		}
		return resultado;
	}

	public String retornarProdutosFornecedor(String nomeFornecedor) {
		String resultado = "Fornecedor não cadastrado!";
		if (fornecedores.containsKey(nomeFornecedor)) {
			resultado = fornecedores.get(nomeFornecedor).getNome() +" - "+fornecedores.get(nomeFornecedor).retornaProdutosFornecedor();
		}
		return resultado;
	}

	public String retronarProdutos() {
		String resultado = "";
		for (String fornecedor : fornecedores.keySet()) {
			resultado += fornecedores.get(fornecedor).getNome() +" - "+ fornecedores.get(fornecedor).retornaProdutosFornecedor();
		}
		return resultado;
	}

	public boolean editarProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto, double precoProduto) {
		boolean resultado = false;
		if (fornecedores.containsKey(nomeFornecedor)) {
			Produto produto = new Produto(nomeProduto, descricaoProduto);
			if(fornecedores.get(nomeFornecedor).contemProduto(produto)) {
				resultado = fornecedores.get(nomeFornecedor).editarProduto(produto, precoProduto);
			}
		}
		return resultado;
	}

	public boolean removerProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto) {
		boolean resultado = false;
		if (fornecedores.containsKey(nomeFornecedor)) {
			Produto produto = new Produto(nomeProduto, descricaoProduto);
			if (fornecedores.get(nomeFornecedor).contemProduto(produto)) {
				resultado = fornecedores.get(nomeFornecedor).removerProduto(produto);
			}
		}
		return resultado;
	}
	
	
}
