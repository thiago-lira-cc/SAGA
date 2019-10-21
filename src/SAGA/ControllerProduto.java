package SAGA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Classe responsável pelas operações com produto
 * Cadastra produto
 * Retorna produto
 * Retorna todos os produtos de um fornecedor
 * Retorna todos os produtos
 * Edita produto
 * Remove produto
 */
public class ControllerProduto {

	private Excecao excecao;
	/**
	 * Controller fornecedor onde tem os fornecedores cadastrados
	 */
	private ControllerFornecedor controlForn;
	/**
	 * Contrói o controller
	 * @param controlForn
	 */
	public ControllerProduto(ControllerFornecedor controlForn) {
		this.excecao = new Excecao();
		this.controlForn = controlForn;
	}
	/**
	 * Método responsável por cadastrar um produto
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricaoProduto
	 * @param precoProduto
	 * @return
	 */
	public boolean adicionaProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto, double precoProduto) {
		boolean resultado = false;
		excecao.verificaStringNula(nomeFornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nomeFornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		
		if(this.controlForn.getFornecedores().containsKey(nomeFornecedor)) {
			excecao.verificaStringNula(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
			excecao.verificaStringVazia(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
			excecao.verificaStringNula(descricaoProduto, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
			excecao.verificaStringVazia(descricaoProduto, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
			excecao.verificaPreco(precoProduto, "Erro no cadastro de produto: preco invalido.");
			
			if(this.controlForn.getFornecedores().get(nomeFornecedor).contemProduto(nomeProduto, descricaoProduto)) {
				throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
			}else {
				resultado = this.controlForn.getFornecedores().get(nomeFornecedor).adicionaProduto(nomeProduto, descricaoProduto, precoProduto);
			}
			
		}else {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		return resultado;
	}
	/**
	 * Retorna um determinado produto
	 * @param nomeProduto
	 * @param descricaoProduto
	 * @param nomeFornecedor
	 * @return produto formatado
	 */
	public String exibeProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		excecao.verificaStringNula(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringNula(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringNula(descricaoProduto, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		excecao.verificaStringVazia(descricaoProduto, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		if (this.controlForn.getFornecedores().containsKey(nomeFornecedor)) {	

			//if (this.controlForn.getFornecedores().get(nomeFornecedor).contemProduto(nomeProduto, descricaoProduto)) {
				return this.controlForn.getFornecedores().get(nomeFornecedor).exibeProduto(nomeProduto, descricaoProduto);
			//}else {
				//throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
			//}
		}
		throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
	}
	/**
	 * Retorna os produtos de um fornecedor expecifico
	 * @param nomeFornecedor
	 * @return string de todos os produtos achados
	 */
	public String exibeProdutosDeUmFornecedor(String nomeFornecedor) {
		excecao.verificaStringNula(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if (this.controlForn.getFornecedores().containsKey(nomeFornecedor)) {
			return this.controlForn.getFornecedores().get(nomeFornecedor).retornaProdutosFornecedor();
		}
		throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
	}
	/**
	 * Retorna todos os produtos cadastrados
	 * @return string de todos os produtos cadastrados
	 */
	public String exibeTodosOsProdutos() {
		String resultado = "";
		List<Fornecedor> fornecedores = new ArrayList<>(this.controlForn.getFornecedores().values());
		Collections.sort(fornecedores);
		
		for (Fornecedor fornecedor : fornecedores) {
			resultado += fornecedor.retornaProdutosFornecedor() + " | ";
		}
		resultado = resultado.substring(0, resultado.length()-3);
		return resultado;
	}
	/**
	 * Edita o preço de um produto
	 * @param nomeProduto
	 * @param descricaoProduto
	 * @param nomeFornecedor
	 * @param novoPreco
	 * @return
	 */
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
			if(this.controlForn.getFornecedores().get(nomeFornecedor).contemProduto(nomeProduto, descricaoProduto)) {
				return this.controlForn.getFornecedores().get(nomeFornecedor).editarProduto(produto, novoPreco);
			}
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		}
		throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
	}
	/**
	 * Remove um produto
	 * @param nomeProduto
	 * @param descricaoProduto
	 * @param nomeFornecedor
	 * @return
	 */
	public boolean removerProduto(String nomeProduto, String descricaoProduto, String nomeFornecedor) {
		excecao.verificaStringNula(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringNula(descricaoProduto, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		excecao.verificaStringVazia(descricaoProduto, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		excecao.verificaStringNula(nomeFornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nomeFornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		if (this.controlForn.getFornecedores().containsKey(nomeFornecedor)) {
			if (this.controlForn.getFornecedores().get(nomeFornecedor).contemProduto(nomeProduto, descricaoProduto)) {
				return this.controlForn.getFornecedores().get(nomeFornecedor).removerProduto(nomeProduto, descricaoProduto);
			}
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
		throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
	}
	public boolean adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		excecao.verificaStringNula(fornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(fornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		
		if (this.controlForn.getFornecedores().containsKey(fornecedor)) {
			excecao.verificaStringNula(nome, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
			excecao.verificaStringVazia(nome, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
			excecao.verificaStringNula(descricao, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
			excecao.verificaStringVazia(descricao, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
			excecao.verificaFator(fator, "Erro no cadastro de combo: fator invalido.");
			excecao.verificaStringNula(produtos, "Erro no cadastro de combo: combo deve ter produtos.");
			excecao.verificaStringVazia(produtos, "Erro no cadastro de combo: combo deve ter produtos.");
			
			return this.controlForn.getFornecedores().get(fornecedor).adicionaCombo(nome, descricao, fator, produtos);
		}
		
		throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
	}
	public boolean editarCombo(String nome, String descricao, String fornecedor, double novoFator) {
		excecao.verificaStringNula(descricao, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		excecao.verificaStringVazia(descricao, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		excecao.verificaStringNula(nome, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(nome, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		excecao.verificaStringNula(fornecedor, "Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaStringVazia(fornecedor, "Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
		excecao.verificaFator(novoFator, "Erro na edicao de combo: fator invalido.");
		
		if (this.controlForn.getFornecedores().containsKey(fornecedor)) {
			ProdutoCombo produto = new ProdutoCombo(nome, descricao);
			
			if(this.controlForn.getFornecedores().get(fornecedor).contemProduto(nome, descricao)) {
				return this.controlForn.getFornecedores().get(fornecedor).editarProduto(produto, novoFator);
			}
			throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");
		}
		throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao existe.");
	}

}
