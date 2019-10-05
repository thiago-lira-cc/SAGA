package SAGA;

import java.util.HashMap;

public class ControllerFornecedorProduto {
	
	private HashMap<String, Fornecedor> fornecedores;
	private Excessao excessao;

	public ControllerFornecedorProduto() {
		this.fornecedores = new HashMap<String, Fornecedor>();
		this.excessao = new Excessao(); 
	}

	public String cadastrarFornecedor(String nome, String email, String telefone) {
		if(!fornecedores.containsKey(nome)) {
			excessao.verificaFornecedor(nome, email, telefone);
			Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
			fornecedores.put(nome, fornecedor);
			return nome;
		}else {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
	}

	public String retornarFornecedor(String nome) {
		String resultado = "Fornecedor não cadastrado!";
		if (fornecedores.containsKey(nome)) {
			resultado = fornecedores.get(nome).toString(); 
		}
		return resultado;
	}

	public String retornarFornecedores() {
		String resultado = "";
		for (String fornecedor : fornecedores.keySet()) {
			resultado += fornecedores.get(fornecedor).toString()+" | ";
		}
		return resultado;
	}

	public boolean editarFornecedor(String nome, String email, String telefone) {
		boolean resultado = false;
		if (fornecedores.containsKey(nome)) {
			fornecedores.get(nome).alteraFornecedor(email, telefone);
			resultado = true;
		}
		return resultado;
	}

	public boolean removerFornecedor(String nome) {
		boolean resultado = false;
		if (fornecedores.containsKey(nome)) {
			fornecedores.remove(nome);
			resultado = true;
		}
		return resultado;
	}

	public boolean cadastrarProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto, String precoProduto) {
		boolean resultado = false;
		if(fornecedores.containsKey(nomeFornecedor)) {
			resultado = fornecedores.get(nomeFornecedor).cadastraProduto(nomeProduto, descricaoProduto, precoProduto);
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

	public boolean editarProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto, String precoProduto) {
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
