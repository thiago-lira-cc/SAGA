package SAGA;

public class ProdutoCombo implements InterfaceProdutos{

	private String nome;
	private String descricao;
	private double preco;
	private String tipo;
	/**
	 * Constroi um combo no sistema.
	 * @param nomeCombo o nome do combo
	 * @param descricaoCombo a descrição do combo.
	 * @param fator
	 * @param produtos os produtos do combo.
	 */
	public ProdutoCombo(String nomeCombo, String descricaoCombo, double fator, String produtos, InterfaceProdutos interfaceProdutos, InterfaceProdutos interfaceProdutos2) {
		this.nome = nomeCombo;
		this.descricao = descricaoCombo;
		this.preco = interfaceProdutos.getPreco()+interfaceProdutos2.getPreco()*fator;
		this.tipo = "Combo";
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
