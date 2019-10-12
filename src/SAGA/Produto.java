package SAGA;

public class Produto implements Interface{

	private String nome;
	private String descricao;
	private double preco;
	
	public Produto(String nome, String descricao, double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Produto(String nomeProduto, String descricaoProduto) {
		this.nome = nomeProduto;
		this.descricao = descricaoProduto;
	}
	
	@Override
	public String toString() {
		return nome + " - " + descricao + " - R$" +String.format("%.2f", preco);
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
		Produto other = (Produto) obj;
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

	public String getNomeEDescricao() {
		return nome+" - "+descricao;
	}
	
	public void setPreco(double novoPreco) {
		this.preco = novoPreco;
	}
	

	@Override
	public int compareTo(Interface o) {
		return this.getIdentificador().compareTo(o.getIdentificador());
	}

	@Override
	public String getIdentificador() {
		return this.nome+ " - "+ this.descricao;
	}
	
}
