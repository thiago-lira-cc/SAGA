package SAGA;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * Representação de um fornecedor no sistema. Cada fornecedor tem nome, email e telefone, além de coleções de produtos, contas e combos.
 * @author Thiago Lira.
 *
 */
public class Fornecedor implements Comparable<Fornecedor>{

	private Excecao excecao = new Excecao();
	/**
	 * O nome do fornecedor.
	 */
	private String nome;
	/**
	 * O email do fornecedor.
	 */
	private String email;
	/**
	 * O telefone do fornecedor.
	 */
	private String telefone;
	/**
	 * O mapa das contas.
	 */
	private Map<Cliente, Conta> contas;
	/**
	 * A mapa dos seus produtos.
	 */
	private Map<ProdutoId, Produto> produtos;
	
	
	/**
	 * Constrói um fornecedor a partir de seu nome, seu telefone e seu email.
	 * Lança as mensagens de exceção do sistema, mostrando que nenhum dos parâmetros recebidos pode ser vazio ou nulo.
	 * 
	 * @param nome o nome do fornecedor.
	 * @param email o email do fornecedor.
	 * @param telefone o telefone do fornecedor.
	 */
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
		this.produtos = new HashMap<ProdutoId, Produto>();
	}
	/**
	 * Cadastra um produto no sistema.
	 * 
	 * @param nomeProduto o nome do produto a ser cadastrado.
	 * @param descricaoProduto a descrição do produto.
	 * @param precoProduto o preço do produto.
	 * @return retorna se o cadastro ocorreu com sucesso.
	 */
	public boolean cadastraProduto(String nomeProduto, String descricaoProduto, double preco) {
		if (!contemProduto(nomeProduto, descricaoProduto)) {
			ProdutoSimples produto = new ProdutoSimples(nomeProduto, descricaoProduto, preco);
			ProdutoId id = new ProdutoId(nomeProduto, descricaoProduto);
			this.produtos.put(id, produto);
			return true;
		}else {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		
	}
	public boolean adicionaCombo(String nome, String descricao, double fator, String produtos) {
		if (!contemProduto(nome, descricao)) {
			String[] produtosSep = produtos.split(", ");
			String[] propduto1 = produtosSep[0].split(" - ");
			ProdutoId id1 = new ProdutoId(propduto1[0], propduto1[1]);
			
			String[] propduto2 = produtosSep[1].split(" - ");
			ProdutoId id2 = new ProdutoId(propduto2[0], propduto2[1]);
			if (this.produtos.containsKey(id1) && this.produtos.containsKey(id2)) {
				if (this.produtos.get(id1).getTipo().equals("Simples") && this.produtos.get(id2).getTipo().equals("Simples")) {
					double precoprod1 = this.produtos.get(id1).getPreco();
					double precoprod2 = this.produtos.get(id2).getPreco();
					
					ProdutoCombo combo = new ProdutoCombo(nome, descricao, fator, produtos, precoprod1, precoprod2);
					ProdutoId id = new ProdutoId(nome, descricao);
					this.produtos.put(id, combo);
					return true;
				}
				throw new IllegalArgumentException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
			}
			if (this.produtos.containsKey(id1) || this.produtos.containsKey(id2)) {
				throw new IllegalArgumentException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
			}
			throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
		}
		throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
	}
	/**
	 * Verifica se o produto já existe.
	 * 
	 * @param produto o produto a ser verificado
	 * @return retorna se o produto existe ou não.
	 */
	public boolean contemProduto(String nome, String descricao) {
		ProdutoId id = new ProdutoId(nome, descricao);
		if (this.produtos.containsKey(id)) {
			return true;
		}
		return false;
	}

	public String exibeProduto(String nome, String descricao) {
		ProdutoId id = new ProdutoId(nome, descricao);
		if (produtos.containsKey(id)) {
			return produtos.get(id).toString();
		}
		throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
	}
	/**
	 * Retorna a lista dos produtos cadastrados no sistema.
	 * @return retorna as representações String dos produtos, em lista.
	 */
	public String retornaProdutosFornecedor() {
		String resultado = "";
		
		List<Produto> listaProdutos = new ArrayList<>();
		listaProdutos.addAll(this.produtos.values());
		
		if (listaProdutos.size() != 0) {
			Collections.sort(listaProdutos);
			
			for (Produto produto : listaProdutos) {
				resultado += this.nome +" - "+ produto.toString() + " | ";
			}
			
			resultado = resultado.substring(0, resultado.length()-3);
			
			return resultado;
		}else {
			return this.nome +" -";
		}
	}
	/**
	 * Edita o preço de um produto.
	 * 
	 * @param produto o produto a ser editado.
	 * @param novoPreco o novo preço do produto.
	 * @return retorna se a edição ocorreu com sucesso.
	 */
	public boolean editarProduto(Produto produtoA, double novoValor) {
		boolean resultado = false;
		for (ProdutoId chaveProdutoB: produtos.keySet()) {
			if (produtos.get(chaveProdutoB).equals(produtoA)) {
				this.produtos.get(chaveProdutoB).setPreco(novoValor);
				resultado = true;
			}
		}
		return resultado;
	}
	/**
	 * Remove um produto do sistema.
	 * @param produtoB o produto a ser removido.
	 * @return retorna se a remoção ocorreu com sucesso.
	 */
	public boolean removerProduto(String nome, String descricao) {
		boolean resultado = false;
		ProdutoId produto = new ProdutoId(nome, descricao);
		for (ProdutoId chave: this.produtos.keySet()) {
			if (produto.equals(chave)) {
				this.produtos.remove(chave);
				return true;
			}
		}
		return resultado;
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
	/**
	 * Retorna preço de um produto
	 * @param produto
	 * @return
	 */
	public double getPrecoProd(ProdutoId produtoA) {
		for (ProdutoId produtoB : produtos.keySet()) {
			if (produtoA.equals(produtoB)) {
				return this.produtos.get(produtoA).getPreco();
			}
		}
		throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
	/**
	 * Representação String de um fornecedor no sistema.
	 * @return retorna a representação do fornecedor no formato " nome - email - telefone".
	 */
	@Override
	public String toString() {
		return nome + " - " + email + " - " + telefone;
	}
	
	/**
	 * Adiciona uma compra no sistema.
	 * @param cliente o cliente que efetuou a compra.
	 * @param data a data da commpra.
	 * @param nome_prod o nome do produto comprado.
	 * @param desc_prod a descrição do produto.
	 * @param preco o preço do produto
	 * @return retorna se a compra ocorreu com sucesso.
	 */
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
	/**
	 * Exibe as contas do Cliente.
	 * @param cliente o cliente.
	 * @return retorna a representação String da conta desejada.
	 */
	public String exibeContas(Cliente cliente) {
		if (contas.containsKey(cliente)) {
			return this.contas.get(cliente).exibeContas();
		}
		throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
	}
	/**
	 * Verifica se um produto está cadastrado
	 * @param cliente
	 * @return boolean true ou false
	 */
	public boolean contemConta(Cliente cliente) {
		if (contas.containsKey(cliente)) {
			return true;
		}
		return false;
	}
	@Override
	public int compareTo(Fornecedor o) {
		return this.nome.compareTo(o.getNome());
	}
	public Collection<Produto> getProdutos() {
		// TODO Auto-generated method stub
		return this.produtos.values();
	}
	
	

	

}