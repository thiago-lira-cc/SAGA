package SAGA;

public class ProdutoCombo implements Comparable<ProdutoCombo>{

	private String nome;
	private String descricao;
	private String produtos;
	private double preco;

	public ProdutoCombo(String nome, String descricao, double fator, String produtos, double precoprod1, double precoprod2) {
		this.nome = nome;
		this.descricao = descricao;
		this.produtos = produtos;
		this.preco = (precoprod1+precoprod2)*(1-fator);
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getProdutos() {
		return produtos;
	}

	public double getPreco() {
		return preco;
	}
	
	public String getIdentificador() {
		return this.nome+ " - "+ this.descricao;
	}
	
	@Override
	public String toString() {
		return nome + " - " + descricao + " - R$" +String.format("%.2f", preco);
	}

	@Override
	public int compareTo(ProdutoCombo outroCombo) {
		// TODO Auto-generated method stub
		return this.getIdentificador().compareTo(outroCombo.getIdentificador());
	}
	
}
