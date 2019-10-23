package SAGA;
/**
 * Representação de um produto combo no sistema. Cada produto possui nome, descrição, preço e tipo
 * @author Thiago Lira.
 *
 */
public class ProdutoCombo implements Produto{
	/**
	 * Nome do produto
	 */
	private String nome;
	/**
	 * descrição de um produto
	 */
	private String descricao;
	/**
	 * Produtos que o combo é formado
	 */
	private String produtos;
	/**
	 * preço do produto 1
	 */
	private double precoProd1;
	/**
	 * preco do produto 2
	 */
	private double precoProd2;
	/**
	 * Fator de desconto
	 */
	private double fator;
	/**
	 * Tipo de produto
	 */
	private String tipo;
	/**
	 * Constrói um combo
	 * @param nome
	 * @param descricao
	 * @param fator
	 * @param produtos
	 * @param precoprod1
	 * @param precoprod2
	 */
	public ProdutoCombo(String nome, String descricao, double fator, String produtos, double precoprod1, double precoprod2) {
		this.nome = nome;
		this.descricao = descricao;
		this.produtos = produtos;
		this.precoProd1 = precoprod1;
		this.precoProd2 = precoprod2;
		this.fator = fator;
		this.tipo = "Combo";
	}
	/**
	 * Constrói um combo a partir do nome e descrição
	 * @param nome
	 * @param descricao
	 */
	public ProdutoCombo(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getProdutos() {
		return produtos;
	}
	
	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public String getIdentificador() {
		return this.nome+ " - "+ this.descricao;
	}

	public double getPreco() {
		return (precoProd1+precoProd2)*(1-fator);
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	@Override
	public void setPreco(double novoValor) {
		this.fator = novoValor;
		
	}
	
	/**
	 * Representação textual de um produto
	 */
	@Override
	public String toString() {
		return nome + " - " + descricao + " - R$" +String.format("%.2f", getPreco());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		ProdutoCombo other = (ProdutoCombo) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public int compareTo(Produto outroProduto) {
		return this.nome.compareTo(outroProduto.getNome());
	}

}
