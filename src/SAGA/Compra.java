package SAGA;

public class Compra {

	private String data;
	private String nome_prod;
	private String desc_prod;
	private double preco;

	public Compra(String data, String nome_prod, String desc_prod, double preco) {
		this.data = data;
		this.nome_prod = nome_prod;
		this.desc_prod = desc_prod;
		this.preco = preco;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNome_prod() {
		return nome_prod;
	}

	public void setNome_prod(String nome_prod) {
		this.nome_prod = nome_prod;
	}

	public String getDesc_prod() {
		return desc_prod;
	}

	public void setDesc_prod(String desc_prod) {
		this.desc_prod = desc_prod;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {		
		return nome_prod +" - "+data.replaceAll("/", "-");
	}

}
