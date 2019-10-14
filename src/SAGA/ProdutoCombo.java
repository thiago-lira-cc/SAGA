package SAGA;

public class ProdutoCombo implements InterfaceProdutos{

	private String nome;
	private String descricao;
	private double preco;
	private String tipo;

	public ProdutoCombo(String nomeCombo, String descricaoCombo, double fator, InterfaceProdutos interfaceProdutos, InterfaceProdutos interfaceProdutos2) {
		this.nome = nomeCombo;
		this.descricao = descricaoCombo;
		this.preco = interfaceProdutos.getPreco()+interfaceProdutos2.getPreco()*fator;
		this.tipo = "Combo";
	}

	public ProdutoCombo(String nomeCombo, String descricaoCombo) {
		this.nome = nomeCombo;
		this.descricao = descricaoCombo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String getIdentificador() {
		return this.nome+ " - "+ this.descricao;
	}

	@Override
	public int compareTo(InterfaceProdutos o) {
		return this.getIdentificador().compareTo(o.getIdentificador());
	}

	@Override
	public String getTipo() {
		return this.tipo;
	}

}
