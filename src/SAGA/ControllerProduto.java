package SAGA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControllerProduto {

	private Excecao excecao;
	private ControllerFornecedor controlForn;
	
	public ControllerProduto(ControllerFornecedor controlForn) {
		this.excecao = new Excecao();
		this.controlForn = controlForn;
	}

	public boolean cadastrarProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto, double precoProduto) {
		boolean resultado = false;
		excecao.verificaStringNula(nomeFornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nomeFornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaPreco(precoProduto, "Erro no cadastro de produto: preco invalido.");
		if(this.controlForn.getFornecedores().containsKey(nomeFornecedor)) {
			excecao.verificaStringNula(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
			excecao.verificaStringVazia(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
			excecao.verificaStringNula(descricaoProduto, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
			excecao.verificaStringVazia(descricaoProduto, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
			ProdutoSimples produto = new ProdutoSimples(nomeProduto, descricaoProduto); 
			if(this.controlForn.getFornecedores().get(nomeFornecedor).contemProduto(produto)) {
				throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
			}

			resultado = this.controlForn.getFornecedores().get(nomeFornecedor).cadastraProduto(nomeProduto, descricaoProduto, precoProduto);
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
		if (this.controlForn.getFornecedores().containsKey(nomeFornecedor)) {	
			ProdutoSimples produto = new ProdutoSimples(nomeProduto, descricaoProduto);
			if (this.controlForn.getFornecedores().get(nomeFornecedor).contemProduto(produto)) {
				return this.controlForn.getFornecedores().get(nomeFornecedor).getProduto(produto);
			}else {
				throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
			}
		}
		throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
	}

	public String retornarProdutosFornecedor(String nomeFornecedor) {
		excecao.verificaStringNula(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if (this.controlForn.getFornecedores().containsKey(nomeFornecedor)) {
			List<InterfaceProdutos> produtos = new ArrayList<>(this.controlForn.getFornecedores().get(nomeFornecedor).getProdutos());
			Collections.sort(produtos, new ComparadorDeProdutos());
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
		List<Fornecedor> fornecedores = new ArrayList<>(this.controlForn.getFornecedores().values());
		Collections.sort(fornecedores, new ComparadorDeUsuarios());
		
		for (int i = 0; i < fornecedores.size(); i++) {
			List<InterfaceProdutos> produtos = this.controlForn.getFornecedores().get(fornecedores.get(i).getNome()).getProdutos();
			Collections.sort(produtos, new ComparadorDeProdutos());
			
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
		if (this.controlForn.getFornecedores().containsKey(nomeFornecedor)) {
			ProdutoSimples produto = new ProdutoSimples(nomeProduto, descricaoProduto);
			if (novoPreco<0) {
				throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
			}
			if(this.controlForn.getFornecedores().get(nomeFornecedor).contemProduto(produto)) {
				return this.controlForn.getFornecedores().get(nomeFornecedor).editarProduto(produto, novoPreco);
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
		if (this.controlForn.getFornecedores().containsKey(nomeFornecedor)) {
			ProdutoSimples produto = new ProdutoSimples(nomeProduto, descricaoProduto);
			if (this.controlForn.getFornecedores().get(nomeFornecedor).contemProduto(produto)) {
				return this.controlForn.getFornecedores().get(nomeFornecedor).removerProduto(produto);
			}
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
		throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
	}

	public boolean adicionaCombo(String nomeFornecedor, String nomeCombo, String descricaoCombo, double fator, String produtos) {
		boolean resultado = false;
		excecao.verificaStringNula(nomeFornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nomeFornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringNula(nomeCombo, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nomeCombo, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringNula(descricaoCombo, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		excecao.verificaStringVazia(descricaoCombo, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		excecao.verificaFator(fator, "Erro no cadastro de combo: fator invalido.");
		
		String[] produtosSeparados = produtos.split(", ");
		ArrayList<String> nomesProd = new ArrayList<String>();
		ArrayList<String> descProd = new ArrayList<String>();
		String[] nomesDescSeparados = new String[4];
		nomesDescSeparados = produtosSeparados[0].split(" - ");
		nomesProd.add(nomesDescSeparados[0]);
		descProd.add(nomesDescSeparados[1]);
		nomesDescSeparados = produtosSeparados[1].split(" - ");
		nomesProd.add(nomesDescSeparados[0]);
		descProd.add(nomesDescSeparados[1]);
		ProdutoSimples prod1 = new ProdutoSimples(nomesProd.get(0), descProd.get(0));
		ProdutoSimples prod2 = new ProdutoSimples(nomesProd.get(1), descProd.get(1));
		
		
		
		if(this.controlForn.getFornecedores().containsKey(nomeFornecedor)) {
			if (controlForn.getFornecedores().get(nomeFornecedor).getProdutos().contains(prod1)&&controlForn.getFornecedores().get(nomeFornecedor).getProdutos().contains(prod2)) {
				int indiceProd1 = 0;
				int indiceProd2 = 0;
				for (int i = 0; i < controlForn.getFornecedores().get(nomeFornecedor).getProdutos().size(); i++) {
					if (controlForn.getFornecedores().get(nomeFornecedor).getProdutos().get(i).equals(prod1)) {
						indiceProd1 = i;
					}
					if (controlForn.getFornecedores().get(nomeFornecedor).getProdutos().get(i).equals(prod2)) {
						indiceProd2 = i;
					}
				}
				ProdutoCombo combo = new ProdutoCombo(nomeCombo, descricaoCombo, fator, controlForn.getFornecedores().get(nomeFornecedor).getProdutos().get(indiceProd1), controlForn.getFornecedores().get(nomeFornecedor).getProdutos().get(indiceProd2)); 
				if(this.controlForn.getFornecedores().get(nomeFornecedor).contemProduto(combo)) {
					throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
				}
				resultado = this.controlForn.getFornecedores().get(nomeFornecedor).cadastraCombo(nomeCombo, descricaoCombo, fator, controlForn.getFornecedores().get(nomeFornecedor).getProdutos().get(indiceProd1), controlForn.getFornecedores().get(nomeFornecedor).getProdutos().get(indiceProd2));
			}
		}else {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		}
		return resultado;
	}
	
}
