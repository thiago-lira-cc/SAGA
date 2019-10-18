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
	private Map<ProdutoId, ProdutoSimples> produtosSimples;
	
	private Map<ProdutoId, ProdutoCombo> produtoCombo;
	
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
		this.produtosSimples = new HashMap<ProdutoId, ProdutoSimples>();
		this.produtoCombo = new HashMap<ProdutoId, ProdutoCombo>();
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
			this.produtosSimples.put(id, produto);
			return true;
		}else {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		
	}
	public boolean adicionaCombo(String nome, String descricao, double fator, String produtos) {
		if (!contemCombo(nome, descricao)) {
			String[] produtosSep = produtos.split(", ");
			String[] propduto1 = produtosSep[0].split(" - ");
			ProdutoId id1 = new ProdutoId(propduto1[0], propduto1[1]);
			
			String[] propduto2 = produtosSep[1].split(" - ");
			ProdutoId id2 = new ProdutoId(propduto2[0], propduto2[1]);
			if (produtosSimples.containsKey(id1) && produtosSimples.containsKey(id2)) {
				double precoprod1 = produtosSimples.get(id1).getPreco();
				double precoprod2 = produtosSimples.get(id2).getPreco();
				
				ProdutoCombo combo = new ProdutoCombo(nome, descricao, fator, produtos, precoprod1, precoprod2);
				ProdutoId id = new ProdutoId(nome, descricao);
				this.produtoCombo.put(id, combo);
				return true;
			}
			if (produtoCombo.containsKey(id1) || produtoCombo.containsKey(id2)) {
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
		if (this.produtosSimples.containsKey(id)) {
			return true;
		}
		return false;
	}
	
	public boolean contemCombo(String nome, String descricao) {
		ProdutoId id = new ProdutoId(nome, descricao);
		if (this.produtoCombo.containsKey(id)) {
			return true;
		}
		return false;
	}

	public String exibeProduto(String nome, String descricao) {
		ProdutoId id = new ProdutoId(nome, descricao);
		if (produtosSimples.containsKey(id)) {
			return produtosSimples.get(id).toString();
		}else if (produtoCombo.containsKey(id)) {
			return produtoCombo.get(id).toString();
		}
		throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
	}
	/**
	 * Retorna a lista dos produtos cadastrados no sistema.
	 * @return retorna as representações String dos produtos, em lista.
	 */
	public String retornaProdutosFornecedor() {
		String resultado = "";
		
		List<ProdutoSimples> listaProdutosSimples = new ArrayList<>();
		listaProdutosSimples.addAll(this.produtosSimples.values());
		List<ProdutoCombo> listaProdutosCombo = new ArrayList<>();
		listaProdutosCombo.addAll(this.produtoCombo.values());
		
		List listaProdutos = new ArrayList<>();
		listaProdutos.addAll(listaProdutosSimples);
		listaProdutos.addAll(listaProdutosCombo);
		
		
		if (listaProdutos.size() != 0) {
			Collections.sort(listaProdutos);
			
			for (ProdutoSimples produtoSimples : listaProdutos) {
				resultado += this.nome +" - "+ produtoSimples.toString() + " | ";
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
	public boolean editarProduto(ProdutoSimples produtoA, double novoPreco) {
		boolean resultado = false;
		for (ProdutoId chaveProdutoB: produtosSimples.keySet()) {
			if (produtosSimples.get(chaveProdutoB).equals(produtoA)) {
				this.produtosSimples.get(chaveProdutoB).setPreco(novoPreco);
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
	public boolean removerProduto(ProdutoSimples produtoB) {
		boolean resultado = false;
		List<ProdutoId> chaves = new ArrayList<ProdutoId>(this.produtosSimples.keySet());
		for (int i = 0; i < chaves.size(); i++) {
			if (produtosSimples.get(chaves.get(i)).equals(produtoB)) {
				produtosSimples.remove(chaves.get(i));
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
	public double getPrecoProd(ProdutoSimples produtoA) {
		for (ProdutoSimples produtoB : produtosSimples.values()) {
			if (produtoA.equals(produtoB)) {
				return produtoB.getPreco();
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
	public Collection<? extends ProdutoSimples> getProdutos() {
		// TODO Auto-generated method stub
		return this.produtosSimples.values();
	}
	
	

	

}